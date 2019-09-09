package com.startdon.resofveh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cyj.dialoglib.AlertDialog;
import com.cyj.uploadapklib.UpLoadApkDialogActivity;
import com.cyj.uploadapklib.UpLoadApkUIActivity;
import com.cyj.uploadapklib.callback.UpLoadApkMsgCallBack;

public class MainActivity extends AppCompatActivity implements UpLoadApkMsgCallBack {


    private String url = "http://imtt.dd.qq.com/16891/D60D4D5B9B7756F51BC42E06657FAFB0.apk?fsname=com.tencent.mobileqq_7.7.0_882.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AlertDialog(this).builder().setTitle("升级提示")
                .setMsg("有新版本需要升级了")
                .setPositiveButton("下载", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //页面型的下载
                        UpLoadApkUIActivity.statAction(MainActivity.this,
                                "1.1.0", "code提交<br/>1.test数据<br/>2.权限问题修改",
                                url, "QQ");

                        //dialog 型的下载
//                        UpLoadApkDialogActivity.statAction(MainActivity.this,url,"QQ");
//
                    }
                }).show();


    }

    @Override
    public void UploadErrorAlert(String msg) {
        new AlertDialog(this).builder().setMsg(msg).show();

    }

    @Override
    public void UploadingOnBackAlert(String msg) {
        new AlertDialog(this).builder().setMsg(msg).show();
    }
}
