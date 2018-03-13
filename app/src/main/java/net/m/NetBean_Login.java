package net.m;

/**
 * Created by java on 2017/10/24.
 */

public class NetBean_Login extends MessageEvent {


    /**
     * code : 10001008
     * data : {"uid":"HT20180105200436120669","mobile":"18668406446","userType":"teacher","hasClass":"has"}
     * message : 登录成功
     * remark : 用户手机号登录接口
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
         * uid : HT20180105200436120669
         * mobile : 18668406446
         * userType : teacher
         * hasClass : has
         */

        private String uid;
        private String mobile;
        private String userType;
        private String hasClass;

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

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getHasClass() {
            return hasClass;
        }

        public void setHasClass(String hasClass) {
            this.hasClass = hasClass;
        }
    }
}
