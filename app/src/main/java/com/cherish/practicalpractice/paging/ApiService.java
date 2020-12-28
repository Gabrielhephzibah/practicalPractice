package com.cherish.practicalpractice.paging;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("vehicle")
    Call<InspectionList> getVehicleList(@Header("Authorization") String authorization,
                                        @Query("limit") int  limit ,
                                        @Query("offset") int  offset);
}
