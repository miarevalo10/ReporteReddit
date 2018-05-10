package com.google.android.gms.internal;

import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzbs;
import com.instabug.library.model.State;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import java.util.Map;

@zzzv
public final class zzamw implements zzt<zzamp> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzamp com_google_android_gms_internal_zzamp = (zzamp) obj;
        if (((Boolean) zzkb.m6350f().m6488a(zznh.bg)).booleanValue()) {
            zzaoa com_google_android_gms_internal_zzaoa;
            boolean z;
            int i;
            zzaoa b = com_google_android_gms_internal_zzamp.mo3464b();
            if (b == null) {
                try {
                    zzaoa com_google_android_gms_internal_zzaoa2 = new zzaoa(com_google_android_gms_internal_zzamp, Float.parseFloat((String) map.get(State.KEY_DURATION)), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                    com_google_android_gms_internal_zzamp.mo3461a(com_google_android_gms_internal_zzaoa2);
                    com_google_android_gms_internal_zzaoa = com_google_android_gms_internal_zzaoa2;
                } catch (Throwable e) {
                    zzakb.m5367b("Unable to parse videoMeta message.", e);
                    zzbs.m4490i().m13246a(e, "VideoMetaGmsgHandler.onGmsg");
                }
            } else {
                com_google_android_gms_internal_zzaoa = b;
            }
            boolean equals = "1".equals(map.get(ModEventBuilder.f27453d));
            obj = Float.parseFloat((String) map.get("currentTime"));
            int parseInt = Integer.parseInt((String) map.get("playbackState"));
            if (parseInt < 0 || 3 < parseInt) {
                parseInt = 0;
            }
            int i2 = parseInt;
            String str = (String) map.get("aspectRatio");
            float parseFloat = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (zzakb.m5365a(3)) {
                StringBuilder stringBuilder = new StringBuilder(79 + String.valueOf(str).length());
                stringBuilder.append("Video Meta GMSG: isMuted : ");
                stringBuilder.append(equals);
                stringBuilder.append(" , playbackState : ");
                stringBuilder.append(i2);
                stringBuilder.append(" , aspectRatio : ");
                stringBuilder.append(str);
                zzakb.m5366b(stringBuilder.toString());
            }
            synchronized (com_google_android_gms_internal_zzaoa.f17581b) {
                com_google_android_gms_internal_zzaoa.f17584e = obj;
                z = com_google_android_gms_internal_zzaoa.f17583d;
                com_google_android_gms_internal_zzaoa.f17583d = equals;
                i = com_google_android_gms_internal_zzaoa.f17582c;
                com_google_android_gms_internal_zzaoa.f17582c = i2;
                obj = com_google_android_gms_internal_zzaoa.f17585f;
                com_google_android_gms_internal_zzaoa.f17585f = parseFloat;
                if (Math.abs(com_google_android_gms_internal_zzaoa.f17585f - obj) > 1.0E-4f) {
                    obj = com_google_android_gms_internal_zzaoa.f17580a;
                    if (obj == null) {
                        throw null;
                    }
                    ((View) obj).invalidate();
                }
            }
            zzbs.m4486e();
            zzahn.m5173a(new zzaoc(com_google_android_gms_internal_zzaoa, i, i2, z, equals));
        }
    }
}
