package com.e.rajapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CreatAccountActivity extends AppCompatActivity {

    private TextView text;
    private TextView logginText;
    private Button creatAnAccount;
    private Button loggin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_account);
    }
}
