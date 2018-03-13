package net.m;

import java.io.Serializable;
import java.util.List;

/**
 * Created by java on 2018/3/1.
 */

public class NetBean_QueryLibIndex extends MessageEvent {
    /**
     * code : 10001000
     * data : {"gradeList":[{"gradeName":"小班","gradeCode":"KINDERGARTEN_BOTTOM_CLASS"},{"gradeName":"中班","gradeCode":"KINDERGARTEN_MIDDLE_CLASS"},{"gradeName":"大班","gradeCode":"KINDERGARTEN_TOP_CLASS"},{"gradeName":"全部","gradeCode":"0"}],"dailyBook":{"dailyImg":"http://member.ellabook.cn/dd89e497ba6c4316941e7dcc9cd64c5e","dailyCode":"D20180204110007133","dailyTitle":"愿每个孩子都是玛德琳"},"domainClassList":[{"domainCode":"D201712055O4YKL","domainName":"健康","level":"1","idx":1,"subDomainClazz":[{"domainCode":"D201712055SW4PC","domainName":"身心健康","parentCode":"D201712055O4YKL","level":"2","idx":7},{"domainCode":"D201712055SW555","domainName":"动作发展","parentCode":"D201712055O4YKL","level":"2","idx":8},{"domainCode":"D201712055SW5WN","domainName":"生活习惯","parentCode":"D201712055O4YKL","level":"2","idx":9},{"domainCode":"D201712055SW65U","domainName":"安全自护","parentCode":"D201712055O4YKL","level":"2","idx":10}]},{"domainCode":"D201712055OHDHS","domainName":"语言","level":"1","idx":2,"subDomainClazz":[{"domainCode":"D201712055SW6MR","domainName":"趣味阅读","parentCode":"D201712055OHDHS","level":"2","idx":11},{"domainCode":"D201712055SWA2F","domainName":"书写准备","parentCode":"D201712055OHDHS","level":"2","idx":12}]},{"domainCode":"D201712055OHDQY","domainName":"社会","level":"1","idx":3,"subDomainClazz":[{"domainCode":"D201712055SWAUO","domainName":"人际交往","parentCode":"D201712055OHDQY","level":"2","idx":13},{"domainCode":"D201712055SWBDG","domainName":"社会适应","parentCode":"D201712055OHDQY","level":"2","idx":14}]},{"domainCode":"D201712055OHDXH","domainName":"科学","level":"1","idx":4,"subDomainClazz":[{"domainCode":"D201712055SWBFM","domainName":"科学探究","parentCode":"D201712055OHDXH","level":"2","idx":15},{"domainCode":"D201712055SWC3H","domainName":"数学认知","parentCode":"D201712055OHDXH","level":"2","idx":16}]},{"domainCode":"D201712055OHEAZ","domainName":"艺术","level":"1","idx":5,"subDomainClazz":[{"domainCode":"D201712056GXKD6","domainName":"感受欣赏","parentCode":"D201712055OHEAZ","level":"2","idx":17},{"domainCode":"D201712056GXKMY","domainName":"表现创造","parentCode":"D201712055OHEAZ","level":"2","idx":18}]}]}
     * message : 【调用成功】
     * remark : 图书馆首页
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
         * gradeList : [{"gradeName":"小班","gradeCode":"KINDERGARTEN_BOTTOM_CLASS"},{"gradeName":"中班","gradeCode":"KINDERGARTEN_MIDDLE_CLASS"},{"gradeName":"大班","gradeCode":"KINDERGARTEN_TOP_CLASS"},{"gradeName":"全部","gradeCode":"0"}]
         * dailyBook : {"dailyImg":"http://member.ellabook.cn/dd89e497ba6c4316941e7dcc9cd64c5e","dailyCode":"D20180204110007133","dailyTitle":"愿每个孩子都是玛德琳"}
         * domainClassList : [{"domainCode":"D201712055O4YKL","domainName":"健康","level":"1","idx":1,"subDomainClazz":[{"domainCode":"D201712055SW4PC","domainName":"身心健康","parentCode":"D201712055O4YKL","level":"2","idx":7},{"domainCode":"D201712055SW555","domainName":"动作发展","parentCode":"D201712055O4YKL","level":"2","idx":8},{"domainCode":"D201712055SW5WN","domainName":"生活习惯","parentCode":"D201712055O4YKL","level":"2","idx":9},{"domainCode":"D201712055SW65U","domainName":"安全自护","parentCode":"D201712055O4YKL","level":"2","idx":10}]},{"domainCode":"D201712055OHDHS","domainName":"语言","level":"1","idx":2,"subDomainClazz":[{"domainCode":"D201712055SW6MR","domainName":"趣味阅读","parentCode":"D201712055OHDHS","level":"2","idx":11},{"domainCode":"D201712055SWA2F","domainName":"书写准备","parentCode":"D201712055OHDHS","level":"2","idx":12}]},{"domainCode":"D201712055OHDQY","domainName":"社会","level":"1","idx":3,"subDomainClazz":[{"domainCode":"D201712055SWAUO","domainName":"人际交往","parentCode":"D201712055OHDQY","level":"2","idx":13},{"domainCode":"D201712055SWBDG","domainName":"社会适应","parentCode":"D201712055OHDQY","level":"2","idx":14}]},{"domainCode":"D201712055OHDXH","domainName":"科学","level":"1","idx":4,"subDomainClazz":[{"domainCode":"D201712055SWBFM","domainName":"科学探究","parentCode":"D201712055OHDXH","level":"2","idx":15},{"domainCode":"D201712055SWC3H","domainName":"数学认知","parentCode":"D201712055OHDXH","level":"2","idx":16}]},{"domainCode":"D201712055OHEAZ","domainName":"艺术","level":"1","idx":5,"subDomainClazz":[{"domainCode":"D201712056GXKD6","domainName":"感受欣赏","parentCode":"D201712055OHEAZ","level":"2","idx":17},{"domainCode":"D201712056GXKMY","domainName":"表现创造","parentCode":"D201712055OHEAZ","level":"2","idx":18}]}]
         */

        private DailyBookBean dailyBook;
        private List<GradeListBean> gradeList;
        private List<DomainClassListBean> domainClassList;

        public DailyBookBean getDailyBook() {
            return dailyBook;
        }

        public void setDailyBook(DailyBookBean dailyBook) {
            this.dailyBook = dailyBook;
        }

        public List<GradeListBean> getGradeList() {
            return gradeList;
        }

        public void setGradeList(List<GradeListBean> gradeList) {
            this.gradeList = gradeList;
        }

        public List<DomainClassListBean> getDomainClassList() {
            return domainClassList;
        }

        public void setDomainClassList(List<DomainClassListBean> domainClassList) {
            this.domainClassList = domainClassList;
        }

        public static class DailyBookBean {
            /**
             * dailyImg : http://member.ellabook.cn/dd89e497ba6c4316941e7dcc9cd64c5e
             * dailyCode : D20180204110007133
             * dailyTitle : 愿每个孩子都是玛德琳
             */

            private String dailyImg;
            private String dailyCode;
            private String dailyTitle;
            private String targetPage;

            public String getDailyImg() {
                return dailyImg;
            }

            public void setDailyImg(String dailyImg) {
                this.dailyImg = dailyImg;
            }

            public String getDailyCode() {
                return dailyCode;
            }

            public void setDailyCode(String dailyCode) {
                this.dailyCode = dailyCode;
            }

            public String getDailyTitle() {
                return dailyTitle;
            }

            public void setDailyTitle(String dailyTitle) {
                this.dailyTitle = dailyTitle;
            }

            public String getTargetPage() {
                return targetPage;
            }

            public void setTargetPage(String targetPage) {
                this.targetPage = targetPage;
            }
        }

        public static class GradeListBean implements Serializable{
            /**
             * gradeName : 小班
             * gradeCode : KINDERGARTEN_BOTTOM_CLASS
             */

            private String gradeName;
            private String gradeCode;

            public String getGradeName() {
                return gradeName;
            }

            public void setGradeName(String gradeName) {
                this.gradeName = gradeName;
            }

            public String getGradeCode() {
                return gradeCode;
            }

            public void setGradeCode(String gradeCode) {
                this.gradeCode = gradeCode;
            }
        }

        public static class DomainClassListBean {
            /**
             * domainCode : D201712055O4YKL
             * domainName : 健康
             * level : 1
             * idx : 1
             * subDomainClazz : [{"domainCode":"D201712055SW4PC","domainName":"身心健康","parentCode":"D201712055O4YKL","level":"2","idx":7},{"domainCode":"D201712055SW555","domainName":"动作发展","parentCode":"D201712055O4YKL","level":"2","idx":8},{"domainCode":"D201712055SW5WN","domainName":"生活习惯","parentCode":"D201712055O4YKL","level":"2","idx":9},{"domainCode":"D201712055SW65U","domainName":"安全自护","parentCode":"D201712055O4YKL","level":"2","idx":10}]
             */

            private String domainCode;
            private String domainName;
            private String level;
            private int idx;
            private List<SubDomainClazzBean> subDomainClazz;
            private List<Book> bookList;

            public String getDomainCode() {
                return domainCode;
            }

            public void setDomainCode(String domainCode) {
                this.domainCode = domainCode;
            }

            public String getDomainName() {
                return domainName;
            }

            public void setDomainName(String domainName) {
                this.domainName = domainName;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public List<SubDomainClazzBean> getSubDomainClazz() {
                return subDomainClazz;
            }

            public void setSubDomainClazz(List<SubDomainClazzBean> subDomainClazz) {
                this.subDomainClazz = subDomainClazz;
            }

            public List<Book> getBookList() {
                return bookList;
            }

            public void setBookList(List<Book> bookList) {
                this.bookList = bookList;
            }

            public static class SubDomainClazzBean implements Serializable{
                /**
                 * domainCode : D201712055SW4PC
                 * domainName : 身心健康
                 * parentCode : D201712055O4YKL
                 * level : 2
                 * idx : 7
                 */

                private String domainCode;
                private String domainName;
                private String parentCode;
                private String level;
                private int idx;

                public String getDomainCode() {
                    return domainCode;
                }

                public void setDomainCode(String domainCode) {
                    this.domainCode = domainCode;
                }

                public String getDomainName() {
                    return domainName;
                }

                public void setDomainName(String domainName) {
                    this.domainName = domainName;
                }

                public String getParentCode() {
                    return parentCode;
                }

                public void setParentCode(String parentCode) {
                    this.parentCode = parentCode;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public int getIdx() {
                    return idx;
                }

                public void setIdx(int idx) {
                    this.idx = idx;
                }
            }

            public static class Book{

                /**
                 * "coverUrl": "http://book.ellabook.cn/097af74461234185b559981adfd4c167"
                 * "bookCode": "B201710250002"
                 * "bookName": "动态阅读2-3彩色世界"
                 */

                private String coverUrl;
                private String bookCode;
                private String bookName;
                private String courseStatus;

                public String getCoverUrl() {
                    return coverUrl;
                }

                public void setCoverUrl(String coverUrl) {
                    this.coverUrl = coverUrl;
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

                public String getCourseStatus() {
                    return courseStatus;
                }

                public void setCourseStatus(String courseStatus) {
                    this.courseStatus = courseStatus;
                }
            }
        }
    }
}
