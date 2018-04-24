package com.example.ali.a00267_lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME= "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_start );
        Log.i(ACTIVITY_NAME, "in onCreate");
        Button clickButton = findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
                startActivityForResult(intent, 5);


            }
        });
    }

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME,"in onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME,"in onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME,"in onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME,"in onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"in onDestory");
    }
}
