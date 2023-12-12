
import app.SampleData.data;

import java.util.InputMismatchException;
import java.util.Scanner;
import app.ui.*;
public class Main {
        public static void run(){
            Scanner scan = new Scanner(System.in);
            int choice=0;

            try {
                System.out.println("Welcome To Student Result Management System: A Project By Group 3");


                System.out.println("1. Admin");
                System.out.println("2. User ");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scan.nextLine());
            }
            catch (Exception e){
                System.out.println("Invalid ");
                run();
            }
                switch (choice) {
                    case 1:
                        AdminPanelUI.mainmenu();
                        run();
                        break;
                    case 2:
                        CommandLineUI.mainmenu();
                        run();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid Command");
                        run();
                }

        }
        public static void main(String[] args) {
            System.out.println("Loadng Data......");
            data.loadData();
            run();
        }
}
