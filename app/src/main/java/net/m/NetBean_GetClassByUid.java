package net.m;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by java on 2018/1/8.
 */

public class NetBean_GetClassByUid {
    public static NetBean_GetClassByUid getExample(){
        String json = "    {\n" +
                "        \"code\": \"0x00000000\",\n" +
                "        \"data\": {\n" +
                "            \"course\": [\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000003\",\n" +
                "                    \"bookName\": \"我用字母画世界\",\n" +
                "                    \"bookCode\": \"B201710250033\",\n" +
                "                    \"applicableClass\": \"小班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/10aca2f5ec4a4748be9124632eee6b32\",\n" +
                "                    \"weekNum\": 1,\n" +
                "                    \"courseType\": \"IN\",\n" +
                "                    \"classGrade\": \"SMALL\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"上周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000003\",\n" +
                "                    \"bookName\": \"4-5岁宝宝涂色画（上）\",\n" +
                "                    \"bookCode\": \"B201710250034\",\n" +
                "                    \"applicableClass\": \"小班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/818ef02c26674811af12dd7b63b4cae1\",\n" +
                "                    \"weekNum\": 2,\n" +
                "                    \"courseType\": \"IN\",\n" +
                "                    \"classGrade\": \"SMALL\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"本周课程\",\n" +
                "                    \"nowWeek\": \"1\",\n" +
                "                    \"issue\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000003\",\n" +
                "                    \"bookName\": \"点点乐园  唐诗\",\n" +
                "                    \"bookCode\": \"B201710250035\",\n" +
                "                    \"applicableClass\": \"小班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/f93426c2da864a848894f41e36cf05d1\",\n" +
                "                    \"weekNum\": 3,\n" +
                "                    \"courseType\": \"IN\",\n" +
                "                    \"classGrade\": \"SMALL\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"下周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000004\",\n" +
                "                    \"bookName\": \"3-4岁宝宝涂色画（上）\",\n" +
                "                    \"bookCode\": \"B201710250049\",\n" +
                "                    \"applicableClass\": \"小班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/5b49a0fccad44d3fa0ed7ad30f1067b6\",\n" +
                "                    \"weekNum\": 1,\n" +
                "                    \"courseType\": \"OUT\",\n" +
                "                    \"classGrade\": \"SMALL\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"上周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000004\",\n" +
                "                    \"bookName\": \"点点乐园  世界名曲（下）\",\n" +
                "                    \"bookCode\": \"B201710250050\",\n" +
                "                    \"applicableClass\": \"小班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/ff321321c5634332932b303c5b197fc9\",\n" +
                "                    \"weekNum\": 2,\n" +
                "                    \"courseType\": \"OUT\",\n" +
                "                    \"classGrade\": \"SMALL\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"本周课程\",\n" +
                "                    \"nowWeek\": \"1\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000004\",\n" +
                "                    \"bookName\": \"点点乐园  儿歌（下）\",\n" +
                "                    \"bookCode\": \"B201710250311\",\n" +
                "                    \"applicableClass\": \"小班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/a76947f7274c42c38baf15dfe97860fb\",\n" +
                "                    \"weekNum\": 3,\n" +
                "                    \"courseType\": \"OUT\",\n" +
                "                    \"classGrade\": \"SMALL\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"下周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000007\",\n" +
                "                    \"bookName\": \"朵拉的春天\",\n" +
                "                    \"bookCode\": \"B201710250374\",\n" +
                "                    \"applicableClass\": \"中班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/b1a63c4fb177461a80b8301acf4c0523\",\n" +
                "                    \"weekNum\": 1,\n" +
                "                    \"courseType\": \"IN\",\n" +
                "                    \"classGrade\": \"MIDDLE\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"上周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000007\",\n" +
                "                    \"bookName\": \"浣熊妈妈\",\n" +
                "                    \"bookCode\": \"B201710250359\",\n" +
                "                    \"applicableClass\": \"中班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/b29694dc123c41948eef95242fa35bbb\",\n" +
                "                    \"weekNum\": 2,\n" +
                "                    \"courseType\": \"IN\",\n" +
                "                    \"classGrade\": \"MIDDLE\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"本周课程\",\n" +
                "                    \"nowWeek\": \"1\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000007\",\n" +
                "                    \"bookName\": \"晚安，我的星星\",\n" +
                "                    \"bookCode\": \"B201710250360\",\n" +
                "                    \"applicableClass\": \"中班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/3217cd8638a145e0b9aaccaadb82ba7f\",\n" +
                "                    \"weekNum\": 3,\n" +
                "                    \"courseType\": \"IN\",\n" +
                "                    \"classGrade\": \"MIDDLE\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"下周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000008\",\n" +
                "                    \"bookName\": \"马\",\n" +
                "                    \"bookCode\": \"B201710250659\",\n" +
                "                    \"applicableClass\": \"中班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": null,\n" +
                "                    \"weekNum\": 1,\n" +
                "                    \"courseType\": \"OUT\",\n" +
                "                    \"classGrade\": \"MIDDLE\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"上周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000008\",\n" +
                "                    \"bookName\": \"蛤蜊最好吃\",\n" +
                "                    \"bookCode\": \"B201710250375\",\n" +
                "                    \"applicableClass\": \"中班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/88a2e22b83954fc5ba9f7f7cf94927b8\",\n" +
                "                    \"weekNum\": 2,\n" +
                "                    \"courseType\": \"OUT\",\n" +
                "                    \"classGrade\": \"MIDDLE\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"本周课程\",\n" +
                "                    \"nowWeek\": \"1\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000008\",\n" +
                "                    \"bookName\": \"儿童安全手册（一）\",\n" +
                "                    \"bookCode\": \"B201710250376\",\n" +
                "                    \"applicableClass\": \"中班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/e2a87f024f9845059fe5d45bb3e8a9db\",\n" +
                "                    \"weekNum\": 3,\n" +
                "                    \"courseType\": \"OUT\",\n" +
                "                    \"classGrade\": \"MIDDLE\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"下周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000011\",\n" +
                "                    \"bookName\": \"贝丝妹妹的粉色生日\",\n" +
                "                    \"bookCode\": \"B201710250428\",\n" +
                "                    \"applicableClass\": \"大班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/4039022e1d2f40209d922cfde86d20c2\",\n" +
                "                    \"weekNum\": 1,\n" +
                "                    \"courseType\": \"IN\",\n" +
                "                    \"classGrade\": \"BIG\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"上周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000011\",\n" +
                "                    \"bookName\": \"二郎担山赶太阳\",\n" +
                "                    \"bookCode\": \"B201710250429\",\n" +
                "                    \"applicableClass\": \"大班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/7deabe83ee95458a8c2e96f3d65e2cb4\",\n" +
                "                    \"weekNum\": 2,\n" +
                "                    \"courseType\": \"IN\",\n" +
                "                    \"classGrade\": \"BIG\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"本周课程\",\n" +
                "                    \"nowWeek\": \"1\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000011\",\n" +
                "                    \"bookName\": \"我不挑食\",\n" +
                "                    \"bookCode\": \"B201710250430\",\n" +
                "                    \"applicableClass\": \"大班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/8c439de754af4e7b9590d76c8d7f3b87\",\n" +
                "                    \"weekNum\": 3,\n" +
                "                    \"courseType\": \"IN\",\n" +
                "                    \"classGrade\": \"BIG\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"下周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000012\",\n" +
                "                    \"bookName\": \"动态阅读5-5冬日精灵\",\n" +
                "                    \"bookCode\": \"B201710250444\",\n" +
                "                    \"applicableClass\": \"大班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/07b3210e758548d3b8a3dd41319d9067\",\n" +
                "                    \"weekNum\": 1,\n" +
                "                    \"courseType\": \"OUT\",\n" +
                "                    \"classGrade\": \"BIG\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"上周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000012\",\n" +
                "                    \"bookName\": \"嫦娥奔月\",\n" +
                "                    \"bookCode\": \"B201710250445\",\n" +
                "                    \"applicableClass\": \"大班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/d61ada3decf949468831d2d6a5a83caa\",\n" +
                "                    \"weekNum\": 2,\n" +
                "                    \"courseType\": \"OUT\",\n" +
                "                    \"classGrade\": \"BIG\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"本周课程\",\n" +
                "                    \"nowWeek\": \"1\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"courseCode\": \"C0000000012\",\n" +
                "                    \"bookName\": \"抓捕青蛙\",\n" +
                "                    \"bookCode\": \"B201710250446\",\n" +
                "                    \"applicableClass\": \"大班\",\n" +
                "                    \"bookPage\": 16,\n" +
                "                    \"tag\": \"行为习惯\",\n" +
                "                    \"taskType\": \"拍照\",\n" +
                "                    \"coverUrl\": \"http://book.ellabook.cn/589dabd6ed2542fda91dcd9287f45655\",\n" +
                "                    \"weekNum\": 3,\n" +
                "                    \"courseType\": \"OUT\",\n" +
                "                    \"classGrade\": \"BIG\",\n" +
                "                    \"semester\": \"NEXTSEMESTER\",\n" +
                "                    \"weekName\": \"下周课程\",\n" +
                "                    \"nowWeek\": \"0\",\n" +
                "                    \"issue\": \"0\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"classInfo\": [\n" +
                "                {\n" +
                "                    \"classGrade\": \"SMALL\",\n" +
                "                    \"classCode\": \"C0000000001\",\n" +
                "                    \"className\": \"草莓班\",\n" +
                "                    \"parentNum\": 1\n" +
                "                },\n" +
                "                {\n" +
                "                    \"classGrade\": \"MIDDLE\",\n" +
                "                    \"classCode\": \"C0000000002\",\n" +
                "                    \"className\": \"二二班\",\n" +
                "                    \"parentNum\": 1\n" +
                "                },\n" +
                "                {\n" +
                "                    \"classGrade\": \"BIG\",\n" +
                "                    \"classCode\": \"C0000000003\",\n" +
                "                    \"className\": \"三三班\",\n" +
                "                    \"parentNum\": 2\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"message\": \"【调用成功】\",\n" +
                "        \"remark\": \"咿啦家园 - 查询相应班级信息\",\n" +
                "        \"status\": \"1\"\n" +
                "    }";
        return JSON.parseObject(json, NetBean_GetClassByUid.class);
    }

    /**
     * code : 0x00000000
     * data : {"course":[{"courseCode":"C0000000003","bookName":"我用字母画世界","bookCode":"B201710250033","applicableClass":"小班","bookPage":16,"tag":"行为习惯","taskType":"拍照","coverUrl":"http://book.ellabook.cn/10aca2f5ec4a4748be9124632eee6b32","weekNum":1,"courseType":"IN","classGrade":"SMALL","semester":"NEXTSEMESTER","weekName":"上周课程","nowWeek":"0","issue":"1"}],"classInfo":[{"classGrade":"SMALL","classCode":"C0000000001","className":"草莓班","parentNum":1}]}
     * message : 【调用成功】
     * remark : 咿啦家园 - 查询相应班级信息
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
        private List<CourseBean> course;
        private List<ClassInfoBean> classInfo;

        public List<CourseBean> getCourse() {
            return course;
        }

        public void setCourse(List<CourseBean> course) {
            this.course = course;
        }

        public List<ClassInfoBean> getClassInfo() {
            return classInfo;
        }

        public void setClassInfo(List<ClassInfoBean> classInfo) {
            this.classInfo = classInfo;
        }

        public static class CourseBean {
            /**
             * courseCode : C0000000003
             * bookName : 我用字母画世界
             * bookCode : B201710250033
             * applicableClass : 小班
             * bookPage : 16
             * tag : 行为习惯
             * taskType : 拍照
             * coverUrl : http://book.ellabook.cn/10aca2f5ec4a4748be9124632eee6b32
             * weekNum : 1
             * courseType : IN
             * classGrade : SMALL
             * semester : NEXTSEMESTER
             * weekName : 上周课程
             * nowWeek : 0
             * issue : 1
             */

            private String courseCode;
            private String bookName;
            private String bookCode;
            private String applicableClass;
            private int bookPage;
            private String tag;
            private String taskType;
            private String coverUrl;
            private int weekNum;
            private String courseType;
            private String classGrade;
            private String semester;
            private String weekName;
            private String nowWeek;
            private String issue;

            public String getCourseCode() {
                return courseCode;
            }

            public void setCourseCode(String courseCode) {
                this.courseCode = courseCode;
            }

            public String getBookName() {
                return bookName;
            }

            public void setBookName(String bookName) {
                this.bookName = bookName;
            }

            public String getBookCode() {
                return bookCode;
            }

            public void setBookCode(String bookCode) {
                this.bookCode = bookCode;
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

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public int getWeekNum() {
                return weekNum;
            }

            public void setWeekNum(int weekNum) {
                this.weekNum = weekNum;
            }

            public String getCourseType() {
                return courseType;
            }

            public void setCourseType(String courseType) {
                this.courseType = courseType;
            }

            public String getClassGrade() {
                return classGrade;
            }

            public void setClassGrade(String classGrade) {
                this.classGrade = classGrade;
            }

            public String getSemester() {
                return semester;
            }

            public void setSemester(String semester) {
                this.semester = semester;
            }

            public String getWeekName() {
                return weekName;
            }

            public void setWeekName(String weekName) {
                this.weekName = weekName;
            }

            public String getNowWeek() {
                return nowWeek;
            }

            public void setNowWeek(String nowWeek) {
                this.nowWeek = nowWeek;
            }

            public String getIssue() {
                return issue;
            }

            public void setIssue(String issue) {
                this.issue = issue;
            }
        }

        public static class ClassInfoBean {
            /**
             * classGrade : SMALL
             * classCode : C0000000001
             * className : 草莓班
             * parentNum : 1
             */

            private String classGrade;
            private String classCode;
            private String className;
            private int parentNum;

            public String getClassGrade() {
                return classGrade;
            }

            public void setClassGrade(String classGrade) {
                this.classGrade = classGrade;
            }

            public String getClassCode() {
                return classCode;
            }

            public void setClassCode(String classCode) {
                this.classCode = classCode;
            }

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }

            public int getParentNum() {
                return parentNum;
            }

            public void setParentNum(int parentNum) {
                this.parentNum = parentNum;
            }
        }
    }
}
