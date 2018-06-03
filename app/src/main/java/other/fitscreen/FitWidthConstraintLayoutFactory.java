package other.fitscreen;

import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import other.base.GlideApp;
import other.base.LogDebug;

/**
 * Created by opera on 2018/6/1.
 */

public class FitWidthConstraintLayoutFactory {

    public static void setDesignSize(View view, int designWidth, int designHeight) {
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof ConstraintLayout.LayoutParams) {
            if (designWidth > 0)
                p.width = FitControl.INSTANCE.getSize(designWidth);
            if (designHeight > 0)
                p.height = FitControl.INSTANCE.getSize(designHeight);
            view.setLayoutParams(p);
        } else {
            LogDebug.d("201806011710", "view is not ConstraintLayout (" + view.getClass().getName() + ")");
        }
    }

    public static void setTextView_DesignSize_FontSize(View root, int id, int fontSize, Typeface typeface
            , int designWidth, int designHeight, int pading, int designleft, int designtop, int designright, int designbottom) {
        TextView view = root.findViewById(id);
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof ConstraintLayout.LayoutParams) {
            if (designWidth > 0)
                p.width = FitControl.INSTANCE.getSize(designWidth);
            if (designHeight > 0)
                p.height = FitControl.INSTANCE.getSize(designHeight);
            ((ConstraintLayout.LayoutParams) p).setMargins(FitControl.INSTANCE.getSize(designleft),
                    FitControl.INSTANCE.getSize(designtop),
                    FitControl.INSTANCE.getSize(designright),
                    FitControl.INSTANCE.getSize(designbottom));
            view.setLayoutParams(p);
        } else {
            LogDebug.d("201806021104", "view is not ConstraintLayout (" + view.getClass().getName() + ")");
        }
        view.setPadding(FitControl.INSTANCE.getSize(pading), FitControl.INSTANCE.getSize(pading)
                , FitControl.INSTANCE.getSize(pading), FitControl.INSTANCE.getSize(pading));
        FitControl.INSTANCE.setFontSize(view, fontSize);
        view.setTypeface(typeface);
    }

    public static void setImageView_DesignSize(ImageView view, int res, String url
            , int designWidth, int designHeight, int pading, int designleft, int designtop, int designright, int designbottom) {
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof ConstraintLayout.LayoutParams) {
            if (designWidth > 0)
                p.width = FitControl.INSTANCE.getSize(designWidth);
            if (designHeight > 0)
                p.height = FitControl.INSTANCE.getSize(designHeight);
            ((ConstraintLayout.LayoutParams) p).setMargins(FitControl.INSTANCE.getSize(designleft),
                    FitControl.INSTANCE.getSize(designtop),
                    FitControl.INSTANCE.getSize(designright),
                    FitControl.INSTANCE.getSize(designbottom));
            view.setLayoutParams(p);
        } else {
            LogDebug.d("201806022205", "view is not ConstraintLayout (" + view.getClass().getName() + ")");
        }
        view.setPadding(FitControl.INSTANCE.getSize(pading), FitControl.INSTANCE.getSize(pading)
                , FitControl.INSTANCE.getSize(pading), FitControl.INSTANCE.getSize(pading));
        if (TextUtils.isEmpty(url))
            GlideApp.with(view).load(res).override(FitControl.INSTANCE.getSize(designWidth),FitControl.INSTANCE.getSize(designHeight)).into(view);
        else
            GlideApp.with(view).load(url).placeholder(res).into(view);
    }

    public static void setImageView_DesignSize(View root, int id, int res, String url
            , int designWidth, int designHeight, int pading, int designleft, int designtop, int designright, int designbottom) {
        ImageView view = root.findViewById(id);
        ViewGroup.LayoutParams p = view.getLayoutParams();
        if (p instanceof ConstraintLayout.LayoutParams) {
            if (designWidth > 0)
                p.width = FitControl.INSTANCE.getSize(designWidth);
            if (designHeight > 0)
                p.height = FitControl.INSTANCE.getSize(designHeight);
            ((ConstraintLayout.LayoutParams) p).setMargins(FitControl.INSTANCE.getSize(designleft),
                    FitControl.INSTANCE.getSize(designtop),
                    FitControl.INSTANCE.getSize(designright),
                    FitControl.INSTANCE.getSize(designbottom));
            view.setLayoutParams(p);
        } else {
            LogDebug.d("201806021114", "view is not ConstraintLayout (" + view.getClass().getName() + ")");
        }
        view.setPadding(FitControl.INSTANCE.getSize(pading), FitControl.INSTANCE.getSize(pading)
                , FitControl.INSTANCE.getSize(pading), FitControl.INSTANCE.getSize(pading));
        if (TextUtils.isEmpty(url))
            GlideApp.with(root).load(res).override(FitControl.INSTANCE.getSize(designWidth),FitControl.INSTANCE.getSize(designHeight)).into(view);
        else
            GlideApp.with(root).load(url).placeholder(res).into(view);
    }
}
