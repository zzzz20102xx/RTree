package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText sendText;
    private String TAG="MainActivity";
    public static final String EXTRA_MESSAGE="com.example.map.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startMapActivity(View view){
        Log.d(TAG, "startMapActivity: ");
        Intent intent=new Intent(this,mapActivity.class);
        String message="This is map";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void startDataActivity(View view){
        Log.d(TAG, "startDataActivity: ");
        Intent intent=new Intent(this,searchTag.class);
        String message="This is searchTag";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void startWriteActivity(View view){
        Log.d(TAG, "startWriteActivity: ");
        Intent intent=new Intent(this,searchTag.class);
        String message="This is writeLost";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void sendMessage(View view){
        Log.d("console", "successful");
        Intent intent=new Intent(this, mapActivity.class);
        sendText=(EditText) findViewById(R.id.sendText);
        String message=sendText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);

    }
}
