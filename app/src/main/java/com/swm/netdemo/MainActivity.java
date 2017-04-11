package com.swm.netdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.swm.netdemo.bean.BaseData;
import com.swm.netdemo.bean.InfoData;
import com.swm.netdemo.utils.SwmOkhttpNetUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwmOkhttpNetUtils mInfoUtils;
    //    请求数据的网址
    private String requestUrl = "https://api.tianapi.com/wxnew/?key=5ba936cc4d870182b30882e314f72134&num=5&page=";
    //    requestUrl 后面的 page参数
//    代表查询的页数
    private int page = 1;

    private List<InfoData.NewslistBean> mInfoBeen = new ArrayList<>();
    private RecyclerView mInfo_recycler;
    private InfoDataAdapter mInfoDataAdapter;
    private ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInfo_recycler = (RecyclerView) findViewById(R.id.info_recycler);
        mProgress = (ProgressBar) findViewById(R.id.progress);

//        初始化 适配器 为 recyclerView设置 适配器
        mInfoDataAdapter = new InfoDataAdapter();
        mInfo_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mInfo_recycler.setAdapter(mInfoDataAdapter);

//        加载数据
        loadData();

//        为 recyclerView的适配器  设置加载更多请求。
        mInfoDataAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                isShowOrGone(mProgress, true);
                page++;
                String url = requestUrl + page;
//                从网络请求数据
                mInfoUtils.getRequestFromServer(url);
            }
        }, mInfo_recycler);
    }


    //    从网络 加载数据
    public void loadData() {
//        InfoData   基于请求网络返回的 json 实体类。
        mInfoUtils = new SwmOkhttpNetUtils(InfoData.class)
//                 get 方式 请求   参数 为  请求网络地址
                .getRequestFromServer(requestUrl += page)
//                设置  请求成功 或者失败的回调。
                .setMyIsRequestCompleteListener(new SwmOkhttpNetUtils.MyIsRequestCompleteListener() {

                    @Override
                    public void requestNetSuccess(BaseData baseData) {
//                        隐藏进度条
                        mProgress.setVisibility(View.GONE);
//                        将返回的 基类BaseData  转换为实际使用的 InfoData
                        InfoData infoData = (InfoData) baseData;
//                        获取到数据
                        List<InfoData.NewslistBean> newslist = infoData.getNewslist();
                        // 将数据 添加到  是适配器中
                        mInfoDataAdapter.addData(newslist);
                        mInfoDataAdapter.loadMoreComplete();
                    }

                    @Override
                    public void requestNetFail(Exception e) {
                        mProgress.setVisibility(View.GONE);
                    }
                });
    }

    //    主内容的适配器
    public class InfoDataAdapter extends BaseQuickAdapter<InfoData.NewslistBean, BaseViewHolder> {
        public InfoDataAdapter() {
            super(R.layout.info_layout, mInfoBeen);
        }

        @Override
        protected void convert(BaseViewHolder viewHolder, final InfoData.NewslistBean item) {
            viewHolder.setText(R.id.newhouse_area_name, item.getTitle());
            viewHolder.setText(R.id.newhouse_notice, item.getDescription());
        }
    }

//    隐藏或者显示 某个view
    private void isShowOrGone(View view, boolean isShow) {
        if (isShow) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

}
