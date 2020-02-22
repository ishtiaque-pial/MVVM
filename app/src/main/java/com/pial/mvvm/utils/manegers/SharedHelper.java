package com.pial.mvvm.utils.manegers;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class SharedHelper {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Inject
    public SharedHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE);
    }

    public void putKey(String Key, String Value) {
        editor = sharedPreferences.edit();
        editor.putString(Key, Value);
        editor.apply();

    }


    public  void putLongKey(String Key, long Value) {
        editor = sharedPreferences.edit();
        editor.putLong(Key,Value);
        editor.apply();
    }
    public long getLongKey(String Key) {
        return sharedPreferences.getLong(Key, 0);

    }

    public void putIntKey(String Key, int Value) {
        editor = sharedPreferences.edit();
        editor.putInt(Key,Value);
        editor.apply();

    }

    public int getIntKey(String Key) {
        return sharedPreferences.getInt(Key, 0);

    }
    public void putKey(String Key, boolean Value) {
        editor = sharedPreferences.edit();
        editor.putBoolean(Key, Value);
        editor.apply();

    }

    public String getKey(Context contextGetKey, String Key) {
        sharedPreferences = contextGetKey.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        return sharedPreferences.getString(Key, "");

    }
    public boolean getBoolenKey(String Key) {
        return sharedPreferences.getBoolean(Key, false);

    }
    public void putDoubleKey(String Key, double Value) {
        editor = sharedPreferences.edit();
        editor.putString(Key, String.valueOf(Value));
        editor.apply();

    }
    public double getDoubleKey(String Key) {
        String temp="0";
        try{
            temp=sharedPreferences.getString(Key, "-1.0");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return -1.0f;
        }
        return Double.parseDouble(temp);

    }
    public void clearSharedPreferences() {
        sharedPreferences.edit().clear().apply();
    }
}
