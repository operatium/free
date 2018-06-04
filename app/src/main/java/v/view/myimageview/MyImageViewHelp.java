package v.view.myimageview;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.yyx.R;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MyImageViewHelp {

    /**
     * move
     */
    public void MoveBegin(View view, MyImageViewModel model){
        if (model.getRect() == null) {
            Rect rect = new Rect();
            rect.left = view.getLeft();
            rect.top = view.getTop();
            rect.right = view.getRight();
            rect.bottom = view.getBottom();
            model.setRect(rect);
        }
    }

    public void MoveDown(MotionEvent event,MyImageViewModel model) {
        model.setSingleClickLast(event.getRawX(),event.getRawY());
    }

    public void MoveMove(View view, MotionEvent event, MyImageViewModel model) {
        if (view.getTag(R.id.Animation) != null)
            return;
        int translationX = (int) (event.getRawX() - model.getSingleClickLast().x);
        int translationY = (int) (event.getRawY() - model.getSingleClickLast().y);
        int left = model.getRect().left + translationX;
        int top = model.getRect().top + translationY;
        int right = model.getRect().right + translationX;
        int bottom = model.getRect().bottom + translationY;
        view.layout(left, top, right, bottom);
    }

    public void MoveUP(final View view, final MyImageViewModel model){
        final Rect rect = model.getRect();
        if (view.getTag(R.id.Animation) == null){
            ValueAnimator animator = ValueAnimator.ofFloat(1f,0f);
            animator.setStartDelay(100);
            animator.start();
            final int left = view.getLeft() - rect.left;
            final int top = view.getTop() - rect.top;
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Float value = (Float) animation.getAnimatedValue();
                    int x1 = (int) (left*value);
                    int y1 = (int) (top*value);
                    view.layout(rect.left + x1
                            , rect.top + y1
                            , rect.right + x1
                            , rect.bottom + y1);
                    if (value == 0)
                        view.setTag(R.id.Animation,null);
                }
            });
            view.setTag(R.id.Animation,animator);
        }
    }

    public void MoveCancel(View view){
        Object o = view.getTag(R.id.Animation);
        if (o != null && o instanceof ValueAnimator){
            ((ValueAnimator) o).removeAllListeners();
            ((ValueAnimator) o).cancel();
            view.setTag(R.id.Animation,null);
        }
    }
}
