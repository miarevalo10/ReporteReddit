package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.widget.TextView;

final class AutoValue_TextViewAfterTextChangeEvent extends TextViewAfterTextChangeEvent {
    private final TextView f15602a;
    private final Editable f15603b;

    AutoValue_TextViewAfterTextChangeEvent(TextView textView, Editable editable) {
        if (textView == null) {
            throw new NullPointerException("Null view");
        }
        this.f15602a = textView;
        this.f15603b = editable;
    }

    public final TextView mo2628a() {
        return this.f15602a;
    }

    public final Editable mo2629b() {
        return this.f15603b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("TextViewAfterTextChangeEvent{view=");
        stringBuilder.append(this.f15602a);
        stringBuilder.append(", editable=");
        stringBuilder.append(this.f15603b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextViewAfterTextChangeEvent)) {
            return false;
        }
        TextViewAfterTextChangeEvent textViewAfterTextChangeEvent = (TextViewAfterTextChangeEvent) obj;
        if (this.f15602a.equals(textViewAfterTextChangeEvent.mo2628a())) {
            if (this.f15603b == null) {
                if (textViewAfterTextChangeEvent.mo2629b() == null) {
                }
            } else if (this.f15603b.equals(textViewAfterTextChangeEvent.mo2629b()) != null) {
                return true;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f15602a.hashCode() ^ 1000003) * 1000003) ^ (this.f15603b == null ? 0 : this.f15603b.hashCode());
    }
}
