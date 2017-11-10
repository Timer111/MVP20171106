package com.dell.lizhanbiao20171106.App;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by DELL on 2017/11/6.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
