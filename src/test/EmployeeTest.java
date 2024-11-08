


import org.junit.Test;

import classes.employees.Employee;

import static org.junit.Assert.*;

public class EmployeeTest {

    private static class TestEmployee extends Employee {
        public TestEmployee(int ID, String name) {
            super(ID, name);
        }

        @Override
        public double einkommen() {
            return 5000.0; // Fixed income for testing
        }
    }

    @Test
    public void testConstructor() {
        Employee employee = new TestEmployee(1, "John Doe");
        assertEquals(1, employee.getID());
        assertEquals("John Doe", employee.getName());
    }

    @Test
    public void testSetID() {
        Employee employee = new TestEmployee(1, "Jane Doe");
        employee.setID(2);
        assertEquals(2, employee.getID());
    }

    @Test
    public void testSetName() {
        Employee employee = new TestEmployee(1, "Alice");
        employee.setName("Bob");
        assertEquals("Bob", employee.getName());
    }

    @Test
    public void testGetIncome() {
        Employee employee = new TestEmployee(1, "Charlie");
        assertEquals(5000.0, employee.getIncome(), 0.001);
    }
}