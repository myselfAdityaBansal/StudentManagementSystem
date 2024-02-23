package course;
import constants.Constants;
import faculty.Faculty;

import static constants.Constants.db;
public class Course {
    String CourseName;
    String CourseID;

    public Course(String courseName, String courseID) {
        this.CourseName = courseName;
        this.CourseID = courseID;
    }
}
