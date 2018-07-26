package com.task.test.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.task.test.ClickEvent.ClickListener;
import com.task.test.R;
import com.task.test.databinding.HomeActivityBinding;
import com.task.test.login.LoginActivity;
import com.task.test.pojo.LogIn;
import com.task.test.realm.RealmController;

import io.realm.Realm;
import io.realm.RealmResults;


public class HomeActivity extends AppCompatActivity {
    Realm realm;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = RealmController.with(HomeActivity.this).getRealm();

        HomeActivityBinding binding= DataBindingUtil.setContentView(this, R.layout.home);

        binding.setModelClickListener(new ClickListener() {
            @Override
            public void onClick() {

                realm.beginTransaction();
                realm.delete(LogIn.class);
                realm.commitTransaction();
                Intent i=new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(i);


            }
        });
    }
}
