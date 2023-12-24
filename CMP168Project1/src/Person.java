
public class Person implements Comparable<Person> {
	// member variables
	private String name;
	private int birthYear;
	
	// default constructor
	public Person() {
		name = "";
		birthYear = 0;
	}
	
	// overloaded constructor
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Person) {
			Person p = (Person) obj;
			// compare attributes now
			if (name.equals(p.name)) {
				if (birthYear == p.birthYear) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override 
	public String toString() {
		return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
	}
	
	@Override 
	public int compareTo(Person p) {
		if (p == null) {
			return 1;
		}
		
		if (birthYear == p.birthYear) {
			return 0;
		}
		
		if (birthYear < p.birthYear) {
			return -1;
		}
		
		return 1;
	}
}
