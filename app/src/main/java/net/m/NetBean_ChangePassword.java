package net.m;

/**
 * Created by java on 2018/1/6.
 */

public class NetBean_ChangePassword {

    /**
     * code : 10001018
     * status : 1
     * message : 密码重置成功，请使用新密码登录
     * remark : 重置密码接口
     * data : null
     */

    private String code;
    private String status;
    private String message;
    private String remark;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
