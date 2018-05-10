package com.google.android.exoplayer2.text.subrip;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SubripDecoder extends SimpleSubtitleDecoder {
    private static final Pattern f19041c = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private final StringBuilder f19042d = new StringBuilder();

    protected final /* bridge */ /* synthetic */ Subtitle mo3931a(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        return m20101a(bArr, i);
    }

    public SubripDecoder() {
        super("SubripDecoder");
    }

    private com.google.android.exoplayer2.text.subrip.SubripSubtitle m20101a(byte[] r7, int r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = new com.google.android.exoplayer2.util.LongArray;
        r1.<init>();
        r2 = new com.google.android.exoplayer2.util.ParsableByteArray;
        r2.<init>(r7, r8);
    L_0x000f:
        r7 = r2.m4267r();
        if (r7 == 0) goto L_0x00c2;
    L_0x0015:
        r8 = r7.length();
        if (r8 == 0) goto L_0x000f;
    L_0x001b:
        java.lang.Integer.parseInt(r7);	 Catch:{ NumberFormatException -> 0x00ad }
        r7 = r2.m4267r();
        if (r7 != 0) goto L_0x002d;
    L_0x0024:
        r7 = "SubripDecoder";
        r8 = "Unexpected end";
        android.util.Log.w(r7, r8);
        goto L_0x00c2;
    L_0x002d:
        r8 = f19041c;
        r8 = r8.matcher(r7);
        r3 = r8.matches();
        if (r3 == 0) goto L_0x0098;
    L_0x0039:
        r7 = 1;
        r3 = m20100a(r8, r7);
        r1.m4207a(r3);
        r3 = 6;
        r4 = r8.group(r3);
        r4 = android.text.TextUtils.isEmpty(r4);
        r5 = 0;
        if (r4 != 0) goto L_0x0055;
    L_0x004d:
        r3 = m20100a(r8, r3);
        r1.m4207a(r3);
        goto L_0x0056;
    L_0x0055:
        r7 = r5;
    L_0x0056:
        r8 = r6.f19042d;
        r8.setLength(r5);
    L_0x005b:
        r8 = r2.m4267r();
        r3 = android.text.TextUtils.isEmpty(r8);
        if (r3 != 0) goto L_0x007e;
    L_0x0065:
        r3 = r6.f19042d;
        r3 = r3.length();
        if (r3 <= 0) goto L_0x0074;
    L_0x006d:
        r3 = r6.f19042d;
        r4 = "<br>";
        r3.append(r4);
    L_0x0074:
        r3 = r6.f19042d;
        r8 = r8.trim();
        r3.append(r8);
        goto L_0x005b;
    L_0x007e:
        r8 = r6.f19042d;
        r8 = r8.toString();
        r8 = android.text.Html.fromHtml(r8);
        r3 = new com.google.android.exoplayer2.text.Cue;
        r3.<init>(r8);
        r0.add(r3);
        if (r7 == 0) goto L_0x000f;
    L_0x0092:
        r7 = 0;
        r0.add(r7);
        goto L_0x000f;
    L_0x0098:
        r8 = "SubripDecoder";
        r3 = new java.lang.StringBuilder;
        r4 = "Skipping invalid timing: ";
        r3.<init>(r4);
        r3.append(r7);
        r7 = r3.toString();
        android.util.Log.w(r8, r7);
        goto L_0x000f;
    L_0x00ad:
        r8 = "SubripDecoder";
        r3 = new java.lang.StringBuilder;
        r4 = "Skipping invalid index: ";
        r3.<init>(r4);
        r3.append(r7);
        r7 = r3.toString();
        android.util.Log.w(r8, r7);
        goto L_0x000f;
    L_0x00c2:
        r7 = r0.size();
        r7 = new com.google.android.exoplayer2.text.Cue[r7];
        r0.toArray(r7);
        r8 = r1.m4208a();
        r0 = new com.google.android.exoplayer2.text.subrip.SubripSubtitle;
        r0.<init>(r7, r8);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.subrip.SubripDecoder.a(byte[], int):com.google.android.exoplayer2.text.subrip.SubripSubtitle");
    }

    private static long m20100a(Matcher matcher, int i) {
        return ((((((Long.parseLong(matcher.group(i + 1)) * 60) * 60) * 1000) + ((Long.parseLong(matcher.group(i + 2)) * 60) * 1000)) + (Long.parseLong(matcher.group(i + 3)) * 1000)) + Long.parseLong(matcher.group(i + 4))) * 1000;
    }
}
