package com.tumtrick.mvcstructure;

import android.app.Application;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Thipphakone on 19/01/2016.
 */
public class MainApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        // Initialize thing(s) here
        Contextor.getInstance().init(getApplicationContext());


    }

    @Override
    public void onTerminate() {
        super.onTerminate();



    }
}
