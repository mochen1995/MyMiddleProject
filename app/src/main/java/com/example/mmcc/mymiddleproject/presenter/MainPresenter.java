package com.example.mmcc.mymiddleproject.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.mmcc.mymiddleproject.model.IMainModel;
import com.example.mmcc.mymiddleproject.model.MainModelImpl;
import com.example.mmcc.mymiddleproject.net.HttpUtils;
import com.example.mmcc.mymiddleproject.view.IMainView;
import com.google.gson.Gson;

/**
 * Created by Administrator on 16-10-19.
 */

public class MainPresenter {
    private IMainView mainView;
    private IMainModel mainModel;
    private Context mContext;

    private Handler handler;

    public MainPresenter(Context context, IMainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModelImpl();
        mContext = context;
        handler = new Handler(Looper.getMainLooper());
    }

    public void RequestData(final String url) {
        HttpUtils.RequestDatas(mContext, url, new HttpUtils.OnHttpRequestListener() {
            @Override
            public void succeed(String json) {
                //数据解析
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                      mainView.OnRequestSucceed(null);
                    }
                });
            }
            @Override
            public void failured(String err) {
                mainView.OnRequestFailured(err);
            }

            @Override
            public void netFailured(String err) {

            }
        });



    }

    public String getDataFromLocal() {
        return mainModel.getDatas();
    }
}
