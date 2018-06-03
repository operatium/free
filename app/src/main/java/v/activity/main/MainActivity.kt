package v.activity.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.webkit.*
import c.main.FunctionListAdapter
import com.bumptech.glide.Glide
import com.yyx.R
import kotlinx.android.synthetic.main.main_activity_main.*
import m.EventBusType
import m.MessageEvent
import m.main.MainActivityModel
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import other.base.BaseActivity
import other.base.GlideApp

/**
 * 菜单列表
 * Created by Administrator on 2018/5/31.
 */

class MainActivity : BaseActivity() {
    var webview :WebView?= null
    var layoutHelp : MainActivityLayoutHelp? = MainActivityLayoutHelp()
    var business : MainActivityBusiness? = null
    var mymodel : MainActivityModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)

        //布局尺寸
        layoutHelp!!.reSize(title1,functionlist1,mainbutton1)
        layoutHelp!!.setMainButtonBackground(mainbutton1)
        layoutHelp = null
    }

    override fun onStart() {
        super.onStart()

        //模型类
        business = MainActivityBusiness()
        mymodel = MainActivityModel()

        //注册
        EventBus.getDefault().register(this)

        //加载背景
        GlideApp.with(backgroundimage1).load(R.drawable.main_background).into(backgroundimage1)
        getBackgroundImage()

        //点击事件
        addClickEventOrRemove(true)

        //列表
        val adapter = FunctionListAdapter()
        adapter.reLoad(mymodel!!.functionList)
        functionlist1.adapter = adapter
        functionlist1.layoutManager = GridLayoutManager(this,2,RecyclerView.VERTICAL,false)
    }

    override fun onStop() {
        super.onStop()

        //注销
        EventBus.getDefault().unregister(this)

        //列表
        functionlist1.adapter = null
        functionlist1.layoutManager = null

        //点击事件
        addClickEventOrRemove(false)

        //webview的销毁
        webview?.destroy()
        webview = null

        //图片回收
        Glide.get(this).clearMemory()

        //模型类
        mymodel = null
        business = null
    }

    private fun addClickEventOrRemove(boolean: Boolean){
        if (boolean){
            backgroundimage1.setOnLongClickListener {
                GlideApp.with(backgroundimage1).load(R.drawable.main_background).into(backgroundimage1)
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
        business!!.jsToUrl(webview,mymodel!!.url)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(msg :MessageEvent){
        when(msg.type){

            //webview获取到url 图片进行加载
            EventBusType.GetBackgroundUrl->{
                if (msg.str1?.isNotEmpty() == true)
                GlideApp.with(backgroundimage1).load(msg.str1).placeholder(R.drawable.main_background).into(backgroundimage1)
            }
            else->{

            }
        }
    }
}
