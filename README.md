# NetDemo
Android请求服务器对返回的JSON数据封装,只需几行代码就可以得到JSON实体类的操作

//        InfoData   基于请求网络返回的 json数据 实体类。实体类统一继承BaseData基类，最后通过强转为SwmOkhttpNetUtils构造方法参数，如InfoData，得到你想要的json实体类数据
详情见另一篇》[GsonFormat，Json实体类快速生产的插件](http://www.jianshu.com/p/203ab7fe660c)

```
        mInfoUtils = new SwmOkhttpNetUtils(InfoData.class)
//                 get 方式 请求   参数 为  请求网络地址
                .getRequestFromServer(requestUrl += page)
//                设置  请求成功 或者失败的回调。
                .setMyIsRequestCompleteListener(new SwmOkhttpNetUtils.MyIsRequestCompleteListener() {
//                         请求网络 成功，将返回的基类转换为SwmOkhttpNetUtils构造参数的JSON实体类
                    @Override
                    public void requestNetSuccess(BaseData baseData) {
//                        将返回的 基类BaseData  转换为实际使用的 InfoData
                        InfoData infoData = (InfoData) baseData;
//                        获取到数据
                        List<InfoData.NewslistBean> newslist = infoData.getNewslist();
                        // 将数据 添加到  是适配器中
                        mInfoDataAdapter.addData(newslist);
                        mInfoDataAdapter.loadMoreComplete();
                    }
//                      请求服务器失败，需要做的一些事情、
                    @Override
                    public void requestNetFail(Exception e) {
                        mProgress.setVisibility(View.GONE);
                    }
                });
```

PS:对于DEMO中的ImageView我没有用[Glide](https://github.com/bumptech/glide)做处理，主要是请求网络返回JSON的数据实体类封装。

如有困惑，请M我，我会尽我所学帮助你。
[点我进我简书查看更多内容,进步不止于现在](http://www.jianshu.com/u/9279ddcfdfb3)
