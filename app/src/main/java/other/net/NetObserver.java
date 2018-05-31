package other.net;

import io.reactivex.disposables.Disposable;

/**
 * Created by opera on 2018/5/24.
 */

public interface NetObserver<T> {
    void onSubscribe(Disposable d);

    void onNext(T t);

    void onError(Throwable e);

    void onComplete();
}
