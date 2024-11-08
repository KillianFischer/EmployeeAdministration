package classes.employees;

public class OfficeEmployee extends Employee {
    public static int counter = 0;
    private double salary;

    public OfficeEmployee(String name, double salary) {
        super(counter + 5100, name);
        this.salary = salary;
        counter++;
    }

    @Override
    public double getIncome() {
        return salary;
    }
}