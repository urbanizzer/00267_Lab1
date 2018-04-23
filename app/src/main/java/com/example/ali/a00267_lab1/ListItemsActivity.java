package com.example.ali.a00267_lab1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.ali.a00267_lab1.StartActivity.ACTIVITY_NAME;

public class ListItemsActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME= "ListItemsActivity";
    private static final int CAMERA_REQUEST = 1888;
    android.widget.ImageButton ImageButton;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_items );
        Log.i(ACTIVITY_NAME, "in onCreate");

        Switch myswitch = findViewById(R.id.switch1);
        myswitch.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText( ListItemsActivity.this, "Swtich on", Toast.LENGTH_LONG ).show();
                } else {
                    Toast.makeText( ListItemsActivity.this,"Switch off", Toast.LENGTH_SHORT ).show();
                }
            }
        });
        ImageButton = findViewById(R.id.imageButton);
        ImageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                builder.setMessage(R.string.dialog_message)
                        .setTitle(R.string.dialog_title)
                        .setPositiveButton( R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Intent resultIntent = new Intent();
                                resultIntent.putExtra("response", "My information to share" );
                                setResult(Activity.RESULT_OK, resultIntent);
                            }
                        })
                        .setNegativeButton( R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                .show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageButton.setImageBitmap(photo);
        }
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

