package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.BackgroundManager.Listener;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

class SessionAnalyticsManager implements Listener {
    static final String EXECUTOR_SERVICE = "Answers Events Handler";
    static final String ON_CRASH_ERROR_MSG = "onCrash called from main thread!!!";
    final BackgroundManager backgroundManager;
    final AnswersEventsHandler eventsHandler;
    private final long installedAt;
    final ActivityLifecycleManager lifecycleManager;
    final AnswersPreferenceManager preferenceManager;

    public void onError(String str) {
    }

    public static SessionAnalyticsManager build(Kit kit, Context context, IdManager idManager, String str, String str2, long j) {
        Context context2 = context;
        SessionMetadataCollector sessionMetadataCollector = new SessionMetadataCollector(context2, idManager, str, str2);
        Kit kit2 = kit;
        AnswersFilesManagerProvider answersFilesManagerProvider = new AnswersFilesManagerProvider(context2, new FileStoreImpl(kit2));
        HttpRequestFactory defaultHttpRequestFactory = new DefaultHttpRequestFactory(Fabric.b());
        ActivityLifecycleManager activityLifecycleManager = new ActivityLifecycleManager(context2);
        ScheduledExecutorService b = ExecutorUtils.b(EXECUTOR_SERVICE);
        BackgroundManager backgroundManager = new BackgroundManager(b);
        return new SessionAnalyticsManager(new AnswersEventsHandler(kit2, context2, answersFilesManagerProvider, sessionMetadataCollector, defaultHttpRequestFactory, b, new FirebaseAnalyticsApiAdapter(context2)), activityLifecycleManager, backgroundManager, AnswersPreferenceManager.build(context2), j);
    }

    SessionAnalyticsManager(AnswersEventsHandler answersEventsHandler, ActivityLifecycleManager activityLifecycleManager, BackgroundManager backgroundManager, AnswersPreferenceManager answersPreferenceManager, long j) {
        this.eventsHandler = answersEventsHandler;
        this.lifecycleManager = activityLifecycleManager;
        this.backgroundManager = backgroundManager;
        this.preferenceManager = answersPreferenceManager;
        this.installedAt = j;
    }

    public void enable() {
        this.eventsHandler.enable();
        this.lifecycleManager.a(new AnswersLifecycleCallbacks(this, this.backgroundManager));
        this.backgroundManager.registerListener(this);
        if (isFirstLaunch()) {
            onInstall(this.installedAt);
            this.preferenceManager.setAnalyticsLaunched();
        }
    }

    public void disable() {
        ActivityLifecycleManager activityLifecycleManager = this.lifecycleManager;
        if (activityLifecycleManager.a != null) {
            ActivityLifecycleCallbacksWrapper.a(activityLifecycleManager.a);
        }
        this.eventsHandler.disable();
    }

    public void onCustom(CustomEvent customEvent) {
        Logger b = Fabric.b();
        String str = Answers.TAG;
        StringBuilder stringBuilder = new StringBuilder("Logged custom event: ");
        stringBuilder.append(customEvent);
        b.a(str, stringBuilder.toString());
        this.eventsHandler.processEventAsync(SessionEvent.customEventBuilder(customEvent));
    }

    public void onPredefined(PredefinedEvent predefinedEvent) {
        Logger b = Fabric.b();
        String str = Answers.TAG;
        StringBuilder stringBuilder = new StringBuilder("Logged predefined event: ");
        stringBuilder.append(predefinedEvent);
        b.a(str, stringBuilder.toString());
        this.eventsHandler.processEventAsync(SessionEvent.predefinedEventBuilder(predefinedEvent));
    }

    public void onCrash(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(ON_CRASH_ERROR_MSG);
        }
        Fabric.b().a(Answers.TAG, "Logged crash");
        this.eventsHandler.processEventSync(SessionEvent.crashEventBuilder(str, str2));
    }

    public void onInstall(long j) {
        Fabric.b().a(Answers.TAG, "Logged install");
        this.eventsHandler.processEventAsyncAndFlush(SessionEvent.installEventBuilder(j));
    }

    public void onLifecycle(Activity activity, Type type) {
        Logger b = Fabric.b();
        String str = Answers.TAG;
        StringBuilder stringBuilder = new StringBuilder("Logged lifecycle event: ");
        stringBuilder.append(type.name());
        b.a(str, stringBuilder.toString());
        this.eventsHandler.processEventAsync(SessionEvent.lifecycleEventBuilder(type, activity));
    }

    public void onBackground() {
        Fabric.b().a(Answers.TAG, "Flush events when app is backgrounded");
        this.eventsHandler.flushEvents();
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.backgroundManager.setFlushOnBackground(analyticsSettingsData.j);
        this.eventsHandler.setAnalyticsSettingsData(analyticsSettingsData, str);
    }

    boolean isFirstLaunch() {
        return !this.preferenceManager.hasAnalyticsLaunched();
    }
}
