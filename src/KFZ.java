public abstract class KFZ {
    private double tanksize;
    private double tankinhalt;
    private double speed;
    private int maxspeed;
    private Fahrer fahrer;
    private boolean motoran;
    private Position aktuelleposition;


    public KFZ (double tanksize, int maxspeed, Position aktuelleposition){
        this.tanksize = tanksize;
        this.maxspeed = maxspeed;
    }
}
