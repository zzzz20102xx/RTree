package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.project.Retrofit.IService;
import com.example.project.Retrofit.RetrofitClient;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private EditText sendText;
    private String TAG="MainActivity";
    public static final String EXTRA_MESSAGE="com.example.map.MESSAGE";
    private IService server;
    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();//manage the subscribe event disposable
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init Service
        Retrofit retrofit= RetrofitClient.getInstance();
        server=retrofit.create(IService.class);

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
        compositeDisposable.add(server.loginUser("ainimal@123", "123123")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<String>(){

                @Override
                public void accept(String s) throws Exception {
                    Log.d("response", s);
                }
            })
        );

    }
}
