package com.example.ali.a00267_lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME= "LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        Log.i(ACTIVITY_NAME, "in onCreate");

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        });

        Button myButton = (Button)findViewById(R.id.button2);
        myButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( LoginActivity.this, StartActivity.class);
                startActivity(intent);

                SharedPreferences prefs;
                SharedPreferences.Editor editor;

                prefs = getSharedPreferences("My App", MODE_PRIVATE);
                editor = prefs.edit();

                TextView LoginTextView = findViewById(R.id.editText);

                editor.putString("LoginName", LoginTextView.getText().toString());
                editor.commit();
            }
        });


    }

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME,"in onStart");
        SharedPreferences prefs;

        prefs = getSharedPreferences("My APP", MODE_PRIVATE);

        TextView LoginTextView = findViewById(R.id.editText);
        String nameString = prefs.getString("LoginName", "email@domain.com" );
        LoginTextView.setText(nameString);
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
