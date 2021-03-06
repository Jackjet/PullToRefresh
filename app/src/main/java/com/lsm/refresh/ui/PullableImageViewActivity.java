package com.lsm.refresh.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lsm.refresh.R;
import com.lsm.refresh.widget.PullToRefreshLayout;

public class PullableImageViewActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullable_image_view);
        ((PullToRefreshLayout) findViewById(R.id.refresh_view))
                .setOnRefreshListener(new MyListener());
    }
}
