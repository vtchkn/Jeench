package com.example.evetochkin.jeench.util;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TypefaceUtil {

    public static Typeface getTypeface(Context context, String fontName) {
        return Typeface.createFromAsset(context.getAssets(), "fonts/" + fontName);
    }

    public static void overrideFont(Context context, String defaultFont, String customFont) {
        final Typeface customTypeface = Typeface.createFromAsset(context.getResources().getAssets(), "fonts/" + customFont);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Map<String, Typeface> map = new HashMap<>();
            map.put(defaultFont, customTypeface);
            try {
                final Field staticField = Typeface.class.getDeclaredField("sSystemFontMap");
                staticField.setAccessible(true);
                staticField.set(null, map);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            try {
                final Field defaultFontTypefaceField = Typeface.class.getDeclaredField(defaultFont);
                defaultFontTypefaceField.setAccessible(true);
                defaultFontTypefaceField.set(null, customFont);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    public static void overrideFont(Context context, Map<String,String> fonts) {
        Map<String, Typeface> map = new HashMap<>();
        for (Map.Entry<String, String> entry : fonts.entrySet()) {
            Typeface customTypeface = Typeface.createFromAsset(context.getResources().getAssets(), "fonts/" + entry.getValue());
            String defaultFont = entry.getKey();
            map.put(defaultFont, customTypeface);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                final Field staticField = Typeface.class.getDeclaredField("sSystemFontMap");
                staticField.setAccessible(true);
                staticField.set(null, map);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            for (Map.Entry<String, Typeface> entry : map.entrySet()) {
                try {
                    Field defaultFontTypefaceField = Typeface.class.getDeclaredField(entry.getKey());
                    defaultFontTypefaceField.setAccessible(true);
                    defaultFontTypefaceField.set(null, entry.getValue());
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}