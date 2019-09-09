package com.startdon.resofveh.mvp.view;

/**
 * 描述：MVP基础view   桥接Activity
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 9:51
 * 修改人：
 * 修改时间：
 */
public interface BaseView {
    /**
     * 启动消息等待框
     * @param str
     */
    void showLoadProgressDialog(String str);

    /**
     * 关闭
     */
    void disDialog();

    /**
     * Toast提示
     * @param message
     */
    void showToast(String message);

}