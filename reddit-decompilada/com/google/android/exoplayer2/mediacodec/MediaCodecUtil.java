package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.ads.AdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.jcodec.codecs.mpeg12.MPEGConst;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class MediaCodecUtil {
    private static final MediaCodecInfo f4659a = MediaCodecInfo.m3886a("OMX.google.raw.decoder");
    private static final Pattern f4660b = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<CodecKey, List<MediaCodecInfo>> f4661c = new HashMap();
    private static final SparseIntArray f4662d;
    private static final SparseIntArray f4663e;
    private static final Map<String, Integer> f4664f;
    private static int f4665g = -1;

    private static final class CodecKey {
        public final String f4657a;
        public final boolean f4658b;

        public CodecKey(String str, boolean z) {
            this.f4657a = str;
            this.f4658b = z;
        }

        public final int hashCode() {
            return (31 * ((this.f4657a == null ? 0 : this.f4657a.hashCode()) + 31)) + (this.f4658b ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (obj.getClass() == CodecKey.class) {
                    CodecKey codecKey = (CodecKey) obj;
                    return TextUtils.equals(this.f4657a, codecKey.f4657a) && this.f4658b == codecKey.f4658b;
                }
            }
            return false;
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private interface MediaCodecListCompat {
        int mo1390a();

        MediaCodecInfo mo1391a(int i);

        boolean mo1392a(String str, CodecCapabilities codecCapabilities);

        boolean mo1393b();
    }

    private static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        public final boolean mo1393b() {
            return false;
        }

        private MediaCodecListCompatV16() {
        }

        public final int mo1390a() {
            return MediaCodecList.getCodecCount();
        }

        public final MediaCodecInfo mo1391a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public final boolean mo1392a(String str, CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    @TargetApi(21)
    private static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int f13220a;
        private MediaCodecInfo[] f13221b;

        public final boolean mo1393b() {
            return true;
        }

        public MediaCodecListCompatV21(boolean z) {
            this.f13220a = z;
        }

        public final int mo1390a() {
            m12275c();
            return this.f13221b.length;
        }

        public final MediaCodecInfo mo1391a(int i) {
            m12275c();
            return this.f13221b[i];
        }

        public final boolean mo1392a(String str, CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void m12275c() {
            if (this.f13221b == null) {
                this.f13221b = new MediaCodecList(this.f13220a).getCodecInfos();
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4662d = sparseIntArray;
        sparseIntArray.put(66, 1);
        f4662d.put(77, 2);
        f4662d.put(88, 4);
        f4662d.put(100, 8);
        sparseIntArray = new SparseIntArray();
        f4663e = sparseIntArray;
        sparseIntArray.put(10, 1);
        f4663e.put(11, 4);
        f4663e.put(12, 8);
        f4663e.put(13, 16);
        f4663e.put(20, 32);
        f4663e.put(21, 64);
        f4663e.put(22, 128);
        f4663e.put(30, 256);
        f4663e.put(31, AdRequest.MAX_CONTENT_URL_LENGTH);
        f4663e.put(32, 1024);
        f4663e.put(40, MPEGConst.CODE_END);
        f4663e.put(41, 4096);
        f4663e.put(42, 8192);
        f4663e.put(50, 16384);
        f4663e.put(51, 32768);
        f4663e.put(52, 65536);
        Map hashMap = new HashMap();
        f4664f = hashMap;
        hashMap.put("L30", Integer.valueOf(1));
        f4664f.put("L60", Integer.valueOf(4));
        f4664f.put("L63", Integer.valueOf(16));
        f4664f.put("L90", Integer.valueOf(64));
        f4664f.put("L93", Integer.valueOf(256));
        f4664f.put("L120", Integer.valueOf(1024));
        f4664f.put("L123", Integer.valueOf(4096));
        f4664f.put("L150", Integer.valueOf(16384));
        f4664f.put("L153", Integer.valueOf(65536));
        f4664f.put("L156", Integer.valueOf(262144));
        f4664f.put("L180", Integer.valueOf(1048576));
        f4664f.put("L183", Integer.valueOf(4194304));
        f4664f.put("L186", Integer.valueOf(16777216));
        f4664f.put("H30", Integer.valueOf(2));
        f4664f.put("H60", Integer.valueOf(8));
        f4664f.put("H63", Integer.valueOf(32));
        f4664f.put("H90", Integer.valueOf(128));
        f4664f.put("H93", Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH));
        f4664f.put("H120", Integer.valueOf(MPEGConst.CODE_END));
        f4664f.put("H123", Integer.valueOf(8192));
        f4664f.put("H150", Integer.valueOf(32768));
        f4664f.put("H153", Integer.valueOf(131072));
        f4664f.put("H156", Integer.valueOf(524288));
        f4664f.put("H180", Integer.valueOf(2097152));
        f4664f.put("H183", Integer.valueOf(8388608));
        f4664f.put("H186", Integer.valueOf(33554432));
    }

    public static MediaCodecInfo m3900a() {
        return f4659a;
    }

    public static MediaCodecInfo m3901a(String str, boolean z) throws DecoderQueryException {
        str = m3905b(str, z);
        return str.isEmpty() ? null : (MediaCodecInfo) str.get(false);
    }

    private static synchronized List<MediaCodecInfo> m3905b(String str, boolean z) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            CodecKey codecKey = new CodecKey(str, z);
            List<MediaCodecInfo> list = (List) f4661c.get(codecKey);
            if (list != null) {
                return list;
            }
            List a = m3902a(codecKey, Util.f5283a >= 21 ? new MediaCodecListCompatV21(z) : new MediaCodecListCompatV16());
            if (z && a.isEmpty() && true <= Util.f5283a && Util.f5283a <= true) {
                a = m3902a(codecKey, new MediaCodecListCompatV16());
                if (!a.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder("MediaCodecList API didn't list secure decoder for: ");
                    stringBuilder.append(str);
                    stringBuilder.append(". Assuming: ");
                    stringBuilder.append(((MediaCodecInfo) a.get(0)).f4646a);
                    Log.w("MediaCodecUtil", stringBuilder.toString());
                }
            }
            m3903a(a);
            str = Collections.unmodifiableList(a);
            f4661c.put(codecKey, str);
            return str;
        }
    }

    public static int m3904b() throws DecoderQueryException {
        if (f4665g == -1) {
            int i = 0;
            MediaCodecInfo a = m3901a("video/avc", false);
            if (a != null) {
                CodecProfileLevel[] a2 = a.m3890a();
                int length = a2.length;
                int i2 = 0;
                while (i < length) {
                    int i3;
                    switch (a2[i].level) {
                        case 1:
                        case 2:
                            i3 = 25344;
                            break;
                        case 8:
                        case 16:
                        case 32:
                            i3 = 101376;
                            break;
                        case 64:
                            i3 = 202752;
                            break;
                        case 128:
                        case 256:
                            i3 = 414720;
                            break;
                        case AdRequest.MAX_CONTENT_URL_LENGTH /*512*/:
                            i3 = 921600;
                            break;
                        case 1024:
                            i3 = 1310720;
                            break;
                        case MPEGConst.CODE_END /*2048*/:
                        case 4096:
                            i3 = 2097152;
                            break;
                        case 8192:
                            i3 = 2228224;
                            break;
                        case 16384:
                            i3 = 5652480;
                            break;
                        case 32768:
                        case 65536:
                            i3 = 9437184;
                            break;
                        default:
                            i3 = -1;
                            break;
                    }
                    i2 = Math.max(i3, i2);
                    i++;
                }
                i = Math.max(i2, Util.f5283a >= 21 ? 345600 : 172800);
            }
            f4665g = i;
        }
        return f4665g;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> m3898a(java.lang.String r9) {
        /*
        r0 = 0;
        if (r9 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "\\.";
        r1 = r9.split(r1);
        r2 = 0;
        r3 = r1[r2];
        r4 = -1;
        r5 = r3.hashCode();
        r6 = 2;
        r7 = 3;
        r8 = 1;
        switch(r5) {
            case 3006243: goto L_0x0036;
            case 3006244: goto L_0x002c;
            case 3199032: goto L_0x0023;
            case 3214780: goto L_0x0019;
            default: goto L_0x0018;
        };
    L_0x0018:
        goto L_0x0040;
    L_0x0019:
        r2 = "hvc1";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x0040;
    L_0x0021:
        r2 = r8;
        goto L_0x0041;
    L_0x0023:
        r5 = "hev1";
        r3 = r3.equals(r5);
        if (r3 == 0) goto L_0x0040;
    L_0x002b:
        goto L_0x0041;
    L_0x002c:
        r2 = "avc2";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x0040;
    L_0x0034:
        r2 = r7;
        goto L_0x0041;
    L_0x0036:
        r2 = "avc1";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x0040;
    L_0x003e:
        r2 = r6;
        goto L_0x0041;
    L_0x0040:
        r2 = r4;
    L_0x0041:
        switch(r2) {
            case 0: goto L_0x004a;
            case 1: goto L_0x004a;
            case 2: goto L_0x0045;
            case 3: goto L_0x0045;
            default: goto L_0x0044;
        };
    L_0x0044:
        return r0;
    L_0x0045:
        r9 = m3899a(r9, r1);
        return r9;
    L_0x004a:
        r2 = r1.length;
        r3 = 4;
        if (r2 >= r3) goto L_0x0062;
    L_0x004e:
        r1 = "MediaCodecUtil";
        r2 = new java.lang.StringBuilder;
        r3 = "Ignoring malformed HEVC codec string: ";
        r2.<init>(r3);
        r2.append(r9);
        r9 = r2.toString();
        android.util.Log.w(r1, r9);
        return r0;
    L_0x0062:
        r2 = f4660b;
        r3 = r1[r8];
        r2 = r2.matcher(r3);
        r3 = r2.matches();
        if (r3 != 0) goto L_0x0084;
    L_0x0070:
        r1 = "MediaCodecUtil";
        r2 = new java.lang.StringBuilder;
        r3 = "Ignoring malformed HEVC codec string: ";
        r2.<init>(r3);
        r2.append(r9);
        r9 = r2.toString();
        android.util.Log.w(r1, r9);
        return r0;
    L_0x0084:
        r9 = r2.group(r8);
        r3 = "1";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x0092;
    L_0x0090:
        r6 = r8;
        goto L_0x009a;
    L_0x0092:
        r3 = "2";
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x00c8;
    L_0x009a:
        r9 = f4664f;
        r1 = r1[r7];
        r9 = r9.get(r1);
        r9 = (java.lang.Integer) r9;
        if (r9 != 0) goto L_0x00be;
    L_0x00a6:
        r9 = "MediaCodecUtil";
        r1 = new java.lang.StringBuilder;
        r3 = "Unknown HEVC level string: ";
        r1.<init>(r3);
        r2 = r2.group(r8);
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r9, r1);
        return r0;
    L_0x00be:
        r0 = new android.util.Pair;
        r1 = java.lang.Integer.valueOf(r6);
        r0.<init>(r1, r9);
        return r0;
    L_0x00c8:
        r1 = "MediaCodecUtil";
        r2 = new java.lang.StringBuilder;
        r3 = "Unknown HEVC profile string: ";
        r2.<init>(r3);
        r2.append(r9);
        r9 = r2.toString();
        android.util.Log.w(r1, r9);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.a(java.lang.String):android.util.Pair<java.lang.Integer, java.lang.Integer>");
    }

    private static List<MediaCodecInfo> m3902a(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat) throws DecoderQueryException {
        int i;
        int i2;
        Exception e;
        Exception exception;
        CodecKey codecKey2 = codecKey;
        MediaCodecListCompat mediaCodecListCompat2 = mediaCodecListCompat;
        try {
            List<MediaCodecInfo> arrayList = new ArrayList();
            String str = codecKey2.f4657a;
            int a = mediaCodecListCompat.mo1390a();
            boolean b = mediaCodecListCompat.mo1393b();
            int i3 = 0;
            while (i3 < a) {
                Object obj;
                String[] supportedTypes;
                int length;
                String str2;
                CodecCapabilities capabilitiesForType;
                boolean a2;
                boolean z;
                StringBuilder stringBuilder;
                MediaCodecInfo a3 = mediaCodecListCompat2.mo1391a(i3);
                String name = a3.getName();
                if (!a3.isEncoder()) {
                    if (b || !name.endsWith(".secure")) {
                        if (Util.f5283a < 21) {
                            if (!("CIPAACDecoder".equals(name) || "CIPMP3Decoder".equals(name) || "CIPVorbisDecoder".equals(name) || "CIPAMRNBDecoder".equals(name) || "AACDecoder".equals(name))) {
                                if ("MP3Decoder".equals(name)) {
                                }
                            }
                        }
                        if (Util.f5283a >= 18 || !"OMX.SEC.MP3.Decoder".equals(name)) {
                            if (Util.f5283a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(name)) {
                                if (!"a70".equals(Util.f5284b)) {
                                    if ("Xiaomi".equals(Util.f5285c) && Util.f5284b.startsWith("HM")) {
                                    }
                                }
                            }
                            if (Util.f5283a == 16 && "OMX.qcom.audio.decoder.mp3".equals(name)) {
                                if (!("dlxu".equals(Util.f5284b) || "protou".equals(Util.f5284b) || "ville".equals(Util.f5284b) || "villeplus".equals(Util.f5284b) || "villec2".equals(Util.f5284b) || Util.f5284b.startsWith("gee") || "C6602".equals(Util.f5284b) || "C6603".equals(Util.f5284b) || "C6606".equals(Util.f5284b) || "C6616".equals(Util.f5284b) || "L36h".equals(Util.f5284b))) {
                                    if ("SO-02E".equals(Util.f5284b)) {
                                    }
                                }
                            }
                            if (Util.f5283a == 16 && "OMX.qcom.audio.decoder.aac".equals(name)) {
                                if (!("C1504".equals(Util.f5284b) || "C1505".equals(Util.f5284b) || "C1604".equals(Util.f5284b))) {
                                    if ("C1605".equals(Util.f5284b)) {
                                    }
                                }
                            }
                            if (Util.f5283a < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && Util.f5285c.equals("samsung"))) {
                                if (!(Util.f5284b.startsWith("zeroflte") || Util.f5284b.startsWith("zerolte") || Util.f5284b.startsWith("zenlte") || Util.f5284b.equals("SC-05G") || Util.f5284b.equals("marinelteatt") || Util.f5284b.equals("404SC") || Util.f5284b.equals("SC-04G"))) {
                                    if (Util.f5284b.equals("SCV31")) {
                                    }
                                }
                            }
                            if (Util.f5283a <= 19 && "OMX.SEC.vp8.dec".equals(name) && "samsung".equals(Util.f5285c)) {
                                if (!(Util.f5284b.startsWith("d2") || Util.f5284b.startsWith("serrano") || Util.f5284b.startsWith("jflte") || Util.f5284b.startsWith("santos"))) {
                                    if (Util.f5284b.startsWith("t0")) {
                                    }
                                }
                            }
                            if (Util.f5283a > 19 || !Util.f5284b.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(name)) {
                                obj = 1;
                                if (obj != null) {
                                    supportedTypes = a3.getSupportedTypes();
                                    length = supportedTypes.length;
                                    i = 0;
                                    while (i < length) {
                                        str2 = supportedTypes[i];
                                        if (str2.equalsIgnoreCase(str)) {
                                            i2 = a;
                                        } else {
                                            try {
                                                capabilitiesForType = a3.getCapabilitiesForType(str2);
                                                a2 = mediaCodecListCompat2.mo1392a(str, capabilitiesForType);
                                                i2 = a;
                                                if (Util.f5283a <= 22) {
                                                    try {
                                                        if ((Util.f5286d.equals("ODROID-XU3") || Util.f5286d.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                                                            z = true;
                                                            if (b) {
                                                                if (codecKey2.f4658b != a2) {
                                                                }
                                                                arrayList.add(MediaCodecInfo.m3887a(name, str, capabilitiesForType, z, false));
                                                            }
                                                            if (b && !codecKey2.f4658b) {
                                                                arrayList.add(MediaCodecInfo.m3887a(name, str, capabilitiesForType, z, false));
                                                            } else if (!b && a2) {
                                                                stringBuilder = new StringBuilder();
                                                                stringBuilder.append(name);
                                                                stringBuilder.append(".secure");
                                                                try {
                                                                    arrayList.add(MediaCodecInfo.m3887a(stringBuilder.toString(), str, capabilitiesForType, z, true));
                                                                    return arrayList;
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                }
                                                            }
                                                        }
                                                    } catch (Exception e3) {
                                                        exception = e3;
                                                        if (Util.f5283a > 23) {
                                                        }
                                                        stringBuilder = new StringBuilder("Failed to query codec ");
                                                        stringBuilder.append(name);
                                                        stringBuilder.append(" (");
                                                        stringBuilder.append(str2);
                                                        stringBuilder.append(")");
                                                        Log.e("MediaCodecUtil", stringBuilder.toString());
                                                        throw exception;
                                                    }
                                                }
                                                z = false;
                                                if (b) {
                                                    if (codecKey2.f4658b != a2) {
                                                    }
                                                    arrayList.add(MediaCodecInfo.m3887a(name, str, capabilitiesForType, z, false));
                                                }
                                                if (b) {
                                                }
                                                try {
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append(name);
                                                    stringBuilder.append(".secure");
                                                    arrayList.add(MediaCodecInfo.m3887a(stringBuilder.toString(), str, capabilitiesForType, z, true));
                                                    return arrayList;
                                                } catch (Exception e4) {
                                                    e3 = e4;
                                                    exception = e3;
                                                    if (Util.f5283a > 23) {
                                                    }
                                                    stringBuilder = new StringBuilder("Failed to query codec ");
                                                    stringBuilder.append(name);
                                                    stringBuilder.append(" (");
                                                    stringBuilder.append(str2);
                                                    stringBuilder.append(")");
                                                    Log.e("MediaCodecUtil", stringBuilder.toString());
                                                    throw exception;
                                                }
                                            } catch (Exception e5) {
                                                e3 = e5;
                                                i2 = a;
                                                exception = e3;
                                                if (Util.f5283a > 23 || arrayList.isEmpty()) {
                                                    stringBuilder = new StringBuilder("Failed to query codec ");
                                                    stringBuilder.append(name);
                                                    stringBuilder.append(" (");
                                                    stringBuilder.append(str2);
                                                    stringBuilder.append(")");
                                                    Log.e("MediaCodecUtil", stringBuilder.toString());
                                                    throw exception;
                                                }
                                                stringBuilder = new StringBuilder("Skipping codec ");
                                                stringBuilder.append(name);
                                                stringBuilder.append(" (failed to query capabilities)");
                                                Log.e("MediaCodecUtil", stringBuilder.toString());
                                                i++;
                                                a = i2;
                                                mediaCodecListCompat2 = mediaCodecListCompat;
                                            }
                                        }
                                        i++;
                                        a = i2;
                                        mediaCodecListCompat2 = mediaCodecListCompat;
                                    }
                                    continue;
                                }
                                i3++;
                                a = a;
                                mediaCodecListCompat2 = mediaCodecListCompat;
                            }
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    supportedTypes = a3.getSupportedTypes();
                    length = supportedTypes.length;
                    i = 0;
                    while (i < length) {
                        str2 = supportedTypes[i];
                        if (str2.equalsIgnoreCase(str)) {
                            i2 = a;
                        } else {
                            capabilitiesForType = a3.getCapabilitiesForType(str2);
                            a2 = mediaCodecListCompat2.mo1392a(str, capabilitiesForType);
                            i2 = a;
                            if (Util.f5283a <= 22) {
                                z = true;
                                if (b) {
                                    if (codecKey2.f4658b != a2) {
                                    }
                                    arrayList.add(MediaCodecInfo.m3887a(name, str, capabilitiesForType, z, false));
                                }
                                if (b) {
                                }
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(name);
                                stringBuilder.append(".secure");
                                arrayList.add(MediaCodecInfo.m3887a(stringBuilder.toString(), str, capabilitiesForType, z, true));
                                return arrayList;
                            }
                            z = false;
                            if (b) {
                                if (codecKey2.f4658b != a2) {
                                }
                                arrayList.add(MediaCodecInfo.m3887a(name, str, capabilitiesForType, z, false));
                            }
                            if (b) {
                            }
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(name);
                            stringBuilder.append(".secure");
                            arrayList.add(MediaCodecInfo.m3887a(stringBuilder.toString(), str, capabilitiesForType, z, true));
                            return arrayList;
                        }
                        i++;
                        a = i2;
                        mediaCodecListCompat2 = mediaCodecListCompat;
                    }
                    continue;
                }
                i3++;
                a = a;
                mediaCodecListCompat2 = mediaCodecListCompat;
            }
            return arrayList;
        } catch (Throwable e6) {
            throw new DecoderQueryException(e6);
        }
    }

    private static void m3903a(List<MediaCodecInfo> list) {
        if (Util.f5283a < 26) {
            int i = 1;
            if (list.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(((MediaCodecInfo) list.get(0)).f4646a)) {
                while (i < list.size()) {
                    MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) list.get(i);
                    if ("OMX.google.raw.decoder".equals(mediaCodecInfo.f4646a)) {
                        list.remove(i);
                        list.add(0, mediaCodecInfo);
                        return;
                    }
                    i++;
                }
            }
        }
    }

    private static android.util.Pair<java.lang.Integer, java.lang.Integer> m3899a(java.lang.String r5, java.lang.String[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 2;
        r1 = 0;
        r2 = r6.length;
        if (r2 >= r0) goto L_0x0019;
    L_0x0005:
        r6 = "MediaCodecUtil";
        r0 = new java.lang.StringBuilder;
        r2 = "Ignoring malformed AVC codec string: ";
        r0.<init>(r2);
        r0.append(r5);
        r5 = r0.toString();
        android.util.Log.w(r6, r5);
        return r1;
    L_0x0019:
        r2 = 1;
        r3 = r6[r2];	 Catch:{ NumberFormatException -> 0x00bf }
        r3 = r3.length();	 Catch:{ NumberFormatException -> 0x00bf }
        r4 = 6;	 Catch:{ NumberFormatException -> 0x00bf }
        if (r3 != r4) goto L_0x0044;	 Catch:{ NumberFormatException -> 0x00bf }
    L_0x0023:
        r3 = r6[r2];	 Catch:{ NumberFormatException -> 0x00bf }
        r4 = 0;	 Catch:{ NumberFormatException -> 0x00bf }
        r0 = r3.substring(r4, r0);	 Catch:{ NumberFormatException -> 0x00bf }
        r3 = 16;	 Catch:{ NumberFormatException -> 0x00bf }
        r0 = java.lang.Integer.parseInt(r0, r3);	 Catch:{ NumberFormatException -> 0x00bf }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x00bf }
        r6 = r6[r2];	 Catch:{ NumberFormatException -> 0x00bf }
        r2 = 4;	 Catch:{ NumberFormatException -> 0x00bf }
        r6 = r6.substring(r2);	 Catch:{ NumberFormatException -> 0x00bf }
        r6 = java.lang.Integer.parseInt(r6, r3);	 Catch:{ NumberFormatException -> 0x00bf }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ NumberFormatException -> 0x00bf }
        goto L_0x005d;	 Catch:{ NumberFormatException -> 0x00bf }
    L_0x0044:
        r3 = r6.length;	 Catch:{ NumberFormatException -> 0x00bf }
        r4 = 3;	 Catch:{ NumberFormatException -> 0x00bf }
        if (r3 < r4) goto L_0x00ab;	 Catch:{ NumberFormatException -> 0x00bf }
    L_0x0048:
        r2 = r6[r2];	 Catch:{ NumberFormatException -> 0x00bf }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x00bf }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ NumberFormatException -> 0x00bf }
        r6 = r6[r0];	 Catch:{ NumberFormatException -> 0x00bf }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x00bf }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ NumberFormatException -> 0x00bf }
        r0 = r2;
    L_0x005d:
        r5 = f4662d;
        r2 = r0.intValue();
        r5 = r5.get(r2);
        r5 = java.lang.Integer.valueOf(r5);
        if (r5 != 0) goto L_0x0081;
    L_0x006d:
        r5 = "MediaCodecUtil";
        r6 = new java.lang.StringBuilder;
        r2 = "Unknown AVC profile: ";
        r6.<init>(r2);
        r6.append(r0);
        r6 = r6.toString();
        android.util.Log.w(r5, r6);
        return r1;
    L_0x0081:
        r0 = f4663e;
        r2 = r6.intValue();
        r0 = r0.get(r2);
        r0 = java.lang.Integer.valueOf(r0);
        if (r0 != 0) goto L_0x00a5;
    L_0x0091:
        r5 = "MediaCodecUtil";
        r0 = new java.lang.StringBuilder;
        r2 = "Unknown AVC level: ";
        r0.<init>(r2);
        r0.append(r6);
        r6 = r0.toString();
        android.util.Log.w(r5, r6);
        return r1;
    L_0x00a5:
        r6 = new android.util.Pair;
        r6.<init>(r5, r0);
        return r6;
    L_0x00ab:
        r6 = "MediaCodecUtil";	 Catch:{ NumberFormatException -> 0x00bf }
        r0 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x00bf }
        r2 = "Ignoring malformed AVC codec string: ";	 Catch:{ NumberFormatException -> 0x00bf }
        r0.<init>(r2);	 Catch:{ NumberFormatException -> 0x00bf }
        r0.append(r5);	 Catch:{ NumberFormatException -> 0x00bf }
        r0 = r0.toString();	 Catch:{ NumberFormatException -> 0x00bf }
        android.util.Log.w(r6, r0);	 Catch:{ NumberFormatException -> 0x00bf }
        return r1;
    L_0x00bf:
        r6 = "MediaCodecUtil";
        r0 = new java.lang.StringBuilder;
        r2 = "Ignoring malformed AVC codec string: ";
        r0.<init>(r2);
        r0.append(r5);
        r5 = r0.toString();
        android.util.Log.w(r6, r5);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.a(java.lang.String, java.lang.String[]):android.util.Pair<java.lang.Integer, java.lang.Integer>");
    }
}
