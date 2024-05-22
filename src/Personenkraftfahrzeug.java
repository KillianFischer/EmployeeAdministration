public class Personenkraftfahrzeug extends KFZ{
    private int anzahlsitze;
    private Mitarbeiter Mitfahrer;
    private int Auslastung;

    public Personenkraftfahrzeug(double tanksize, int maxspeed, Position aktuelleposition) {
        super(tanksize, maxspeed, aktuelleposition);
    }
}
