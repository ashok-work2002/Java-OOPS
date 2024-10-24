import java.util.Scanner;

public class PartTimeEmployee extends Employee {
    Scanner s = new Scanner(System.in);
    double hourlyWage;
    double hoursWorked;
    PartTimeEmployee(String name, String empId, int empType) {
        super(name, empId, empType);
        System.out.print("Enter hourly wage: ");
        hourlyWage = s.nextDouble();
        System.out.print("Enter hours worked: ");
        hoursWorked = s.nextDouble();
    }

    public double getSalary() {
        return (hoursWorked * hourlyWage);
    }

}
