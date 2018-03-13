package net.i;

import net.c.BaseNetCacheMode;

import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Administrator on 2017/11/25.
 */

public class SimpleNetCacheCallback<T> implements BaseNetCacheMode.NetCacheCallback<T> {

    @Override
    public void onCache(T t) {

    }

    @Override
    public void httpTask(Func1<String, T> mapfunc, Subscriber<T> callback) {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(T t) {
        return false;
    }
}
