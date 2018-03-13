package net.c;


/**
 * 优先使用缓存，没有缓存再进行网络请求
 * Created by Administrator on 2017/11/25.
 */

public class CacheWithoutHttpMode implements BaseNetCacheMode.NetMode {

    //只进行网络请求，不需要缓存
    @Override
    public boolean onlySendNetWorkRequest() {
        return false;
    }

    //网络请求前，发现有缓存,需要直接提供使用吗
    @Override
    public boolean before_the_network_request__find_that_there_is_a_cache__do_you_need_to_provide_it_directly() {
        return true;
    }

    //在有缓存的情况下,网络请求是否继续发送
    @Override
    public boolean in_the_case_of_a_cache__the_network_request_continues_to_be_sent() {
        return false;
    }

    //此次网络请求返回的数据无法使用时，是否使用缓存提供数据
    @Override
    public boolean do_you_need_to_use_the_cache_to_provide_data_when_the_data_returned_by_the_network_request_cannot_be_used() {
        return false;
    }
}
