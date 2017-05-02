package com.sihua.rxjava.biz.user;

import com.sihua.rxjava.model.OAuthModel;
import com.sihua.rxjava.network.TokenNetwork;
import com.sihua.rxjava.viewBean.ILoginView;

import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sihuaxie on 17/5/2.
 */

public class UserBizImpl implements IUserBiz {

    private ILoginView loginView;

    public UserBizImpl(ILoginView loginView) {
        this.loginView = loginView;
    }


    @Override
    public Subscription login(String clientId, String clientSecret, String deviceId) {
        return TokenNetwork.getOpenriceApi().reGrantOAuth2Authorize(loginView.getUserName(),loginView.getPassword(),"password",clientId,clientSecret,deviceId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OAuthModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if(e!=null && (e instanceof HttpException)){
                            HttpException exception = (HttpException) e;
                            loginView.loginFailedError(exception.code(),exception.message());
                        }

                    }

                    @Override
                    public void onNext(OAuthModel oAuthModel) {
                        loginView.loginSuccess(oAuthModel);
                    }
                });
    }
}
