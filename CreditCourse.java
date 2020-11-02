/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class CreditCourse extends Course {

    private String semester;
    private double grade;
    private Boolean active;
    
    // add a constructor method with appropriate parameters
    // should call the super class constructor
    public CreditCourse(String name, String code, String descr, String fmt, String semester, double grade) {
        super(name, code, descr, fmt);
        this.semester = semester;
        this.grade = 0.0;
    }

    public double getGrade() {
        // add code and remove line below
        return grade;
    }
    
    public void setGrade(double score) {
        // add code and remove line below
        grade = score;
    }
    
    public boolean getActive() {
        // add code and remove line below
        return active;
    }

    public void setActive() {
        // add code
        this.active = true;
    }

    public void setInactive() {
        // add code
        this.active = false;
    }

    public String displayGrade() {
        // Change line below and print out info about this course plus which semester and the grade achieved
        // make use of inherited method in super class
        return super.getInfo() + " " + semester + " Grade " + CreditCourse.convertNumericGrade(grade);
    }
}
