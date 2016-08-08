package com.jsqix.dq.mvp.retrofit.rxjava.data.api;

import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.IpInfo;
import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.UserBean;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dq on 2016/8/5.
 */
public interface ApiService {
    @GET("userLogin")
    Observable<UserBean> login(@Query("acct") String username, @Query("pwd") String password);

    @FormUrlEncoded
    @POST("userLogin")
    Observable<UserBean> login_post(@Field("acct") String username, @Field("pwd") String password);

    @GET("service/getIpInfo.php")
    Observable<IpInfo> getIpInfo(@Query("ip") String ip);

    @FormUrlEncoded
    @POST("service/getIpInfo.php")
    Observable<IpInfo> getIpInfo_post(@Field("ip") String ip);

    /**
     * 单文件上传
     * RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/png"), file);
     * MultipartBody.Part photo = MultipartBody.Part.createFormData("photos", "icon.png", photoRequestBody);
     */

    @Multipart
    @POST("register")
    Observable<UserBean> registerUser(@Part MultipartBody.Part photo, @Part("acct") RequestBody username, @Part("pwd") RequestBody password);

    /**
     * 多文件上传
     * params可以是多个文件，也可是文件与参数混合
     * RequestBody photo = RequestBody.create(MediaType.parse("image/png", file);
     * Map<String,RequestBody> photos = new HashMap<>();
     * photos.put("photos\"; filename=\"icon.png", photo);
     * photos.put("username",  RequestBody.create(null, "abc"));
     */
    @Multipart
    @POST("userLogin")
    Observable<UserBean> registerUser(@PartMap Map<String, RequestBody> params, @Part("acct") RequestBody username, @Part("pwd") RequestBody password);
}
