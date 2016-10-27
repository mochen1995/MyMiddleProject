package com.example.mmcc.mymiddleproject.activitys;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.db.SharedPreferenceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

public class SaveActivity extends BaseActivity {

    @Bind(R.id.activity_save_lv)
    ListView lv;

    private List<String> dateValues;
    private List<String> urlValues;
    private ArrayAdapter<String> adapter;
    private static int oldSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        initData();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, dateValues);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailActivity.toDetailActivity(SaveActivity.this,urlValues.get(position));
            }
        });
    }

    private void initData() {
        Map<String, ?> allData = SharedPreferenceUtil.getAllData(this);
        oldSize = allData.size();
        dateValues = new ArrayList<>();
        urlValues = new ArrayList<>();
        Object[] objectsKey = allData.keySet().toArray();
        for (Object o : objectsKey) {
            urlValues.add(o.toString());
        }
        Collection<String> values = (Collection<String>) allData.values();
        Object[] objectsValue = values.toArray();
        for (Object object : objectsValue) {
            dateValues.add(object.toString());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SharedPreferenceUtil.getAllData(this).size()!=oldSize)
        {
            initData();
            adapter.clear();
            adapter.addAll(dateValues);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_save;
    }
}
