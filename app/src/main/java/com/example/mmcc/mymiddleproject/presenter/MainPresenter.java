package com.example.mmcc.mymiddleproject.presenter;

import android.os.Handler;

import com.example.mmcc.mymiddleproject.model.IMainModel;
import com.example.mmcc.mymiddleproject.model.MainModelImpl;
import com.example.mmcc.mymiddleproject.net.HttpUtils;
import com.example.mmcc.mymiddleproject.view.IMainView;

/**
 * Created by Administrator on 16-10-19.
 */

public class MainPresenter {
    private IMainView mainView;
    private IMainModel mainModel;

    public MainPresenter(IMainView mainView){
        this.mainView = mainView;
        mainModel = new MainModelImpl();
    }

    public void RequestData(final String url){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String s = HttpUtils.RequestDatas(url);
                mainModel.saveDatas(s); //model保存了数据
                mainView.setText(s); //回调mainView的接口方法
            }
        },2000);

    }
    public String getDataFromLocal(){
        return mainModel.getDatas();
    }
}
