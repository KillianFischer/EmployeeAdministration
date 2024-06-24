package classes.utility;

import classes.employees.Employee;
import classes.employees.OfficeEmployee;
import classes.employees.ShiftEmployee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Abteilung {
    private  String name;
    private Employee leiter;
    private List<Employee> employeeList;
    public static List<Abteilung> allDepartments = new ArrayList<>();

    public Abteilung(String name, Employee leiter) {
        this.name = name;
        this.employeeList = new ArrayList<>();
        this.leiter = leiter;
        employeeList.add(leiter);
        allDepartments.add(this);
    }

    public void addEmployee(Employee neuer) {
        employeeList.add(neuer);
    }

    public void removeEmployee(Employee welcher) {
        employeeList.remove(welcher);
    }

    public void changeLeiter(Employee neuerManager) {
        this.leiter.setID(OfficeEmployee.counter+5100);
        this.removeEmployee(this.leiter);
        OfficeEmployee newOfficeEmployee = new OfficeEmployee(leiter.getName(),leiter.einkommen());
        this.addEmployee(leiter);
        this.leiter = neuerManager;
        this.addEmployee(this.leiter);
    }

    public String gehaltsliste() {
        StringBuilder gehaltsliste = new StringBuilder("Gehaltsliste für Abteilung: " + name + "\n");
        DecimalFormat df = new DecimalFormat("#.##");

        double gesamtGehalt = 0;

        for (Employee mitarbeiter : employeeList) {
            double gehalt = mitarbeiter.einkommen();
            gesamtGehalt += gehalt;
            gehaltsliste.append(mitarbeiter.getName()).append(" (ID: ").append(mitarbeiter.getID()).append("): ")
                    .append(df.format(gehalt)).append(" EUR\n");
        }

        gehaltsliste.append("Gesamtgehalt: ").append(df.format(gesamtGehalt)).append(" EUR");

        return gehaltsliste.toString();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    public String getName(){return this.name;}
    public Employee getLeiter(){return this.leiter;}
}