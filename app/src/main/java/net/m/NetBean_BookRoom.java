package net.m;

import java.util.List;

/**
 * Created by java on 2018/3/5.
 */

public class NetBean_BookRoom extends MessageEvent {


    /**
     * code : 00000000
     * data : [{"id":2,"uid":"123123","bookCode":"B201710250002","userType":"TEACHER","bookType":"COURSE_IN","useStartTime":null,"useEndTime":null,"useStatus":null,"readStatus":"NOT_READ","readNum":null,"openNum":null,"createTime":1519978010000,"updateTime":null,"bookName":"动态阅读2-3彩色世界","coverUrl":"http://book.ellabook.cn/097af74461234185b559981adfd4c167","previewUrl":null,"resourcesUrl":"http://book.ellabook.cn/032b14ef49ab4e4bacb9dfe251b323b0"},{"id":1,"uid":"123123","bookCode":"B201710250001","userType":"TEACHER","bookType":"COURSE_IN","useStartTime":null,"useEndTime":null,"useStatus":null,"readStatus":"NOT_READ","readNum":null,"openNum":null,"createTime":1519974445000,"updateTime":null,"bookName":"动态阅读7-2惜福与丰收","coverUrl":"http://book.ellabook.cn/XF20171213105728","previewUrl":null,"resourcesUrl":"http://book.ellabook.cn/5b6507d901244ffab61d9a0c1ab763db"}]
     * message : 调用成功
     * remark : 获取书房列表
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
         * id : 2
         * uid : 123123
         * bookCode : B201710250002
         * userType : TEACHER
         * bookType : COURSE_IN
         * useStartTime : null
         * useEndTime : null
         * useStatus : null
         * readStatus : NOT_READ
         * readNum : null
         * openNum : null
         * createTime : 1519978010000
         * updateTime : null
         * bookName : 动态阅读2-3彩色世界
         * coverUrl : http://book.ellabook.cn/097af74461234185b559981adfd4c167
         * previewUrl : null
         * resourcesUrl : http://book.ellabook.cn/032b14ef49ab4e4bacb9dfe251b323b0
         */

        private int id;
        private String uid;
        private String bookCode;
        private String userType;
        private String bookType;
        private Object useStartTime;
        private Object useEndTime;
        private Object useStatus;
        private String readStatus;
        private Object readNum;
        private Object openNum;
        private long createTime;
        private Object updateTime;
        private String bookName;
        private String coverUrl;
        private Object previewUrl;
        private String resourcesUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getBookCode() {
            return bookCode;
        }

        public void setBookCode(String bookCode) {
            this.bookCode = bookCode;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getBookType() {
            return bookType;
        }

        public void setBookType(String bookType) {
            this.bookType = bookType;
        }

        public Object getUseStartTime() {
            return useStartTime;
        }

        public void setUseStartTime(Object useStartTime) {
            this.useStartTime = useStartTime;
        }

        public Object getUseEndTime() {
            return useEndTime;
        }

        public void setUseEndTime(Object useEndTime) {
            this.useEndTime = useEndTime;
        }

        public Object getUseStatus() {
            return useStatus;
        }

        public void setUseStatus(Object useStatus) {
            this.useStatus = useStatus;
        }

        public String getReadStatus() {
            return readStatus;
        }

        public void setReadStatus(String readStatus) {
            this.readStatus = readStatus;
        }

        public Object getReadNum() {
            return readNum;
        }

        public void setReadNum(Object readNum) {
            this.readNum = readNum;
        }

        public Object getOpenNum() {
            return openNum;
        }

        public void setOpenNum(Object openNum) {
            this.openNum = openNum;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public Object getPreviewUrl() {
            return previewUrl;
        }

        public void setPreviewUrl(Object previewUrl) {
            this.previewUrl = previewUrl;
        }

        public String getResourcesUrl() {
            return resourcesUrl;
        }

        public void setResourcesUrl(String resourcesUrl) {
            this.resourcesUrl = resourcesUrl;
        }
    }
}
