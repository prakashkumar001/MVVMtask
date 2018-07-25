package com.task.test.signup;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.task.test.ClickEvent.ClickListener;
import com.task.test.R;
import com.task.test.databinding.SignupBinding;


public class Signup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SignupBinding binding= DataBindingUtil.setContentView(this, R.layout.signup);
        binding.setSignup(new SignUpViewModel("Enter name","Enter email","Enter Password","Enter confirm Password","Submit"));

       binding.setModelClickListener(new ClickListener() {
           @Override
           public void onClick() {


           }
       });

    }
}
