package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

final class zzam {
    long f6531a;
    final String f6532b;
    final String f6533c;
    final long f6534d;
    final long f6535e;
    final long f6536f;
    final long f6537g;
    final List<zzl> f6538h;

    zzam(String str, zzc com_google_android_gms_internal_zzc) {
        this(str, com_google_android_gms_internal_zzc.f6722b, com_google_android_gms_internal_zzc.f6723c, com_google_android_gms_internal_zzc.f6724d, com_google_android_gms_internal_zzc.f6725e, com_google_android_gms_internal_zzc.f6726f, com_google_android_gms_internal_zzc.f6728h != null ? com_google_android_gms_internal_zzc.f6728h : zzao.m5471b(com_google_android_gms_internal_zzc.f6727g));
        this.f6531a = (long) com_google_android_gms_internal_zzc.f6721a.length;
    }

    private zzam(String str, String str2, long j, long j2, long j3, long j4, List<zzl> list) {
        this.f6532b = str;
        if ("".equals(str2)) {
            str2 = null;
        }
        this.f6533c = str2;
        this.f6534d = j;
        this.f6535e = j2;
        this.f6536f = j3;
        this.f6537g = j4;
        this.f6538h = list;
    }

    static zzam m5405a(zzan com_google_android_gms_internal_zzan) throws IOException {
        if (zzal.m13309a((InputStream) com_google_android_gms_internal_zzan) == 538247942) {
            return new zzam(zzal.m13311a(com_google_android_gms_internal_zzan), zzal.m13311a(com_google_android_gms_internal_zzan), zzal.m13317b((InputStream) com_google_android_gms_internal_zzan), zzal.m13317b((InputStream) com_google_android_gms_internal_zzan), zzal.m13317b((InputStream) com_google_android_gms_internal_zzan), zzal.m13317b((InputStream) com_google_android_gms_internal_zzan), zzal.m13318b(com_google_android_gms_internal_zzan));
        }
        throw new IOException();
    }

    final boolean m5406a(OutputStream outputStream) {
        try {
            zzal.m13312a(outputStream, 538247942);
            zzal.m13314a(outputStream, this.f6532b);
            zzal.m13314a(outputStream, this.f6533c == null ? "" : this.f6533c);
            zzal.m13313a(outputStream, this.f6534d);
            zzal.m13313a(outputStream, this.f6535e);
            zzal.m13313a(outputStream, this.f6536f);
            zzal.m13313a(outputStream, this.f6537g);
            List<zzl> list = this.f6538h;
            if (list != null) {
                zzal.m13312a(outputStream, list.size());
                for (zzl com_google_android_gms_internal_zzl : list) {
                    zzal.m13314a(outputStream, com_google_android_gms_internal_zzl.f7777a);
                    zzal.m13314a(outputStream, com_google_android_gms_internal_zzl.f7778b);
                }
            } else {
                zzal.m13312a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (OutputStream outputStream2) {
            zzae.m5043b("%s", outputStream2.toString());
            return false;
        }
    }
}
