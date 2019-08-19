package com.e.rajapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetrajActivity extends AppCompatActivity {

    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getraj);


        home = (Button)findViewById(R.id.bt_home_id);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bthome();
            }
        });
    }

    private void bthome() {

        Intent intent = new Intent(GetrajActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
