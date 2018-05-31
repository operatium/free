package other.net;


/**
 * （缓存异步）网络请求返回结果，如果接收到网络请求不使用缓存，网络异常则使用缓存返回结果
 * Created by Administrator on 2017/11/25.
 */

public class AsynchronousCacheMode implements BaseNetCacheMode.NetMode {

    //只进行网络请求，不需要缓存
    @Override
    public boolean onlySendNetWorkRequest() {
        return false;
    }

    //网络请求前，发现有缓存,需要直接提供使用吗
    @Override
    public boolean before_the_network_request__find_that_there_is_a_cache__do_you_need_to_provide_it_directly() {
        return false;
    }

    //在有缓存的情况下,网络请求是否继续发送
    @Override
    public boolean in_the_case_of_a_cache__the_network_request_continues_to_be_sent() {
        return true;
    }

    //此次网络请求返回的数据无法使用时，是否使用缓存提供数据
    @Override
    public boolean do_you_need_to_use_the_cache_to_provide_data_when_the_data_returned_by_the_network_request_cannot_be_used() {
        return true;
    }
}
