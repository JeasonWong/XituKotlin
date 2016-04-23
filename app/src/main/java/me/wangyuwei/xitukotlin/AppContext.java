package me.wangyuwei.xitukotlin;

import android.app.Application;

/**
 * 作者： 巴掌 on 16/4/23 23:28
 */
public class AppContext extends Application {

    private static AppContext singleton;

    public static AppContext getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
