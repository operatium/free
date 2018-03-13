package net.m;

import java.util.List;

/**
 * Created by java on 2018/1/8.
 */

public class NetBean_LessonInfo {

    /**
     * code : 0x00000000
     * data : {"bookCode":"B201710250033","bookName":"我用字母画世界","applicableClass":"小班","bookPage":19,"tag":"艺术,表现创造,益智游戏,老校长童书工作室,河南科学技术出版社,我用字母画世界,原创,中文,3,4,5,6,7,8,语言,艺术,动物,植物,自然,日常用品,颜色,形状,游戏,绘画,视觉,创意,趣味,想象力,中班","taskType":"阅读拍照","remark":"西瓜像字母A，弓箭像字母B，月亮像字母C\u2026\u2026那么香蕉、茄子、蘑菇都像哪些字母呢？你身边还有什么东西像字母吗？让我们边跟着这本书学习，边来发现我们身边的字母秘密吧！","target":"阅读理解，有感悟","preparation":"课前预习","process":"课上阅读观看-课下复习观看","activityExtension":"和爸爸妈妈一起读咿啦看书","coverUrl":"http://book.ellabook.cn/10aca2f5ec4a4748be9124632eee6b32","previewUrlList":["http://book.ellabook.cn/B201710250342-12.jpg","http://book.ellabook.cn/B201710250343-12.jpg","http://book.ellabook.cn/B201710250344-10.jpg"],"resourcesUrl":"http://book.ellabook.cn/38a9ee35c8ac42a4a9c22325ca05e269","readNum":131,"courseType":"IN","createTime":1515054534000,"updateTime":1515054534000,"state":"NORMAL","issue":"1","taskState":"0","taskWorth":"3","semester":"NEXTSEMESTER","weekNum":"7","released":"0","taskCode":"T0000000001"}
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
         * bookCode : B201710250033
         * bookName : 我用字母画世界
         * applicableClass : 小班
         * bookPage : 19
         * tag : 艺术,表现创造,益智游戏,老校长童书工作室,河南科学技术出版社,我用字母画世界,原创,中文,3,4,5,6,7,8,语言,艺术,动物,植物,自然,日常用品,颜色,形状,游戏,绘画,视觉,创意,趣味,想象力,中班
         * taskType : 阅读拍照
         * remark : 西瓜像字母A，弓箭像字母B，月亮像字母C……那么香蕉、茄子、蘑菇都像哪些字母呢？你身边还有什么东西像字母吗？让我们边跟着这本书学习，边来发现我们身边的字母秘密吧！
         * target : 阅读理解，有感悟
         * preparation : 课前预习
         * process : 课上阅读观看-课下复习观看
         * activityExtension : 和爸爸妈妈一起读咿啦看书
         * coverUrl : http://book.ellabook.cn/10aca2f5ec4a4748be9124632eee6b32
         * previewUrlList : ["http://book.ellabook.cn/B201710250342-12.jpg","http://book.ellabook.cn/B201710250343-12.jpg","http://book.ellabook.cn/B201710250344-10.jpg"]
         * resourcesUrl : http://book.ellabook.cn/38a9ee35c8ac42a4a9c22325ca05e269
         * readNum : 131
         * courseType : IN
         * createTime : 1515054534000
         * updateTime : 1515054534000
         * state : NORMAL
         * issue : 1
         * taskState : 0
         * taskWorth : 3
         * semester : NEXTSEMESTER
         * weekNum : 7
         * released : 0
         * taskCode : T0000000001
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
        private String taskCode;
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

        public String getTaskCode() {
            return taskCode;
        }

        public void setTaskCode(String taskCode) {
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
