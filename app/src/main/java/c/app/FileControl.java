package c.app;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * context.getFilesDir()的目录下
 * 相对路径
 *
 * 用户登陆信息 和 设备游客账号 存储2位饿.++9-+*
 * +
 * +在getDir_Public()下
 * Created by java on 2017/10/24.
 */

public class FileControl {

    //这个可以获取完整路径
    public static String getFullPath(Context context, String xiangduilujin, boolean needcreate, boolean isdir) {
        String path = context.getFilesDir() + File.separator + xiangduilujin;
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

    //都是相对路径 这个是返回全路径的方法
    public static String getFullPath(Context context, String xiangduilujin) {
        return getFullPath(context, xiangduilujin, false, false);
    }

    //公共文件夹
    public static String getDir_Public() {
        return "public";
    }

    //公共临时文件的文件夹
    public static String getDir_Public_Temp() {
        return getDir_Public() + File.separator + "temp";
    }

    public static String get_VersionAPK(String version) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator+"Download"+ File.separator + "ellabook"+version + ".apk";
    }
}
