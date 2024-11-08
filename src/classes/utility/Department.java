package classes.utility;

import classes.employees.Employee;
import classes.employees.Manager;
import java.util.ArrayList;
import java.util.List;

public class Department {
    public static List<Department> allDepartments = new ArrayList<>();
    private String name;
    private Manager manager;
    private List<Employee> employeeList = new ArrayList<>();

    public Department(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
        allDepartments.add(this);
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public void changeManager(Manager newManager) {
        this.manager = newManager;
    }
}