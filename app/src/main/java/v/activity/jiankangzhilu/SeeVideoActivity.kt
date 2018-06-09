package v.activity.jiankangzhilu

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

import com.yyx.R
import kotlinx.android.synthetic.main.jiankangzhilu_activity_main.*
import m.EventBusType
import m.MessageEvent
import org.greenrobot.eventbus.EventBus

import other.base.BaseActivity
import other.base.LogDebug
import other.fitscreen.FitControl
import other.fitscreen.FitFactory
import other.fitscreen.FitWidthConstraintLayoutFactory

/**
 * Created by Administrator on 2018/6/8.
 */

class SeeVideoActivity : BaseActivity() {
    val url = "http://tv.cctv.com/lm/jkzl/videoset/"


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jiankangzhilu_activity_main)
        //标题
        FitFactory.setTextView(title2, 50, null)

        //指纹
        FitWidthConstraintLayoutFactory.setImageView_DesignSize(mainbutton2, R.drawable.ic_group_work_white_48dp
                , null, 100, 100, 0, 0, 0, 0, 20)
        val gradientDrawable1 = GradientDrawable()
        // 形状-圆角矩形
        gradientDrawable1.shape = GradientDrawable.RECTANGLE
        // 圆角
        gradientDrawable1.cornerRadius = FitControl.getSize(100).toFloat()
        gradientDrawable1.setColor(Color.RED)
        mainbutton2.background = gradientDrawable1
        mainbutton2.setOnClickListener {
            webview2.loadUrl(url)
        }

        //返回按钮
        FitWidthConstraintLayoutFactory.setDesignSize(back2,80,80)
        back2.setOnClickListener {
            finish()
        }

        val setting = webview2.settings
        setting.javaScriptEnabled = true
        setting.loadWithOverviewMode = true
        setting.javaScriptCanOpenWindowsAutomatically = true
        setting.setSupportMultipleWindows(true)
        webview2.webChromeClient = WebChromeClient()
        webview2.loadUrl(url)
        webview2.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (Build.VERSION.SDK_INT < 24) {
                    LogDebug.d("show", "getBackgroundImage = $url")
                    view.loadUrl(url)
                }
                return super.shouldOverrideUrlLoading(view, url)
            }

            @TargetApi(24)
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                if (Build.VERSION.SDK_INT >= 24) {
                    LogDebug.d("show", "getBackgroundImage 24 = " + request.url.toString())
                    EventBus.getDefault().post(MessageEvent().setType(EventBusType.GetBackgroundUrl).setStr1(request.url.toString()))
                }
                return super.shouldOverrideUrlLoading(view, request)
            }
        }
        ClearHelp().clear(this)

    }

    override fun onStop() {
        super.onStop()
        webview2.stopLoading()
    }

    override fun onDestroy() {
        super.onDestroy()
        webview2.destroy()
    }
}
