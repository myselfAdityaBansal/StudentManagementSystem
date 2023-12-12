package app.semester;
import app.Course.course;
import app.Student.Student;

public interface semester {
    public void enrollInCourse(String courseID,int sem, Student student);
    public boolean fetchCourseIfEnrolled(String CourseID);
    public void printSpecificGrade(String CourseID);
    public void printEveryGrade();
    public void printCourses();

    }
