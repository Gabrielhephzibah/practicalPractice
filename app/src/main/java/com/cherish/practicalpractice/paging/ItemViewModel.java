package com.cherish.practicalpractice.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;

public class ItemViewModel extends ViewModel {
    LiveData<PagedList<InspectorData>> itemPageList;
    LiveData<PageKeyedDataSource<Integer, InspectorData>> liveDataSource;

    public  ItemViewModel(){
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        liveDataSource = dataSourceFactory.getItemLiveData();
        PagedList.Config pagedListConfig  = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.limit).build();
        itemPageList = (new LivePagedListBuilder(dataSourceFactory, pagedListConfig))
                .build();

    }





}

