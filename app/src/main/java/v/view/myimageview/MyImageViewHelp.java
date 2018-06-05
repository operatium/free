package v.view.myimageview;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.yyx.R;

import other.base.LogDebug;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MyImageViewHelp {
    private Matrix tempMatrix = new Matrix();
    /**
     * move
     */
    public void MoveBegin(ImageView view, MyImageViewModel model){
        if (model.getRect() == null) {
            Rect rect = new Rect();
            rect.left = view.getLeft();
            rect.top = view.getTop();
            rect.right = view.getRight();
            rect.bottom = view.getBottom();
            model.setRect(rect);
        }
        if (model.getMatrix() == null)
            model.setMatrix(view.getImageMatrix());
    }

    public void MoveDown(ImageView view,MotionEvent event,MyImageViewModel model) {
        model.setSingleClickLast(event.getX(),event.getY());
        model.getCurrentMatrix().set(view.getImageMatrix());
    }

    public void MoveMove(ImageView view, MotionEvent event, MyImageViewModel model) {
        if (view.getTag(R.id.Animation) != null)
            return;
        float translationX = event.getX() - model.getSingleClickLast().x;
        float translationY = event.getY() - model.getSingleClickLast().y;
        LogDebug.d("touch","translationX = " + translationX);
        model.getMatrix().set(model.getCurrentMatrix());
        model.getMatrix().postTranslate(translationX,translationY);
        view.setImageMatrix(model.getMatrix());
    }

    public void MoveUP(final View view, final MyImageViewModel model){

    }

    public void MoveCancel(View view){
        Object o = view.getTag(R.id.Animation);
        if (o != null && o instanceof ValueAnimator){
            ((ValueAnimator) o).removeAllListeners();
            ((ValueAnimator) o).cancel();
            view.setTag(R.id.Animation,null);
        }
    }

    /**
     * scale
     */
    public void ScaleBegin(){

    }
}
