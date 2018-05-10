package com.crashlytics.android.beta;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class AbstractCheckForUpdatesController implements UpdatesController {
    static final long LAST_UPDATE_CHECK_DEFAULT = 0;
    static final String LAST_UPDATE_CHECK_KEY = "last_update_check";
    private static final long MILLIS_PER_SECOND = 1000;
    private Beta beta;
    private BetaSettingsData betaSettings;
    private BuildProperties buildProps;
    private Context context;
    private CurrentTimeProvider currentTimeProvider;
    private final AtomicBoolean externallyReady;
    private HttpRequestFactory httpRequestFactory;
    private IdManager idManager;
    private final AtomicBoolean initialized;
    private long lastCheckTimeMillis;
    private PreferenceStore preferenceStore;

    public AbstractCheckForUpdatesController() {
        this(false);
    }

    public AbstractCheckForUpdatesController(boolean z) {
        this.initialized = new AtomicBoolean();
        this.lastCheckTimeMillis = LAST_UPDATE_CHECK_DEFAULT;
        this.externallyReady = new AtomicBoolean(z);
    }

    public void initialize(Context context, Beta beta, IdManager idManager, BetaSettingsData betaSettingsData, BuildProperties buildProperties, PreferenceStore preferenceStore, CurrentTimeProvider currentTimeProvider, HttpRequestFactory httpRequestFactory) {
        this.context = context;
        this.beta = beta;
        this.idManager = idManager;
        this.betaSettings = betaSettingsData;
        this.buildProps = buildProperties;
        this.preferenceStore = preferenceStore;
        this.currentTimeProvider = currentTimeProvider;
        this.httpRequestFactory = httpRequestFactory;
        if (signalInitialized() != null) {
            checkForUpdates();
        }
    }

    protected boolean signalExternallyReady() {
        this.externallyReady.set(true);
        return this.initialized.get();
    }

    boolean signalInitialized() {
        this.initialized.set(true);
        return this.externallyReady.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void checkForUpdates() {
        synchronized (this.preferenceStore) {
            if (this.preferenceStore.a().contains(LAST_UPDATE_CHECK_KEY)) {
                this.preferenceStore.a(this.preferenceStore.b().remove(LAST_UPDATE_CHECK_KEY));
            }
        }
        long a = this.currentTimeProvider.a();
        long j = ((long) this.betaSettings.b) * MILLIS_PER_SECOND;
        Logger b = Fabric.b();
        String str = Beta.TAG;
        StringBuilder stringBuilder = new StringBuilder("Check for updates delay: ");
        stringBuilder.append(j);
        b.a(str, stringBuilder.toString());
        b = Fabric.b();
        str = Beta.TAG;
        stringBuilder = new StringBuilder("Check for updates last check time: ");
        stringBuilder.append(getLastCheckTimeMillis());
        b.a(str, stringBuilder.toString());
        long lastCheckTimeMillis = getLastCheckTimeMillis() + j;
        Logger b2 = Fabric.b();
        String str2 = Beta.TAG;
        stringBuilder = new StringBuilder("Check for updates current time: ");
        stringBuilder.append(a);
        stringBuilder.append(", next check time: ");
        stringBuilder.append(lastCheckTimeMillis);
        b2.a(str2, stringBuilder.toString());
        if (a >= lastCheckTimeMillis) {
            try {
                performUpdateCheck();
            } finally {
                setLastCheckTimeMillis(a);
            }
        } else {
            Fabric.b().a(Beta.TAG, "Check for updates next check time was not passed");
        }
    }

    private void performUpdateCheck() {
        Fabric.b().a(Beta.TAG, "Performing update check");
        ApiKey apiKey = new ApiKey();
        new CheckForUpdatesRequest(this.beta, this.beta.getOverridenSpiEndpoint(), this.betaSettings.a, this.httpRequestFactory, new CheckForUpdatesResponseTransform()).invoke(ApiKey.a(this.context), (String) this.idManager.c().get(DeviceIdentifierType.c), this.buildProps);
    }

    void setLastCheckTimeMillis(long j) {
        this.lastCheckTimeMillis = j;
    }

    long getLastCheckTimeMillis() {
        return this.lastCheckTimeMillis;
    }
}
