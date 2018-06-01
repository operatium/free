package other.fitscreen;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by opera on 2018/5/18.
 */

public class FitFactory {

    //文本控件字体 字号
    public static void setTextView(TextView tv, int fontsize, Typeface typeface){
        FitControl.INSTANCE.setFontSize(tv,fontsize);
        if (typeface != null)
            tv.setTypeface(typeface);
    }

    public static TextView setTextViewFormParentView(View root, int tvid, int fontsize, Typeface typeface){
        TextView tv = root.findViewById(tvid);
        FitControl.INSTANCE.setFontSize(tv,fontsize);
        tv.setTypeface(typeface);
        return tv;
    }

    //全屏尺寸
    public static ViewGroup.LayoutParams getFullLayoutParams(){
        return new ViewGroup.LayoutParams(FitControl.INSTANCE.getFullWidth(), FitControl.INSTANCE.getFullHeight());
    }

    //无指定布局器
    public static void setLayoutParamsWidthHeight(View view, int designWidth,int designHeight){
        view.setLayoutParams(new ViewGroup.LayoutParams(FitControl.INSTANCE.getSize(designWidth), FitControl.INSTANCE.getSize(designHeight)));
    }

    //无指定布局器
    public static void setLayoutParamsWidth(View view, int designWidth,int height){
        view.setLayoutParams(new ViewGroup.LayoutParams(FitControl.INSTANCE.getSize(designWidth), height));
    }

    //无指定布局器
    public static void setLayoutParamsHeight(View view, int width,int designHeight){
        view.setLayoutParams(new ViewGroup.LayoutParams(width, FitControl.INSTANCE.getSize(designHeight)));
    }

    //无指定布局器
    public static void setLayoutParams(View view, int width,int height){
        view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
    }
}
