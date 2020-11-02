# Student-Registry

1. Student: Class Student contains instance variables name (type String), id (type
String), courses (array list of CreditCourse objects). The id string should contain
5 digit characters. The courses variable keeps track of the courses the student
has taken in the past or is currently enrolled in. Methods include addNewStudent,
removeStudent, addCourse, and dropCourse. 

2. Course: class Course contains instance variables code, name, description, format
(all type String). Subclasses include CreditCourse and ActiveCourse.

3. ActiveCourse: Class ActiveCourse extends class Course. That is, an ActiveCourse is
a Course. Variables and methods inherited from class Course, class ActiveCourse keeps 
students enrolled in the course.

    This class also has two private Comparator classes that are used to sort the list
    of students by name or by student id. 

4. CreditCourse: class CreditCourse also extends class Course. That is, a CreditCourse
is a Course. Variables and methods inherited from class Course, class CreditCourse adds 
variables semester (type String), grade (double), active (type boolean). Class Student 
above keeps a list of CreditCourse objects. The grade variable is initially set to 0. 
The active variable is initially set to true. The active variable indicates whether 
this is course that is currently happening – and therefore there is an assocated 
ActiveCourse object in the Registry – or whether this was a course the student has 
taken in the past. The final grade for a CreditCourse that a student is taking is set 
from class Registry in method setFinalGrade(). A CreditCourse is associated with a student 
and is like a record of what the student has done or is currently doing. An ActiveCourse, 
on the other hand, is for university administrators and professors which holds information 
for a currently active course like cps209. In a university, an ActiveCourse may not be
for credit and so it is not a subclass of CreditCourse. 

5. Registry: class Registry holds students registered at this university and a active 
courses. It is the largest class for this system. 

6. StudentRegistrySimulator. This class has the main() method and is the user
interaction part.

   In a while loop, a scanner reads a line of input from the user. The input lines
   contain words (Strings). Most input lines contain a single word that represents a
   command. Some lines contain a command word and some parameter string. 

Commands:

a. “L” : list all the students in the registry.

b. “Q” : quit out of the program.

c. “REG” : register a student. Reads a student name and student id from the
commandLine scanner. Uses Registry method to register the new student. Just 
make up a 5 digit id.

d. “DEL”: deletes a student from the registry.

e. “ADDC”: adds a student to an active course.

f. “DROPC”: drops a student from an active course.

g. “PAC” : prints all active course.

h. “PCL” : prints class list for an active course.

i. “PGR” : prints student id and grade for all students in an active course.

j. “PSC” : prints all credit courses for a student.

k. “SFG” : Set final grade of a student in a course.

l. “SCN” : sort list of students in a course by student name.

m. “SCI” : sort list of students in a course by student id.

n. Code handles commands that are not recognized or the null string or a null 
reference etc.


-------------------------------------------------------------------------------------

1. ActiveCourse: Add new instance variables int lectureStart, int lectureDuration,
String lectureDay. You can use different names if you prefer. These variables will
be set/used by the new Scheduler class.

2. Registry: 

    a. The student names and ids are read from a file called students.txt. 
    Each file line should contain the student name and id. Handles IOExceptions. 
    Catches Exceptions in the main method by surrounding the lines Registry 
    registry = new Registry(); by a try{..} catch{..} block. Once you have 
    read a student name and id from the file, proceeds as usual – creates a 
    Student object and add it to the TreeMap.

    b. Uses the student id as the key for the students TreeMap and use the
    course code as the key for the courses TreeMap. 

3. Class Scheduler: 
    This class is responsible for scheduling active courses. There are 3 commands 
    added to the StudentRegistrySimulator that use the Scheduler. These 3  commands 
    will be explained in point 4. below. 

    Public methods for this class (note – add any other helper methods or
    variables you think you need):

    a. public Scheduler(TreeMap&lt;String,ActiveCourse&gt; courses). A constructor method
    that takes a reference to a TreeMap of active courses. In the main method of
    class StudentRegistrySimulator, Registry object uses a Scheduler object to pass 
    in the courses treemap from the registry. Initialize the schedule instance variable. 

    b. public void setDayAndTime(String courseCode, String day, int startTime, int
    duration). Method will set the variables lectureDay, lectureStart, lectureDuration 
    of the corresponding active course object. This method does extensive error checking
    first before setting these variables. If there is an error in one of the parameters, 
    then this method throws an appropriate exception. These exceptions are caught in the 
    main method of class StudentRegistrySimulator. Custom exceptions made by
    extending RuntimeException. Here is the error checking this method should support:

     UnknownCourse exception: the given courseCode cannot not be found
    
     InvalidDay exception: the string parameter day should be one of “Mon”, “Tue”, “Wed”, 
        “Thur”, “Fri”.
        
     InvalidTime exception: the startTime parameter should not be less than 0800 (8 am) 
        and the end time of the lecture (based on the duration parameter) should not be 
        greater than 1700 (5pm). Use a 24 hour clock.
        
     InvalidDuration parameter: the lecture duration should be 1, 2 or 3 hours.
    
     LectureTimeCollision exception : the day, startTime, and duration should be such 
        that it does not create any overlap with another
        scheduled course.
        

    c. public void clearSchedule(String courseCode). Given the course code, resets the 
        lectureDay to “”, lectureStart to 0 and lectureDuration to 0 of the ActiveCourse 
        object. If no such active course exists, do nothing.

    d. public void printSchedule(). Prints the timetable in a nice format. 
        Hours along the left side and days across the top.

4. StudentRegistrySimulator. Three commands:

    a. “SCH courseCode day start duration”. For example: sch cps209
        Mon 900 3. Schedules a course for a certain day, start time and duration.

        Catches any exceptions thrown. Print an appropriate message to
        the user if an exception is thrown.

    b. “CSCH courseCode”. Clears the schedule of the given course

    c. “PSCH” Prints the entire schedule.


5. BONUS:

    a. Extends the scheduler to handle multiple blocks of time for a course.

    b. Given a course code and a lecture duration, the scheduler automatically 
        finds a block of time during the week. If it cannot, it throws an exception. 
        If it succeeds, when you print the schedule, you should see the course has 
        been scheduled.
