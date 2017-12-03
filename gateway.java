package com.example.admin.tabbedactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class gateway extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gateway);
        String f = getIntent().getExtras().getString("load");
        Toast.makeText(gateway.this,f,Toast.LENGTH_SHORT).show();
    }
}
