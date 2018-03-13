package net.m;

import java.util.List;

/**
 * 图书分类数据封装
 * @autor hongbing
 * @date 2018/3/5
 */
public class NetBean_queryBookListByDomain {

    /**
     * code: "0x00000000",
     * data: { "pageIndex": 1,"count": 2,"bookList": [{"coverUrl": "http://book.ellabook.cn/XF20171213105728","gradeName": "小班","bookCode": "B201710250001","readNum": 893,"bookPage": 22,"bookName": "动态阅读7-2惜福与丰收","tag": "凤凰出版传媒集团,思维拓展,表达能力"}]},
     * message": "",
     * remark": "查询年级分类图书列表",
     * status: "1"
     */
    private String code;
    private String message;
    private String remark;
    private String status;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int count;
        private int pageIndex;
        private List<BookData> bookList;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public List<BookData> getBookList() {
            return bookList;
        }

        public void setBookList(List<BookData> bookList) {
            this.bookList = bookList;
        }

        public static class BookData{
            private String coverUrl;
            private String bookName;
            private String gradeName;
            private String bookCode;
            private int bookPage;
            private int readNum;
            private String tag;
            private String courseCode;

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public String getBookName() {
                return bookName;
            }

            public void setBookName(String bookName) {
                this.bookName = bookName;
            }

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

            public int getBookPage() {
                return bookPage;
            }

            public void setBookPage(int bookPage) {
                this.bookPage = bookPage;
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

            public String getCourseCode() {
                return courseCode;
            }

            public void setCourseCode(String courseCode) {
                this.courseCode = courseCode;
            }
        }
    }




}
