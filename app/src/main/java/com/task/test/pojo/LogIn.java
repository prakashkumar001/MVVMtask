package com.task.test.pojo;

import io.realm.RealmObject;

public class LogIn extends RealmObject {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String email;
    public String password;
}
