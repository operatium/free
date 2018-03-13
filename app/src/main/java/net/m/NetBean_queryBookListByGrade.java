package net.m;

import java.util.List;

/**
 * 年级分类图书列表数据封装
 * @autor hongbing
 * @date 2018/3/6
 */
public class NetBean_queryBookListByGrade {

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
        private int pageIndex;
        private int count;
        private List<BookData> bookList;

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<BookData> getBookList() {
            return bookList;
        }

        public void setBookList(List<BookData> bookList) {
            this.bookList = bookList;
        }

        public static class BookData {

            private String coverUrl;
            private String gradeName;
            private String bookCode;
            private int readNum;
            private int bookPage;
            private String bookName;
            private String tag;
            private String courseStatus;

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
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

            public int getReadNum() {
                return readNum;
            }

            public void setReadNum(int readNum) {
                this.readNum = readNum;
            }

            public int getBookPage() {
                return bookPage;
            }

            public void setBookPage(int bookPage) {
                this.bookPage = bookPage;
            }

            public String getBookName() {
                return bookName;
            }

            public void setBookName(String bookName) {
                this.bookName = bookName;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
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
