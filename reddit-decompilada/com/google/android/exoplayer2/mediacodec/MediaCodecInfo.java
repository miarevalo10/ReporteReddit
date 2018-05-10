package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Log;
import com.google.android.exoplayer2.util.Util;

@TargetApi(16)
public final class MediaCodecInfo {
    public final String f4646a;
    public final boolean f4647b;
    public final boolean f4648c;
    public final boolean f4649d;
    public final String f4650e;
    public final CodecCapabilities f4651f;

    public static MediaCodecInfo m3886a(String str) {
        return new MediaCodecInfo(str, null, null, false, false);
    }

    public static MediaCodecInfo m3887a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new MediaCodecInfo(str, str2, codecCapabilities, z, z2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MediaCodecInfo(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
        r1 = this;
        r1.<init>();
        r2 = com.google.android.exoplayer2.util.Assertions.m4182a(r2);
        r2 = (java.lang.String) r2;
        r1.f4646a = r2;
        r1.f4650e = r3;
        r1.f4651f = r4;
        r2 = 0;
        r3 = 1;
        if (r5 != 0) goto L_0x002a;
    L_0x0013:
        if (r4 == 0) goto L_0x002a;
    L_0x0015:
        r5 = com.google.android.exoplayer2.util.Util.f5283a;
        r0 = 19;
        if (r5 < r0) goto L_0x0025;
    L_0x001b:
        r5 = "adaptive-playback";
        r5 = r4.isFeatureSupported(r5);
        if (r5 == 0) goto L_0x0025;
    L_0x0023:
        r5 = r3;
        goto L_0x0026;
    L_0x0025:
        r5 = r2;
    L_0x0026:
        if (r5 == 0) goto L_0x002a;
    L_0x0028:
        r5 = r3;
        goto L_0x002b;
    L_0x002a:
        r5 = r2;
    L_0x002b:
        r1.f4647b = r5;
        r5 = 21;
        if (r4 == 0) goto L_0x0044;
    L_0x0031:
        r0 = com.google.android.exoplayer2.util.Util.f5283a;
        if (r0 < r5) goto L_0x003f;
    L_0x0035:
        r0 = "tunneled-playback";
        r0 = r4.isFeatureSupported(r0);
        if (r0 == 0) goto L_0x003f;
    L_0x003d:
        r0 = r3;
        goto L_0x0040;
    L_0x003f:
        r0 = r2;
    L_0x0040:
        if (r0 == 0) goto L_0x0044;
    L_0x0042:
        r0 = r3;
        goto L_0x0045;
    L_0x0044:
        r0 = r2;
    L_0x0045:
        r1.f4648c = r0;
        if (r6 != 0) goto L_0x005c;
    L_0x0049:
        if (r4 == 0) goto L_0x005d;
    L_0x004b:
        r6 = com.google.android.exoplayer2.util.Util.f5283a;
        if (r6 < r5) goto L_0x0059;
    L_0x004f:
        r5 = "secure-playback";
        r4 = r4.isFeatureSupported(r5);
        if (r4 == 0) goto L_0x0059;
    L_0x0057:
        r4 = r3;
        goto L_0x005a;
    L_0x0059:
        r4 = r2;
    L_0x005a:
        if (r4 == 0) goto L_0x005d;
    L_0x005c:
        r2 = r3;
    L_0x005d:
        r1.f4649d = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecInfo.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public final CodecProfileLevel[] m3890a() {
        if (this.f4651f != null) {
            if (this.f4651f.profileLevels != null) {
                return this.f4651f.profileLevels;
            }
        }
        return new CodecProfileLevel[0];
    }

    @TargetApi(21)
    public final boolean m3889a(int i, int i2, double d) {
        if (this.f4651f == null) {
            m3891b("sizeAndRate.caps");
            return false;
        }
        VideoCapabilities videoCapabilities = this.f4651f.getVideoCapabilities();
        if (videoCapabilities == null) {
            m3891b("sizeAndRate.vCaps");
            return false;
        }
        if (!m3888a(videoCapabilities, i, i2, d)) {
            StringBuilder stringBuilder;
            if (i < i2) {
                if (m3888a(videoCapabilities, i2, i, d)) {
                    stringBuilder = new StringBuilder("sizeAndRate.rotated, ");
                    stringBuilder.append(i);
                    stringBuilder.append("x");
                    stringBuilder.append(i2);
                    stringBuilder.append("x");
                    stringBuilder.append(d);
                    i = stringBuilder.toString();
                    d = new StringBuilder("AssumedSupport [");
                    d.append(i);
                    d.append("] [");
                    d.append(this.f4646a);
                    d.append(", ");
                    d.append(this.f4650e);
                    d.append("] [");
                    d.append(Util.f5287e);
                    d.append("]");
                    Log.d("MediaCodecInfo", d.toString());
                }
            }
            stringBuilder = new StringBuilder("sizeAndRate.support, ");
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            stringBuilder.append("x");
            stringBuilder.append(d);
            m3891b(stringBuilder.toString());
            return false;
        }
        return true;
    }

    public final void m3891b(String str) {
        StringBuilder stringBuilder = new StringBuilder("NoSupport [");
        stringBuilder.append(str);
        stringBuilder.append("] [");
        stringBuilder.append(this.f4646a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f4650e);
        stringBuilder.append("] [");
        stringBuilder.append(Util.f5287e);
        stringBuilder.append("]");
        Log.d("MediaCodecInfo", stringBuilder.toString());
    }

    public static int m3885a(String str, String str2, int i) {
        if (i <= 1) {
            if (Util.f5283a < 26 || i <= 0) {
                if (!("audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2))) {
                    if (!"audio/gsm".equals(str2)) {
                        str2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) != null ? 16 : 30;
                        StringBuilder stringBuilder = new StringBuilder("AssumedMaxChannelAdjustment: ");
                        stringBuilder.append(str);
                        stringBuilder.append(", [");
                        stringBuilder.append(i);
                        stringBuilder.append(" to ");
                        stringBuilder.append(str2);
                        stringBuilder.append("]");
                        Log.w("MediaCodecInfo", stringBuilder.toString());
                        return str2;
                    }
                }
                return i;
            }
        }
        return i;
    }

    @TargetApi(21)
    private static boolean m3888a(VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (d != -1.0d) {
            if (d > 0.0d) {
                return videoCapabilities.areSizeAndRateSupported(i, i2, d);
            }
        }
        return videoCapabilities.isSizeSupported(i, i2);
    }
}
