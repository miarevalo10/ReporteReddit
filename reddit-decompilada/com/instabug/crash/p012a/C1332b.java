package com.instabug.crash.p012a;

import android.net.Uri;
import com.instabug.library.internal.video.AutoScreenRecordingContract;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;

/* compiled from: ExternalAutoScreenRecordHelper */
public class C1332b implements AutoScreenRecordingContract {
    private static C1332b f15419a;

    public static C1332b m15327a() {
        if (f15419a == null) {
            f15419a = new C1332b();
        }
        return f15419a;
    }

    private C1332b() {
    }

    public Uri getAutoScreenRecordingFileUri() {
        return InternalAutoScreenRecorderHelper.getInstance().getAutoScreenRecordingFileUri();
    }

    public void delete() {
        InternalAutoScreenRecorderHelper.getInstance().delete();
    }

    public void clear() {
        InternalAutoScreenRecorderHelper.getInstance().clear();
    }

    public boolean isEnabled() {
        return InternalAutoScreenRecorderHelper.getInstance().isEnabled();
    }

    public static void m15328b() {
        InternalAutoScreenRecorderHelper.getInstance().start();
    }
}
