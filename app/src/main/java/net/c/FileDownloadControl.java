package net.c;

import android.content.Context;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.model.FileDownloadStatus;
import com.liulishuo.filedownloader.util.FileDownloadUtils;


import java.util.HashMap;
import java.util.Map;

import control.AppControl;
import control.FileControl;
import debug.LogDebug;
import util.FileUtils;

/**
 * 下载文件的基础工具类
 * Created by java on 2017/9/15.
 */

public class FileDownloadControl {//0 = 未知  1 = 下载中 2 = 中断  3 = 完成  4 = 重复下载
    public static final int _NULL = 0;
    public static final int _Downloading = 1;
    public static final int _Paused =2 ;
    public static final int _Completed = 3;
    public static final int _Warn = 4;

    //单例模式
    private static class FileDownloadControlHolder {
        private static FileDownloadControl INSTANCE = new FileDownloadControl();
    }
    public static FileDownloadControl getInstance() {
        return FileDownloadControlHolder.INSTANCE;
    }
    private boolean jinwifi = true;
    private HashMap<String,DownloadTaskData> tasks = new HashMap<>();
    private boolean reStartLock;//重新连接的锁

    public void init(Context context) {
        String set = FileUtils.readCache(context, FileControl.getFullPath(context, FileControl.getDir_downloadSet()),FileControl.getKey_downloadSet());
        if (set.equals("false")){
            jinwifi = false;
        }else{
            jinwifi = true;
        }
        FileUtils.writeCache(context,FileControl.getFullPath(context, FileControl.getDir_downloadSet())
                ,FileControl.getKey_downloadSet(),Boolean.valueOf(jinwifi).toString());
        FileDownloader.setup(context);
        FileDownloader.enableAvoidDropFrame();//开启 避免掉帧处理。就是将抛消息到ui线程的间隔设为默认值10ms, 很明显会影响的是回调不会立马通知到监听器(FileDownloadListener)中，默认值是: 最多10ms处理5个回调到监听器中
        FileDownloader.setGlobalPost2UIInterval(100);//为了避免掉帧，这里是设置了最多每interval毫秒抛一个消息到ui线程(使用Handler)，防止由于回调的过于频繁导致ui线程被ddos导致掉帧。 默认值: 10ms. 如果设置小于0，将会失效，也就是说每个回调都直接抛一个消息到ui线程
        FileDownloader.setGlobalHandleSubPackageSize(6);//为了避免掉帧, 如果上面的方法设置的间隔是一个小于0的数，这个packageSize将不会生效。packageSize这个值是为了避免在ui线程中一次处理过多回调，结合上面的间隔，就是每个interval毫秒间隔抛一个消息到ui线程，而每个消息在ui线程中处理packageSize个回调。默认值: 5
//        FileDownloader.getImpl().startForeground(1,new Notification(R.drawable.owl, String.valueOf("咿啦看书"), System.currentTimeMillis()));
        FileDownloader.getImpl().setMaxNetworkThreadCount(2);//设置最大并行下载的数目(网络下载线程数), [1,12]
    }

    //核心下载
    private void download(DownloadTaskData data){
        if (data == null)
            return;
        BaseDownloadTask task = FileDownloader.getImpl().create(data.getUrl()).setPath(data.getPath())
                .setWifiRequired(data.isWifi()).setSyncCallback(false).setTag(data.getTag()).setListener(data.getListener());
        addtask(data);
        task.start();
    }

    // 管理下载任务
    // 增
    private void addtask(DownloadTaskData data){
        if (data == null)
            return;
        tasks.put(data.getTag(),data);
    }
    // 删记录
    public void remove(String tag){
        tasks.remove(tag);
    }

    // 查
    public DownloadTaskData gettask(String tag){
        if(tasks.containsKey(tag)){
            return tasks.get(tag);
        }else {
            return null;
        }
    }
    //分析下载状态
    public int getResult(DownloadTaskData data){
        return getResult(data.getUrl(),data.getPath());
    }

    public int getResult(String url,String path){
        int status = 0; //0 = 未知  1 = 下载中 2 = 中断  3 = 完成  4 = 重复下载
        switch (FileDownloader.getImpl().getStatus(url,path)) {
            case FileDownloadStatus.pending:
                status = _Downloading;
                break;
            case FileDownloadStatus.started:
                status = _Downloading;
                break;
            case FileDownloadStatus.connected:
                status = _Downloading;
                break;
            case FileDownloadStatus.progress:
                status = _Downloading;
                break;
            case FileDownloadStatus.blockComplete:
                status = _Completed;
                break;
            case FileDownloadStatus.completed:
                status = _Completed;
                break;
            case FileDownloadStatus.paused:
                status = _Paused;
                break;
            case FileDownloadStatus.error:
                status = _Paused;
                break;
            case FileDownloadStatus.warn:
                status = _Warn;
                LogDebug.d("show",path+": 出现重复下载任务");
                break;
        }
        return status;
    }
    /**
     *创建下载
     */
    public void start(DownloadTaskData data) {
        try {
            int status = getResult(data);
            switch (status) {
                case _NULL:
                    download(data);
                    break;
                case _Paused:
                    download(data);
                    break;
            }
        } catch (Exception e) {
            LogDebug.e("201802021751", e.toString());
        }
    }

    /**
     *手动暂停
     */
    public void pause(String tag) {
        try {
            DownloadTaskData data = gettask(tag);
            if (data == null)
                return;
            int downloadID = FileDownloadUtils.generateId(data.getUrl(),data.getPath());
            int size = FileDownloader.getImpl().pause(downloadID);
            if (size == 0) {
                FileDownloader.getImpl().clear(downloadID, data.getPath());
            }
        } catch (Exception e) {
            LogDebug.e("201802021808", e.toString());
        }
    }

    //删除任务源文件
    public void removeTaskAndFile(String tag) {
        try {
            DownloadTaskData data = gettask(tag);
            if (data == null)
                return;
            int downloadID = FileDownloadUtils.generateId(data.getUrl(), data.getPath());
            FileDownloader.getImpl().pause(downloadID);
            FileDownloader.getImpl().clear(downloadID, data.getPath());
        } catch (Exception e) {
            LogDebug.e("201803071218", e.toString());
        }
    }

    //后台全部重新连接一次网络 在网络切换的时候
    public void backgroundReStart() {
        if (reStartLock)
            return;
        reStartLock = true;
        FileDownloader.getImpl().pauseAll();
        new Thread() {
            @Override
            public void run() {
                try {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (Object o : tasks.entrySet()) {
                        Map.Entry entry = (Map.Entry) o;
                        Object val = entry.getValue();
                        if (val instanceof DownloadTaskData) {
                            download((DownloadTaskData) val);
                        }
                    }
                    reStartLock = false;
                } catch (Exception e) {
                    LogDebug.e("201802021602", e.toString());
                    reStartLock = false;
                }
            }
        }.start();
    }

    public boolean isJinwifi() {
        return jinwifi;
    }

    public void setJinwifi(boolean jinwifi) {
        this.jinwifi = jinwifi;
        Context context = AppControl.getInstance().getContext();
        FileUtils.writeCache(context, FileControl.getFullPath(context,FileControl.getDir_downloadSet())
                ,FileControl.getKey_downloadSet(),Boolean.valueOf(jinwifi).toString());
    }

    public static class DownloadTaskData{
        String tag;
        String url;
        String path;
        boolean wifi;
        FileDownloadListener listener;

        public DownloadTaskData(String tag, String url, String path, boolean wifi,FileDownloadListener listener) {
            this.tag = tag;
            this.url = url;
            this.path = path;
            this.listener = listener;
            this.wifi = wifi;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public FileDownloadListener getListener() {
            return listener;
        }

        public void setListener(FileDownloadListener listener) {
            this.listener = listener;
        }

        public boolean isWifi() {
            return wifi;
        }

        public DownloadTaskData setWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }
    }
}
