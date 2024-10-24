import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        Employee[] empArray = new Employee[100];
        int numOfEmp = s.nextInt();

        for (int i = 0; i < numOfEmp; i++) {
            System.out.print("Enter the name of the employee: ");
            String name = s.next();
            System.out.print("Enter employee id: ");
            String empId = s.next();
            System.out.print("Enter employee type (1 for Full-Time, 2 for Part-Time):");
            int empType = s.nextInt();

            if(empType == 1) {
                empArray[i] = new FullTimeEmployee(name, empId, empType);

            }
            else {
                empArray[i] = new PartTimeEmployee(name, empId, empType);
            }

        }

        Employee.displayEmpDetails(numOfEmp, empArray);

    }
}