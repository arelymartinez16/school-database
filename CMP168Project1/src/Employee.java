
public class Employee extends Person implements Comparable<Person> { // implements Comparable<Employee>{
	// private member variables
	private String deptName;
	private static int numEmployees;
	// this variable is going to be generated
	private int employeeID;
	
	// default constructor
	public Employee() {
		deptName = "";
		numEmployees++;
		employeeID = numEmployees;
	}
	
	// overloaded constructor with string as parameter
	public Employee(String deptName) {
		// call default constructor
		this();
		this.deptName = deptName;
		/* numEmployees++;
		employeeID = numEmployees; */
	}
	
	// overloaded constructor 
	public Employee(String name, int birthYear, String deptName) {
		super(name, birthYear);
		this.deptName = deptName;
		numEmployees++;
		employeeID = numEmployees;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public static int getNumEmployees() {
		return numEmployees;
	}

	public int getEmployeeID() {
		return employeeID;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if (this == o) {
			return true;
		}
		
		if (o instanceof Employee) {
			Employee e = (Employee) o;
			
			// compare attributes from this class and the Person 
			super.equals(e);
			
			if (deptName.equals(e.deptName)) {
				if (employeeID == e.employeeID) {
					// if (super.name.equals(e.name))
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		// Prints contents of the Person class and this class
		return super.toString() + String.format(" Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
	}  
	
	@Override
	public int compareTo(Person p) {
		super.compareTo(p);
		
		if (p == null) {
			return 1;
		}
		
		Employee e = (Employee) p;
		
		if (employeeID == e.employeeID) {
			return 0;
		}
		
		if (employeeID < e.employeeID) {
			return -1;
		}
		
		return 1;
	} 
}
