package com.task.test.common;

import android.app.Application;

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
