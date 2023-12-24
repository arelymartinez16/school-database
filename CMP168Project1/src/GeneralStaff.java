
public class GeneralStaff extends Employee {
	// private member variable
	private String duty;
	
	// constructors
	public GeneralStaff() {
		duty = "";
	}
	
	public GeneralStaff(String duty) {
		this.duty = duty;
	}
	
	public GeneralStaff(String deptName, String duty) {
		super(deptName);
		this.duty = duty;
	}
	
	public GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name, birthYear, deptName);
		this.duty = duty;
	}

	public String getDuty() {
		return duty;
	}
	
	@Override
	public boolean equals(Object obj) {
		// null check
		if (obj == null) {
			return false;
		}
		
		// check if they are the same object
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof GeneralStaff) {
			GeneralStaff gs = (GeneralStaff) obj;
			// compare attributes now
			super.equals(gs);
			
			if (duty.equals(gs.duty)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" GeneralStaff: Duty: %10s", duty);
	}
}
