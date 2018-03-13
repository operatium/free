package net.m;

/**
 * Created by java on 2017/10/24.
 */

public class NetBean_GetCode extends MessageEvent {


    /**
     * code : 10002002
     * status : 1
     * message : 验证码已发送
     * remark : 发送验证码接口
     * data : {"num":"123456","mobile":"123456"}
     */

    private String code;
    private String status;
    private String message;
    private String remark;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * num : 123456
         * mobile : 123456
         */

        private String num;
        private String mobile;

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
