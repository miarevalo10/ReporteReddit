package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.source.SampleMetadataQueue.SampleExtrasHolder;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;

public final class SampleQueue implements TrackOutput {
    public final SampleMetadataQueue f13275a = new SampleMetadataQueue();
    public boolean f13276b;
    public long f13277c;
    public boolean f13278d;
    public UpstreamFormatChangedListener f13279e;
    private final Allocator f13280f;
    private final int f13281g;
    private final SampleExtrasHolder f13282h = new SampleExtrasHolder();
    private final ParsableByteArray f13283i = new ParsableByteArray(32);
    private AllocationNode f13284j = new AllocationNode(0, this.f13281g);
    private AllocationNode f13285k = this.f13284j;
    private AllocationNode f13286l = this.f13284j;
    private Format f13287m;
    private Format f13288n;
    private long f13289o;

    private static final class AllocationNode {
        public final long f4777a;
        public final long f4778b;
        public boolean f4779c;
        public Allocation f4780d;
        public AllocationNode f4781e;

        public AllocationNode(long j, int i) {
            this.f4777a = j;
            this.f4778b = j + ((long) i);
        }

        public final int m3963a(long j) {
            return ((int) (j - this.f4777a)) + this.f4780d.f5159b;
        }

        public final AllocationNode m3964a() {
            this.f4780d = null;
            AllocationNode allocationNode = this.f4781e;
            this.f4781e = null;
            return allocationNode;
        }
    }

    public interface UpstreamFormatChangedListener {
        void mo1440g();
    }

    public SampleQueue(Allocator allocator) {
        this.f13280f = allocator;
        this.f13281g = allocator.mo1470c();
    }

    public final void m12357a(boolean z) {
        SampleMetadataQueue sampleMetadataQueue = this.f13275a;
        sampleMetadataQueue.f4760b = 0;
        sampleMetadataQueue.f4761c = 0;
        sampleMetadataQueue.f4762d = 0;
        sampleMetadataQueue.f4763e = 0;
        sampleMetadataQueue.f4766h = true;
        sampleMetadataQueue.f4764f = Long.MIN_VALUE;
        sampleMetadataQueue.f4765g = Long.MIN_VALUE;
        if (z) {
            sampleMetadataQueue.f4768j = false;
            sampleMetadataQueue.f4767i = true;
        }
        m12345a(this.f13284j);
        this.f13284j = new AllocationNode(0, this.f13281g);
        this.f13285k = this.f13284j;
        this.f13286l = this.f13284j;
        this.f13289o = 0;
        this.f13280f.mo1469b();
    }

    public final void m12352a(int i) {
        this.f13289o = this.f13275a.m3949a(i);
        if (this.f13289o != 0) {
            if (this.f13289o != this.f13284j.f4777a) {
                i = this.f13284j;
                while (this.f13289o > i.f4778b) {
                    i = i.f4781e;
                }
                AllocationNode allocationNode = i.f4781e;
                m12345a(allocationNode);
                i.f4781e = new AllocationNode(i.f4778b, this.f13281g);
                this.f13286l = this.f13289o == i.f4778b ? i.f4781e : i;
                if (this.f13285k == allocationNode) {
                    this.f13285k = i.f4781e;
                }
                return;
            }
        }
        m12345a(this.f13284j);
        this.f13284j = new AllocationNode(this.f13289o, this.f13281g);
        this.f13285k = this.f13284j;
        this.f13286l = this.f13284j;
    }

    public final int m12349a() {
        SampleMetadataQueue sampleMetadataQueue = this.f13275a;
        return sampleMetadataQueue.f4761c + sampleMetadataQueue.f4763e;
    }

    public final void m12359b() {
        this.f13275a.m3959e();
        this.f13285k = this.f13284j;
    }

    public final void m12354a(long j, boolean z, boolean z2) {
        m12347b(this.f13275a.m3950a(j, z, z2));
    }

    public final void m12360c() {
        m12347b(this.f13275a.m3961g());
    }

    public final void m12361d() {
        m12347b(this.f13275a.m3962h());
    }

    public final boolean m12358a(long j, boolean z) {
        return this.f13275a.m3953a(j, z);
    }

    public final int m12350a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, long j) {
        switch (this.f13275a.m3948a(formatHolder, decoderInputBuffer, z, z2, this.f13287m, this.f13282h)) {
            case true:
                this.f13287m = formatHolder.f4039a;
                return -5;
            case true:
                if (decoderInputBuffer.m3715c() == null) {
                    if (decoderInputBuffer.f12801d < j) {
                        decoderInputBuffer.m3713a(Integer.MIN_VALUE);
                    }
                    if (decoderInputBuffer.m11974f() != null) {
                        formatHolder = this.f13282h;
                        long j2 = formatHolder.f4757b;
                        int i = 1;
                        this.f13283i.m4242a(1);
                        m12344a(j2, this.f13283i.f5256a, 1);
                        j2++;
                        int i2 = 0;
                        j = this.f13283i.f5256a[0];
                        int i3 = (j & 128) != 0 ? 1 : 0;
                        int i4 = j & 127;
                        if (decoderInputBuffer.f12799b.f4223a == null) {
                            decoderInputBuffer.f12799b.f4223a = new byte[16];
                        }
                        m12344a(j2, decoderInputBuffer.f12799b.f4223a, i4);
                        z = j2 + ((long) i4);
                        if (i3 != 0) {
                            this.f13283i.m4242a(2);
                            m12344a((long) z, this.f13283i.f5256a, 2);
                            z += 2;
                            i = this.f13283i.m4252e();
                        }
                        j = decoderInputBuffer.f12799b.f4226d;
                        if (j == null || j.length < i) {
                            j = new int[i];
                        }
                        int[] iArr = decoderInputBuffer.f12799b.f4227e;
                        if (iArr == null || iArr.length < i) {
                            iArr = new int[i];
                        }
                        if (i3 != 0) {
                            i3 = 6 * i;
                            this.f13283i.m4242a(i3);
                            m12344a((long) z, this.f13283i.f5256a, i3);
                            z += (long) i3;
                            this.f13283i.m4249c(0);
                            while (i2 < i) {
                                j[i2] = this.f13283i.m4252e();
                                iArr[i2] = this.f13283i.m4263n();
                                i2++;
                            }
                        } else {
                            j[0] = null;
                            iArr[0] = formatHolder.f4756a - ((int) (z - formatHolder.f4757b));
                        }
                        CryptoData cryptoData = formatHolder.f4758c;
                        CryptoInfo cryptoInfo = decoderInputBuffer.f12799b;
                        byte[] bArr = cryptoData.f4270b;
                        byte[] bArr2 = decoderInputBuffer.f12799b.f4223a;
                        int i5 = cryptoData.f4269a;
                        int i6 = cryptoData.f4271c;
                        i2 = cryptoData.f4272d;
                        cryptoInfo.f4228f = i;
                        cryptoInfo.f4226d = j;
                        cryptoInfo.f4227e = iArr;
                        cryptoInfo.f4224b = bArr;
                        cryptoInfo.f4223a = bArr2;
                        cryptoInfo.f4225c = i5;
                        cryptoInfo.f4229g = i6;
                        cryptoInfo.f4230h = i2;
                        if (Util.f5283a >= 16) {
                            cryptoInfo.f4231i.numSubSamples = cryptoInfo.f4228f;
                            cryptoInfo.f4231i.numBytesOfClearData = cryptoInfo.f4226d;
                            cryptoInfo.f4231i.numBytesOfEncryptedData = cryptoInfo.f4227e;
                            cryptoInfo.f4231i.key = cryptoInfo.f4224b;
                            cryptoInfo.f4231i.iv = cryptoInfo.f4223a;
                            cryptoInfo.f4231i.mode = cryptoInfo.f4225c;
                            if (Util.f5283a >= 24) {
                                PatternHolderV24.m3717a(cryptoInfo.f4232j, cryptoInfo.f4229g, cryptoInfo.f4230h);
                            }
                        }
                        z = (int) (z - formatHolder.f4757b);
                        formatHolder.f4757b += (long) z;
                        formatHolder.f4756a -= z;
                    }
                    decoderInputBuffer.m11973c(this.f13282h.f4756a);
                    z = this.f13282h.f4757b;
                    formatHolder = decoderInputBuffer.f12800c;
                    decoderInputBuffer = this.f13282h.f4756a;
                    m12343a((long) z);
                    while (decoderInputBuffer > null) {
                        j = Math.min(decoderInputBuffer, (int) (this.f13285k.f4778b - z));
                        formatHolder.put(this.f13285k.f4780d.f5158a, this.f13285k.m3963a(z), j);
                        decoderInputBuffer -= j;
                        z += (long) j;
                        if (z == this.f13285k.f4778b) {
                            this.f13285k = this.f13285k.f4781e;
                        }
                    }
                }
                return -4;
            case true:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    private void m12344a(long j, byte[] bArr, int i) {
        m12343a(j);
        long j2 = j;
        j = i;
        while (j > null) {
            int min = Math.min(j, (int) (this.f13285k.f4778b - j2));
            System.arraycopy(this.f13285k.f4780d.f5158a, this.f13285k.m3963a(j2), bArr, i - j, min);
            j -= min;
            j2 += (long) min;
            if (j2 == this.f13285k.f4778b) {
                this.f13285k = this.f13285k.f4781e;
            }
        }
    }

    private void m12343a(long j) {
        while (j >= this.f13285k.f4778b) {
            this.f13285k = this.f13285k.f4781e;
        }
    }

    private void m12347b(long j) {
        if (j != -1) {
            while (j >= this.f13284j.f4778b) {
                this.f13280f.mo1467a(this.f13284j.f4780d);
                this.f13284j = this.f13284j.m3964a();
            }
            if (this.f13285k.f4777a < this.f13284j.f4777a) {
                this.f13285k = this.f13284j;
            }
        }
    }

    public final void mo1345a(Format format) {
        long j = this.f13277c;
        Format a = format == null ? null : (j == 0 || format.f4035w == Long.MAX_VALUE) ? format : format.m3575a(format.f4035w + j);
        boolean a2 = this.f13275a.m3954a(a);
        this.f13288n = format;
        this.f13276b = null;
        if (this.f13279e != null && a2) {
            this.f13279e.mo1440g();
        }
    }

    public final int mo1343a(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
        extractorInput = extractorInput.mo1331a(this.f13286l.f4780d.f5158a, this.f13286l.m3963a(this.f13289o), m12346b(i));
        if (extractorInput != -1) {
            m12348c(extractorInput);
            return extractorInput;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void mo1346a(ParsableByteArray parsableByteArray, int i) {
        while (i > 0) {
            int b = m12346b(i);
            parsableByteArray.m4245a(this.f13286l.f4780d.f5158a, this.f13286l.m3963a(this.f13289o), b);
            i -= b;
            m12348c(b);
        }
    }

    public final void mo1344a(long j, int i, int i2, int i3, CryptoData cryptoData) {
        long j2 = j;
        if (this.f13276b) {
            mo1345a(r0.f13288n);
        }
        if (r0.f13278d) {
            if ((i & 1) != 0) {
                if (r0.f13275a.m3952a(j2)) {
                    r0.f13278d = false;
                }
            }
            return;
        }
        int i4 = i2;
        r0.f13275a.m3951a(j2 + r0.f13277c, i, (r0.f13289o - ((long) i4)) - ((long) i3), i4, cryptoData);
    }

    private void m12345a(AllocationNode allocationNode) {
        if (allocationNode.f4779c) {
            Allocation[] allocationArr = new Allocation[(this.f13286l.f4779c + (((int) (this.f13286l.f4777a - allocationNode.f4777a)) / this.f13281g))];
            for (int i = 0; i < allocationArr.length; i++) {
                allocationArr[i] = allocationNode.f4780d;
                allocationNode = allocationNode.m3964a();
            }
            this.f13280f.mo1468a(allocationArr);
        }
    }

    private int m12346b(int i) {
        if (!this.f13286l.f4779c) {
            AllocationNode allocationNode = this.f13286l;
            Allocation a = this.f13280f.mo1466a();
            AllocationNode allocationNode2 = new AllocationNode(this.f13286l.f4778b, this.f13281g);
            allocationNode.f4780d = a;
            allocationNode.f4781e = allocationNode2;
            allocationNode.f4779c = true;
        }
        return Math.min(i, (int) (this.f13286l.f4778b - this.f13289o));
    }

    private void m12348c(int i) {
        this.f13289o += (long) i;
        if (this.f13289o == this.f13286l.f4778b) {
            this.f13286l = this.f13286l.f4781e;
        }
    }
}
