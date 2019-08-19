package com.thanhnguyen.devjob.Model.UserModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginInfo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("role")
    @Expose
    private Integer role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
