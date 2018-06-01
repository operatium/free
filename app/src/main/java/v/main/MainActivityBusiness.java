package v.main;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.yyx.R;

import org.greenrobot.eventbus.EventBus;

import m.MessageEvent;
import other.base.LogDebug;

/**
 * Created by opera on 2018/6/1.
 */

public class MainActivityBusiness {

    //加载webview获取背景图片
    @SuppressLint("SetJavaScriptEnabled")
    public void jsToUrl(WebView webview,String url){//"https://source.unsplash.com/random"
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
                LogDebug.d("show","webViewClient shouldOverrideUrlLoading => url = $url");
                EventBus.getDefault().post(new MessageEvent().setStr1(url));
                return super.shouldOverrideUrlLoading(view, url);
            }

            @TargetApi(24)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                EventBus.getDefault().post(new MessageEvent().setStr1(request.getUrl().toString()));
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }
}
