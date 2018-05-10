package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate;
import java.util.regex.Pattern;

public final class GaplessInfoHolder {
    public static final FramePredicate f4250a = new C11271();
    private static final Pattern f4251d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int f4252b = -1;
    public int f4253c = -1;

    static class C11271 implements FramePredicate {
        public final boolean mo1347a(int i, int i2, int i3, int i4, int i5) {
            return i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2);
        }

        C11271() {
        }
    }

    private boolean m3751a(java.lang.String r5, java.lang.String r6) {
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
        r4 = this;
        r0 = "iTunSMPB";
        r5 = r0.equals(r5);
        r0 = 0;
        if (r5 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r5 = f4251d;
        r5 = r5.matcher(r6);
        r6 = r5.find();
        if (r6 == 0) goto L_0x0033;
    L_0x0016:
        r6 = 1;
        r1 = r5.group(r6);	 Catch:{ NumberFormatException -> 0x0033 }
        r2 = 16;	 Catch:{ NumberFormatException -> 0x0033 }
        r1 = java.lang.Integer.parseInt(r1, r2);	 Catch:{ NumberFormatException -> 0x0033 }
        r3 = 2;	 Catch:{ NumberFormatException -> 0x0033 }
        r5 = r5.group(r3);	 Catch:{ NumberFormatException -> 0x0033 }
        r5 = java.lang.Integer.parseInt(r5, r2);	 Catch:{ NumberFormatException -> 0x0033 }
        if (r1 > 0) goto L_0x002e;	 Catch:{ NumberFormatException -> 0x0033 }
    L_0x002c:
        if (r5 <= 0) goto L_0x0033;	 Catch:{ NumberFormatException -> 0x0033 }
    L_0x002e:
        r4.f4252b = r1;	 Catch:{ NumberFormatException -> 0x0033 }
        r4.f4253c = r5;	 Catch:{ NumberFormatException -> 0x0033 }
        return r6;
    L_0x0033:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.GaplessInfoHolder.a(java.lang.String, java.lang.String):boolean");
    }

    public final boolean m3752a() {
        return (this.f4252b == -1 || this.f4253c == -1) ? false : true;
    }

    public final boolean m3753a(Metadata metadata) {
        for (Entry entry : metadata.f4666a) {
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if (m3751a(commentFrame.f16880b, commentFrame.f16881c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
