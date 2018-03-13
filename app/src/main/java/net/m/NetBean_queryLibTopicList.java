package net.m;

import java.util.List;

/**
 * @autor hongbing
 * @date 2018/3/10
 */
public class NetBean_queryLibTopicList {

    /**
     * code : 10001000
     * data : {"pageIndex":1,"count":10,"bookList":[{"topicCode":"T20180305140121601","topicImg":"http://kindergarten.ellabook.cn/96a3af5e40b447f19a8284b5e327101e.jpg","topicSubTitle":"这是一篇测试文章副标题","topicTitle":"这是一篇测试文章标题","targetPage":"http://member.ellabook.cn/085b48e84360443a85b1b6e5e16392a1.html"},{"topicCode":"T20180305110637974","topicImg":"http://kindergarten.ellabook.cn/e5d8da5de69d41a0bfa63d16b7abb572.jpg","topicSubTitle":"测试","topicTitle":"测试","targetPage":"http://member.ellabook.cn/c261ca1e87c242989ee0e168c52f47c6.html"},{"topicCode":"T20180305203128585","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"55667778888","targetPage":"5555555555555111"},{"topicCode":"T20180305202410067","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"556677789999","targetPage":"5555555555555111"},{"topicCode":"T20180305110038204","topicImg":"http://kindergarten.ellabook.cn/c8e3cbcefb654b0da94c476ee776002e.jpg","topicSubTitle":"123","topicTitle":"123","targetPage":"http://member.ellabook.cn/ea4243996d12452ca22b7619fa531a18.html"},{"topicCode":"T20180305105504721","topicImg":"http://kindergarten.ellabook.cn/9c0cd8a29b4342d3a6760a17454f1d1a.jpg","topicSubTitle":"123123","topicTitle":"123","targetPage":"http://member.ellabook.cn/d1550bdabd13411e849d6387e0e3d0e1.html"},{"topicCode":"T20180305101643854","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"55667778888","targetPage":"5555555555555111"},{"topicCode":"T20180302151807547","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"55667778888","targetPage":"5555555555555111"},{"topicCode":"T20180302150632194","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"55667778888","targetPage":"5555555555555111"},{"topicCode":"T20180302143234784","topicImg":"http://member.ellabook.cn/dd89e497ba6c4316941e7dcc9cd64c5e","topicSubTitle":"222222111","topicTitle":"愿每个孩子都是玛德琳","targetPage":"5555555555555111"}]}
     * message : 【调用成功】
     * remark : 查询图书馆专题列表
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
         * pageIndex : 1
         * count : 10
         * bookList : [{"topicCode":"T20180305140121601","topicImg":"http://kindergarten.ellabook.cn/96a3af5e40b447f19a8284b5e327101e.jpg","topicSubTitle":"这是一篇测试文章副标题","topicTitle":"这是一篇测试文章标题","targetPage":"http://member.ellabook.cn/085b48e84360443a85b1b6e5e16392a1.html"},{"topicCode":"T20180305110637974","topicImg":"http://kindergarten.ellabook.cn/e5d8da5de69d41a0bfa63d16b7abb572.jpg","topicSubTitle":"测试","topicTitle":"测试","targetPage":"http://member.ellabook.cn/c261ca1e87c242989ee0e168c52f47c6.html"},{"topicCode":"T20180305203128585","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"55667778888","targetPage":"5555555555555111"},{"topicCode":"T20180305202410067","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"556677789999","targetPage":"5555555555555111"},{"topicCode":"T20180305110038204","topicImg":"http://kindergarten.ellabook.cn/c8e3cbcefb654b0da94c476ee776002e.jpg","topicSubTitle":"123","topicTitle":"123","targetPage":"http://member.ellabook.cn/ea4243996d12452ca22b7619fa531a18.html"},{"topicCode":"T20180305105504721","topicImg":"http://kindergarten.ellabook.cn/9c0cd8a29b4342d3a6760a17454f1d1a.jpg","topicSubTitle":"123123","topicTitle":"123","targetPage":"http://member.ellabook.cn/d1550bdabd13411e849d6387e0e3d0e1.html"},{"topicCode":"T20180305101643854","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"55667778888","targetPage":"5555555555555111"},{"topicCode":"T20180302151807547","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"55667778888","targetPage":"5555555555555111"},{"topicCode":"T20180302150632194","topicImg":"99999999111","topicSubTitle":"222222111","topicTitle":"55667778888","targetPage":"5555555555555111"},{"topicCode":"T20180302143234784","topicImg":"http://member.ellabook.cn/dd89e497ba6c4316941e7dcc9cd64c5e","topicSubTitle":"222222111","topicTitle":"愿每个孩子都是玛德琳","targetPage":"5555555555555111"}]
         */

        private int pageIndex;
        private int count;
        private List<BookListBean> bookList;

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

        public List<BookListBean> getBookList() {
            return bookList;
        }

        public void setBookList(List<BookListBean> bookList) {
            this.bookList = bookList;
        }

        public static class BookListBean {
            /**
             * topicCode : T20180305140121601
             * topicImg : http://kindergarten.ellabook.cn/96a3af5e40b447f19a8284b5e327101e.jpg
             * topicSubTitle : 这是一篇测试文章副标题
             * topicTitle : 这是一篇测试文章标题
             * targetPage : http://member.ellabook.cn/085b48e84360443a85b1b6e5e16392a1.html
             */

            private String topicCode;
            private String topicImg;
            private String topicSubTitle;
            private String topicTitle;
            private String targetPage;

            public String getTopicCode() {
                return topicCode;
            }

            public void setTopicCode(String topicCode) {
                this.topicCode = topicCode;
            }

            public String getTopicImg() {
                return topicImg;
            }

            public void setTopicImg(String topicImg) {
                this.topicImg = topicImg;
            }

            public String getTopicSubTitle() {
                return topicSubTitle;
            }

            public void setTopicSubTitle(String topicSubTitle) {
                this.topicSubTitle = topicSubTitle;
            }

            public String getTopicTitle() {
                return topicTitle;
            }

            public void setTopicTitle(String topicTitle) {
                this.topicTitle = topicTitle;
            }

            public String getTargetPage() {
                return targetPage;
            }

            public void setTargetPage(String targetPage) {
                this.targetPage = targetPage;
            }
        }
    }
}
