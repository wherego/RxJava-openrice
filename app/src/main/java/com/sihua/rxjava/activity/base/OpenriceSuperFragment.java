package com.sihua.rxjava.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sihua.rxjava.R;

import butterknife.ButterKnife;

/**
 * Created by sihuaxie on 17/5/2.
 */

public abstract class OpenriceSuperFragment extends Fragment {
    protected int mRegionID = 0;
    protected int mCountryId = 1;
    private View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getRootViewLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    protected abstract int getRootViewLayoutId();

    protected abstract void initView();

    protected  void loadData(){

    }

}
