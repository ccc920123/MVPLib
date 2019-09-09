package com.startdon.resofveh.mvp.presenter;

import android.content.Context;

import com.startdon.resofveh.mvp.MVPCallBackImp;
import com.startdon.resofveh.mvp.model.TestModel;
import com.startdon.resofveh.mvp.model.TestModelImp;
import com.startdon.resofveh.mvp.view.TestView;

/**
 * 描述：test
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5
 * 修改人：
 * 修改时间：
 */


public class TestPresenter extends BasePresenter<TestView> {

    //最重要的一步
    TestModelImp testModelImp = new TestModel();

    public void testMetdod(Context context, String... params) {
        //TODO
        //1.你可以在这里判断 mView 不等于空 进行消息等待框的加载，提示用户。
        //由于网络框架在请求数据时自动默认开启（关闭）了等待框，所有这里步在开启
//        if(mView!=null)
//        {
//            mView.showLoadProgressDialog("加载数据...");
//        }

        //2.通过 testModelImp 来调取操作model层的方法
        testModelImp.test(context, new MVPCallBackImp() {
            @Override
            public void succeed(Object bean) {

                //如果开始消息等待，请记得关闭等待框
//                mView.disDialog();
                // 通过mView 来操作 view 层 （也就是间接操作到Activity）
                mView.dataSucced(bean);
                // 或者
                // mView.daatOther("Z这个方法也行")

            }

            @Override
            public void failed(String message) {
                //如果开始消息等待，请记得关闭等待框
//                mView.disDialog();
                // 通过mView 来操作 view 层 （也就是间接操作到Activity）
                //提示错误
                mView.showToast("error");
            }
        }, params);


    }

}
