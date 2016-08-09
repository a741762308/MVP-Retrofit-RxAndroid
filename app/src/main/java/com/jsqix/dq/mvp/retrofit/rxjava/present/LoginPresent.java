package com.jsqix.dq.mvp.retrofit.rxjava.present;

import com.jsqix.dq.mvp.retrofit.rxjava.C;
import com.jsqix.dq.mvp.retrofit.rxjava.data.api.Api;
import com.jsqix.dq.mvp.retrofit.rxjava.data.api.Md5;
import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.IpInfo;
import com.jsqix.dq.mvp.retrofit.rxjava.ui.contact.LoginContact;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.util.TreeMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observer;

/**
 * Created by dq on 2016/8/5.
 */
public class LoginPresent extends LoginContact.Presenter {

    @Override
    public void login(String name, String pass) {
        mRxManager.add(mModel.login(name, pass).subscribe(user -> {
                    mRxManager.post(C.EVENT_LOGIN, user);
                    mView.loginSuccess(user);
                }, throwable -> mView.showMsg("登录失败!")
        ));
    }

    @Override
    public void getIpInfo(String ip) {

        mModel.getIpInfo(ip).subscribe(new Observer<IpInfo>() {
            @Override
            public void onCompleted() {
                Logger.d("");
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("");
            }

            @Override
            public void onNext(IpInfo ipInfo) {
                Logger.d("");
                mView.getIpSucess(ipInfo);
            }
        });

    }

    @Override
    public void uploadHead(String path, String uid) {
        /*添加加密字符串*/
        TreeMap<String, Object> map = new TreeMap<>();
        map.put(uid, uid);
        String hmac = Md5.getSign(map, Api.PARA_KEY);

        File file = new File(path);
        RequestBody fileBody = RequestBody.create(Api.TYPE_IMAGE, file);
        MultipartBody.Part photo = MultipartBody.Part.createFormData("img", file.getName(), fileBody);
        mModel.uploadHead(photo, RequestBody.create(null, uid), RequestBody.create(null, hmac)).subscribe(baseBean ->
                mView.uploadSucess(), throwable -> mView.showMsg("上传失败"));
    }

    @Override
    public void start() {

    }
}
