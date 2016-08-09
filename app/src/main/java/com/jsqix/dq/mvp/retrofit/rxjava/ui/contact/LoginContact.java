package com.jsqix.dq.mvp.retrofit.rxjava.ui.contact;

import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.BaseBean;
import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.IpInfo;
import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.UserBean;
import com.jsqix.dq.mvp.retrofit.rxjava.model.BaseModel;
import com.jsqix.dq.mvp.retrofit.rxjava.present.BasePresent;
import com.jsqix.dq.mvp.retrofit.rxjava.ui.view.BaseView;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by dq on 2016/8/5.
 */
public interface LoginContact {
    interface Model extends BaseModel {
        Observable<UserBean> login(String name, String pass);

        Observable<IpInfo> getIpInfo(String ip);

        Observable<BaseBean> uploadHead(MultipartBody.Part photo, RequestBody body,RequestBody hmac);
    }

    interface View extends BaseView {
        void loginSuccess(UserBean user);

        void getIpSucess(IpInfo ipInfo);

        void uploadSucess();
    }

    abstract class Presenter extends BasePresent<Model, View> {
        public abstract void login(String name, String pass);

        public abstract void getIpInfo(String ip);

        public abstract void uploadHead(String path, String uid);
    }
}
