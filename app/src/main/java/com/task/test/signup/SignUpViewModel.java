package com.task.test.signup;

import com.task.test.BR;
import com.task.test.R;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;


public class SignUpViewModel extends BaseObservable {


    private String name;
    private String email;
    private String password;
    private String errorEmail;
//All the hints of edittexts .

    public String passwordHint;
    public String cpasswordHint;
    private String emailHint;
    public String submitText;


    // Setting texts of forgot password link and

    public String forgotPasswordText;
    public String loginButtonText;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
    }

    private String confirm_pass;
    public void setUserEmail(String userEmail) {
        this.email = userEmail;
        /** To get value of edittext enterd by user, This Updates the value of userEmail on Every LEtter Entered by User*/
        notifyPropertyChanged(R.id.email);
        /**to check Email for validation on every character inserted by user*/
        //Similarly This
        notifyPropertyChanged(BR.errorEmail);
    }
    //  Constructor

    public SignUpViewModel(String name,String emailHint, String passwordHint, String cpasswordHint, String submitText) {
        this.name = name;
        this.emailHint = emailHint;
        this.passwordHint = passwordHint;
        this.cpasswordHint = cpasswordHint;
        this.submitText = submitText;

    }
}