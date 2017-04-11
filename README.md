# NetDemo
Android网络请求封装，请求网络只需几行就可以搞定
//        InfoData   基于请求网络返回的 json数据 实体类。
详情见另一篇》[GsonFormat，Json实体类快速生产的插件](http://www.jianshu.com/p/203ab7fe660c)

```
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
```

