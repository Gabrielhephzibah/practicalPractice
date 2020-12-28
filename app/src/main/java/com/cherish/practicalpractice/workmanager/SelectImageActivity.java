package com.cherish.practicalpractice.workmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cherish.practicalpractice.R;
import com.cherish.practicalpractice.datePicker.DatePickerActivity;
import com.cherish.practicalpractice.workmanager.worker.BlurWorker;

import java.io.IOException;

public class SelectImageActivity extends AppCompatActivity {
    Uri imageUrl;
    Button selectImg,cancelWork, nextPage;
   public WorkManager workManager;
    TextView workStatus,outputData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);
        selectImg = findViewById(R.id.selectImage);
        workStatus = findViewById(R.id.workStatus);
        outputData = findViewById(R.id.outputData);
        cancelWork = findViewById(R.id.cancelWork);
        nextPage = findViewById(R.id.nextPage);

        Data data = new Data.Builder()
                .putString("mData", "I Know, I know, I know")
                .build();

        // ************ Setting Constraints ***********

        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true) // you can add as many constraints as you want
                .setRequiresStorageNotLow(true)
                .build();

        final WorkRequest workRequest = new OneTimeWorkRequest.Builder(BlurWorker.class)
                .setInputData(data)
                .build();
        // ******************* Cancel Work *****************
            cancelWork.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WorkManager.getInstance(getApplicationContext()).cancelWorkById(workRequest.getId());
                }
            });

            nextPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), DatePickerActivity.class);
                    startActivity(intent);
                }
            });



//        workManager = WorkManager.getInstance().

        selectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance(getApplicationContext()).enqueue(workRequest);
//                pickImage();
            }
        });

      WorkManager.getInstance(getApplicationContext()).getWorkInfoByIdLiveData(workRequest.getId())
              .observe(this, new Observer<WorkInfo>() {
                  @Override
                  public void onChanged(WorkInfo workInfo) {

                      if (workInfo!=null && workInfo.getState().isFinished()){
                          outputData.append(workInfo.getOutputData().getString("mOutPut") + "\n");
                          workStatus.append(workInfo.getState().name() + "\n");
                      }
                  }
              });

        if (checkForPermission()){

        }else {
            requestPermission();
        }
    }



    public boolean checkForPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }




    public void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED) {
                            showMessageOKCancel("You need to allow access permissions",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermission();
                                            }
                                        }
                                    });
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(SelectImageActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    public void  pickImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == RESULT_OK && data != null && data.getData() != null){
            handleImageResult(data);
//            imageUrl = data.getData();
//            Log.i("ImageUrl", imageUrl.toString());
//            Bitmap bitmap;
//            try {
//                if (  Build.VERSION.SDK_INT < 28) {
//                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUrl);
//                } else {
//                    ImageDecoder.Source source = ImageDecoder.createSource(getContentResolver(),imageUrl);
//                    bitmap = ImageDecoder.decodeBitmap(source);
//                }
//                image.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }

    }

    private  void  handleImageResult(Intent data){
        Uri imageUri = null;
        if (data.getClipData() != null) {
            imageUri = data.getClipData().getItemAt(0).getUri();
        } else if (data.getData() != null) {
            imageUri = data.getData();
        }

        if (imageUri == null) {
            Log.e("Message", "Invalid input image Uri.");
            return;
        }

        Intent filterIntent = new Intent(this, BlurActivity.class);
        filterIntent.putExtra(Constants.KEY_IMAGE_URI, imageUri.toString());
        startActivity(filterIntent);
    }


}