package com.e.rajapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CreatAccountActivity extends AppCompatActivity
{

    private TextView text;
    private Button creatAnAccount;
    private TextView logginText;
    private Button loggin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_account);

        text = (TextView)findViewById(R.id.tv_text_id);
        creatAnAccount = (Button)findViewById(R.id.bt_createaccount_id);
        logginText = (TextView)findViewById(R.id.tv_loggintext_id);
        loggin = (Button)findViewById(R.id.bt_login_id);



    }
}
