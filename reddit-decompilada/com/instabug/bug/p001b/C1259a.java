package com.instabug.bug.p001b;

import android.net.Uri;
import com.instabug.library.internal.video.AutoScreenRecordingContract;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;

/* compiled from: ExternalAutoScreenRecordHelper */
public class C1259a implements AutoScreenRecordingContract {
    private static C1259a f15304a;

    public static C1259a m15209a() {
        if (f15304a == null) {
            f15304a = new C1259a();
        }
        return f15304a;
    }

    private C1259a() {
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
}
