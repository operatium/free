package m.main;

import android.graphics.Color;

import com.yyx.R;

import java.util.ArrayList;

import other.fitscreen.FitControl;

/**
 * Created by Administrator on 2018/6/1.
 */

public class MainActivityModel {

    public ArrayList<FunctionItemData> getFunctionList() {
        String[] urls = new String[]{null, null, null, null, null, null};
        int[] ress = new int[]{R.drawable.ic_3d_rotation_white_48dp
                , R.drawable.ic_account_circle_white_48dp
                , R.drawable.ic_camera_enhance_white_48dp
                , R.drawable.ic_face_white_48dp
                , R.drawable.ic_view_quilt_white_48dp
                , R.drawable.ic_group_work_white_48dp};
        int[] colors = new int[]{Color.rgb(64, 133, 250)
                , Color.rgb(255, 116, 175)
                , Color.rgb(136, 111, 254)
                , Color.rgb(112, 223, 230)
                , Color.rgb(112, 223, 110)
                , Color.rgb(230, 100, 127)};
        String[] titles = new String[]{"查看图片", "opencv人脸识别", "虹软人脸识别", "股市行情","时光机","健康之路"};

        ArrayList<FunctionItemData> list = new ArrayList<>();
        for (int i = 0; i < titles.length; ++i) {
            FunctionItemData itemData = new FunctionItemData(urls[i], ress[i], colors[i], titles[i]);
            list.add(itemData);
        }
        return list;
    }

    public String getUrl() {
        return "https://source.unsplash.com/random/" + FitControl.INSTANCE.getFullWidth() + "x" + FitControl.INSTANCE.getFullHeight();
    }
}
