package com.example.printer;

import android.view.Window;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;

class SystemBarsUtils {

    public static void styleSystemBars(AppCompatActivity activity, @ColorRes int statusBarColor) {
        setSystemBarsColor(activity, statusBarColor);
    }

    public static void setSystemBarsColor(AppCompatActivity activity, @ColorRes int colorResId) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        window.setStatusBarColor(ContextCompat.getColor(activity, colorResId));
        window.setNavigationBarColor(0);
    }

}
