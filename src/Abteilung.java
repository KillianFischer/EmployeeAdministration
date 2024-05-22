import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Abteilung {
    private  String name;
    private Mitarbeiter leiter;
    private List<Mitarbeiter> mitarbeiterList;
    public static List<Abteilung> allDepartments = new ArrayList<>();

    public Abteilung(String name, Mitarbeiter leiter) {
        this.name = name;
        this.mitarbeiterList = new ArrayList<>();
        this.leiter = leiter;
        mitarbeiterList.add(leiter);
        allDepartments.add(this);
    }

    public void addMitarbeiter(Mitarbeiter neuer) {
        mitarbeiterList.add(neuer);
    }

    public void removeMitarbeiter(Mitarbeiter welcher) {
        mitarbeiterList.remove(welcher);
    }

    public void changeLeiter(Mitarbeiter neuerManager) {
        this.leiter.setID(BueroArbeiter.counter+5100);
        this.removeMitarbeiter(this.leiter);
        BueroArbeiter newBueroArbeiter = new BueroArbeiter(leiter.getName(),leiter.einkommen());
        this.addMitarbeiter(leiter);
        this.leiter = neuerManager;
        this.addMitarbeiter(this.leiter);
    }

    public String gehaltsliste() {
        StringBuilder gehaltsliste = new StringBuilder("Gehaltsliste für Abteilung: " + name + "\n");
        DecimalFormat df = new DecimalFormat("#.##");

        double gesamtGehalt = 0;

        for (Mitarbeiter mitarbeiter : mitarbeiterList) {
            double gehalt = mitarbeiter.einkommen();
            gesamtGehalt += gehalt;
            gehaltsliste.append(mitarbeiter.getName()).append(" (ID: ").append(mitarbeiter.getID()).append("): ")
                    .append(df.format(gehalt)).append(" EUR\n");
        }

        gehaltsliste.append("Gesamtgehalt: ").append(df.format(gesamtGehalt)).append(" EUR");

        return gehaltsliste.toString();
    }

    public List<Mitarbeiter> getMitarbeiterList() {
        return mitarbeiterList;
    }
    public String getName(){return this.name;}
    public Mitarbeiter getLeiter(){return this.leiter;}
}