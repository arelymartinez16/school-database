
public class Student extends Person implements Comparable<Person>{
	private static int numStudents;
	private int studentID;
	private Course[] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major = "undeclared";
	
	// constructors
	public Student() {
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		isGraduate = false;
		numStudents++;
		studentID = numStudents;
	}
	
	public Student(boolean isGraduate) {
		this();
		this.isGraduate = isGraduate;
		numStudents++;
		studentID = numStudents;
	}
	
	public Student(String major, boolean isGraduate) {
		this();
		this.major = major;
		this.isGraduate = isGraduate;
		/* numStudents++;
		studentID = numStudents; */
	}
	
	public Student(String name, int birthYear, String major, boolean isGraduate) {
		super(name, birthYear);
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		this.major = major;
		this.isGraduate = isGraduate;
		numStudents++;
		studentID = numStudents;
	}

	public static int getNumStudents() {
		return numStudents;
	}

	public int getStudentID() {
		return studentID;
	}

	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}

	public boolean isGraduate() {
		return isGraduate;
	}

	public String getMajor() {
		return major;
	}

	public void setGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public void addCourseTaken(Course course) {
		if (numCoursesTaken >= coursesTaken.length) {
			return;
		}
		else {
			coursesTaken[numCoursesTaken] = course;
			numCoursesTaken++;
		}
	} 
	
	public void addCoursesTaken(Course[] course) {
		if (numCoursesTaken < 50) {
			for (int i = 0; i < numCoursesTaken; i++) {
				coursesTaken[numCoursesTaken] = course[i];
				numCoursesTaken++;
			}
		}
	} 
	
	public Course getCourseTaken(int index) {
		// check if the index is invalid
		if (index < 0 || index >= numCoursesTaken || index >= coursesTaken.length || coursesTaken[index] == null) {
			return null;
		}
		
		return coursesTaken[index];
	}
	
	public String getCourseTakenAsString(int index) {
		// check if the index is invalid
		if (index < 0 || index >= numCoursesTaken || index >= coursesTaken.length || coursesTaken[index] == null) {
			return "";
		}
		
		return coursesTaken[index].getCourseDept() + "-" + coursesTaken[index].getCourseNum();
	}
	
	public String getAllCoursesTakenAsString() {
		String allCoursesTakenInfo = "";
		
		for (int i = 0; i < numCoursesTaken; i++) {
			// don't add a comma at the end of the string
			if (i == numCoursesTaken) {
				allCoursesTakenInfo = getCourseTakenAsString(i);
			}
			else {
				allCoursesTakenInfo += getCourseTakenAsString(i) + ", ";
			}
		}
		
		return allCoursesTakenInfo;
	}
	
	@Override
	public boolean equals(Object obj) {
		// null check
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		if (obj instanceof Student) {
			Student studt = (Student) obj;
			super.equals(studt);
			
			// compare attributes on this class
			if (studentID == studt.studentID) {
				if (numCoursesTaken == studt.numCoursesTaken) {
					if (coursesTaken == studt.coursesTaken) {
						if (isGraduate == studt.isGraduate) {
							if (major == studt.major) {
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String info = super.toString() + String.format(" Student: studentID: %04d | Major %20s |", studentID, major);
		
		// create if statements to indicate if the student is graduate or undergraduate
		if (isGraduate) {
			info += String.format(" %14s", "Graduate");
		}
		else if (!isGraduate) {
			info += String.format(" %14s", "Undergraduate");
		}
		
		info += String.format(" | Number of Courses Taken: %3d | Courses Taken: %s", numCoursesTaken, getAllCoursesTakenAsString());
		
		return info;
	}
	
	@Override
	public int compareTo(Person p) {  
		super.compareTo(p);
		
		if (p == null) {
			return 1;
		} 
		
		Student s = (Student) p;
		int numCredits = 0;
		int sNumberCredits = 0;
		
		// create for loops to find the number of credits for two objects
		for (int i = 0; i < numCoursesTaken; i++) {
			numCredits += coursesTaken[i].getNumCredits(); 
		}
		
		for (int i = 0; i < s.numCoursesTaken; i++) {
			sNumberCredits += s.coursesTaken[i].getNumCredits();
		}
		
		// now compare the number of credits
		if (numCredits == sNumberCredits) {
			return 0;
		}
		
		if (numCredits < sNumberCredits) {
			return -1;
		}
		
		return 1;
	}
}
