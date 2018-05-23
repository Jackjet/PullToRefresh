package com.lsm.refresh.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lsm.refresh.R;
import com.lsm.refresh.widget.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import static com.lsm.refresh.widget.PullToRefreshLayout.SUCCEED;

public class PullableRecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<String> list;
    private Adapter adapter;
    private PullToRefreshLayout ptrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pullable_recycler_view);
        recyclerView = findViewById(R.id.content_view);
        ptrl = findViewById(R.id.refresh_view);
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);
        ptrl.setOnRefreshListener(new PullToRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {
                list.clear();
                adapter.notifyDataSetChanged();
                pullToRefreshLayout.refreshFinish(SUCCEED);
            }

            @Override
            public void onLoadMore(PullToRefreshLayout pullToRefreshLayout) {
                initData();
            }
        });
        ptrl.autoRefresh();
    }

    public void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(String.valueOf(i));
        }
        adapter.notifyDataSetChanged();
        ptrl.loadmoreFinish(SUCCEED);
    }

    class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
        private Context context;
        private List<String> lists;

        public Adapter(Context context, List<String> lists) {
            this.context = context;
            this.lists = lists;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textView.setText(lists.get(position));
        }

        @Override
        public int getItemCount() {
            return lists.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv);
            }
        }
    }
}
