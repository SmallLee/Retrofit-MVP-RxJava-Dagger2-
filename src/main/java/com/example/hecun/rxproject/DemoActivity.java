package com.example.hecun.rxproject;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hecun.rxproject.base.BaseActivity;
import com.example.hecun.rxproject.common.Constant;
import com.example.hecun.rxproject.entity.MovieInfo;
import com.example.hecun.rxproject.mvp.presenter.IDemoPresenter;
import com.example.hecun.rxproject.mvp.view.IDemoView;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import butterknife.BindView;

public class DemoActivity extends BaseActivity implements IDemoView{
    private static final String TAG = "DemoActivity";
    @BindView(R.id.tv_content)
    TextView tvContent;
    @Inject
    IDemoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.init(TAG);
    }
    @Override
    protected void initDagger() {
        mActivityComponent.inject(this);
    }
    @Override
    protected int getContentViewID() {
        return R.layout.activity_demo;
    }
    @Override
    protected void initPresenter() {
        presenter.attachView(this);
    }


    public void request(View view){
        presenter.getMovieInfo(Constant.VOTE,Constant.API_KEY);
    }


    @Override
    public void showView(MovieInfo result) {
        Logger.d(result.toString());
        tvContent.setText(result.toString());
    }

    @Override
    public void showError(Throwable throwable) {
        Logger.d(throwable.getMessage());
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.detachView();
    }
}
