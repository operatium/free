package c.app

import android.content.Context
import android.content.Intent
import v.main.MainActivity

/**
 * 管理APP的路由功能
 */

object RouteControl {

    //跳转首页
    fun ToHome(context: Context) {
        context.startActivity(Intent(context, MainActivity::class.java))
    }
}