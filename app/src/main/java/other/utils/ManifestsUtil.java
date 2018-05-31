package other.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import other.base.AppInfo;
import other.base.LogDebug;

/**
 * Created by opera on 2018/5/9.
 */

public class ManifestsUtil {
    public static String getString4ApplicationMeta(String key, String defaul) {
        try {
            Context context = AppInfo.INSTANCE.getContext();
            String baoming = context.getPackageName();
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(baoming, PackageManager.GET_META_DATA);
            String msg = appInfo.metaData.getString(key);
            LogDebug.d("show", baoming +" : "+ key +" == " + msg);
            if (TextUtils.isEmpty(msg))
                return defaul;
            return msg;
        }catch (Exception e){
            LogDebug.e("201805091905",e.toString(),e);
            return defaul;
        }
    }

    public static int getInt4ApplicationMeta(String key, int defaul) {
        try {
            Context context = AppInfo.INSTANCE.getContext();
            String baoming = context.getPackageName();
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(baoming, PackageManager.GET_META_DATA);
            int msg = appInfo.metaData.getInt(key);
            LogDebug.d("show", baoming +" : "+ key +" == " + msg);
            return msg;
        }catch (Exception e){
            LogDebug.e("201805111013",e.toString(),e);
            return defaul;
        }
    }

    public static boolean getBool4ApplicationMeta(String key, boolean defaul) {
        try {
            Context context = AppInfo.INSTANCE.getContext();
            String baoming = context.getPackageName();
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(baoming, PackageManager.GET_META_DATA);
            boolean msg = appInfo.metaData.getBoolean(key);
            LogDebug.d("show", baoming +" : "+ key +" == " + msg);
            return msg;
        }catch (Exception e){
            LogDebug.e("201805091906",e.toString(),e);
            return defaul;
        }
    }
}
