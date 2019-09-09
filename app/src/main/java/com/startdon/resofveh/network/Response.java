package com.startdon.resofveh.network;

/**
 * 描述：响应返回数据实体类
 * 公司：四川星盾科技股份有限公司
 * 编写人：陈渝金-pc:chenyujin
 * 时间： 2019/9/5 15:31
 * 修改人：
 * 修改时间：
 */
public class Response {

    private boolean success;//标记成功或失败

    private Object data;//返回的数据

    private int total;//分页查询返回信息总数

    public Response failure(){
        this.success = false;
        return this;
    }

    public Response failure(Object message){
        this.success = false;
        this.data = message;
        return this;
    }

    public Response success(){
        this.success = true;
        return this;
    }

    public Response success(Object message){
        this.success = true;
        this.data = message;
        return this;
    }

    public Response success(Object message,int total){
        this.success = true;
        this.data = message;
        this.total = total;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }

    public int getTotal() {
        return total;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
