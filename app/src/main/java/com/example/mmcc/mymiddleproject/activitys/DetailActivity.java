package com.example.mmcc.mymiddleproject.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.example.mmcc.mymiddleproject.R;
import com.example.mmcc.mymiddleproject.db.SharedPreferenceUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;

public class DetailActivity extends BaseActivity {

    private static String WEB_URL = "web_url";
    @Bind(R.id.activity_detail_toolbar)
    Toolbar toolbar;
    @Bind(R.id.activity_detail_web)
    WebView webView;

    @Bind(R.id.title_bar_layout_save)
    CheckBox rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String web_url = getIntent().getStringExtra(WEB_URL);
        toolbar.setTitle(R.string.app_name);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webView.loadUrl(web_url);
        rb.setVisibility(View.VISIBLE);
        if (SharedPreferenceUtil.isSaved(DetailActivity.this,web_url))
        {
            rb.setChecked(true);
        }else{
            rb.setChecked(false);
        }

        rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferenceUtil.putData(DetailActivity.this, web_url, webView.getTitle());
                    /*Map<String, ?> allData = SharedPreferenceUtil.getAllData(DetailActivity.this);
                    Set<? extends Map.Entry<String, ?>> entries = allData.entrySet();
                    Iterator<? extends Map.Entry<String, ?>> iterator = entries.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, ?> next = iterator.next();
                    }*/
                } else {
                    SharedPreferenceUtil.remove(DetailActivity.this, web_url);
                  /*  Map<String, ?> allData = SharedPreferenceUtil.getAllData(DetailActivity.this);
                    Set<? extends Map.Entry<String, ?>> entries = allData.entrySet();
                    Iterator<? extends Map.Entry<String, ?>> iterator = entries.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, ?> next = iterator.next();
                    }*/
                }
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });


    }

    public static void toDetailActivity(Context context, String web_url) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(WEB_URL, web_url);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }
}
