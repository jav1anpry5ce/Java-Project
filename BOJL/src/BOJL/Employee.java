// 20182855
package BOJL;

public class Employee {
    private final String empId;
    private final String categorization;

    public Employee(String id, String category) {
        this.empId = id;
        this.categorization = category;
    }

    @Override
    public String toString() {
        return "Employee Id: " + empId + "\n" + "Category: " + categorization;
    }
}
