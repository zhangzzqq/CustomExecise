//package com.example.zq.util;
//
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//
//import java.io.File;
//import java.util.Arrays;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import cn.edu.zafu.bmobdemo.BuildConfig;
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.RequestBody;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
///**
// * Created by stevenZhang on 2017/1/13.
// */
//
//public class RetrofitApi<T > {
//
//    public static int TYPE_NORMAL = 0 ;
//    public static int TYPE_LIST = 1;
//    public static int TYPE_MODEL = 2 ;
//    public static int TYPE_POST = 3;
//
//    public static OkHttpClient okHttpClient;
//
//    static {
//        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
//        if (BuildConfig.DEBUG) {
//            okHttpBuilder.addNetworkInterceptor(new StethoInterceptor());
//            //            okHttpBuilder.addInterceptor(new HttpLoggingInterceptor());
//            okHttpBuilder.addInterceptor( new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//                @Override
//                public void log(String message) {
//                    KLog.i("OkHttp", message);
//                }
//            }).setLevel(HttpLoggingInterceptor.Level.BODY));//网络和日志拦截
//        }
//        okHttpBuilder.connectTimeout(OkHttpHandle.TIME_OUT, TimeUnit.SECONDS).readTimeout(OkHttpHandle.TIME_OUT, TimeUnit.SECONDS).writeTimeout(OkHttpHandle.TIME_OUT, TimeUnit.SECONDS);//设置请求超时
//        okHttpClient = okHttpBuilder.build();
//    }
//
//    private static final Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://com.base.url/")
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//
//    private static RetrofitApi retrofitApi;
//
//    public static RetrofitApi getInstance() {
//        if (null == retrofitApi) return new RetrofitApi();
//        return retrofitApi;
//    }
//
//    public void getNormal(String url, Map<String, String> map, final OkHttpHandle.CallbackListener listener) {
//        callEnqueue(TYPE_NORMAL, null, url, map, listener);
//    }
//
//    public void getList(final Class<T> tClass, String url, Map<String, String> map, final OkHttpHandle.CallbackListener listener) {
//        callEnqueue(TYPE_LIST, tClass, url, map, listener);
//    }
//
//    public void getModel(final Class<T> tClass, String url, Map<String, String> map, final OkHttpHandle.CallbackListener listener) {
//        callEnqueue(TYPE_MODEL, tClass, url, map, listener);
//    }
//
//    public void postData(String url, Map<String, String> map, final OkHttpHandle.CallbackListener listener) {
//        callEnqueue(TYPE_POST , null, url, map, listener);
//    }
//
//    public void callEnqueue(final int type, final Class< T> tClass, String url, Map<String, String> map, final OkHttpHandle.CallbackListener listener) {
//        Call<JsonObject> call;
//        if (type == TYPE_POST) {//POST
//            call = ((RetrofitService) retrofit.create(RetrofitService.class)).postData(url, map);
//        } else {//GET
//            call = ((RetrofitService) retrofit.create(RetrofitService.class)).getData(url, map);
//        }
//        call.enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                if (response.code() == 200) {
//                    try {
//                        JsonObject json = response.body();
//
//                        if (json.get( "status").getAsInt() >= 0 ) {
//
//                            if ( type == TYPE_LIST) { //列表
//
//                                JsonObject result = json.getAsJsonObject("result");
//                                JsonArray jsonArray = result.getAsJsonArray("list" );
//
//                                listener.onSuccess(Arrays. asList(new GsonBuilder().create().fromJson(jsonArray, (Class< T[]>) tClass)), result.get("total" ).getAsString());
//
//                            } else if ( type == TYPE_MODEL) { //单个对象
//
//                                JsonObject result = json.getAsJsonObject("result");
//                                listener.onSuccess( new GsonBuilder().create().fromJson(result, tClass), json.get("message" ).getAsString());
//
//                            } else { //普通JsonObject
//
//                                if (json.has( "result") && json.get("result" ).isJsonObject()) {
//                                    listener.onSuccess(json.getAsJsonObject("result"), json.get("message" ).getAsString());
//                                } else {
//                                    listener.onSuccess( null, json.get("message" ).getAsString());
//                                }
//                            }
//
//                        } else {
//                            listener.onFail(json.get( "message").getAsString());
//                        }
//                    } catch (Exception e) {
//                        listener.onFail(AppUtil. getRequestException());
//                    }
//                } else {
//                    listener.onFail(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//                listener.onFail(AppUtil.getRequestException());
//            }
//        });
//    }
//
//    public void uploadFile(String url, Map<String, RequestBody> map, final OkHttpHandle.CallbackListener listener) {
//        Call<JsonObject> call = ((RetrofitService) retrofit.create(RetrofitService.class)).uploadFile(url, map);
//        call.enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                if (response.code() == 200) {
//                    try {
//                        JsonObject json = response.body();
//
//                        if (json.get( "status").getAsInt() >= 0 ) {
//                            if (json.has( "result") && json.get("result" ).isJsonObject()) {//单张图片 -返回图片路径
//
//                                //                                listener.onSuccess(json.getAsJsonObject("result"), json.get("message").getAsString());
//
//                                JsonObject result = json.getAsJsonObject("result" );
//                                if (result.has( "url")) {
//                                    listener.onSuccess(result.get("url").getAsString(), json.get("message" ).getAsString());
//
//                                } else {
//                                    listener.onSuccess( null, json.get("message" ).getAsString());
//                                }
//                            } else {
//                                listener.onSuccess( null, json.get("message" ).getAsString());
//                            }
//                        } else {
//                            listener.onFail(json.get( "message").getAsString());
//                        }
//                    } catch (Exception e) {
//                        listener.onFail(AppUtil. getRequestException());
//                    }
//                } else {
//                    listener.onFail(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//                listener.onFail(AppUtil.getRequestException());
//            }
//        });
//    }
//
//    public RequestBody parseRequestBody(String value) {
//        return RequestBody.create(MediaType. parse("text/plain"), value);
//    }
//
//    public RequestBody parseImageRequestBody(File file) {
//        return RequestBody.create(MediaType. parse("image/jpg"), file);
//    }
//
//    public String parseImageMapKey(String key, String fileName) {
//        return key + "\"; filename=\"" + fileName;
//    }
//}
