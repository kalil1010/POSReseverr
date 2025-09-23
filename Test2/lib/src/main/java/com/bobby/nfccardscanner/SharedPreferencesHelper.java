package com.bobby.nfccardscanner;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class SharedPreferencesHelper {
    private static final String SHARED_PREF_NAME = "my_prefs";
    private static SharedPreferencesHelper instance;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    private SharedPreferencesHelper(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, 0);
        this.sharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public static synchronized SharedPreferencesHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesHelper(context.getApplicationContext());
        }
        return instance;
    }

    public void saveString(String key, String value) {
        this.editor.putString(key, value);
        this.editor.apply();
    }

    public String getString(String key, String defaultValue) {
        return this.sharedPreferences.getString(key, defaultValue);
    }

    public void removeKey(String key) {
        this.editor.remove(key);
        this.editor.apply();
    }

    public void clear() {
        this.editor.clear();
        this.editor.apply();
    }
}
