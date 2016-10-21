package com.example.mmcc.mymiddleproject.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.mmcc.mymiddleproject.bean.ImageEnjoy;
import com.example.mmcc.mymiddleproject.model.IMainModel;
import com.example.mmcc.mymiddleproject.model.MainModelImpl;
import com.example.mmcc.mymiddleproject.net.GsonUtil;
import com.example.mmcc.mymiddleproject.net.HttpUtils;
import com.example.mmcc.mymiddleproject.view.IImageDetailView;
import com.example.mmcc.mymiddleproject.view.IMainView;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by zhanglu on 2016/10/21.
 */

public class ImageDetailPresenter {
    private IImageDetailView mainView;
    private IMainModel mainModel;
    private Context mContext;

    private Handler handler;

    public ImageDetailPresenter(Context context, IImageDetailView mainView) {
        this.mainView = mainView;
        mainModel = new MainModelImpl();
        mContext = context;
        handler = new Handler(Looper.getMainLooper());
    }

    public void RequestData(final String url) {
        HttpUtils.RequestDatas(mContext, url, new HttpUtils.OnHttpRequestListener() {
            @Override
            public void succeed(final String json) {
                //数据解析
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TypeToken<List<ImageEnjoy>> typeToken = new TypeToken<List<ImageEnjoy>>(){};
                        List<ImageEnjoy> imgInfos = GsonUtil.jsonToList(json, typeToken.getType());
                        mainView.getAllImages(imgInfos);
                    }
                });
            }
            @Override
            public void failured(String err) {
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
