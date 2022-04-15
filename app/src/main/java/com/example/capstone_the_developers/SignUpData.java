package com.example.capstone_the_developers;

public class SignUpData {
    String mobile;
    String email;
    String password;
    String id;

    public SignUpData(String id, String mobile,String email,String password) {
        this.email=email;
        this.password=password;
        this.mobile=mobile;
        this.id=id;
    }

    public void SignUpData() {
    }


    public String getMobile() {
        return mobile;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
