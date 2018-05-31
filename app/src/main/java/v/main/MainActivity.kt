package v.main

import android.os.Bundle
import android.os.PersistableBundle
import com.yyx.R
import kotlinx.android.synthetic.main.main_activity_main.*
import other.base.BaseActivity

/**
 * Created by Administrator on 2018/5/31.
 */

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)
    }

    override fun onStart() {
        super.onStart()
        loadBackgroundImage()
    }

    override fun onStop() {
        super.onStop()
    }

    fun loadBackgroundImage(){
        val webSettings = background1.settings
        // 设置与Js交互的权限
        webSettings.javaScriptEnabled = true
        // 设置允许JS弹窗
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        background1.loadUrl("https://source.unsplash.com/random")
    }
}
