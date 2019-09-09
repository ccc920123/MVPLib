package com.startdon.resofveh.network;

import com.google.gson.JsonObject;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 描述： webservices请求的接口
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/3/15 10:19
 * 修改人：
 * 修改时间：
 */
public interface WebServicesInterface {
//可以添加请求头部

    //    @Headers({
//            "Content-Type: application/x-www-form-urlencoded"
//    })
    @POST
    Call<JsonObject> contributors(@Url String mothod, @Body RequestBody requestBodyBean);

    @GET
    Call<JsonObject> contributorsget(@Url String mothod);


    Observable<ResponseBody> download(@Header("RANGE") String downParam, @Url String url);


}