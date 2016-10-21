package com.example.mmcc.mymiddleproject.fragment.tabfragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.activitys.DetailActivity;
import com.example.mmcc.mymiddleproject.adapter.FirstFragment_tab1Adapter;
import com.example.mmcc.mymiddleproject.adapter.FirstFragment_tab2Adapter;
import com.example.mmcc.mymiddleproject.adapter.ListHeadAdapter;
import com.example.mmcc.mymiddleproject.bean.ListHeadInfo;
import com.example.mmcc.mymiddleproject.bean.MaterialBean;
import com.example.mmcc.mymiddleproject.bean.Selection;
import com.example.mmcc.mymiddleproject.net.GsonUtil;
import com.example.mmcc.mymiddleproject.presenter.FragmentPresenter;
import com.example.mmcc.mymiddleproject.url.MyUrl;
import com.example.mmcc.mymiddleproject.view.IFragmentView;
import com.example.mylibrary.L;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhanglu on 2016/10/21.
 */

public class SecondFragment_tab2 extends Fragment implements IFragmentView, ViewPager.OnPageChangeListener, PullToRefreshBase.OnRefreshListener2, FirstFragment_tab2Adapter.OnTwoLayoutClickListener {
    @Bind(R.id.fragment_tab1_material_ptr)
    PullToRefreshListView ptr;
    private View mView;
    private FragmentPresenter presenter;
    private int currentPage = 1; //数据加载的页数
    private ListHeadAdapter listHeadAdapter;
    private FirstFragment_tab2Adapter adapter;
    private RadioGroup rg;
    private ViewPager vp;

    private int currentHeadPos; //当前头部视图的位置
    private boolean isDraging; //当前是否在拖动头部视图，停止自动轮播

    //处理预加载
    private boolean isInit = false; //是否初始化了布局,即调用了onCreateView
    private boolean isFirst = true;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x10:
                    //轮播头部视图
                    currentHeadPos++;
                    vp.setCurrentItem(currentHeadPos % 3, true);
                    break;
            }
        }
    };


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isFirst && isVisibleToUser) {
            if (isInit) {
                isFirst = false;
                loadData();
            }
        }
    }

    public void loadData() {
        //请求数据
        presenter.RequestData(MyUrl.getSceneryUrl(currentPage));
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter.getCount() == 0 && getUserVisibleHint()) {
            loadData();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isInit = true;
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_tab1_material, container, false);
            presenter = new FragmentPresenter(getContext(), this);
            ButterKnife.bind(this, mView);
            initView();
          /*  //请求头部视图数据
            presenter.RequestHeadData(MyUrl.getMaterialHeadUrl());*/
        }
        return mView;
    }

    private void initView() {
        ptr.setOnRefreshListener(this);
        adapter = new FirstFragment_tab2Adapter(getContext());
        ptr.setEmptyView(mView.findViewById(R.id.list_empty_view));
        adapter.setOnTwoLayoutClickListener(this);
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
        presenter.RequestData(MyUrl.getSceneryUrl(currentPage));
    }

    //上拉加载
    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        currentPage++;
        presenter.RequestData(MyUrl.getSceneryUrl(currentPage));
    }

    @Override
    public void OnRequestSucceed(String json) {
        if (currentPage == 1) //说明请求的第一页数据
            adapter.clearDatas();

        L.e(json);
        List<MaterialBean> list = GsonUtil.parsonCommonJson(json);
        L.e(list.toString());
        adapter.addDatas(list);
        if (ptr != null)
            ptr.onRefreshComplete();
    }

    @Override
    public void OnRequestFailured(String err) {
        L.e(err);
        Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
        /*if (ptr != null)
            ptr.onRefreshComplete();*/
    }

    @Override
    public void netFailured(String err) {
        Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
        if (ptr != null)
            ptr.onRefreshComplete();
    }

    @Override
    public void OnLoadListHead(String json) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        currentHeadPos = position;
        RadioButton rb = (RadioButton) rg.getChildAt(position);
        rb.setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            case ViewPager.SCROLL_STATE_DRAGGING:
                isDraging = true;
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                isDraging = false;
                break;
        }
    }

    @Override
    public void OnLeftClick(String webUrl) {
        DetailActivity.toDetailActivity(getContext(), webUrl);
    }

    @Override
    public void OnRightClick(String webUrl) {
        DetailActivity.toDetailActivity(getContext(), webUrl);
    }
}
