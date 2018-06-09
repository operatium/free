package v.activity.jiankangzhilu;

/**
 * Created by Administrator on 2018/6/9.
 */
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.widget.Toast;

import java.util.List;

import other.base.LogDebug;

public class ClearHelp {


    public void clear(Context context) {

        //To change body of implemented methods use File | Settings | File Templates.
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> infoList = am.getRunningAppProcesses();
        List<ActivityManager.RunningServiceInfo> serviceInfos = am.getRunningServices(100);

        long beforeMem = getAvailMemory(context);
        LogDebug.d("show", "-----------before memory info : " + beforeMem);
        int count = 0;
        if (infoList != null)

        {
            for (int i = 0; i < infoList.size(); ++i) {
                RunningAppProcessInfo appProcessInfo = infoList.get(i);
                LogDebug.d("show", "process name : " + appProcessInfo.processName);
                //importance 该进程的重要程度  分为几个级别，数值越低就越重要。
                LogDebug.d("show", "importance : " + appProcessInfo.importance);

                // 一般数值大于RunningAppProcessInfo.IMPORTANCE_SERVICE的进程都长时间没用或者空进程了
                // 一般数值大于RunningAppProcessInfo.IMPORTANCE_VISIBLE的进程都是非可见进程，也就是在后台运行着
                if (appProcessInfo.importance > RunningAppProcessInfo.IMPORTANCE_VISIBLE) {
                    String[] pkgList = appProcessInfo.pkgList;
                    for (int j = 0; j < pkgList.length; ++j) {//pkgList 得到该进程下运行的包名
                        LogDebug.d("show", "It will be killed, package name : " + pkgList[j]);
                        try{
                            am.killBackgroundProcesses(pkgList[j]);
                        }catch (Exception e){
                            LogDebug.e("201806090030",e.toString(),e);
                        }
                        count++;
                    }
                }

            }
        }

        long afterMem = getAvailMemory(context);
        LogDebug.d("show", "----------- after memory info : " + afterMem);
        Toast.makeText(context, "clear " + count + " process, "
                + (afterMem - beforeMem) + "M", Toast.LENGTH_LONG).show();
    }
    //获取可用内存大小
    private long getAvailMemory(Context context) {
        // 获取android当前可用内存大小
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        MemoryInfo mi = new MemoryInfo();
        am.getMemoryInfo(mi);
        //mi.availMem; 当前系统的可用内存
        //return Formatter.formatFileSize(context, mi.availMem);// 将获取的内存大小规格化
        LogDebug.d("show", "可用内存---->>>" + mi.availMem / (1024 * 1024));
        return mi.availMem / (1024 * 1024);
    }
}