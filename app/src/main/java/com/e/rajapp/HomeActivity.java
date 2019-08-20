package com.e.rajapp;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {
    private ImageView profileImage;
    private Button uploadImage;
    private Button getRajHere;
    private Button postRajHere;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri profileImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (Build.VERSION.SDK_INT > 22) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
        }


        profileImage = (ImageView) findViewById(R.id.iv_profileimage_id);
        uploadImage = (Button) findViewById(R.id.bt_upload_id);
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btupload();
            }
        });

        getRajHere = (Button) findViewById(R.id.bt_getrajhere_id);
        getRajHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getjob();
            }
        });

        postRajHere = (Button) findViewById(R.id.bt_postrajhere_id);
        postRajHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postjob();
            }
        });


    }

    private void postjob() {

        Intent intent = new Intent(HomeActivity.this, PostrajActivity.class);
        startActivity(intent);

    }

    private void getjob() {

        Intent intent = (new Intent(HomeActivity.this, GetrajActivity.class));
        startActivity(intent);

    }


    private void btupload() {

        Intent btuploadIntent = new Intent();

        btuploadIntent.setType("image/*");

        btuploadIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(btuploadIntent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            profileImageUri = data.getData();
            profileImage.setImageURI(profileImageUri);

        }else {

            Toast.makeText(this, "Please choose image", Toast.LENGTH_SHORT).show();

        }
    }
}





