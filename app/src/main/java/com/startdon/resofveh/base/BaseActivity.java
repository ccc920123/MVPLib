package com.startdon.resofveh.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.startdon.resofveh.mvp.presenter.BasePresenter;
import com.startdon.resofveh.mvp.view.BaseView;

/**
 * 描述： Actiovity 的基本类
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 14:11
 * 修改人：
 * 修改时间：
 */
public abstract class BaseActivity<T extends BasePresenter<BaseView>> extends AppCompatActivity implements IBase {
    public BasePresenter mPresenter;
    public Context mContext;
    /**
     * 传入标示符
     */
    public String fromTag;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // mRxManager = new RxManager();
        setBaseConfig();
        setContentView(getLayoutId());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //如果使用 黄牛刀，就开启该方法
//        ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        onSaveState(savedInstanceState);
        mPresenter = getPresenter();
        if (mPresenter != null && this instanceof BaseView) {
            mPresenter.attach((BaseView) this);
        }
        //注册一个监听连接状态的listener
        initEventAndData();


    }

    public void onSaveState(Bundle savedInstanceState) {
    }


    private void setBaseConfig() {
        initTheme();
        AppManager.getAppManager().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * 获取布局
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 设置监听
     */
    protected abstract void initEventAndData();

    private void initTheme() {
    }

    private void restartApplication() {
        final Intent intent = this.getPackageManager().getLaunchIntentForPackage(this.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        this.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        AppManager.getAppManager().finishActivity(this);
        if (mPresenter != null && this instanceof BaseView) {
            mPresenter.detachView();
            mPresenter = null;
        }

        super.onDestroy();
    }

    private void initToolBarConfig() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }

    /**
     * 开启消息等待框
     *
     * @param string
     */
    public void showLoading(String string) {
//        CustomPrograss.show(this, string, false, null);
    }

    /**
     * 关闭消息等待框
     */
    public void dissLoadDialog() {

//        CustomPrograss.disMiss();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }


}
