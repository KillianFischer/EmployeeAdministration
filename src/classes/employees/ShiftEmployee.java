package classes.employees;

public class ShiftEmployee extends Employee {
    public static int counter = 0;
    private double hourlyRate;
    private int hoursWorked;

    public ShiftEmployee(String name, double hourlyRate) {
        super(counter + 3000, name);
        this.hourlyRate = hourlyRate;
        counter++;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getIncome() {
        return hourlyRate * hoursWorked;
    }
}