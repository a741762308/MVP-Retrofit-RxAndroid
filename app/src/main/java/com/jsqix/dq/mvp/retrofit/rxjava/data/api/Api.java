package com.jsqix.dq.mvp.retrofit.rxjava.data.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dq on 2016/8/5.
 */
public class Api {

    public static final String BASE_URL = "http://dw.jsqix.com/api/"/*"http://ip.taobao.com/"*/;
    public final static String PARA_KEY = "1732d45564733ae7ab7b7175cdd16071";
    public final static String PSW_KEY = "4d3bb9c3e6bb7d38ef0270050de8edc9";
    public final static String UTF_8 = "UTF-8";
    public static final int DEFAULT_TIMEOUT = 30;

    public Retrofit retrofit;
    public ApiService service;


    //构造方法私有
    private Api() {


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor())
                .addInterceptor(new MyOkHttpInterceptor())
                .build();


        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
//                .addConverterFactory(JsonConverterFactory.create(gson))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        service = retrofit.create(ApiService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final Api INSTANCE = new Api();
    }

    //获取单例
    public static Api getInstance() {
        return SingletonHolder.INSTANCE;
    }

}