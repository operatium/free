package util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by java on 2018/3/13.
 */

public class NetUtils {
    //判断本地网络是否正常连接互联网
    public static boolean LocalNetIsOk(Context context){
        boolean flag = false;
        //得到网络连接信息
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager != null && manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return flag;
    }
}
