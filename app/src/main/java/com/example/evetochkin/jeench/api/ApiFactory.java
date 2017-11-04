package com.example.evetochkin.jeench.api;

import com.example.evetochkin.jeench.BuildConfig;
import okhttp3.OkHttpClient;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public final class ApiFactory {
    private static OkHttpClient mClient;

    private static JeenchService mService;

    public static JeenchService getService() {
        JeenchService service = mService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = mService;
                if (service == null) {
                    service = mService = createService();
                }
            }
        }
        return service;
    }

    private static JeenchService createService() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(JeenchService.class);
    }

    private static OkHttpClient getClient() {
        OkHttpClient client = mClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = mClient;
                if (client == null) {
                    client = mClient = buildClient();
                }
            }
        }
        return client;
    }

    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE))
                .build();
    }
}
