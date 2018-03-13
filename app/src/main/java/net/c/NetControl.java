package net.c;

import android.content.Context;
import android.util.Log;

import net.i.NetCallback;
import net.i.SimpleNetCacheCallback;
import net.m.NetBean_Login;
import net.m.NetBean_AddBookToStudy;
import net.m.NetBean_AddTaskComment;
import net.m.NetBean_Banner;
import net.m.NetBean_BeijingTime;
import net.m.NetBean_BookDetail4Library;
import net.m.NetBean_BookRoom;
import net.m.NetBean_ChangePassword;
import net.m.NetBean_ClassManager;
import net.m.NetBean_CreateTask;
import net.m.NetBean_GetClassByUid;
import net.m.NetBean_GetCode;
import net.m.NetBean_LessonInfo;
import net.m.NetBean_LessonList;
import net.m.NetBean_Login;
import net.m.NetBean_QueryLibIndex;
import net.m.NetBean_RemoveParent;
import net.m.NetBean_SelectLessonList;
import net.m.NetBean_SetUserInfo;
import net.m.NetBean_Task;
import net.m.NetBean_TaskAnswerInfo;
import net.m.NetBean_UpFile;
import net.m.NetBean_UpdataClassName;
import net.m.NetBean_Version;
import net.m.NetBean_activeVipCard;
import net.m.NetBean_activeVipHistory;
import net.m.NetBean_newLessonInfo;
import net.m.NetBean_queryBookListByDomain;
import net.m.NetBean_queryBookListByGrade;
import net.m.NetBean_queryLibTopicList;
import control.AppControl;
import control.FileControl;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by java on 2017/10/24.
 */

public class NetControl {

    private static String resouce = "android";
    public static String str_NetFail = "似乎出了点问题，再试一次";
    public static String str_NetError = "啊哦，网络不太顺畅哦~";



    //登录
    public static void login(int cachemode, final String account, final String password, final NetCallback<NetBean_Login> callback){
        Context context = AppControl.getInstance().getContext();
        final String key = "login_"+account+password;
        final String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_Login>().runhttp(context, dir, key, NetBean_Login.class, BaseNetCacheMode.getMode(cachemode)
                , new SimpleNetCacheCallback<NetBean_Login>() {
                    @Override
                    public void onCache(NetBean_Login netBean_login) {
                        if (netBean_login == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_login);
                    }

                    @Override
                    public void httpTask(Func1<String, NetBean_Login> mapfunc, Subscriber<NetBean_Login> callback) {
                        HttpTask.login(account, password, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_Login netBean_login) {
                        if (netBean_login == null)
                            return;
                        if (callback != null) {
                            if (netBean_login.getStatus().equals("1")) {
                                callback.success(netBean_login);
                            } else {
                                callback.fail(netBean_login);
                            }
                        }
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_Login netBean_login) {
                        return false;
                    }
                }, null);
    }

    //获取验证码
    public static void getCode(int cachemode, final String mobile, final NetCallback<NetBean_GetCode> callback){
        Context context = AppControl.getInstance().getContext();
        final String key = "getcode_"+mobile;
        final String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_GetCode>().runhttp(context, dir, key, NetBean_GetCode.class, BaseNetCacheMode.getMode(cachemode)
                , new SimpleNetCacheCallback<NetBean_GetCode>() {
                    @Override
                    public void onCache(NetBean_GetCode netBean_login) {
                        if (netBean_login == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_login);
                    }

                    @Override
                    public void httpTask(Func1<String, NetBean_GetCode> mapfunc, Subscriber<NetBean_GetCode> callback) {
                        HttpTask.getCode(mobile,"1", mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_GetCode netdata) {
                        if (netdata == null)
                            return;
                        if (callback != null) {
                            if (netdata.getStatus().equals("1")) {
                                callback.success(netdata);
                            } else {
                                callback.fail(netdata);
                            }
                        }
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_GetCode netBean_login) {
                        return false;
                    }
                },null);
    }

    //修改密码
    public static void changePassword(int cachemode, final String customerName, final String password, final String checkCode, final NetCallback<NetBean_ChangePassword> callback){
        Context context = AppControl.getInstance().getContext();
        final String key = "changepassword_"+customerName;
        final String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_ChangePassword>().runhttp(context, dir, key, NetBean_ChangePassword.class, BaseNetCacheMode.getMode(cachemode)
                , new SimpleNetCacheCallback<NetBean_ChangePassword>() {
                    @Override
                    public void onCache(NetBean_ChangePassword netBean_login) {
                        if (netBean_login == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_login);
                    }

                    @Override
                    public void httpTask(Func1<String, NetBean_ChangePassword> mapfunc, Subscriber<NetBean_ChangePassword> callback) {
                        HttpTask.changePassword(customerName,password, checkCode,mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_ChangePassword netdata) {
                        if (netdata == null)
                            return;
                        if (callback != null) {
                            if (netdata.getStatus().equals("1")) {
                                callback.success(netdata);
                            } else {
                                callback.fail(netdata);
                            }
                        }
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_ChangePassword netBean_login) {
                        return false;
                    }
                },null);
    }

    //banner
    public static void getBanner(int cachemode, final boolean isteacher, final NetCallback<NetBean_Banner> callback){
        Context context = AppControl.getInstance().getContext();
        final String key = "changepassword_"+isteacher;
        final String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_Banner>().runhttp(context, dir, key, NetBean_Banner.class, BaseNetCacheMode.getMode(cachemode)
                , new SimpleNetCacheCallback<NetBean_Banner>() {
                    @Override
                    public void onCache(NetBean_Banner netBean_login) {
                        if (netBean_login == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_login);
                    }

                    @Override
                    public void httpTask(Func1<String, NetBean_Banner> mapfunc, Subscriber<NetBean_Banner> callback) {
                        String str = "parent";
                        if (isteacher)
                            str = "teacher";
                        HttpTask.getBanner(str,mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_Banner netdata) {
                        if (netdata == null)
                            return;
                        if (callback != null) {
                            if (netdata.getStatus().equals("1")) {
                                callback.success(netdata);
                            } else {
                                callback.fail(netdata);
                            }
                        }
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_Banner netdata) {
                        return netdata != null && netdata.getStatus().equals("1");
                    }
                },null);
    }

    //获取老师端和家长端班级列表和首页课程
    public static void getClassByUid(int cachemode, final String uid, final boolean isteacher, final NetCallback<NetBean_GetClassByUid> callback) {
        Context context = AppControl.getInstance().getContext();
        final String key = "getclassbyuid_"+isteacher;
        final String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_GetClassByUid>().runhttp(context, dir, key, NetBean_GetClassByUid.class, BaseNetCacheMode.getMode(cachemode)
                , new SimpleNetCacheCallback<NetBean_GetClassByUid>() {
                    @Override
                    public void onCache(NetBean_GetClassByUid netBean_login) {
                        if (netBean_login == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_login);
                    }

                    @Override
                    public void httpTask(Func1<String, NetBean_GetClassByUid> mapfunc, Subscriber<NetBean_GetClassByUid> callback) {
                        String str = "PARENT";
                        if (isteacher)
                            str = "TEACHER";
                        HttpTask.getClassByUid(uid, str, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_GetClassByUid netdata) {
                        if (netdata == null)
                            return;
                        if (callback != null) {
                            if (netdata.getStatus().equals("1")) {
                                callback.success(netdata);
                            } else {
                                callback.fail(netdata);
                            }
                        }
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_GetClassByUid netdata) {
                        return netdata != null && netdata.getStatus().equals("1");
                    }
                }, null);
    }

    //获取课程详情
    public static void getCourseDetail(int cachemode, final String uid, final String taskCode, final String bookCode
            , final String classCode, final String weekNum, final String semester, final NetCallback<NetBean_LessonInfo> callback) {
        Context context = AppControl.getInstance().getContext();
        final String key = "getcoursedetail"+bookCode+classCode;
        final String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_LessonInfo>().runhttp(context, dir, key, NetBean_LessonInfo.class, BaseNetCacheMode.getMode(cachemode)
                , new SimpleNetCacheCallback<NetBean_LessonInfo>() {
                    @Override
                    public void onCache(NetBean_LessonInfo netBean_login) {
                        //拦截会返回null
                        if (netBean_login == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_login);
                    }

                    @Override
                    public void httpTask(Func1<String, NetBean_LessonInfo> mapfunc, Subscriber<NetBean_LessonInfo> callback) {
                        HttpTask.getCourseDetail(uid, taskCode, bookCode, classCode, weekNum, semester, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_LessonInfo netdata) {
                        if (netdata == null)//拦截会返回null
                            return;
                        if (callback != null) {
                            if (netdata.getStatus().equals("1")) {
                                callback.success(netdata);
                            } else {
                                callback.fail(netdata);
                            }
                        }
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_LessonInfo netdata) {
                        return netdata != null && netdata.getStatus().equals("1");
                    }
                },null);
    }

    //老师端的课程表内的获取课程详情
    public static void newGetLessonInfo(int cachemode, final String uid, final String taskCode, final String bookCode
            , final String classCode,final String weekNum,final String semester, final NetCallback<NetBean_newLessonInfo> callback) {
        Context context = AppControl.getInstance().getContext();
        final String key = "newGetLessonInfo"+bookCode+classCode+weekNum;
        final String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_newLessonInfo>().runhttp(context, dir, key, NetBean_newLessonInfo.class, BaseNetCacheMode.getMode(cachemode)
                , new SimpleNetCacheCallback<NetBean_newLessonInfo>() {
                    @Override
                    public void onCache(NetBean_newLessonInfo netBean_login) {
                        //拦截会返回null
                        if (netBean_login == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_login);
                    }

                    @Override
                    public void httpTask(Func1<String, NetBean_newLessonInfo> mapfunc, Subscriber<NetBean_newLessonInfo> callback) {
                        HttpTask.getLessonInfo(bookCode, classCode, uid, taskCode, weekNum, semester, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_newLessonInfo netdata) {
                        if (netdata == null)//拦截会返回null
                            return;
                        if (callback != null) {
                            if (netdata.getStatus().equals("1")) {
                                callback.success(netdata);
                            } else {
                                callback.fail(netdata);
                            }
                        }
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_newLessonInfo netdata) {
                        return netdata != null && netdata.getStatus().equals("1");
                    }
                },null);
    }

    //获取北京时间
    public static void getBeijingTime(int cachemode, final NetCallback<NetBean_BeijingTime> callback){
        Context context = AppControl.getInstance().getContext();
        final String key = "getbeijingtime";
        final String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_BeijingTime>().runhttp(context,dir,key,NetBean_BeijingTime.class,BaseNetCacheMode.getMode(cachemode)
                , new SimpleNetCacheCallback<NetBean_BeijingTime>(){
                    @Override
                    public void onCache(NetBean_BeijingTime netBean_login) {
                        if (netBean_login == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_login);
                    }

                    @Override
                    public void httpTask(Func1<String, NetBean_BeijingTime> mapfunc, Subscriber<NetBean_BeijingTime> callback) {
                        HttpTask.getBeijingTime(mapfunc,callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_BeijingTime netBean_login) {
                        if (netBean_login == null)
                            return;
                        if (callback != null) {
                            if (netBean_login.getSuccess().equals("1")) {
                                callback.success(netBean_login);
                            } else {
                                callback.fail(netBean_login);
                            }
                        }
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_BeijingTime netBean_login) {
                        return netBean_login != null && netBean_login.getSuccess().equals("1");
                    }
                },null);
    }



    //获取老师端的课程表
    public static void getLessonList(final int cachemode, final String uid, boolean isTeacher,
                                     final String classGrade, final String courseType,
                                     final NetCallback<NetBean_LessonList> callback) {
        String key = "getLessonList"+classGrade+courseType;
        String dir = FileControl.getUserTempDir();
        Context context = AppControl.getInstance().getContext();
        final String userType = isTeacher ? "TEACHER" : "PARENT";
        new BaseNetCacheMode<NetBean_LessonList>().runhttp(context, dir, key, NetBean_LessonList.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_LessonList>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_LessonList> mapfunc, Subscriber<NetBean_LessonList> callback) {
                        HttpTask.getLessonList(uid, userType,
                                classGrade, courseType, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_LessonList data) {
                        if (data == null)
                            return;
                        if ("1".equals(data.getStatus())) {
                            if (callback != null)
                                callback.success(data);
                        } else {
                            if (callback != null)
                                callback.fail(data);
                        }
                    }

                    @Override
                    public void onCache(NetBean_LessonList data) {
                        if (data == null)
                            return;
                        if (callback != null)
                            callback.onCache(data);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_LessonList data) {
                        return data != null && "1".equals(data.getStatus());
                    }
                }, null);
    }

    //版本控制
    public static void getVersion(int cachemode,final NetCallback<NetBean_Version> callback) {
        String key = "getVersion";
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_Version>().runhttp(context, dir, key, NetBean_Version.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_Version>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_Version> mapfunc, Subscriber<NetBean_Version> callback) {
                        HttpTask.getVersion(mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_Version netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_Version netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_Version netBean_account) {
                        return netBean_account != null && "1".equals(netBean_account.getStatus());
                    }
                },null);
    }

    //修改用户信息
    public static void setUserInfo(int cachemode,final String uid, boolean isTeacher,final String name, final String icon,final NetCallback<NetBean_SetUserInfo> callback) {
        String key = "setUserInfo";
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        final String userType = isTeacher ? "TEACHER" : "PARENT";
        new BaseNetCacheMode<NetBean_SetUserInfo>().runhttp(context, dir, key, NetBean_SetUserInfo.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_SetUserInfo>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_SetUserInfo> mapfunc, Subscriber<NetBean_SetUserInfo> callback) {
                        HttpTask.setUserInfo(uid,userType,name,icon,mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_SetUserInfo netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_SetUserInfo netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_SetUserInfo netBean_account) {
                        return false;
                    }
                }, null);
    }

    //发布作业接口
    public static void createTask(int cachemode,final String uid, final String bookCode, final String classCode,
                                  final String taskDetail, final NetCallback<NetBean_CreateTask> callback) {
        String key = "createTask";
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_CreateTask>().runhttp(context, dir, key, NetBean_CreateTask.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_CreateTask>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_CreateTask> mapfunc, Subscriber<NetBean_CreateTask> callback) {
                        HttpTask.createTask(uid,bookCode, classCode, "photo", "2", taskDetail, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_CreateTask netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_CreateTask netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_CreateTask netBean_account) {
                        return false;
                    }
                }, null);
    }

    //选择课程列表
    public static void selectLessonList(int cachemode, final String uid, final String classGrade,final String classCode, final NetCallback<NetBean_SelectLessonList> callback) {
        String key = "selectLessonList"+uid+classGrade;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_SelectLessonList>().runhttp(context, dir, key, NetBean_SelectLessonList.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_SelectLessonList>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_SelectLessonList> mapfunc, Subscriber<NetBean_SelectLessonList> callback) {
                        HttpTask.selectLessonList(uid, classGrade, classCode, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_SelectLessonList netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_SelectLessonList netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_SelectLessonList netBean_account) {
                        return false;
                    }
                }, null);
    }

    //老师查看作业完成情况
    public static void getTaskAnswerList(int cachemode, final String classCode, final NetCallback<NetBean_Task> callback) {
        String key = "getTaskAnswerList"+classCode;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_Task>().runhttp(context, dir, key, NetBean_Task.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_Task>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_Task> mapfunc, Subscriber<NetBean_Task> callback) {
                        HttpTask.getTaskAnswerList(classCode, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_Task netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_Task netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_Task netBean_account) {
                        return false;
                    }
                },null);
    }

    //上传文件
    public static void upFile(final String path,final NetCallback<NetBean_UpFile> callback) {
        String key = "upFile";
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_UpFile>().runhttp(context, dir, key, NetBean_UpFile.class,
                BaseNetCacheMode.getMode(BaseNetCacheMode.Mode_OnlyHttp), new SimpleNetCacheCallback<NetBean_UpFile>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_UpFile> mapfunc, Subscriber<NetBean_UpFile> callback) {
                        HttpTask.UpFile(path, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_UpFile netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_UpFile netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_UpFile netBean_account) {
                        return false;
                    }
                }, null);
    }

    //老师查看作业完成情况
    public static void getTaskAnswerInfo(int cachemode, final String answerCode, final NetCallback<NetBean_TaskAnswerInfo> callback) {
        String key = "getTaskAnswerInfo"+answerCode;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_TaskAnswerInfo>().runhttp(context, dir, key, NetBean_TaskAnswerInfo.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_TaskAnswerInfo>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_TaskAnswerInfo> mapfunc, Subscriber<NetBean_TaskAnswerInfo> callback) {
                        HttpTask.getTaskAnswerInfo(answerCode, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_TaskAnswerInfo netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_TaskAnswerInfo netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_TaskAnswerInfo netBean_account) {
                        return false;
                    }
                },null);
    }

    //添加评论
    public static void addTaskComment(int cachemode, final String answerCode, final String uid
            ,final String commentContent,final NetCallback<NetBean_AddTaskComment> callback) {
        String key = "addTaskComment" + answerCode;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_AddTaskComment>().runhttp(context, dir, key, NetBean_AddTaskComment.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_AddTaskComment>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_AddTaskComment> mapfunc, Subscriber<NetBean_AddTaskComment> callback) {
                        HttpTask.addTaskComment(answerCode, uid, commentContent, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_AddTaskComment netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_AddTaskComment netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_AddTaskComment netBean_account) {
                        return false;
                    }
                }, null);
    }

    //添加花
    public static void addTaskFlower(int cachemode, final String answerCode, final String uid
            ,final NetCallback<NetBean_AddTaskComment> callback) {
        String key = "addTaskFlower" + answerCode;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_AddTaskComment>().runhttp(context, dir, key, NetBean_AddTaskComment.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_AddTaskComment>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_AddTaskComment> mapfunc, Subscriber<NetBean_AddTaskComment> callback) {
                        HttpTask.addTaskFlower(answerCode, uid,  mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_AddTaskComment netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_AddTaskComment netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_AddTaskComment netBean_account) {
                        return false;
                    }
                }, null);
    }

    //获取班级信息 管理班级
    public static void getClassManage(int cachemode, final String classCode, final NetCallback<NetBean_ClassManager> callback) {
        String key = "getClassManage"+classCode;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_ClassManager>().runhttp(context, dir, key, NetBean_ClassManager.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_ClassManager>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_ClassManager> mapfunc, Subscriber<NetBean_ClassManager> callback) {
                        HttpTask.getClassManage(classCode, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_ClassManager netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_ClassManager netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_ClassManager netBean_account) {
                        return netBean_account != null && "1".equals(netBean_account.getStatus());
                    }
                }, null);
    }

    //修改班级名称
    public static void updateClassName(int cachemode, final String classCode,final String className, final NetCallback<NetBean_UpdataClassName> callback) {
        String key = "updateClassName";
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_UpdataClassName>().runhttp(context, dir, key, NetBean_UpdataClassName.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_UpdataClassName>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_UpdataClassName> mapfunc, Subscriber<NetBean_UpdataClassName> callback) {
                        HttpTask.updateClassName(classCode,className, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_UpdataClassName netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_UpdataClassName netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_UpdataClassName netBean_account) {
                        return false;
                    }
                },null);
    }

    //删除家长
    public static void delectParentFromClass(int cachemode, final String parentuid,final String classCode, final NetCallback<NetBean_RemoveParent> callback) {
        String key = "delectParentFromClass";
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_RemoveParent>().runhttp(context, dir, key, NetBean_RemoveParent.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_RemoveParent>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_RemoveParent> mapfunc, Subscriber<NetBean_RemoveParent> callback) {
                        HttpTask.delectParentFromClass(parentuid,classCode, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_RemoveParent netBean_account) {
                        if (netBean_account == null)
                            return;
                        if ("1".equals(netBean_account.getStatus())) {
                            if (callback != null)
                                callback.success(netBean_account);
                        } else {
                            if (callback != null)
                                callback.fail(netBean_account);
                        }
                    }

                    @Override
                    public void onCache(NetBean_RemoveParent netBean_account) {
                        //拦截会返回null
                        if (netBean_account == null)
                            return;
                        if (callback != null)
                            callback.onCache(netBean_account);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_RemoveParent netBean_account) {
                        return false;
                    }
                },null);
    }

    //获取图书馆首页外框架数据
    public static void queryLibIndex(int cachemode, final String uid,final boolean isTeacher, final NetCallback<NetBean_QueryLibIndex> callback) {
        String key = "queryLibIndex"+uid;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_QueryLibIndex>().runhttp(context, dir, key, NetBean_QueryLibIndex.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_QueryLibIndex>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_QueryLibIndex> mapfunc, Subscriber<NetBean_QueryLibIndex> callback) {
                        String useType = "PARENT";
                        if (isTeacher)
                            useType = "TEACHER";
                        HttpTask.queryLibIndex(uid, useType, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_QueryLibIndex netdata) {
                        if (netdata == null)
                            return;
                        if ("1".equals(netdata.getStatus())) {
                            if (callback != null)
                                callback.success(netdata);
                        } else {
                            if (callback != null)
                                callback.fail(netdata);
                        }
                    }

                    @Override
                    public void onCache(NetBean_QueryLibIndex netdata) {
                        //拦截会返回null
                        if (netdata == null)
                            return;
                        if (callback != null)
                            callback.onCache(netdata);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_QueryLibIndex netdata) {
                        return netdata != null && "1".equals(netdata.getStatus());
                    }
                }, null);
    }

    //获取书房列表
    public static void getBookRoom(int cachemode, final String uid, final boolean isTeacher, final NetCallback<NetBean_BookRoom> callback) {
        String key = "getBookRoom"+uid;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_BookRoom>().runhttp(context, dir, key, NetBean_BookRoom.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_BookRoom>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_BookRoom> mapfunc, Subscriber<NetBean_BookRoom> callback) {
                        String type = "TEACHER";
                        if (isTeacher)
                            type = "TEACHER";
                        else
                            type = "PARENT";
                        HttpTask.getBookRoom(uid,type, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_BookRoom netdata) {
                        if (netdata == null)
                            return;
                        if ("1".equals(netdata.getStatus())) {
                            if (callback != null)
                                callback.success(netdata);
                        } else {
                            if (callback != null)
                                callback.fail(netdata);
                        }
                    }

                    @Override
                    public void onCache(NetBean_BookRoom netdata) {
                        //拦截会返回null
                        if (netdata == null)
                            return;
                        if (callback != null)
                            callback.onCache(netdata);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_BookRoom netdata) {
                        return netdata != null && "1".equals(netdata.getStatus());
                    }
                }, null);
    }

    //老师端的图书馆的绘本详情
    public static void getBookDetail4Library(int cachemode, final String uid, final String bookCode
            , final NetCallback<NetBean_BookDetail4Library> callback) {
        String key = "getBookDetail4Library"+uid+bookCode;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_BookDetail4Library>().runhttp(context, dir, key, NetBean_BookDetail4Library.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_BookDetail4Library>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_BookDetail4Library> mapfunc, Subscriber<NetBean_BookDetail4Library> callback) {
                        HttpTask.getBookDetail4Library(uid, bookCode, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_BookDetail4Library netdata) {
                        if (netdata == null)
                            return;
                        if ("1".equals(netdata.getStatus())) {
                            if (callback != null)
                                callback.success(netdata);
                        } else {
                            if (callback != null)
                                callback.fail(netdata);
                        }
                    }

                    @Override
                    public void onCache(NetBean_BookDetail4Library netdata) {
                        //拦截会返回null
                        if (netdata == null)
                            return;
                        if (callback != null)
                            callback.onCache(netdata);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_BookDetail4Library netdata) {
                        return netdata != null && "1".equals(netdata.getStatus());
                    }
                },null);
    }

    //插入书房
    public static void addBookToStudy(int cachemode, final String uid,final String userType, final String bookCode,final String bookType
            , final NetCallback<NetBean_AddBookToStudy> callback) {
        String key = "addBookToStudy"+uid+bookCode;
        String dir = FileControl.getNetDir();
        Context context = AppControl.getInstance().getContext();
        new BaseNetCacheMode<NetBean_AddBookToStudy>().runhttp(context, dir, key, NetBean_AddBookToStudy.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_AddBookToStudy>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_AddBookToStudy> mapfunc, Subscriber<NetBean_AddBookToStudy> callback) {
                        HttpTask.addBookToStudy(uid, userType, bookCode, bookType, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_AddBookToStudy netdata) {
                        if (netdata == null)
                            return;
                        if ("1".equals(netdata.getStatus())) {
                            if (callback != null)
                                callback.success(netdata);
                        } else {
                            if (callback != null)
                                callback.fail(netdata);
                        }
                    }

                    @Override
                    public void onCache(NetBean_AddBookToStudy netdata) {
                        //拦截会返回null
                        if (netdata == null)
                            return;
                        if (callback != null)
                            callback.onCache(netdata);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_AddBookToStudy netdata) {
                        return false;
                    }
                }, null);
    }

    // 年级分类图书列表
    public static void queryBookListByDomain(final int cachemode,final boolean isTeacher, final String uid,
                                             final String domainCode,final String level,final int pageIndex,
                                             final int pageSize,
                                             final NetCallback<NetBean_queryBookListByDomain> callback){
        Context context = AppControl.getInstance().getContext();
        String key = "queryBookListByDomain" + uid;
        String dir = FileControl.getNetDir();
        final String userType = isTeacher ? "TEACHER" : "PARENT";
        new BaseNetCacheMode<NetBean_queryBookListByDomain>().runhttp(context, dir, key, NetBean_queryBookListByDomain.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_queryBookListByDomain>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_queryBookListByDomain> mapfunc, Subscriber<NetBean_queryBookListByDomain> callback) {
                        HttpTask.queryBookListByDomain(uid, userType, domainCode, level, pageIndex, pageSize, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_queryBookListByDomain netdata) {
                        if (netdata == null)
                            return;
                        if ("1".equals(netdata.getStatus())) {
                            if (callback != null)
                                callback.success(netdata);
                        } else {
                            if (callback != null)
                                callback.fail(netdata);
                        }
                    }

                    @Override
                    public void onCache(NetBean_queryBookListByDomain netdata) {
                        //拦截会返回null
                        if (netdata == null)
                            return;
                        if (callback != null)
                            callback.onCache(netdata);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_queryBookListByDomain netdata) {
                        return netdata != null && "1".equals(netdata.getStatus());
                    }
                },null);
    }

    // 年级分类图书列表
    public static void queryBookListByGrade(final int cachemode, final boolean isTeacher, final String uid,
                                            final String gradeCode, final int pageIndex, final int pageSize,
                                            final NetCallback<NetBean_queryBookListByGrade> callback) {
        Context context = AppControl.getInstance().getContext();
        String key = "queryBookListByGrade" + uid;
        String dir = FileControl.getNetDir();
        final String userType = isTeacher ? "TEACHER" : "PARENT";
        new BaseNetCacheMode<NetBean_queryBookListByGrade>().runhttp(context, dir, key, NetBean_queryBookListByGrade.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_queryBookListByGrade>() {

                    @Override
                    public void httpTask(Func1<String, NetBean_queryBookListByGrade> mapfunc, Subscriber<NetBean_queryBookListByGrade> callback) {
                        HttpTask.queryBookListByGrade(uid, userType, gradeCode, pageIndex, pageSize, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_queryBookListByGrade netdata) {
                        if (netdata == null)
                            return;
                        if ("1".equals(netdata.getStatus())) {
                            if (callback != null)
                                callback.success(netdata);
                        } else {
                            if (callback != null)
                                callback.fail(netdata);
                        }
                    }

                    @Override
                    public void onCache(NetBean_queryBookListByGrade netdata) {
                        //拦截会返回null
                        if (netdata == null)
                            return;
                        if (callback != null)
                            callback.onCache(netdata);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_queryBookListByGrade netdata) {
                        return netdata != null && "1".equals(netdata.getStatus());
                    }
                }, null);
    }

    // 专题列表
    public static void queryLibTopicList(final int cachemode, final String uid, final int pageIndex,
                                         final int pageSize, final NetCallback<NetBean_queryLibTopicList> callback) {
        Context context = AppControl.getInstance().getContext();
        String key = "queryLibTopicList" + uid;
        String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_queryLibTopicList>().runhttp(context, dir, key, NetBean_queryLibTopicList.class,
                BaseNetCacheMode.getMode(cachemode), new SimpleNetCacheCallback<NetBean_queryLibTopicList>() {

                    @Override
                    public void httpTask(Func1<String, NetBean_queryLibTopicList> mapfunc, Subscriber<NetBean_queryLibTopicList> callback) {
                        HttpTask.queryLibTopicList(uid, pageIndex, pageSize, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_queryLibTopicList netdata) {
                        if (netdata == null)
                            return;
                        if ("1".equals(netdata.getStatus())) {
                            if (callback != null)
                                callback.success(netdata);
                        } else {
                            if (callback != null)
                                callback.fail(netdata);
                        }
                    }

                    @Override
                    public void onCache(NetBean_queryLibTopicList netdata) {
                        //拦截会返回null
                        if (netdata == null)
                            return;
                        if (callback != null)
                            callback.onCache(netdata);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_queryLibTopicList netdata) {
                        return netdata != null && "1".equals(netdata.getStatus());
                    }
                }, null);
    }

    // VIP兑换码激活接口
    public static void activeVipCard(final String uid,final String cardCode,final NetCallback<NetBean_activeVipCard> callback){
        Context context = AppControl.getInstance().getContext();
        String key = "queryLibTopicList" + uid;
        String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_activeVipCard>().runhttp(context, dir, key, NetBean_activeVipCard.class,
                BaseNetCacheMode.getMode(BaseNetCacheMode.Mode_OnlyHttp), new SimpleNetCacheCallback<NetBean_activeVipCard>() {

                    @Override
                    public void httpTask(Func1<String, NetBean_activeVipCard> mapfunc, Subscriber<NetBean_activeVipCard> callback) {
                        HttpTask.activeVipCard(uid, cardCode, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_activeVipCard netdata) {
                        if (netdata == null)
                            return;
                        if ("1".equals(netdata.getStatus())) {
                            if (callback != null)
                                callback.success(netdata);
                        } else {
                            if (callback != null)
                                callback.fail(netdata);
                        }
                    }

                    @Override
                    public void onCache(NetBean_activeVipCard netdata) {
                        //拦截会返回null
                        if (netdata == null)
                            return;
                        if (callback != null)
                            callback.onCache(netdata);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_activeVipCard netdata) {
                        return netdata != null && "1".equals(netdata.getStatus());
                    }
                }, null);
    }

    // VIP兑换码激活历史接口
    public static void activeVipHistory(final String uid,final NetCallback<NetBean_activeVipHistory> callback){
        Context context = AppControl.getInstance().getContext();
        String key = "activeVipHistory" + uid;
        String dir = FileControl.getNetDir();
        new BaseNetCacheMode<NetBean_activeVipHistory>().runhttp(context, dir, key, NetBean_activeVipHistory.class,
                BaseNetCacheMode.getMode(BaseNetCacheMode.Mode_OnlyHttp), new SimpleNetCacheCallback<NetBean_activeVipHistory>() {
                    @Override
                    public void httpTask(Func1<String, NetBean_activeVipHistory> mapfunc, Subscriber<NetBean_activeVipHistory> callback) {
                        HttpTask.activeVipHistory(uid, mapfunc, callback);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null)
                            callback.error(e.toString());
                    }

                    @Override
                    public void onNext(NetBean_activeVipHistory netdata) {
                        if (netdata == null)
                            return;
                        if ("1".equals(netdata.getStatus())) {
                            if (callback != null)
                                callback.success(netdata);
                        } else {
                            if (callback != null)
                                callback.fail(netdata);
                        }
                    }

                    @Override
                    public void onCache(NetBean_activeVipHistory netdata) {
                        //拦截会返回null
                        if (netdata == null)
                            return;
                        if (callback != null)
                            callback.onCache(netdata);
                    }

                    @Override
                    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(NetBean_activeVipHistory netdata) {
                        return netdata != null && "1".equals(netdata.getStatus());
                    }
                }, null);
    }
}