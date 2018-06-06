package v.view.myimageview;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.yyx.R;

import other.base.LogDebug;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MyImageViewHelp {
    private int wMin;
    private int hMin;

    private Matrix temp_pre = new Matrix();
    private Matrix temp_now = new Matrix();

    private PointF move_point_pre = new PointF();

    private double scale_distance_pre;
    private PointF scale_midPoint_pre;

    private int drawMode = 0;//模式 0=空 1=移动 2=缩放

    private final float scaleMinimum =0.1f;
    private final float scaleMax = 10;
    private float allScale = 1;

    /**
     * move
     */
    public void begin(ImageView view, MotionEvent event) {
        if (wMin == 0 || hMin == 0) {
            Rect rect = view.getDrawable().copyBounds();
            int oldh = rect.bottom - rect.top;
            int oldw = rect.right - rect.left;
            wMin = (int) (oldw * 0.1f);
            hMin = (int) (oldh * 0.1f);
        }
    }

    public void moveDown(ImageView view, MotionEvent event) {
        drawMode = 1;
        move_point_pre.x = event.getX();
        move_point_pre.y = event.getY();
        temp_pre.set(view.getImageMatrix());
    }

    public void moveMove(ImageView view, MotionEvent event) {
        if (view.getTag(R.id.Animation) != null || drawMode != 1)
            return;
        float translationX = event.getX() - move_point_pre.x;
        float translationY = event.getY() - move_point_pre.y;
        temp_now.set(temp_pre);
        temp_now.postTranslate(translationX, translationY);
        view.setImageMatrix(temp_now);
    }

    public void moveUP() {
        drawMode = 0;
    }

    public void moveCancel(ImageView view) {
        Object o = view.getTag(R.id.Animation);
        if (o != null && o instanceof ValueAnimator) {
            ((ValueAnimator) o).removeAllListeners();
            ((ValueAnimator) o).cancel();
            view.setTag(R.id.Animation, null);
        }
    }

    /**
     * scale
     */
    public void scalePointer_Down(ImageView view,MotionEvent event) {
        scale_distance_pre = distance(event);
        if (scale_distance_pre > 10) {
            drawMode = 2;
            scale_midPoint_pre = mid(event);
            temp_pre.set(view.getImageMatrix());
        }
    }

    public void scaleMove(ImageView view,MotionEvent event) {
        if (view.getTag(R.id.Animation) != null || drawMode != 2)
            return;
        double distance_now = distance(event);
        if (distance_now > 10) {
            if (allScale > 0.01) {
                float scale = Double.valueOf(distance_now / scale_distance_pre).floatValue();
                allScale = allScale * scale;
                LogDebug.d("touch","allScale = " + allScale);
                temp_now.set(temp_pre);
                temp_now.postScale(scale, scale, scale_midPoint_pre.x, scale_midPoint_pre.y);
                view.setImageMatrix(temp_now);
            }
        }
    }

    public void scalePointer_Up() {
        drawMode = 0;
    }

    /** 计算两个手指间的距离
     * 使用勾股定理返回两点之间的距离 */
    private double distance(MotionEvent event) {
        float dx = event.getX(1) - event.getX(0);
        float dy = event.getY(1) - event.getY(0);
        return Math.sqrt(dx * dx + dy * dy);
    }

    /** 计算两个手指间的中间点 */
    private PointF mid(MotionEvent event) {
        float midX = (event.getX(1) + event.getX(0)) / 2;
        float midY = (event.getY(1) + event.getY(0)) / 2;
        return new PointF(midX, midY);
    }
}
