package app.SampleData;
import app.AdminLoginCredentials.AdminLoginPage;
import app.Student.Student;

import static app.Constants.db;
import app.Course.ParticularCourse;

public class data {
    public static void loadData(){
        AdminLoginPage phlaAdmin=new AdminLoginPage("admin","1234");
        phlaAdmin.createAdminUser();
        ParticularCourse course=new ParticularCourse("CSE101","Computer Science");
        db.totalCourseslist[db.totalCourses]=course;
        db.totalCourses++;
        course=new ParticularCourse("CSE102","Maths");
        db.totalCourseslist[db.totalCourses]=course;
        db.totalCourses++;
        course=new ParticularCourse("CSE103","Science");
        db.totalCourseslist[db.totalCourses]=course;
        db.totalCourses++;
        Student student=new Student("Aditya",1001,21,"abc@gmail.com");
        db.totalStudentslist[db.totalStudents]=student;
        db.totalStudents++;
        student.enrollInSemester(1);
        student.semesters[0].enrollInCourse("CSE101",1,student);
        student.semesters[0].coursesEnrolled[0].setGrades("A");
        student.enrollInSemester(2);
        student.semesters[1].enrollInCourse("CSE102",2,student);
        student.semesters[1].enrollInCourse("CSE103",2,student);
        student.semesters[1].coursesEnrolled[0].setGrades("B");
        student.semesters[1].coursesEnrolled[1].setGrades("C");
        student=new Student("Udit",1002,21,"abc@gmail.com");
        db.totalStudentslist[db.totalStudents]=student;
        db.totalStudents++;
        student.enrollInSemester(1);
        student.semesters[0].enrollInCourse("CSE103",1,student);
        student.semesters[0].coursesEnrolled[0].setGrades("C");
        student=new Student("Hemant",1003,21,"abc@gmail.com");
        db.totalStudentslist[db.totalStudents]=student;
        db.totalStudents++;
        student=new Student("Kashish",1004,21,"abc@gmail.com");
        db.totalStudentslist[db.totalStudents]=student;
        db.totalStudents++;

//        db.totalStudentslist[0].enrollInSemester(1);
//        db.totalStudentslist[0].enrollInSemester(2);
    }
}
