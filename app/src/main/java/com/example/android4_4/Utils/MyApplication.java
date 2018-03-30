package com.example.android4_4.Utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by JackR on 2018/3/30.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
