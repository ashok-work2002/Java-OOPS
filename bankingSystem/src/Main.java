import java.util.Scanner;

class BankTransaction extends Thread {
    BankAccount account;
    double amount;
    int transactionType;

    BankTransaction(BankAccount account, double amount, int transactionType) {
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public void run() {
        if(transactionType == 1) {
            account.deposit(amount);
        }
        else {
            account.withdraw(amount);
        }
    }
}

class BankAccount {
    double balance;
    BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Not sufficient balance");
        }
        else {
            balance -= amount;
        }
        System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount + "New Balance: $" + balance);
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposit: $" + amount + " New Balance: $" + balance);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        System.out.print("Enter the number of transactions to perform: ");
        int numOfTrans = s.nextInt();

        int[] transactionType = new int[numOfTrans];
        double[] amount = new double[numOfTrans];
        BankTransaction[] trans = new BankTransaction[numOfTrans];

        BankAccount account = new BankAccount(1000);

        for (int i = 0; i < numOfTrans; i++) {

            System.out.print("Enter transaction type (1 for Deposit, 2 for Withdrawal): ");
            transactionType[i] = s.nextInt();

            System.out.print("Enter amount: ");
            amount[i] = s.nextDouble();

            trans[i] = new BankTransaction(account, amount[i], transactionType[i]);
            trans[i].setName("User " + (i+1));
        }

        for (int i = 0; i < numOfTrans; i++) {
            trans[i].start();
            try{
                trans[i].join();
            }catch (Exception e) {
                System.out.println(e + "");
            }
        }

        System.out.println("Final Balance: " + account.balance);
    }
}

