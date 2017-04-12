package com.swm.netdemo.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import com.swm.netdemo.utils.SwmLogUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by SwmIsMe on 2016/8/25.
 * <p>
 * NOTICE!!!
 * 一定要在 AndroidManifest.xml  文件下的
 * <application     标签添加  name  属性  否则获取不到
 * android:name=".app.MyApplication"
 */
public class MyApplication extends Application {
    
    private static Handler handler;
    private static int mainThread;
    private static Context context;
    private boolean isOnLine = false;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
//  		import android.os.Process;  有两个包需要导入这个包
        mainThread = Process.myTid();

//        初始化 okhttp
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(10000L, TimeUnit.MILLISECONDS);
        okHttpClientBuilder.readTimeout(10000L, TimeUnit.MILLISECONDS);
        if (isOnLine) {
            SwmLogUtils.setDebuggable(SwmLogUtils.LEVEL_NONE);
        } else {
            okHttpClientBuilder.addInterceptor(new LoggerInterceptor("okhttpTAG"));
        }
        OkHttpUtils.initClient(okHttpClientBuilder.build());

    }


    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadId() {
        return mainThread;
    }
}
