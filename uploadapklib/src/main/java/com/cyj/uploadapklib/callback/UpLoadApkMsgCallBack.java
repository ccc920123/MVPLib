package com.cyj.uploadapklib.callback;

/**
 * 描述： 下载界面 操作失败的提示接口，暴露给开发着使用
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/6
 * 修改人：
 * 修改时间：
 */


public interface UpLoadApkMsgCallBack {

    void UploadErrorAlert(String msg);
    void UploadingOnBackAlert(String msg);


}
