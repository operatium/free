package control


import com.liulishuo.filedownloader.BaseDownloadTask
import com.liulishuo.filedownloader.FileDownloadListener
import com.liulishuo.filedownloader.exception.*

import org.greenrobot.eventbus.EventBus

import java.io.File

import debug.LogDebug
import net.m.FileDownloadShowData
import net.m.FileDownloadShowHelp
import net.m.MessageEvent
import net.m.NetBean_AddBookToStudy
import net.c.BaseNetCacheMode
import net.c.FileDownloadControl
import net.c.NetControl
import net.i.SimpleCacheAndSuccesSameNetCallback
import util.FileUtils
import util.ZIPUtils

/**
 * 写一个下载书籍的管理器的c 静态的方法
 * 下载书籍调用这个对外的封装类
 * 下载回调进度 需要通过轮询
 * Created by java on 2018/2/8.
 */

object BookDownloadControl {
    const val _start: Int = 7
    const val _pending: Int = 1
    const val _progress: Int = 2
    const val _completed: Int = 3
    const val _paused: Int = 4
    const val _error: Int = 5
    const val _warn: Int = 6
    const val _nothavebook: Int = 8
    const val _readbook: Int = 9

    const val _downloading: Int = 10
    const val _null: Int = 12

    const val _wifiNoparameter: Int = 13
    const val _wifiTrue: Int = 14
    const val _wifiFalse: Int = 15

    /**
     * 针对下载业务 接口访问成功才能下载 接口空挡需要UI状态支持 书写函数downloadBook2
     */
    public fun updataDownload(bookcode: String, bookname: String, url: String, wifi: Int
                              , zippath: String, unzippath: String, uid: String, bookType: String?, isTeacher: Boolean) {
        var downloadData = FileDownloadShowHelp.getInstance().getData(bookcode)
        if (downloadData == null) {
            downloadData = FileDownloadShowData().setBookcode(bookcode)
                    .setName(bookname)
                    .setUnzippath(unzippath)
                    .setDownloadData(FileDownloadControl.DownloadTaskData(bookcode, url, zippath
                            , FileDownloadControl.getInstance().isJinwifi, setDownloadListener()))
                    .setUIStatus(FileDownloadShowData._Start)
                    .setPauseprogress(0)
            FileDownloadShowHelp.getInstance().addData(downloadData)
        }
        when (wifi) {
            _wifiTrue -> downloadData.downloadData.isWifi = true
            _wifiFalse -> downloadData.downloadData.isWifi = false
        }
        EventBus.getDefault().post(MessageEvent().setType(MessageEvent.BookDownloadProgress).setObject2(bookcode))

        var usertype = "PARENT"
        if (isTeacher)
            usertype = "TEACHER"
        var bokty = "BOOK_NORMAL"
        if (bookType?.isNotEmpty()?:false) {
            bokty = bookType?:""
        }
        NetControl.addBookToStudy(BaseNetCacheMode.Mode_OnlyHttp, uid, usertype, bookcode, bokty
                , object : SimpleCacheAndSuccesSameNetCallback<NetBean_AddBookToStudy>() {
            override fun success(messageEvent: NetBean_AddBookToStudy?) {
                downloadBook2(false, downloadData)
                EventBus.getDefault().post(MessageEvent().setType(MessageEvent.BookDownloadProgress).setObject2(bookcode))
            }

            override fun fail(messageEvent: NetBean_AddBookToStudy?) {
                EventBus.getDefault().post(MessageEvent().setType(MessageEvent.TOAST).setObject1("《"+bookname+"》下载失败"))
                var downloadData = FileDownloadShowHelp.getInstance().getData(bookcode)
                downloadData?.uiStatus = FileDownloadShowData._Stop
                EventBus.getDefault().post(MessageEvent().setType(MessageEvent.BookDownloadProgress).setObject2(bookcode))
            }

            override fun error(str: String?) {
                EventBus.getDefault().post(MessageEvent().setType(MessageEvent.TOAST).setObject1("《"+bookname+"》下载失败"))
                var downloadData = FileDownloadShowHelp.getInstance().getData(bookcode)
                downloadData?.uiStatus = FileDownloadShowData._Stop
                EventBus.getDefault().post(MessageEvent().setType(MessageEvent.BookDownloadProgress).setObject2(bookcode))
            }
        });
    }

    //下载还是停止
    public fun downloadBook2(ispause: Boolean, showData: FileDownloadShowData?) {
        val bookcode = showData?.bookcode?:""
        val url = showData?.downloadData?.url?:""
        val zippath = showData?.downloadData?.path?:""
        val name = showData?.name?:""
        val unzippath = showData?.unzippath?:""
        //实时状态
        val result = FileDownloadControl.getInstance().getResult(url, zippath)
        when (result) {
            FileDownloadControl._NULL -> {
                if (!ispause)
                    FileDownloadControl.getInstance().start(showData?.downloadData)
            }
            FileDownloadControl._Downloading -> {
                if (ispause)
                    FileDownloadControl.getInstance().pause(bookcode)
            }
            FileDownloadControl._Paused -> {
                if (!ispause)
                    FileDownloadControl.getInstance().start(showData?.downloadData)
            }
            FileDownloadControl._Completed -> {//删除后马上点击会出现假完成
                if (!ispause) {
                    Thread{
                        FileDownloadControl.getInstance().removeTaskAndFile(bookcode)
                        File(zippath).delete()
                        FileDownloadControl.getInstance().start(showData?.downloadData)
                    }.start()
                }
            }
            FileDownloadControl._Warn -> {
                FileDownloadControl.getInstance().removeTaskAndFile(bookcode)
                if (ispause)
                    FileDownloadControl.getInstance().pause(bookcode)
            }
        }
        //界面状态
        if (result == FileDownloadControl._Completed) {
            showData?.uiStatus = FileDownloadShowData._Start
        }else{
            if (!ispause)
                showData?.uiStatus = FileDownloadShowData._Start
            else
                showData?.uiStatus = FileDownloadShowData._Paused
        }
    }

    //下载还是停止
    public fun downloadBook(ispause: Boolean, bookcode: String, bookname: String, url: String, wifi: Int, zippath: String, unzippath: String) {
        var downloadData = FileDownloadShowHelp.getInstance().getData(bookcode)
        if (downloadData == null) {
            downloadData = FileDownloadShowData().setBookcode(bookcode)
                    .setName(bookname)
                    .setUnzippath(unzippath)
                    .setDownloadData(FileDownloadControl.DownloadTaskData(bookcode, url, zippath
                            , FileDownloadControl.getInstance().isJinwifi, setDownloadListener()))
            FileDownloadShowHelp.getInstance().addData(downloadData)
        }
        when (wifi) {
            _wifiTrue -> downloadData.downloadData.isWifi = true
            _wifiFalse -> downloadData.downloadData.isWifi = false
        }
        //实时状态
        val result = FileDownloadControl.getInstance().getResult(url, zippath)
        when (result) {
            FileDownloadControl._NULL -> {
                if (!ispause)
                    FileDownloadControl.getInstance().start(downloadData.downloadData)
            }
            FileDownloadControl._Downloading -> {
                if (ispause)
                    FileDownloadControl.getInstance().pause(bookcode)
            }
            FileDownloadControl._Paused -> {
                if (!ispause)
                    FileDownloadControl.getInstance().start(downloadData.downloadData)
            }
            FileDownloadControl._Completed -> {//删除后马上点击会出现假完成
                if (!ispause) {
                    Thread{
                        FileDownloadControl.getInstance().removeTaskAndFile(bookcode)
                        File(zippath).delete()
                        FileDownloadControl.getInstance().start(downloadData.downloadData)
                    }.start()
                }
            }
            FileDownloadControl._Warn -> {
                FileDownloadControl.getInstance().removeTaskAndFile(bookcode)
                if (ispause)
                    FileDownloadControl.getInstance().pause(bookcode)
            }
        }
        //界面状态
        if (result == FileDownloadControl._Completed) {
            downloadData.uiStatus = FileDownloadShowData._Start
        }else{
            if (!ispause)
                downloadData.uiStatus = FileDownloadShowData._Start
            else
                downloadData.uiStatus = FileDownloadShowData._Paused
        }
    }

    //获取全部的状态(回调执行后显示的 延迟状态)
    fun getAllStatus(bookcode: String): Int {
        val book = FileDownloadShowHelp.getInstance().getData(bookcode)
        return book?.status ?: _nothavebook
    }

    //获取UI状态
    fun getUIStatus(bookcode: String): Int {
        val book = FileDownloadShowHelp.getInstance().getData(bookcode)
        return book?.uiStatus ?: FileDownloadShowData._Stop
    }

    //获取下载数据
    fun getDownloadShowData(bookcode: String): FileDownloadShowData? {
        val book = FileDownloadShowHelp.getInstance().getData(bookcode)
        return book
    }

    fun setDownloadListener(): FileDownloadListener {
        /**
         * Tag是bookcode
         */
        return object : FileDownloadListener() {
            override fun pending(task: BaseDownloadTask, soFarBytes: Int, totalBytes: Int) {
                val bookcode = task.tag.toString()
                var showdata = FileDownloadShowHelp.getInstance().getData(bookcode)
                if (showdata != null) {
                    showdata.setStatus(_pending)
                }
            }

            override fun progress(task: BaseDownloadTask, soFarBytes: Int, totalBytes: Int) {
                val p = soFarBytes * 1.0f / totalBytes * 100
                val bookcode = task.tag.toString()
                var showdata = FileDownloadShowHelp.getInstance().getData(bookcode)
                if (showdata != null) {
                    showdata.setStatus(_progress).setPauseprogress(p.toInt()).speed = task.speed
                    EventBus.getDefault().post(MessageEvent().setType(MessageEvent.BookDownloadProgress)
                            .setObject2(bookcode))
                }
            }

            override fun completed(task: BaseDownloadTask) {
                val bookcode = task.tag.toString()
                var showdata = FileDownloadShowHelp.getInstance().getData(bookcode)
                if (showdata != null) {
                    showdata.setStatus(_completed).pauseprogress = 100
                    EventBus.getDefault().post(MessageEvent().setType(MessageEvent.BookDownloadProgress)
                            .setObject2(bookcode))
                    Thread{
                        Thread.sleep(1000)
                        unZip(showdata.downloadData.path, showdata.unzippath)
                    }.start()
                }
                FileDownloadControl.getInstance().remove(bookcode)
            }

            override fun paused(task: BaseDownloadTask, soFarBytes: Int, totalBytes: Int) {
                val bookcode = task.tag.toString()
                var showdata = FileDownloadShowHelp.getInstance().getData(bookcode)
                if (showdata != null) {
                    showdata.status = _paused
                }
            }

            override fun error(task: BaseDownloadTask, e: Throwable) {
                val bookcode = task.tag.toString()
                var showdata = FileDownloadShowHelp.getInstance().getData(bookcode)
                if (showdata != null) {
                    showdata.setUIStatus(FileDownloadShowData._Stop)
                            .setStatus(_error)

                    if(e is FileDownloadOutOfSpaceException){
                        showdata.setIserror(true).error = "磁盘空间不足"
                    }else if(e is FileDownloadNetworkPolicyException){
                        showdata.setIserror(true).error = "wifi断开"
                    }else if (e is PathConflictException){
                        showdata.setIserror(true).error = "下载重复"
                    }else if (e is FileDownloadHttpException){
                        /*
                        在发出请求以后，response-code不是200(HTTP_OK)，也不是206(HTTP_PARTIAL)的情况下会抛出该异常;
                        在这个异常对象会带上 response-code、response-header、request-header。
                         */
                        showdata.setIserror(true).error = "下载失败"
                    }else if (e is FileDownloadGiveUpRetryException){
                        /*
在请求返回的 response-header 中没有带有文件大小(content-length)，并且不是流媒体(transfer-encoding)的情况下会抛出该异常；
出现这个异常，将会忽略所有重试的机会(BaseDownloadTask#setAutoRetryTimes).
你可以通过在 filedownloader.properties中添加 http.lenient=true 来忽略这个异常，并且在该情况下，直接作为流媒体进行下载。
                         */
                        showdata.setIserror(true).error = "下载异常"
                    }
                    else{
                        showdata.setIserror(true).error = "下载错误"
                    }
                    AppControl.getInstance().cachedThreadPool.execute{
                        FileUtils.deleteFile(File(showdata.downloadData.path))
                        FileUtils.deleteFile(File(showdata.unzippath))
                    }
                }
                LogDebug.e("201802061659", e.toString())
                FileDownloadControl.getInstance().remove(bookcode)
                EventBus.getDefault().post(MessageEvent().setType(MessageEvent.BookDownloadProgress)
                        .setObject2(bookcode))
                LogDebug.e("show", "error" + e.toString())
            }

            override fun warn(task: BaseDownloadTask) {
                val bookcode = task.tag.toString()
                var showdata = FileDownloadShowHelp.getInstance().getData(bookcode)
                if (showdata != null) {
                    showdata.setStatus(_warn)
                }
                LogDebug.e("show", "warn")
            }
        }
    }

    //解压
    fun unZip(zippath: String, unzip: String) {
        try {
            ZIPUtils.upZipFile(File(zippath), unzip) { progress ->
                EventBus.getDefault().post(MessageEvent().setType(MessageEvent.BookUnZipProgress)
                        .setObject1(zippath).setWhat1(progress))
            }

        } catch (e: Exception) {
            LogDebug.e("201801031619", e.toString())
            EventBus.getDefault().post(MessageEvent().setType(MessageEvent.BookUnZipProgress)
                    .setObject1(zippath).setWhat1(-1).setObject2("解压失败"))

            object : Thread() {
                override fun run() {
                    FileUtils.deleteFile(File(unzip))
                    FileUtils.deleteFile(File(zippath))
                }
            }.start()
        }
    }

    //删除书籍
    fun deleteBook(path : String,bookcode: String){
        FileDownloadShowHelp.getInstance().removeData(bookcode)
        FileControl.deleteFiles(File(path))
        FileDownloadControl.getInstance().removeTaskAndFile(bookcode);
    }

    public interface DownloadCallbck{
        fun httpsuccess(ispause: Boolean, bookcode: String, bookname: String, url: String, wifi: Int, zippath: String, unzippath: String)
        fun httpfail(ispause: Boolean, bookcode: String, bookname: String, url: String, wifi: Int, zippath: String, unzippath: String)
    }
}
