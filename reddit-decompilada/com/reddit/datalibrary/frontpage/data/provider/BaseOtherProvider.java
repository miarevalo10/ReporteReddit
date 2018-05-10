package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import android.text.TextUtils;
import com.evernote.android.state.State;
import com.livefront.bridge.Bridge;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import java.util.UUID;

public abstract class BaseOtherProvider {
    String ownerId;
    @State
    protected String providerId;

    public static class ProviderEvent extends BaseEvent {
        public final String f16222a;

        public ProviderEvent(String str) {
            this.f16222a = str;
        }
    }

    public void finish() {
    }

    public void onError(Exception exception) {
    }

    protected BaseOtherProvider() {
        this(null);
    }

    protected BaseOtherProvider(String str) {
        this.ownerId = str;
        this.providerId = UUID.randomUUID().toString();
    }

    public final void saveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        Bridge.m8483b(this, bundle);
    }

    public final void restoreInstanceState(Bundle bundle) {
        onRestoreInstanceState(bundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        Bridge.m8482a((Object) this, bundle);
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public boolean isSource(ProviderEvent providerEvent) {
        return (providerEvent == null || TextUtils.equals(this.providerId, providerEvent.f16222a) == null) ? null : true;
    }
}
