package net.m;

import java.util.List;

/**
 * Created by java on 2018/1/19.
 */

public class NetBean_Task {
    /**
     * code : 10005000
     * data : {"homeTask":{"taskDetail":"看书拍照","createTime":"今天"},"unfinished":{"num":"0","list":[{"answerCode":"","nickName":"小明爸爸","icon":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ768l0EC5M9wSDy77sQJvjzn3jssdCic9JBKrWZIqLHHuGdaH7fyouXaExINhXYff06CFW8xkhdCQ/0","completeTime":null}]},"finished":{"num":"1","list":[{"answerCode":"A0000000003","nickName":"小明妈妈","icon":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ768l0EC5M9wSDy77sQJvjzn3jssdCic9JBKrWZIqLHHuGdaH7fyouXaExINhXYff06CFW8xkhdCQ/0","completeTime":"1天前提交"}]}}
     * message : 【调用成功】
     * remark : 老师查看作业完成情况接口
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
         * homeTask : {"taskDetail":"看书拍照","createTime":"今天"}
         * unfinished : {"num":"0","list":[{"answerCode":"","nickName":"小明爸爸","icon":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ768l0EC5M9wSDy77sQJvjzn3jssdCic9JBKrWZIqLHHuGdaH7fyouXaExINhXYff06CFW8xkhdCQ/0","completeTime":null}]}
         * finished : {"num":"1","list":[{"answerCode":"A0000000003","nickName":"小明妈妈","icon":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ768l0EC5M9wSDy77sQJvjzn3jssdCic9JBKrWZIqLHHuGdaH7fyouXaExINhXYff06CFW8xkhdCQ/0","completeTime":"1天前提交"}]}
         */

        private HomeTaskBean homeTask;
        private UnfinishedBean unfinished;
        private FinishedBean finished;

        public HomeTaskBean getHomeTask() {
            return homeTask;
        }

        public void setHomeTask(HomeTaskBean homeTask) {
            this.homeTask = homeTask;
        }

        public UnfinishedBean getUnfinished() {
            return unfinished;
        }

        public void setUnfinished(UnfinishedBean unfinished) {
            this.unfinished = unfinished;
        }

        public FinishedBean getFinished() {
            return finished;
        }

        public void setFinished(FinishedBean finished) {
            this.finished = finished;
        }

        public static class HomeTaskBean {
            /**
             * taskDetail : 看书拍照
             * createTime : 今天
             */

            private String taskDetail;
            private String createTime;

            public String getTaskDetail() {
                return taskDetail;
            }

            public void setTaskDetail(String taskDetail) {
                this.taskDetail = taskDetail;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }

        public static class UnfinishedBean {
            /**
             * num : 0
             * list : [{"answerCode":"","nickName":"小明爸爸","icon":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ768l0EC5M9wSDy77sQJvjzn3jssdCic9JBKrWZIqLHHuGdaH7fyouXaExINhXYff06CFW8xkhdCQ/0","completeTime":null}]
             */

            private String num;
            private List<ListBean> list;

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * answerCode :
                 * nickName : 小明爸爸
                 * icon : http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ768l0EC5M9wSDy77sQJvjzn3jssdCic9JBKrWZIqLHHuGdaH7fyouXaExINhXYff06CFW8xkhdCQ/0
                 * completeTime : null
                 */

                private String answerCode;
                private String nickName;
                private String icon;
                private Object completeTime;

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

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public Object getCompleteTime() {
                    return completeTime;
                }

                public void setCompleteTime(Object completeTime) {
                    this.completeTime = completeTime;
                }
            }
        }

        public static class FinishedBean {
            /**
             * num : 1
             * list : [{"answerCode":"A0000000003","nickName":"小明妈妈","icon":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ768l0EC5M9wSDy77sQJvjzn3jssdCic9JBKrWZIqLHHuGdaH7fyouXaExINhXYff06CFW8xkhdCQ/0","completeTime":"1天前提交"}]
             */

            private String num;
            private List<ListBeanX> list;

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {
                /**
                 * answerCode : A0000000003
                 * nickName : 小明妈妈
                 * icon : http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ768l0EC5M9wSDy77sQJvjzn3jssdCic9JBKrWZIqLHHuGdaH7fyouXaExINhXYff06CFW8xkhdCQ/0
                 * completeTime : 1天前提交
                 */

                private String answerCode;
                private String nickName;
                private String icon;
                private String completeTime;

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

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getCompleteTime() {
                    return completeTime;
                }

                public void setCompleteTime(String completeTime) {
                    this.completeTime = completeTime;
                }
            }
        }
    }
}
