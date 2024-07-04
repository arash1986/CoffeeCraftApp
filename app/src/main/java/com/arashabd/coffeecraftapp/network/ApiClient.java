package com.arashabd.coffeecraftapp.network;


import android.content.Context;

import com.arashabd.coffeecraftapp.utils.Constants;
import com.arashabd.coffeecraftapp.utils.DialogBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    private static retrofit2.Retrofit retrofit = null;

    public static ApiInterface getClient(Context context, String content) {

        DialogBuilder.INSTANCE.initProgressDialog(context, content);

        if (retrofit == null) {

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(Constants.BASEURL  )
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
}