package net.m;

/**
 * Created by java on 2018/3/5.
 */

public class NetBean_AddBookToStudy extends MessageEvent {

    /**
     * code : 00000000
     * data : 1
     * message : 调用成功
     * remark : 新增图书到书房
     * status : 1
     */

    private String code;
    private int data;
    private String message;
    private String remark;
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
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
}
