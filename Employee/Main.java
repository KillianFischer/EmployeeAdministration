import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    // remove an employee by name
    private static void removeEmployeeByName(String name) {
        for (Abteilung obj:Abteilung.allDepartments){
            for (Mitarbeiter mitarbeiter : obj.getMitarbeiterList()) {
                if (mitarbeiter.getName().equals(name)) {
                    obj.removeMitarbeiter(mitarbeiter);
                    System.out.println(name + " wurde entfernt.");
                    return;
                }
        }
    }
    }

    public static void main(String[] args) {
        // Erstellen von Abteilungen

        File filename = new File("CSV/employee.csv");

        Abteilung it = new Abteilung("IT", new Manager("Janna", 10.0, 0.1));
        Abteilung vertrieb = new Abteilung("Vertrieb", new Manager("Soraka", 600, 0.15));
        Abteilung einkauf = new Abteilung("Einkauf", new Manager("Killian", 16.0,0.25));
        
        // Hinzufügen von Mitarbeitern
        SchichtArbeiter schichtArbeiter1 = new SchichtArbeiter("Gwen", 15);
        schichtArbeiter1.setAnzahlStunden(40); // Set the number of hours worked
        it.addMitarbeiter(schichtArbeiter1);

        BueroArbeiter bueroArbeiter1 = new BueroArbeiter( "Jax", 4500);
        it.addMitarbeiter(bueroArbeiter1);

        SchichtArbeiter schichtArbeiter2 = new SchichtArbeiter( "Akali", 20);
        schichtArbeiter2.setAnzahlStunden(30); // Set the number of hours worked
        vertrieb.addMitarbeiter(schichtArbeiter2);

        BueroArbeiter bueroArbeiter2 = new BueroArbeiter("Jhin", 5500);
        vertrieb.addMitarbeiter(bueroArbeiter2);

        // Mitarbeiter hinzufügen und entfernen sowie Gehaltsliste anzeigen über die Konsole
        Scanner scanner = new Scanner(System.in);
        boolean continueManaging = true;

        while (continueManaging) {
            System.out.println("\nOptionen:");
            System.out.println("1. Mitarbeiter hinzufügen");
            System.out.println("2. Mitarbeiter entfernen");
            System.out.println("3. Gehaltsliste anzeigen");
            System.out.println("4. Beenden");
            System.out.print("Wählen Sie eine Option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                    case 1:
                    System.out.println("Geben Sie die Details des neuen Mitarbeiters ein:");
                    System.out.print("Name: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.print("Mitarbeiterart (Schichtarbeiter/BueroArbeiter/Manager): ");
                    String employeeType = scanner.nextLine();
                    for(Abteilung obj:Abteilung.allDepartments){
                        System.out.print(" | "+obj.getName()+" | ");
                    }
                    String department = scanner.nextLine().toLowerCase();
                
                    if ("Schichtarbeiter".equalsIgnoreCase(employeeType)&&(SchichtArbeiter.counter+3000)<5000) {
                        System.out.print("Stundenlohn: ");
                        double stundenSatz = scanner.nextDouble();
                        SchichtArbeiter newSchichtArbeiter = new SchichtArbeiter( nameToAdd, stundenSatz);
                        for(Abteilung abt:Abteilung.allDepartments){
                            if(abt.getName().toLowerCase().equals(department)){
                                abt.addMitarbeiter(newSchichtArbeiter);
                            }
                        }

                    } else if ("BueroArbeiter".equalsIgnoreCase(employeeType)&&(BueroArbeiter.counter+5100)<6000) {
                        System.out.print("Festgehalt: ");
                        double festgehalt = scanner.nextDouble();
                        BueroArbeiter newBueroArbeiter = new BueroArbeiter( nameToAdd, festgehalt);
                        for(Abteilung abt:Abteilung.allDepartments){
                            if(abt.getName().toLowerCase().equals(department)){
                                abt.addMitarbeiter(newBueroArbeiter);
                            }
                        }
                    } else if ("Manager".equalsIgnoreCase(employeeType)&&(Manager.counter+5000)<5100) {
                        System.out.print("Festgehalt: ");
                        double festgehalt = scanner.nextDouble();
                        System.out.print("Bonus-Satz: ");
                        double bonusSatz = scanner.nextDouble();
                        Manager newManager = new Manager(nameToAdd, festgehalt, bonusSatz);
                        for(Abteilung abt:Abteilung.allDepartments){
                            if(abt.getName().toLowerCase().equals(department)){
                                if(abt.getLeiter()!=null){
                                    abt.changeLeiter(newManager);
                                }else{
                                    abt.addMitarbeiter(newManager);
                                }
                            }
                        }
                    } else {
                        System.out.println("Ungültige Mitarbeiterart.");
                    }
                    break;
                case 2:
                    System.out.print("Geben Sie den Namen des Mitarbeiters zum Entfernen ein: ");
                    String nameToRemove = scanner.nextLine();
                    removeEmployeeByName(nameToRemove);
                    break;
                case 3:
                    // Gehaltsliste anzeigen
                    for(Abteilung abt:Abteilung.allDepartments){
                        System.out.println("Gehaltsliste "+abt.getName());
                        System.out.println(abt.gehaltsliste());
                        System.out.println();
                    }
                    break;
                case 4:
                    continueManaging = false;
                    break;
                default:
                    System.out.println("Ungültige Option");
            }
        }
    }
}