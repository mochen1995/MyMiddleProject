package com.example.mmcc.mymiddleproject.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 16-10-19.
 */

public class HttpUtils {

    public interface OnHttpRequestListener{
        void succeed(String json);
        void failured(String err);
    }
    private static OkHttpClient okHttpClient=null;
    //该方法只返回json数据
    public static void RequestDatas(Context context, String url, final OnHttpRequestListener listener) {
        if(isNetWorking(context))
        {
            if (okHttpClient == null)
            {
                okHttpClient = new OkHttpClient();
            }
            final Request request = new Request.Builder()
                    .url(url).build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    listener.failured("服务器异常！");
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                   listener.succeed(response.body().string());
                }
            });
        }else{
            listener.failured("请您检查网络连接...");
        }

    }

    /**
     *
     * @param context
     * @return  true表示有网络，false表示无网络
     */
    public static boolean isNetWorking(Context context){
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conn.getActiveNetworkInfo();
        if(networkInfo!=null&&networkInfo.isConnected())
        {
            return true;
        }
        return false;
    }
}
