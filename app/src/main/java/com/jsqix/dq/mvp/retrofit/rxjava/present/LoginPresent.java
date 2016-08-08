package com.jsqix.dq.mvp.retrofit.rxjava.present;

import com.jsqix.dq.mvp.retrofit.rxjava.C;
import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.IpInfo;
import com.jsqix.dq.mvp.retrofit.rxjava.ui.contact.LoginContact;
import com.orhanobut.logger.Logger;

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
                }, e -> mView.showMsg("登录失败!")
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
    public void start() {

    }
}
