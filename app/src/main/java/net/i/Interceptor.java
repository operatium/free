package net.i;

/**
 * 过滤器
 * 返回true 则正常返回
 * 返回false 过滤掉返回 null
 * Created by Administrator on 2017/11/25.
 */

public interface Interceptor<T> {
    boolean interceptor(String s, T t);
}
