package semester;

import database.LL;
public class Semester {
    protected int semNo;
    protected LL StudentAndCourses=new LL();


    public void insertStudent(int StudentID,int CourseID){
        StudentAndCourses.insert(StudentID,CourseID);
    }
    public void deleteStudent(int StudentID,int CourseID){
        StudentAndCourses.delete(StudentID,CourseID);
    }

    public void print(){
        System.out.printf("%-6s%10s%10s%n","Sr No.","StudentID","CourseID");
        StudentAndCourses.print();
    }

    public static void main(String[] args) {
        Semester abc=new Semester();
        System.out.println();
        abc.insertStudent(1,1);
        abc.insertStudent(2,2);
        abc.insertStudent(3,3);
        abc.insertStudent(4,4);
        abc.insertStudent(5,5);


        abc.deleteStudent(5,4);
        abc.print();


    }
}
