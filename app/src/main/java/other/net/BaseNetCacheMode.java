package other.net;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import other.base.LogDebug;
import other.utils.FileUtils;

/**
 * Created by Administrator on 2017/11/25.
 */

public class BaseNetCacheMode<T> {
    /**
     * 只走网络请求
     */
    public static final int Mode_OnlyHttp = 1;

    /**
     * 先查询缓存，
     * Mode_SynchronousCache 有缓存则直接加载缓存，同时进行网络请求
     * Mode_AsynchronousCache 等待网络请求完成后，加载网络请求数据
     */
    public static final int Mode_SynchronousCache = 2;
    public static final int Mode_AsynchronousCache = 3;

    /**
     * 只使用缓存
     */
    public static final int Mode_CacheWithoutHttp = 4;

    public void runhttp(final Context context, final String dir, final String key, final Class<T> tClass
            , NetMode cachemode, final RunHttpNetCacheCallback<T> callback, final Interceptor<T> interceptor) {
        try {
            final long starttime = System.currentTimeMillis();
            LogDebug.d("shownet", key + " runhttp start =" + starttime);
            if (cachemode == null) {
                cachemode = new NetMode() {
                    @Override
                    public boolean onlySendNetWorkRequest() {
                        return true;
                    }

                    @Override
                    public boolean before_the_network_request__find_that_there_is_a_cache__do_you_need_to_provide_it_directly() {
                        return false;
                    }

                    @Override
                    public boolean in_the_case_of_a_cache__the_network_request_continues_to_be_sent() {
                        return false;
                    }

                    @Override
                    public boolean do_you_need_to_use_the_cache_to_provide_data_when_the_data_returned_by_the_network_request_cannot_be_used() {
                        return false;
                    }
                };
            }
            final NetMode mudo = cachemode;
            Function<String, T> mapfunc = new Function<String, T>() {

                @Override
                public T apply(String s) throws Exception {
                    final T t = JSON.parseObject(s, tClass);
                    try {
                        if (interceptor != null) {
                            if (interceptor.interceptor(s, t)) {
                                if (callback.does_the_data_for_this_network_request_need_to_be_written_to_the_cache(t))
                                    FileUtils.writeCache(context, dir, key, s);
                                return t;
                            }
                        } else {
                            if (callback.does_the_data_for_this_network_request_need_to_be_written_to_the_cache(t))
                                FileUtils.writeCache(context, dir, key, s);
                            return t;
                        }
                    } catch (Exception e) {
                        LogDebug.e("201712222043", e.toString(), e);
                    }
                    return null;
                }
            };
            NetObserver<T> netObserver = new NetObserver<T>() {
                @Override
                public void onSubscribe(Disposable d) {
                    if (callback != null)
                        callback.onSubscribe(d);
                }

                @Override
                public void onNext(T t) {
                    LogDebug.d("shownet", key + " runhttp time =" + (System.currentTimeMillis() -starttime));
                    if (callback != null)
                        callback.onNext(t);
                }

                @Override
                public void onError(Throwable e) {
                    LogDebug.d("shownet", key + " runhttp time =" + (System.currentTimeMillis() -starttime));
                    LogDebug.d("shownet", key + " runhttp error =" + e.toString());
                    if (callback != null) {
                        if (mudo.do_you_need_to_use_the_cache_to_provide_data_when_the_data_returned_by_the_network_request_cannot_be_used()) {
                            String cache = FileUtils.readCache(context, dir, key);
                            if (!TextUtils.isEmpty(cache)) {
                                T result = JSON.parseObject(cache, tClass);
                                if (result != null)
                                    callback.onCache(result);
                            }
                        }
                        callback.onError(e);
                    }
                }

                @Override
                public void onComplete() {
                    if (callback != null)
                        callback.onCompleted();
                }
            };
            if (mudo.onlySendNetWorkRequest()) {
                if (callback != null)
                    callback.httpTask(mapfunc, netObserver);
            } else {
                String cache = FileUtils.readCache(context, dir, key);
                if (cache.isEmpty()) {
                    if (callback != null)
                        callback.httpTask(mapfunc, netObserver);
                } else {
                    if (mudo.before_the_network_request__find_that_there_is_a_cache__do_you_need_to_provide_it_directly()) {
                        T result = JSON.parseObject(cache, tClass);
                        if (callback != null)
                            callback.onCache(result);
                    }
                    if (mudo.in_the_case_of_a_cache__the_network_request_continues_to_be_sent())
                        if (callback != null)
                            callback.httpTask(mapfunc, netObserver);
                }
            }
        } catch (Exception e) {
            LogDebug.e("201712222010", e.toString(), e);
            if (callback != null)
                callback.onError(e);
        }
    }

    public static NetMode getMode(int cacheMode) {
        NetMode mode = null;
        switch (cacheMode) {
            case Mode_OnlyHttp:
                mode = new OnlyHttpMode();
                break;
            case Mode_SynchronousCache:
                mode = new SynchronousCacheMode();
                break;
            case Mode_AsynchronousCache:
                mode = new AsynchronousCacheMode();
                break;
            case Mode_CacheWithoutHttp:
                mode = new CacheWithoutHttpMode();
                break;
        }
        return mode;
    }

    public interface NetMode {
        //只进行网络请求，不需要缓存
        boolean onlySendNetWorkRequest();

        //网络请求前，发现有缓存,需要直接提供使用吗
        boolean before_the_network_request__find_that_there_is_a_cache__do_you_need_to_provide_it_directly();

        //在有缓存的情况下,网络请求是否继续发送
        boolean in_the_case_of_a_cache__the_network_request_continues_to_be_sent();

        //此次网络请求返回的数据无法使用时，是否使用缓存提供数据
        boolean do_you_need_to_use_the_cache_to_provide_data_when_the_data_returned_by_the_network_request_cannot_be_used();

    }

}