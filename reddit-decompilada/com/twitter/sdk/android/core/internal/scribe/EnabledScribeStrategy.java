package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import io.fabric.sdk.android.services.events.EnabledEventsStrategy;
import io.fabric.sdk.android.services.events.FilesSender;
import java.util.concurrent.ScheduledExecutorService;

class EnabledScribeStrategy extends EnabledEventsStrategy<ScribeEvent> {
    private final FilesSender f37608f;

    public EnabledScribeStrategy(Context context, ScheduledExecutorService scheduledExecutorService, ScribeFilesManager scribeFilesManager, ScribeConfig scribeConfig, ScribeFilesSender scribeFilesSender) {
        super(context, scheduledExecutorService, scribeFilesManager);
        this.f37608f = scribeFilesSender;
        this.f34681e = scribeConfig.f23998h;
        m35597a(null, (long) this.f34681e);
    }

    public final FilesSender mo6597a() {
        return this.f37608f;
    }
}
