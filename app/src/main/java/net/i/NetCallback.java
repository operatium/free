package net.i;

/**
 * Created by java on 2017/10/24.
 */

public interface NetCallback<T> {
    void success(T messageEvent);
    void fail(T messageEvent);
    void error(String str);
    void onCache(T messageEvent);
}
