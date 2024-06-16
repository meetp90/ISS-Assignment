// Abstract class for generic employee information
abstract class Employee {
	protected String name; // Protected for inheritance access control
	private int id; // Encapsulated with private access
	final String COMPANY_NAME = "Learn Inc."; // constant value

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public abstract String getDetails(); // Abstract method for details

	// Getter method for encapsulated id (if needed)
	public int getId() {
		return id;
	}
}

// Subclass for specific department (e.g., Sales)
class Sales extends Employee {
	private String department; // Specific to Sales department

	public Sales(String name, int id, String department) {
		super(name, id); // Call parent constructor
		this.department = department;
	}

	@Override
	public String getDetails() {
		return "Name: " + name + ", ID: " + getId() + ", Department: " + department;
	}
}

public class Assignment2 {

	public static void main(String[] args) {
		// Cannot create object of abstract class (commented out)
		// Employee emp = new Employee("John Doe", 123);

		// Create Sales department employee object
		Sales johnDoe = new Sales("John Doe", 123, "Sales");

	}
}
