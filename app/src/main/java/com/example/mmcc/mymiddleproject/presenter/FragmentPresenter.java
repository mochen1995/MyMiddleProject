package com.example.mmcc.mymiddleproject.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.mmcc.mymiddleproject.model.IMainModel;
import com.example.mmcc.mymiddleproject.model.MainModelImpl;
import com.example.mmcc.mymiddleproject.net.HttpUtils;
import com.example.mmcc.mymiddleproject.view.IFragmentView;
import com.example.mmcc.mymiddleproject.view.IMainView;

/**
 * Created by Administrator on 16-10-20.
 */

public class FragmentPresenter {
    private IFragmentView fragmentView;
    private IMainModel mainModel;
    private Context mContext;

    private Handler handler;

    public FragmentPresenter(Context context, IFragmentView fragmentView) {
        this.fragmentView = fragmentView;
        mainModel = new MainModelImpl();
        mContext = context;
        handler = new Handler(Looper.getMainLooper());
    }
    public void RequestData(final String url) {
        HttpUtils.RequestDatas(mContext, url, new HttpUtils.OnHttpRequestListener() {
            @Override
            public void succeed(final String json) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        fragmentView.OnRequestSucceed(json);
                    }
                });
            }
            @Override
            public void failured(String err) {
                fragmentView.OnRequestFailured(err);
            }

            @Override
            public void netFailured(String err) {
                fragmentView.netFailured(err);
            }
        });
    }

    public void RequestHeadData(final String url) {
        HttpUtils.RequestDatas(mContext, url, new HttpUtils.OnHttpRequestListener() {
            @Override
            public void succeed(final String json) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        fragmentView.OnLoadListHead(json);
                    }
                });
            }
            @Override
            public void failured(String err) {
               // fragmentView.OnRequestFailured(err);
            }

            @Override
            public void netFailured(String err) {
               // fragmentView.netFailured(err);
            }
        });
    }


    public String getDataFromLocal() {
        return mainModel.getDatas();
    }
}
