package com.sihua.rxjava.activity;

import android.os.Bundle;

import com.sihua.rxjava.R;
import com.sihua.rxjava.base.OpenriceSuperActivity;
import com.sihua.rxjava.fragment.LoginFragment;

/**
 * Created by sihuaxie on 17/5/2.
 */

public class LoginActivity extends OpenriceSuperActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.common_activity);
        LoginFragment fragment = LoginFragment.newInstance(new Bundle());
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment).commit();
    }
}
