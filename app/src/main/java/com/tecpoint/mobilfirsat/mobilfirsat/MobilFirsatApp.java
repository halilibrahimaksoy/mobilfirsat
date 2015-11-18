package com.tecpoint.mobilfirsat.mobilfirsat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.tecpoint.mobilfirsat.mobilfirsat.Model.Category;

import java.util.AbstractCollection;

/**
 * Created by Halil ibrahim AKSOY on 16.11.2015.
 */
public class MobilFirsatApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Category.class);

        Parse.initialize(this, "5wcZm5o4WRAMXv45j6BuH4Z3rzrjx5mxjbC70mZW", "SdnSntGyfgjr1piLK5HvxZLvIm7J6vM1h45VuSBJ");
    }
}
