package net.m;

import com.alibaba.fastjson.JSON;

/**
 * Created by java on 2018/1/16.
 */

public class NetBean_Me {

    public static NetBean_Me getExample(){
        String json = "{\n" +
                "    \"code\": \"0x00000000\",\n" +
                "    \"data\": {\n" +
                "        \"uid\": \"U201710311724500100596\",\n" +
                "        \"mobile\": \"13123901077\",\n" +
                "        \"icon\": \"http://www.qqzhi.com/uploadpic/2014-10-17/065915361.jpg\",\n" +
                "        \"name\": \"陈老师\"\n" +
                "    },\n" +
                "    \"message\": \"【调用成功】\",\n" +
                "    \"remark\": \"咿啦家园 - 获取老师端和家长端我的信息\",\n" +
                "    \"status\": \"1\"\n" +
                "}";
        return JSON.parseObject(json,NetBean_Me.class);
    }
    /**
     * code : 0x00000000
     * data : {"uid":"U201710311724500100596","mobile":"13123901077","icon":"http://www.qqzhi.com/uploadpic/2014-10-17/065915361.jpg","name":"陈老师"}
     * message : 【调用成功】
     * remark : 咿啦家园 - 获取老师端和家长端我的信息
     * status : 1
     */

    private String code;
    private DataBean data;
    private String message;
    private String remark;
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * uid : U201710311724500100596
         * mobile : 13123901077
         * icon : http://www.qqzhi.com/uploadpic/2014-10-17/065915361.jpg
         * name : 陈老师
         */

        private String uid;
        private String mobile;
        private String icon;
        private String name;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
