package classes.employees;

public class Driver extends ShiftEmployee {
    private char licenseClass;

    public Driver(String name, double hourlyRate) {
        super(name, hourlyRate);
    }

    public char getLicenseClass() {
        return licenseClass;
    }

    public void setLicenseClass(char licenseClass) {
        this.licenseClass = licenseClass;
    }
}