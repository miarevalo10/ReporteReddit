package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

final class TextViewTextObservable extends InitialValueObservable<CharSequence> {
    private final TextView f19318a;

    static final class Listener extends MainThreadDisposable implements TextWatcher {
        private final TextView f18595a;
        private final Observer<? super CharSequence> f18596b;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        Listener(TextView textView, Observer<? super CharSequence> observer) {
            this.f18595a = textView;
            this.f18596b = observer;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (b() == 0) {
                this.f18596b.onNext(charSequence);
            }
        }

        protected final void p_() {
            this.f18595a.removeTextChangedListener(this);
        }
    }

    TextViewTextObservable(TextView textView) {
        this.f19318a = textView;
    }

    protected final void mo4087a(Observer<? super CharSequence> observer) {
        Object listener = new Listener(this.f19318a, observer);
        observer.onSubscribe(listener);
        this.f19318a.addTextChangedListener(listener);
    }

    protected final /* synthetic */ Object mo4086a() {
        return this.f19318a.getText();
    }
}
