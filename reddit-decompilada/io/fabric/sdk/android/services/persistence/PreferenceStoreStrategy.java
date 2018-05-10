package io.fabric.sdk.android.services.persistence;

import android.annotation.SuppressLint;

public class PreferenceStoreStrategy<T> {
    public final PreferenceStore f24860a;
    public final SerializationStrategy<T> f24861b;
    public final String f24862c;

    public PreferenceStoreStrategy(PreferenceStore preferenceStore, SerializationStrategy<T> serializationStrategy, String str) {
        this.f24860a = preferenceStore;
        this.f24861b = serializationStrategy;
        this.f24862c = str;
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void m26431a(T t) {
        this.f24860a.mo5607a(this.f24860a.mo5608b().putString(this.f24862c, this.f24861b.mo5462a((Object) t)));
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void m26430a() {
        this.f24860a.mo5608b().remove(this.f24862c).commit();
    }
}
