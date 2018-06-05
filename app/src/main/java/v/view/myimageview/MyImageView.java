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
    private MyImageViewModel myModel;

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
        if (myModel == null)
            myModel = new MyImageViewModel();
        int pc = event.getPointerCount();

        if (pc == 1)
            help.MoveBegin(this,myModel);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if (pc == 1)
                help.MoveDown(this,event,myModel);
                break;

            case MotionEvent.ACTION_MOVE:

                if (pc == 1)
                help.MoveMove(this,event,myModel);
                break;

            case MotionEvent.ACTION_UP:

                if (pc == 1)
                help.MoveUP(this,myModel);
                break;
        }
        return true;
    }

    @Override
    protected void onDetachedFromWindow() {
        if (help != null)
            help.MoveCancel(this);
        help = null;
        myModel = null;
        super.onDetachedFromWindow();
    }
}