package com.e.rajapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PostrajActivity extends AppCompatActivity {
    private Button submit;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postraj);

        home = (Button)findViewById(R.id.bt_homepage_id);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dala();

            }
        });

    }

    private void dala() {

        Intent intent = new Intent(PostrajActivity.this,HomeActivity.class);
        startActivity(intent);

    }
}
