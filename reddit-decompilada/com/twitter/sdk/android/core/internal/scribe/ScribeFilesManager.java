package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventTransform;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.events.QueueFileEventStorage;
import java.io.IOException;
import java.util.UUID;

class ScribeFilesManager extends EventsFilesManager<ScribeEvent> {
    public ScribeFilesManager(Context context, EventTransform<ScribeEvent> eventTransform, CurrentTimeProvider currentTimeProvider, QueueFileEventStorage queueFileEventStorage, int i) throws IOException {
        super(context, eventTransform, currentTimeProvider, queueFileEventStorage, i);
    }

    protected String generateUniqueRollOverFileName() {
        UUID randomUUID = UUID.randomUUID();
        StringBuilder stringBuilder = new StringBuilder("se_");
        stringBuilder.append(randomUUID.toString());
        stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        stringBuilder.append(this.currentTimeProvider.mo5580a());
        stringBuilder.append(".tap");
        return stringBuilder.toString();
    }
}
