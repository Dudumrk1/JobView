package com.liveperson.hackathon.jobview.jobview.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Set;

/**
 * A utility class that wraps Android SharedPreferences
 */
public class PreferenceManager {

    private static final String TAG = PreferenceManager.class.getSimpleName();
    private static final String JB_SHARED_FILENAME = "jb_shared";


    private static volatile SharedPreferences mPreferences;
    private static volatile PreferenceManager Instance = null;


    private PreferenceManager(Context applicationContext) {
        mPreferences = applicationContext.getSharedPreferences(JB_SHARED_FILENAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (Instance == null) {
            Instance = new PreferenceManager(context);
        }
    }

    public static synchronized PreferenceManager getInstance() {
        if (Instance == null) {
            throw new IllegalStateException(PreferenceManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return Instance;
    }


    /**
     * Setting long value
     *
     * @param key
     * @param value
     */
    public void setLongValue(String key, long value) {
        mPreferences.edit().putLong(key, value).apply();
    }


    /**
     * Getting long value
     *
     * @param key
     * @param defValue
     * @return
     */
    public long getLongValue(String key, long defValue) {
        return mPreferences.getLong(key, defValue);
    }


    /**
     * @param key
     * @param value
     */
    public void setBooleanValue(String key, boolean value) {
        mPreferences.edit().putBoolean(key, value).apply();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public boolean getBooleanValue(String key, boolean defValue) {
        return mPreferences.getBoolean(key, defValue);
    }


    /**
     * @param key
     * @param defValue
     * @return
     */
    public boolean getLongValue(String key, boolean defValue) {
        return mPreferences.getBoolean(key, defValue);
    }

    /**
     * @param defValues
     * @param key
     * @return
     */
    public Set<String> getStringSet(String key, Set<String> defValues) {
        return mPreferences.getStringSet(key, defValues);
    }

    /**
     * @param key
     * @param value
     */
    public void setIntValue(String key, int value) {
        mPreferences.edit().putInt(key, value).apply();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public int getIntValue(String key, int defValue) {
        return mPreferences.getInt(key, defValue);
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public String getStringValue(String key, String defValue) {
        return mPreferences.getString(key, defValue);
    }

    /**
     * @param key
     * @param value
     */
    public void setStringValue(String key, String value) {
        mPreferences.edit().putString(key, value).apply();
    }

    /**
     * @param key
     * @param value
     */
    public void setStringsSet(String key, Set<String> value) {
        mPreferences.edit().putStringSet(key, value).apply();
    }


    /**
     * @param key
     */
    public void remove(String key) {
        mPreferences.edit().remove(key).apply();
    }

    /**
     * @param key
     * @return
     */
    public boolean contains(String key) {
        return mPreferences.contains(key);
    }


    /**
     * @return
     */
    public boolean clearAll() {
        Log.d(TAG, "Clearing all data");
        return mPreferences.edit().clear().commit();
    }


}
