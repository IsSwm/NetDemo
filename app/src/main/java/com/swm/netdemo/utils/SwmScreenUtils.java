package com.swm.netdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 *
 */
public class SwmScreenUtils {
    private static int screenW;
    private static int screenH;

    public static int getScreenW() {
        if (screenW == 0) {
            initScreen();
        }
        return screenW;
    }

    public static int getScreenH() {
        if (screenH == 0) {
            initScreen();
        }
        return screenH;
    }

    private static void initScreen() {
        WindowManager wm = (WindowManager) SwmUIUtils.getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        screenW = outMetrics.widthPixels;
        screenH = outMetrics.heightPixels;
    }


    //    获取通知栏的高度
    public static float getStasusBarHeight() {
        int identifier = SwmUIUtils.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
//            getDimensionPixelSize 四舍五入  offset  直接舍去  getDimension  原来的摸样精确度高
            return SwmUIUtils.getContext().getResources().getDimensionPixelSize(identifier);
        }
        throw new RuntimeException("获取不到通知栏的高度");
    }

    /**
     * 获取当前屏幕截图，包含状态栏
     *
     * @return
     */
    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int width = getScreenW();
        int height = getScreenH();
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
        view.destroyDrawingCache();
        return bp;

    }

    /**
     * 获取当前屏幕截图，不包含状态栏
     *
     * @param activity
     * @return
     */
    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = getScreenW();
        int height = getScreenH();
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
                - statusBarHeight);
        view.destroyDrawingCache();
        return bp;

    }
}
