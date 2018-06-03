package v.activity.main;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.greenrobot.eventbus.EventBus;

import m.EventBusType;
import m.MessageEvent;
import other.base.LogDebug;

/**
 * Created by opera on 2018/6/1.
 */

public class MainActivityBusiness {

    //加载webview获取背景图片
    @SuppressLint("SetJavaScriptEnabled")
    public void jsToUrl(WebView webview,String url){
        WebSettings setting = webview.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setLoadWithOverviewMode(true);
        setting.setJavaScriptCanOpenWindowsAutomatically(true);
        setting.setSupportMultipleWindows(true);
        webview.setWebChromeClient(new WebChromeClient());
        webview.loadUrl(url);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (Build.VERSION.SDK_INT < 24) {
                    LogDebug.d("show", "getBackgroundImage = " + url);
                    EventBus.getDefault().post(new MessageEvent().setType(EventBusType.GetBackgroundUrl).setStr1(url));
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @TargetApi(24)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= 24) {
                    LogDebug.d("show", "getBackgroundImage 24 = " + request.getUrl().toString());
                    EventBus.getDefault().post(new MessageEvent().setType(EventBusType.GetBackgroundUrl).setStr1(request.getUrl().toString()));
                }
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }
}
