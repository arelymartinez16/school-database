import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

// Video link: https://youtu.be/87bxxyPvkNY

// Note: I didn't implement all features of the menu and I only had free time today to record the video. I tried to discuss the features I made to the best of my ability with limited time
// I didn't implement these features: 1 pts) Add an array of 2 Courses to a Faculty object
// (1 pts) Add an array of 2 Courses to a Student object
// Allow the user to select a Faculty object and a Course object from menus and query the Faculty object for the Course to determine whether the Faculty object teaches it or not.
// Determine which Course is the minimum of all Course objects in the catalog.
// (1 pts) Determine which Course is the maximum of all Course objects in the catalog.
// Determine which Student has the most and least credits.



public class Driver_SchoolDB {
	
	public static int numCourses = 0;
	public static int numFaculty = 0;
	public static int numStudents = 0;
	public static int numGeneralStaff = 0;
	static Scanner scnr = new Scanner(System.in);
	public static Course[] courseObjInput = new Course[3];
	public static GeneralStaff[] gs = new GeneralStaff[3];
	public static Student[] s = new Student[3];
	public static Faculty[] fac = new Faculty[3];

	public static void main(String[] args) {
		Scanner inStream = null;
		String fileContent = "";
		String fileName = "SchoolDB_Initial.txt";
		
		File initialText = new File(fileName);
		
		// referred to the TextFileHandler (1) java file
		try {
			inStream = new Scanner(initialText);
			
			// now read the contents of the file
			while (inStream.hasNextLine()) {
				fileContent += inStream.nextLine() + "\n";
				// System.out.println(fileContent);
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println(fileName + " was not found " + e.getMessage());
		}
		finally {
			// close the inStream
			if (inStream != null) {
				inStream.close();
			}
		}
		
		// I put the print statement here so the content gets displayed correctly
		System.out.println(fileContent);
		
		// focus on 10 and beyond  
		// print database info
		System.out.println("**************************************************************");
		System.out.println("SCHOOL DATABASE INFO:");
		System.out.println();
		System.out.println("************************************************");
		System.out.println("COURSES:");
		// create Course objects in order to print info about them
		Course c0 = new Course(true, 771, "MAT", 4);
		System.out.println(c0.toString());
		Course c1 = new Course(true, 777, "CMP", 4);
		System.out.println(c1.toString());
		Course c2 = new Course(true, 711, "CMP", 4);
		System.out.println(c2.toString());
		Course c3 = new Course(true, 723, "MAT", 4);
		System.out.println(c3.toString());
		Course c4 = new Course(false, 168, "CMP", 4);
		System.out.println(c4.toString());
		Course c5 = new Course(false, 338, "CMP", 4);
		System.out.println(c5.toString());
		
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("PERSONS:");
		System.out.println("************************************************");
		System.out.println("************************************************");
		
		System.out.println("EMPLOYEES:");
		System.out.println("************************************************");
		System.out.println("************************************************");

		// I created the Faculty objects here because the expected output in zybooks had the employee ids mixed up with these objects and the GeneralStaff
		Faculty f1 = new Faculty();
		Faculty f2 = new Faculty(true);
		Faculty f3 = new Faculty("MAT", false);
		Faculty f4 = new Faculty("Superman", 1938, "PHY", true);
		
		System.out.println("GENERAL STAFF:");
		// create GeneralStaff objects and call the toString method
		GeneralStaff gs1 = new GeneralStaff();
		System.out.println(gs1.toString());
		GeneralStaff gs2 = new GeneralStaff("advise students");
		System.out.println(gs2.toString());
		GeneralStaff gs3 = new GeneralStaff("Sanitation", "clean");
		System.out.println(gs3.toString());
		GeneralStaff gs4 = new GeneralStaff("Flash Gordon", 1934, "Security", "safety");
		System.out.println(gs4.toString());
		System.out.println("************************************************");
		System.out.println("************************************************");
		
		// print Faculty objects 
		System.out.println("FACULTY:");
		
		System.out.println(f1.toString());
		
		System.out.println(f2.toString());
		
		System.out.println(f3.toString());
		
		System.out.println(f4.toString());
		System.out.println("************************************************");
		System.out.println("************************************************");
		
		// print Student objects
		System.out.println("STUDENTS:");
		Student s1 = new Student();
		System.out.println(s1.toString());
		Student s2 = new Student();
		System.out.println(s2.toString());
		Student s3 = new Student("Math", false);
		System.out.println(s3.toString());
		Student s4 = new Student("Wonderwoman", 1941, "JST", true);
		System.out.println(s4.toString());
		System.out.println("************************************************");
		// add more *******
		System.out.println("**************************************************************");
		System.out.println();
		
		// create menu now
		// openMenu();
	}
	
	// create a menu method
	public static void openMenu() {
		System.out.println("Welcome to the School's Database!");
		System.out.println("Enter a number.");
		System.out.println("1: Course");
		// System.out.println("2: Person");
		// System.out.println("3: Employees");
		System.out.println("2: General Staff");
		System.out.println("3: Student");
		System.out.println("4: Faculty");
		System.out.println("5: Print information");
		System.out.println("6: Exit Database");

		// more practice with exceptions
		try {
			while (scnr.hasNext()) {
				int choice = scnr.nextInt();
				
				// create a switch statement to print specific information based on their input
				switch(choice) {
					case 1:
						courses();
						break;
					case 2: 
						generalStaff();
						break;
					case 3:
						student();
						break;
					case 4:
						faculty();
						break;
					case 5: 
						updateInfo();
						break;
					case 6: 
						scnr.close();
						writeFile();
						System.exit(0);
						break;
				}
			}
			
		}
		catch (NoSuchElementException e) {
			System.out.println("Invalid input. Please try again.");
			scnr.next();
			openMenu();
		}
			
	}
	
	// create methods for each class
	public static void courses() {
		System.out.println("Welcome to the Course Section!");
		System.out.println("Enter a number:");
		System.out.println("1: Create a new course");
		System.out.println("2: Print information of this section");
		System.out.println("3: Exit this section");
		
		// Scanner scnr = new Scanner(System.in);
		int numInput = scnr.nextInt();
		
		switch(numInput) {
			/// create 3 new course objects from input
			case 1:
				System.out.println("Enter the number of course objects you want to make. You can only create a maximum of three course objects.");
				int objectsMake = scnr.nextInt();
				
				if (objectsMake < 0 || objectsMake > 3) {
					courses();
				}
				
				// create a for loop to iterate a specific amount of times to create objects
				for (int i = 0; i < objectsMake; i++) {
					System.out.println("Enter the information in the following order: isGraduateCourse, course number, course department, and number of credits");
					boolean isGraduate = scnr.nextBoolean();
					scnr.nextLine();
					int courseNum = scnr.nextInt();
					scnr.nextLine();
					String courseDept = scnr.nextLine();
					int numCredits = scnr.nextInt();
					scnr.nextLine();
				
					courseObjInput[i] = new Course(isGraduate, courseNum, courseDept, numCredits);
					
					numCourses++;
				}	courses();
				break;
			case 2:
				for (int i = 0; i < courseObjInput.length; i++) {
					if (courseObjInput[i] != null) {
						System.out.println(courseObjInput[i].toString());
					}
				}
				courses();
				break; 
			case 3:
				// this will return to the main menu
				openMenu();
				scnr.close();
				break;
		}
	}
	
	public static void generalStaff() {
		System.out.println("Welcome to the General Staff Section!");
		System.out.println("Enter a number:");
		System.out.println("1: Create a new General Staff");
		System.out.println("2: Print information of this section");
		System.out.println("3: Exit this section");
		
		int userInput = scnr.nextInt();
		
		switch(userInput) {
			// the code will be similar to the one in the course section
			case 1:
				System.out.println("Enter the number of General Staff objects you want to make. You can only create a maximum of three General Staff objects.");
				
				int objectsMade = scnr.nextInt();
				scnr.nextLine();
				// this will ensure that the user can create three objects
				if (objectsMade < 0 || objectsMade > 3) {
					generalStaff();
				}
				
				for (int i = 0; i < objectsMade; i++) {	
					// System.out.println("Enter the duty of the general staff.");
					System.out.println("Enter the information in the following order: name, birth year, department name, and duty.");
					String name = scnr.nextLine();
					int birthYear = scnr.nextInt();
					scnr.nextLine();
					String deptName = scnr.nextLine();
					String duty = scnr.nextLine();
					gs[i] = new GeneralStaff(name, birthYear, deptName, duty);
					numGeneralStaff++;
				}
				generalStaff();
				break;
			case 2:
				// print information
				for (int i = 0; i < gs.length; i++) {
					if (gs[i] != null) {
						System.out.println(gs[i].toString());
					}
				}
				generalStaff();
				break;
			case 3:
				openMenu();
				scnr.close();
				break;
		}
	}
	
	public static void student() {
		System.out.println("Welcome to the Student Section!");
		System.out.println("Enter a number:");
		System.out.println("1: Create a new Student object");
		System.out.println("2: Print information of this section");
		System.out.println("3: Add course to Student object");
		System.out.println("4: Get course from Student object");
		System.out.println("5: Get Student object with the most and the least credits");
		System.out.println("6: Exit this section");
		
		int userInpt = scnr.nextInt();
		
		switch(userInpt) {
			case 1:
				System.out.println("Enter the number of Student objects you want to make. You can only create a maximum of three Student objects.");
				int objectsMadeFromUser = scnr.nextInt();
				scnr.nextLine();
				
				if (objectsMadeFromUser < 0 || objectsMadeFromUser > 3) {
					student();
				}
				
				for (int i = 0; i < objectsMadeFromUser; i++) {	
					System.out.println("Enter the information in the following order: name, birth year, major, isGraduateStudent");
					String name = scnr.nextLine();
					int birthYear = scnr.nextInt();
					scnr.nextLine();
					String major = scnr.nextLine();
					boolean isGraduate = scnr.nextBoolean();
					scnr.nextLine();
					
					s[i] = new Student(name, birthYear, major, isGraduate);
					numStudents++;
				}
				student();
				break;
			case 2:
				// print information
				for (int i = 0; i < s.length; i++) {
					if (s[i] != null) {
						System.out.println(s[i].toString());
					}
				}
				student();
				break;
			// add course
			case 3:
				if (numCourses == 0) {
					System.out.println("You have to create a Course object before adding one to the Student object.");
					courses();
				}
				
				// and make sure the user created a Student object before proceeding
				if (numStudents == 0) {
					System.out.println("You have to create a Student object before proceeding.");
					student();
				}
				
				// print out the contents of the Course and Faculty array
				for (int i = 0; i < courseObjInput.length; i++) {
					if (courseObjInput[i] != null) {
						System.out.println(i + " " + courseObjInput[i].toString());
					}
				}
				
				for (int i = 0; i < s.length; i++) {
					if (s[i] != null) {
						System.out.println(i + " " + s[i].toString());
					}
				}
				
				// prompt the user which object they choose
				System.out.println("Select a Course object you want to add.");
				int courseObjSelected = scnr.nextInt();
				scnr.nextLine();
				
				System.out.println("Now select a Student object that you want to add the course to.");
				int studentObjSelected = scnr.nextInt();
				scnr.nextLine();
				
				Course courseSelected = null;
				
				for (int i = 0; i < courseObjInput.length; i++) {
					if (i == courseObjSelected) {
						courseSelected = courseObjInput[i];
					}
				}
				
				for (int i = 0; i < s.length; i++) {
					if (i == studentObjSelected) {
						s[i].addCourseTaken(courseSelected);
					}
				}
	
				student();
				break;
			case 4:
				// just like when adding the course, make sure that the user has already created a Course and Student object before starting
				if (numCourses == 0) {
					System.out.println("You have to create a Course object before proceeding.");
					courses();
				}
				
				if (numStudents == 0) {
					System.out.println("You have to create a Student object before proceeding.");
					student();
				}
				
				// print contents of Student objects
				for (int i = 0; i < s.length; i++) {
					if (s[i] != null) {
						System.out.println(i + " " + s[i].toString());
					}
				}
				
				// make the user select a Student object to later get a course in the object
				System.out.println("Select a Student object.");
				int studentSelected = scnr.nextInt();
				scnr.nextLine();
				
				// check if they wrote valid input
				if (studentSelected < 0 || studentSelected > 3) {
					System.out.println("Invalid input!");
					faculty();
				}
				
				// the object must have courses taken
				if (s[studentSelected].getAllCoursesTakenAsString() == "") {
					System.out.println("You didn't add the courses to this Student object. Please add the courses first.");
					student();
				}
				
				System.out.println("Courses taken by " + s[studentSelected].getName());
				System.out.println(s[studentSelected].getAllCoursesTakenAsString());
				
				// now make the user get course
				System.out.println("Select a course starting from zero.");
				int courseIndex = scnr.nextInt();
				scnr.nextLine();
				
				Course course = s[studentSelected].getCourseTaken(courseIndex);
				System.out.println(course);
				
				student();
				break;
			case 5:
				// first check if the user already made Course and Student objects
				if (numCourses == 0) {
					System.out.println("You have to create a Course object before proceeding.");
					courses();
				}
				
				if (numStudents == 0) {
					System.out.println("You have to create a Student object before proceeding.");
					student();
				}
				
				// check if the Student object has courses taken before processing
				for (int i = 0; i < s.length; i++) {
					if (s[i] != null) {
						if (s[i].getAllCoursesTakenAsString() == "") {
							System.out.println("You need to add a course in " + s[i] + ".");
							student();
						}
					}
				}
				
				Student studentMostCredits = null;
				Student studentLeastCredits = null;
				int maxCredits = Integer.MIN_VALUE;
				int minCredits = Integer.MAX_VALUE;
				
				// find the student object with the most credits
				for (int i = 0; i < s.length; i++) {
					if (s[i] != null) {
						// try to fix this part
						if (s[i].getCourseTaken(i).getNumCredits() > maxCredits) {
							studentMostCredits = s[i];
							maxCredits = s[i].getCourseTaken(i).getNumCredits();
						}
						
						if (s[i].getCourseTaken(i).getNumCredits() < minCredits) {
							studentLeastCredits = s[i];
							minCredits = s[i].getCourseTaken(i).getNumCredits();
						}
					}
				}
				
				System.out.println("Student with the most credits: " + studentMostCredits);
				System.out.println("Student with the least credits: " + studentLeastCredits);
				
				student();
				break;
			case 6:
				openMenu();
				scnr.close();
				break;
		}
	}
	
	public static void faculty() {
		System.out.println("Welcome to the Faculty Section!");
		System.out.println("Enter a number:");
		System.out.println("1: Create a new Faculty object");
		System.out.println("2: Print information of this section");
		System.out.println("3: Add course to Faculty object");
		System.out.println("4: Get course from Faculty object");
		System.out.println("5: Get Faculty object with the most and the least courses taught");
		System.out.println("6: Exit this section");
		
		int choice = scnr.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("Enter the number of Faculty objects you want to make. You can only make a maximum of three Faculty objects.");
				int objectsMade = scnr.nextInt();
				scnr.nextLine();
				
				if (objectsMade < 0 || objectsMade > 3) {
					faculty();
				}
				
				for (int i = 0; i < objectsMade; i++) {
					System.out.println("Enter the information in the following order: name, birth year, department name, and isTenured");
					String name = scnr.nextLine();
					int birthYear = scnr.nextInt();
					scnr.nextLine();
					String deptName = scnr.nextLine();
					boolean isTenured = scnr.nextBoolean();
					scnr.nextLine();
					fac[i] = new Faculty(name, birthYear, deptName, isTenured);
					numFaculty++;
				}
				faculty();
				break;
			case 2:
				// print information
				for (int i = 0; i < fac.length; i++) {
					if (fac[i] != null) {
						System.out.println(fac[i].toString());
					}
				}
				faculty();
				break;
			// add course
			case 3:
				// make sure that the user already created a course before adding them to the Faculty object
				if (numCourses == 0) {
					System.out.println("You have to create a Course object before adding one to the Faculty object.");
					courses();
				}
				
				// and make sure the user created a Faculty object before proceeding
				if (numFaculty == 0) {
					System.out.println("You have to create a Faculty object before proceeding.");
					faculty();
				}
				
				// print out the contents of the Course and Faculty array
				for (int i = 0; i < courseObjInput.length; i++) {
					if (courseObjInput[i] != null) {
						System.out.println(i + " " + courseObjInput[i].toString());
					}
				}
				
				for (int i = 0; i < fac.length; i++) {
					if (fac[i] != null) {
						System.out.println(i + " " + fac[i].toString());
					}
				}
				
				// prompt the user which object they choose
				System.out.println("Select a Course object you want to add.");
				int courseObjSelected = scnr.nextInt();
				scnr.nextLine();
				
				System.out.println("Now select a Faculty object that you want to add the course to.");
				int facultyObjSelected = scnr.nextInt();
				scnr.nextLine();
				
				Course courseSelected = null;
				
				for (int i = 0; i < courseObjInput.length; i++) {
					if (i == courseObjSelected) {
						courseSelected = courseObjInput[i];
					}
				}
				
				for (int i = 0; i < fac.length; i++) {
					if (i == facultyObjSelected) {
						fac[i].addCourseTaught(courseSelected);
					}
				}
				
				faculty();
				break;
			case 4:
				// just like when adding the course, make sure that the user has already created a Course and Faculty object before starting
				if (numCourses == 0) {
					System.out.println("You have to create a Course object before proceeding.");
					courses();
				}
				
				if (numFaculty == 0) {
					System.out.println("You have to create a Faculty object before proceeding.");
					faculty();
				}
				
				// print contents of Faculty objects
				for (int i = 0; i < fac.length; i++) {
					if (fac[i] != null) {
						System.out.println(i + " " + fac[i].toString());
					}
				}
				
				// make the user select a Faculty object to later get a course in the object
				System.out.println("Select a Faculty object.");
				int facultyOSelected = scnr.nextInt();
				scnr.nextLine();
				
				// check if they wrote valid input
				if (facultyOSelected < 0 || facultyOSelected > 3) {
					System.out.println("Invalid input!");
					faculty();
				}
				
				if (fac[facultyOSelected].getAllCoursesTaughtAsString() == "") {
					System.out.println("You didn't add the courses to this Faculty object. Please add the courses first.");
					faculty();
				}
				
				System.out.println("Courses taught by " + fac[facultyOSelected].getName());
				System.out.println(fac[facultyOSelected].getAllCoursesTaughtAsString());
				
				// now make the user get course
				System.out.println("Select a course starting from zero.");
				int courseIndex = scnr.nextInt();
				scnr.nextLine();
				
				Course course = fac[facultyOSelected].getCourseTaught(courseIndex);
				System.out.println(course);
				
				faculty();
				break;
			case 5:
				// first check if the user already made Course and Student objects
				if (numCourses == 0) {
					System.out.println("You have to create a Course object before proceeding.");
					courses();
				}
				
				if (numFaculty == 0) {
					System.out.println("You have to create a Faculty object before proceeding.");
					faculty();
				}
				
				// check if the Student object has courses taken before processing
				for (int i = 0; i < fac.length; i++) {
					if (fac[i] != null) {
						if (fac[i].getAllCoursesTaughtAsString() == "") {
							System.out.println("You need to add a course in " + fac[i] + ".");
							faculty();
						}
					}
				}
				
				Faculty facWMostCourses = null;
				Faculty facWLeastCourses = null;
				
				int minCoursesTaught = Integer.MAX_VALUE;
				int maxCoursesTaught = Integer.MIN_VALUE;
				
				for (int i = 0; i < fac.length; i++) {
					if (fac[i] != null) {
						if (fac[i].getNumCoursesTaught() < minCoursesTaught) {
							facWLeastCourses = fac[i];
							minCoursesTaught = fac[i].getNumCoursesTaught();
						}
						
						if (fac[i].getNumCoursesTaught() > maxCoursesTaught) {
							facWMostCourses = fac[i];
							maxCoursesTaught = fac[i].getNumCoursesTaught();
						}
					}
				}
				
				System.out.println("Faculty with the most number of courses taught is: " + facWMostCourses);
				System.out.println("Faculty with the least number of courses taught is: " + facWLeastCourses);
				
				faculty();
				break;
			case 6: 
				openMenu();
				scnr.close();
				break;
		}
	}
	
	// create a method to update the database with the objects the user made
	public static void updateInfo() {
		System.out.println("**************************************************************");
		System.out.println("SCHOOL DATABASE INFO:");
		System.out.println();
		System.out.println("************************************************");
		System.out.println("COURSES:");
		// create Course objects in order to print info about them
		Course c0 = new Course(true, 771, "MAT", 4);
		System.out.println(c0.toString());
		Course c1 = new Course(true, 777, "CMP", 4);
		System.out.println(c1.toString());
		Course c2 = new Course(true, 711, "CMP", 4);
		System.out.println(c2.toString());
		Course c3 = new Course(true, 723, "MAT", 4);
		System.out.println(c3.toString());
		Course c4 = new Course(false, 168, "CMP", 4);
		System.out.println(c4.toString());
		Course c5 = new Course(false, 338, "CMP", 4);
		System.out.println(c5.toString());
		// add the course objects the user created
		for (int i = 0; i < courseObjInput.length; i++) {
			if (courseObjInput[i] != null) {
				System.out.println(courseObjInput[i].toString());
			}
		}
		
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("PERSONS:");
		System.out.println("************************************************");
		System.out.println("************************************************");
		
		System.out.println("EMPLOYEES:");
		System.out.println("************************************************");
		System.out.println("************************************************");

		System.out.println("GENERAL STAFF:");
		// create GeneralStaff objects and call the toString method
		GeneralStaff gs1 = new GeneralStaff();
		System.out.println(gs1.toString());
		GeneralStaff gs2 = new GeneralStaff("advise students");
		System.out.println(gs2.toString());
		GeneralStaff gs3 = new GeneralStaff("Sanitation", "clean");
		System.out.println(gs3.toString());
		GeneralStaff gs4 = new GeneralStaff("Flash Gordon", 1934, "Security", "safety");
		System.out.println(gs4.toString());
		// add GeneralStaff objects that the user created
		for (int i = 0; i < gs.length; i++) {
			if (gs[i] != null) {
				System.out.println(gs[i].toString());
			}
		}
		System.out.println("************************************************");
		System.out.println("************************************************");
		
		// print Faculty objects 
		System.out.println("FACULTY:");
		Faculty f1 = new Faculty();
		System.out.println(f1.toString());
		Faculty f2 = new Faculty(true);
		System.out.println(f2.toString());
		Faculty f3 = new Faculty("MAT", false);
		System.out.println(f3.toString());
		Faculty f4 = new Faculty("Superman", 1938, "PHY", true);
		System.out.println(f4.toString());
		// print Faculty objects that the user made
		for (int i = 0; i < fac.length; i++) {
			if (fac[i] != null) {
				System.out.println(fac[i].toString());
			}
		}
		System.out.println("************************************************");
		System.out.println("************************************************");
		
		// print Student objects
		System.out.println("STUDENTS:");
		Student s1 = new Student();
		System.out.println(s1.toString());
		Student s2 = new Student();
		System.out.println(s2.toString());
		Student s3 = new Student("Math", false);
		System.out.println(s3.toString());
		Student s4 = new Student("Wonderwoman", 1941, "JST", true);
		System.out.println(s4.toString());
		// print Student objects that the user made
		for (int i = 0; i < s.length; i++) {
			if (s[i] != null) {
				System.out.println(s[i].toString());
			}
		}
		System.out.println("************************************************");
		System.out.println("**************************************************************");
		System.out.println();
		
		openMenu();
	}
	
	// write file method
	// from the shared drive fileIO TextFileHandler.java
	public static void writeFile() {
		PrintWriter outStream = null;
		String fileName = "SchoolDB_Updated.txt";
		
		try {
			outStream = new PrintWriter(fileName);
			
			// first write the objects I created from the initial file 
			Course c0 = new Course(true, 771, "MAT", 4);
			outStream.println("Course: " + c0.isGraduateCourse() + "," + c0.getCourseNum() + "," + c0.getCourseDept() + "," + c0.getNumCredits());
			Course c1 = new Course(true, 777, "CMP", 4);
			outStream.println("Course: " + c1.isGraduateCourse() + "," + c1.getCourseNum() + "," + c1.getCourseDept() + "," + c1.getNumCredits());
			Course c2 = new Course(true, 711, "CMP", 4);
			outStream.println("Course: " + c2.isGraduateCourse() + "," + c2.getCourseNum() + "," + c2.getCourseDept() + "," + c2.getNumCredits());
			Course c3 = new Course(true, 723, "MAT", 4);
			outStream.println("Course: " + c3.isGraduateCourse() + "," + c3.getCourseNum() + "," + c3.getCourseDept() + "," + c3.getNumCredits());
			Course c4 = new Course(false, 168, "CMP", 4);
			outStream.println("Course: " + c4.isGraduateCourse() + "," + c4.getCourseNum() + "," + c4.getCourseDept() + "," + c4.getNumCredits());
			Course c5 = new Course(false, 338, "CMP", 4);
			outStream.println("Course: " + c5.isGraduateCourse() + "," + c5.getCourseNum() + "," + c5.getCourseDept() + "," + c5.getNumCredits());
			
			GeneralStaff gs1 = new GeneralStaff();
			outStream.println("GeneralStaff: " + gs1.getName() + "," + gs1.getBirthYear() + "," + gs1.getDeptName() + "," + gs1.getDuty());
			GeneralStaff gs2 = new GeneralStaff("advise students");
			outStream.println("GeneralStaff: " + gs2.getName() + "," + gs2.getBirthYear() + "," + gs2.getDeptName() + "," + gs2.getDuty());
			GeneralStaff gs3 = new GeneralStaff("Sanitation", "clean");
			outStream.println("GeneralStaff: " + gs3.getName() + "," + gs3.getBirthYear() + "," + gs3.getDeptName() + "," + gs3.getDuty());
			GeneralStaff gs4 = new GeneralStaff("Flash Gordon", 1934, "Security", "safety");
			outStream.println("GeneralStaff: " + gs4.getName() + "," + gs4.getBirthYear() + "," + gs4.getDeptName() + "," + gs4.getDuty());
			
			Faculty f1 = new Faculty();
			outStream.println("Faculty: " + f1.getName() + "," + f1.getDeptName() + "," + f1.isTenured());
			Faculty f2 = new Faculty(true);
			outStream.println("Faculty: " + f2.getName() + "," + f2.getDeptName() + "," + f2.isTenured());
			Faculty f3 = new Faculty("MAT", false);
			outStream.println("Faculty: " + f3.getName() + "," + f3.getDeptName() + "," + f3.isTenured());
			Faculty f4 = new Faculty("Superman", 1938, "PHY", true);
			outStream.println("Faculty: " + f4.getName() + "," + f4.getDeptName() + "," + f4.isTenured());
			
			Student s1 = new Student();
			outStream.println("Student: " + s1.getName() + "," + s1.getBirthYear() + "," + s1.getMajor() + "," + s1.isGraduate());
			Student s2 = new Student();
			outStream.println("Student: " + s2.getName() + "," + s2.getBirthYear() + "," + s2.getMajor() + "," + s2.isGraduate());
			Student s3 = new Student("Math", false);
			outStream.println("Student: " + s3.getName() + "," + s3.getBirthYear() + "," + s3.getMajor() + "," + s3.isGraduate());
			Student s4 = new Student("Wonderwoman", 1941, "JST", true);
			outStream.println("Student: " + s4.getName() + "," + s4.getBirthYear() + "," + s4.getMajor() + "," + s4.isGraduate());
			
			for (int i = 0; i < fac.length; i++) {
				// this should remove the null pointer exception
				if (fac[i] != null) {
					outStream.println("Faculty: " + fac[i].getName() + "," + fac[i].getDeptName() + "," + fac[i].isTenured());
				}
			}
			
			outStream.println();
			
			for (int i = 0; i < s.length; i++) {
				if (s[i] != null) {
					outStream.println("Student: " + s[i].getName() + "," + s[i].getBirthYear() + "," + s[i].getMajor() + "," + s[i].isGraduate());
				}
			}
			
			outStream.println();
			
			for (int i = 0; i < gs.length; i++) {
				if (gs[i] != null) {
					outStream.println("GeneralStaff: " + gs[i].getName() + "," + gs[i].getBirthYear() + "," + gs[i].getDeptName() + "," + gs[i].getDuty());
				}
			}
			
			outStream.println();
			
			for (int i = 0; i < courseObjInput.length; i++) {
				if (courseObjInput[i] != null) {
					outStream.println("Course: " + courseObjInput[i].isGraduateCourse() + "," + courseObjInput[i].getCourseNum() + "," + courseObjInput[i].getCourseDept() + "," + courseObjInput[i].getNumCredits());
				}
			}
			
			outStream.println();
		}
		catch (FileNotFoundException e) {
			System.out.println("Problem creating new file " + fileName + " " + e.getMessage());
		}
		finally {
			if (outStream != null) {
				outStream.close();
			}
		}
	}
}
