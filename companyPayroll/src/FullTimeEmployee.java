import java.util.Scanner;

public class FullTimeEmployee extends Employee {
    Scanner s = new Scanner(System.in);
    double monthlySalary;

    FullTimeEmployee(String name, String empId, int empType) {

        super(name, empId, empType);
        System.out.print("Enter monthly salary: ");
        monthlySalary = s.nextDouble();
    }

    public double getSalary() {
        return (monthlySalary);
    }
}
