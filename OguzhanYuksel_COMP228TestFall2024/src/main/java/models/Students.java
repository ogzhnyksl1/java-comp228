package models;

public class Students {
    private String studentID;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String province;
    private String postalCode;

    //constractor
    public Students(String studentID, String firstName, String lastName, String address, String city, String province, String postalCode) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    //getters
    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return studentID + "\t" + firstName + "\t" + lastName + "\t" + address + "\t" + city + "\t" + province + "\t" + postalCode + "\n";
    }
}
