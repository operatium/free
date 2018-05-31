package other.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observable;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 网络请求类
 * Created by java on 2017/9/11.
 */

public class HttpTask {

    // 获取retrofit实例 过滤code
    private static Retrofit getRetrofit(String IP) {
        return new Retrofit.Builder()
                .baseUrl(IP)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 特殊接口
     */
    //获取美图
    public static Observable<String> getImage(int page) {
        Retrofit retrofit = getRetrofit("https://www.apiopen.top/");
        NetInterfaceService requset = retrofit.create(NetInterfaceService.class);
        return requset.getImage(page);
    }
}
