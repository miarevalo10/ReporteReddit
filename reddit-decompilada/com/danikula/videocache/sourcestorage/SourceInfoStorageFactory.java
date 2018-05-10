package com.danikula.videocache.sourcestorage;

import android.content.Context;

public class SourceInfoStorageFactory {
    public static SourceInfoStorage m3363a(Context context) {
        return new DatabaseSourceInfoStorage(context);
    }

    public static SourceInfoStorage m3362a() {
        return new NoSourceInfoStorage();
    }
}
