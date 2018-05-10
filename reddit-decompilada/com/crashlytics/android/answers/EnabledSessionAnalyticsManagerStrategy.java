package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicReference;

class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    ApiKey apiKey = new ApiKey();
    private final Context context;
    boolean customEventsEnabled = true;
    EventFilter eventFilter = new KeepAllEventFilter();
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    FilesSender filesSender;
    private final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    boolean forwardToFirebaseAnalyticsEnabled = false;
    private final HttpRequestFactory httpRequestFactory;
    boolean includePurchaseEventsInForwardedEvents = false;
    private final Kit kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled = true;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference();
    volatile int rolloverIntervalSeconds = -1;

    public EnabledSessionAnalyticsManagerStrategy(Kit kit, Context context, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, HttpRequestFactory httpRequestFactory, SessionEventMetadata sessionEventMetadata, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter) {
        this.kit = kit;
        this.context = context;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = httpRequestFactory;
        this.metadata = sessionEventMetadata;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter;
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(this.kit, str, analyticsSettingsData.a, this.httpRequestFactory, ApiKey.a(this.context)));
        this.filesManager.setAnalyticsSettingsData(analyticsSettingsData);
        this.forwardToFirebaseAnalyticsEnabled = analyticsSettingsData.f;
        this.includePurchaseEventsInForwardedEvents = analyticsSettingsData.g;
        str = Fabric.b();
        String str2 = Answers.TAG;
        StringBuilder stringBuilder = new StringBuilder("Firebase analytics forwarding ");
        stringBuilder.append(this.forwardToFirebaseAnalyticsEnabled ? "enabled" : "disabled");
        str.a(str2, stringBuilder.toString());
        str = Fabric.b();
        str2 = Answers.TAG;
        stringBuilder = new StringBuilder("Firebase analytics including purchase events ");
        stringBuilder.append(this.includePurchaseEventsInForwardedEvents ? "enabled" : "disabled");
        str.a(str2, stringBuilder.toString());
        this.customEventsEnabled = analyticsSettingsData.h;
        str = Fabric.b();
        str2 = Answers.TAG;
        stringBuilder = new StringBuilder("Custom event tracking ");
        stringBuilder.append(this.customEventsEnabled ? "enabled" : "disabled");
        str.a(str2, stringBuilder.toString());
        this.predefinedEventsEnabled = analyticsSettingsData.i;
        str = Fabric.b();
        str2 = Answers.TAG;
        stringBuilder = new StringBuilder("Predefined event tracking ");
        stringBuilder.append(this.predefinedEventsEnabled ? "enabled" : "disabled");
        str.a(str2, stringBuilder.toString());
        if (analyticsSettingsData.k > 1) {
            Fabric.b().a(Answers.TAG, "Event sampling enabled");
            this.eventFilter = new SamplingEventFilter(analyticsSettingsData.k);
        }
        this.rolloverIntervalSeconds = analyticsSettingsData.b;
        scheduleTimeBasedFileRollOver(null, (long) this.rolloverIntervalSeconds);
    }

    public void processEvent(Builder builder) {
        Logger b;
        String str;
        StringBuilder stringBuilder;
        builder = builder.build(this.metadata);
        Logger b2;
        String str2;
        StringBuilder stringBuilder2;
        if (!this.customEventsEnabled && Type.CUSTOM.equals(builder.type)) {
            b2 = Fabric.b();
            str2 = Answers.TAG;
            stringBuilder2 = new StringBuilder("Custom events tracking disabled - skipping event: ");
            stringBuilder2.append(builder);
            b2.a(str2, stringBuilder2.toString());
        } else if (!this.predefinedEventsEnabled && Type.PREDEFINED.equals(builder.type)) {
            b2 = Fabric.b();
            str2 = Answers.TAG;
            stringBuilder2 = new StringBuilder("Predefined events tracking disabled - skipping event: ");
            stringBuilder2.append(builder);
            b2.a(str2, stringBuilder2.toString());
        } else if (this.eventFilter.skipEvent(builder)) {
            b2 = Fabric.b();
            str2 = Answers.TAG;
            stringBuilder2 = new StringBuilder("Skipping filtered event: ");
            stringBuilder2.append(builder);
            b2.a(str2, stringBuilder2.toString());
        } else {
            Object obj;
            boolean equals;
            try {
                this.filesManager.writeEvent(builder);
            } catch (Throwable e) {
                b = Fabric.b();
                str = Answers.TAG;
                stringBuilder = new StringBuilder("Failed to write event: ");
                stringBuilder.append(builder);
                b.c(str, stringBuilder.toString(), e);
            }
            scheduleTimeBasedRollOverIfNeeded();
            if (!Type.CUSTOM.equals(builder.type)) {
                if (!Type.PREDEFINED.equals(builder.type)) {
                    obj = null;
                    equals = "purchase".equals(builder.predefinedType);
                    if (this.forwardToFirebaseAnalyticsEnabled) {
                        if (obj == null) {
                            if (equals || this.includePurchaseEventsInForwardedEvents) {
                                try {
                                    this.firebaseAnalyticsApiAdapter.processEvent(builder);
                                } catch (Throwable e2) {
                                    b = Fabric.b();
                                    str = Answers.TAG;
                                    stringBuilder = new StringBuilder("Failed to map event to Firebase: ");
                                    stringBuilder.append(builder);
                                    b.c(str, stringBuilder.toString(), e2);
                                    return;
                                }
                            }
                            return;
                        }
                    }
                }
            }
            obj = 1;
            equals = "purchase".equals(builder.predefinedType);
            if (this.forwardToFirebaseAnalyticsEnabled) {
                if (obj == null) {
                    if (equals) {
                    }
                    this.firebaseAnalyticsApiAdapter.processEvent(builder);
                }
            }
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
        if ((this.rolloverIntervalSeconds != -1 ? 1 : null) != null) {
            scheduleTimeBasedFileRollOver((long) this.rolloverIntervalSeconds, (long) this.rolloverIntervalSeconds);
        }
    }

    public void sendEvents() {
        if (this.filesSender == null) {
            CommonUtils.a(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.a(this.context, "Sending all files");
        List batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i = 0;
        while (batchOfFilesToSend.size() > 0) {
            try {
                CommonUtils.a(this.context, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(batchOfFilesToSend.size())}));
                boolean send = this.filesSender.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                }
                batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
            } catch (Exception e) {
                Context context = this.context;
                StringBuilder stringBuilder = new StringBuilder("Failed to send batch of analytics files to server: ");
                stringBuilder.append(e.getMessage());
                CommonUtils.b(context, stringBuilder.toString());
            }
        }
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }

    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            CommonUtils.a(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.rolloverFutureRef.get()).cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    public boolean rollFileOver() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.filesManager;	 Catch:{ IOException -> 0x0007 }
        r0 = r0.rollFileOver();	 Catch:{ IOException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = r2.context;
        r1 = "Failed to roll file over.";
        io.fabric.sdk.android.services.common.CommonUtils.b(r0, r1);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.answers.EnabledSessionAnalyticsManagerStrategy.rollFileOver():boolean");
    }

    void scheduleTimeBasedFileRollOver(long r9, long r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = r8.rolloverFutureRef;
        r0 = r0.get();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = 1;
        goto L_0x000b;
    L_0x000a:
        r0 = 0;
    L_0x000b:
        if (r0 == 0) goto L_0x0043;
    L_0x000d:
        r2 = new io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
        r0 = r8.context;
        r2.<init>(r0, r8);
        r0 = r8.context;
        r1 = new java.lang.StringBuilder;
        r3 = "Scheduling time based file roll over every ";
        r1.<init>(r3);
        r1.append(r11);
        r3 = " seconds";
        r1.append(r3);
        r1 = r1.toString();
        io.fabric.sdk.android.services.common.CommonUtils.a(r0, r1);
        r0 = r8.rolloverFutureRef;	 Catch:{ RejectedExecutionException -> 0x003c }
        r1 = r8.executorService;	 Catch:{ RejectedExecutionException -> 0x003c }
        r7 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ RejectedExecutionException -> 0x003c }
        r3 = r9;	 Catch:{ RejectedExecutionException -> 0x003c }
        r5 = r11;	 Catch:{ RejectedExecutionException -> 0x003c }
        r9 = r1.scheduleAtFixedRate(r2, r3, r5, r7);	 Catch:{ RejectedExecutionException -> 0x003c }
        r0.set(r9);	 Catch:{ RejectedExecutionException -> 0x003c }
        return;
    L_0x003c:
        r9 = r8.context;
        r10 = "Failed to schedule time based file roll over";
        io.fabric.sdk.android.services.common.CommonUtils.b(r9, r10);
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.answers.EnabledSessionAnalyticsManagerStrategy.scheduleTimeBasedFileRollOver(long, long):void");
    }
}
