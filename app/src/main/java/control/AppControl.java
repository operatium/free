package control;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



/**
 * 整个APP的基础逻辑
 * Created by java on 2017/10/24.
 */

public class AppControl {

    private static HashMap<String, Activity> mActivityMap = new HashMap<>();

    private static class AppControlHolder {
        private static final AppControl INSTANCE = new AppControl();
    }

    public static final AppControl getInstance() {
        return AppControlHolder.INSTANCE;
    }

    private Context context;
    private ExecutorService executorService;//线程池

    /**
     *方法
     */
    public void init(Context c){
        this.context =c;
    }

    //线程池
    public ExecutorService getCachedThreadPool(){
        if (executorService == null)
            executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE
                    , 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        return executorService;
    }

    /**
     * get + set
     */
    public Context getContext() {
        return context;
    }
}
