package v.view.myimageview;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.yyx.R;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MyImageViewHelp {
    private Matrix temp_pre = new Matrix();
    private Matrix temp_now = new Matrix();

    private PointF move_point_pre = new PointF();//移动的时候 按下的位置

    private double scale_distance_pre;//缩放的时候 按下时的2个手指间距离
    private PointF scale_midPoint_pre;//缩放的时候 按下时的2个手指间中间点

    private int drawMode = 0;//模式 0=空 1=移动 2=缩放

    private float[] old;
    private float[] values_MaxOrMin;//存下极限值 缩放可以改 锚点一直在变 需要存下来恢复
    private float[] temp_values = new float[9];


    /**
     * move
     */
    public void begin(ImageView view ) {
        if (old == null) {
            old = new float[9];
            view.getImageMatrix().getValues(old);
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
        values_MaxOrMin = null;//移动过锚点不准确了
    }

    public void moveUP(final ImageView view) {
        if (drawMode == 1){
            float[] nowvalue = new float[9];
            final Matrix endM = view.getImageMatrix();
            endM.getValues(nowvalue);
            temp_now.set(endM);
            final float x = nowvalue[2] - old[2];
            final float y = nowvalue[5] - old[5];
            Object tag = view.getTag(R.id.Animation);
            if (tag == null) {
                ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float f = (float) animation.getAnimatedValue();
                        //回到原点怎么写
                        if (f == 1) {
                            animation.removeAllListeners();
                            view.setTag(R.id.Animation, null);
                        }
                    }
                });
                animator.start();
                view.setTag(R.id.Animation, animator);
            }
        }
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
            float scale = Double.valueOf(distance_now / scale_distance_pre).floatValue();
            temp_now.set(temp_pre);
            temp_now.postScale(scale, scale, scale_midPoint_pre.x, scale_midPoint_pre.y);
            temp_now.getValues(temp_values);

            boolean jixian = false;

            if (temp_values[0] <= 0.31f) {
                temp_values[0] = 0.3f;
                jixian = true;

            } else if (temp_values[0] >= 2.9f) {
                temp_values[0] = 3;
                jixian = true;

            }
            if (temp_values[4] <= 0.31f) {
                temp_values[4] = 0.3f;
                jixian = true;

            } else if (temp_values[4] >= 2.9f) {
                temp_values[4] = 3;
                jixian = true;

            }

            if (!jixian)
                values_MaxOrMin = null;
            else{
                if (values_MaxOrMin == null)
                    values_MaxOrMin = temp_values.clone();
                else
                    temp_values = values_MaxOrMin.clone();
            }

            temp_now.setValues(temp_values);
            view.setImageMatrix(temp_now);
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
