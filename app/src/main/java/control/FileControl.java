package control;

import android.content.Context;

import java.io.File;

/**
 * context.getFilesDir()的目录下
 * 相对路径
 * Created by java on 2017/10/24.
 */

public class FileControl {
    public static long nowTime;
    public static String uid;//与LoginData绑定
    /**
     * 存储登录过的每个ID的用户信息， 登录的ID，设备的游客ID
     */
    public static final String BOOKUNZIP = "bookunzip";
    public static final String BOOKZIP = "bookzip";

    //保存用户信息的文件夹
    public static String getDir_Login(){
        return "login";
    }

    //是否第一次打开APP的key 这个文件存放在getDir_Login()目录下
    public static String getKey_FirstOpenApp(){
        return "firstopenapp";
    }


    //每个用户的文件夹
    public static String getUserFileDir(){
        return uid;
    }

    //解压到指定文件夹(用户购买或者拥有阅读权限的书籍资源存放的位置)
    public static String getBookUnzipBookDir(String booid){
        return getUserFileDir()+ File.separator+BOOKUNZIP+File.separator + booid;
    }

    //获取阅读书籍资源的文件夹(用户购买或者拥有阅读权限的书籍资源存放的位置)
    public static String getBookResourceDir(String booid){
        return getBookUnzipBookDir(booid) +File.separator+"Iphone1334";
    }

    //获取书籍资源的文件夹内json.txt文件(用户购买或者拥有阅读权限的书籍资源存放的位置)
    public static String getBookResource_jsontxt(String booid) {
        return getBookResourceDir(booid) + File.separator + "json.txt";
    }

    //获取私有的书籍zip文件夹
    public static String getBookZipDir() {
        return getUserFileDir() + File.separator + BOOKZIP;
    }

    //获取私有的书籍zip文件路径
    public static String getBookZip(String bookid) {
        return getBookZipDir() + File.separator + bookid + ".zip";
    }

    //用户试读的书籍资源存放的目录(公共区域非自己所属的书籍)
    public static String getTryBookUnzipBookDir(String booid){
        return BOOKUNZIP+File.separator + booid;
    }
    //获取阅读书籍资源的文件夹(公共区域非自己所属的书籍)
    public static String getTryBookResourceDir(String booid){
        return getTryBookUnzipBookDir(booid) +File.separator+"Iphone1334";
    }

    //获取书籍资源的文件夹内json.txt文件(公共区域非自己所属的书籍)
    public static String getTryBookResource_jsontxt(String booid){
        return getTryBookResourceDir(booid)+File.separator+"json.txt";
    }

    //获取公共的书籍zip文件的文件夹路径
    public static String getTryBookZipDir(){
        return BOOKZIP;
    }

    //获取公共的书籍zip路径
    public static String getTryBookZip(String bookid){
        return BOOKZIP+File.separator+bookid+".zip";
    }

    //都是相对路径 这个是返回全路径的方法
    public static String getFullPath(Context context, String xiangduilujin){
        return getFullPath(context, xiangduilujin,false,false);
    }

    public static String getFullPath(Context context, String xiangduilujin, boolean needcreate,boolean isdir){
        String path = context.getFilesDir()+File.separator+xiangduilujin;
        if (needcreate) {
            File file = new File(path);
            if (!file.exists()) {
                if (isdir)
                    file.mkdirs();
                else
                    file.mkdir();
            }
        }
        return path;
    }


    //网络请求的缓存文件夹
    public static String getNetDir(){
        return getUserFileDir()+File.separator+"net";
    }

    //评论的音频文件下载的地方
    public static String getPinglunSoundFilePath(int id){
        return "voiceComment"+File.separator+id+".mp3";
    }

    //获取缓存视力保护的文件名
    public static String getKey_PreservationOfEyesightControl(){
        return "preservationofeyesightcontrol";
    }

    //获取缓存视力保护的文件路径的目录
    public static String getDir_PreservationOfEyesightControl(){
        return getUserFileDir();
    }

    //获取缓存视力保护的文件路径
    public static String getPreservationOfEyesightControl(){
        return getDir_PreservationOfEyesightControl()+File.separator+getKey_PreservationOfEyesightControl();
    }

    //下载设置 仅wifi 缓存在files下的login文件夹下的 downloadset(Key)文件
    public static String getKey_downloadSet(){
        return "downloadset";
    }

    //获取下载设置的文件路径的目录
    public static String getDir_downloadSet(){
        return getDir_Login();
    }

    //获取下载设置的文件路径
    public static String getdownloadSet(){
        return getDir_downloadSet()+ File.separator+getKey_downloadSet();
    }

    //app好评的缓存文件路径的KEY
    public static String getKey_appHaoPingPath(){
        return "apphaoping";
    }

    //app好评的缓存文件路径的目录
    public static String getDir_AppHaoPingPath(){
        return getUserFileDir();
    }

    //app好评的缓存文件路径
    public static String getAppHaoPingPath(){
        return getDir_AppHaoPingPath()+ File.separator+getKey_appHaoPingPath();
    }

    //临时文件夹
    public static String getTempDir(){
        return "temp";
    }

    //用户的临时文件夹
    public static String getUserTempDir(){
        return getUserFileDir()+"/temp";
    }

    //随机出多个文件名
    public synchronized static String getOnlyFileName(String houzhui){
        if (nowTime == 0)
            nowTime = System.currentTimeMillis();
        return String.valueOf(++nowTime)+houzhui;
    }

    //获取缓存文件的大小
    public static String getCacheSize(){
        // TODO: 2017/12/16
        return "0M";
    }

    //清除缓存
    public static void clearCache(){
        // TODO: 2017/12/16
    }

    public static void deleteFiles(File dir) {
        if (dir == null || !dir.exists())
            return;
        if(!dir.isDirectory()){
            dir.delete();
            return;
        }
        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete(); // 删除所有文件
            else if (file.isDirectory())
                deleteFiles(file); // 递规的方式删除文件夹
        }
        dir.delete();// 删除目录本身
    }
}
