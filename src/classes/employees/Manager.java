package classes.employees;

public class Manager extends OfficeEmployee {
    public static int counter = 0;
    private double bonusRate;

    public Manager(String name, double salary, double bonusRate) {
        super(name, salary);
        super.setId(counter + 5000);
        this.bonusRate = bonusRate;
        counter++;
    }

    public double calculateBonus() {
        return super.getIncome() * (bonusRate / 100.0);
    }

    @Override
    public double getIncome() {
        return super.getIncome() + calculateBonus();
    }
}