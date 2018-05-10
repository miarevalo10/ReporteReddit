package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.common.util.zzq;
import java.io.InputStream;

final class zzyq implements zzajb<zzoi> {
    private /* synthetic */ boolean f14760a;
    private /* synthetic */ double f14761b;
    private /* synthetic */ boolean f14762c;
    private /* synthetic */ String f14763d;
    private /* synthetic */ zzym f14764e;

    zzyq(zzym com_google_android_gms_internal_zzym, boolean z, double d, boolean z2, String str) {
        this.f14764e = com_google_android_gms_internal_zzym;
        this.f14760a = z;
        this.f14761b = d;
        this.f14762c = z2;
        this.f14763d = str;
    }

    @TargetApi(19)
    private final zzoi m14463b(InputStream inputStream) {
        Bitmap decodeStream;
        Options options = new Options();
        options.inDensity = (int) (160.0d * this.f14761b);
        if (!this.f14762c) {
            options.inPreferredConfig = Config.RGB_565;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Throwable e) {
            zzakb.m5367b("Error grabbing image.", e);
            decodeStream = null;
        }
        if (decodeStream == null) {
            this.f14764e.m6820a(2, this.f14760a);
            return null;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (zzq.m4913e() && zzagf.m13279a()) {
            int width = decodeStream.getWidth();
            int height = decodeStream.getHeight();
            int allocationByteCount = decodeStream.getAllocationByteCount();
            uptimeMillis2 -= uptimeMillis;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder stringBuilder = new StringBuilder(108);
            stringBuilder.append("Decoded image w: ");
            stringBuilder.append(width);
            stringBuilder.append(" h:");
            stringBuilder.append(height);
            stringBuilder.append(" bytes: ");
            stringBuilder.append(allocationByteCount);
            stringBuilder.append(" time: ");
            stringBuilder.append(uptimeMillis2);
            stringBuilder.append(" on ui thread: ");
            stringBuilder.append(z);
            zzagf.m13278a(stringBuilder.toString());
        }
        return new zzoi(new BitmapDrawable(Resources.getSystem(), decodeStream), Uri.parse(this.f14763d), this.f14761b);
    }

    public final /* synthetic */ Object mo1724a() {
        this.f14764e.m6820a(2, this.f14760a);
        return null;
    }

    @TargetApi(19)
    public final /* synthetic */ Object mo1725a(InputStream inputStream) {
        return m14463b(inputStream);
    }
}
