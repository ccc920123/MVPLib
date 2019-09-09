package com.startdon.resofveh.network;

import android.content.Context;

import com.cyj.dialoglib.LoadProgressDialog;
import com.google.gson.JsonObject;
import com.startdon.resofveh.comm.Comm;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chenpan on 2019/3/14.
 */

public class NetWork {
    /**
     * @param context
     * @param mothod         请求的方法
     * @param type           请求类型    0---post，1---get
     * @param gson           webservice 参数
     * @param resultCallback 返回结果 new resultCallback
     */
    public static void callNetWorkQuery(Context context, int type, String mothod, String gson, final ResultCallback<JsonObject> resultCallback) {
        if (type == 0) { //post
            callPostNetWork(context, mothod, gson, resultCallback);
        } else {//get

            callGetNetWork(context, mothod, resultCallback);

        }
    }

    /**
     * get请求
     *
     * @param context
     * @param mothod
     * @param resultCallback
     */
    private static void callGetNetWork(final Context context, String mothod, final ResultCallback<JsonObject> resultCallback) {
        if (context != null) {
            LoadProgressDialog.getInstance(context).show();
        }

        String url = Comm.IP;  //这里是测试ip
        // 初始化Retrofit
        //G
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServicesInterface apiStore = retrofit.create(WebServicesInterface.class);

        Call<JsonObject> call = apiStore.contributorsget(mothod);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (context != null) {
                    LoadProgressDialog.getInstance(context).dismissHUD();//关闭等待框
                }
                resultCallback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                resultCallback.onError(t.getMessage());
                if (context != null) {
                    LoadProgressDialog.getInstance(context).dismissHUD();
                }
            }
        });
    }

    /**
     * post 请求数据
     *
     * @param context
     * @param mothod
     * @param requestBodyBean
     * @param resultCallback
     */
    private static void callPostNetWork(final Context context, String mothod, String requestBodyBean, final ResultCallback<JsonObject> resultCallback) {
//        if (context != null) {
//            LoadProgressDialog.getInstance(context).show();
//        }

        String url = Comm.IP;  //这里是测试ip
        // 初始化Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
//                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServicesInterface apiStore = retrofit.create(WebServicesInterface.class);
        MediaType json = MediaType.parse("application/json; charset=utf-8");

        RequestBody requestBody = RequestBody.create(json, requestBodyBean);
        Call<JsonObject> call = apiStore.contributors(mothod, requestBody);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                Log.d(TAG, "onResponse: result : " + response.body());
                if (context != null) {
                    LoadProgressDialog.getInstance(context).dismissHUD();//关闭等待框
                }
                resultCallback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                resultCallback.onError(t.getMessage());
                if (context != null) {
                    LoadProgressDialog.getInstance(context).dismissHUD();
                }
            }
        });
    }

}
