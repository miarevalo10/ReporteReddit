package com.instabug.library.util;

import android.content.Context;
import android.media.AudioManager;
import android.support.v4.content.ContextCompat;
import com.instabug.chat.model.Attachment;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;

/* compiled from: MicUtils */
public class C0775c {
    public static void m8364a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(Attachment.TYPE_AUDIO);
        audioManager.setMode(0);
        if (!audioManager.isMicrophoneMute()) {
            audioManager.setMicrophoneMute(true);
        }
    }

    public static void m8366b(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(Attachment.TYPE_AUDIO);
        audioManager.setMode(0);
        if (audioManager.isMicrophoneMute()) {
            audioManager.setMicrophoneMute(false);
        }
    }

    public static boolean m8365a() {
        return ContextCompat.m713a(InstabugInternalTrackingDelegate.getInstance().getCurrentActivity(), "android.permission.RECORD_AUDIO") == 0;
    }
}
