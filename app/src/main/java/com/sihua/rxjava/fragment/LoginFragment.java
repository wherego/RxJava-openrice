package com.sihua.rxjava.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.sihua.rxjava.Constants;
import com.sihua.rxjava.R;
import com.sihua.rxjava.activity.HomeActivity;
import com.sihua.rxjava.activity.base.OpenriceSuperFragment;
import com.sihua.rxjava.application.OpenRiceApplication;
import com.sihua.rxjava.biz.user.IUserBiz;
import com.sihua.rxjava.biz.user.UserBizImpl;
import com.sihua.rxjava.model.OAuthModel;
import com.sihua.rxjava.utils.DeviceUtil;
import com.sihua.rxjava.viewBean.ILoginView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by sihuaxie on 17/5/2.
 */

public class LoginFragment extends OpenriceSuperFragment implements ILoginView {
    @Bind(R.id.userName)
    EditText userName;
    @Bind(R.id.password)
    EditText password;
    private IUserBiz userBiz;

    public static LoginFragment newInstance(Bundle args) {
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void loadData() {
        userBiz = new UserBizImpl(this);
    }

    @Override
    protected int getRootViewLayoutId() {
        return R.layout.fragment_login;
    }

    @OnClick(R.id.loginButton)
    void login() {
        showLoading();
        subscription = userBiz.login(Constants.APP_TYPE, Constants.CLIENT_SECRET, DeviceUtil.getDeviceUUID(OpenRiceApplication.getInstance()));
    }

    public void loginSuccess(OAuthModel aouthModel) {
        if (isActive()) {
            hideLoading();
            gotoHomeActivity();
        }
    }

    public void loginFailedError(int httpStatus, String errorMessage) {
        if (isActive()) {
            hideLoading();
        }
    }


    public String getPassword() {
        return password.getText().toString();
    }

    public String getUserName() {
        return userName.getText().toString();
    }

    private void gotoHomeActivity() {
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }


}
