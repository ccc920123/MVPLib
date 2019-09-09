package com.startdon.resofveh.network;

/**
 * 描述：网络请求回调
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 15:29
 * 修改人：
 * 修改时间：
 */
public abstract class ResultCallback<T> {
    //    Call<T> request,
    public abstract void onError(String e);

    public abstract void onResponse(T response);
}