package c.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.yyx.R;

import java.util.ArrayList;

import m.main.FunctionItemData;
import v.activity.main.FunctionsItemViewHolder;

/**
 * 主页的功能菜单列表
 * Created by Administrator on 2018/6/2.
 */

public class FunctionListAdapter extends RecyclerView.Adapter<FunctionsItemViewHolder> {
    private ArrayList<FunctionItemData> datas = new ArrayList<>();


    @NonNull
    @Override
    public FunctionsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.main_activity_pictruebutton,null);
        return new FunctionsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FunctionsItemViewHolder holder, int position) {
        holder.bind(datas.get(position));
    }



    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void reLoad(ArrayList<FunctionItemData> data){
        if (data != null)
            datas = data;
    }
}
