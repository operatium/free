package v.fragment.meiyan

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yyx.R
import kotlinx.android.synthetic.main.meiyan_fragment_main.*

import other.base.BaseFragment
import other.base.GlideApp
import other.base.LogDebug
import com.mt.mtxx.image.JNI
import java.io.File
import android.graphics.Bitmap


/**
 * Created by Administrator on 2018/6/3.
 */

class MeiyanFragment : BaseFragment() {
    private var path: String? = null
    private val utile = JNI()

    companion object {

        fun newInstance(path: String): MeiyanFragment {
            val fragment = MeiyanFragment()
            fragment.path = path
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        try {
            return inflater.inflate(R.layout.meiyan_fragment_main, container,false)
        } catch (e: Exception) {
            LogDebug.e("201806032202",e.toString(),e)
            return null
        }
    }

    override fun onStart() {
        super.onStart()
        try {
            GlideApp.with(image3).load(Uri.fromFile(File(path))).into(image3)
            addClickEventOrRemove(true)
        }catch (e : Exception){
            LogDebug.e("201806032155",e.toString(),e)
        }
    }

    override fun onStop() {
        super.onStop()
        addClickEventOrRemove(false)
    }

    fun addClickEventOrRemove(boolean: Boolean){
        if (boolean){
            back3.setOnClickListener{
                activity?.finish()
            }
            button3.setOnClickListener {
                image3.isDrawingCacheEnabled = true
                val ima = process(image3.drawingCache)
                image3.setImageDrawable(null)
                image3.setImageBitmap(ima)
            }
        }else{
            back3.setOnClickListener(null)
            button3.setOnClickListener(null)
        }
    }

    fun process(bm:Bitmap):Bitmap {
        LogDebug.d("show","process start")
        val width = bm.getWidth()
        val height = bm.getHeight()
        val pixels = IntArray(width * height)
        // getPixels执行之后pixels数组就被修改了 pixel中保存了bm的颜色信息
        bm.getPixels(pixels, 0, width, 0, 0, width, height)
        // StyleLomoB运行后，pixel的颜色信息已经被修改 修改成特效处理后的颜色信息
        try {
            utile.StyleJapanese(pixels, width, height)
        }catch (e :Exception){
            LogDebug.e("201806111306",e.toString(),e)
        }
        // 用处理好的像素数组 创建一张新的图片就是经过特效处理的
        LogDebug.d("show","process end")
        return Bitmap.createBitmap(pixels, width, height, bm.getConfig())
    }
}
