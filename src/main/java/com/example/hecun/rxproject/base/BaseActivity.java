package com.example.hecun.rxproject.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hecun.rxproject.DemoApplication;
import com.example.hecun.rxproject.di.component.ActivityComponent;
import com.example.hecun.rxproject.di.component.DaggerActivityComponent;
import com.example.hecun.rxproject.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {

    public ActivityComponent mActivityComponent;
    public EmptyView mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewID());
        mEmptyView = new EmptyView(this,getContentViewID());
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((DemoApplication) getApplication()).getApplicationComponent())
                .build();
        initDagger();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initPresenter();
    }

    protected abstract void initDagger();
    protected abstract int getContentViewID();
    protected abstract void initPresenter();
}
