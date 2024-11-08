package classes.employees;

import java.util.Scanner;
import classes.utility.Department;

public class Main {

    private static void removeEmployeeByName(String name) {
        for (Department department : Department.allDepartments) {
            for (Employee employee : department.getEmployeeList()) {
                if (employee.getName().equals(name)) {
                    department.removeEmployee(employee);
                    System.out.println(name + " was removed.");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Department it = new Department("IT", new Manager("Janna", 10.0, 0.1));
        Department sales = new Department("Sales", new Manager("Soraka", 600, 0.15));
        Department procurement = new Department("Procurement", new Manager("Killian", 16.0, 0.25));

        ShiftEmployee shiftEmployee1 = new ShiftEmployee("Gwen", 15);
        shiftEmployee1.setHoursWorked(40);
        it.addEmployee(shiftEmployee1);

        OfficeEmployee officeEmployee1 = new OfficeEmployee("Jax", 4500);
        it.addEmployee(officeEmployee1);

        ShiftEmployee shiftEmployee2 = new ShiftEmployee("Akali", 20);
        shiftEmployee2.setHoursWorked(35);
        it.addEmployee(shiftEmployee2);

        // Example usage of removeEmployeeByName
        removeEmployeeByName("Gwen");

        // Adding new employees based on user input
        while (true) {
            System.out.print("Enter employee type (ShiftEmployee, OfficeEmployee, Manager) or 'exit' to quit: ");
            String employeeType = scanner.next();
            if ("exit".equalsIgnoreCase(employeeType)) {
                break;
            }

            System.out.print("Enter name: ");
            String nameToAdd = scanner.next();
            System.out.print("Enter department: ");
            String department = scanner.next();

            if ("ShiftEmployee".equalsIgnoreCase(employeeType) && (ShiftEmployee.counter + 3000) < 4000) {
                System.out.print("Hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                ShiftEmployee newShiftEmployee = new ShiftEmployee(nameToAdd, hourlyRate);
                System.out.print("Hours worked: ");
                int hoursWorked = scanner.nextInt();
                newShiftEmployee.setHoursWorked(hoursWorked);
                for (Department dept : Department.allDepartments) {
                    if (dept.getName().equalsIgnoreCase(department)) {
                        dept.addEmployee(newShiftEmployee);
                    }
                }
            } else if ("OfficeEmployee".equalsIgnoreCase(employeeType) && (OfficeEmployee.counter + 5100) < 6000) {
                System.out.print("Salary: ");
                double salary = scanner.nextDouble();
                OfficeEmployee newOfficeEmployee = new OfficeEmployee(nameToAdd, salary);
                for (Department dept : Department.allDepartments) {
                    if (dept.getName().equalsIgnoreCase(department)) {
                        dept.addEmployee(newOfficeEmployee);
                    }
                }
            } else if ("Manager".equalsIgnoreCase(employeeType) && (Manager.counter + 5000) < 5100) {
                System.out.print("Salary: ");
                double salary = scanner.nextDouble();
                System.out.print("Bonus rate: ");
                double bonusRate = scanner.nextDouble();
                Manager newManager = new Manager(nameToAdd, salary, bonusRate);
                for (Department dept : Department.allDepartments) {
                    if (dept.getName().equalsIgnoreCase(department)) {
                        dept.changeManager(newManager);
                    }
                }
            } else {
                System.out.println("Invalid employee type or ID range exceeded.");
            }
        }

        scanner.close();
    }
}