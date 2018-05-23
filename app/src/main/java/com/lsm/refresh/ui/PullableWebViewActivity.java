package com.lsm.refresh.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.lsm.refresh.R;
import com.lsm.refresh.widget.PullToRefreshLayout;

public class PullableWebViewActivity extends Activity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullable_web_view);
        ((PullToRefreshLayout) findViewById(R.id.refresh_view)).setOnRefreshListener(new MyListener());
        webView = findViewById(R.id.content_view);
        webView.loadUrl("https://www.baidu.com/");
    }
}
