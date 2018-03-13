package net.m;

import java.util.List;

/**
 * Created by java on 2018/1/22.
 */

public class NetBean_ClassManager {

    /**
     * code : 0x00000000
     * data : {"teacherInfo":[{"uid":"HT20180122145030145280","name":"闫磊卡卡c","icon":"http://kindergarten.ellabook.cn/e437e765cf9941d582459db319b44c5f.jpg","role":"老师"},{"uid":"HT20180122145030145185","name":"红领巾","icon":"","role":"老师"},{"uid":"HT20180122145030145712","name":"吴老师2","icon":"","role":"老师"},{"uid":"HT20180122145030145185","name":"红领巾","icon":"","role":"老师"}],"userNum":{"parentNum":5,"teacherNum":3},"parentInfo":[{"uid":"U201801231604376102875","name":"请输入新昵称","icon":"http://kindergarten.ellabook.cn/7466d3ad44ff49fca91356268b571795.png","role":"熊三爸爸"},{"uid":"U201801231605001543593","name":"熊四外公","icon":"http://kindergarten.ellabook.cn/7f9edaf3b8d3410985cc3b6ad4e72c66.png","role":"熊四外公"},{"uid":"U201801241441116549601","name":"熊七外公","icon":"","role":"熊七外公"},{"uid":"U201801241441125395733","name":"熊七外公","icon":"","role":"熊七外公"},{"uid":"U201801241441123405420","name":"熊七外公","icon":"","role":"熊七外公"}]}
     * message : 【调用成功】
     * remark : 咿啦家园 - 班级管理
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
         * teacherInfo : [{"uid":"HT20180122145030145280","name":"闫磊卡卡c","icon":"http://kindergarten.ellabook.cn/e437e765cf9941d582459db319b44c5f.jpg","role":"老师"},{"uid":"HT20180122145030145185","name":"红领巾","icon":"","role":"老师"},{"uid":"HT20180122145030145712","name":"吴老师2","icon":"","role":"老师"},{"uid":"HT20180122145030145185","name":"红领巾","icon":"","role":"老师"}]
         * userNum : {"parentNum":5,"teacherNum":3}
         * parentInfo : [{"uid":"U201801231604376102875","name":"请输入新昵称","icon":"http://kindergarten.ellabook.cn/7466d3ad44ff49fca91356268b571795.png","role":"熊三爸爸"},{"uid":"U201801231605001543593","name":"熊四外公","icon":"http://kindergarten.ellabook.cn/7f9edaf3b8d3410985cc3b6ad4e72c66.png","role":"熊四外公"},{"uid":"U201801241441116549601","name":"熊七外公","icon":"","role":"熊七外公"},{"uid":"U201801241441125395733","name":"熊七外公","icon":"","role":"熊七外公"},{"uid":"U201801241441123405420","name":"熊七外公","icon":"","role":"熊七外公"}]
         */

        private UserNumBean userNum;
        private List<TeacherInfoBean> teacherInfo;
        private List<ParentInfoBean> parentInfo;

        public UserNumBean getUserNum() {
            return userNum;
        }

        public void setUserNum(UserNumBean userNum) {
            this.userNum = userNum;
        }

        public List<TeacherInfoBean> getTeacherInfo() {
            return teacherInfo;
        }

        public void setTeacherInfo(List<TeacherInfoBean> teacherInfo) {
            this.teacherInfo = teacherInfo;
        }

        public List<ParentInfoBean> getParentInfo() {
            return parentInfo;
        }

        public void setParentInfo(List<ParentInfoBean> parentInfo) {
            this.parentInfo = parentInfo;
        }

        public static class UserNumBean {
            /**
             * parentNum : 5
             * teacherNum : 3
             */

            private int parentNum;
            private int teacherNum;

            public int getParentNum() {
                return parentNum;
            }

            public void setParentNum(int parentNum) {
                this.parentNum = parentNum;
            }

            public int getTeacherNum() {
                return teacherNum;
            }

            public void setTeacherNum(int teacherNum) {
                this.teacherNum = teacherNum;
            }
        }

        public static class TeacherInfoBean {
            /**
             * uid : HT20180122145030145280
             * name : 闫磊卡卡c
             * icon : http://kindergarten.ellabook.cn/e437e765cf9941d582459db319b44c5f.jpg
             * role : 老师
             */

            private String uid;
            private String name;
            private String icon;
            private String role;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class ParentInfoBean {
            /**
             * uid : U201801231604376102875
             * name : 请输入新昵称
             * icon : http://kindergarten.ellabook.cn/7466d3ad44ff49fca91356268b571795.png
             * role : 熊三爸爸
             */

            private String uid;
            private String name;
            private String icon;
            private String role;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }
    }
}
