package com.jsqix.dq.mvp.retrofit.rxjava.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jsqix.dq.mvp.retrofit.rxjava.model.BaseModel;
import com.jsqix.dq.mvp.retrofit.rxjava.present.BasePresent;
import com.jsqix.dq.mvp.retrofit.rxjava.ui.view.BaseView;
import com.jsqix.dq.mvp.retrofit.rxjava.util.TUtil;

import butterknife.ButterKnife;

/**
 * Created by dq on 2016/8/5.
 */
public abstract class BaseActivity<P extends BasePresent, M extends BaseModel> extends AppCompatActivity implements BaseView {
    public P mPresenter;
    public M mModel;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        mContext = this;
        mPresenter.attachView(mModel, this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

    }

    public abstract int getLayoutId();

    public abstract void initView();
}
