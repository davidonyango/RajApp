package com.e.rajapp;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    private CircleImageView circularProfile;
    private Button uploadImage;
    private Button getRajHere;
    private Button postRajHere;
    private static final int PICK_IMAGE_REQUEST =1;
    private  Uri circularProfileUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(Build.VERSION.SDK_INT >22){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2);
        }

        circularProfile = (CircleImageView)findViewById(R.id.civ_circularprofile_id);
        //setting up the circular image
        circularProfile.setCircleBackgroundColor(Color.WHITE);

        circularProfile.setBorderWidth(2);

        circularProfile.setImageResource(R.drawable.circularprofile);

        circularProfile.setBorderOverlay(true);
        uploadImage = (Button)findViewById(R.id.bt_upload_id);
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                ploadciv();

            }
        });

        getRajHere = (Button)findViewById(R.id.bt_getrajhere_id);
        getRajHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getrajo();
            }
        });


        postRajHere = (Button)findViewById(R.id.bt_postrajhere_id);
        postRajHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postrajo();

            }
        });

            }

    private void postrajo() {

        Intent intent = new Intent(HomeActivity.this,PostrajActivity.class);
        startActivity(intent);

    }

    private void getrajo() {

        Intent intent = new Intent(HomeActivity.this,GetrajActivity.class);
        startActivity(intent);
    }

    private void ploadciv() {

        Intent ploadcivIntent = new Intent();

        ploadcivIntent.setType("image/*");

        ploadcivIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(ploadcivIntent, PICK_IMAGE_REQUEST);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            circularProfileUri = data.getData();
            circularProfile.setImageURI(circularProfileUri);


        } else {

            Toast.makeText(this, "Please choose image", Toast.LENGTH_SHORT).show();
        }
    }
}



