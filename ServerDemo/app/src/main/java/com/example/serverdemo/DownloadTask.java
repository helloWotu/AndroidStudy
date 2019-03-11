package com.example.serverdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class DownloadTask extends AsyncTask<Void,Integer,Boolean> {



    /**
     * 在后台任务开始执行之前调用，用户进行一些界面上的初始化操作，比如显示一个进度条对话框
     */
    @Override
    protected void onPreExecute() {

    }


    /**
     * 这个方法会在子线程中运行
     * @param voids
     * @return
     */
    @Override
    protected Boolean doInBackground(Void... voids) {
        return null;
    }

    /**
     * 在这个方法中可以对UI进行操作，利用参数中的数值就可以对界面元素进行相应的更新
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    /**
     *
     * @param aBoolean
     */
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

}
