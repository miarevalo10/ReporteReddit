package com.google.android.gms.internal;

import android.os.Environment;
import java.util.concurrent.Callable;

final class zzmu implements Callable<Boolean> {
    zzmu() {
    }

    public final /* synthetic */ Object call() throws Exception {
        return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
    }
}
