package com.hack.twenty;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.hack.twenty.api.UserApi;
import com.hack.twenty.interfaces.NetworkInterface;
import com.hack.twenty.tasks.NetworkTask;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by stoyan on 10/24/15.
 */
public class Money extends Application {
    /**
     * TAG for logging
     */
    private static final String TAG = "Application";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static final String RECIPIENT_URL = "https://myles.herokuapp.com/api/last_recipient";
    public static Long USER_ID = 1l;

    public static OkHttpClient client = new OkHttpClient();
    public static ImageLoader imageLoader;
    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String get(String url) throws IOException {
//        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static void asyncGet(String url, NetworkInterface networkInterface){
        NetworkTask task = new NetworkTask(networkInterface, true);
        task.execute(url);
    }

    public static void asyncPost(String url, String json){
        NetworkTask task = new NetworkTask();
        task.execute(url, json);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        imageLoader = ImageLoader.getInstance(); // Get singleton instance
        imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
        getRecipient();
    }

    private void getRecipient() {
        asyncGet(RECIPIENT_URL, new NetworkInterface() {
            @Override
            public void onNetworkResponse(String result) {
                Log.d(TAG, result);
                Gson gson = new Gson();
                UserApi userApi = gson.fromJson(result, UserApi.class);
                if(userApi != null){
                    USER_ID = userApi.id;
                }
            }
        });
        
    }
}
