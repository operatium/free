package other.base;

import android.support.multidex.MultiDexApplication;


import com.tencent.bugly.crashreport.CrashReport;

import other.fitscreen.PhoneInfo;


public class MyAPP extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            //APP初始化+
            AppInfo.INSTANCE.init(this);
            CrashReport.initCrashReport(this);
            PhoneInfo.INSTANCE.init(this);
            try {
                int screenWidth = PhoneInfo.INSTANCE.getScreenWidth();
                int screenHeight = PhoneInfo.INSTANCE.getScreenHeight();
                CrashReport.putUserData(AppInfo.INSTANCE.getContext(), "windowSize"
                        , "screenWidth = " + screenWidth + " / screenHeight = " + screenHeight);
            } catch (Exception e) {
                LogDebug.e("201805161752", e.toString(), e);
            }
        } catch (Exception e) {
            LogDebug.e("201804041336", e.toString(), e);
        }
    }
}