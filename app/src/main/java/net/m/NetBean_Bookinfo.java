package net.m;

/**
 * Created by Administrator on 2017/11/7.
 */

public class NetBean_Bookinfo extends MessageEvent {
    /**
     * result : true
     * code : 0
     * data : {"bookId":1,"bookAuthor":"霍梦露 张月","bookPage":22,"bookSize":"39.39M","bookPress":"康轩书店","bookAge":-2,"bookIntroduction":"兔奶奶有一件特别漂亮的花旗袍。可惜，兔奶奶年纪大了，穿不下了。于是，兔奶奶决定用它给兔宝宝做一件礼物。会是什么呢？我们打开这本，一起去看看这些温馨的故事吧！","avgScore":5,"bookPrice":0.99,"bookmarketPrice":8,"bookName":"动态阅读7-2惜福与丰收","orderId":37829,"bookListenUrl":null,"bookReadUrl":null,"bookPlayUrl":"http://book.ellabook.cn/5b6507d901244ffab61d9a0c1ab763db","bookMakeUrl":null,"bookCoverUrl":"http://book.ellabook.cn/50fe32396e664efeb6f48e7a2a7bdc2b","bookViewUrl":"http://book.ellabook.cn/350d612a555142e0914d08e484ba07ac","goodsState":1,"goodsVerify":1,"osskeyList":{},"ossbucket":"ellabook-book","osskey":"5b6507d901244ffab61d9a0c1ab763db","iosPriceId":"com.diandu.ellabook.bookprice_1_0","bookDownloadSize":41300484,"pressId":23,"gcId":1086,"remainTime":1956134,"videoAddress":"s05280u546d","topicClassCode":"18","domainClassCode":"06","subDomainClassCode":"0601"}
     * isVip : true
     * desc : success
     */

    private boolean result;
    private int code;
    private DataBean data;
    private boolean isVip;
    private String desc;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isIsVip() {
        return isVip;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static class DataBean {
        /**
         * bookId : 1
         * bookAuthor : 霍梦露 张月
         * bookPage : 22
         * bookSize : 39.39M
         * bookPress : 康轩书店
         * bookAge : -2
         * bookIntroduction : 兔奶奶有一件特别漂亮的花旗袍。可惜，兔奶奶年纪大了，穿不下了。于是，兔奶奶决定用它给兔宝宝做一件礼物。会是什么呢？我们打开这本，一起去看看这些温馨的故事吧！
         * avgScore : 5.0
         * bookPrice : 0.99
         * bookmarketPrice : 8.0
         * bookName : 动态阅读7-2惜福与丰收
         * orderId : 37829
         * bookListenUrl : null
         * bookReadUrl : null
         * bookPlayUrl : http://book.ellabook.cn/5b6507d901244ffab61d9a0c1ab763db
         * bookMakeUrl : null
         * bookCoverUrl : http://book.ellabook.cn/50fe32396e664efeb6f48e7a2a7bdc2b
         * bookViewUrl : http://book.ellabook.cn/350d612a555142e0914d08e484ba07ac
         * goodsState : 1
         * goodsVerify : 1
         * osskeyList : {}
         * ossbucket : ellabook-book
         * osskey : 5b6507d901244ffab61d9a0c1ab763db
         * iosPriceId : com.diandu.ellabook.bookprice_1_0
         * bookDownloadSize : 41300484
         * pressId : 23
         * gcId : 1086
         * remainTime : 1956134
         * videoAddress : s05280u546d
         * topicClassCode : 18
         * domainClassCode : 06
         * subDomainClassCode : 0601
         */

        private int bookId;
        private String bookAuthor;
        private int bookPage;
        private String bookSize;
        private String bookPress;
        private int bookAge;
        private String bookIntroduction;
        private double avgScore;
        private double bookPrice;
        private double bookmarketPrice;
        private String bookName;
        private int orderId;
        private Object bookListenUrl;
        private Object bookReadUrl;
        private String bookPlayUrl;
        private Object bookMakeUrl;
        private String bookCoverUrl;
        private String bookViewUrl;
        private int goodsState;
        private int goodsVerify;
        private OsskeyListBean osskeyList;
        private String ossbucket;
        private String osskey;
        private String iosPriceId;
        private int bookDownloadSize;
        private int pressId;
        private int gcId;
        private int remainTime;
        private String videoAddress;
        private String topicClassCode;
        private String domainClassCode;
        private String subDomainClassCode;

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public String getBookAuthor() {
            return bookAuthor;
        }

        public void setBookAuthor(String bookAuthor) {
            this.bookAuthor = bookAuthor;
        }

        public int getBookPage() {
            return bookPage;
        }

        public void setBookPage(int bookPage) {
            this.bookPage = bookPage;
        }

        public String getBookSize() {
            return bookSize;
        }

        public void setBookSize(String bookSize) {
            this.bookSize = bookSize;
        }

        public String getBookPress() {
            return bookPress;
        }

        public void setBookPress(String bookPress) {
            this.bookPress = bookPress;
        }

        public int getBookAge() {
            return bookAge;
        }

        public void setBookAge(int bookAge) {
            this.bookAge = bookAge;
        }

        public String getBookIntroduction() {
            return bookIntroduction;
        }

        public void setBookIntroduction(String bookIntroduction) {
            this.bookIntroduction = bookIntroduction;
        }

        public double getAvgScore() {
            return avgScore;
        }

        public void setAvgScore(double avgScore) {
            this.avgScore = avgScore;
        }

        public double getBookPrice() {
            return bookPrice;
        }

        public void setBookPrice(double bookPrice) {
            this.bookPrice = bookPrice;
        }

        public double getBookmarketPrice() {
            return bookmarketPrice;
        }

        public void setBookmarketPrice(double bookmarketPrice) {
            this.bookmarketPrice = bookmarketPrice;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public Object getBookListenUrl() {
            return bookListenUrl;
        }

        public void setBookListenUrl(Object bookListenUrl) {
            this.bookListenUrl = bookListenUrl;
        }

        public Object getBookReadUrl() {
            return bookReadUrl;
        }

        public void setBookReadUrl(Object bookReadUrl) {
            this.bookReadUrl = bookReadUrl;
        }

        public String getBookPlayUrl() {
            return bookPlayUrl;
        }

        public void setBookPlayUrl(String bookPlayUrl) {
            this.bookPlayUrl = bookPlayUrl;
        }

        public Object getBookMakeUrl() {
            return bookMakeUrl;
        }

        public void setBookMakeUrl(Object bookMakeUrl) {
            this.bookMakeUrl = bookMakeUrl;
        }

        public String getBookCoverUrl() {
            return bookCoverUrl;
        }

        public void setBookCoverUrl(String bookCoverUrl) {
            this.bookCoverUrl = bookCoverUrl;
        }

        public String getBookViewUrl() {
            return bookViewUrl;
        }

        public void setBookViewUrl(String bookViewUrl) {
            this.bookViewUrl = bookViewUrl;
        }

        public int getGoodsState() {
            return goodsState;
        }

        public void setGoodsState(int goodsState) {
            this.goodsState = goodsState;
        }

        public int getGoodsVerify() {
            return goodsVerify;
        }

        public void setGoodsVerify(int goodsVerify) {
            this.goodsVerify = goodsVerify;
        }

        public OsskeyListBean getOsskeyList() {
            return osskeyList;
        }

        public void setOsskeyList(OsskeyListBean osskeyList) {
            this.osskeyList = osskeyList;
        }

        public String getOssbucket() {
            return ossbucket;
        }

        public void setOssbucket(String ossbucket) {
            this.ossbucket = ossbucket;
        }

        public String getOsskey() {
            return osskey;
        }

        public void setOsskey(String osskey) {
            this.osskey = osskey;
        }

        public String getIosPriceId() {
            return iosPriceId;
        }

        public void setIosPriceId(String iosPriceId) {
            this.iosPriceId = iosPriceId;
        }

        public int getBookDownloadSize() {
            return bookDownloadSize;
        }

        public void setBookDownloadSize(int bookDownloadSize) {
            this.bookDownloadSize = bookDownloadSize;
        }

        public int getPressId() {
            return pressId;
        }

        public void setPressId(int pressId) {
            this.pressId = pressId;
        }

        public int getGcId() {
            return gcId;
        }

        public void setGcId(int gcId) {
            this.gcId = gcId;
        }

        public int getRemainTime() {
            return remainTime;
        }

        public void setRemainTime(int remainTime) {
            this.remainTime = remainTime;
        }

        public String getVideoAddress() {
            return videoAddress;
        }

        public void setVideoAddress(String videoAddress) {
            this.videoAddress = videoAddress;
        }

        public String getTopicClassCode() {
            return topicClassCode;
        }

        public void setTopicClassCode(String topicClassCode) {
            this.topicClassCode = topicClassCode;
        }

        public String getDomainClassCode() {
            return domainClassCode;
        }

        public void setDomainClassCode(String domainClassCode) {
            this.domainClassCode = domainClassCode;
        }

        public String getSubDomainClassCode() {
            return subDomainClassCode;
        }

        public void setSubDomainClassCode(String subDomainClassCode) {
            this.subDomainClassCode = subDomainClassCode;
        }

        public static class OsskeyListBean {
        }
    }
}
