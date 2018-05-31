package other.net;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by java on 2017/9/11.
 */

public interface NetInterfaceService {

    /**
     * 特殊接口
     */
    //获取美图
    //https://www.apiopen.top/meituApi?page=20
    @GET("meituApi")
    Observable<String> getImage(@Query("page") int page);

}
