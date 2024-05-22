class Manager extends BueroArbeiter {
    public static int counter=0;
    //private double festgehalt;
    private double bonusSatz;

    public Manager(String name, double festgehalt, double bonusSatz) {
        super(name,festgehalt);
        super.setID(counter+5000);
        //this.festgehalt = festgehalt;
        this.bonusSatz = bonusSatz;
        super.counter--;
        counter++;
    }

    public double berechneBonus() {
        return super.einkommen() * (bonusSatz / 100.0);
    }

    @Override
    public double einkommen() {
        return super.einkommen() + berechneBonus();
    }
}