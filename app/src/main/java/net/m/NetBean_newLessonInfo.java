package net.m;

import java.util.List;

/**
 * Created by java on 2018/1/18.
 */

public class NetBean_newLessonInfo {

    /**
     * code : 0x00000000
     * data : {"bookCode":"B201710250329","bookName":"卖火柴的小女孩","applicableClass":"中班","bookPage":15,"tag":"卖火柴的小女孩","taskType":"阅读拍照","remark":"冬天，有一个穿着补丁","target":"阅读理解，有感悟","preparation":"课前预习","process":"课上阅读观看-课下复习观看","activityExtension":"和爸爸妈妈一起读咿啦看书","coverUrl":"http://book.ellabook.cn/4028e1116b994a9e91dd618ed357a527","previewUrlList":["http://book.ellabook.cn/B201710250329-12.jpg","http://book.ellabook.cn/B201710250329-4.jpg","http://book.ellabook.cn/B201710250329-5.jpg"],"resourcesUrl":"http://book.ellabook.cn/87c48cae0bf2415293bbd8a6bf45b825","readNum":939,"courseType":"IN","createTime":1515054534000,"updateTime":1515054534000,"state":"NORMAL","issue":"0","taskState":"0","taskWorth":"0","semester":"LASTSEMESTER","weekNum":"11","released":"1","taskCode":null,"bookType":"COURSE_IN"}
     * message : 【调用成功】
     * remark : 咿啦家园 - 获取课程详情
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
         * bookCode : B201710250329
         * bookName : 卖火柴的小女孩
         * applicableClass : 中班
         * bookPage : 15
         * tag : 卖火柴的小女孩
         * taskType : 阅读拍照
         * remark : 冬天，有一个穿着补丁
         * target : 阅读理解，有感悟
         * preparation : 课前预习
         * process : 课上阅读观看-课下复习观看
         * activityExtension : 和爸爸妈妈一起读咿啦看书
         * coverUrl : http://book.ellabook.cn/4028e1116b994a9e91dd618ed357a527
         * previewUrlList : ["http://book.ellabook.cn/B201710250329-12.jpg","http://book.ellabook.cn/B201710250329-4.jpg","http://book.ellabook.cn/B201710250329-5.jpg"]
         * resourcesUrl : http://book.ellabook.cn/87c48cae0bf2415293bbd8a6bf45b825
         * readNum : 939
         * courseType : IN
         * createTime : 1515054534000
         * updateTime : 1515054534000
         * state : NORMAL
         * issue : 0
         * taskState : 0
         * taskWorth : 0
         * semester : LASTSEMESTER
         * weekNum : 11
         * released : 1
         * taskCode : null
         * bookType : COURSE_IN
         */

        private String bookCode;
        private String bookName;
        private String applicableClass;
        private int bookPage;
        private String tag;
        private String taskType;
        private String remark;
        private String target;
        private String preparation;
        private String process;
        private String activityExtension;
        private String coverUrl;
        private String resourcesUrl;
        private int readNum;
        private String courseType;
        private long createTime;
        private long updateTime;
        private String state;
        private String issue;
        private String taskState;
        private String taskWorth;
        private String semester;
        private String weekNum;
        private String released;
        private Object taskCode;
        private String bookType;
        private List<String> previewUrlList;

        public String getBookCode() {
            return bookCode;
        }

        public void setBookCode(String bookCode) {
            this.bookCode = bookCode;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getApplicableClass() {
            return applicableClass;
        }

        public void setApplicableClass(String applicableClass) {
            this.applicableClass = applicableClass;
        }

        public int getBookPage() {
            return bookPage;
        }

        public void setBookPage(int bookPage) {
            this.bookPage = bookPage;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTaskType() {
            return taskType;
        }

        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getPreparation() {
            return preparation;
        }

        public void setPreparation(String preparation) {
            this.preparation = preparation;
        }

        public String getProcess() {
            return process;
        }

        public void setProcess(String process) {
            this.process = process;
        }

        public String getActivityExtension() {
            return activityExtension;
        }

        public void setActivityExtension(String activityExtension) {
            this.activityExtension = activityExtension;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getResourcesUrl() {
            return resourcesUrl;
        }

        public void setResourcesUrl(String resourcesUrl) {
            this.resourcesUrl = resourcesUrl;
        }

        public int getReadNum() {
            return readNum;
        }

        public void setReadNum(int readNum) {
            this.readNum = readNum;
        }

        public String getCourseType() {
            return courseType;
        }

        public void setCourseType(String courseType) {
            this.courseType = courseType;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public String getTaskState() {
            return taskState;
        }

        public void setTaskState(String taskState) {
            this.taskState = taskState;
        }

        public String getTaskWorth() {
            return taskWorth;
        }

        public void setTaskWorth(String taskWorth) {
            this.taskWorth = taskWorth;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }

        public String getWeekNum() {
            return weekNum;
        }

        public void setWeekNum(String weekNum) {
            this.weekNum = weekNum;
        }

        public String getReleased() {
            return released;
        }

        public void setReleased(String released) {
            this.released = released;
        }

        public Object getTaskCode() {
            return taskCode;
        }

        public void setTaskCode(Object taskCode) {
            this.taskCode = taskCode;
        }

        public String getBookType() {
            return bookType;
        }

        public void setBookType(String bookType) {
            this.bookType = bookType;
        }

        public List<String> getPreviewUrlList() {
            return previewUrlList;
        }

        public void setPreviewUrlList(List<String> previewUrlList) {
            this.previewUrlList = previewUrlList;
        }
    }
}
