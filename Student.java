//IMPORTANT
/* Hey guys In this code, the Student class has the required attributes 
(sID, name, interestedIn, phone, address, dateOfBirth) as private variables. It also includes a constructor to initialize these attributes, 
as well as getters and setters to access and modify the attribute values. */

/* Please someone Create the source code folder where the project is stored.
Inside the source code folder, create a new package (folder) called com.library 
(or any suitable package name) to organize our classes.
Within the com.library package, transfer this Java class file called Student.java.*/

package com.library;

import java.util.Date;

public class Student {
    private String sID;
    private String name;
    private String interestedIn;
    private String phone;
    private String address;
    private Date dateOfBirth;

    public Student(String sID, String name, String interestedIn, String phone, String address, Date dateOfBirth) {
        this.sID = sID;
        this.name = name;
        this.interestedIn = interestedIn;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getSID() {
        return sID;
    }

    public void setSID(String sID) {
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterestedIn() {
        return interestedIn;
    }

    public void setInterestedIn(String interestedIn) {
        this.interestedIn = interestedIn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
