package classes.employees;

public class OfficeEmployee extends Employee {
    public static int counter=0;
    private double festgehalt;

    public OfficeEmployee(String name, double festgehalt) {
        super(counter+5100, name);
        this.festgehalt = festgehalt;
        counter++;
    }

    @Override
    public double einkommen() {
        return festgehalt;
    }
}