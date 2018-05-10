package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import java.lang.reflect.Constructor;

public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static final Constructor<? extends Extractor> f12833a;
    private int f12834b;
    private int f12835c;
    private int f12836d;
    private int f12837e = 1;
    private int f12838f;

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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = "com.google.android.exoplayer2.ext.flac.FlacExtractor";	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r1 = com.google.android.exoplayer2.extractor.Extractor.class;	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r0 = r0.asSubclass(r1);	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r1 = 0;	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r1 = new java.lang.Class[r1];	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        r0 = r0.getConstructor(r1);	 Catch:{ ClassNotFoundException -> 0x0014, ClassNotFoundException -> 0x0014 }
        goto L_0x0015;
    L_0x0014:
        r0 = 0;
    L_0x0015:
        f12833a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.DefaultExtractorsFactory.<clinit>():void");
    }

    public final synchronized Extractor[] mo1342a() {
        Extractor[] extractorArr;
        extractorArr = new Extractor[(f12833a == null ? 11 : 12)];
        extractorArr[0] = new MatroskaExtractor(this.f12834b);
        extractorArr[1] = new FragmentedMp4Extractor(this.f12835c);
        extractorArr[2] = new Mp4Extractor();
        extractorArr[3] = new Mp3Extractor(this.f12836d);
        extractorArr[4] = new AdtsExtractor();
        extractorArr[5] = new Ac3Extractor();
        extractorArr[6] = new TsExtractor(this.f12837e, this.f12838f);
        extractorArr[7] = new FlvExtractor();
        extractorArr[8] = new OggExtractor();
        extractorArr[9] = new PsExtractor();
        extractorArr[10] = new WavExtractor();
        if (f12833a != null) {
            try {
                extractorArr[11] = (Extractor) f12833a.newInstance(new Object[0]);
            } catch (Throwable e) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
            }
        }
        return extractorArr;
    }
}
