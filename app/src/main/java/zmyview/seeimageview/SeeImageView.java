package zmyview.seeimageview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import other.base.LogDebug;

/**
 * 查看图片的控件
 * 可以缩放 移动 双击恢复和放大3倍
 * Created by Administrator on 2018/6/4.
 */

public class SeeImageView extends android.support.v7.widget.AppCompatImageView {
    private SeeImageViewHelp help = new SeeImageViewHelp();

    public SeeImageView(Context context) {
        super(context);
    }

    public SeeImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SeeImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setScaleType(ScaleType.MATRIX);
        help.initBitmap(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean b = super.dispatchTouchEvent(event);
//        LogDebug.d("touch", "view dispatchTouchEvent return " + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
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
        } catch (Exception e) {
            LogDebug.e("201806251043", e.toString(), e);
        }
        return true;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (help == null)
            help = new SeeImageViewHelp();
    }

    @Override
    protected void onDetachedFromWindow() {
        if (help != null)
            help.moveCancel(this);
        help = null;
        super.onDetachedFromWindow();
    }
}