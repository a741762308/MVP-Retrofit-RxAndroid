package com.jsqix.dq.mvp.retrofit.rxjava.present;

import com.jsqix.dq.mvp.retrofit.rxjava.model.BaseModel;
import com.jsqix.dq.mvp.retrofit.rxjava.rx.RxManager;
import com.jsqix.dq.mvp.retrofit.rxjava.ui.view.BaseView;

/**
 * Created by dq on 2016/8/5.
 */
public abstract class BasePresent<M extends BaseModel, V extends BaseView> {
    public M mModel;
    public V mView;
    public RxManager mRxManager = new RxManager();

    public void attachView(M model, V view) {
        this.mModel = model;
        this.mView = view;
        start();
    }

    public abstract void start();

    public void destroy() {
        mRxManager.clear();
    }

    public void detachView() {
        mModel = null;
        mView = null;
        destroy();
    }

}
