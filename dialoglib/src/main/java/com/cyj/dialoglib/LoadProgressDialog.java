package com.cyj.dialoglib;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * 描述：消息等待框
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 15:11
 * 修改人：
 * 修改时间：
 */
public class LoadProgressDialog extends Dialog {


    static LoadProgressDialog instance;
    View view;
    TextView tvMessage;
    SplshView splshView;
    Context context;


    public static LoadProgressDialog getInstance(Context context) {
        if (instance != null && instance.isShowing()) {
            instance.dismissHUD();
        }
        instance = new LoadProgressDialog(context);
        return instance;
    }

    public LoadProgressDialog(Context context) {
        super(context, R.style.DialogTheme);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        this.setCanceledOnTouchOutside(true);
        this.setCancelable(true);
        this.context = context;
        view = getLayoutInflater().inflate(R.layout.dialog_progress, null);
        tvMessage = (TextView) view.findViewById(R.id.textview_message);
        splshView = (SplshView) view.findViewById(R.id.imageview_progress_spinner);

        this.setContentView(view);
    }


    public void setMessage(String message) {
        tvMessage.setText(message);
    }

    @Override
    public void show() {
        if (!((Activity) context).isFinishing()) {
            splshView = new SplshView(context);
            super.show();
        } else {
            instance = null;
        }
    }


    public void dismissHUD() {
        splshView.splshDisapaer();
        dismiss();

    }

}
