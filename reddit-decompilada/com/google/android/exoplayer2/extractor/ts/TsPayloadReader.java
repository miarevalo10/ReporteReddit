package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Collections;
import java.util.List;

public interface TsPayloadReader {

    public static final class DvbSubtitleInfo {
        public final String f4624a;
        public final int f4625b;
        public final byte[] f4626c;

        public DvbSubtitleInfo(String str, int i, byte[] bArr) {
            this.f4624a = str;
            this.f4625b = i;
            this.f4626c = bArr;
        }
    }

    public static final class EsInfo {
        public final int f4627a;
        public final String f4628b;
        public final List<DvbSubtitleInfo> f4629c;
        public final byte[] f4630d;

        public EsInfo(int i, String str, List<DvbSubtitleInfo> list, byte[] bArr) {
            this.f4627a = i;
            this.f4628b = str;
            if (list == null) {
                i = Collections.emptyList();
            } else {
                i = Collections.unmodifiableList(list);
            }
            this.f4629c = i;
            this.f4630d = bArr;
        }
    }

    public interface Factory {
        SparseArray<TsPayloadReader> mo1381a();

        TsPayloadReader mo1382a(int i, EsInfo esInfo);
    }

    public static final class TrackIdGenerator {
        private final String f4631a;
        private final int f4632b;
        private final int f4633c;
        private int f4634d;
        private String f4635e;

        public TrackIdGenerator(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public TrackIdGenerator(int i, int i2, int i3) {
            if (i != Integer.MIN_VALUE) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append(Operation.DIVISION);
                i = stringBuilder.toString();
            } else {
                i = "";
            }
            this.f4631a = i;
            this.f4632b = i2;
            this.f4633c = i3;
            this.f4634d = Integer.MIN_VALUE;
        }

        public final void m3876a() {
            this.f4634d = this.f4634d == Integer.MIN_VALUE ? this.f4632b : this.f4634d + this.f4633c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f4631a);
            stringBuilder.append(this.f4634d);
            this.f4635e = stringBuilder.toString();
        }

        public final int m3877b() {
            m3875d();
            return this.f4634d;
        }

        public final String m3878c() {
            m3875d();
            return this.f4635e;
        }

        private void m3875d() {
            if (this.f4634d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }

    void mo1383a();

    void mo1384a(ParsableByteArray parsableByteArray, boolean z);

    void mo1385a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);
}
