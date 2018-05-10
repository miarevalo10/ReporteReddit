package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.widget.TextView;

public abstract class TextViewAfterTextChangeEvent {
    public abstract TextView mo2628a();

    public abstract Editable mo2629b();

    public static TextViewAfterTextChangeEvent m8474a(TextView textView, Editable editable) {
        return new AutoValue_TextViewAfterTextChangeEvent(textView, editable);
    }

    TextViewAfterTextChangeEvent() {
    }
}
