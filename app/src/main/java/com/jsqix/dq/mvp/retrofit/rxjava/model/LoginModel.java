package com.jsqix.dq.mvp.retrofit.rxjava.model;

import com.jsqix.dq.mvp.retrofit.rxjava.data.api.Api;
import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.IpInfo;
import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.UserBean;
import com.jsqix.dq.mvp.retrofit.rxjava.ui.contact.LoginContact;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dq on 2016/8/5.
 */
public class LoginModel implements LoginContact.Model {
    @Override
    public Observable<UserBean> login(String name, String pass) {
        return Api.getInstance().service
                .login_post(name, pass)
                .compose(RxSchedulers.io_main());
    }

    @Override
    public Observable<IpInfo> getIpInfo(String ip) {
        return Api.getInstance().service
                .getIpInfo_post(ip)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
