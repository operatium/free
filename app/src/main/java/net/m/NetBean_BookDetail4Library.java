package net.m;

import java.util.List;

/**
 * Created by java on 2018/3/7.
 */

public class NetBean_BookDetail4Library extends MessageEvent {


    /**
     * code : 10001000
     * data : {"gradeName":"小班,中班","bookCode":"B201710250001","process":"课上阅读观看-课下复习观看","activityExtension":"1. 和爸爸妈妈去感受雪景\n2. 和爸爸妈妈一起阅读动画书\n3. 收集雪景照片","bookPage":22,"previewResource":[{"previewUrl":"http://book.ellabook.cn/B201710250324-11.jpg"},{"previewUrl":"http://book.ellabook.cn/B201710250324-4.jpg"},{"previewUrl":"http://book.ellabook.cn/B201710250324-7.jpg"}],"remark":"兔奶奶有一件特别漂亮的花旗袍。可惜，兔奶奶年纪大了，穿不下了。于是，兔奶奶决定用它给兔宝宝做一件礼物。会是什么呢？我们打开这本，一起去看看这些温馨的故事吧！","bookName":"动态阅读7-2惜福与丰收","resourcesUrl":"http://book.ellabook.cn/5b6507d901244ffab61d9a0c1ab763db","target":"阅读理解，有感悟222223223","preparation":"1. 准备图片\n2. 准备游戏\n3. 准","coverUrl":"http://book.ellabook.cn/XF20171213105728","readNum":893,"tag":"凤凰出版传媒集团,江苏教育出版社,亲子共读,全领域,故事童谣,诗歌,字宝宝,识字,幼儿园教材,中文,原创,康轩,趣味,创意,思维拓展,益智游戏,语言,3,4,5,6,7,8,奶奶的花旗袍,种豆娃,它是什么瓜,中秋节的传说,西江月夜行黄沙道中,辛弃疾,小书坊,珍惜,连衣裙,节约,节俭,黄瓜,植物,嫦娥,后裔,月饼,月亮,神仙,思维,想象力,表达能力","downloadStatus":"YES","bookType":"COURSE_OUT"}
     * message : 【调用成功】
     * remark : 查询图书详情
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
         * gradeName : 小班,中班
         * bookCode : B201710250001
         * process : 课上阅读观看-课下复习观看
         * activityExtension : 1. 和爸爸妈妈去感受雪景
         2. 和爸爸妈妈一起阅读动画书
         3. 收集雪景照片
         * bookPage : 22
         * previewResource : [{"previewUrl":"http://book.ellabook.cn/B201710250324-11.jpg"},{"previewUrl":"http://book.ellabook.cn/B201710250324-4.jpg"},{"previewUrl":"http://book.ellabook.cn/B201710250324-7.jpg"}]
         * remark : 兔奶奶有一件特别漂亮的花旗袍。可惜，兔奶奶年纪大了，穿不下了。于是，兔奶奶决定用它给兔宝宝做一件礼物。会是什么呢？我们打开这本，一起去看看这些温馨的故事吧！
         * bookName : 动态阅读7-2惜福与丰收
         * resourcesUrl : http://book.ellabook.cn/5b6507d901244ffab61d9a0c1ab763db
         * target : 阅读理解，有感悟222223223
         * preparation : 1. 准备图片
         2. 准备游戏
         3. 准
         * coverUrl : http://book.ellabook.cn/XF20171213105728
         * readNum : 893
         * tag : 凤凰出版传媒集团,江苏教育出版社,亲子共读,全领域,故事童谣,诗歌,字宝宝,识字,幼儿园教材,中文,原创,康轩,趣味,创意,思维拓展,益智游戏,语言,3,4,5,6,7,8,奶奶的花旗袍,种豆娃,它是什么瓜,中秋节的传说,西江月夜行黄沙道中,辛弃疾,小书坊,珍惜,连衣裙,节约,节俭,黄瓜,植物,嫦娥,后裔,月饼,月亮,神仙,思维,想象力,表达能力
         * downloadStatus : YES
         * bookType : COURSE_OUT
         */

        private String gradeName;
        private String bookCode;
        private String process;
        private String activityExtension;
        private int bookPage;
        private String remark;
        private String bookName;
        private String resourcesUrl;
        private String target;
        private String preparation;
        private String coverUrl;
        private int readNum;
        private String tag;
        private String downloadStatus;
        private String bookType;
        private List<PreviewResourceBean> previewResource;

        public String getGradeName() {
            return gradeName;
        }

        public void setGradeName(String gradeName) {
            this.gradeName = gradeName;
        }

        public String getBookCode() {
            return bookCode;
        }

        public void setBookCode(String bookCode) {
            this.bookCode = bookCode;
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

        public int getBookPage() {
            return bookPage;
        }

        public void setBookPage(int bookPage) {
            this.bookPage = bookPage;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getResourcesUrl() {
            return resourcesUrl;
        }

        public void setResourcesUrl(String resourcesUrl) {
            this.resourcesUrl = resourcesUrl;
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

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public int getReadNum() {
            return readNum;
        }

        public void setReadNum(int readNum) {
            this.readNum = readNum;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getDownloadStatus() {
            return downloadStatus;
        }

        public void setDownloadStatus(String downloadStatus) {
            this.downloadStatus = downloadStatus;
        }

        public String getBookType() {
            return bookType;
        }

        public void setBookType(String bookType) {
            this.bookType = bookType;
        }

        public List<PreviewResourceBean> getPreviewResource() {
            return previewResource;
        }

        public void setPreviewResource(List<PreviewResourceBean> previewResource) {
            this.previewResource = previewResource;
        }

        public static class PreviewResourceBean {
            /**
             * previewUrl : http://book.ellabook.cn/B201710250324-11.jpg
             */

            private String previewUrl;

            public String getPreviewUrl() {
                return previewUrl;
            }

            public void setPreviewUrl(String previewUrl) {
                this.previewUrl = previewUrl;
            }
        }
    }
}
