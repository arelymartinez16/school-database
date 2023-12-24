
public class Course implements Comparable<Course>{
	// private member variables
	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;
	
	// only constructor in the class
	public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
		this.isGraduateCourse = isGraduateCourse;
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;
	}

	public boolean isGraduateCourse() {
		return isGraduateCourse;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public String getCourseDept() {
		return courseDept;
	}

	public int getNumCredits() {
		return numCredits;
	}

	public String getCourseName() {
		String courseName = "";
		
		// create if statements to illustrate cases if it is a graduate course or undergraduate
		// if it's one of those courses, I append it to the string that is going to be returned in the method
		if (!isGraduateCourse) {
			courseName = "U";
		}
		else if (isGraduateCourse) {
			courseName = "G";
		}
		
		// add the rest of info
		courseName += courseDept + courseNum;
		
		return courseName;
	}
	
	@Override
	public boolean equals(Object o) {
		// null check
		if (o == null) {
			return false;
		}
		
		if (this == o) {
			return true;
		}
		
		if (o instanceof Course) {
			Course course = (Course) o;
			
			// start comparing attributes
			// in order for two course objects to be equal, all attributes have to return true
			if (isGraduateCourse == course.isGraduateCourse) {
				if (courseNum == course.courseNum) {
					if (courseDept == course.courseDept) {
						if (numCredits == course.numCredits) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		// return String.format("Course: %3s-%3d | Number of Credits: %02d  | Graduate/Undergraduate", courseDept, courseNum, numCredits, isGraduateCourse);
		String courseInfo = String.format("Course: %3s-%3d | Number of Credits: %02d | ", courseDept, courseNum, numCredits);
		
		// depending on the type of course, one of those words will show
		if (isGraduateCourse) {
			// courseInfo.concat("Graduate");
			courseInfo += "Graduate";
		}
		else if (!isGraduateCourse) {
			// courseInfo.concat("Undergraduate");
			courseInfo += "Undergraduate";
		}
		
		return courseInfo;
		
	}
	
	// this method might contain errors
	@Override
	public int compareTo(Course c) {
		if (c == null) {
			return 1;
		}
		
		if (this.courseNum == c.courseNum) {
			return 0;
		}
		
		else if (this.courseNum < c.courseNum) {
			return -1;
		}
		
		return 1;
		
		
	}
}
