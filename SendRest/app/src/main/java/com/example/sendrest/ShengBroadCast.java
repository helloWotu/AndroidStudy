package com.example.sendrest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ShengBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String content = getResultData();

        setResultData("");
        abortBroadcast();

    }
}
