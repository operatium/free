package v.main

import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.yyx.R
import kotlinx.android.synthetic.main.main_activity_main.*
import other.base.BaseActivity
import android.widget.Toast
import android.webkit.JavascriptInterface
import v.main.MainActivity.JsInteraction





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

        background1.getSettings().setJavaScriptEnabled(true)
        background1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true)
        background1.getSettings().setSupportMultipleWindows(true)
        background1.setWebViewClient(WebViewClient())
        background1.setWebChromeClient(WebChromeClient())
        background1.loadUrl("https://source.unsplash.com/random")
        background1.addJavascriptInterface(JsInteraction(), "control")
    }

    inner class JsInteraction {
        @JavascriptInterface
        fun toastMessage(message: String) {   //提供给js调用的方法
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }
}
