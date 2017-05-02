package com.sihua.rxjava.biz.user;

import rx.Subscription;

/**
 * Created by sihuaxie on 17/5/2.
 */

public interface IUserBiz {
    Subscription login( String clientId,String clientSecret,String deviceId);
}
