package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.UUID;

public class SsManifest {
    public final int f4916a;
    public final int f4917b;
    public final int f4918c;
    public final boolean f4919d;
    public final ProtectionElement f4920e;
    public final StreamElement[] f4921f;
    public final long f4922g;
    public final long f4923h;

    public static class ProtectionElement {
        public final UUID f4898a;
        public final byte[] f4899b;

        public ProtectionElement(UUID uuid, byte[] bArr) {
            this.f4898a = uuid;
            this.f4899b = bArr;
        }
    }

    public static class StreamElement {
        public final int f4900a;
        public final String f4901b;
        public final long f4902c;
        public final String f4903d;
        public final int f4904e;
        public final int f4905f;
        public final int f4906g;
        public final int f4907h;
        public final String f4908i;
        public final Format[] f4909j;
        public final int f4910k;
        public final String f4911l;
        public final String f4912m;
        public final List<Long> f4913n;
        public final long[] f4914o;
        private final long f4915p;

        public StreamElement(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, Format[] formatArr, List<Long> list, long j2) {
            long j3 = j;
            List list2 = list;
            this.f4911l = str;
            this.f4912m = str2;
            this.f4900a = i;
            this.f4901b = str3;
            this.f4902c = j3;
            this.f4903d = str4;
            this.f4904e = i2;
            this.f4905f = i3;
            this.f4906g = i4;
            this.f4907h = i5;
            this.f4908i = str5;
            this.f4909j = formatArr;
            this.f4910k = list.size();
            this.f4913n = list2;
            this.f4915p = Util.m4303a(j2, 1000000, j3);
            this.f4914o = Util.m4315a(list2, j3);
        }

        public final int m4021a(long j) {
            return Util.m4300a(this.f4914o, j, true);
        }

        public final long m4022a(int i) {
            return i == this.f4910k + -1 ? this.f4915p : this.f4914o[i + 1] - this.f4914o[i];
        }
    }

    public SsManifest(int i, int i2, long j, long j2, long j3, int i3, boolean z, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        long j4;
        this.f4916a = i;
        this.f4917b = i2;
        this.f4918c = i3;
        this.f4919d = z;
        this.f4920e = protectionElement;
        this.f4921f = streamElementArr;
        long j5 = -9223372036854775807L;
        if (j3 == 0) {
            j4 = -9223372036854775807L;
        } else {
            j4 = Util.m4303a(j3, 1000000, j);
        }
        r0.f4923h = j4;
        if (j2 != 0) {
            j5 = Util.m4303a(j2, 1000000, j);
        }
        r0.f4922g = j5;
    }
}
