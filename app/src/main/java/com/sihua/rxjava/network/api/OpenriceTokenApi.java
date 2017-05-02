package com.sihua.rxjava.network.api;

import com.sihua.rxjava.model.OAuthModel;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by sihuaxie on 17/5/2.
 */

public interface OpenriceTokenApi {
    @POST("/oauth2/token")
    @FormUrlEncoded
    Observable<OAuthModel> reGrantOAuth2Authorize(@Field("userName") String userName,@Field("password") String password,@Field("grant_type") String type);
}
