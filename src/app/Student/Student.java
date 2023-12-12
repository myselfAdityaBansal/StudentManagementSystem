package app.Student;

import app.semester.currentSemester;
import app.Constants;

public class Student implements Student_base{
    private String name;
    private int StudentID;
    private int age;
    private String email;
    public currentSemester[] semesters = new currentSemester[8];
    private int totalSemestersEnrolled = 0;

    public Student(String name, int StudentID, int age, String email) {
        this.name = name;
        this.StudentID = StudentID;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getTotalSemestersEnrolled() {
        return totalSemestersEnrolled;
    }

    public void enrollInSemester(int sem) {
        currentSemester semesterI=new currentSemester();
        semesterI.setSemNo(sem);
        semesters[totalSemestersEnrolled] = semesterI;
        totalSemestersEnrolled++;
    }

    public void printSemesters() {
        System.out.println("Student is enrolled in Semesters: ");
        try {
            for (int i = 0; i <= totalSemestersEnrolled; i++) {
                System.out.println(semesters[i].getSemNo());
            }
        }
        catch (Exception e){

        }

    }
    @Override
    public void printCourses(int SemNo) {
        try {
            for (int i = 0; i <= totalSemestersEnrolled; i++) {
                if (semesters[i].getSemNo() == SemNo) {
                    System.out.println("Student was enrolled in coures:");
                    semesters[i].printCourses();
                }
            }
        }
        catch (Exception e){

        }
    }
    @Override
    public void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + StudentID);
        System.out.println("Age: " + age);
        System.out.println("Email Address: "+ email);
        System.out.println("Total Semesters Enrolled: " + totalSemestersEnrolled);
        System.out.println("Semesters Details: ");
        printSemesters();
    }

    public int findSemInArray(int sem) {
        for (int i = 0; i < totalSemestersEnrolled; i++) {
            if (semesters[i].getSemNo() == sem) {
                return i;
            }
        }
        return 0;
    }

}
