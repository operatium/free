package c.app

import android.content.Context
import android.content.Intent
import v.activity.meiyan.MeiyanActivity

/**
 * 管理APP的路由功能
 */

object RouteControl {

    //跳转首页
    fun ToMeiyan(context: Context) {
        context.startActivity(Intent(context, MeiyanActivity::class.java))
    }
}