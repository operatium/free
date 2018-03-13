package net.m;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by Administrator on 2018/1/20.
 */

public class NetBean_TaskAnswerInfo {

    public static NetBean_TaskAnswerInfo getExample(){
        String json = "    {\n" +
                "        \"code\": \"10005000\",\n" +
                "        \"data\": {\n" +
                "            \"flowers\": [\n" +
                "                {\n" +
                "                    \"answerCode\": \"A0000000003\",\n" +
                "                    \"teacherName\": \"和珅\",\n" +
                "                    \"flowerNum\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"answerCode\": \"A0000000003\",\n" +
                "                    \"teacherName\": \"张行\",\n" +
                "                    \"flowerNum\": \"3\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"comments\": [\n" +
                "                {\n" +
                "                    \"commentCode\": \"C201801111649212347448\",\n" +
                "                    \"teacherName\": \"和珅\",\n" +
                "                    \"icon\": \"http://q.qlogo.cn/qqapp/1105394063/174040CD4BCA3578053FF3C934B1C6CA/100\",\n" +
                "                    \"commentContent\": \"测试评论\",\n" +
                "                    \"createTime\": \"2018-01-11 16:49:21\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"answer\": {\n" +
                "                \"answerCode\": \"A0000000003\",\n" +
                "                \"nickName\": \"黑白世界、看不清\",\n" +
                "                \"answerInfo\": \"testtest\",\n" +
                "                \"icon\": \"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIhSmkt1IyauibarOuGNnXENUumkmjFUQtxQqrpxYF8BZkZBlq0ILDFPUG5gicKGTL0Ftj4ibJsicSgnw/0\",\n" +
                "                \"pictureNum\": \"1\",\n" +
                "                \"flowerNum\": \"5\",\n" +
                "                \"pictureUrl\": \"http://img.taopic.com/uploads/allimg/120516/159400-1205161T15625.jpg\",\n" +
                "                \"completeTime\": \"2018-01-10 11:15:30\",\n" +
                "                \"startTime\": \"2018-01-11 14:32:43\",\n" +
                "                \"endTime\": \"2018-01-11 14:32:46\",\n" +
                "                \"readTime\": \"16分钟\",\n" +
                "                \"readPage\": \"15页\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"message\": \"【调用成功】\",\n" +
                "        \"remark\": \"家长查询作业详情接口\",\n" +
                "        \"status\": \"1\"\n" +
                "    }";
        return JSON.parseObject(json,NetBean_TaskAnswerInfo.class);
    }
    /**
     * code : 10005000
     * data : {"flowers":[{"answerCode":"A0000000003","teacherName":"和珅","flowerNum":"1"},{"answerCode":"A0000000003","teacherName":"张行","flowerNum":"3"}],"comments":[{"commentCode":"C201801111649212347448","teacherName":"和珅","icon":"http://q.qlogo.cn/qqapp/1105394063/174040CD4BCA3578053FF3C934B1C6CA/100","commentContent":"测试评论","createTime":"2018-01-11 16:49:21"}],"answer":{"answerCode":"A0000000003","nickName":"黑白世界、看不清","answerInfo":"testtest","icon":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIhSmkt1IyauibarOuGNnXENUumkmjFUQtxQqrpxYF8BZkZBlq0ILDFPUG5gicKGTL0Ftj4ibJsicSgnw/0","pictureNum":"1","flowerNum":"5","pictureUrl":null,"completeTime":"2018-01-10 11:15:30","startTime":"2018-01-11 14:32:43","endTime":"2018-01-11 14:32:46","readTime":"16分钟","readPage":"15页"}}
     * message : 【调用成功】
     * remark : 家长查询作业详情接口
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
         * flowers : [{"answerCode":"A0000000003","teacherName":"和珅","flowerNum":"1"},{"answerCode":"A0000000003","teacherName":"张行","flowerNum":"3"}]
         * comments : [{"commentCode":"C201801111649212347448","teacherName":"和珅","icon":"http://q.qlogo.cn/qqapp/1105394063/174040CD4BCA3578053FF3C934B1C6CA/100","commentContent":"测试评论","createTime":"2018-01-11 16:49:21"}]
         * answer : {"answerCode":"A0000000003","nickName":"黑白世界、看不清","answerInfo":"testtest","icon":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIhSmkt1IyauibarOuGNnXENUumkmjFUQtxQqrpxYF8BZkZBlq0ILDFPUG5gicKGTL0Ftj4ibJsicSgnw/0","pictureNum":"1","flowerNum":"5","pictureUrl":null,"completeTime":"2018-01-10 11:15:30","startTime":"2018-01-11 14:32:43","endTime":"2018-01-11 14:32:46","readTime":"16分钟","readPage":"15页"}
         */

        private AnswerBean answer;
        private List<FlowersBean> flowers;
        private List<CommentsBean> comments;

        public AnswerBean getAnswer() {
            return answer;
        }

        public void setAnswer(AnswerBean answer) {
            this.answer = answer;
        }

        public List<FlowersBean> getFlowers() {
            return flowers;
        }

        public void setFlowers(List<FlowersBean> flowers) {
            this.flowers = flowers;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class AnswerBean {
            /**
             * answerCode : A0000000003
             * nickName : 黑白世界、看不清
             * answerInfo : testtest
             * icon : http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIhSmkt1IyauibarOuGNnXENUumkmjFUQtxQqrpxYF8BZkZBlq0ILDFPUG5gicKGTL0Ftj4ibJsicSgnw/0
             * pictureNum : 1
             * flowerNum : 5
             * pictureUrl : null
             * completeTime : 2018-01-10 11:15:30
             * startTime : 2018-01-11 14:32:43
             * endTime : 2018-01-11 14:32:46
             * readTime : 16分钟
             * readPage : 15页
             */

            private String answerCode;
            private String nickName;
            private String answerInfo;
            private String icon;
            private String pictureNum;
            private String flowerNum;
            private String pictureUrl;
            private String completeTime;
            private String startTime;
            private String endTime;
            private String readTime;
            private String readPage;

            public String getAnswerCode() {
                return answerCode;
            }

            public void setAnswerCode(String answerCode) {
                this.answerCode = answerCode;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getAnswerInfo() {
                return answerInfo;
            }

            public void setAnswerInfo(String answerInfo) {
                this.answerInfo = answerInfo;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getPictureNum() {
                return pictureNum;
            }

            public void setPictureNum(String pictureNum) {
                this.pictureNum = pictureNum;
            }

            public String getFlowerNum() {
                return flowerNum;
            }

            public void setFlowerNum(String flowerNum) {
                this.flowerNum = flowerNum;
            }

            public String getPictureUrl() {
                return pictureUrl;
            }

            public void setPictureUrl(String pictureUrl) {
                this.pictureUrl = pictureUrl;
            }

            public String getCompleteTime() {
                return completeTime;
            }

            public void setCompleteTime(String completeTime) {
                this.completeTime = completeTime;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getReadTime() {
                return readTime;
            }

            public void setReadTime(String readTime) {
                this.readTime = readTime;
            }

            public String getReadPage() {
                return readPage;
            }

            public void setReadPage(String readPage) {
                this.readPage = readPage;
            }
        }

        public static class FlowersBean {
            /**
             * answerCode : A0000000003
             * teacherName : 和珅
             * flowerNum : 1
             */

            private String answerCode;
            private String teacherName;
            private String flowerNum;

            public String getAnswerCode() {
                return answerCode;
            }

            public void setAnswerCode(String answerCode) {
                this.answerCode = answerCode;
            }

            public String getTeacherName() {
                return teacherName;
            }

            public void setTeacherName(String teacherName) {
                this.teacherName = teacherName;
            }

            public String getFlowerNum() {
                return flowerNum;
            }

            public void setFlowerNum(String flowerNum) {
                this.flowerNum = flowerNum;
            }
        }

        public static class CommentsBean {
            /**
             * commentCode : C201801111649212347448
             * teacherName : 和珅
             * icon : http://q.qlogo.cn/qqapp/1105394063/174040CD4BCA3578053FF3C934B1C6CA/100
             * commentContent : 测试评论
             * createTime : 2018-01-11 16:49:21
             */

            private String commentCode;
            private String teacherName;
            private String icon;
            private String commentContent;
            private String createTime;

            public String getCommentCode() {
                return commentCode;
            }

            public void setCommentCode(String commentCode) {
                this.commentCode = commentCode;
            }

            public String getTeacherName() {
                return teacherName;
            }

            public void setTeacherName(String teacherName) {
                this.teacherName = teacherName;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getCommentContent() {
                return commentContent;
            }

            public void setCommentContent(String commentContent) {
                this.commentContent = commentContent;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
