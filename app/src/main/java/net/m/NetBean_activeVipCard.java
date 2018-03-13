package net.m;

/**
 * @autor hongbing
 * @date 2018/3/10
 */
public class NetBean_activeVipCard {

    /**
     * code : 0x00000000
     * data : null
     * message : 【调用成功】
     * remark : VIP兑换码激活接口
     * status : 1
     */

    private String code;
    private Object data;
    private String message;
    private String remark;
    private String status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
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
