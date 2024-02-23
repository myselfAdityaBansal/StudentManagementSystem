package faculty;

import mandates.Human;

import static constants.Constants.db;

public class Faculty extends Human {
    protected int FacultyID;

    Faculty(String name,String address,int age, Double mobile, char gender){
        this.FacultyID=(1000+db.totalFaculty);
        this.name=name;
        this.address=address;
        this.age=age;
        this.MobileNumber=mobile;
        this.Gender=gender;
    }

    protected int getFacultyID() {
        return FacultyID;
    }
}
