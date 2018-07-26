package com.task.test.common;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class Global extends Application {
    public void onCreate() {



        super.onCreate();

        setUpRealmConfig();


    }

    private void setUpRealmConfig(){

        // initialize Realm
        Realm.init(getApplicationContext());

        // create your Realm configuration
        RealmConfiguration config = new RealmConfiguration.
                Builder().
                deleteRealmIfMigrationNeeded().
                build();
        Realm.setDefaultConfiguration(config);
    }
}
