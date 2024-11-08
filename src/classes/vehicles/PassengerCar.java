package classes.vehicles;


import classes.employees.Employee;

public class PassengerCar extends VehicleTest {
    private int anzahlsitze;
    private Employee employee;
    private int Auslastung;

    public PassengerCar(double tanksize, int maxspeed, PositionTest aktuelleposition) {
        super(tanksize, maxspeed, aktuelleposition);
    }
}
