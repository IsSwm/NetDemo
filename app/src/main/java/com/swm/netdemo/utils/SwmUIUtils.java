package com.swm.netdemo.utils;


import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.swm.netdemo.app.MyApplication;

/**
 * Created by IsSwm on 2016/8/25.
 */
public class SwmUIUtils {

    //     * 获取上下文
    public static Context getContext() {
        return MyApplication.getContext();
    }

    public static Handler getHandler() {
        return MyApplication.getHandler();
    }

    public static int getMainThreadId() {
        return MyApplication.getMainThreadId();
    }

    //    -----------------  自定义方法  -----------------

    /**
     * 注意：状态栏的高度没有忽略
     * 根据屏幕的大小。重新设置view的宽高
     *
     * @param view          将要改变高度或宽度的 view
     * @param widthPercent  宽度占整个屏幕宽度几份，如，占屏幕1/2，则写2
     * @param heightPercent 高度占整个屏幕高度几份，如，占屏幕1/2，则写2
     */

    public static void setViewHeightOrWidth(View view, int widthPercent, int heightPercent) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (widthPercent != 0) {
            params.width = SwmScreenUtils.getScreenW() / widthPercent;
        }
        if (heightPercent != 0) {
            params.height = SwmScreenUtils.getScreenH() / heightPercent;
        }
        view.setLayoutParams(params);
    }

//    -----------------  加载资源文件  -------------------


    /**
     * 获取类型数组  自定义属性信息
     *
     * @param attr style.xml 中的 declare-styleable 的自定义属性 数组 R.styleable.custom_name
     */
    public static TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

    //    获取 整数资源
    public static int getInteger(@IntegerRes int resId) {
        return getContext().getResources().getInteger(resId);
    }

    //    获取字符串
    public static String getString(int id) {
        return getContext().getResources().getString(id);
    }

    //      获取字符串数组
    public static String[] getStringArray(int id) {
        return getContext().getResources().getStringArray(id);
    }

    //    获取 图片资源
    public static Drawable getDrawable(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getContext().getResources().getDrawable(id, null);
        } else {
            return getContext().getResources().getDrawable(id);
        }
    }

    //    获取 颜色
    public static int getColor(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getContext().getResources().getColor(id, null);
        } else {
            return getContext().getResources().getColor(id);
        }
    }

    //    根据Id 获取 颜色的 状态选择器
    public static ColorStateList getColorStateList(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getContext().getResources().getColorStateList(id, null);
        } else {
            return getContext().getResources().getColorStateList(id);
        }
    }

    //    获取尺寸
    public static int getDimen(int id) {
        return getContext().getResources().getDimensionPixelSize(id);
    }

    //    获取通知栏的高度
    public static float getStasusBarHeight() {
        int identifier = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
//            getDimensionPixelSize 四舍五入  offset  直接舍去  getDimension  原来的摸样精确度高
            return getContext().getResources().getDimensionPixelSize(identifier);
        }
        throw new RuntimeException("获取不到通知栏的高度");
    }

    //    dip 和 px 之间的转换
    public static int dip2px(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f);
    }

    public static int px2dip(float px) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5f);
    }

    //     设置添加屏幕的背景透明度
    public void backgroundAlpha(float bgAlpha, Activity activity) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        activity.getWindow().setAttributes(lp);
    }

    //    -----------------  加载布局文件  -------------------
    public static View inflate(@LayoutRes int resLayoutId, ViewGroup root, boolean attachToRoot) {
        return LayoutInflater.from(getContext()).inflate(resLayoutId, root, attachToRoot);
    }

    //    -----------------  判断是否运行在主线程  -------------------
    public static boolean isRunOnMainThread() {
//        获取当前线程的ID  判断是否和主线程ID 是否一致
        int myTid = android.os.Process.myTid();
        if (myTid == getMainThreadId()) {
            return true;
        }
        return false;
    }

    //          在主线程运行
    public static void runOnUIThread(Runnable runnable) {
        if (isRunOnMainThread()) {
            runnable.run();
        } else {
//            如果是子线程  借助handler 让其运行在主线程
            getHandler().post(runnable);
        }

    }

}
