package com.reddit.frontpage.ui.listener;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class TextChangedListener implements TextWatcher {
    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
