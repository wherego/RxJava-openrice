package com.sihua.rxjava.viewBean;

import com.sihua.rxjava.model.OAuthModel;

/**
 * Created by sihuaxie on 17/5/2.
 */

public interface ILoginView {
    String getUserName();
    String getPassword();
    void loginFailedError(int httpStatus,String errorMessage);
    void loginSuccess(OAuthModel oAuthModel);
}
