package other.fitscreen;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import other.base.GlideApp;
import other.base.LogDebug;

/**
 * 高度适配刚工厂类
 * Created by opera on 2018/5/17.
 */

public class FitHeightLinearLayoutFactory {

    /**
     * LinearLayout
     * @param view
     * @param designWidth
     * @param designHeight
     */
    public static void setDesignSize(View view, int designWidth, int designHeight){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof LinearLayout.LayoutParams){
            p.width = FitControl.INSTANCE.getSize(designWidth,FitType.HeightFit);
            p.height = FitControl.INSTANCE.getSize(designHeight,FitType.HeightFit);
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805181150","view is not LinearLayout ("+view.getClass().getName()+")");
        }
    }


    public static void setMarginDesignEnd(View view, int designEnd){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof LinearLayout.LayoutParams){
            ((LinearLayout.LayoutParams) p).setMargins(0,0,FitControl.INSTANCE.getSize(designEnd,FitType.HeightFit),0);
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805181151","view is not LinearLayout ("+view.getClass().getName()+")");
        }
    }

    public static void setMarginDesignTopDesignBottom(View view, int designTop, int designBottom){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof LinearLayout.LayoutParams){
            ((LinearLayout.LayoutParams) p).setMargins(0,FitControl.INSTANCE.getSize(designTop,FitType.HeightFit)
                    ,0,FitControl.INSTANCE.getSize(designBottom,FitType.HeightFit));
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805181152","view is not LinearLayout ("+view.getClass().getName()+")");
        }
    }

    public static void setMarginDesign(View view, int designLeft, int designTop, int designRight, int designBottom){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof LinearLayout.LayoutParams){
            ((LinearLayout.LayoutParams) p).setMargins(
                    FitControl.INSTANCE.getSize(designLeft,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designTop,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designRight,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designBottom,FitType.HeightFit));
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805181152","view is not LinearLayout ("+view.getClass().getName()+")");
        }
    }

    /**
     * ImageView
     * @param view
     * @param designWidth
     * @param designHeight
     * @param img
     */
    public static void setImageViewDesignSize(ImageView view, int designWidth, int designHeight, int img){
        int w = FitControl.INSTANCE.getSize(designWidth,FitType.HeightFit);
        int h = FitControl.INSTANCE.getSize(designHeight,FitType.HeightFit);
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof LinearLayout.LayoutParams){
            p.width = w;
            p.height = h;
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805181159","view is not LinearLayout ("+view.getClass().getName()+")");
        }
        GlideApp.with(view).load(img).override(w,h).into(view);
    }

    public static ImageView setImageViewDesignSizeFromParentView(View root, int viewid,int designWidth, int designHeight, int img){
        ImageView view = root.findViewById(viewid);
        int w = FitControl.INSTANCE.getSize(designWidth,FitType.HeightFit);
        int h = FitControl.INSTANCE.getSize(designHeight,FitType.HeightFit);
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof LinearLayout.LayoutParams){
            p.width = w;
            p.height = h;
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805181234","view is not LinearLayout ("+view.getClass().getName()+")");
        }
        GlideApp.with(view).load(img).override(w,h).into(view);
        return view;
    }
    /**
     * TextView
     */
    public static void setTextViewDesignSize(TextView view, int fontsize, Typeface typeface, int designWidth,int designHeight){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof LinearLayout.LayoutParams) {
            if (designWidth > 0)
                p.width = FitControl.INSTANCE.getSize(designWidth);
            if (designHeight > 0)
                p.height = FitControl.INSTANCE.getSize(designHeight);
            view.setLayoutParams(p);
        } else {
            LogDebug.d("201805291509", "view is not LinearLayout (" + view.getClass().getName() + ")");
        }
        FitControl.INSTANCE.setFontSize(view,fontsize);
        view.setTypeface(typeface);
    }

    public static TextView setTextViewMarginDesignStartFormParentView(View root, int viewid,int fontsize, Typeface typeface, int designStart){
        TextView view = root.findViewById(viewid);
        setTextViewMarginDesignStart(view,fontsize,typeface,designStart);
        return view;
    }

    public static void setTextViewMarginDesignStart(TextView view, int fontsize, Typeface typeface, int designStart){
        if (designStart > 0) {
            ViewGroup.LayoutParams p = view.getLayoutParams();
            if (p instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) p).setMargins(FitControl.INSTANCE.getSize(designStart, FitType.HeightFit), 0, 0, 0);
                view.setLayoutParams(p);
            } else {
                LogDebug.d("201805181154", "view is not LinearLayout (" + view.getClass().getName() + ")");
            }
        }
        FitControl.INSTANCE.setFontSize(view,fontsize);
        view.setTypeface(typeface);
    }

    public static TextView setTextViewDesignMarginFormParentView(View root, int viewid, int fontsize, Typeface typeface
            , int designStart, int designTop, int designEnd , int designBottom){
        TextView view = root.findViewById(viewid);
        setTextViewDesignMargin(view, fontsize, typeface, designStart, designTop, designEnd, designBottom);
        return view;
    }

    public static void setTextViewDesignMargin(TextView view, int fontsize, Typeface typeface
            , int designStart, int designTop, int designEnd , int designBottom){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof LinearLayout.LayoutParams){
            ((LinearLayout.LayoutParams) p).setMargins(
                    FitControl.INSTANCE.getSize(designStart,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designTop,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designEnd,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designBottom,FitType.HeightFit));
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805181155","view is not LinearLayout ("+view.getClass().getName()+")");
        }
        FitControl.INSTANCE.setFontSize(view,fontsize);
        if (typeface != null)
            view.setTypeface(typeface);
    }

}
