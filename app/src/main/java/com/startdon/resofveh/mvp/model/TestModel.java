package com.startdon.resofveh.mvp.model;

import android.content.Context;

import com.startdon.resofveh.mvp.MVPCallBackImp;

/**
 * 描述：test
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5
 * 修改人：
 * 修改时间：
 */


public class TestModel implements TestModelImp {


    /**
     *  处理网络逻辑
     * @param context  上下文
     * @param callBack  回调
     * @param params   String 的参数组
     */
    @Override
    public void test(Context context, MVPCallBackImp callBack, String... params) {

        //TODO
        // 1.开始进行网络请求
        //2.网络请求失败通过 callBack.failed("error")；告知presenter
        //2-1. 网络请求成功通过 callBack.succeed(T); 告知presenter


    }
}
