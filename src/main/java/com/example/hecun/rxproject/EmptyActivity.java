package com.example.hecun.rxproject;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.hecun.rxproject.base.EmptyView;

public class EmptyActivity extends AppCompatActivity {

    private EmptyView mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        mEmptyView = new EmptyView(this, R.layout.activity_empty);
        mEmptyView.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmptyActivity.this, "加载数据", Toast.LENGTH_SHORT).show();
                mEmptyView.hideAll();
            }
        });
    }
    public void showEmptyPage(View view){
        mEmptyView.showLoadingLayout();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(EmptyActivity.this, "加载成功", Toast.LENGTH_SHORT).show();
                mEmptyView.hideAll();
            }
        },3000);
    }
    public void showNoNet(View view){
        mEmptyView.showInternetOffLayout();
    }

    public void showErrorPage(View view){
        mEmptyView.showExceptionLayout();
    }

}
