package com.mvp.mvptemplateproject.injection;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mvp.mvptemplateproject.model.rest.ApiService1;
import com.mvp.mvptemplateproject.model.rest.ApiService2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by grishberg on 09.10.16.
 */
@Module
public class RestModule {
    private static final String TAG = RestModule.class.getSimpleName();
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private String mBaseUrl;

    // Constructor needs one parameter to instantiate.
    public RestModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        final Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setDateFormat(DATE_PATTERN)
                .create();
        return gson;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {

        OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                //.addInterceptor(interceptor)
                .build();
        return defaultHttpClient;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    ApiService1 provideApiService1(Retrofit retrofit) {
        return retrofit.create(ApiService1.class);
    }

    @Provides
    @Singleton
    ApiService2 provideApiService2(Retrofit retrofit) {
        return retrofit.create(ApiService2.class);
    }
}