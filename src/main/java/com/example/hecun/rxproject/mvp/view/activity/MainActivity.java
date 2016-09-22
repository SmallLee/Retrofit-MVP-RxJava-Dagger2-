package com.example.hecun.rxproject.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.hecun.rxproject.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView textView;
    String[] datas = {"a","b","c"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
    }
        public void single(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
    public void subject(View view){
        Intent intent = new Intent(this,SubjectActivity.class);
        startActivity(intent);
    }

    public void Schedulers(View view){
        Intent intent = new Intent(this,SchedulersActivity.class);
        startActivity(intent);
    }
    public void Demo(View view){
        Intent intent = new Intent(this,DemoActivity.class);
        startActivity(intent);
    }

    public void emptyView(View view){
       startActivity(new Intent(this,EmptyActivity.class));
    }

}
