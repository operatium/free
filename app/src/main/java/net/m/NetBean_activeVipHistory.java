package net.m;

import java.util.List;

/**
 * @autor hongbing
 * @date 2018/3/12
 */
public class NetBean_activeVipHistory {

    /**
     * normal类型
     */
    public static final int TYPE_NORMAL = 0;
    /**
     * footer类型
     */
    public static final int TYPE_FOOTER = 1;

    /**
     * code : 0x00000000
     * data : [{"vipEndTime":"2019-03-09","activeDays":365,"useTime":"2018/3/9"}]
     * message : 【调用成功】
     * remark : VIP兑换码激活历史接口
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
         * vipEndTime : 2019-03-09
         * activeDays : 365
         * useTime : 2018/3/9
         */

        private String vipEndTime;
        private int activeDays;
        private String useTime;
        private int itemType;

        public String getVipEndTime() {
            return vipEndTime;
        }

        public void setVipEndTime(String vipEndTime) {
            this.vipEndTime = vipEndTime;
        }

        public int getActiveDays() {
            return activeDays;
        }

        public void setActiveDays(int activeDays) {
            this.activeDays = activeDays;
        }

        public String getUseTime() {
            return useTime;
        }

        public void setUseTime(String useTime) {
            this.useTime = useTime;
        }

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }
    }
}
