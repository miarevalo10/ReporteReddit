package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public class OggExtractor implements Extractor {
    public static final ExtractorsFactory f13021a = new C11331();
    private ExtractorOutput f13022b;
    private StreamReader f13023c;
    private boolean f13024d;

    static class C11331 implements ExtractorsFactory {
        C11331() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new OggExtractor()};
        }
    }

    public final boolean mo1353a(com.google.android.exoplayer2.extractor.ExtractorInput r1) throws java.io.IOException, java.lang.InterruptedException {
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
        r0 = this;
        r1 = r0.m12133b(r1);	 Catch:{ ParserException -> 0x0005 }
        return r1;
    L_0x0005:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ogg.OggExtractor.a(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f13022b = extractorOutput;
    }

    public final void mo1351a(long j, long j2) {
        if (this.f13023c != null) {
            this.f13023c.m3834a(j, j2);
        }
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        if (this.f13023c == null) {
            if (m12133b(extractorInput)) {
                extractorInput.mo1332a();
            } else {
                throw new ParserException("Failed to determine bitstream type");
            }
        }
        if (!this.f13024d) {
            TrackOutput a = this.f13022b.mo1415a(0, 1);
            this.f13022b.mo1416a();
            this.f13023c.m3835a(this.f13022b, a);
            this.f13024d = true;
        }
        StreamReader streamReader = this.f13023c;
        switch (streamReader.f4514b) {
            case 0:
                return streamReader.m3831a(extractorInput);
            case 1:
                extractorInput.mo1335b((int) streamReader.f4513a);
                streamReader.f4514b = 2;
                return 0;
            case 2:
                return streamReader.m3832a(extractorInput, positionHolder);
            default:
                throw new IllegalStateException();
        }
    }

    private boolean m12133b(ExtractorInput extractorInput) throws IOException, InterruptedException {
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.m3827a(extractorInput, true)) {
            if ((oggPageHeader.f4501b & 2) == 2) {
                int min = Math.min(oggPageHeader.f4508i, 8);
                ParsableByteArray parsableByteArray = new ParsableByteArray(min);
                extractorInput.mo1340c(parsableByteArray.f5256a, 0, min);
                parsableByteArray.m4249c(0);
                if (FlacReader.m12127a(parsableByteArray) != null) {
                    this.f13023c = new FlacReader();
                } else {
                    parsableByteArray.m4249c(0);
                    if (VorbisReader.m12146a(parsableByteArray) != null) {
                        this.f13023c = new VorbisReader();
                    } else {
                        parsableByteArray.m4249c(0);
                        if (OpusReader.m12139a(parsableByteArray) == null) {
                            return false;
                        }
                        this.f13023c = new OpusReader();
                    }
                }
                return true;
            }
        }
        return false;
    }
}
