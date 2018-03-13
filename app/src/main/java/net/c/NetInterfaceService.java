package net.c;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * https://www.nowapi.com/api/life.time  北京时间API
 * <p>
 * Created by java on 2017/9/11.
 */

public interface NetInterfaceService {

    //app2.0网络请求 架构
    @FormUrlEncoded
    @POST("rest/api/service")
    Observable<String> networdrequestType1(@FieldMap Map<String, String> map);


    //https://www.nowapi.com/的网络API operatium@163.com
    //北京时间
    //demo: http://api.k780.com/?app=life.time&appkey=APPKEY&sign=SIGN&format=json
    @GET("/")
    Observable<String> getBeijingTime(@Query("app") String app
            , @Query("appkey") String appkey
            , @Query("sign") String sign
            , @Query("format") String format);


    /**上传*/
    @Multipart
    @POST("rest/upload/avatarHome")
    Observable<String> UpFile(@Part MultipartBody.Part file);

}

