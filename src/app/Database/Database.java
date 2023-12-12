package app.Database;
import app.Course.ParticularCourse;
import app.Student.Student;

import java.util.Arrays;

public class Database {
    public int totalStudents =0;
    public int totalCourses=0;
    public String[][] loginCredentials= new String[10][2];
    public Student[] totalStudentslist =new Student[100];
    public ParticularCourse[] totalCourseslist =new ParticularCourse[20];

    public Database() {
        // Initialize loginCredentials with empty strings
        for (int i=0; i<10; i++) {
            Arrays.fill(loginCredentials[i], "");
        }
    }

}
