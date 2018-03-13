package net.m;

import java.util.List;

/**
 * Created by luodi on 2018/1/4.
 */

public class NetBean_CourseData {

    /**
     * code : 0x00000000
     * data : {"NEXTSEMESTER":{"title":"草莓班下学期绘本教学课程共16节","IN":[{"courseCode":"C0000000003","bookCode":"B201710250033","bookName":"我用字母画世界","coverUrl":"http://book.ellabook.cn/10aca2f5ec4a4748be9124632eee6b32","weekNum":1,"weekName":"第1周","nowWeek":"0","tag":"行为习惯","issue":null},{"courseCode":"C0000000003","bookCode":"B201710250034","bookName":"4-5岁宝宝涂色画（上）","coverUrl":"http://book.ellabook.cn/818ef02c26674811af12dd7b63b4cae1","weekNum":2,"weekName":"本周课程","nowWeek":"1","tag":"行为习惯","issue":null}]},"LASTSEMESTER":{"title":"草莓班上学期绘本教学课程共16节","IN":[{"courseCode":"C0000000001","bookCode":"B201710250001","bookName":"动态阅读7-2惜福与丰收","coverUrl":"http://book.ellabook.cn/XF20171213105728","weekNum":1,"weekName":"第1周","nowWeek":"0","tag":"行为习惯","issue":null},{"courseCode":"C0000000001","bookCode":"B201710250002","bookName":"动态阅读2-3彩色世界","coverUrl":"http://book.ellabook.cn/097af74461234185b559981adfd4c167","weekNum":2,"weekName":"第2周","nowWeek":"0","tag":"行为习惯","issue":null}]},"semester":"NEXTSEMESTER"}
     * message : 【调用成功】
     * remark : 咿啦家园 - 获取课程表
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
         * NEXTSEMESTER : {"title":"草莓班下学期绘本教学课程共16节","IN":[{"courseCode":"C0000000003","bookCode":"B201710250033","bookName":"我用字母画世界","coverUrl":"http://book.ellabook.cn/10aca2f5ec4a4748be9124632eee6b32","weekNum":1,"weekName":"第1周","nowWeek":"0","tag":"行为习惯","issue":null},{"courseCode":"C0000000003","bookCode":"B201710250034","bookName":"4-5岁宝宝涂色画（上）","coverUrl":"http://book.ellabook.cn/818ef02c26674811af12dd7b63b4cae1","weekNum":2,"weekName":"本周课程","nowWeek":"1","tag":"行为习惯","issue":null}]}
         * LASTSEMESTER : {"title":"草莓班上学期绘本教学课程共16节","IN":[{"courseCode":"C0000000001","bookCode":"B201710250001","bookName":"动态阅读7-2惜福与丰收","coverUrl":"http://book.ellabook.cn/XF20171213105728","weekNum":1,"weekName":"第1周","nowWeek":"0","tag":"行为习惯","issue":null},{"courseCode":"C0000000001","bookCode":"B201710250002","bookName":"动态阅读2-3彩色世界","coverUrl":"http://book.ellabook.cn/097af74461234185b559981adfd4c167","weekNum":2,"weekName":"第2周","nowWeek":"0","tag":"行为习惯","issue":null}]}
         * semester : NEXTSEMESTER
         */

        private NEXTSEMESTERBean NEXTSEMESTER;
        private LASTSEMESTERBean LASTSEMESTER;
        private String semester;

        public NEXTSEMESTERBean getNEXTSEMESTER() {
            return NEXTSEMESTER;
        }

        public void setNEXTSEMESTER(NEXTSEMESTERBean NEXTSEMESTER) {
            this.NEXTSEMESTER = NEXTSEMESTER;
        }

        public LASTSEMESTERBean getLASTSEMESTER() {
            return LASTSEMESTER;
        }

        public void setLASTSEMESTER(LASTSEMESTERBean LASTSEMESTER) {
            this.LASTSEMESTER = LASTSEMESTER;
        }

        public String getSemester() {
            return semester;
        }

        public void setSemester(String semester) {
            this.semester = semester;
        }

        public static class NEXTSEMESTERBean {
            /**
             * title : 草莓班下学期绘本教学课程共16节
             * IN : [{"courseCode":"C0000000003","bookCode":"B201710250033","bookName":"我用字母画世界","coverUrl":"http://book.ellabook.cn/10aca2f5ec4a4748be9124632eee6b32","weekNum":1,"weekName":"第1周","nowWeek":"0","tag":"行为习惯","issue":null},{"courseCode":"C0000000003","bookCode":"B201710250034","bookName":"4-5岁宝宝涂色画（上）","coverUrl":"http://book.ellabook.cn/818ef02c26674811af12dd7b63b4cae1","weekNum":2,"weekName":"本周课程","nowWeek":"1","tag":"行为习惯","issue":null}]
             */

            private String title;
            private List<INBean> IN;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<INBean> getIN() {
                return IN;
            }

            public void setIN(List<INBean> IN) {
                this.IN = IN;
            }

            public static class INBean {
                /**
                 * courseCode : C0000000003
                 * bookCode : B201710250033
                 * bookName : 我用字母画世界
                 * coverUrl : http://book.ellabook.cn/10aca2f5ec4a4748be9124632eee6b32
                 * weekNum : 1
                 * weekName : 第1周
                 * nowWeek : 0
                 * tag : 行为习惯
                 * issue : null
                 */

                private String courseCode;
                private String bookCode;
                private String bookName;
                private String coverUrl;
                private int weekNum;
                private String weekName;
                private String nowWeek;
                private String tag;
                private Object issue;

                public String getCourseCode() {
                    return courseCode;
                }

                public void setCourseCode(String courseCode) {
                    this.courseCode = courseCode;
                }

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

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public Object getIssue() {
                    return issue;
                }

                public void setIssue(Object issue) {
                    this.issue = issue;
                }
            }
        }

        public static class LASTSEMESTERBean {
            /**
             * title : 草莓班上学期绘本教学课程共16节
             * IN : [{"courseCode":"C0000000001","bookCode":"B201710250001","bookName":"动态阅读7-2惜福与丰收","coverUrl":"http://book.ellabook.cn/XF20171213105728","weekNum":1,"weekName":"第1周","nowWeek":"0","tag":"行为习惯","issue":null},{"courseCode":"C0000000001","bookCode":"B201710250002","bookName":"动态阅读2-3彩色世界","coverUrl":"http://book.ellabook.cn/097af74461234185b559981adfd4c167","weekNum":2,"weekName":"第2周","nowWeek":"0","tag":"行为习惯","issue":null}]
             */

            private String title;
            private List<INBeanX> IN;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<INBeanX> getIN() {
                return IN;
            }

            public void setIN(List<INBeanX> IN) {
                this.IN = IN;
            }

            public static class INBeanX {
                /**
                 * courseCode : C0000000001
                 * bookCode : B201710250001
                 * bookName : 动态阅读7-2惜福与丰收
                 * coverUrl : http://book.ellabook.cn/XF20171213105728
                 * weekNum : 1
                 * weekName : 第1周
                 * nowWeek : 0
                 * tag : 行为习惯
                 * issue : null
                 */

                private String courseCode;
                private String bookCode;
                private String bookName;
                private String coverUrl;
                private int weekNum;
                private String weekName;
                private String nowWeek;
                private String tag;
                private Object issue;

                public String getCourseCode() {
                    return courseCode;
                }

                public void setCourseCode(String courseCode) {
                    this.courseCode = courseCode;
                }

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

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public Object getIssue() {
                    return issue;
                }

                public void setIssue(Object issue) {
                    this.issue = issue;
                }
            }
        }
    }
}
