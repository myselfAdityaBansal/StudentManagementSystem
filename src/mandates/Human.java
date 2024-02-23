package mandates;

public class Human {
    protected String name;
    protected String address;
    protected int age;
    protected Double MobileNumber;
    protected char Gender;


    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getAddress() {
        return address;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected Double getMobileNumber() {
        return MobileNumber;
    }

    protected void setMobileNumber(Double mobileNumber) {
        MobileNumber = mobileNumber;
    }

    protected char getGender() {
        return Gender;
    }

    protected void setGender(char gender) {
        Gender = gender;
    }
}
