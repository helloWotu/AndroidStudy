package com.example.myapplication.downloadfile;

import com.example.myapplication.base.BaseView;

import java.io.File;

public interface DownloadFileView extends BaseView {
    void onSuccess(File file);

    void onError(String msg);
}
