package com.startdon.resofveh.mvp.view;

/**
 * 描述：test
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5
 * 修改人：
 * 修改时间：
 */


public interface TestView extends BaseView {
    //成功的数据
    void dataSucced(Object bean);
    //其他的数据
    void daatOther(String message);
}
