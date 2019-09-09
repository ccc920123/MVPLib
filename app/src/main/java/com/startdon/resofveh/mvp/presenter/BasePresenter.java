package com.startdon.resofveh.mvp.presenter;


import com.startdon.resofveh.mvp.view.BaseView;

/**
 * 描述： mvp p 层  处理 view层桥接activity的判断逻辑
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 9:50
 * 修改人：
 * 修改时间：
 */
public abstract class BasePresenter<T extends BaseView> {
    public T mView;

    public void attach(T mView) {
        this.mView = mView;
    }

    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }


}