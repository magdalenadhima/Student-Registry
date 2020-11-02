/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Active University Course
public class ActiveCourse extends Course {

    private ArrayList<Student> students;
    private String semester;

    // Add a constructor method with appropriate parameters
    // should call super class constructor to initialize inherited variables
    // make sure to *copy* students array list being passed in into new arraylist of students
    // see class Registry to see how an ActiveCourse object is created and used
    public ActiveCourse(String name, String code, String descr, String fmt, String semester, ArrayList<Student> students) {
        super(name, code, descr, fmt);
        ArrayList<Student> copyOfStudents = (ArrayList<Student>) students.clone();
        this.students = copyOfStudents;
        this.semester = semester;

    }

    public String getSemester() {
        return semester;
    }
    
    public void addStudent(Student s) {
        students.add(s);
    }
    
    public void removeStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(studentId)) {
                students.remove(students.get(i));
            }
        } 
    }

    // Prints the students in this course  (name and student id)
    public void printClassList() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    // Prints the grade of each student in this course (along with name and student id)
    // 
    public void printGrades(String courseCode) {
        // Search the student's list of credit courses to find the course code that matches this active course
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getId()  + " " + students.get(i).getName() 
                    + " " + getGrade(courseCode, students.get(i).getId()));
        }
    }
    
    // Returns the numeric grade in this course for this student
    // If student not found in course, return 0 
    public double getGrade(String courseCode, String studentId) {
        // Search the student's list of credit courses to find the course code that matches this active course
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(studentId)) {
                for (int j = 0; j < students.get(i).courses.size(); j++) {
                    if (students.get(i).courses.get(j).getCode().equalsIgnoreCase(courseCode)) {
                        // see class Student method getGrade() 
                        // return the grade stored in the credit course object
                        return students.get(i).courses.get(j).getGrade();
                    }
                }
            }
        }
        return 0.0; 
    }

    // Returns a String containing the course information as well as the semester and the number of students 
    // enrolled in the course
    // must override method in the superclass Course and use super class method getDescription()
    @Override
    public String getDescription() {
        return super.getDescription() + " " + semester + " Enrolment: " + students.size() + "\n";
    }

    // Sort the students in the course by name using the Collections.sort() method with appropriate arguments
    // Make use of a private Comparator class below
    public void sortByName() {
        Comparator<Student> byName = new NameComparator();
        Collections.sort(students, byName);
    }

    // Fill in the class so that this class implement the Comparator interface
    // This class is used to compare two Student objects based on student name
    private class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) 
        { 
            return a.getName().compareTo(b.getName()); 
        } 
    }

    // Sort the students in the course by student id using the Collections.sort() method with appropriate arguments
    // Make use of a private Comparator class below
    public void sortById() {
        Comparator<Student> byId = new IdComparator();
        Collections.sort(students, byId);
    }

    // Fill in the class so that this class implement the Comparator interface
    // This class is used to compare two Student objects based on student id
    private class IdComparator implements Comparator<Student>{
        @Override
        public int compare(Student a, Student b) 
        {
            return a.getId().compareTo(b.getId());
        }
    }
}
