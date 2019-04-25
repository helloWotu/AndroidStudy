package com.example.myapplication.downloadfile;

public interface DownFileCallback {

    void onSuccess(String path);

    void onFail(String msg);

    void onProgress(long totalSize, long downSize);

}
