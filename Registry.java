/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Registry {

    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<ActiveCourse> courses = new ArrayList<ActiveCourse>();

    public Registry() {
        
        String name, studentID;

        // create a file object using the FileReader constructor 
        FileReader fr = null;
        
        try {
            
            // with the filename given by user 
            fr = new FileReader("students.txt");
            Scanner in = new Scanner(fr);
            
            // loop reading every line of the file until the line is empty
            while (in.hasNextLine()) {
                
                // Add some students
                // in A2 we will read from a file
                name = in.next();
                studentID = in.next();
                
                students.add(new Student(name, studentID));
            }
            // sort the students alphabetically - see class Student
              
        //Catch exception if any error
        } catch (IOException e) {
            System.err.println("Error: unable to read file");
        } catch (NumberFormatException e) {
            System.err.println("Error: wrong type found in file");
        } catch (NoSuchElementException e) {
            System.err.println("Error: incorect formatting of file");
            System.err.println("Make sure file is made up of student names followed by their id");
        // execute finally clause if no exception catch
        } finally {
            try {
                // close file
                fr.close();
            // 
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (NullPointerException e) {
                System.err.println("Error: no file name entered");
            }
        }
        // sort the students alphabetically - see class Student
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student a, Student b) {
                return a.getName().compareTo(b.getName());
            }
        });
        
        //Catch exception if any error
        //Catch exception if any error
        
        // Add some students
        // in A2 we will read from a file
//        Student s1 = new Student("JohnOliver", "34562");
//        Student s2 = new Student("HarryWindsor", "38467");
//        Student s3 = new Student("SophieBrown", "98345");
//        Student s4 = new Student("FaisalQuereshi", "57643");
//        Student s5 = new Student("GenghisKhan", "25347");
//        Student s6 = new Student("SherryTu", "46532");
//        students.add(s1);
//        students.add(s2);
//        students.add(s3);
//        students.add(s4);
//        students.add(s5);
//        students.add(s6);
        // sort the students alphabetically - see class Student
        
        ArrayList<Student> list = new ArrayList<Student>();
        String courseName, courseCode, descr, format;
        
        Boolean start = true;
        int num_of_students = 0;
        Student student = null;

        // create a file object using the FileReader constructor 
        fr = null;
        
        try {
            
            // with the filename given by user 
            fr = new FileReader("courses.txt");
            Scanner in = new Scanner(fr);

            // loop reading every line of the file until the line is empty
            while (in.hasNextLine()) {
                
                if (start) {
                    num_of_students = in.nextInt();
                    start = false;
                    
                } else {
                    in.nextLine();
                    courseName = in.nextLine();
                    courseCode = in.nextLine();
                    descr = in.nextLine();
                    format = in.nextLine();
                    
                    for (int i = 0; i < num_of_students; i++) {
                        // get the student's number in the file,
                        // get student from ArrayList students by using its index i
                        student = students.get(in.nextInt()-1);
                        student.addCourse(courseName, courseCode, descr, format, "W2020", 0);
                        // add to list
                        list.add(student);
                    }
                    courses.add(new ActiveCourse(courseName, courseCode, descr, format, "W2020", list));
                    for (int i = 0; i < num_of_students; i++) {
                        list.get(i).addCourse(courseName, courseCode, descr, format, "W2020", 0);
                    }
                    start = true;
                    list.clear();
                }
            }
              
        //Catch exception if any error
        } catch (IOException e) {
            System.err.println("Error: unable to read file");
        } catch (NumberFormatException e) {
            System.err.println("Error: wrong type found in file");
        } catch (NoSuchElementException e) {
            System.err.println("Error: incorect formatting of file");
            System.err.println("Make sure file is made up of student names followed by their id");
        // execute finally clause if no exception catch
        } finally {
            try {
                // close file
                fr.close();
            // 
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (NullPointerException e) {
                System.err.println("Error: no file name entered");
            }
        }
        
//
//        ArrayList<Student> list = new ArrayList<Student>();
//
//        // Add some active courses with students
//        String courseName = "Computer Science II";
//        String courseCode = "CPS209";
//        String descr = "Learn how to write complex programs!";
//        String format = "3Lec 2Lab";
//        list.add(s2);
//        list.add(s3);
//        list.add(s4);
//        courses.add(new ActiveCourse(courseName, courseCode, descr, format, "W2020", list));
//        // Add course to student list of courses
//        s2.addCourse(courseName, courseCode, descr, format, "W2020", 0);
//        s3.addCourse(courseName, courseCode, descr, format, "W2020", 0);
//        s4.addCourse(courseName, courseCode, descr, format, "W2020", 0);
//
//        // CPS511
//        list.clear();
//        courseName = "Computer Graphics";
//        courseCode = "CPS511";
//        descr = "Learn how to write cool graphics programs";
//        format = "3Lec";
//        list.add(s1);
//        list.add(s5);
//        list.add(s6);
//        courses.add(new ActiveCourse(courseName, courseCode, descr, format, "F2020", list));
//        s1.addCourse(courseName, courseCode, descr, format, "W2020", 0);
//        s5.addCourse(courseName, courseCode, descr, format, "W2020", 0);
//        s6.addCourse(courseName, courseCode, descr, format, "W2020", 0);
//
//        // CPS643
//        list.clear();
//        courseName = "Virtual Reality";
//        courseCode = "CPS643";
//        descr = "Learn how to write extremely cool virtual reality programs";
//        format = "3Lec 2Lab";
//        list.add(s1);
//        list.add(s2);
//        list.add(s4);
//        list.add(s6);
//        courses.add(new ActiveCourse(courseName, courseCode, descr, format, "W2020", list));
//        s1.addCourse(courseName, courseCode, descr, format, "W2020", 0);
//        s2.addCourse(courseName, courseCode, descr, format, "W2020", 0);
//        s4.addCourse(courseName, courseCode, descr, format, "W2020", 0);
//        s6.addCourse(courseName, courseCode, descr, format, "W2020", 0);

    }

    // Add new student to the registry (students arraylist above) 
    public boolean addNewStudent(String name, String id) {
        // Create a new student object
        Object otherStudent = new Student(name, id);
        boolean registered = false;
        // check to ensure student is not already in registry
        for (int i = 0; i < students.size(); i++) {
            // make use of equals method in class Student
            // if in list
            if (students.get(i).equals(otherStudent)) {
                registered = true;
            } 
        }
        // if not, add them and return true, otherwise return false
        if (registered) {
            return false;
        } else {
            students.add((Student) otherStudent);
            return true;
        }
    }
    
    // Remove student from registry 
    public boolean removeStudent(String studentId) {
        // Find student in students arraylist
        for (int i = 0; i < students.size(); i++) {
            // If found, remove this student and return true
            if (students.get(i).getId().equalsIgnoreCase(studentId)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    // Print all registered students
    public void printAllStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

    }

    // Given a studentId and a course code, add student to the active course
    public void addCourse(String studentId, String courseCode) {
        // Find student object in registry (i.e. students arraylist)
        
        String courseName = null;
        String descr = null;
        String format = null;
        
	// Find student object in registry (i.e. students arraylist)
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(studentId)) {
                // then find the active course in courses array list using course code
                for (int j = 0; j < students.get(i).courses.size() ; j++) {
                    // Check if student has already taken this course in the past Hint: look at their credit course list
                    if (students.get(i).courses.get(j).getCode().equalsIgnoreCase(courseCode)) {
                        // If active course found 
                        if (!students.get(i).courses.get(j).getActive()) {
                            // then check to see if student already enrolled in this course
                            students.get(i).courses.get(j).setActive();
                        }
                    } else { // If not already taken
                        courseName = students.get(i).courses.get(j).getName();
                        descr = students.get(i).courses.get(j).getDescription();
                        format = students.get(i).courses.get(j).getFormat();

                        students.get(i).addCourse(courseName, courseCode, descr, format, "W2020", 0);
                    }
                } 
                // update courses array list in registry using course code
                for (int j = 0; j < courses.size(); j++) {
                    if (courses.get(j).getCode().equalsIgnoreCase(courseCode)) {
                        // add student to the active course
                        courses.get(j).addStudent(students.get(i));
                    }
                }
            }
        }
    }
        
    
    // Given a studentId and a course code, drop student from the active course
    public void dropCourse(String studentId, String courseCode) {
        
        // Find the active course
        for (int i = 0; i < students.size(); i++) {
            // Find the student in the list of students for this course
            // If student found:
            if (students.get(i).getId().equalsIgnoreCase(studentId)) {
                //   remove the student from the active course
                //   remove the credit course from the student's list of credit courses
                students.get(i).removeActiveCourse(courseCode);
            }
        }
        for (int i = 0; i < courses.size() ; i++) {
            if (courses.get(i).getCode().equalsIgnoreCase(courseCode)) {
                courses.get(i).removeStudent(studentId);
            }
        }
    }
       

    // Print all active courses
    public void printActiveCourses() {
        for (int i = 0; i < courses.size(); i++) {
            ActiveCourse ac = courses.get(i);
            System.out.println(ac.getDescription());
        }
    }

    // Print the list of students in an active course
    public void printClassList(String courseCode) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equalsIgnoreCase(courseCode)) {
                courses.get(i).printClassList();
            }
        }
    }

    // Given a course code, find course and sort class list by student name
    public void sortCourseByName(String courseCode) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equalsIgnoreCase(courseCode)) {
                courses.get(i).sortByName();
            }
        }
    }

    // Given a course code, find course and sort class list by student name
    public void sortCourseById(String courseCode) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equalsIgnoreCase(courseCode)) {
                courses.get(i).sortById();
            }
        }
    }

    // Given a course code, find course and print student names and grades
    public void printGrades(String courseCode) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equalsIgnoreCase(courseCode)) {
                courses.get(i).printGrades(courseCode);
            }
        }
    }

    // Given a studentId, print all active courses of student
    public void printStudentCourses(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(studentId)) {
                students.get(i).printActiveCourses();
            }
        }
    }

    // Given a studentId, print all completed courses and grades of student
    public void printStudentTranscript(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(studentId)) {
                students.get(i).printTranscript();
            }
        }
    }

    // Given a course code, student id and numeric grade
    // set the final grade of the student
    public void setFinalGrade(String courseCode, String studentId, double grade) {
        for (int i = 0; i < students.size(); i++) {
            // If found, find the student in class list
            if (students.get(i).getId().equalsIgnoreCase(studentId)) {
                // then search student credit course list in student object and find course
                for (int j = 0; j < students.get(i).courses.size(); j++) {
                    // find the active course
                    if (students.get(i).courses.get(j).getCode().equalsIgnoreCase(courseCode)) {
                        // set the grade in credit course and set credit course inactive
                        students.get(i).courses.get(j).setGrade(grade);
                        students.get(i).courses.get(j).setInactive();
                    }
                }
            }
        }
    }
}
