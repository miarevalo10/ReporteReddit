package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;

final class WebvttCue extends Cue {
    public final long f13571m;
    public final long f13572n;

    static /* synthetic */ class C04201 {
        static final /* synthetic */ int[] f5100a = new int[Alignment.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = android.text.Layout.Alignment.values();
            r0 = r0.length;
            r0 = new int[r0];
            f5100a = r0;
            r0 = f5100a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.text.Layout.Alignment.ALIGN_NORMAL;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f5100a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.text.Layout.Alignment.ALIGN_CENTER;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f5100a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCue.1.<clinit>():void");
        }
    }

    public static final class Builder {
        long f5101a;
        long f5102b;
        SpannableStringBuilder f5103c;
        Alignment f5104d;
        float f5105e;
        int f5106f;
        int f5107g;
        float f5108h;
        int f5109i;
        float f5110j;

        public Builder() {
            m4103a();
        }

        public final void m4103a() {
            this.f5101a = 0;
            this.f5102b = 0;
            this.f5103c = null;
            this.f5104d = null;
            this.f5105e = Float.MIN_VALUE;
            this.f5106f = Integer.MIN_VALUE;
            this.f5107g = Integer.MIN_VALUE;
            this.f5108h = Float.MIN_VALUE;
            this.f5109i = Integer.MIN_VALUE;
            this.f5110j = Float.MIN_VALUE;
        }

        public final WebvttCue m4104b() {
            if (this.f5108h != Float.MIN_VALUE && r0.f5109i == Integer.MIN_VALUE) {
                if (r0.f5104d != null) {
                    switch (C04201.f5100a[r0.f5104d.ordinal()]) {
                        case 1:
                            r0.f5109i = 0;
                            break;
                        case 2:
                            r0.f5109i = 1;
                            break;
                        case 3:
                            r0.f5109i = 2;
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder("Unrecognized alignment: ");
                            stringBuilder.append(r0.f5104d);
                            Log.w("WebvttCueBuilder", stringBuilder.toString());
                            r0.f5109i = 0;
                            break;
                    }
                }
                r0.f5109i = Integer.MIN_VALUE;
            }
            return new WebvttCue(r0.f5101a, r0.f5102b, r0.f5103c, r0.f5104d, r0.f5105e, r0.f5106f, r0.f5107g, r0.f5108h, r0.f5109i, r0.f5110j);
        }
    }

    public WebvttCue(CharSequence charSequence) {
        this(charSequence, (byte) 0);
    }

    private WebvttCue(CharSequence charSequence, byte b) {
        this(0, 0, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public WebvttCue(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.f13571m = j;
        this.f13572n = j2;
    }
}
