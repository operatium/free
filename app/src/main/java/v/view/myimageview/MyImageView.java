package v.view.myimageview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.util.Arrays;

import other.base.LogDebug;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView {
    private MyImageViewHelp help = new MyImageViewHelp();

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        help.initBitmap(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean b = super.dispatchTouchEvent(event);
        LogDebug.d("touch", "view dispatchTouchEvent return " + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        help.begin(this);

        switch (event.getActionMasked()) {

            case MotionEvent.ACTION_DOWN:
                help.moveDown(this, event);
                help.backDown(this);
                break;

            case MotionEvent.ACTION_MOVE:
                help.moveMove(this, event);
                help.scaleMove(this, event);
                break;

            case MotionEvent.ACTION_UP:
                help.moveUP(this);
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                help.scalePointer_Down(this, event);
                break;

            case MotionEvent.ACTION_POINTER_UP:
                help.scalePointer_Up();
                break;
        }
        return true;
    }

    @Override
    protected void onDetachedFromWindow() {
        if (help != null)
            help.moveCancel(this);
        help = null;
        super.onDetachedFromWindow();
    }
}