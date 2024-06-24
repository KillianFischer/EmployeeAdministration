package classes.vehicles;


import classes.employees.Employee;

public class PassengerCar extends Vehicle {
    private int anzahlsitze;
    private Employee employee;
    private int Auslastung;

    public PassengerCar(double tanksize, int maxspeed, Position aktuelleposition) {
        super(tanksize, maxspeed, aktuelleposition);
    }
}
