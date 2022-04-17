package com.example.demo.model;

import java.sql.Date;

public class Reader extends AdminUser {
    private Integer readerId;
    private String email;
    private String address;
    private Date createDate;

    public Reader(Integer adminId, String firstName, String lastName, String gender, Integer readerId, String email, String address, Date createDate, String password) {
        super(adminId, firstName, lastName, gender, password);
        this.readerId = readerId;
        this.email = email;
        this.address = address;
        this.createDate = createDate;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
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

    public Date getDate() {
        return createDate;
    }

    public void setDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                "adminId=" + getAdminId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", date=" + createDate +
                ", password='" + getPassword() + '\'' +
                "}\n";
    }
}
