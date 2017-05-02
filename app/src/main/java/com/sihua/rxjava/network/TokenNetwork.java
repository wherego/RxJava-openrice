package com.sihua.rxjava.network;

import android.content.Context;
import android.provider.Settings;

import com.sihua.rxjava.application.OpenRiceApplication;
import com.sihua.rxjava.network.api.OpenriceApi;
import com.sihua.rxjava.network.api.OpenriceTokenApi;
import com.sihua.rxjava.utils.DeviceUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sihuaxie on 17/5/2.
 */

public class TokenNetwork {
    public static final String BASE_URL = "http://stagingbak.api2.openrice.com/";
    private static OkHttpClient okHttpClient ;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static Retrofit retrofit;
    public static OpenriceTokenApi openriceApi;

    static {
        okHttpClient = genericClient();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
    }


    public static OpenriceTokenApi getOpenriceApi(){
        if(openriceApi == null){
            retrofit.create(OpenriceApi.class);
        }
        return openriceApi;
    }


    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        String cnVersion = "";
                        String header = "Openrice" + cnVersion + "_Android/" + "5.6" + " (Android; " + android.os.Build.VERSION.SDK_INT + ")";
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                        String currentDatTime = sdf.format(new Date());
                        String deviceId = DeviceUtil.getDeviceUUID(OpenRiceApplication.getInstance());
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                .addHeader("Connection", "keep-alive")
                                .addHeader("User-Agent", header)
                                .addHeader("Accept-Language", "US-EN")
                                .addHeader("X-SendDate", currentDatTime)
                                .addHeader("X-deviceId", deviceId)
                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();

        return httpClient;
    }
}
