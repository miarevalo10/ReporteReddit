package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.EsInfo;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DefaultTsPayloadReaderFactory implements Factory {
    private final int f13084a;
    private final List<Format> f13085b;

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    public DefaultTsPayloadReaderFactory(int i) {
        this(i, Collections.emptyList());
    }

    public DefaultTsPayloadReaderFactory(int i, List<Format> list) {
        this.f13084a = i;
        if (m12180a(32) == 0 && list.isEmpty() != 0) {
            list = Collections.singletonList(Format.m3555a((String) 0, "application/cea-608"));
        }
        this.f13085b = list;
    }

    public final SparseArray<TsPayloadReader> mo1381a() {
        return new SparseArray();
    }

    public final TsPayloadReader mo1382a(int i, EsInfo esInfo) {
        switch (i) {
            case 2:
                return new PesReader(new H262Reader());
            case 3:
            case 4:
                return new PesReader(new MpegAudioReader(esInfo.f4628b));
            case 15:
                if (m12180a(2) != 0) {
                    return null;
                }
                return new PesReader(new AdtsReader(false, esInfo.f4628b));
            case 21:
                return new PesReader(new Id3Reader());
            case 27:
                if (m12180a(4) != 0) {
                    return null;
                }
                return new PesReader(new H264Reader(m12179a(esInfo), m12180a(1), m12180a(8)));
            case 36:
                return new PesReader(new H265Reader(m12179a(esInfo)));
            case 89:
                return new PesReader(new DvbSubtitleReader(esInfo.f4629c));
            case 129:
            case 135:
                return new PesReader(new Ac3Reader(esInfo.f4628b));
            case 130:
            case 138:
                return new PesReader(new DtsReader(esInfo.f4628b));
            case 134:
                if (m12180a(16) != 0) {
                    return null;
                }
                return new SectionReader(new SpliceInfoSectionReader());
            default:
                return null;
        }
    }

    private SeiReader m12179a(EsInfo esInfo) {
        if (m12180a(32)) {
            return new SeiReader(this.f13085b);
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.f4630d);
        esInfo = this.f13085b;
        while (parsableByteArray.m4246b() > 0) {
            int d = parsableByteArray.f5257b + parsableByteArray.m4250d();
            if (parsableByteArray.m4250d() == 134) {
                esInfo = new ArrayList();
                int d2 = parsableByteArray.m4250d() & 31;
                for (int i = 0; i < d2; i++) {
                    String str;
                    String e = parsableByteArray.m4253e(3);
                    int d3 = parsableByteArray.m4250d();
                    int i2 = 1;
                    if (((d3 & 128) != 0 ? 1 : 0) != 0) {
                        str = "application/cea-708";
                        i2 = d3 & 63;
                    } else {
                        str = "application/cea-608";
                    }
                    esInfo.add(Format.m3561a(null, str, 0, e, i2));
                    parsableByteArray.m4251d(2);
                }
            }
            parsableByteArray.m4249c(d);
        }
        return new SeiReader(esInfo);
    }

    private boolean m12180a(int i) {
        return (i & this.f13084a) != 0;
    }
}
