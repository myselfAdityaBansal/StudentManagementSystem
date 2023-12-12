package app.Course;
import java.util.Scanner;

import static app.Constants.db;
public class course_functions {
    public static void createCourse(){
        if(db.totalCourses<20) {
            Scanner scan= new Scanner(System.in);
            String courseID, courseName;
            System.out.println("Please Enter the Course ID of the course to be Generated");
            courseID=scan.nextLine();
            System.out.println("Please Enter the Course Name of the course to be Generated against Course ID: "+courseID);
            courseName=scan.nextLine();
            ParticularCourse course=new ParticularCourse(courseID,courseName);
            db.totalCourseslist[db.totalCourses] = course;
            db.totalCourses++;
        }
        else{
            System.out.println("Total Number of Courses has reached 20. Database Limit Reached");
        }
    }

    public static void deleteCourse(){
        System.out.println("Please Enter the Course ID of the course you want to delete");
        Scanner scan=new Scanner(System.in);
        String tempID=scan.nextLine();
        if(db.totalCourses>0) {
            for (int i = 0; i < db.totalCourses; i++) {
                if (db.totalCourseslist[i].getCourseID().equalsIgnoreCase(tempID)) {
                    for (int j = i; j < db.totalCourses; j++) {
                        db.totalCourseslist[j] = db.totalCourseslist[j + 1];

                    }
                    db.totalCourseslist[db.totalCourses] = null;
                    db.totalCourses--;
                } else {
                    System.out.println("No Course with Course ID: " + tempID + " exists.");
                }
            }
        }
        else {
            System.out.println("No course in the database at the moment");
        }
    }
}
