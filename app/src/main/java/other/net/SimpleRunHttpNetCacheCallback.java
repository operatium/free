package other.net;

import android.support.annotation.NonNull;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2017/11/25.
 */

public class SimpleRunHttpNetCacheCallback<T> implements RunHttpNetCacheCallback<T> {

    @Override
    public void onCache(T t) {

    }

    @Override
    public void httpTask(Function<String, T> mapfunc, @NonNull NetObserver<T> netObserver) {

    }

    @Override
    public void onCompleted( ) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onSubscribe(Disposable disposable) {

    }

    @Override
    public boolean does_the_data_for_this_network_request_need_to_be_written_to_the_cache(T t) {
        return false;
    }
}
