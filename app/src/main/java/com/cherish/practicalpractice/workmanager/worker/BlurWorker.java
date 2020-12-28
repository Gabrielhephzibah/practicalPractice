package com.cherish.practicalpractice.workmanager.worker;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.cherish.practicalpractice.workmanager.Constants;

public class BlurWorker extends Worker {


    public BlurWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String data = getInputData().getString("mData");

//        setting out-put data
        Data mData = new Data.Builder()
                .putString("mOutPut", "I'm outputting this data from worker to the class, after the work is done")
                .build();

//        setOutputData(mData);
//     setOutputData();
       workToDo(data);
        return Result.success(mData);
    }

    public void workToDo(String data){
        Log.i("Worker", data);
    }

//    public  void  setOutputData(Data data){
//        Log.i("OutPutData", String.valueOf(data));
//    }


//
//
//
//
//    public BlurWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
//        super(context, workerParams);
//
//
//    }
//
//    @NonNull
//    @Override
//    public Result doWork() {
//        Toast.makeText(getApplicationContext(), "Worker Request Starting", Toast.LENGTH_SHORT).show();
//        sleep();
//        String resourceUri = getInputData().getString(Constants.KEY_IMAGE_URI);
//        try {
//            if (TextUtils.isEmpty(resourceUri)){
//                Log.i("Error", "Invalid Uri");
//                throw new IllegalArgumentException("Invalid Input Uri");
//            }
//
//            ContentResolver resolver = getApplicationContext().getContentResolver();
//            // Create a bitmap
//            Bitmap picture = BitmapFactory.decodeStream(resolver.openInputStream(Uri.parse(resourceUri)))
//            // Blur the  bitmap
//            Bitmap output =
//
//        }catch (Throwable throwable){
//
//        }
//
//
//
//        return null;
//    }
//
//    static void sleep() {
//        try {
//            Thread.sleep(Constants.DELAY_TIME_MILLIS, 0);
//        } catch (InterruptedException e) {
//            Log.d("Error", e.getMessage());
//        }
//    }
}
