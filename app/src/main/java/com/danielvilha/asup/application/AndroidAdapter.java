package com.danielvilha.asup.application;

import android.content.Context;

import com.danielvilha.asup.common.entity.DaoSession;

/**
 * Created by Daniel Vilha 26/06/17.
 */

public class AndroidAdapter {

    public static Context getContext() {
        return AppApplication.getContext();
    }

    public static DaoSession getDaoSession() {
        return AppApplication.getDaoSession();
    }
}
