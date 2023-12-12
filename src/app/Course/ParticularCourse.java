package app.Course;


import app.Database.courseDatabase;
import static app.Constants.db;


public class ParticularCourse extends course{
    private String grades;
    courseDatabase[] StudentsAndGrades=new courseDatabase[20];


    public ParticularCourse(String CourseID,String CourseName) {
        this.CourseID = CourseID;
        this.CourseName=CourseName;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }
    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public static ParticularCourse fetchCOursebyID(String courseID){

        for(int i=0;i<db.totalCourses;i++){
           if (db.totalCourseslist[i].CourseID.equalsIgnoreCase(courseID)){
               return db.totalCourseslist[i];
           }
        }
        return null;
    }


}
