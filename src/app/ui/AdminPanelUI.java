package app.ui;
import app.AdminLoginCredentials.AdminLoginPage;
import app.Student.student_functions;
import app.Course.course_functions;

import java.io.Console;
import java.util.Scanner;

public class AdminPanelUI {
    public static void mainmenu(){
        System.out.println("Kindly Authenticate To Proceed. ");
        Scanner scan=new Scanner(System.in);
        System.out.println("Please Enter User ID. ");
        String UserID=scan.nextLine();
//        System.out.println("Please Enter Your Password");
        Console cb=System.console();
        if (cb == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }
        char[] passArray= cb.readPassword("Enter your Password \n");
        String Password=new String(passArray);
        AdminLoginPage phlaAdmin=new AdminLoginPage(UserID,Password);
        if(phlaAdmin.adminAuthenticate()){
            System.out.println("Welcome admin!!");
            runnableAdmin();
            mainmenu();
        }
        else {
            System.out.println("Authentication Failed!!");
        }
    }
    private static void runnableAdmin(){
        System.out.println("1. Create Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Modify Student");
        System.out.println("4. Create Course");
        System.out.println("5. Delete Course");
        System.out.println("6. Enroll Student for a Semester");
        System.out.println("7. Assign Grades to Students");
        System.out.println("8. Log Out as Admin");
        System.out.println("Enter Your Choice");
        Scanner scan=new Scanner(System.in);
        int choice;
        try {
            choice = Integer.parseInt(scan.nextLine());
        }
        catch (Exception e){
            System.out.println("Invalid Input");
            choice=Integer.parseInt(scan.nextLine());
        }

        switch (choice){
            case 1:
                student_functions.createStudent();
                System.out.println("Command Executed Succesfully.");
                runnableAdmin();
                break;
            case 2:
                student_functions.deleteStudent();
                System.out.println("Command Executed Succesfully.");
                runnableAdmin();
                break;
            case 3:
                student_functions.ModifyStudent();
                System.out.println("Command Executed Successfully.");
                runnableAdmin();
                break;
            case 4:
                course_functions.createCourse();
                System.out.println("Command Executed Successfully.");
                runnableAdmin();
                break;
            case 5:
                course_functions.deleteCourse();
                System.out.println("Command Executed Successfully.");
                runnableAdmin();
                break;
            case 6:
                student_functions.assignCourses();
                System.out.println("Command Executed Successfully");
                runnableAdmin();
                break;
            case 7:
                student_functions.assignStudent();
                System.out.println("Command Executed Successfully.");
                runnableAdmin();
                break;
            case 8:
                break;
            case 9:
                student_functions.showAllStudents();
                System.out.println("Command Executed Successfully.");
                runnableAdmin();
            default:
                System.out.println("Invalid Command!!");
                runnableAdmin();
        }



    }
}
