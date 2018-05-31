package other.fitscreen

import android.content.Context
import com.tencent.bugly.crashreport.CrashReport
import other.base.AppInfo
import other.base.LogDebug

/**
 * 静态类
 * 描述手机的信息
 */
object PhoneInfo{
    var screenWidth : Int = 0
    var screenHeight : Int = 0
    var onCreateTime :Long = 0
    var onResumeTime :Long = 0
    var phoneRun :PhoneRun = PhoneRun.NULL//手机运行跑分

    fun init(context :Context){
        val w = context.resources.displayMetrics.widthPixels
        val h = context.resources.displayMetrics.heightPixels
        if (w > h) {
            screenWidth = w
            screenHeight = h
        }else{
            screenWidth = h
            screenHeight = w
        }
    }

    fun setCreateTime(end:Long){
        if (onResumeTime == 0L && end > 0) {
            onResumeTime = end
            val t = onResumeTime - onCreateTime
            phoneRun = if (t < PhoneRun.Good.time){
                PhoneRun.Good
            }else if (t < PhoneRun.Ordinary.time){
                PhoneRun.Ordinary
            }else{
                PhoneRun.Worst
            }
            LogDebug.d("show", "PhoneInfo $t $phoneRun")
            CrashReport.putUserData(AppInfo.getContext(),"phoneRun","首页时间：$t $phoneRun")
        }
    }
}
