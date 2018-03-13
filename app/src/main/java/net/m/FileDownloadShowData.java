package net.m;


import net.c.FileDownloadControl;

/**
 * 帮助界面展示下载状态的数据类
 * Created by java on 2018/2/8.
 */

public class FileDownloadShowData{
    public static final int _Paused = 1;
    public static final int _Start = 2;
    public static final int _Stop = 3;
    public static final int _UNzip = 4;
    //UI界面提供
    private String bookcode="";//每个下载任务的tag
    private String name="";//下载的大名
    private FileDownloadControl.DownloadTaskData downloadData;//下载数据
    private String unzippath;
    private int UIStatus;//界面的状态


    //回调提供 只是一个回调的状态 跟UI操作是脱节的
    private int pauseprogress=0;//进度
    private int speed;//速度
    private int status;//状态
    private boolean iserror;//是否有错误
    private String error;//发生错误 提示错误信息

    public String getBookcode() {
        return bookcode;
    }

    public FileDownloadShowData setBookcode(String bookcode) {
        this.bookcode = bookcode;
        return this;
    }

    public int getPauseprogress() {
        return pauseprogress;
    }

    public FileDownloadShowData setPauseprogress(int pauseprogress) {
        this.pauseprogress = pauseprogress;
        return this;
    }

    public FileDownloadControl.DownloadTaskData getDownloadData() {
        return downloadData;
    }

    public FileDownloadShowData setDownloadData(FileDownloadControl.DownloadTaskData downloadData) {
        this.downloadData = downloadData;
        return this;
    }

    public String getName() {
        return name;
    }

    public FileDownloadShowData setName(String name) {
        this.name = name;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public FileDownloadShowData setStatus(int status) {
        this.status = status;
        return this;
    }

    public boolean isIserror() {
        return iserror;
    }

    public FileDownloadShowData setIserror(boolean iserror) {
        this.iserror = iserror;
        return this;
    }

    public String getError() {
        return error;
    }

    public FileDownloadShowData setError(String error) {
        this.error = error;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getUnzippath() {
        return unzippath;
    }

    public FileDownloadShowData setUnzippath(String unzippath) {
        this.unzippath = unzippath;
        return this;
    }

    public int getUIStatus() {
        return UIStatus;
    }

    public FileDownloadShowData setUIStatus(int UIStatus) {
        this.UIStatus = UIStatus;
        return this;
    }
}