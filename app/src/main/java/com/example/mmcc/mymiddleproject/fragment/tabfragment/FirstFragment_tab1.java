package com.example.mmcc.mymiddleproject.fragment.tabfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.adapter.FirstFragment_tab1Adapter;
import com.example.mmcc.mymiddleproject.bean.Selection;
import com.example.mmcc.mymiddleproject.net.GsonUtil;
import com.example.mmcc.mymiddleproject.presenter.FragmentPresenter;
import com.example.mmcc.mymiddleproject.url.MyUrl;
import com.example.mmcc.mymiddleproject.view.IFragmentView;
import com.example.mylibrary.L;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-10-20.
 */

public class FirstFragment_tab1 extends Fragment implements PullToRefreshBase.OnRefreshListener2, IFragmentView {

    @Bind(R.id.fragment_tab1_selection_ptr)
    PullToRefreshListView ptr;
    private View mView;
    private FragmentPresenter presenter;
    private int currentPage = 1;
    private FirstFragment_tab1Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_tab1_selection, container, false);
        ButterKnife.bind(this, mView);
        presenter = new FragmentPresenter(getContext(), this);
        presenter.RequestData(MyUrl.getSelectUrl(currentPage));
        initView();
        return mView;
    }

    private void initView() {
        ptr.setOnRefreshListener(this);
        adapter = new FirstFragment_tab1Adapter(getContext());
        ptr.setEmptyView(mView.findViewById(R.id.list_empty_view));
        ptr.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    //下拉刷新
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        currentPage = 1;
        presenter.RequestData(MyUrl.getSelectUrl(currentPage));
    }

    //上拉加载
    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        currentPage++;
        presenter.RequestData(MyUrl.getSelectUrl(currentPage));
    }

    @Override
    public void OnRequestSucceed(String json) {
        if(currentPage==1) //说明请求的第一页数据
            adapter.clearDatas();
        List<Selection> list = GsonUtil.parsonJson(json);
        L.e(list.toString());
        adapter.addDatas(list);
        ptr.onRefreshComplete();
    }

    @Override
    public void OnRequestFailured(String err) {
        L.e(err);
        ptr.onRefreshComplete();
    }

    @Override
    public void netFailured(String err) {
        Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
        ptr.onRefreshComplete();
    }
}
