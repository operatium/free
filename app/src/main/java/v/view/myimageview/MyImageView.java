package v.view.myimageview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import other.base.LogDebug;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView {
    private MyImageViewHelp help;

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
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean b = super.dispatchTouchEvent(event);
        LogDebug.d("touch", "view dispatchTouchEvent return " + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (help == null)
            help = new MyImageViewHelp();

        help.begin(this, event);

        switch (event.getActionMasked()) {

            case MotionEvent.ACTION_DOWN:
                help.moveDown(this, event);
                break;

            case MotionEvent.ACTION_MOVE:
                help.moveMove(this, event);
                help.scaleMove(this, event);
                break;

            case MotionEvent.ACTION_UP:
                help.moveUP();
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