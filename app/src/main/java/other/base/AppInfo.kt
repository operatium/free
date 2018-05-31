package other.base

import android.content.Context

/**
 * 静态类
 * 描述app的信息
 */

object AppInfo{
    private var application : MyAPP? = null

    fun init(app:MyAPP){
        application = app
    }

    fun getContext() :Context{
        return application!!.applicationContext
    }

    /**
     * 获取版本号
     * @return 当前应用的版本号
     */
    fun getVersion(): String {
        try {
            val context = getContext()
            val manager = context.packageManager
            val info = manager.getPackageInfo(context.packageName, 0)
            val str=  info.versionName
            if (str?.isNotEmpty() == true)
                return str
        } catch (e: Exception) {
            LogDebug.e("201606081432",e.toString(),e)
        }
        return ""
    }
}
