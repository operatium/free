package v.activity.main;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yyx.R;

import c.app.RouteControl;
import m.main.FunctionItemData;
import other.base.GlideApp;
import other.fitscreen.FitControl;
import other.fitscreen.FitWidthConstraintLayoutFactory;
import v.activity.jiankangzhilu.SeeVideoActivity;
import v.activity.opencv.FaceDetectionOpenCVActivity;

/**
 * Created by Administrator on 2018/6/2.
 */

public class FunctionsItemViewHolder extends RecyclerView.ViewHolder {

    public FunctionsItemViewHolder(View itemView) {
        super(itemView);
        itemView.setPadding(FitControl.INSTANCE.getSize(15)
                , 0
                , FitControl.INSTANCE.getSize(15)
                , FitControl.INSTANCE.getSize(10));
        FitWidthConstraintLayoutFactory.setTextView_DesignSize_FontSize(itemView, R.id.title2, 30, null
                , 0, 0, 0, 10, 0, 0, 10);
        FitWidthConstraintLayoutFactory.setImageView_DesignSize(itemView, R.id.icon2, R.drawable.public_bingqiling,
                null, 100, 100, 0, 0, 10, 10, 0);
    }

    public void bind(FunctionItemData data) {
        ImageView background = itemView.findViewById(R.id.background2);
        GradientDrawable gradientDrawable1 = new GradientDrawable();
        // 形状-圆角矩形
        gradientDrawable1.setShape(GradientDrawable.RECTANGLE);
        // 圆角
        gradientDrawable1.setCornerRadius(FitControl.INSTANCE.getSize(8));
        gradientDrawable1.setColor(data.getBackgroundColor());
        background.setBackground(gradientDrawable1);

        TextView textView = itemView.findViewById(R.id.title2);
        textView.setText(data.getText());

        ImageView icon = itemView.findViewById(R.id.icon2);
        String url = data.getImageUrl();
        if (TextUtils.isEmpty(url))
            GlideApp.with(icon).load(data.getRes()).into(icon);
        else
            GlideApp.with(icon).load(url).placeholder(data.getRes()).into(icon);
        final String name = data.getText();
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (name){
                    case "查看图片":
                        RouteControl.INSTANCE.ToSeePic(itemView.getContext());
                        break;
                    case "opencv人脸识别":
                        RouteControl.INSTANCE.ToOpencv(itemView.getContext());
                        break;
                    case "健康之路":
                        RouteControl.INSTANCE.ToJiankangzhilu(itemView.getContext());
                        break;
                    case "虹软人脸识别":
                        RouteControl.INSTANCE.ToHongRuan(itemView.getContext());
                        break;
                }
            }
        });
    }
}
