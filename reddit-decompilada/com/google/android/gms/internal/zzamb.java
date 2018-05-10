package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@zzzv
@TargetApi(14)
public abstract class zzamb extends TextureView implements zzamt {
    protected final zzami f14148a = new zzami();
    protected final zzams f14149b;

    public zzamb(Context context) {
        super(context);
        this.f14149b = new zzams(context, this);
    }

    public abstract String mo3447a();

    public abstract void mo3448a(float f, float f2);

    public abstract void mo3449a(int i);

    public abstract void mo3450a(zzama com_google_android_gms_internal_zzama);

    public abstract void mo3451b();

    public abstract void mo3452c();

    public abstract void mo3453d();

    public abstract void mo1740e();

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setVideoPath(String str);
}
