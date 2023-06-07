package com.library;

public class Student {
    private int studentID;
    private int bookID;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String interest;

    public Student(int studentID, int bookID, String name, String phone, String email, String address, String interest) {
        this.studentID = studentID;
        this.bookID = bookID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.interest = interest;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getname() {
        return name;
    }

    public void setStudentName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
