package com.swm.netdemo.utils;

import com.swm.netdemo.bean.BaseData;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.LinkedHashMap;


/**
 * Created by IsSwm on 2017/3/15.
 */

public class SwmOkhttpNetUtils {

    public SwmOkhttpNetUtils() {
    }
    private MyCallBack myCallBack;

//    参数aClass 为你接受Json数据实体类。
    public SwmOkhttpNetUtils(Class<?> aClass) {
//        初始化 callBack
        myCallBack = new MyCallBack(aClass, new MyCallBack.RequestOver() {
            @Override
            public void requestSuccess(Object data) {
//                强转为基类
                BaseData baseData = (BaseData) data;
                isRequestComplete.requestNetSuccess(baseData);
            }

            @Override
            public void requestFail(Exception e) {
                SwmToastUtils.showToast("未连接到服务器");
                isRequestComplete.requestNetFail(e);
            }
        });
    }

    //    请求完成 监听
    public interface MyIsRequestCompleteListener {
        void requestNetSuccess(BaseData baseData);

        void requestNetFail(Exception e);
    }

    MyIsRequestCompleteListener isRequestComplete;

//    设置
    public SwmOkhttpNetUtils setMyIsRequestCompleteListener(MyIsRequestCompleteListener isRequestComplete) {
        this.isRequestComplete = isRequestComplete;
        return this;
    }

    //  使用 GET  请求方式 提交数据到服务器
    public SwmOkhttpNetUtils getRequestFromServer(String requestUrl) {
        OkHttpUtils
                .get()
                .url(requestUrl)
                .build()
                .execute(myCallBack);
        return this;
    }

    /**
    * 使用 POST 请求方式 提交数据到服务器
     * @param params 请求是body
     */
    public void postRequestFromServer(String requestUrl, LinkedHashMap<String, String> params) {
        OkHttpUtils.post().params(params).url(requestUrl).build().execute(myCallBack);
    }

}