package com.startdon.resofveh.mvp;

/**
 * 描述：一个简单的回调类,用于普通的回调
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 9:56
 * 修改人：
 * 修改时间：
 */

public interface MVPCallBackImp<T> {
    void succeed(T bean);

    void failed(String message);

}