package com.arash.coffeecraftapp;

import android.app.Application;

import com.caverock.androidsvg.BuildConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class AppController extends Application {
    public FirebaseCrashlytics mCrashlytics;
    public FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mCrashlytics = FirebaseCrashlytics.getInstance();
        mCrashlytics.setCrashlyticsCollectionEnabled(true);

    mCrashlytics.setCustomKey("AppVersion", BuildConfig.APPLICATION_ID);
    }
}
