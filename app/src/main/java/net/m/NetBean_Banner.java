package net.m;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by java on 2018/1/6.
 */

public class NetBean_Banner {

    public static NetBean_Banner getExample(){
        String json = "{\n" +
                "    \"code\": \"0x00000000\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"bannerCode\": \"BA20170919163823\",\n" +
                "            \"bannerTitle\": \"美影厂\",\n" +
                "            \"bannerDesc\": \"美影厂\",\n" +
                "            \"bannerImageUrl\": \"http://book.ellabook.cn/banner-2.png\",\n" +
                "            \"targetType\": \"BOOK_LIST\",\n" +
                "            \"type\": \"PARENT\",\n" +
                "            \"targetPage\": \"ellabook://list.book?sourceCode=P20171031152429&method=ella.book.listBookByPressCode&title=上海美影厂\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"message\": \"【调用失败】\",\n" +
                "    \"remark\": \"获取banner\",\n" +
                "    \"status\": \"1\"\n" +
                "}";
        return JSON.parseObject(json,NetBean_Banner.class);
    }
    /**
     * code : 0x00000000
     * data : [{"bannerCode":"BA20170919163823","bannerTitle":"美影厂","bannerDesc":"美影厂","bannerImageUrl":"http://book.ellabook.cn/banner-2.png","targetType":"BOOK_LIST","type":"PARENT","targetPage":"ellabook://list.book?sourceCode=P20171031152429&method=ella.book.listBookByPressCode&title=上海美影厂"}]
     * message : 【调用失败】
     * remark : 获取老师端banner
     * status : 1
     */

    private String code;
    private String message;
    private String remark;
    private String status;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bannerCode : BA20170919163823
         * bannerTitle : 美影厂
         * bannerDesc : 美影厂
         * bannerImageUrl : http://book.ellabook.cn/banner-2.png
         * targetType : BOOK_LIST
         * type : PARENT
         * targetPage : ellabook://list.book?sourceCode=P20171031152429&method=ella.book.listBookByPressCode&title=上海美影厂
         */

        private String bannerCode;
        private String bannerTitle;
        private String bannerDesc;
        private String bannerImageUrl;
        private String targetType;
        private String type;
        private String targetPage;

        public String getBannerCode() {
            return bannerCode;
        }

        public void setBannerCode(String bannerCode) {
            this.bannerCode = bannerCode;
        }

        public String getBannerTitle() {
            return bannerTitle;
        }

        public void setBannerTitle(String bannerTitle) {
            this.bannerTitle = bannerTitle;
        }

        public String getBannerDesc() {
            return bannerDesc;
        }

        public void setBannerDesc(String bannerDesc) {
            this.bannerDesc = bannerDesc;
        }

        public String getBannerImageUrl() {
            return bannerImageUrl;
        }

        public void setBannerImageUrl(String bannerImageUrl) {
            this.bannerImageUrl = bannerImageUrl;
        }

        public String getTargetType() {
            return targetType;
        }

        public void setTargetType(String targetType) {
            this.targetType = targetType;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTargetPage() {
            return targetPage;
        }

        public void setTargetPage(String targetPage) {
            this.targetPage = targetPage;
        }
    }
}
