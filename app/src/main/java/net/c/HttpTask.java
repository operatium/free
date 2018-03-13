package net.c;

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

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import debug.LogDebug;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import util.TimeUtil;

/**
 * 网络请求类
 * http://118.31.171.207/showdoc/index.php?s=/14&page_id=346
 * Created by java on 2017/9/11.
 */

public class HttpTask {
        public static String NetIp = "http://118.31.171.207:9000/";
//    public static String NetIp = "http://192.168.10.100:9000/"; // 个人服务器
    public static String DebugIp = "http://home.ellabook.cn:88/";//用于debug时候 恢复原始IP
    public static String nowapiIp = "http://api.k780.com/";
    private static String resource = "android";

    // 获取retrofit实例 过滤code
    private static Retrofit getRetrofit(String IP) {
        return new Retrofit.Builder()
                .baseUrl(IP)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static Map<String, String> getPublicParamter(String method, String content) {
        String time = TimeUtil.getDateToString4now("yyyy-MM-dd HH:mm:ss");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("method", method);
        map.put("format", "json");
        map.put("app_key", "2017506650");
        map.put("v", "1.0");
        map.put("sign_method", "md5");
        map.put("timestamp", time);
        map.put("content", content);
        map.put("sign", "57482800eaf55a577000dd65");
        return map;
    }

    //登录
    public static void login(String accout, String password
            , Func1<String, NetBean_Login> mapfunc
            , Subscriber<NetBean_Login> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService requset = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.login";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("customerName", accout);
            jsonObjectParamter.put("password", password);
            jsonObjectParamter.put("resource", resource);
            jsonObjectParamter.put("loginType", "APP");
        } catch (Exception e) {
            LogDebug.e("201801061539", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        requset.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //获取验证码
    public static void getCode(String mobile,String type
            , Func1<String, NetBean_GetCode> mapfunc
            , Subscriber<NetBean_GetCode> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService requset = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.sendMessage";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("mobile", mobile);
            jsonObjectParamter.put("type", type);
        } catch (Exception e) {
            LogDebug.e("201801061821", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        requset.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //修改密码
    public static void changePassword(String customerName, String password, String checkCode
            , Func1<String, NetBean_ChangePassword> mapfunc
            , Subscriber<NetBean_ChangePassword> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService requset = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.resetPassword";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("customerName", customerName);
            jsonObjectParamter.put("password", password);
            jsonObjectParamter.put("resource", resource);
            jsonObjectParamter.put("checkCode", checkCode);
        } catch (Exception e) {
            LogDebug.e("201801061936", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        requset.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //banner图
    public static void getBanner(String userType, Func1<String, NetBean_Banner> mapfunc
            , Subscriber<NetBean_Banner> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService requset = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.getHomeBanner";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("userType", userType);
        } catch (Exception e) {
            LogDebug.e("201801062020", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        requset.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //获取老师端和家长端班级列表和首页课程
    public static void getClassByUid(String uid, String userType, Func1<String, NetBean_GetClassByUid> mapfunc
            , Subscriber<NetBean_GetClassByUid> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService requset = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.getClassByUid";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("userType", userType);
        } catch (Exception e) {
            LogDebug.e("201801081011", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        requset.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //获取课程详情
    public static void getCourseDetail(String uid, String taskCode, String bookCode, String classCode
            ,String weekNum, String semester, Func1<String, NetBean_LessonInfo> mapfunc
            , Subscriber<NetBean_LessonInfo> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService requset = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.getCourseDetail";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("bookCode", bookCode);
            jsonObjectParamter.put("classCode", classCode);
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("taskCode", taskCode);
            jsonObjectParamter.put("weekNum", weekNum);
            jsonObjectParamter.put("semester", semester);
        } catch (Exception e) {
            LogDebug.e("201801081116", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        requset.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //新版 获取课程详情
    public static void getLessonInfo(String bookCode,String classCode, String uid
            ,String taskCode,String weekNum,String semester, Func1<String, NetBean_newLessonInfo> mapfunc
            , Subscriber<NetBean_newLessonInfo> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService requset = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.getCourseDetail";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("bookCode", bookCode);
            jsonObjectParamter.put("classCode", classCode);
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("taskCode", taskCode);
            jsonObjectParamter.put("weekNum", weekNum);
            jsonObjectParamter.put("semester", semester);
        } catch (Exception e) {
            LogDebug.e("201801181718", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        requset.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //北京时间
    public static void getBeijingTime(Func1<String, NetBean_BeijingTime> mapfunc
            , Subscriber<NetBean_BeijingTime> callback) {
        Retrofit retrofit = getRetrofit(nowapiIp);
        NetInterfaceService requset = retrofit.create(NetInterfaceService.class);
        requset.getBeijingTime("life.time", "30797", "d7375364fedbb85396020dcd5a448d19", "json")
                .subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //获取课程表信息
    public static void getLessonList(String uid, String userType, String classGrade, String courseType,
                                     Func1<String, NetBean_LessonList> mapfunc,
                                     Subscriber<NetBean_LessonList> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.getTimeTables";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("userType", userType);
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("classGrade", classGrade);
            jsonObjectParamter.put("courseType", courseType);
        } catch (Exception e) {
            LogDebug.e("201801112047", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //版本信息
    public static void getVersion(Func1<String, NetBean_Version> mapfunc,
                                  Subscriber<NetBean_Version> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.getVersion";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("versionResource", resource);
        } catch (Exception e) {
            LogDebug.e("201801171515", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //修改用户信息
    public static void setUserInfo(String uid, String userType, String name, String icon
            , Func1<String, NetBean_SetUserInfo> mapfunc,
                                   Subscriber<NetBean_SetUserInfo> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.updateMyselfInfo";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("userType", userType);
            jsonObjectParamter.put("name", name);
            jsonObjectParamter.put("icon", icon);
        } catch (Exception e) {
            LogDebug.e("201801171755", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //发布作业接口
    public static void createTask(String uid, String bookCode, String classCode, String taskType, String taskWorth
            ,String taskDetail, Func1<String, NetBean_CreateTask> mapfunc,
                                  Subscriber<NetBean_CreateTask> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.createHomeTask";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("bookCode", bookCode);
            jsonObjectParamter.put("classCode", classCode);
            jsonObjectParamter.put("taskType", taskType);
            jsonObjectParamter.put("taskWorth", taskWorth);
            jsonObjectParamter.put("taskDetail", taskDetail);
        } catch (Exception e) {
            LogDebug.e("201801181955", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //选择课程列表
    public static void selectLessonList(String uid, String classGrade,String classCode, Func1<String, NetBean_SelectLessonList> mapfunc
            , Subscriber<NetBean_SelectLessonList> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.choiceCourseByTeacher";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("classGrade", classGrade);
            jsonObjectParamter.put("classCode", classCode);
        } catch (Exception e) {
            LogDebug.e("201801190917", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //老师查看作业完成情况
    public static void getTaskAnswerList(String classCode, Func1<String, NetBean_Task> mapfunc
            , Subscriber<NetBean_Task> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.getTaskAnswerList";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("classCode", classCode);
        } catch (Exception e) {
            LogDebug.e("201801191553", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    /**
     * 上传文件
     */
    public static void UpFile(final String path, Func1<String, NetBean_UpFile> mapfunc,
                              Subscriber<NetBean_UpFile> callback) {
        try {
            Retrofit retrofit = getRetrofit(NetIp);
            NetInterfaceService request = retrofit.create(NetInterfaceService.class);
            // 创建 RequestBody，用于封装构建RequestBody
            File myfile = new File(path);
            RequestBody requestFile = RequestBody.create(MediaType.parse("application/octet-stream"), myfile);
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", myfile.getName(), requestFile);
            request.UpFile(body).subscribeOn(Schedulers.newThread())
                    .map(mapfunc)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(callback);
        } catch (Exception e) {
            LogDebug.e("201801201236", e.toString());
        }
    }



    //作业详情
    public static void getTaskAnswerInfo(String answerCode, Func1<String, NetBean_TaskAnswerInfo> mapfunc
            , Subscriber<NetBean_TaskAnswerInfo> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.queryTaskAnswerInfo";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("answerCode", answerCode);
        } catch (Exception e) {
            LogDebug.e("201801201240", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //添加评论
    public static void addTaskComment(String answerCode,String uid,String commentContent, Func1<String, NetBean_AddTaskComment> mapfunc
            , Subscriber<NetBean_AddTaskComment> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.addTaskComment";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("answerCode", answerCode);
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("commentContent", commentContent);
        } catch (Exception e) {
            LogDebug.e("201801211521", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //添加花
    public static void addTaskFlower(String answerCode,String uid,Func1<String, NetBean_AddTaskComment> mapfunc
            , Subscriber<NetBean_AddTaskComment> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.addTaskFlower";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("answerCode", answerCode);
            jsonObjectParamter.put("uid", uid);
        } catch (Exception e) {
            LogDebug.e("201801212022", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //获取班级信息 管理班级
    public static void getClassManage(String classCode, Func1<String, NetBean_ClassManager> mapfunc
            , Subscriber<NetBean_ClassManager> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.classManage";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("classCode", classCode);
        } catch (Exception e) {
            LogDebug.e("201801221106", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //修改班级名称
    public static void updateClassName(String classCode,String className, Func1<String, NetBean_UpdataClassName> mapfunc
            , Subscriber<NetBean_UpdataClassName> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.updateCalssName";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("classCode", classCode);
            jsonObjectParamter.put("className", className);
        } catch (Exception e) {
            LogDebug.e("201801221505", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //删除家长
    public static void delectParentFromClass(String uid,String classCode, Func1<String, NetBean_RemoveParent> mapfunc
            , Subscriber<NetBean_RemoveParent> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.delectParentFromClass";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("classCode", classCode);
        } catch (Exception e) {
            LogDebug.e("201801221627", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //获取图书馆首页外框架数据
    public static void queryLibIndex(String uid,String userType, Func1<String, NetBean_QueryLibIndex> mapfunc
            , Subscriber<NetBean_QueryLibIndex> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.queryLibIndex";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("userType", userType);
            jsonObjectParamter.put("resource",resource);
        } catch (Exception e) {
            LogDebug.e("201803011748", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    // 获取年级分类图书列表
    public static void queryBookListByDomain(String uid, String userType, String domainCode, String level
            , int pageIndex, int pageSize, Func1<String, NetBean_queryBookListByDomain> mapfunc
            , Subscriber<NetBean_queryBookListByDomain> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.queryBookListByDomain";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("userType", userType);
            jsonObjectParamter.put("resource", resource);
            jsonObjectParamter.put("domainCode", domainCode);
            jsonObjectParamter.put("level", level);
            jsonObjectParamter.put("pageIndex", pageIndex);
            jsonObjectParamter.put("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            LogDebug.e("201803061017", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    // 年级分类图书列表
    public static void queryBookListByGrade(String uid, String userType, final String gradeCode, int pageIndex, int pageSize,
                                            Func1<String, NetBean_queryBookListByGrade> mapfunc, Subscriber<NetBean_queryBookListByGrade> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.queryBookListByGrade";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("userType", userType);
            jsonObjectParamter.put("resource", resource);
            jsonObjectParamter.put("gradeCode", gradeCode);
            jsonObjectParamter.put("pageIndex", pageIndex);
            jsonObjectParamter.put("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            LogDebug.e("201803061917", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    // 专题列表
    public static void queryLibTopicList(String uid, int pageIndex, int pageSize,
                                         Func1<String, NetBean_queryLibTopicList> mapfunc, Subscriber<NetBean_queryLibTopicList> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.queryLibTopicList";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("resource", resource);
            jsonObjectParamter.put("pageIndex", pageIndex);
            jsonObjectParamter.put("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            LogDebug.e("201803071056", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //获取用户书房
    public static void getBookRoom(String uid,String userType, Func1<String, NetBean_BookRoom> mapfunc
            , Subscriber<NetBean_BookRoom> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.getStudyList";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("userType",userType);
        } catch (Exception e) {
            LogDebug.e("201803051004", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //老师端的图书馆的绘本详情
    public static void getBookDetail4Library(String uid,String bookCode, Func1<String, NetBean_BookDetail4Library> mapfunc
            , Subscriber<NetBean_BookDetail4Library> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.queryBookDetail";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("bookCode",bookCode);
        } catch (Exception e) {
            LogDebug.e("201803071659", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    //插入书房
    public static void addBookToStudy(String uid,String userType, String bookCode,String bookType
            , Func1<String, NetBean_AddBookToStudy> mapfunc
            , Subscriber<NetBean_AddBookToStudy> callback){
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.addBookToStudy";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("userType", userType);
            jsonObjectParamter.put("bookCode",bookCode);
            jsonObjectParamter.put("bookType", bookType);

        } catch (Exception e) {
            LogDebug.e("201803072012", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    // VIP兑换码激活接口
    public static void activeVipCard(final String uid, final String cardCode, Func1<String, NetBean_activeVipCard> mapfunc
            , Subscriber<NetBean_activeVipCard> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.activeVipCard";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
            jsonObjectParamter.put("cardCode", cardCode);

        } catch (Exception e) {
            LogDebug.e("201803101812", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }

    // VIP兑换码激活历史接口
    public static void activeVipHistory(final String uid, Func1<String, NetBean_activeVipHistory> mapfunc
            , Subscriber<NetBean_activeVipHistory> callback) {
        Retrofit retrofit = getRetrofit(NetIp);
        NetInterfaceService request = retrofit.create(NetInterfaceService.class);
        String method = "ella.home.activeVipHistory";
        JSONObject jsonObjectParamter = new JSONObject();
        try {
            jsonObjectParamter.put("uid", uid);
        } catch (Exception e) {
            LogDebug.e("201803121124", e.toString());
        }
        Map<String, String> map = getPublicParamter(method, jsonObjectParamter.toString());
        request.networdrequestType1(map).subscribeOn(Schedulers.newThread())
                .map(mapfunc)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
    }
}