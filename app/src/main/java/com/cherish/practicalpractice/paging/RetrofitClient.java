package com.cherish.practicalpractice.paging;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofitt;

    public  Retrofit getRetrofit() {
        return retrofit;

    }

    private static Retrofit retrofit = null;

    public static OkHttpClient createDefaultOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient().newBuilder()
                .addInterceptor(interceptor)
                .build();

    }






    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(createDefaultOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
