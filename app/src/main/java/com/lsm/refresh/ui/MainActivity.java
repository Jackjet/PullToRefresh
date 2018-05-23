package com.lsm.refresh.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.lsm.refresh.R;
import com.lsm.refresh.widget.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 更多详解见博客http://blog.csdn.net/zhongkejingwang/article/details/38868463
 */
public class MainActivity extends Activity
{
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((PullToRefreshLayout) findViewById(R.id.refresh_view)).setOnRefreshListener(new MyListener());
        listView = (ListView) findViewById(R.id.content_view);
        initListView();
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent();
                switch (position) {
                    case 0:
                        it.setClass(MainActivity.this, PullableListViewActivity.class);
                        break;
                    case 1:
                        it.setClass(MainActivity.this, PullableGridViewActivity.class);
                        break;
                    case 2:
                        it.setClass(MainActivity.this, PullableExpandableListViewActivity.class);
                        break;
                    case 3:
                        it.setClass(MainActivity.this, PullableScrollViewActivity.class);
                        break;
                    case 4:
                        it.setClass(MainActivity.this, PullableWebViewActivity.class);
                        break;
                    case 5:
                        it.setClass(MainActivity.this, PullableImageViewActivity.class);
                        break;
                    case 6:
                        it.setClass(MainActivity.this, PullableTextViewActivity.class);
                        break;
                    case 7:
                        it.setClass(MainActivity.this, PullableRecyclerViewActivity.class);
                        break;
                    default:
                        break;
                }
                startActivity(it);
            }
        });
    }

    /**
     * ListView初始化方法
     */
    private void initListView() {
        List<String> items = new ArrayList<String>();
        items.add("可下拉刷新上拉加载的ListView");
        items.add("可下拉刷新上拉加载的GridView");
        items.add("可下拉刷新上拉加载的ExpandableListView");
        items.add("可下拉刷新上拉加载的SrcollView");
        items.add("可下拉刷新上拉加载的WebView");
        items.add("可下拉刷新上拉加载的ImageView");
        items.add("可下拉刷新上拉加载的TextView");
        items.add("可下拉刷新上拉加载的RecyclerViewView");
        MyAdapter adapter = new MyAdapter(this, items);
        listView.setAdapter(adapter);
    }
}
