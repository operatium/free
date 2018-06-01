package v.main;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import other.fitscreen.FitFactory;
import other.fitscreen.FitWidthConstraintLayoutFactory;

/**
 * Created by opera on 2018/6/1.
 */

public class MainActivityLayoutHelp {

    //控件尺寸
    public void reSize(TextView title1, RecyclerView buttonlist1){
        //标题
        FitFactory.setTextView(title1,50,null);

        //功能列表
        FitWidthConstraintLayoutFactory.setDesignSize(buttonlist1,720,640);
    }


}
