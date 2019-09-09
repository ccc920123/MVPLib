package com.startdon.resofveh;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.startdon.resofveh.base.BaseActivity;
import com.startdon.resofveh.mvp.presenter.BasePresenter;
import com.startdon.resofveh.mvp.presenter.TestPresenter;
import com.startdon.resofveh.mvp.view.TestView;

public class TestActivity extends BaseActivity implements TestView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initEventAndData() {
        //TODO
        //加载布局与数据
        //

        ((TestPresenter) mPresenter).testMetdod(this, "test1", "test2");
    }

    @Override
    public BasePresenter getPresenter() {
        //TODO
        return new TestPresenter();
    }

    @Override
    public void dataSucced(Object bean) {
        //TODO
        // 请求返回的数据,处理你需要的逻辑
    }

    @Override
    public void daatOther(String message) {
        //TODO
        // 请求返回的数据，处理你需要的逻辑
    }

    @Override
    public void showLoadProgressDialog(String str) {
        //TODO
        // 开启消息等待框
        //由于网络框架在请求数据时自动默认开启（关闭）了等待框，所有这里不进行任何操作

    }

    @Override
    public void disDialog() {
        //TODO
        //由于网络框架在请求数据时自动默认开启（关闭）了等待框，所有这里不进行任何操作
    }

    @Override
    public void showToast(String message) {
        //TODO
        // 可以做toast
    }
}
