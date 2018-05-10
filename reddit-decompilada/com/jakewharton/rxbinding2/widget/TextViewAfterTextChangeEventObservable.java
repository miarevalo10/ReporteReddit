package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class TextViewAfterTextChangeEventObservable extends InitialValueObservable<TextViewAfterTextChangeEvent> {
    private final TextView f19317a;

    static final class Listener extends MainThreadDisposable implements TextWatcher {
        private final TextView f18593a;
        private final Observer<? super TextViewAfterTextChangeEvent> f18594b;

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        Listener(TextView textView, Observer<? super TextViewAfterTextChangeEvent> observer) {
            this.f18593a = textView;
            this.f18594b = observer;
        }

        public final void afterTextChanged(Editable editable) {
            this.f18594b.onNext(TextViewAfterTextChangeEvent.m8474a(this.f18593a, editable));
        }

        protected final void p_() {
            this.f18593a.removeTextChangedListener(this);
        }
    }

    TextViewAfterTextChangeEventObservable(TextView textView) {
        this.f19317a = textView;
    }

    protected final void mo4087a(Observer<? super TextViewAfterTextChangeEvent> observer) {
        Object listener = new Listener(this.f19317a, observer);
        observer.onSubscribe(listener);
        this.f19317a.addTextChangedListener(listener);
    }

    protected final /* synthetic */ Object mo4086a() {
        return TextViewAfterTextChangeEvent.m8474a(this.f19317a, this.f19317a.getEditableText());
    }
}
