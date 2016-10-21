package com.example.mmcc.mymiddleproject.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mmcc.mymiddleproject.R;

import butterknife.Bind;

public class DetailActivity extends BaseActivity {

    private static String WEB_URL = "web_url";
    @Bind(R.id.activity_detail_toolbar)
    Toolbar toolbar;
    @Bind(R.id.activity_detail_web)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String web_url = getIntent().getStringExtra(WEB_URL);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white));
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webView.loadUrl(web_url);
        webView.setWebViewClient(new WebViewClient(){
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
