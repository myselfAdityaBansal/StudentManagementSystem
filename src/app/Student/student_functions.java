package app.Student;
import java.util.InputMismatchException;
import java.util.Scanner;

import static app.Constants.db;

public class student_functions {

    public static void createStudent(){
        for(int i=0;i<db.totalStudents;i++) {
            System.out.println(db.totalStudentslist[i].getStudentID());
        }
        if(db.totalStudents <100) {
            Scanner scan=new Scanner(System.in);
            Scanner scanner=new Scanner(System.in);
            String name ,email;
            int age, studentID= (1001+db.totalStudents);
            System.out.println("Please Enter the name of the Student");
            name =scan.nextLine();
            System.out.println("Please Enter the age of the Student");
            age =Integer.parseInt(scan.nextLine());
            System.out.println("Please Enter the email of the Student");
            email =scan.nextLine();
            System.out.println(db.totalStudents);
//            System.out.println("Please Enter the Student ID of the Student");
//            studentID =Integer.parseInt(scan.nextLine());


            Student student = new Student(name,studentID,age,email);
//            System.out.println("Hello");
            db.totalStudentslist[db.totalStudents] = student;
            db.totalStudents++;
//            System.out.println("Hello");
            System.out.println(db.totalStudents);
//            int tempID=db.totalStudentslist[4].getStudentID();
            System.out.println("The Student ID for the new Student is: "+ db.totalStudentslist[(db.totalStudents-1)].getStudentID());


        }
        else {
            System.out.println("Total number of students reached 100. Database Limit reached");
        }
    }

    public static void deleteStudent(){
        if(db.totalStudents>0){
            Scanner scan=new Scanner(System.in);
            System.out.println("Please enter the Student ID of the Student which you want to delete");
            int tempID=Integer.parseInt(scan.nextLine());
            for(int i=0;i<db.totalStudents;i++){
                if(db.totalStudentslist[i].getStudentID()==tempID){
                    for(int j=i;j<db.totalStudents;j++){
                        db.totalStudentslist[j]=db.totalStudentslist[j+1];
                    }
                    db.totalStudentslist[db.totalStudents]=null;
                    db.totalStudents--;
                    return;
                }
            }
        }
        else {
            System.out.println("No Student in the Database for Deletion");
        }
    }
    public  static void showAllStudents(){
        for(int i=0;i<db.totalStudents;i++){

            db.totalStudentslist[i].displayStudent();
        }
    }
    public static void ModifyStudent(){
        System.out.println("Please enter the Student ID of the Student which you want to Modify");
        Scanner scan=new Scanner(System.in);
        int tempID=Integer.parseInt(scan.nextLine());
        for(int i=0;i<db.totalStudents;i++){
            if(db.totalStudentslist[i].getStudentID()==tempID){
                System.out.println("Please enter the detail you want to change: ");
                System.out.println("1. Name");
                System.out.println("2. Age");
                System.out.println("3. Email address");
                int choice=Integer.parseInt(scan.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Please Enter the new name");
                        String newname=scan.nextLine();
                        db.totalStudentslist[i].setName(newname);
                        break;
                    case 2:
                        System.out.println("Please Enter the new age");
                        int newage=Integer.parseInt(scan.nextLine());
                        db.totalStudentslist[i].setAge(newage);
                        break;
                    case 3:
                        Scanner sc=new Scanner(System.in);
                        System.out.println("Please Enter the new email");
                        String newmail=sc.nextLine();
                        db.totalStudentslist[i].setEmail(newmail);
                        break;
                    default:
                        System.out.println("Invalid Command");
                        ModifyStudent();
                        break;
                }

            }
        }

    }
    public static void assignMarksToStudent(Student student){
        Scanner scan=new Scanner(System.in);
        System.out.println("Select The Semester You want to Edit: ");
        student.printSemesters();
        int sem=Integer.parseInt(scan.nextLine());
        int semIndex=student.findSemInArray(sem);
        student.printCourses(sem);
        System.out.println("Please Enter the course ID of the course you want to edit");
        Scanner sc=new Scanner(System.in);
        String tempCourseID=scan.nextLine();
        System.out.println("Enter the grade you want to assign to the course");
        String tempGrade=scan.nextLine();
        int courseIndex=student.semesters[semIndex].findCourseInArray(tempCourseID);
        student.semesters[semIndex].coursesEnrolled[courseIndex].setGrades(tempGrade);
        System.out.println("Want To Assign Marks to the Same Student ?? Press 3.");
        System.out.println("Press Any Other Key to Exit");

        int choice=Integer.parseInt(scan.nextLine());
        if(choice==3){
            assignMarksToStudent(student);
        }
    }
    public static void assignCourses(){
            int choice=1;
            Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Student ID you want to Modify");
        int tempID=Integer.parseInt(sc.nextLine());
        Student student=fetchStudentbyID(tempID);
        System.out.println("Enter the semester you want to enroll the Student in: ");
        int semNo= Integer.parseInt(sc.nextLine());
        while (choice==1) {
            System.out.println("Enter the course ID of the course you want to assign");
            String courseID = sc.nextLine();
            student.enrollInSemester(semNo);
            student.semesters[semNo - 1].enrollInCourse(courseID, semNo, student);
            System.out.println("Do You Want to enroll the student into other Courses ??");
            System.out.println(" If Yes, Press 1. To exit press any other Key");
            choice=Integer.parseInt(sc.nextLine());
        }
    }
    public static void assignStudent(){
        System.out.println("Enter the Student ID to whom you want to assign Grades");
        Scanner scan= new Scanner(System.in);
        int tempID=Integer.parseInt(scan.nextLine());
        Student student=fetchStudentbyID(tempID);
        System.out.println("Student Name: "+ student.getName());
        System.out.println("");
        assignMarksToStudent(student);

    }
    public static Student fetchStudentbyID(int StudentID){

        for(Student student1: db.totalStudentslist){
             if(student1.getStudentID()==StudentID){
                 return student1;
             }
        }
        return null;
    }
    public static void performFunctions(Student student){
        System.out.println(" Please enter the number according to the action you want to perform from the List");
        System.out.println("1. View All the Semesters "+student.getName()+" is enrolled in");
        System.out.println("2. View Courses of a particular Semester");
        System.out.println("3. Go Back to Previous Menu");
        Scanner sca=new Scanner(System.in);
        int choice=Integer.parseInt(sca.nextLine());
        switch (choice){
            case 1:
                student.printSemesters();
                performFunctions(student);
                break;
            case 2:
                System.out.println("Please enter the semester you wanna look into");
                int sem=Integer.parseInt(sca.nextLine());
                student.printCourses(sem);
                performFunctionOnCourses(sem, student);
                performFunctions(student);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid Choice");
                performFunctions(student);

        }
    }

    public static void performFunctionOnCourses(int sem, Student student) {
        try {
            for (int i = 0; i <= student.getTotalSemestersEnrolled(); i++) {
                if (student.semesters[i].getSemNo() == sem) {
                    System.out.println("You are into the details of Student " + student.getName() + " and looking the details for his semester: " + sem);
                    System.out.println(" Please enter the number according to the action you want to perform from the List");
                    System.out.println("1. Look at all the courses " + student.getName() + " was enrolled in");
                    System.out.println("2. Look at complete report of the Semester");
                    System.out.println("3. Look at grade of a particular Subject");
                    System.out.println("4. Go back to previous Menu");
                    Scanner sca = new Scanner(System.in);
                    try {
                        int choice = Integer.parseInt(sca.nextLine());
                        switch (choice) {
                            case 1:
                                student.semesters[i].printCourses();
                                performFunctionOnCourses(sem, student);
                                break;
                            case 2:
                                student.semesters[i].printEveryGrade();
                                performFunctionOnCourses(sem, student);
                                break;
                            case 3:
                                String courseID;
                                Scanner scan = new Scanner(System.in);
                                System.out.println("Please enter the Course ID of the subject");
                                courseID = scan.nextLine();
                                student.semesters[i].printSpecificGrade(courseID);
                                performFunctionOnCourses(sem, student);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid Choice");
                                performFunctionOnCourses(sem, student);

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong Input.");
                        performFunctionOnCourses(sem, student);
                    }
                } else {
                    performFunctions(student);
                }
            }
        }
        catch(NullPointerException e){

        }
    }


}
