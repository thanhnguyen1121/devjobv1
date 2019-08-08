package com.thanhnguyen.devjob.Model.UserModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisterStatus {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("username")
    @Expose
    private List<String> username = null;
    @SerializedName("email")
    @Expose
    private List<String> email = null;
    @SerializedName("role")
    @Expose
    private List<String> role = null;
    @SerializedName("phone")
    @Expose
    private List<String> phone = null;
    @SerializedName("password")
    @Expose
    private List<String> password = null;
    @SerializedName("repassword")
    @Expose
    private List<String> repassword = null;

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getPassword() {
        return password;
    }

    public void setPassword(List<String> password) {
        this.password = password;
    }

    public List<String> getRepassword() {
        return repassword;
    }

    public void setRepassword(List<String> repassword) {
        this.repassword = repassword;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}