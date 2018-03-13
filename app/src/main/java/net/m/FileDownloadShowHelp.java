package net.m;

import java.util.HashMap;

/**
 * 帮助下载类展示数据和状态
 * Created by java on 2018/2/2.
 */

public class FileDownloadShowHelp {
    private static FileDownloadShowHelp INSTANCE;
    private HashMap<String, FileDownloadShowData> hashMap = new HashMap<>();

    public static FileDownloadShowHelp getInstance() {
        if (INSTANCE == null){
            INSTANCE = new FileDownloadShowHelp();
        }
        return INSTANCE;
    }

    public void addData(FileDownloadShowData data){
        hashMap.put(data.getBookcode(),data);
    }

    public FileDownloadShowData getData(String bookcode){
        FileDownloadShowData data = null;
        if (hashMap.containsKey(bookcode)){
            data = hashMap.get(bookcode);
        }
        return data;
    }

    public void removeData(String bookcode){
        hashMap.remove(bookcode);
    }

    public HashMap<String, FileDownloadShowData> getHashMap() {
        return hashMap;
    }

}
