package com.instabug.crash.p012a;

import android.net.Uri;
import com.instabug.crash.models.Crash;
import com.instabug.crash.models.Crash.CrashState;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.settings.SettingsManager;

/* compiled from: AutoScreenRecordingUtils */
public class C0580a {
    public static void m7994a(Crash crash) {
        if (SettingsManager.getInstance().autoScreenRecordingEnabled()) {
            Uri autoScreenRecordingFileUri = C1332b.m15327a().getAutoScreenRecordingFileUri();
            if (autoScreenRecordingFileUri != null) {
                Attachment attachment = new Attachment();
                attachment.setName(autoScreenRecordingFileUri.getLastPathSegment());
                attachment.setLocalPath(autoScreenRecordingFileUri.getPath());
                attachment.setType(Type.AUTO_SCREEN_RECORDING);
                crash.f15425d.add(attachment);
                crash.f15427f = CrashState.WAITING_FOR_SCREEN_RECORDING_TO_BE_TRIMMED;
            }
            C1332b.m15327a().clear();
        }
    }
}
