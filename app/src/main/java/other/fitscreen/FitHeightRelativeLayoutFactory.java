package other.fitscreen;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import other.base.GlideApp;
import other.base.LogDebug;

/**
 * 高度适配刚工厂类
 * Created by opera on 2018/5/17.
 */

public class FitHeightRelativeLayoutFactory {

    public static void setDesignSizeFromParentView(View root,int viewid, int designWidth, int designHeight){
        View view = root.findViewById(viewid);
        setDesignSize(view,designWidth,designHeight);
    }

    public static void setDesignSize(View view, int designWidth, int designHeight){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof RelativeLayout.LayoutParams){
            if (designWidth > 0)
                p.width = FitControl.INSTANCE.getSize(designWidth,FitType.HeightFit);
            if (designHeight > 0)
                p.height = FitControl.INSTANCE.getSize(designHeight,FitType.HeightFit);
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805171451","view is not RelativeLayout ("+view.getClass().getName()+")");
        }
    }


    public static void setMarginDesignEnd(View view, int designEnd){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof RelativeLayout.LayoutParams){
            ((RelativeLayout.LayoutParams) p).setMargins(0,0,FitControl.INSTANCE.getSize(designEnd,FitType.HeightFit),0);
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805171453","view is not RelativeLayout ("+view.getClass().getName()+")");
        }
    }

    public static void setMarginDesignTopDesignBottom(View view, int designTop, int designBottom){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof RelativeLayout.LayoutParams){
            ((RelativeLayout.LayoutParams) p).setMargins(0,FitControl.INSTANCE.getSize(designTop,FitType.HeightFit)
                    ,0,FitControl.INSTANCE.getSize(designBottom,FitType.HeightFit));
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805171453","view is not RelativeLayout ("+view.getClass().getName()+")");
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
        if (p instanceof RelativeLayout.LayoutParams){
            p.width = w;
            p.height = h;
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805171452","view is not RelativeLayout ("+view.getClass().getName()+")");
        }
        if (img > 0)
            GlideApp.with(view).load(img).override(w,h).into(view);
    }

    public static ImageView setImageViewDesignSizeFromParentView(View root, int viewid, int designWidth, int designHeight, int img
    ,int designStart, int designTop, int designEnd, int designBottom){
        ImageView view = root.findViewById(viewid);
        int w = FitControl.INSTANCE.getSize(designWidth,FitType.HeightFit);
        int h = FitControl.INSTANCE.getSize(designHeight,FitType.HeightFit);
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof RelativeLayout.LayoutParams){
            p.width = w;
            p.height = h;
            ((RelativeLayout.LayoutParams) p).setMargins(
                    FitControl.INSTANCE.getSize(designStart,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designTop,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designEnd,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designBottom,FitType.HeightFit));
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805171452","view is not RelativeLayout ("+view.getClass().getName()+")");
        }
        if (img > 0)
            GlideApp.with(view).load(img).override(w,h).into(view);
        return view;
    }

    public static ImageView setImageViewDesignSizeFromParentView(View root, int viewid, int designWidth, int designHeight,int placeholder, String imgurl
            ,int designStart, int designTop, int designEnd, int designBottom){
        ImageView view = root.findViewById(viewid);
        int w = FitControl.INSTANCE.getSize(designWidth,FitType.HeightFit);
        int h = FitControl.INSTANCE.getSize(designHeight,FitType.HeightFit);
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof RelativeLayout.LayoutParams){
            p.width = w;
            p.height = h;
            ((RelativeLayout.LayoutParams) p).setMargins(
                    FitControl.INSTANCE.getSize(designStart,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designTop,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designEnd,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designBottom,FitType.HeightFit));
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805251426","view is not RelativeLayout ("+view.getClass().getName()+")");
        }
        if (!TextUtils.isEmpty(imgurl))
            GlideApp.with(view).load(imgurl).placeholder(placeholder).override(w,h).into(view);
        return view;
    }

    public static ImageView setImageViewDesignSizeTranlationXYFromParentView(View root, int viewid
            , int designWidth, int designHeight
            , String imgurl, int defRes
            ,int designY, int designX){
        ImageView view = root.findViewById(viewid);
        int w = FitControl.INSTANCE.getSize(designWidth,FitType.HeightFit);
        int h = FitControl.INSTANCE.getSize(designHeight,FitType.HeightFit);
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof RelativeLayout.LayoutParams){
            p.width = w;
            p.height = h;
            view.setLayoutParams(p);
            view.setTranslationY(FitControl.INSTANCE.getSize(designY));
            view.setTranslationX(FitControl.INSTANCE.getSize(designX));
        }else {
            LogDebug.d("201805251753","view is not RelativeLayout ("+view.getClass().getName()+")");
        }
        if (!TextUtils.isEmpty(imgurl))
            GlideApp.with(view).load(imgurl).placeholder(defRes).override(w,h).into(view);
        return view;
    }

    /**
     * TextView
     * @param fontsize
     * @param typeface
     * @param designStart
     */
    public static TextView setTextViewMarginDesignStartFromParentView(View root, int tvid, int fontsize, Typeface typeface, int designStart){
        TextView view = root.findViewById(tvid);
        setTextViewMarginDesignStart(view,fontsize,typeface,designStart);
        return view;
    }

    public static void setTextViewMarginDesignStart(TextView view, int fontsize, Typeface typeface, int designStart){
        setTextViewDesignMargin(view,fontsize,typeface,designStart,0,0,0);
    }

    public static void setTextViewDesignMargin(TextView view, int fontsize, Typeface typeface
            , int designStart, int designTop, int designEnd , int designBottom){
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof RelativeLayout.LayoutParams){
            ((RelativeLayout.LayoutParams) p).setMargins(
                    FitControl.INSTANCE.getSize(designStart,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designTop,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designEnd,FitType.HeightFit)
                    ,FitControl.INSTANCE.getSize(designBottom,FitType.HeightFit));
            view.setLayoutParams(p);
        }else {
            LogDebug.d("201805171454","view is not RelativeLayout ("+view.getClass().getName()+")");
        }
        FitControl.INSTANCE.setFontSize(view,fontsize);
        if (typeface != null)
            view.setTypeface(typeface);
    }

}
