package app.ui;
import java.util.InputMismatchException;
import java.util.Scanner;
import app.Student.Student;
import static app.Student.student_functions.*;

public class CommandLineUI {
    public static void mainmenu(){

        boolean running = true;
        System.out.println(" Welcome!! User");
        System.out.println("");
        while (running==true) {
            System.out.println("1. Generate Student Report");
//            System.out.println("2. Generate Course Report");
            System.out.println("3. Log Out as User");
            System.out.print("Enter your choice: ");
            Scanner scan = new Scanner(System.in);
            int choice=Integer.parseInt(scan.nextLine());
            switch (choice){
                case 1:
                    generateStudentReport();
                    break;
                case 3:
                    running=false;
                    System.out.println("Thanks for using our Student Result Management System. \nPlease Share your valuable Insight to our team.");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid Option");
                    mainmenu();
            }
        }
    }
    private static void generateStudentReport(){
        System.out.println("Please Enter the Student ID of the Student");
        Scanner scan=new Scanner(System.in);
        int tempID;
        try {
            tempID = Integer.parseInt(scan.nextLine());
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input");
            tempID = Integer.parseInt(scan.nextLine());
        }
        Student myStudent = fetchStudentbyID(tempID);
        if(myStudent !=null){
            myStudent.displayStudent();
            performFunctions(myStudent);
            mainmenu();
        }
        else {
            while (myStudent == null) {
                System.out.println("Student ID wasn't found in database. Please Enter a valid Student ID");
                generateStudentReport();
            }
        }
    }
    private static void generateCourseReport(){

    }
}
