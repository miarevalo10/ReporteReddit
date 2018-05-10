package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

class FirebaseAnalyticsApiAdapter {
    private final Context context;
    private EventLogger eventLogger;
    private final FirebaseAnalyticsEventMapper eventMapper;

    public FirebaseAnalyticsApiAdapter(Context context) {
        this(context, new FirebaseAnalyticsEventMapper());
    }

    public FirebaseAnalyticsApiAdapter(Context context, FirebaseAnalyticsEventMapper firebaseAnalyticsEventMapper) {
        this.context = context;
        this.eventMapper = firebaseAnalyticsEventMapper;
    }

    public EventLogger getFirebaseAnalytics() {
        if (this.eventLogger == null) {
            this.eventLogger = AppMeasurementEventLogger.getEventLogger(this.context);
        }
        return this.eventLogger;
    }

    public void processEvent(SessionEvent sessionEvent) {
        EventLogger firebaseAnalytics = getFirebaseAnalytics();
        if (firebaseAnalytics == null) {
            Fabric.b().a(Answers.TAG, "Firebase analytics logging was enabled, but not available...");
            return;
        }
        FirebaseAnalyticsEvent mapEvent = this.eventMapper.mapEvent(sessionEvent);
        if (mapEvent == null) {
            Logger b = Fabric.b();
            String str = Answers.TAG;
            StringBuilder stringBuilder = new StringBuilder("Fabric event was not mappable to Firebase event: ");
            stringBuilder.append(sessionEvent);
            b.a(str, stringBuilder.toString());
            return;
        }
        firebaseAnalytics.logEvent(mapEvent.getEventName(), mapEvent.getEventParams());
        if ("levelEnd".equals(sessionEvent.predefinedType) != null) {
            firebaseAnalytics.logEvent("post_score", mapEvent.getEventParams());
        }
    }
}
