package com.task.test.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.task.test.ClickEvent.ClickListener;
import com.task.test.R;
import com.task.test.databinding.LoginDataBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final LoginDataBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

// Lets Set Value Of XML properties PROGRAMMATICALY


        LoginViewModel viewModel=new LoginViewModel("Enter Email","Enter Password","Signup Account","Login");

        binding.setLogin(viewModel);






        //View Is Bound with ViewModel here Lets proceed with getting Data and Validations



        binding.setModelClickListener(new ClickListener() {
            @Override
            public void onClick() {

                Toast.makeText(LoginActivity.this, binding.getLogin().getUserEmail(), Toast.LENGTH_SHORT).show();
                Toast.makeText(LoginActivity.this, binding.getLogin().getUserPassword(), Toast.LENGTH_SHORT).show();

                // On Click It will display all the values
            }
        });





    }
}
