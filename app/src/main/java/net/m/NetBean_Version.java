package net.m;

import com.alibaba.fastjson.JSON;

/**
 * Created by java on 2018/1/17.
 */

public class NetBean_Version extends MessageEvent{

    public static NetBean_Version getExample(){
        String json = "{\n" +
                "    \"code\": \"0x00000000\",\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"versionResource\": \"android\",\n" +
                "        \"versionNum\": \"0.0.1\",\n" +
                "        \"versionAddtime\": 1466670959000,\n" +
                "        \"versionFilepath\": \"ellabook-book\",\n" +
                "        \"versionUrl\": \"https://www.baidu.com/?tn=02003390_3_hao_pg\",\n" +
                "        \"versionFilename\": \"f141bb2d2b8a4100b3aee0f405fe926b.apk\",\n" +
                "        \"versionDescription\": \"最新版本\"\n" +
                "    },\n" +
                "    \"message\": \"【调用成功】\",\n" +
                "    \"remark\": \"咿啦家园 - 版本控制\",\n" +
                "    \"status\": \"1\"\n" +
                "}";
        return JSON.parseObject(json,NetBean_Version.class);
    }

    /**
     * code : 0x00000000
     * data : {"id":1,"versionResource":"android","versionNum":"0.0.1","versionAddtime":1466670959000,"versionFilepath":"ellabook-book","versionUrl":"https://www.baidu.com/?tn=02003390_3_hao_pg","versionFilename":"f141bb2d2b8a4100b3aee0f405fe926b.apk","versionDescription":"最新版本"}
     * message : 【调用成功】
     * remark : 咿啦家园 - 版本控制
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
         * id : 1
         * versionResource : android
         * versionNum : 0.0.1
         * versionAddtime : 1466670959000
         * versionFilepath : ellabook-book
         * versionUrl : https://www.baidu.com/?tn=02003390_3_hao_pg
         * versionFilename : f141bb2d2b8a4100b3aee0f405fe926b.apk
         * versionDescription : 最新版本
         */

        private int id;
        private String versionResource;
        private String versionNum;
        private long versionAddtime;
        private String versionFilepath;
        private String versionUrl;
        private String versionFilename;
        private String versionDescription;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVersionResource() {
            return versionResource;
        }

        public void setVersionResource(String versionResource) {
            this.versionResource = versionResource;
        }

        public String getVersionNum() {
            return versionNum;
        }

        public void setVersionNum(String versionNum) {
            this.versionNum = versionNum;
        }

        public long getVersionAddtime() {
            return versionAddtime;
        }

        public void setVersionAddtime(long versionAddtime) {
            this.versionAddtime = versionAddtime;
        }

        public String getVersionFilepath() {
            return versionFilepath;
        }

        public void setVersionFilepath(String versionFilepath) {
            this.versionFilepath = versionFilepath;
        }

        public String getVersionUrl() {
            return versionUrl;
        }

        public void setVersionUrl(String versionUrl) {
            this.versionUrl = versionUrl;
        }

        public String getVersionFilename() {
            return versionFilename;
        }

        public void setVersionFilename(String versionFilename) {
            this.versionFilename = versionFilename;
        }

        public String getVersionDescription() {
            return versionDescription;
        }

        public void setVersionDescription(String versionDescription) {
            this.versionDescription = versionDescription;
        }
    }
}
