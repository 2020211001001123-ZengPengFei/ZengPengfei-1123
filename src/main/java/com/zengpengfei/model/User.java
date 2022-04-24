package com.zengpengfei.model;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String gender;
    private Date birthDate;

    public User() {
    }

    public User(int id, String username, String password, String email, String gender, Date bithDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.birthDate = bithDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername(String username) {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBithDate() {
        return birthDate;
    }

    public void setBithDate(Date bithDate) {
        this.birthDate = bithDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
