package v.main

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Bundle
import android.webkit.*
import com.bumptech.glide.Glide
import com.yyx.R
import kotlinx.android.synthetic.main.main_activity_main.*
import other.base.BaseActivity
import other.base.GlideApp
import other.base.LogDebug

/**
 * Created by Administrator on 2018/5/31.
 */

class MainActivity : BaseActivity() {
    var webview :WebView?= null
    var layoutHelp : MainActivityLayoutHelp? = MainActivityLayoutHelp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)
        layoutHelp!!.reSize(title1,buttonlist1)
        layoutHelp = null
    }

    override fun onStart() {
        super.onStart()
        GlideApp.with(backgroundimage1).load(R.drawable.background).into(backgroundimage1)
        getBackgroundImage()
        addClickEventOrRemove(true)
    }

    override fun onStop() {
        super.onStop()
        addClickEventOrRemove(false)

        //webview的销毁
        webview?.destroy()
        webview = null
        Glide.get(this).clearMemory()
    }

    private fun addClickEventOrRemove(boolean: Boolean){
        if (boolean){
            backgroundimage1.setOnLongClickListener {
                getBackgroundImage()
                true
            }
        }else{
            backgroundimage1.setOnLongClickListener(null)
        }
    }

    //背景图片的切换效果
    private fun getBackgroundImage(){
        if (webview == null)
            webview = WebView(this)
    }
}
