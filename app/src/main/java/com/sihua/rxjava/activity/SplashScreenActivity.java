package com.sihua.rxjava.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sihua.rxjava.R;
import com.sihua.rxjava.activity.base.OpenriceSuperActivity;
import com.sihua.rxjava.application.OpenRiceApplication;
import com.sihua.rxjava.model.OAuthModel;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by sihuaxie on 17/5/3.
 */

public class SplashScreenActivity extends OpenriceSuperActivity {

    private ImageView imageView;

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        setContentView(R.layout.activity_splash_screen);
        imageView = (ImageView) findViewById(R.id.splash_screen);
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493786590705&di=77c27709cf640aa842b77ee11fc53432&imgtype=0&src=http%3A%2F%2Fs13.sinaimg.cn%2Fmw690%2F005G4DkNgy6RSxcwGFS6c%26690")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        setTitle("SplashScreen");
        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        }, 3000);

    }

    private void loadData() {
        queryLoginInfo();
    }

    private void queryLoginInfo() {
        Realm realm = Realm.getDefaultInstance();
        realm.where(OAuthModel.class).findAll()
                .asObservable()
                .flatMap(new Func1<RealmResults<OAuthModel>, Observable<OAuthModel>>() {
                    @Override
                    public Observable<OAuthModel> call(RealmResults<OAuthModel> users) {
                        if (users.size() == 0) {
                            gotoLogin();
                            return null;
                        } else
                            return Observable.from(users);
                    }
                })
                .subscribe(new Action1<OAuthModel>() {
                    @Override
                    public void call(OAuthModel user) {
                        if (user != null) {
                            OpenRiceApplication.getInstance().setoAuthModel(user);
                            gotoHome();
                        } else {
                            gotoLogin();
                        }
                        onBackPressed();
                    }
                });
    }

    private void gotoHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
