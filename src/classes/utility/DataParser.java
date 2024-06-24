//import classes.employees.Employee;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.util.List;
//
//public class DataParser {
//    private List<Employee> employees;
//
//    public void parseData(String data) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            Employee[] employeesArray = mapper.readValue(data, Employee[].class);
//            employees = List.of(employeesArray);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String convertToTargetFormat() {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            return mapper.writeValueAsString(employees);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//}
