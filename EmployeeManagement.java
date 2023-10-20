import java.util.Scanner;
import java.util.ArrayList;


class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. List Employees");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    addEmployee(scanner, employees);
                    break;
                case 2:
                    updateEmployee(scanner, employees);
                    break;
                case 3:
                    deleteEmployee(scanner, employees);
                    break;
                case 4:
                    listEmployess(employees);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please selet a valid option.");
            }
        }
    }

    public static void addEmployee(Scanner scanner, ArrayList<Employee> employees){
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.println("Enter employee salary: ");
        double salary = scanner.nextDouble();

        int id = employees.size() + 1;
        Employee newEmployee = new Employee(id, name, salary);
        employees.add(newEmployee);
        System.out.println("Employee added successfully");
    }

    public static void updateEmployee(Scanner scanner, ArrayList<Employee> employees){
        System.out.println("Enter the employee ID to update: ");
        int idToUpdate = scanner.nextInt();
        Employee employeeToUpdate = findEmployeeById(employees, idToUpdate);
        if (employeeToUpdate != null){
            System.out.println("Enter new name: ");
            String newName = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Enter new salary");
            double newSalary = scanner.nextDouble();

            employeeToUpdate.setName(newName);
            employeeToUpdate.setSalary(newSalary);
            System.out.println("Employee updated successfully.");
        }else{
            System.out.println("Employee with ID " + idToUpdate + " not found");
        }
    }

    public static void deleteEmployee(Scanner scanner, ArrayList<Employee> employees){
        System.out.println("Enter the employee ID to delete: ");
        int idToDelete = scanner.nextInt();

        Employee employeeToDelete = findEmployeeById(employees, idToDelete);

        if (employeeToDelete != null){
            employees.remove(employeeToDelete);
            System.out.println("Employee deleted successfully.");
        }else{
            System.out.println("Employee with ID " + idToDelete + " not found.");
        }
    }

    public static void listEmployess(ArrayList<Employee> employees){
        System.out.println("\nEmployee List:");
        for (Employee employee: employees){
            System.out.println(employee);
        }
    }

    public static Employee findEmployeeById(ArrayList<Employee> employee, int idToSearch){
       for (Employee emp: employee){
           if (emp.getId() == idToSearch){
               return emp;
           }
       }
       return null;
    }
}
