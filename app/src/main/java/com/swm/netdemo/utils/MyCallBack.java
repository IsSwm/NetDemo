package com.swm.netdemo.utils;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by IsSwm on 2017/3/25.
 * 请求到数据的时候 接口返回数据或者异常。
 */

public class MyCallBack extends Callback {

    private Class entityClass;
    private RequestOver mRequestOver;

    public MyCallBack(Class entityClass, RequestOver requestOver) {
        this.entityClass = entityClass;
        mRequestOver = requestOver;
    }

//    请求成功或者失败的接口回调
    public interface RequestOver {
        void requestSuccess(Object data);
        void requestFail(Exception e);
    }

    @Override
    public Object parseNetworkResponse(Response response, int id) throws Exception {
        String jsonData = response.body().string();
        return jsonData;
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        mRequestOver.requestFail(e);
    }


    @Override
    public void onResponse(Object response, int id) {
//        将返回的json 数据 改变成 实体类
        String json = response.toString();
        Object data = new Gson().fromJson(json, entityClass);
        mRequestOver.requestSuccess(data);
    }


}
