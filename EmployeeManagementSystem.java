import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: ₹" + salary);
    }
}

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addEmployee(int id, String name, double salary) {
        employeeList.add(new Employee(id, name, salary));
    }

    public static void updateEmployee(int id, String newName, double newSalary) {
        for (Employee employee : employeeList) {
            if (employee.id == id) {
                employee.name = newName;
                employee.salary = newSalary;
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void removeEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.id == id) {
                employeeList.remove(employee);
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void searchEmployee(int id) {
        for (Employee employee : employeeList) {
            if (employee.id == id) {
                employee.displayDetails();
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            for (Employee employee : employeeList) {
                employee.displayDetails();
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    addEmployee(id, name, salary);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    updateEmployee(updateId, newName, newSalary);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    removeEmployee(removeId);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    searchEmployee(searchId);
                    break;

                case 5:
                    displayAllEmployees();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}