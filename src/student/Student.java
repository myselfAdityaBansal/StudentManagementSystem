package student;

import database.Database;
import static constants.Constants.db;
import mandates.Human;
public class Student extends Human{
    protected int StudentID;
    protected int BatchYear;
    Student(String name,String address,int age, Double mobile, char gender, int batchYear){
        this.StudentID=(100+db.totalStudents);
        this.name=name;
        this.address=address;
        this.age=age;
        this.MobileNumber=mobile;
        this.Gender=gender;
        this.BatchYear=batchYear;

    }

    protected int getStudentID() {
        return StudentID;
    }
}
