package com.cherish.practicalpractice.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, InspectorData> {
    public static int limit = 2;
    public static int offset;
   private int increment =  offset +=2;
   ApiService mApiService;
   List<ItemList> itemList = new ArrayList<>();

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, InspectorData> callback) {
        mApiService = ApiUtils.getAPIService();
        Log.i("Load Initial", "ON LOAD INITIAL");
        mApiService.getVehicleList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImEzZGE5N2RlLWQxNmUtNGI5Yi1iZGQzLTM5ZjFhMzU3YjExYyIsImVtYWlsIjoiZGF5b0BlbnlhdGEuY29tIiwicm9sZSI6Imluc3BlY3RvciIsImlhdCI6MTYwODExNTgxMywiZXhwIjoxNjA4MjAyMjEzfQ.DMlkk8Ys3A-LlIhjmLXfRHWbjutV0YtTebakOo18uF4",limit,0)
                .enqueue(new Callback<InspectionList>() {
                    @Override
                    public void onResponse(Call<InspectionList> call, Response<InspectionList> response) {
                        if (response.body()!=null){

                            Log.i("RESPONSE", String.valueOf(response.body()));
                            callback.onResult(response.body().getData(), null, offset += 2);
                        }
                    }

                    @Override
                    public void onFailure(Call<InspectionList> call, Throwable t) {
                        Log.i("FAILED", "Request FAILED");

                    }
                });

    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, InspectorData> callback) {

    }

//    @Override
//    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, InspectorData> callback) {
//        mApiService.getVehicleList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImEzZGE5N2RlLWQxNmUtNGI5Yi1iZGQzLTM5ZjFhMzU3YjExYyIsImVtYWlsIjoiZGF5b0BlbnlhdGEuY29tIiwicm9sZSI6Imluc3BlY3RvciIsImlhdCI6MTYwODAyODE1NywiZXhwIjoxNjA4MTE0NTU3fQ.b4WVPo20qW0UYqnmROceolE0VqWEQlzFVu-cz9sGhPI",limit,0)
//                .enqueue(new Callback<InspectionList>() {
//                    @Override
//                    public void onResponse(Call<InspectionList> call, Response<InspectionList> response) {
//                        Integer adjacentKey = (limit > 20) ? limit - 20 : null;
//                        if (response.body()!=null){
//                            Log.i("Load Before", "ON LOAD BEFORE");
//                            Log.i("RESPONSE", String.valueOf(response.body()));
//                            callback.onResult(response.body().getData(), adjacentKey);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<InspectionList> call, Throwable t) {
//                        Log.i("FAILED", "Request FAILED on Load before");
//
//                    }
//                });
//
//    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull final LoadCallback<Integer, InspectorData> callback) {
        Log.i("Params", String.valueOf(params.key));
        Log.i("Load After", "ON LOAD AFTER");
        mApiService.getVehicleList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImEzZGE5N2RlLWQxNmUtNGI5Yi1iZGQzLTM5ZjFhMzU3YjExYyIsImVtYWlsIjoiZGF5b0BlbnlhdGEuY29tIiwicm9sZSI6Imluc3BlY3RvciIsImlhdCI6MTYwODExNTgxMywiZXhwIjoxNjA4MjAyMjEzfQ.DMlkk8Ys3A-LlIhjmLXfRHWbjutV0YtTebakOo18uF4",limit,params.key)
                .enqueue(new Callback<InspectionList>() {
                    @Override
                    public void onResponse(Call<InspectionList> call, Response<InspectionList> response) {
                           if (response.body().getData().size() > 0){
                             int increamentKey =  offset+=2;
                             callback.onResult(response.body().getData(), increamentKey);
                           }


                    }

                    @Override
                    public void onFailure(Call<InspectionList> call, Throwable t) {
                        Log.i("FAILED", "Request FAILED on Load After");

                    }
                });


    }


//    @Override
//    public void loadInitial(@NonNull LoadInitialParams params, @NonNull final LoadInitialCallback callback) {
//
//
//    @Override
//    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {
//
//    }
//
//    @Override
//    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {
//
//    }


}
