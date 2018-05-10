package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

public final class ChunkExtractorWrapper implements ExtractorOutput {
    public final Extractor f13315a;
    public SeekMap f13316b;
    public Format[] f13317c;
    private final Format f13318d;
    private final SparseArray<BindingTrackOutput> f13319e = new SparseArray();
    private boolean f13320f;
    private TrackOutputProvider f13321g;

    public interface TrackOutputProvider {
        TrackOutput mo1414a(int i);
    }

    private static final class BindingTrackOutput implements TrackOutput {
        public Format f13310a;
        private final int f13311b;
        private final int f13312c;
        private final Format f13313d;
        private TrackOutput f13314e;

        public BindingTrackOutput(int i, int i2, Format format) {
            this.f13311b = i;
            this.f13312c = i2;
            this.f13313d = format;
        }

        public final void m12373a(TrackOutputProvider trackOutputProvider) {
            if (trackOutputProvider == null) {
                this.f13314e = new DummyTrackOutput();
                return;
            }
            this.f13314e = trackOutputProvider.mo1414a(this.f13312c);
            if (this.f13314e != null) {
                this.f13314e.mo1345a(this.f13310a);
            }
        }

        public final void mo1345a(Format format) {
            BindingTrackOutput bindingTrackOutput;
            Format format2 = format;
            Format format3 = this.f13313d;
            if (format2 != format3) {
                format2 = new Format(format3.f4013a, format2.f4017e, format2.f4018f, format2.f4015c == null ? format3.f4015c : format2.f4015c, format2.f4014b == -1 ? format3.f4014b : format2.f4014b, format2.f4019g, format2.f4022j, format2.f4023k, format2.f4024l == -1.0f ? format3.f4024l : format2.f4024l, format2.f4025m, format2.f4026n, format2.f4028p, format2.f4027o, format2.f4029q, format2.f4030r, format2.f4031s, format2.f4032t, format2.f4033u, format2.f4034v, format2.f4036x | format3.f4036x, format2.f4037y == null ? format3.f4037y : format2.f4037y, format2.f4038z, format2.f4035w, format2.f4020h, format3.f4021i != null ? format3.f4021i : format2.f4021i, format2.f4016d);
                bindingTrackOutput = this;
            }
            bindingTrackOutput.f13310a = format2;
            bindingTrackOutput.f13314e.mo1345a(bindingTrackOutput.f13310a);
        }

        public final int mo1343a(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
            return this.f13314e.mo1343a(extractorInput, i, z);
        }

        public final void mo1346a(ParsableByteArray parsableByteArray, int i) {
            this.f13314e.mo1346a(parsableByteArray, i);
        }

        public final void mo1344a(long j, int i, int i2, int i3, CryptoData cryptoData) {
            this.f13314e.mo1344a(j, i, i2, i3, cryptoData);
        }
    }

    public ChunkExtractorWrapper(Extractor extractor, Format format) {
        this.f13315a = extractor;
        this.f13318d = format;
    }

    public final void m12378a(TrackOutputProvider trackOutputProvider) {
        this.f13321g = trackOutputProvider;
        if (this.f13320f) {
            this.f13315a.mo1351a(0, 0);
            for (int i = 0; i < this.f13319e.size(); i++) {
                ((BindingTrackOutput) this.f13319e.valueAt(i)).m12373a(trackOutputProvider);
            }
            return;
        }
        this.f13315a.mo1352a((ExtractorOutput) this);
        this.f13320f = true;
    }

    public final TrackOutput mo1415a(int i, int i2) {
        BindingTrackOutput bindingTrackOutput = (BindingTrackOutput) this.f13319e.get(i);
        if (bindingTrackOutput != null) {
            return bindingTrackOutput;
        }
        Assertions.m4186b(this.f13317c == null);
        TrackOutput bindingTrackOutput2 = new BindingTrackOutput(i, i2, this.f13318d);
        bindingTrackOutput2.m12373a(this.f13321g);
        this.f13319e.put(i, bindingTrackOutput2);
        return bindingTrackOutput2;
    }

    public final void mo1416a() {
        Format[] formatArr = new Format[this.f13319e.size()];
        for (int i = 0; i < this.f13319e.size(); i++) {
            formatArr[i] = ((BindingTrackOutput) this.f13319e.valueAt(i)).f13310a;
        }
        this.f13317c = formatArr;
    }

    public final void mo1417a(SeekMap seekMap) {
        this.f13316b = seekMap;
    }
}
