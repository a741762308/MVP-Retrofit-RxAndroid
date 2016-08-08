package com.jsqix.dq.mvp.retrofit.rxjava.data.api;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.TreeMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dq on 2016/8/8.
 * 拦截器
 */
public class MyOkHttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        RequestBody body = original.body();
        Request.Builder requestBuilder = original.newBuilder();
        if (original.method().equals("GET")) {
            HttpUrl url = original.url();
            int size = url.querySize();
            if (size > 0) {
                TreeMap<String, Object> map = new TreeMap<>();
                for (int i = 0; i < size; i++) {
                    String key = url.queryParameterName(i);
                    String value = url.queryParameterValue(i);
                    map.put(key, value);
                }
                String sign = Md5.getSign(map, Api.PARA_KEY);
                url=url.newBuilder().addQueryParameter("hmac", sign).build();
                requestBuilder.url(url);
                requestBuilder.method(original.method(),body);
            }

        } else if (original.method().equals("POST")) {
            if(body instanceof FormBody){
                FormBody oldBody= (FormBody) body;
                FormBody.Builder newBody=new FormBody.Builder();
                TreeMap<String, Object> map = new TreeMap<>();
                for (int i = 0;i<oldBody.size();i++){
                    String key = oldBody.name(i);
                    String value = oldBody.value(i);
                    newBody.add(key,value);
                    map.put(key,value);
                }
                String sign = Md5.getSign(map, Api.PARA_KEY);
                newBody.add("hmac",sign);
                requestBuilder.method(original.method(),newBody.build());
            }
            else if(body instanceof MultipartBody){
//                MultipartBody oldBody= (MultipartBody) body;
//                int size=oldBody.size();
//                for(int i=0;i<size;i++)
//                {
//                    MultipartBody.Part part=oldBody.part(i);
//                }
            }

        }
        Request request = requestBuilder.build();
        Logger.d("url", request.url());
        return chain.proceed(request);
    }
}
