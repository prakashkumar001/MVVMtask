package com.task.test.signup;





import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;

import com.task.test.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignUpViewModel extends BaseObservable {


    private String name;
    private String email;
    private String password;



    public String errorEmail;

    public String errorPassword;
//All the hints of edittexts .

    public String getNamehint() {
        return namehint;
    }

    public void setNamehint(String namehint) {
        this.namehint = namehint;
    }

    public String getEmailhint() {
        return emailhint;
    }

    public void setEmailhint(String emailhint) {
        this.emailhint = emailhint;
    }

    public String getPasshint() {
        return passhint;
    }

    public void setPasshint(String passhint) {
        this.passhint = passhint;
    }

    public String namehint;
    public String emailhint;
    public String passhint;

    public String getCpasshint() {
        return cpasshint;
    }

    public void setCpasshint(String cpasshint) {
        this.cpasshint = cpasshint;
    }

    public String getSubmitText() {
        return submitText;
    }

    public void setSubmitText(String submitText) {
        this.submitText = submitText;
    }

    public String cpasshint;
    public String submitText;















    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        // Same for pass word
        notifyPropertyChanged(R.id.name);
        //this line will notify new value of password every time
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        /** To get value of edittext enterd by user, This Updates the value of userEmail on Every LEtter Entered by User*/
        notifyPropertyChanged(R.id.email);
        /**to check Email for validation on every character inserted by user*/
        //Similarly This
        notifyPropertyChanged(com.task.test.BR.errorEmail);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(R.id.password);
        notifyPropertyChanged(com.task.test.BR.errorPassword);
    }

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
        notifyPropertyChanged(R.id.confirm_pass);
        notifyPropertyChanged(com.task.test.BR.errorPassword);
    }

    private String confirm_pass;

    //  Constructor

    public SignUpViewModel(String nameHint,String emailHint, String passwordHint, String cpasswordHint, String submitText) {
        this.namehint = nameHint;
        this.emailhint = emailHint;
        this.passhint = passwordHint;
        this.cpasshint = cpasswordHint;
        this.submitText = submitText;

    }

    //These Methods Check For Validation Every Time user enters a character
    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        pattern = Pattern.compile(PASSWORD_PATTERN);

        matcher = pattern.matcher(password);
        return matcher.matches();
    }


    @Bindable
    public String getErrorPassword() {
        if(password==null){
            return "Please Enter";
        }
        else if(password.length()<8){
            return "Too Short..!!";
        }else if(!isValidPassword(password)){
            return "Your Password Must be combination of \n Small,Captital & Special Characters";
        }else {
            return null;
        }


    }

    //These Methods Check For Validation Every Time user enters a character


    public static boolean isValidEmail( String userEmail) {
        Pattern pattern;
        Matcher matcher;
        // final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern= android.util.Patterns.EMAIL_ADDRESS;
        matcher = pattern.matcher(userEmail);
        return matcher.matches();
    }


    // If you Dont Bind Here You Wont get BR values
    @Bindable
    public String getErrorEmail() {
        if(email == null)
        {
            return "Please Enter";
        }else if(!isValidEmail(email))
        {
            return "Enter valid Id";
        }
        else
        {
            return null;
        }
    }
/**
 * Now Your XML is bound with ViewModel
 * Lets Check now
 *
 * Before , we need click listener
 */
}