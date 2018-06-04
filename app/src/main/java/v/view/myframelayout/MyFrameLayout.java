package v.view.myframelayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

import other.base.LogDebug;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MyFrameLayout extends FrameLayout {
    public MyFrameLayout(@NonNull Context context) {
        super(context);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean b = super.dispatchTouchEvent(ev);
        LogDebug.d("touch","viewgroup dispatchTouchEvent return " + b);
        return b;
    }

    //拦截函数
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean b=  super.onInterceptTouchEvent(ev);
        LogDebug.d("touch","viewgroup onInterceptTouchEvent return " + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b=  super.onTouchEvent(event);
        LogDebug.d("touch","viewgroup onTouchEvent return " + b);
        return b;
    }
}
