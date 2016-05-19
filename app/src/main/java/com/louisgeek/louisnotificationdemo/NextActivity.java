package com.louisgeek.louisnotificationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

String sss=InfoHolderSingleton.getInstance().getListObj(0).toString();
        Toast.makeText(NextActivity.this, "单例方式得到的："+sss, Toast.LENGTH_SHORT).show();
    }
}
