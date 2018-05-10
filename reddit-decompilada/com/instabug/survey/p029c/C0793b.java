package com.instabug.survey.p029c;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* compiled from: KeyboardUtils */
public class C0793b {
    public static void m8408a(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static void m8409a(Activity activity, EditText editText) {
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(editText, 1);
    }
}
