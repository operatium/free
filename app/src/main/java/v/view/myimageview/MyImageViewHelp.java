package v.view.myimageview;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.yyx.R;

import java.util.Arrays;

import other.base.LogDebug;

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

    private float[] values_MaxOrMin;//存下极限值 缩放可以改 锚点一直在变 需要存下来恢复
    private float[] temp_values = new float[9];

    private long time_pre;//双击的时间

    private float[] values_now = new float[9];//获取当前的矩阵数据 用于回弹动画

    /**
     * 初始化图片
     */
    public void initBitmap(ImageView view) {
        try {
            if (view.getDrawable() == null)
                return;
            float scale;
            float dx;
            float dy;

            int dwidth = view.getDrawable().getIntrinsicWidth();
            int dheight = view.getDrawable().getIntrinsicHeight();
            int vwidth = view.getWidth() - view.getPaddingLeft() - view.getPaddingRight();
            int vheight = view.getHeight() - view.getPaddingTop() - view.getPaddingBottom();
            if (dwidth <= vwidth && dheight <= vheight) {
                scale = 1.0f;
            } else {
                scale = Math.min(vwidth * 1.0f / dwidth,
                        vheight * 1.0f / dheight) * 0.98f;
            }

            dx = Math.round((vwidth - dwidth * scale) * 0.5f);
            dy = Math.round((vheight - dheight * scale) * 0.5f);

            Matrix matrix = new Matrix();
            matrix.set(view.getImageMatrix());
            matrix.setScale(scale, scale);
            matrix.postTranslate(dx, dy);
            view.setImageMatrix(matrix);

        } catch (Exception e) {
            LogDebug.e("201806070949", e.toString(), e);
        }
    }

    /**
     * move
     */
    public void begin(ImageView view) {

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
        drawMode = 0;
        if (view.getDrawable() == null) {
            return;
        }

        view.getImageMatrix().getValues(values_now);
        float dwidth = view.getDrawable().getIntrinsicWidth() * values_now[0];
        float dheight = view.getDrawable().getIntrinsicHeight() * values_now[4];
        int vwidth = view.getWidth() - view.getPaddingLeft() - view.getPaddingRight();
        int vheight = view.getHeight() - view.getPaddingTop() - view.getPaddingBottom();
        float translationX = values_now[2];
        float translationY = values_now[5];

        if (dwidth <= vwidth && dheight <= vheight) {//缩小 返回居中
            backCenter(view, vwidth, vheight, dwidth, dheight, values_now);
        } else {//放大 贴边
            float vleft = 0;
            float vright = vwidth;
            float vtop = 0;
            float vbottom = vheight;
            float dleft = translationX;
            float dright = translationX + dwidth;
            float dtop = translationY;
            float dbottom = translationY + dheight;
            backEdging(view, vwidth, vheight, dwidth, dheight
                    , vleft, vtop, vright, vbottom, dleft, dtop, dright, dbottom, values_now);

        }
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
    public void scalePointer_Down(ImageView view, MotionEvent event) {
        scale_distance_pre = distance(event);
        if (scale_distance_pre > 10) {
            drawMode = 2;
            scale_midPoint_pre = mid(event);
            temp_pre.set(view.getImageMatrix());
        }
    }

    public void scaleMove(ImageView view, MotionEvent event) {
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
            else {
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

    /**
     * 计算两个手指间的距离
     * 使用勾股定理返回两点之间的距离
     */
    private double distance(MotionEvent event) {
        float dx = event.getX(1) - event.getX(0);
        float dy = event.getY(1) - event.getY(0);
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * 计算两个手指间的中间点
     */
    private PointF mid(MotionEvent event) {
        float midX = (event.getX(1) + event.getX(0)) / 2;
        float midY = (event.getY(1) + event.getY(0)) / 2;
        return new PointF(midX, midY);
    }

    /**
     * 回弹恢复
     */
    //双击 恢复到初始化
    public void backDown(ImageView view) {
        long t = System.currentTimeMillis() - time_pre;
        if (t < 200) {
            time_pre = 0;
            Object animator = view.getTag(R.id.Animation);
            if (animator != null && animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).removeAllUpdateListeners();
                view.setTag(R.id.Animation, null);
            }
            //双击效果
            initBitmap(view);
            drawMode = 0;
        } else {
            time_pre = System.currentTimeMillis();
        }
    }

    //缩小后 移动返回居中位置
    private void backCenter(final ImageView view, float vwidth, float vheight, float dwidth, float dheight, final float[] values) {
        final float dx = Math.round((vwidth - dwidth) * 0.5f);
        final float dy = Math.round((vheight - dheight) * 0.5f);
        float nowx = values[2];
        float nowy = values[5];
        if (dx == nowx)//k不可运算
        {
            if (dy == nowy)
                return;
            final Matrix matrix = new Matrix();
            ValueAnimator animator = ValueAnimator.ofFloat(nowy, dy);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float y = (float) animation.getAnimatedValue();
                    values[5] = y;
                    matrix.setValues(values);
                    view.setImageMatrix(matrix);
                    LogDebug.d("animation", Arrays.toString(values));
                    if (y == dy) {
                        animation.removeAllUpdateListeners();
                        view.setTag(R.id.Animation, null);
                    }
                }
            });
            animator.start();
            view.setTag(R.id.Animation, animator);
        }else {
            final float k = (dy - nowy) / (dx - nowx);//直线的斜率
            final float c = nowy - nowx * k;
            final Matrix matrix = new Matrix();
            ValueAnimator animator = ValueAnimator.ofFloat(nowx, dx);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float x = (float) animation.getAnimatedValue();
                    values[2] = x;
                    values[5] = k * x + c;
                    matrix.setValues(values);
                    view.setImageMatrix(matrix);
                    LogDebug.d("animation", Arrays.toString(values));
                    if (x == dx) {
                        animation.removeAllUpdateListeners();
                        view.setTag(R.id.Animation, null);
                    }
                }
            });
            animator.start();
            view.setTag(R.id.Animation, animator);
        }
    }

    //放大后 靠边
    private void backEdging(final ImageView view, float vwidth, float vheight, float dwidth, float dheight
            , float vleft, float vtop, float vright, float vbottom, float dleft, float dtop, float dright, float dbottom, float[] values) {

        final float[] tempvalue = new float[9];

        //终点
        float translationX = values[2];
        float translationY = values[5];
        if (dleft > vleft && dleft < vright) {
            //左靠边
            translationX = 0;
            LogDebug.d("animation", "左靠边" + Arrays.toString(values));
        } else if (dright > vleft && dright < vright) {
            //右靠边
            translationX = vwidth - dwidth;
            LogDebug.d("animation", "右靠边" + Arrays.toString(values));
        }
        if (dtop > vtop && dtop < vbottom) {
            //上靠边
            translationY = 0;
            LogDebug.d("animation", "上靠边" + Arrays.toString(values));
        } else if (dbottom > vtop && dbottom < vbottom) {
            //下靠边
            translationY = vheight - dheight;
            LogDebug.d("animation", "下靠边" + Arrays.toString(values));
        }

        //起点
        Matrix matrix = view.getImageMatrix();
        matrix.getValues(tempvalue);
        float x1 = tempvalue[2];
        float y1 = tempvalue[5];

        //有斜率
        if (x1 != translationX) {
            final float k = (y1 - translationY) / (x1 - translationX);
            final float c = y1 - x1 * k;

            final float[] val = values.clone();
            final float zhongdianx = translationX;
            final Matrix temp = new Matrix();

            ValueAnimator animator = ValueAnimator.ofFloat(x1, translationX);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float x = (float) animation.getAnimatedValue();
                    float y = k * x + c;
                    val[2] = x;
                    val[5] = y;
                    temp.setValues(val);
                    view.setImageMatrix(temp);
                    LogDebug.d("animation1", Arrays.toString(val));

                    if (x == zhongdianx) {
                        animation.removeAllUpdateListeners();
                        view.setTag(R.id.Animation, null);
                    }
                }
            });
            animator.start();
            view.setTag(R.id.Animation, animator);
        } else {//没有斜率
            if (y1 == translationY)
                return;
            final float[] val = values.clone();
            final float zhongdiany = translationY;
            final Matrix temp = new Matrix();
            ValueAnimator animator = ValueAnimator.ofFloat(y1, translationY);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float y = (float) animation.getAnimatedValue();
                    val[5] = y;
                    temp.setValues(val);
                    view.setImageMatrix(temp);
                    LogDebug.d("animation2", Arrays.toString(val));
                    if (y == zhongdiany) {
                        animation.removeAllUpdateListeners();
                        view.setTag(R.id.Animation, null);
                    }
                }
            });
            animator.start();
            view.setTag(R.id.Animation, animator);
        }
    }
}