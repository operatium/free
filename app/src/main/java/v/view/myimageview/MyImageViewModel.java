package v.view.myimageview;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MyImageViewModel {
    private Rect rect;//view的矩形区域
    private PointF singleClickLast;//单指操作的最后坐标
    private Matrix matrix = new Matrix();
    private Matrix currentMatrix = new Matrix();

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public void setSingleClickLast(float x,float y) {
        if (singleClickLast == null)
            singleClickLast = new PointF(x,y);
        else {
            singleClickLast.x = x;
            singleClickLast.y = y;
        }
    }

    public PointF getSingleClickLast() {
        return singleClickLast;
    }

    public void setSingleClickLast(PointF singleClickLast) {
        this.singleClickLast = singleClickLast;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public Matrix getCurrentMatrix() {
        return currentMatrix;
    }

    public void setCurrentMatrix(Matrix currentMatrix) {
        this.currentMatrix = currentMatrix;
    }
}
