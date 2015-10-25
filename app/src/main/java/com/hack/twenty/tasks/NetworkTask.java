package com.hack.twenty.tasks;

import android.os.AsyncTask;

import com.hack.twenty.Money;
import com.hack.twenty.interfaces.NetworkInterface;

import java.io.IOException;

/**
 * Created by stoyan on 10/24/15.
 */
public class NetworkTask extends AsyncTask<String, Void, String> {
    NetworkInterface mCallback;
    public NetworkTask(NetworkInterface callback){
        this.mCallback = callback;
    }
    @Override
    protected String doInBackground(String... params) {
        try {
            return Money.get(params[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(mCallback != null){
            mCallback.onNetworkResponse(result);
        }
    }
}
