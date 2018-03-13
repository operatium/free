package net.m;

/**
 * Created by luodi on 2018/1/11.
 */

public class NetBean_Account {

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
        private String vipDesc; // 新增字段，描述阅读体验试用期数量

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

        public String getVipDesc() {
            return vipDesc;
        }

        public void setVipDesc(String vipDesc) {
            this.vipDesc = vipDesc;
        }
    }
}
