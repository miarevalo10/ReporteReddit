package io.fabric.sdk.android.services.persistence;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.io.File;

public class FileStoreImpl implements FileStore {
    private final Context f31026a;
    private final String f31027b;
    private final String f31028c;

    public FileStoreImpl(Kit kit) {
        if (kit.getContext() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f31026a = kit.getContext();
        this.f31027b = kit.getPath();
        kit = new StringBuilder("Android/");
        kit.append(this.f31026a.getPackageName());
        this.f31028c = kit.toString();
    }

    public final File mo5605a() {
        File filesDir = this.f31026a.getFilesDir();
        if (filesDir != null) {
            if (!filesDir.exists()) {
                if (!filesDir.mkdirs()) {
                    Fabric.m26243b().mo5569d("Fabric", "Couldn't create file");
                }
            }
            return filesDir;
        }
        Fabric.m26243b().mo5562a("Fabric", "Null File");
        return null;
    }
}
