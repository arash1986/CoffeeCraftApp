package com.arash.coffeecraftapp.network;


import android.content.Context;

import com.arash.coffeecraftapp.activity.BaseActivity;
import com.arash.coffeecraftapp.utils.Constants;
import com.arash.coffeecraftapp.utils.DialogBuilder;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    private static retrofit2.Retrofit retrofit = null;
    private static retrofit2.Retrofit retrofit2 = null;
    private static retrofit2.Retrofit retrofitWithoutToken = null;
    private retrofit2.Retrofit retrofitVideoUpload;

    public static ApiInterface getClient(Context context, String content) {

        DialogBuilder.INSTANCE.initProgressDialog(context, content);

        if (retrofit == null) {

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(Constants.Base_Url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient().newBuilder()
                            .readTimeout(15, TimeUnit.SECONDS)
                            .callTimeout(15, TimeUnit.SECONDS)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .addInterceptor(new VersionInterceptor())
                            .addInterceptor(new TokenInterceptor(context))
                            .addInterceptor(new RetrofitErrorHandler(context))
                            .build())
                    .build();

        }
        return retrofit.create(ApiInterface.class);
    }


//    public static ApiInterface getClientV2(SessionManager sessionManager) {
//
//        if (retrofit2 == null) {
//            HttpLoggingInterceptor logIn = new HttpLoggingInterceptor();
//            logIn.setLevel(HttpLoggingInterceptor.Level.BODY);
//            retrofit2 = new retrofit2.Retrofit.Builder()
//                    .baseUrl(Constants.Base_Url)
//                    .addConverterFactory(ScalarsConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(new OkHttpClient().newBuilder()
//                            .readTimeout(15, TimeUnit.SECONDS)
//                            .callTimeout(15, TimeUnit.SECONDS)
//                            .connectTimeout(15, TimeUnit.SECONDS)
//                            .writeTimeout(15, TimeUnit.SECONDS)
//                            .addInterceptor(new TokenInterceptor(sessionManager))
//                            .addInterceptor(new VersionInterceptor())
//                            .addInterceptor(logIn)
//                            .build())
//                    .build();
//
//        }
//        return retrofit2.create(ApiInterface.class);
//    }

//    public static ApiInterface getClientV1WithToken(SessionManager sessionManager) {
//
//        if (retrofitWithoutToken == null) {
//            HttpLoggingInterceptor logIn = new HttpLoggingInterceptor();
//            logIn.setLevel(HttpLoggingInterceptor.Level.BODY);
//            retrofitWithoutToken = new retrofit2.Retrofit.Builder()
//                    .baseUrl(Constant.BASE_URL)
//                    .addConverterFactory(ScalarsConverterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(new OkHttpClient().newBuilder()
//                            .readTimeout(15, TimeUnit.SECONDS)
//                            .callTimeout(15, TimeUnit.SECONDS)
//                            .connectTimeout(15, TimeUnit.SECONDS)
//                            .writeTimeout(15, TimeUnit.SECONDS)
//                            .addInterceptor(new TokenInterceptor(sessionManager))
//                            .addInterceptor(new VersionInterceptor())
//                            .addInterceptor(logIn)
//                            .build())
//                    .build();
//
//        }
//        return retrofitWithoutToken.create(ApiInterface.class);
//    }

    public ApiInterface buildAndGetClientForVideoUpload() {

        if (retrofitVideoUpload == null) {

            retrofitVideoUpload = new retrofit2.Retrofit.Builder()
                    .baseUrl(Constants.Base_Url)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient().newBuilder()
                            .readTimeout(2, TimeUnit.MINUTES)
                            .callTimeout(2, TimeUnit.MINUTES)
                            .connectTimeout(2, TimeUnit.MINUTES)
                            .writeTimeout(2, TimeUnit.MINUTES)
                            .build())
                    .build();

        }
        return retrofitVideoUpload.create(ApiInterface.class);
    }
}