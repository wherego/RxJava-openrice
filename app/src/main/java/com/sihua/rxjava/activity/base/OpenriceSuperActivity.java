package com.sihua.rxjava.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sihua.rxjava.R;

/**
 * Created by sihuaxie on 17/5/2.
 */

public abstract class OpenriceSuperActivity extends AppCompatActivity {
    protected int mRegionID = 0;
    protected int mCountryId = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
    }

    protected abstract void initView(Bundle savedInstanceState);
    protected OpenriceProgressDialogFragment progressDialogFragment = null;
    public void showProgressDialog(String messageStr, boolean isCancelable) {

        if (!isFinishing()) {
            if (getSupportFragmentManager().findFragmentByTag(OpenriceProgressDialogFragment.class.getName()) != null) {
                progressDialogFragment = (OpenriceProgressDialogFragment) getSupportFragmentManager().findFragmentByTag(OpenriceProgressDialogFragment.class.getName());
                progressDialogFragment.dismiss();
            }
            progressDialogFragment = OpenriceProgressDialogFragment.newInstance(messageStr, isCancelable);
            getSupportFragmentManager().beginTransaction().add(progressDialogFragment, OpenriceProgressDialogFragment.class.getName()).commitAllowingStateLoss();
        }


    }
    public void hideProgress() {
        if (progressDialogFragment!=null && getSupportFragmentManager().findFragmentByTag(OpenriceProgressDialogFragment.class.getName()) != null)  {
            progressDialogFragment.dismiss();
        }
    }

    public synchronized void showConnectionError(int httpStatus, View.OnClickListener onClickListener) {
        if (findViewById(R.id.container) != null && !isFinishing()) {
            ConnectionErrorFragment connectionErrorFragment = ConnectionErrorFragment.newInstance(httpStatus, null);
            connectionErrorFragment.setOnClickListener(onClickListener);
            getSupportFragmentManager().beginTransaction().add(R.id.container,
                    connectionErrorFragment, ConnectionErrorFragment.class.getName()).commitAllowingStateLoss();
        }
    }

    public synchronized void showConnectionError(String title, String message, String buttonLabel, View.OnClickListener onClickListener) {
        if (findViewById(R.id.container) != null && !isFinishing()) {
            ConnectionErrorFragment connectionErrorFragment = ConnectionErrorFragment.newInstance(title, message, buttonLabel);
            connectionErrorFragment.setOnClickListener(onClickListener);
            getSupportFragmentManager().beginTransaction().add(R.id.container,
                    connectionErrorFragment, ConnectionErrorFragment.class.getName()).commitAllowingStateLoss();
        }
    }
}
