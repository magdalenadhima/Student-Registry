/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentRegistrySimulator {

    public static void main(String[] args) {

        // initialize registry class type variable
        Registry registry = new Registry();

        // get user input with scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print(">");

        // get each line of scanner
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            // if line is empty
            if (inputLine == null || inputLine.equals("")) {
                continue;   // break
            }

            // pass line to scanner
            Scanner commandLine = new Scanner(inputLine);

            ArrayList<String> tokens = new ArrayList<>();
            while (commandLine.hasNext()) {
                tokens.add(commandLine.next());
            }

            String command = null;

            try {
                // get first group of characters to command
                command = tokens.get(0);
                tokens.remove(0);
            } catch (IndexOutOfBoundsException e) {
                command = null;
            }
            
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            for (int i = 0; i < tokens.size(); i++) {
                Matcher matcher = pattern.matcher(tokens.get(i));
                if (!matcher.matches()) {
                    command = null;
                    System.out.println("Invalid: No special characters");
                    break;
                }
            }

            // if command is empty
            if (command == null || command.equals("")) {
                System.out.print("\n>");
                continue;   // break

                // if command to list students
            } else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST")) {
                registry.printAllStudents();
                
            } else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT")) {
                return;

                // if command for student registration
            } else if (command.equalsIgnoreCase("REG") && tokens.size() == 2) {
                // register a new student in registry
                // get name and student id string in parameters
                // e.g. reg JohnBoy 74345
                String name = tokens.get(0);
                String studentId = tokens.get(1);
                
                boolean isName = isStringOnlyAlphabet(name);
                boolean isId = isNumeric(studentId);

                // Checks:
                //  ensure name is all alphabetic characters
                if (isName && isId) {
                    boolean registered = registry.addNewStudent(name, studentId);
                    if (!registered) {
                        System.out.println("Student " + name + " already registered");
                    }
                    
                } else {
                    if (!isName) {
                        System.out.println(" check student name");
                    } if (!isId) {
                        System.out.println(" check student id");
                    }
                }

                // if command for student deletion
            } else if (command.equalsIgnoreCase("DEL") && tokens.size() == 1) {
                // delete a student from registry
                // get student id
                String studentId = tokens.get(0);
                // ensure numeric
                boolean isId = isNumeric(studentId);
                // remove student from registry
                if (isId) {
                    boolean deleted = registry.removeStudent(studentId);
                    if (!deleted) {
                        System.out.println("Student can not be found");
                    }
                    
                } else {
                    System.out.println(" check student id");
                }

                // if command to add a student to an active course
            } else if (command.equalsIgnoreCase("ADDC") && tokens.size() == 2) {
                // get student id and course code strings
                String studentId = tokens.get(0);
                String courseCode = tokens.get(1);

                boolean isId = isNumeric(studentId);
                
                if (isId) {
                    // add a student to an active course
                    // add student to course (see class Registry)
                    registry.addCourse(studentId, courseCode);
                } else {
                    if (!isId) {
                        System.out.println(" check student id");
                    }
                }

                // if command to drop a student from an course
            } else if (command.equalsIgnoreCase("DROPC") && tokens.size() == 2) {
                // get student id and course code strings
                String studentId = tokens.get(0);
                String courseCode = tokens.get(1);

                boolean isId = isNumeric(studentId);
                
                if (isId) {
                    // drop student from course (see class Registry)
                    registry.dropCourse(studentId, courseCode);
                } else {
                    if (!isId) {
                        System.out.println(" check student id");
                    } 
                }

                // if command to print all active courses
            } else if (command.equalsIgnoreCase("PAC")) {
                // print all active courses
                registry.printActiveCourses();

                // if command to print a class list for a course
            } else if (command.equalsIgnoreCase("PCL") && tokens.size() == 1) {
                // get course code string
                String courseCode = tokens.get(0);
                
                // print class list (i.e. students) for this course
                registry.printClassList(courseCode);


                // if command to print all student data in an active course
            } else if (command.equalsIgnoreCase("PGR") && tokens.size() == 1) {
                // get course code string
                String courseCode = tokens.get(0);
                
                // print name, id and grade of all students in active course
                registry.printGrades(courseCode);


                // if command to print all credit courses of student
            } else if (command.equalsIgnoreCase("PSC") && tokens.size() == 1) {
                // get student id string
                String studentId = tokens.get(0);

                boolean isId = isNumeric(studentId);
                
                if (isId) {
                    // print all credit courses of student
                    registry.printStudentCourses(studentId);
                } else {
                    System.out.println(" check student id");
                }

                // if command to print student transcript
            } else if (command.equalsIgnoreCase("PST") && tokens.size() == 1) {
                // get student id string
                String studentId = tokens.get(0);

                boolean isId = isNumeric(studentId);
                
                if (isId) {
                    // print student transcript
                    registry.printStudentTranscript(studentId);
                } else {
                    System.out.println(" check student id");
                }

                // if command to set final grade of a student
            } else if (command.equalsIgnoreCase("SFG") && tokens.size() == 3) {
                // set final grade of student
                // get course code, student id, numeric grade
                String courseCode = tokens.get(0);
                String studentId = tokens.get(1);
                String tempGrade = tokens.get(2);

                boolean isId = isNumeric(studentId);
                boolean isGrade = true;
                
                double grade = 0;
                try {
                    grade = Double.parseDouble(tempGrade);
                } catch (NumberFormatException e) {
                    isGrade = false;
                }

                if (isId && isGrade) {
                    // use registry to set final grade of this student (see class Registry)
                    registry.setFinalGrade(courseCode, studentId, grade);
                } else {
                    if (!isId) {
                        System.out.println(" check student id");
                    } if (!isGrade) {
                        System.out.println(" check student grade");
                    }
                }

                // if command to sort list of students in course by name
            } else if (command.equalsIgnoreCase("SCN") && tokens.size() == 1) {
                // get course code
                String courseCode = tokens.get(0);
                
                // sort list of students in course by name (i.e. alphabetically)
                // see class Registry
                registry.sortCourseByName(courseCode);


                // if command to list of students in course by student id
            } else if (command.equalsIgnoreCase("SCI") && tokens.size() == 1) {
                // get course code
                String courseCode = tokens.get(0);

                // sort list of students in course by student id
                // see class Registry
                registry.sortCourseById(courseCode);


            } else {
                System.out.println("Invalid command");
            }
            // readability
            System.out.print("\n>");
        }
    }

    // method to check if string str contains only alphabetic characters
    private static boolean isStringOnlyAlphabet(String str) {
        // write method to check if string str contains only alphabetic characters 
        //  ensure name is all alphabetic characters
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)) {
                System.out.println(str + " contains invalid characters");
                return false;
            }
        }

        return true;
    }

    // method to check if string str contains only numeric characters
    public static boolean isNumeric(String str) {
        // write method to check if string str contains only numeric characters
        //  ensure id string is all numeric characters
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (!Character.isDigit(c)) {
                System.out.println(str + " contains invalid characters");
                return false;
            }
        }

        return true;
    }
}
