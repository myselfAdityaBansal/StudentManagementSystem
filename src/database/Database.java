package database;
import course.Course;
import faculty.Faculty;
import student.Student;
import java.util.Arrays;
import java.util.LinkedList;

public class Database {

//    public String[][] loginCredentials= new String[10][2];
    public LinkedList<Student> totalStudentslist =new LinkedList<Student>();
    public LinkedList<Faculty> totalFacultylist =new LinkedList<Faculty>();
    public LinkedList<Course> totalCourseslist =new LinkedList<Course>();

    public int totalStudents =totalStudentslist.size();
    public int totalFaculty=totalFacultylist.size();
    public int totalCourses=totalCourseslist.size();
    public Database() {
        // Initialize loginCredentials with empty strings
//        for (int i=0; i<10; i++) {
//            Arrays.fill(loginCredentials[i], "");
//        }
    }

}
