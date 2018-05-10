package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.containers.mps.MPSUtils;

public final class PsExtractor implements Extractor {
    public static final ExtractorsFactory f13175a = new C11361();
    private final TimestampAdjuster f13176b;
    private final SparseArray<PesReader> f13177c;
    private final ParsableByteArray f13178d;
    private boolean f13179e;
    private boolean f13180f;
    private boolean f13181g;
    private ExtractorOutput f13182h;

    private static final class PesReader {
        final ElementaryStreamReader f4614a;
        final TimestampAdjuster f4615b;
        final ParsableBitArray f4616c = new ParsableBitArray(new byte[64]);
        boolean f4617d;
        boolean f4618e;
        boolean f4619f;
        int f4620g;
        long f4621h;

        public PesReader(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.f4614a = elementaryStreamReader;
            this.f4615b = timestampAdjuster;
        }
    }

    static class C11361 implements ExtractorsFactory {
        C11361() {
        }

        public final Extractor[] mo1342a() {
            return new Extractor[]{new PsExtractor()};
        }
    }

    public PsExtractor() {
        this(new TimestampAdjuster(0));
    }

    private PsExtractor(TimestampAdjuster timestampAdjuster) {
        this.f13176b = timestampAdjuster;
        this.f13178d = new ParsableByteArray(4096);
        this.f13177c = new SparseArray();
    }

    public final boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        extractorInput.mo1340c(bArr, 0, 14);
        if (MPSUtils.PACK != (((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255)) || (bArr[4] & JpegConst.DHT) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.mo1339c(bArr[13] & 7);
        extractorInput.mo1340c(bArr, 0, 3);
        if (1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255))) {
            return true;
        }
        return false;
    }

    public final void mo1352a(ExtractorOutput extractorOutput) {
        this.f13182h = extractorOutput;
        extractorOutput.mo1417a(new Unseekable(-9223372036854775807L));
    }

    public final void mo1351a(long j, long j2) {
        this.f13176b.f5280b = -9223372036854775807L;
        for (int i = 0; i < this.f13177c.size(); i++) {
            PesReader pesReader = (PesReader) this.f13177c.valueAt(i);
            pesReader.f4619f = false;
            pesReader.f4614a.mo1376a();
        }
    }

    public final int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        if (extractorInput.mo1337b(this.f13178d.f5256a, 0, 4, true) == null) {
            return -1;
        }
        this.f13178d.m4249c(0);
        positionHolder = this.f13178d.m4259j();
        if (positionHolder == 441) {
            return -1;
        }
        if (positionHolder == 442) {
            extractorInput.mo1340c(this.f13178d.f5256a, 0, 10);
            this.f13178d.m4249c(9);
            extractorInput.mo1335b((this.f13178d.m4250d() & 7) + 14);
            return 0;
        } else if (positionHolder == 443) {
            extractorInput.mo1340c(this.f13178d.f5256a, 0, 2);
            this.f13178d.m4249c(0);
            extractorInput.mo1335b(this.f13178d.m4252e() + 6);
            return 0;
        } else if (((positionHolder & -256) >> 8) != 1) {
            extractorInput.mo1335b(1);
            return 0;
        } else {
            positionHolder &= 255;
            PesReader pesReader = (PesReader) this.f13177c.get(positionHolder);
            if (!this.f13179e) {
                if (pesReader == null) {
                    ElementaryStreamReader elementaryStreamReader = null;
                    if (!this.f13180f && positionHolder == 189) {
                        elementaryStreamReader = new Ac3Reader();
                        this.f13180f = true;
                    } else if (!this.f13180f && (positionHolder & JpegConst.APP0) == JpegConst.SOF0) {
                        elementaryStreamReader = new MpegAudioReader();
                        this.f13180f = true;
                    } else if (!this.f13181g && (positionHolder & 240) == JpegConst.APP0) {
                        elementaryStreamReader = new H262Reader();
                        this.f13181g = true;
                    }
                    if (elementaryStreamReader != null) {
                        elementaryStreamReader.mo1378a(this.f13182h, new TrackIdGenerator(positionHolder, 256));
                        pesReader = new PesReader(elementaryStreamReader, this.f13176b);
                        this.f13177c.put(positionHolder, pesReader);
                    }
                }
                if (!(this.f13180f == null || this.f13181g == null) || extractorInput.mo1338c() > 1048576) {
                    this.f13179e = true;
                    this.f13182h.mo1416a();
                }
            }
            extractorInput.mo1340c(this.f13178d.f5256a, 0, 2);
            this.f13178d.m4249c(0);
            positionHolder = this.f13178d.m4252e() + 6;
            if (pesReader == null) {
                extractorInput.mo1335b(positionHolder);
            } else {
                this.f13178d.m4242a(positionHolder);
                extractorInput.mo1336b(this.f13178d.f5256a, 0, positionHolder);
                this.f13178d.m4249c(6);
                extractorInput = this.f13178d;
                extractorInput.m4245a(pesReader.f4616c.f5252a, 0, 3);
                pesReader.f4616c.m4231a(0);
                pesReader.f4616c.m4234b(8);
                pesReader.f4617d = pesReader.f4616c.m4237c();
                pesReader.f4618e = pesReader.f4616c.m4237c();
                pesReader.f4616c.m4234b(6);
                pesReader.f4620g = pesReader.f4616c.m4236c(8);
                extractorInput.m4245a(pesReader.f4616c.f5252a, 0, pesReader.f4620g);
                pesReader.f4616c.m4231a(0);
                pesReader.f4621h = 0;
                if (pesReader.f4617d != null) {
                    pesReader.f4616c.m4234b(4);
                    long c = ((long) pesReader.f4616c.m4236c(3)) << 30;
                    pesReader.f4616c.m4234b(1);
                    c |= (long) (pesReader.f4616c.m4236c(15) << 15);
                    pesReader.f4616c.m4234b(1);
                    c |= (long) pesReader.f4616c.m4236c(15);
                    pesReader.f4616c.m4234b(1);
                    if (!pesReader.f4619f && pesReader.f4618e) {
                        pesReader.f4616c.m4234b(4);
                        long c2 = ((long) pesReader.f4616c.m4236c(3)) << 30;
                        pesReader.f4616c.m4234b(1);
                        c2 |= (long) (pesReader.f4616c.m4236c(15) << 15);
                        pesReader.f4616c.m4234b(1);
                        long c3 = ((long) pesReader.f4616c.m4236c(15)) | c2;
                        pesReader.f4616c.m4234b(1);
                        pesReader.f4615b.m4286b(c3);
                        pesReader.f4619f = true;
                    }
                    pesReader.f4621h = pesReader.f4615b.m4286b(c);
                }
                pesReader.f4614a.mo1377a(pesReader.f4621h, true);
                pesReader.f4614a.mo1379a(extractorInput);
                pesReader.f4614a.mo1380b();
                this.f13178d.m4247b(this.f13178d.m4248c());
            }
            return 0;
        }
    }
}
