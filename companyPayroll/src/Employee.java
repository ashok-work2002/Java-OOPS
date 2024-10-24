public abstract class Employee {
    String empName;
    String empId;
    int empType;
    Employee(String name, String id, int type) {
        empName = name;
        empId = id;
        empType = type;
    }

    abstract double getSalary();

    public static void displayEmpDetails(int numOfEmp, Employee[] empArray) {
        System.out.println("Employee salary Details: ");
        for (int i = 0; i < numOfEmp; i++) {
            System.out.println("Employee Name: " + empArray[i].empName + ", Employee ID: " + empArray[i].empId + ", Salary: " +  empArray[i].getSalary());
        }
    }

}
