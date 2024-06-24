import java.nio.file.*;
import java.util.*;

import classes.employees.*;
import classes.utility.*;

public class Main {

    private static void removeEmployeeByName(String name) {
        for (Abteilung obj: Abteilung.allDepartments){
            for (Employee employee : obj.getEmployeeList()) {
                if (employee.getName().equals(name)) {
                    obj.removeEmployee(employee);
                    System.out.println(name + " wurde entfernt.");
                    return;
                }
        }
    }
    }

    public static void main(String[] args) {

        Abteilung it = new Abteilung("IT", new Manager("Janna", 10.0, 0.1));
        Abteilung vertrieb = new Abteilung("Vertrieb", new Manager("Soraka", 600, 0.15));
        Abteilung einkauf = new Abteilung("Einkauf", new Manager("Killian", 16.0,0.25));

        ShiftEmployee shiftEmployee1 = new ShiftEmployee("Gwen", 15);
        shiftEmployee1.setAnzahlStunden(40);
        it.addEmployee(shiftEmployee1);

        OfficeEmployee officeEmployee1 = new OfficeEmployee( "Jax", 4500);
        it.addEmployee(officeEmployee1);

        ShiftEmployee shiftEmployee2 = new ShiftEmployee( "Akali", 20);
        shiftEmployee2.setAnzahlStunden(30); // Set the number of hours worked
        vertrieb.addEmployee(shiftEmployee2);

        OfficeEmployee officeEmployee2 = new OfficeEmployee("Jhin", 5500);
        vertrieb.addEmployee(officeEmployee2);

        // Interface for user interaction
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
            scanner.nextLine();

            switch (option) {
                    case 1:
                    System.out.println("Geben Sie die Details des neuen Mitarbeiters ein:");
                    System.out.print("Name: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.print("Mitarbeiterart (Schichtarbeiter/BueroArbeiter/Manager): ");
                    String employeeType = scanner.nextLine();
                    for(Abteilung obj: Abteilung.allDepartments){
                        System.out.print(" | "+obj.getName()+" | ");
                    }
                    String department = scanner.nextLine().toLowerCase();

                    if ("Schichtarbeiter".equalsIgnoreCase(employeeType)&&(ShiftEmployee.counter+3000)<5000) {
                        System.out.print("Stundenlohn: ");
                        double stundenSatz = scanner.nextDouble();
                        ShiftEmployee newShiftEmployee = new ShiftEmployee( nameToAdd, stundenSatz);
                        for(Abteilung abt: Abteilung.allDepartments){
                            if(abt.getName().toLowerCase().equals(department)){
                                abt.addEmployee(newShiftEmployee);
                            }
                        }

                    } else if ("BueroArbeiter".equalsIgnoreCase(employeeType)&&(OfficeEmployee.counter+5100)<6000) {
                        System.out.print("Festgehalt: ");
                        double festgehalt = scanner.nextDouble();
                        OfficeEmployee newOfficeEmployee = new OfficeEmployee( nameToAdd, festgehalt);
                        for(Abteilung abt: Abteilung.allDepartments){
                            if(abt.getName().toLowerCase().equals(department)){
                                abt.addEmployee(newOfficeEmployee);
                            }
                        }
                    } else if ("Manager".equalsIgnoreCase(employeeType)&&(Manager.counter+5000)<5100) {
                        System.out.print("Festgehalt: ");
                        double festgehalt = scanner.nextDouble();
                        System.out.print("Bonus-Satz: ");
                        double bonusSatz = scanner.nextDouble();
                        Manager newManager = new Manager(nameToAdd, festgehalt, bonusSatz);
                        for(Abteilung abt: Abteilung.allDepartments){
                            if(abt.getName().toLowerCase().equals(department)){
                                if(abt.getLeiter()!=null){
                                    abt.changeLeiter(newManager);
                                }else{
                                    abt.addEmployee(newManager);
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
                    for(Abteilung abt: Abteilung.allDepartments){
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