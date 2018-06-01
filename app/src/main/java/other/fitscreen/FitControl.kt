package other.fitscreen

import android.support.constraint.ConstraintLayout
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * 适配方案：横屏，高度适配
 */

object FitControl{
    private val designWidth = 720
    private val designHeight = 1280
    private val type:FitType = FitType.WidthFit

    fun getSize(desSize : Int) : Int{
        return getSize(desSize.toFloat(), type)
    }

    fun getSize(desSize : Float) : Int{
        return getSize(desSize, type)
    }

    fun getSize(desSize: Float,fit : FitType) : Int{
        when(fit){
            FitType.WidthFit ->{
                val size = desSize * PhoneInfo.screenWidth / designWidth
                return size.toInt()
            }
            FitType.HeightFit ->{
                val size = desSize * PhoneInfo.screenHeight / designHeight
                return size.toInt()
            }
            else ->{
                return desSize.toInt()
            }
        }
    }

    fun getFullWidth() : Int{
        return PhoneInfo.screenWidth
    }

    fun getFullHeight() : Int{
        return PhoneInfo.screenHeight
    }

    fun reSize_ConstraintLayout(view :View,designWidth :Int,designHeight :Int,viewheight :Int){
        val p = getConstraintLayoutLayoutParams(view)
        p?.width = (designWidth*1.0*viewheight/designHeight).toInt()
        p?.height = viewheight
        setConstraintLayoutLayoutParams(view,p)
    }

    //ConstraintLayout
    fun getConstraintLayoutLayoutParams(view : View) : ConstraintLayout.LayoutParams?{
        val p = view.layoutParams
        return p as? ConstraintLayout.LayoutParams
    }

    @Throws(Exception::class)
    fun setConstraintLayoutLayoutParams(view : View,p : ConstraintLayout.LayoutParams?) {
        if (p == null)
            throw Exception("LayoutParams of view is not ConstraintLayout.LayoutParams ")
        else{
            view.layoutParams = p
        }
    }


    fun getViewGroupLayoutParams(view : View) : ViewGroup.LayoutParams?{
        val p = view.layoutParams
        return p
    }

    @Throws(Exception::class)
    fun setViewGroupLayoutParams(view : View,p : ViewGroup.LayoutParams?) {
        if (p == null)
            throw Exception("LayoutParams of view is not ViewGroup.LayoutParams ")
        else{
            view.layoutParams = p
        }
    }

    //LinearLayout
    fun getLinearLayoutLayoutParams(view : View) : LinearLayout.LayoutParams?{
        val p = view.layoutParams
        return p as? LinearLayout.LayoutParams
    }

    @Throws(Exception::class)
    fun setLinearLayoutLayoutParams(view : View,p : LinearLayout.LayoutParams?) {
        if (p == null)
            throw Exception("LayoutParams of view is not LinearLayout.LayoutParams ")
        else{
            view.layoutParams = p
        }
    }

    //RelativeLayout
    fun getRelativeLayoutLayoutParams(view : View) : RelativeLayout.LayoutParams?{
        val p = view.layoutParams
        return p as? RelativeLayout.LayoutParams
    }

    @Throws(Exception::class)
    fun setRelativeLayoutLayoutParams(view : View,p : RelativeLayout.LayoutParams?) {
        if (p == null)
            throw Exception("LayoutParams of view is not RelativeLayout.LayoutParams ")
        else{
            view.layoutParams = p
        }
    }

    //FrameLayout
    fun getFrameLayoutLayoutParams(view : View) : FrameLayout.LayoutParams?{
        val p = view.layoutParams
        return p as? FrameLayout.LayoutParams
    }

    @Throws(Exception::class)
    fun setFrameLayoutLayoutParams(view : View,p : FrameLayout.LayoutParams?) {
        if (p == null)
            throw Exception("LayoutParams of view is not FrameLayout.LayoutParams ")
        else{
            view.layoutParams = p
        }
    }

    //设置文本字体尺寸
    fun setFontSize(textView: TextView?, size: Int) {
        textView?.setTextSize(TypedValue.COMPLEX_UNIT_PX, getSize(size).toFloat())
    }
}
