package classes.employees;

public abstract class Employee {
    private int ID;
    private String name;

    public Employee(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }
    public void setID(int id) {
        this.ID=id;
    }

    public String getName() {
        return name;
    }

    public abstract double einkommen();

    public void setName(String name) {
        this.name = name;
    }
}