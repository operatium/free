package other.net;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by opera on 2018/5/24.
 */

public interface RunHttpNetCacheCallback<T> {
    //此次网络请求的数据是否需要写入缓存
    boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(T t);

    //网络请求前，发现有缓存,直接提供使用时的回调
    void onCache(T t);

    //网络请求
    void httpTask(Function<String, T> mapfunc, NetObserver<T> netObserver);

    //网络回调
    void onCompleted();

    void onError(Throwable e);

    void onNext(T t);

    void onSubscribe(Disposable disposable);
}