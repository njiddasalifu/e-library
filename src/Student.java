


import java.util.Date;
public class Student {
    private String StudentID;
    private String Name;
    private String Interest;
    private String Phone;
    private String Address;
    private Date dateOfBirth;

    public Student(String StudentID, String Name, String Interest, String Phone, String Address, Date dateOfBirth) {
        this.StudentID = StudentID;
        this.Name = Name;
        this.Interest = Interest;
        this.Phone = Phone;
        this.Address = Address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getSID() {
        return StudentID;
    }

    public void setSID(String StudentID) {
        this.StudentID = StudentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getInterest() {
        return Interest;
    }

    public void setInterest(String Interest) {
        this.Interest = Interest;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
