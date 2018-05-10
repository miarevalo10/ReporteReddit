package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;

public interface SubtitleDecoderFactory {
    public static final SubtitleDecoderFactory f4940a = new C11421();

    static class C11421 implements SubtitleDecoderFactory {
        C11421() {
        }

        public final boolean mo1448a(Format format) {
            format = format.f4018f;
            if (!("text/vtt".equals(format) || "text/x-ssa".equals(format) || "application/ttml+xml".equals(format) || "application/x-mp4-vtt".equals(format) || "application/x-subrip".equals(format) || "application/x-quicktime-tx3g".equals(format) || "application/cea-608".equals(format) || "application/x-mp4-cea-608".equals(format) || "application/cea-708".equals(format))) {
                if ("application/dvbsubs".equals(format) == null) {
                    return null;
                }
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.android.exoplayer2.text.SubtitleDecoder mo1449b(com.google.android.exoplayer2.Format r3) {
            /*
            r2 = this;
            r0 = r3.f4018f;
            r1 = r0.hashCode();
            switch(r1) {
                case -1351681404: goto L_0x0066;
                case -1026075066: goto L_0x005c;
                case -1004728940: goto L_0x0052;
                case 691401887: goto L_0x0048;
                case 822864842: goto L_0x003e;
                case 930165504: goto L_0x0034;
                case 1566015601: goto L_0x002a;
                case 1566016562: goto L_0x001f;
                case 1668750253: goto L_0x0015;
                case 1693976202: goto L_0x000b;
                default: goto L_0x0009;
            };
        L_0x0009:
            goto L_0x0071;
        L_0x000b:
            r1 = "application/ttml+xml";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0013:
            r0 = 3;
            goto L_0x0072;
        L_0x0015:
            r1 = "application/x-subrip";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x001d:
            r0 = 4;
            goto L_0x0072;
        L_0x001f:
            r1 = "application/cea-708";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0027:
            r0 = 8;
            goto L_0x0072;
        L_0x002a:
            r1 = "application/cea-608";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0032:
            r0 = 6;
            goto L_0x0072;
        L_0x0034:
            r1 = "application/x-mp4-cea-608";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x003c:
            r0 = 7;
            goto L_0x0072;
        L_0x003e:
            r1 = "text/x-ssa";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0046:
            r0 = 1;
            goto L_0x0072;
        L_0x0048:
            r1 = "application/x-quicktime-tx3g";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0050:
            r0 = 5;
            goto L_0x0072;
        L_0x0052:
            r1 = "text/vtt";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x005a:
            r0 = 0;
            goto L_0x0072;
        L_0x005c:
            r1 = "application/x-mp4-vtt";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x0064:
            r0 = 2;
            goto L_0x0072;
        L_0x0066:
            r1 = "application/dvbsubs";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0071;
        L_0x006e:
            r0 = 9;
            goto L_0x0072;
        L_0x0071:
            r0 = -1;
        L_0x0072:
            switch(r0) {
                case 0: goto L_0x00b9;
                case 1: goto L_0x00b1;
                case 2: goto L_0x00ab;
                case 3: goto L_0x00a5;
                case 4: goto L_0x009f;
                case 5: goto L_0x0097;
                case 6: goto L_0x008d;
                case 7: goto L_0x008d;
                case 8: goto L_0x0085;
                case 9: goto L_0x007d;
                default: goto L_0x0075;
            };
        L_0x0075:
            r3 = new java.lang.IllegalArgumentException;
            r0 = "Attempted to create decoder for unsupported format";
            r3.<init>(r0);
            throw r3;
        L_0x007d:
            r0 = new com.google.android.exoplayer2.text.dvb.DvbDecoder;
            r3 = r3.f4020h;
            r0.<init>(r3);
            return r0;
        L_0x0085:
            r0 = new com.google.android.exoplayer2.text.cea.Cea708Decoder;
            r3 = r3.f4038z;
            r0.<init>(r3);
            return r0;
        L_0x008d:
            r0 = new com.google.android.exoplayer2.text.cea.Cea608Decoder;
            r1 = r3.f4018f;
            r3 = r3.f4038z;
            r0.<init>(r1, r3);
            return r0;
        L_0x0097:
            r0 = new com.google.android.exoplayer2.text.tx3g.Tx3gDecoder;
            r3 = r3.f4020h;
            r0.<init>(r3);
            return r0;
        L_0x009f:
            r3 = new com.google.android.exoplayer2.text.subrip.SubripDecoder;
            r3.<init>();
            return r3;
        L_0x00a5:
            r3 = new com.google.android.exoplayer2.text.ttml.TtmlDecoder;
            r3.<init>();
            return r3;
        L_0x00ab:
            r3 = new com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder;
            r3.<init>();
            return r3;
        L_0x00b1:
            r0 = new com.google.android.exoplayer2.text.ssa.SsaDecoder;
            r3 = r3.f4020h;
            r0.<init>(r3);
            return r0;
        L_0x00b9:
            r3 = new com.google.android.exoplayer2.text.webvtt.WebvttDecoder;
            r3.<init>();
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.SubtitleDecoderFactory.1.b(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.text.SubtitleDecoder");
        }
    }

    boolean mo1448a(Format format);

    SubtitleDecoder mo1449b(Format format);
}
