package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;

class CrashlyticsFileMarker {
    private final FileStore fileStore;
    private final String markerName;

    public CrashlyticsFileMarker(String str, FileStore fileStore) {
        this.markerName = str;
        this.fileStore = fileStore;
    }

    public boolean create() {
        try {
            return getMarkerFile().createNewFile();
        } catch (Throwable e) {
            Logger b = Fabric.b();
            String str = CrashlyticsCore.TAG;
            StringBuilder stringBuilder = new StringBuilder("Error creating marker: ");
            stringBuilder.append(this.markerName);
            b.c(str, stringBuilder.toString(), e);
            return false;
        }
    }

    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    public boolean remove() {
        return getMarkerFile().delete();
    }

    private File getMarkerFile() {
        return new File(this.fileStore.a(), this.markerName);
    }
}
