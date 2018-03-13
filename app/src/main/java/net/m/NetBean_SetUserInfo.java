package net.m;

import com.alibaba.fastjson.JSON;

/**
 * Created by java on 2018/1/17.
 */

public class NetBean_SetUserInfo {

    public static NetBean_SetUserInfo getExample(){
        String json = "{\n" +
                "    \"code\": \"0x00000000\",\n" +
                "    \"data\": null,\n" +
                "    \"message\": \"【调用成功】\",\n" +
                "    \"remark\": \"咿啦家园 - 修改老师端和家长端我的头像或者昵称信息\",\n" +
                "    \"status\": \"1\"\n" +
                "}";
        return JSON.parseObject(json,NetBean_SetUserInfo.class);
    }

    /**
     * code : 0x00000000
     * data : null
     * message : 【调用成功】
     * remark : 咿啦家园 - 修改老师端和家长端我的头像或者昵称信息
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
