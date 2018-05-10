package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.instabug.chat.model.Attachment;

@zzzv
@TargetApi(14)
public final class zzams implements OnAudioFocusChangeListener {
    boolean f6583a;
    boolean f6584b;
    boolean f6585c;
    float f6586d = 1.0f;
    private final AudioManager f6587e;
    private final zzamt f6588f;

    public zzams(Context context, zzamt com_google_android_gms_internal_zzamt) {
        this.f6587e = (AudioManager) context.getSystemService(Attachment.TYPE_AUDIO);
        this.f6588f = com_google_android_gms_internal_zzamt;
    }

    final void m5426a() {
        boolean z = false;
        boolean z2 = this.f6584b && !this.f6585c && this.f6586d > 0.0f;
        if (!z2 || this.f6583a) {
            if (!z2 && this.f6583a) {
                if (this.f6587e != null) {
                    if (this.f6583a) {
                        if (this.f6587e.abandonAudioFocus(this) == 0) {
                            z = true;
                        }
                        this.f6583a = z;
                    }
                }
                this.f6588f.mo1740e();
            }
            return;
        }
        if (this.f6587e != null) {
            if (!this.f6583a) {
                if (this.f6587e.requestAudioFocus(this, 3, 2) == 1) {
                    z = true;
                }
                this.f6583a = z;
            }
        }
        this.f6588f.mo1740e();
    }

    public final void m5427a(boolean z) {
        this.f6585c = z;
        m5426a();
    }

    public final void onAudioFocusChange(int i) {
        this.f6583a = i > 0;
        this.f6588f.mo1740e();
    }
}
