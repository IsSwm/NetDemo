package com.swm.netdemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */

public class InfoData extends BaseData{

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-04-10","title":"设计师为iPhone 8设计新概念：这两种虚拟 HOME 键方案，你满意吗？","description":"同步推","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/S67ZPlGTOy3vRwab0ibv79gGkPsqHvX8XEY64zZf6CAUfu7WibH2iaE2ETZs3piaDZicuUhv6L4EmGqOYJkfqML3z0w/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/5D8bSw3nImq0odfNPQQb1Q"},{"ctime":"2017-04-10","title":"赶超papi酱，这几个短视频公众号不仅吸粉千万还变现不断","description":"微果酱","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/52wy0FK91vibakCqVoy1LCXKx9EoHyiab9lLclC49UNCAibF5l5X9WCObCIexSC1cd9xdjn7rWDaTOW8pZWGFJ0sg/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/POI7CP8OrZKHvQO46zeElw"},{"ctime":"2017-04-10","title":"无论查到什么，不要告诉爸爸妈妈","description":"人民日报","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/xrFYciaHL08BEKJvugGOSRMphC7Lm6T1CswsgoKDQiaufqg9kJeibcGibQj4fKq13IEGbvibjpH3tWSIGKF6zoBatjQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/P9rC7W1ZmSYTUa4Y5FwatQ"},{"ctime":"2017-04-10","title":"挺好看的石楠花，为什么闻起来一股\u2026\u2026精液的味道？","description":"果壳网","picUrl":"http://mmbiz.qpic.cn/mmbiz/icZklJrRfHgDdib0VSklY0UdowWibCiaqtYRX4Mzq2ic8qCVQofvq3hx6FI4UHCrF6xkM1hBeyoVpecVxBfCtDdSjqw/640?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/pkP0g0e-67r86JQpIri2lg"},{"ctime":"2017-04-10","title":"对于求职者来说，该如何输出一份好的产品分析","description":"鸟哥笔记","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/AWTVpzlzltqj4Baysib7TdziaWoC8dF8m52bOHZOWCxILOuPhN1xnTR1TUeJGcuDKkxicOgXP7CPomEBia7gX5VZYg/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/FT45_0D_Ck_ADvB-IWl3og"},{"ctime":"2017-04-10","title":"拖延这件小事 讨论一次就够了","description":"拉勾网Lagou","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/Mrzzl4KuLapX40xicib0oGA58OqeE5n0DvfDpk8q2pI5eDr65MzviaiaFibAxB4icEL2D3icjCNhUyDc6IW4gv6XnC1sw/640?wx_fmt=png","url":"http://mp.weixin.qq.com/s/zsFkigDTyDBCU9dxzpO01w"},{"ctime":"2017-04-10","title":"人民的名义：在\u201c成功\u201d男人的世界里，为什么没有女人？","description":"心之助","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/Yhz6q8ib1jSRGuXMUZEONhusUVtKicHzF6Y94mWPJEB77EymWM9hpDj3X94WExRvzeiaJHkjvETIouq4zJ91QS7gw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/x7GcS0rWR1VOCetZFqPUTw"},{"ctime":"2017-03-29","title":"一个比日本还要可怕的国家","description":"看见","picUrl":"http://mmbiz.qpic.cn/mmbiz/SL01kv8vjY1mHkE5jzb9Wo13krFxE4M8ylqpgbRNrf7Y2uYZBAuUScFibm5pgCaDlBJibPRtKudLohVave1Y6KyA/640?wx_fmt=jpegx26amp","url":"http://mp.weixin.qq.com/s/AsFk5mccfREaLQSODPEwXQ"},{"ctime":"2017-03-29","title":"最新！上海紫色交通卡能在20城通用！周边游约起！","description":"这里是上海","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/BJLG44l0uqoz5DW8ycZEh4RFyvxu2oeibcxH5Lvke4aUGOAV7piaiaRVaQyAD3B1KARNUPkQ6u26opGTg1oja0lRw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/ddZHAudcKhCuJI7oiqu8_Q"},{"ctime":"2017-03-27","title":"谁说只有会计才能管财务？这家公司就是要让任何人都能管理财务","description":"知家","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/AnpHrdpe5icQcL58c1z2AoA7hQaniaQfM1oTRIGzSov6DsESciaENV26UhrjUntZvrdABfGDN2DTzPgp32u56rJJA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/IbLxiJOUbimZjwAmlO716Q"}]
     */

    private int code;
    private String msg;
    /**
     * ctime : 2017-04-10
     * title : 设计师为iPhone 8设计新概念：这两种虚拟 HOME 键方案，你满意吗？
     * description : 同步推
     * picUrl : http://mmbiz.qpic.cn/mmbiz_jpg/S67ZPlGTOy3vRwab0ibv79gGkPsqHvX8XEY64zZf6CAUfu7WibH2iaE2ETZs3piaDZicuUhv6L4EmGqOYJkfqML3z0w/0?wx_fmt=jpeg
     * url : http://mp.weixin.qq.com/s/5D8bSw3nImq0odfNPQQb1Q
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
