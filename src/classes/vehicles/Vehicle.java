package classes.vehicles;
import classes.employees.Driver;

public abstract class Vehicle {
    private double tanksize;
    private double tankinhalt;
    private double speed;
    private int maxspeed;
    private Driver fahrer;
    private boolean motoran;
    private Position aktuelleposition;


    public Vehicle(double tanksize, int maxspeed, Position aktuelleposition){
        this.tanksize = tanksize;
        this.maxspeed = maxspeed;
    }
}
