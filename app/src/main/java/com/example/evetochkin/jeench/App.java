package com.example.evetochkin.jeench;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import com.crashlytics.android.Crashlytics;
import com.example.evetochkin.jeench.util.Currency;
import com.example.evetochkin.jeench.util.TypefaceUtil;

import io.fabric.sdk.android.Fabric;
import java.util.HashMap;
import java.util.Map;

public class App extends Application {
    private Map<String, String> typefaces = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        fontInit();
        TypefaceUtil.overrideFont(this, typefaces);
    }
    private void fontInit() {
        typefaces.put("serif", "arial.ttf");
        typefaces.put("sans-serif", "Verdana.ttf");
    }

    public static String currencyParser(String price, Currency currency) {
        return currency.getCurrency() + price;
    }
}
