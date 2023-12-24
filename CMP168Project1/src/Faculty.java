
public class Faculty extends Employee implements Comparable<Person>{
	// private member variables
	private Course[] coursesTaught;
	private int numCoursesTaught;
	private boolean isTenured;
	
	// default constructor
	public Faculty() {
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
		isTenured = false;
	}
	
	// overloaded constructors
	public Faculty(boolean isTenured) {
		this();
		this.isTenured = isTenured;
	}
	
	public Faculty(String deptName, boolean isTenured) {
		super(deptName);
		this.isTenured = isTenured;
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
	}
	
	public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		super(name, birthYear, deptName);
		this.isTenured = isTenured;
		coursesTaught = new Course[100];
		numCoursesTaught = 0;
	}
	
	// getters and setters
	public int getNumCoursesTaught() {
		return numCoursesTaught;
	}

	public boolean isTenured() {
		return isTenured;
	}

	public void setTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	
	// other methods
	public void addCourseTaught(Course course) {
		if (numCoursesTaught >= coursesTaught.length) {
			return;
		}
		else {
			coursesTaught[numCoursesTaught] = course;
			numCoursesTaught++;
		}
	}
	
	// same method but with array 
	// may need to check this method later
	public void addCoursesTaught(Course[] course) {
		if (numCoursesTaught < 100) {
			for (int i = 0; i < numCoursesTaught; i++) {
				coursesTaught[numCoursesTaught] = course[i];
				numCoursesTaught++;
			}
		}
		/* Course[] completeCoursesTaught = new Course[course.length + coursesTaught.length];
		
		for (int i = 0; i < coursesTaught.length; i++) {
			completeCoursesTaught[i] = coursesTaught[i];
		}
		
		// create a variable to represent the first index so the course array can be appended to the other array
		int j = 0;
		
		for (int i = coursesTaught.length; i < completeCoursesTaught.length; i++) {
			completeCoursesTaught[i] = course[j];
			j++;
		}
		
		// update references
		coursesTaught = completeCoursesTaught; */
	}
	
	public Course getCourseTaught(int index) {
		// invalid index check
		if (index < 0 || index >= numCoursesTaught || index >= coursesTaught.length || coursesTaught[index] == null) {
			return null;
		}
		
		return coursesTaught[index];
	}
	
	public String getCourseTaughtAsString(int index) {
		if (index < 0 || index >= numCoursesTaught || index >= coursesTaught.length || coursesTaught[index] == null) {
			return "";
		}
		
		return coursesTaught[index].getCourseDept() + "-" + coursesTaught[index].getCourseNum();
	}
	
	public String getAllCoursesTaughtAsString() {
		String allCourses = "";
		
		// create a for loop
		for (int i = 0; i < numCoursesTaught; i++) {
			// allCourses += getCourseTaughtAsString(i) + ", ";
			
			// don't add a comma at the end 
			if (i == numCoursesTaught) {
				allCourses = getCourseTaughtAsString(i);
			}
			// it will add commas until it reaches to the end
			else {
				allCourses += getCourseTaughtAsString(i) + ", ";
			}
		}
		
		return allCourses;
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
		
		if (obj instanceof Faculty) {
			Faculty f = (Faculty) obj;
			super.equals(f);
			
			// compare attributes of this class
			if (coursesTaught == f.coursesTaught) {
				if (numCoursesTaught == f.numCoursesTaught) {
					if (isTenured == f.isTenured) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		// Contents of Employee 
		String info = super.toString();
		
		// create if statements to print only Is Tenured or Not Tenured depending on the value of isTenured
		if (isTenured) {
			info += String.format(" Faculty: %11s ", "Is Tenured");
		}
		else if (!isTenured) {
			info += String.format(" Faculty: %11s ", "Not Tenured");
		}
		
		info += String.format("| Number of Courses Taught: %3d | Courses Taught: %s", numCoursesTaught, getAllCoursesTaughtAsString());
		// return super.toString() + String.format(" Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s", isTenured, numCoursesTaught, getAllCoursesTaughtAsString());
		return info;
	}
	
	@Override
	public int compareTo(Person p) {
		super.compareTo(p);
		
		if (p == null) {
			return 1;
		}
		
		// I decided to cast the peron object to a faculty object because it would be easier to compare numCoursesTaught and avoid errors
		Faculty fac = (Faculty) p;
		
		if (numCoursesTaught == fac.numCoursesTaught) {
			return 0;
		} 
		
		if (numCoursesTaught < fac.numCoursesTaught) {
			return -1;
		} 
		
		return 1;
	}

}
