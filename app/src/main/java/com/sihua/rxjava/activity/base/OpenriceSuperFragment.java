package com.sihua.rxjava.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by sihuaxie on 17/5/2.
 */

public abstract class OpenriceSuperFragment extends Fragment {
    protected Subscription subscription;
    protected int mRegionID = 0;
    protected int mCountryId = 1;
    protected View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getRootViewLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    protected abstract int getRootViewLayoutId();


    protected  void loadData(){

    }

    protected OpenriceSuperActivity getOpenRiceSuperActivity() {
        try {
            return (OpenriceSuperActivity) getActivity();
        } catch (Exception e) {
            return null;
        }
    }

    public synchronized boolean isActive() {
        return getActivity() != null && !getActivity().isFinishing() && isAdded() && !isRemoving();
    }

    protected void showLoading(){
        getOpenRiceSuperActivity().showProgressDialog(null,false);
    }


    protected void hideLoading(){
        getOpenRiceSuperActivity().hideProgress();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
