package com.task.test.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.task.test.ClickEvent.ClickListener;
import com.task.test.R;
import com.task.test.databinding.LoginDataBinding;
import com.task.test.home.HomeActivity;
import com.task.test.pojo.LogIn;
import com.task.test.pojo.User;
import com.task.test.realm.RealmController;
import com.task.test.signup.Signup;

import io.realm.Realm;


public class LoginActivity extends AppCompatActivity {

    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.realm = RealmController.with(LoginActivity.this).getRealm();



        if(RealmController.getInstance().getLogin().size()>0)
        {
            finish();

            Intent i=new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);

        }else {

        }

        final LoginDataBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

// Lets Set Value Of XML properties PROGRAMMATICALY


        LoginViewModel viewModel=new LoginViewModel("Enter Email","Enter Password","Signup Account","Login");

        binding.setLogin(viewModel);






        //View Is Bound with ViewModel here Lets proceed with getting Data and Validations



        binding.setModelClickListener(new ClickListener() {
            @Override
            public void onClick() {

                User user = realm.where(User.class).equalTo("email", binding.getLogin().getUserEmail()).findFirst();
                if (user != null) {
                    // dog

                    //Toast.makeText(LoginActivity.this, user.getPassword(), Toast.LENGTH_SHORT).show();

                    if (!binding.getLogin().getUserEmail().isEmpty() && !binding.getLogin().getUserPassword().isEmpty()) {
                        if(user.getEmail().equalsIgnoreCase(binding.getLogin().getUserEmail()) && user.getPassword().equalsIgnoreCase(binding.getLogin().getUserPassword()))
                        {
                            LogIn value = new LogIn();
                            value.setEmail(user.getEmail());
                            value.setPassword(user.getPassword());

                            realm.beginTransaction();
                            realm.copyToRealm(value);
                            realm.commitTransaction();

                            Toast.makeText(LoginActivity.this, "Login sucess", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(i);
                        }else {

                            Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                            // On Click It will display all the values
                        }


                    } else {

                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                        // On Click It will display all the values
                    }
                }else {

                    Toast.makeText(LoginActivity.this, "Invalid", Toast.LENGTH_SHORT).show();

                    // On Click It will display all the values
                }
            }
        });


        binding.signupAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, Signup.class);
                startActivity(i);
            }
        });



    }


}
