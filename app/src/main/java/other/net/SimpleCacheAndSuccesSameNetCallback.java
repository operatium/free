package other.net;

/**
 * 网络回调的实现类 success函数和onCache函数一样,并且不处理异常和错误
 * Created by java on 2017/11/14.
 */

public class SimpleCacheAndSuccesSameNetCallback<T> extends SimpleNetCallback<T> {
    @Override
    public void success(T messageEvent) {

    }

    @Override
    public void fail(T messageEvent) {
    }

    @Override
    public void error(String str) {
    }

    @Override
    public void onCache(T messageEvent) {
        success(messageEvent);
    }
}
