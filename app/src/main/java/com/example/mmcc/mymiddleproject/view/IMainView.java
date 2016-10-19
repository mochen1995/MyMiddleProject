package com.example.mmcc.mymiddleproject.view;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 16-10-19.
 */

public interface IMainView {
    void OnRequestSucceed(Object obj);
    void OnRequestFailured(String err);
}
