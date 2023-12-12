package app.semester;
import app.Course.ParticularCourse;
import app.Student.Student;

public class currentSemester implements semester{
    private int SemNo;
    public ParticularCourse[] coursesEnrolled= new ParticularCourse[5];
    private int totalCoursesEnrolled=0;

    public int getSemNo() {
        return SemNo;
    }

    public void setSemNo(int semNo) {
        SemNo = semNo;
    }

    public int getTotalCoursesEnrolled() {
        return totalCoursesEnrolled;
    }

    public int findCourseInArray(String courseID){
        try {
            for (int i = 0; i < totalCoursesEnrolled; i++) {
                if (coursesEnrolled[i].getCourseID().equalsIgnoreCase(courseID)) {
                    return i;
                }
            }
        }
        catch (Exception e){

        }
        return 0;
    }

    @Override
    public void enrollInCourse(String courseID,int sem, Student student){
        ParticularCourse Course1=ParticularCourse.fetchCOursebyID(courseID);
        student.semesters[sem-1].coursesEnrolled[totalCoursesEnrolled]=Course1;
        totalCoursesEnrolled++;
    }
    @Override
    public void printCourses(){
        try {
            for(int i=0;i<=totalCoursesEnrolled;i++){
                System.out.print(coursesEnrolled[i].getCourseName()+"  ");
                System.out.println(coursesEnrolled[i].getCourseID());
            }
        }
        catch (Exception e){

        }

    }
    @Override
    public void printEveryGrade(){
        try {
            for (ParticularCourse Course : coursesEnrolled) {
                System.out.println("Grade For " + Course.getCourseID() + " is: " + Course.getGrades());
            }
        }
        catch (Exception e){

        }
    }
    @Override
    public void printSpecificGrade(String CourseID){
        try {
            for (int i = 0; i <= totalCoursesEnrolled; i++) {
                if (coursesEnrolled[i].getCourseID().equalsIgnoreCase(CourseID)) {
                    System.out.println("Grade For " + CourseID + " is: " + coursesEnrolled[i].getGrades());
                } else {
                    System.out.println(CourseID + " Not Found");
                }
            }
        }
        catch (Exception e){

        }
    }
    @Override
    public boolean fetchCourseIfEnrolled(String CourseID){
        for(ParticularCourse Course  : coursesEnrolled){
            if(Course.getCourseID().equalsIgnoreCase(CourseID)) {
                return true;
            }
        }
        return false;
    }

}
