package classes.employees;

public class ShiftEmployee extends Employee {
    public static int counter=0;
    private double stundenSatz;
    private int anzahlStunden;

    public ShiftEmployee(String name, double stundenSatz) {
        super(counter+3000, name);
        this.stundenSatz = stundenSatz;
        counter++;
    }



    public double getStundenSatz() {
        return stundenSatz;
    }

    public void setStundenSatz(double stundenSatz) {
        this.stundenSatz = stundenSatz;
    }

    public int getAnzahlStunden() {
        return anzahlStunden;
    }

    public void setAnzahlStunden(int anzahlStunden) {
        this.anzahlStunden = anzahlStunden;
    }

    @Override
    public double einkommen() {
        return stundenSatz * anzahlStunden;
    }
}