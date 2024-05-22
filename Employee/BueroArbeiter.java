class BueroArbeiter extends Mitarbeiter {
    public static int counter=0;
    private double festgehalt;

    public BueroArbeiter(String name, double festgehalt) {
        super(counter+5100, name);
        this.festgehalt = festgehalt;
        counter++;
    }

    @Override
    public double einkommen() {
        return festgehalt;
    }
}