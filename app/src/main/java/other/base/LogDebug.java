package other.base;


import android.text.TextUtils;
import android.util.Log;

import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * 打印logcat 由bugly.debug = true 控制
 * Created by Administrator on 2018/2/3.
 */

public class LogDebug {
    public static void e(String tag, String msg, Exception e) {
        if (TextUtils.isEmpty(msg)){
            msg = "未知";
        }
        BuglyLog.e(tag, msg);
        CrashReport.postCatchedException(e);
        CrashReport.putUserData(AppInfo.INSTANCE.getContext(),"pid",""+android.os.Process.myPid());
        Log.e("show",e.toString() + "yyx = "+android.os.Process.myPid());
    }

    public static void w(String tag, String msg) {
        BuglyLog.w(tag, msg);
    }

    public static void d(String tag, String msg) {
        BuglyLog.i(tag, msg);
    }

}