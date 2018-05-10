package com.jakewharton.rxbinding2.widget;

import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;

public final class RxTextView {
    public static InitialValueObservable<CharSequence> m8472a(TextView textView) {
        Preconditions.m8471a(textView, "view == null");
        return new TextViewTextObservable(textView);
    }

    public static InitialValueObservable<TextViewAfterTextChangeEvent> m8473b(TextView textView) {
        Preconditions.m8471a(textView, "view == null");
        return new TextViewAfterTextChangeEventObservable(textView);
    }
}
