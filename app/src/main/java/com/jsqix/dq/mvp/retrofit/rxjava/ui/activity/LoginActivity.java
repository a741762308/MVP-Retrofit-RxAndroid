package com.jsqix.dq.mvp.retrofit.rxjava.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jsqix.dq.mvp.retrofit.rxjava.R;
import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.IpInfo;
import com.jsqix.dq.mvp.retrofit.rxjava.data.bean.UserBean;
import com.jsqix.dq.mvp.retrofit.rxjava.model.LoginModel;
import com.jsqix.dq.mvp.retrofit.rxjava.present.LoginPresent;
import com.jsqix.dq.mvp.retrofit.rxjava.ui.base.BaseActivity;
import com.jsqix.dq.mvp.retrofit.rxjava.ui.contact.LoginContact;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresent, LoginModel> implements LoginContact.View {


    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_pass)
    EditText inputPass;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.result_content)
    TextView resultContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        inputName.setText("18662539527");
        inputPass.setText("919395");

    }

    @OnClick(R.id.btn_submit)
    void submit() {
//        mPresenter.login(inputName.getText().toString(), Md5.getMD5(inputPass.getText().toString() + Api.PSW_KEY, Api.UTF_8));
//        mPresenter.getIpInfo("221.224.198.229");
        mPresenter.uploadHead("/sdcard/DCIM/IMG_1482018674.jpg","10");
    }


    @Override
    public void loginSuccess(UserBean user) {
        resultContent.setText(new Gson().toJson(user));
    }

    @Override
    public void getIpSucess(IpInfo ipInfo) {
        Logger.d("");
        resultContent.setText(new Gson().toJson(ipInfo));
    }

    @Override
    public void uploadSucess() {

    }
}
