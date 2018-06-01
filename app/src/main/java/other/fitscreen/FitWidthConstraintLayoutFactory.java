package other.fitscreen;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;

import other.base.LogDebug;

/**
 * Created by opera on 2018/6/1.
 */

public class FitWidthConstraintLayoutFactory {

    public static void setDesignSize(View view, int designWidth, int designHeight){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof ConstraintLayout.LayoutParams){
            p.width = FitControl.INSTANCE.getSize(designWidth);
            p.height = FitControl.INSTANCE.getSize(designHeight);
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201806011710","view is not ConstraintLayout ("+view.getClass().getName()+")");
        }
    }
}
