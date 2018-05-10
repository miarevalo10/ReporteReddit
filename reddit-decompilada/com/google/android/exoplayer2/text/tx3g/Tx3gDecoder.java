package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.charset.Charset;
import java.util.List;

public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private static final int f19049c = Util.m4326g("styl");
    private static final int f19050d = Util.m4326g("tbox");
    private final ParsableByteArray f19051e = new ParsableByteArray();
    private boolean f19052f;
    private int f19053g;
    private int f19054h;
    private String f19055i;
    private float f19056j;
    private int f19057k;

    public Tx3gDecoder(List<byte[]> list) {
        super("Tx3gDecoder");
        boolean z = false;
        if (list != null && list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            byte[] bArr = (byte[]) list.get(0);
            this.f19053g = bArr[24];
            this.f19054h = ((((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16)) | ((bArr[28] & 255) << 8)) | (bArr[29] & 255);
            this.f19055i = "Serif".equals(new String(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
            this.f19057k = 20 * bArr[25];
            if ((bArr[0] & 32) != 0) {
                z = true;
            }
            this.f19052f = z;
            if (this.f19052f) {
                this.f19056j = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) this.f19057k);
                this.f19056j = Util.m4295a(this.f19056j, 0.0f, 0.95f);
                return;
            }
            this.f19056j = 0.85f;
            return;
        }
        this.f19053g = 0;
        this.f19054h = -1;
        this.f19055i = "sans-serif";
        this.f19052f = false;
        this.f19056j = 0.85f;
    }

    protected final Subtitle mo3931a(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        CharSequence charSequence;
        this.f19051e.m4244a(bArr, i);
        ParsableByteArray parsableByteArray = this.f19051e;
        m20112a(parsableByteArray.m4246b() >= 2);
        int e = parsableByteArray.m4252e();
        if (e == 0) {
            charSequence = "";
        } else {
            if (parsableByteArray.m4246b() >= 2) {
                char c = (char) (((parsableByteArray.f5256a[parsableByteArray.f5257b] & 255) << 8) | (parsableByteArray.f5256a[parsableByteArray.f5257b + 1] & 255));
                if (c == '﻿' || c == '￾') {
                    charSequence = parsableByteArray.m4240a(e, Charset.forName("UTF-16"));
                }
            }
            charSequence = parsableByteArray.m4240a(e, Charset.forName("UTF-8"));
        }
        if (charSequence.isEmpty()) {
            return Tx3gSubtitle.f13568a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        m20111a(spannableStringBuilder2, r0.f19053g, 0, 0, spannableStringBuilder.length(), 16711680);
        m20113b(spannableStringBuilder2, r0.f19054h, -1, 0, spannableStringBuilder.length(), 16711680);
        String str = r0.f19055i;
        String str2 = "sans-serif";
        int length = spannableStringBuilder.length();
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float f = r0.f19056j;
        while (r0.f19051e.m4246b() >= 8) {
            e = r0.f19051e.f5257b;
            int j = r0.f19051e.m4259j();
            length = r0.f19051e.m4259j();
            if (length == f19049c) {
                m20112a(r0.f19051e.m4246b() >= 2);
                int e2 = r0.f19051e.m4252e();
                int i2 = 0;
                while (i2 < e2) {
                    ParsableByteArray parsableByteArray2 = r0.f19051e;
                    m20112a(parsableByteArray2.m4246b() >= 12);
                    int e3 = parsableByteArray2.m4252e();
                    int e4 = parsableByteArray2.m4252e();
                    parsableByteArray2.m4251d(2);
                    int d = parsableByteArray2.m4250d();
                    parsableByteArray2.m4251d(1);
                    int j2 = parsableByteArray2.m4259j();
                    spannableStringBuilder2 = spannableStringBuilder;
                    int i3 = e3;
                    int i4 = e4;
                    int i5 = i2;
                    m20111a(spannableStringBuilder2, d, r0.f19053g, i3, i4, 0);
                    m20113b(spannableStringBuilder2, j2, r0.f19054h, i3, i4, 0);
                    i2 = i5 + 1;
                }
            } else if (length == f19050d && r0.f19052f) {
                m20112a(r0.f19051e.m4246b() >= 2);
                f = Util.m4295a(((float) r0.f19051e.m4252e()) / ((float) r0.f19057k), 0.0f, 0.95f);
            }
            r0.f19051e.m4249c(e + j);
        }
        return new Tx3gSubtitle(new Cue(spannableStringBuilder, null, f, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    private static void m20111a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            i2 = 33 | i5;
            int i6 = 1;
            i5 = (i & 1) != 0 ? 1 : 0;
            int i7 = (i & 2) != 0 ? 1 : 0;
            if (i5 != 0) {
                if (i7 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i2);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i2);
                }
            } else if (i7 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i2);
            }
            if ((i & 4) == 0) {
                i6 = 0;
            }
            if (i6 != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i2);
            }
            if (i6 == 0 && i5 == 0 && i7 == 0) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i2);
            }
        }
    }

    private static void m20113b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, 33 | i5);
        }
    }

    private static void m20112a(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }
}
