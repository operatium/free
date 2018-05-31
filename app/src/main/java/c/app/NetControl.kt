package c.app

import com.trello.rxlifecycle2.LifecycleTransformer
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import m.netbean.*
import other.base.AppInfo
import other.base.LogDebug
import other.net.*

/***
 * 网络请求使用rxjava 解绑3步骤
 * 1.Action onComplete 当前网络请求回调执行完毕的时候， disposable.dispose()
 * 2.BaseActivity.currentLife 或者当前Activity的Model置空 当Activity onPause或者onStop的时候，if(myModel == null) return
 * 3.BaseActivity extends RxActivity 当Activity onPause的时候，observer.compose(observableTransformer)
 */

object NetControl {

    /**
     * 特殊接口
     */
    //*获取美图
    fun getImage(page : Int, callback: NetCallback<NetBean_GetImage>?, observableTransformer: LifecycleTransformer<Any>?) {
        val context = AppInfo.getContext()
        val key = "getImage"
        val dir = FileControl.getDir_Public_Temp()
        BaseNetCacheMode<NetBean_GetImage>().runhttp(context, dir, key, NetBean_GetImage::class.java
                , BaseNetCacheMode.getMode(BaseNetCacheMode.Mode_OnlyHttp), object : SimpleRunHttpNetCacheCallback<NetBean_GetImage>() {
            override fun onCache(t: NetBean_GetImage?) {
                if (t == null)
                    return
                callback?.onCache(t)
            }

            override fun httpTask(mapfunc: Function<String, NetBean_GetImage>?, netObserver: NetObserver<NetBean_GetImage>) {
                val observable = HttpTask.getImage(page)
                if (observableTransformer != null)
                    observable.compose(observableTransformer)
                observable.subscribeOn(Schedulers.io()).map(mapfunc).observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<NetBean_GetImage> {
                    var disposable: Disposable? = null
                    override fun onComplete() {
                        netObserver.onComplete()
                        LogDebug.d("shownet","$key  disposable.dispose() $disposable")
                        disposable?.dispose()
                        disposable = null
                    }

                    override fun onSubscribe(d: Disposable) {
                        netObserver.onSubscribe(d)
                        disposable = d
                    }

                    override fun onNext(t: NetBean_GetImage) {
                        netObserver.onNext(t)
                    }

                    override fun onError(e: Throwable) {
                        netObserver.onError(e)
                        LogDebug.d("shownet","$key  disposable.dispose() $disposable")
                        disposable?.dispose()
                        disposable = null
                    }

                })
            }

            override fun onError(e: Throwable) {
                callback?.error(e.toString())
            }

            override fun onNext(data: NetBean_GetImage?) {
                if (data == null)
                    return
                if (data.code == 200) {
                    callback?.success(data)
                } else {
                    callback?.fail(data)
                }
            }

            override fun does_the_data_for_this_network_request_need_to_be_written_to_the_cache(data: NetBean_GetImage): Boolean {
                return false
            }
        }, object : Interceptor<NetBean_GetImage> {
            override fun interceptor(s: String?, t: NetBean_GetImage?): Boolean {
                LogDebug.d("shownet", s)
                return true
            }
        })
    }
}
