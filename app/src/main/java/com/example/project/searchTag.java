package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class searchTag extends AppCompatActivity {
    private Spinner type_spinner;
    private Spinner breed_spinner;
    private EditText found_time;
    private EditText animal_feature;
    private Button submitBtn;
    private RecyclerView animalList;
    private ArrayList<String> type=new ArrayList<String>();
    private ArrayList<String> breed=new ArrayList<String>();


    private ImageView img1;
    private ImageView img2;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_tag);
        initWidge();
    }
    private void initWidge(){
        type_spinner=findViewById(R.id.animalType);
        breed_spinner=findViewById(R.id.breed);
        found_time=findViewById(R.id.foundTime);
        animal_feature=findViewById(R.id.feature);
        submitBtn=findViewById(R.id.submitBtn);
        //animalList=findViewById(R.id.animalList);
        type.add("狗");
        type.add("貓");
        breed.add("拉布阿多");
        breed.add("臘腸狗");
        ArrayAdapter<String> typeAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,type);
        ArrayAdapter<String> breedAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,breed);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        breedAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        type_spinner.setAdapter(typeAdapter);
        breed_spinner.setAdapter(breedAdapter);


        img1=findViewById(R.id.imageView);
        img2=findViewById(R.id.imageView3);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        t1.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);
        t3.setVisibility(View.INVISIBLE);
        t4.setVisibility(View.INVISIBLE);
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
    }
    public void showAnimalResult(View view){
        t1.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        t4.setVisibility(View.VISIBLE);
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.VISIBLE);
    }
}
