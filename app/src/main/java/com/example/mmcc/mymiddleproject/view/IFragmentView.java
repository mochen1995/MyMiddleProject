package com.example.mmcc.mymiddleproject.view;

/**
 * Created by Administrator on 16-10-20.
 */

public interface IFragmentView {
    void OnRequestSucceed(String json);
    void OnRequestFailured(String err);
    void netFailured(String err);
    void OnLoadListHead(String json);
}
