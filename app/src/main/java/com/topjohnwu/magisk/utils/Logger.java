package com.topjohnwu.magisk.utils;

import android.util.Log;

import com.topjohnwu.magisk.MagiskManager;

public class Logger {

    public static final String TAG = "Magisk";

    public static void debug(String msg) {
        Log.d(TAG, "DEBUG: " + msg);
    }

    public static void error(String msg) {
        Log.e(TAG, "MANAGERERROR: " + msg);
    }

    public static void dev(String msg, Object... args) {
        if (MagiskManager.devLogging) {
            if (args.length == 1 && args[0] instanceof Throwable) {
                Log.d(TAG, "MANAGER: " + msg, (Throwable) args[0]);
            } else {
                Log.d(TAG, "MANAGER: " + String.format(msg, args));
            }
        }
    }

    public static void dev(String msg) {
        if (MagiskManager.devLogging) {
            Log.d(TAG, "MANAGER: " + msg);
        }
    }

    public static void shell(boolean root, String msg) {
        if (MagiskManager.shellLogging) {
            Log.d(TAG, root ? "MANAGERSU" : "MANAGERSH" + msg);
        }
    }
}
