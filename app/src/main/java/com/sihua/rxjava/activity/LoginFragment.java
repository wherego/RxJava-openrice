package com.sihua.rxjava.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.sihua.rxjava.R;
import com.sihua.rxjava.activity.base.OpenriceSuperFragment;

import butterknife.Bind;

/**
 * Created by sihuaxie on 17/5/2.
 */

public class LoginFragment extends OpenriceSuperFragment {
    private @Bind(R.id.loginButton) Button loginBtn;
    private  @Bind(R.id.userName) EditText userName;
    private  @Bind(R.id.password) EditText password;
    public static LoginFragment newInstance(Bundle args) {
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getRootViewLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {

    }

}
