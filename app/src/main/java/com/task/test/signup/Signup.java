package com.task.test.signup;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.task.test.ClickEvent.ClickListener;
import com.task.test.ClickEvent.IView;
import com.task.test.R;
import com.task.test.databinding.SignupBinding;
import com.task.test.login.LoginViewModel;
import com.task.test.pojo.User;
import com.task.test.realm.RealmController;

import io.realm.Realm;


public class Signup extends AppCompatActivity implements IView{

Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.realm = RealmController.with(this).getRealm();
        final SignupBinding binding= DataBindingUtil.setContentView(this, R.layout.signup);
        SignUpViewModel viewModel=new SignUpViewModel("Enter name","Enter email","Enter Password","Enter confirm Password","Submit");

        binding.setSignup(viewModel);

       binding.setModelClickListener(new ClickListener() {
           @Override
           public void onClick() {

               User user = realm.where(User.class).equalTo("email", binding.getSignup().getEmail()).findFirst();

               if(user.getEmail().equals(binding.getSignup().getEmail()))
               {
                   showMessage("Already Email exists");
           }else
               {

                   User value=new User();
                   value.setName(binding.getSignup().getName());
                   value.setEmail(binding.getSignup().getEmail());
                   value.setPassword(binding.getSignup().getPassword());
                   value.setConfirm_pass(binding.getSignup().getConfirm_pass());

                   realm.beginTransaction();
                   realm.copyToRealm(value);
                   realm.commitTransaction();

                   showMessage("SignUp Successfull");
                   finish();
               }


           }

    });

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(Signup.this,message,Toast.LENGTH_SHORT);
    }
}
