package net.m;

/**
 * Created by java on 2017/10/18.
 */

public class MessageEvent {
    int type;
    int what1;
    int what2;
    Object object1;
    Object object2;
    Object object3;

    public static final int ActivityIsBackground = 100;//APP切到后台
    public static final int TOAST = 101;//APP后台服务提供弹窗
    public static final int StopProgressBar = 102;//关闭进度条
    public static final int FINISH = 103;//关闭activity
    public static final int APKDownloadProgress = 104;//APP下载更新
    public static final int BookDownloadProgress = 105;//书籍的下载进度
    public static final int BookUnZipProgress = 106;//解压进度


    public static final int PARENT_LIBRARYTYPEACTIVITY_NO_OR_HAS_DATA = 20000; // 家长端 图书分类没有/有数据
    public static final int PARENT_LIBRARYTYPEACTIVITY_NET_ERR = PARENT_LIBRARYTYPEACTIVITY_NO_OR_HAS_DATA + 1; // 网络错误
    public static final int PARENT_LIBRARYTYPEACTIVITY_REFESH = PARENT_LIBRARYTYPEACTIVITY_NET_ERR + 1; // 数据刷新


    public static final int Teacher_HomeActivity_HomeFragment_Refersh =10001;//老师端 刷新界面
    public static final int Teacher_HomeActivity_HomeFragment_InvitationShow=10002;//弹出 邀请界面底部弹窗
    public static final int Teacher_SelectLessonActivity_SelectLesson=10003;//选择一本书，选中课程
    public static final int Teacher_LessonActivity_DownloadSetProgress = 10004;//下载进度
    public static final int Teacher_LessonActivity_DownloadPending = 100017;//下载进度pending状态
    public static final int Teacher_LessonActivity_ZipSetProgress = 10005;//解压进度
    public static final int Teacher_TaskInfoActivity_ScaleImage = 10006;//放大查看图片
    public static final int Teacher_TaskInfoActivity_CloseScaleImage = 10007;//关闭查看器
    public static final int Teacher_TaskInfoActivity_Refersh = 10008;//刷新界面
    public static final int Teacher_ClassManagerActivity_RemoveParent = 10009;//删除家长
    public static final int Teacher_ClassManagerActivity_RemoveParentSuccess = 10010;//删除家长成功
    public static final int Teacher_Home_Dialog_ShowBookRoomMultipleChoice = 10011;//activity打开书房多选的操作菜单
    public static final int Teacher_CloseBookRoomMultipleChoice = 10012;//fargment关闭书房多选的列表项操作
    public static final int Teacher_BookRoomNoData = 10013;//fargment书房无数据
    public static final int Teacher_StartActivity_TeacherNotHaveClass = 10014;//跳转老师没有班级
    public static final int Teacher_Shape = 10015;//分享
    public static final int Teacher_LessonActivity_ZipSetProgressSuccess = 10016;//解压成功
    public static final int Teacher_LessonListActivity_StartActivityLesson = 10017;//跳转课程详情
    public static final int Teacher_TeacherLibraryTypeAdapter_Count = 10018;//图书馆图书分类界面，列表的数量，提示没有内容

    public static final int Login_ChangePasswordActivity_RefershTime = 11000;//倒计时60

    public static final int PARENT_HOME_SWITCH = 12000; //父母首页切换tab
    public static final int PARENT_ACCOUNT_AVATAR_UPLOAD_SUCCESS = 12001;//我的头像上传完成
    public static final int PARENT_ACCOUNT_AVATAR_UPLOAD_FAIL = 12004;//我的头像上传失败
    public static final int PARENT_RELEASE_TASK_PHOTO = 12002;//发布作业的照片文件转换为uri后
	public static final int PARENT_RELEASE_TASK_COMMENT_BACK = 12003;//从评论页返回作业箱
	public static final int PARENT_FINISH_GLORY_WALL = 12005;//关闭荣誉墙
	public static final int PARENT_NET_CHANGE = 12006;//网络变化

    public int getType() {
        return type;
    }

    public MessageEvent setType(int type) {
        this.type = type;
        return this;
    }

    public int getWhat1() {
        return what1;
    }

    public MessageEvent setWhat1(int what1) {
        this.what1 = what1;
        return this;
    }

    public int getWhat2() {
        return what2;
    }

    public MessageEvent setWhat2(int what2) {
        this.what2 = what2;
        return this;
    }

    public Object getObject1() {
        return object1;
    }

    public MessageEvent setObject1(Object object1) {
        this.object1 = object1;
        return this;
    }

    public Object getObject2() {
        return object2;
    }

    public MessageEvent setObject2(Object object2) {
        this.object2 = object2;
        return this;
    }

    public Object getObject3() {
        return object3;
    }

    public MessageEvent setObject3(Object object3) {
        this.object3 = object3;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MessageEvent) {
            return ((MessageEvent) obj).getObject1().equals(object1);
        }
        return super.equals(obj);
    }
}
