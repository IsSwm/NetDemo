package com.swm.netdemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author MaTianyu
 * @date 2014-07-31
 */
public class SwmToastUtils {

    private static Toast mToast;
    private static Context context = SwmUIUtils.getContext();


    //  获取 一个单独的toast
    public static Toast getSingletonToast(int resId) {
        if (mToast == null) {
            mToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(resId);
        }
        return mToast;
    }

    public static Toast getSingletonToast(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        return mToast;
    }

    public static Toast getSingleLongToast(int resId) {
        if (mToast == null) {
            mToast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
        } else {
            mToast.setText(resId);
        }
        return mToast;
    }

    public static Toast getSingleLongToast(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        } else {
            mToast.setText(text);
        }
        return mToast;
    }

    public static Toast getToast(int resId) {
        return Toast.makeText(context, resId, Toast.LENGTH_SHORT);
    }

    public static Toast getToast(String text) {
        return Toast.makeText(context, text, Toast.LENGTH_SHORT);
    }

    public static Toast getLongToast(int resId) {
        return Toast.makeText(context, resId, Toast.LENGTH_LONG);
    }

    public static Toast getLongToast(String text) {
        return Toast.makeText(context, text, Toast.LENGTH_LONG);
    }

    public static void showSingletonToast(int resId) {
        getSingletonToast(resId).show();
    }


    public static void showSingletonToast(String text) {
        getSingletonToast(text).show();
    }

    public static void showSingleLongToast(int resId) {
        getSingleLongToast(resId).show();
    }


    public static void showSingleLongToast(String text) {
        getSingleLongToast(text).show();
    }

    public static void showToast(int resId) {
        getToast(resId).show();
    }

    public static void showToast(String text) {
        getToast(text).show();
    }

    public static void showLongToast(int resId) {
        getLongToast(resId).show();
    }

    public static void showLongToast(String text) {
        getLongToast(text).show();
    }

}
