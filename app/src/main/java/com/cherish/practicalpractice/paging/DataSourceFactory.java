package com.cherish.practicalpractice.paging;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedListAdapter;

public class DataSourceFactory extends DataSource.Factory {
    public MutableLiveData<PageKeyedDataSource<Integer, InspectorData>> itemLiveData = new MutableLiveData<>();


    @NonNull
    @Override
    public DataSource<Integer, InspectorData> create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        itemLiveData.postValue(itemDataSource);

        return itemDataSource;
    }

    public  MutableLiveData<PageKeyedDataSource<Integer, InspectorData>> getItemLiveData(){
        return itemLiveData;
    }
}
