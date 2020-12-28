package com.cherish.practicalpractice.paging;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cherish.practicalpractice.R;
import com.cherish.practicalpractice.appsetting.SettingActivity;

public class PagingActivity extends AppCompatActivity {
  private   RecyclerView recyclerView;
  private  ItemViewModel itemViewModel;
  private SwipeRefreshLayout swipeLayout;
    DataSourceFactory dataSourceFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        recyclerView = findViewById(R.id.recyclerView);
        swipeLayout = findViewById(R.id.swiperLayout);
        dataSourceFactory = new DataSourceFactory();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        ItemAdapter itemAdapter = new ItemAdapter(this);
//        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                dataSourceFactory.itemLiveData.getValue().invalidate();
//
//
//            }
//        });
//        itemViewModel.itemPageList.observe(this, new Observer<PagedList<InspectorData>>() {
//            @Override
//            public void onChanged(PagedList<InspectorData> inspectorData) {
//                itemAdapter.submitList(inspectorData);
//                swipeLayout.setRefreshing(false);
//            }
//        });
//
//        recyclerView.setAdapter(itemAdapter);

    }

    public void onNext(View view) {
        Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
        startActivity(intent);
    }
}