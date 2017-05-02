package com.sihua.rxjava.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.sihua.rxjava.R;
import com.sihua.rxjava.activity.base.OpenriceSuperActivity;

/**
 * Created by sihuaxie on 17/5/2.
 */

public class LoginActivity extends OpenriceSuperActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.common_activity);
        LoginFragment fragment = LoginFragment.newInstance(new Bundle());
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment).commit();
    }
}
