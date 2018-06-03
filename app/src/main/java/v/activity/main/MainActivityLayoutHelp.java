package v.activity.main;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.yyx.R;

import other.fitscreen.FitControl;
import other.fitscreen.FitFactory;
import other.fitscreen.FitWidthConstraintLayoutFactory;

/**
 * Created by opera on 2018/6/1.
 */

public class MainActivityLayoutHelp {

    //控件尺寸
    public void reSize(TextView title1, RecyclerView buttonlist1, ImageView mainbutton1){
        //标题
        FitFactory.setTextView(title1,50,null);

        //功能列表
        FitWidthConstraintLayoutFactory.setDesignSize(buttonlist1,720,690);

        //指纹
        FitWidthConstraintLayoutFactory.setImageView_DesignSize(mainbutton1, R.drawable.ic_fingerprint_white_48dp,null
                ,100,100,0,0,0,0,20);
    }

    public void setMainButtonBackground(ImageView mainbutton1){
        GradientDrawable gradientDrawable1 = new GradientDrawable();
        // 形状-圆角矩形
        gradientDrawable1.setShape(GradientDrawable.RECTANGLE);
        // 圆角
        gradientDrawable1.setCornerRadius(FitControl.INSTANCE.getSize(100));
        gradientDrawable1.setColor(Color.RED);
        mainbutton1.setBackground(gradientDrawable1);
    }


}
