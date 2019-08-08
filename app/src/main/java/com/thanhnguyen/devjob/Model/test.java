package com.thanhnguyen.devjob.Model;

public class test {
    String token, app, session;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "test{" +
                "token='" + token + '\'' +
                ", app='" + app + '\'' +
                ", session='" + session + '\'' +
                '}';
    }
}

