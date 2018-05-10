package com.google.android.exoplayer2.source.hls.playlist;

import java.util.Collections;
import java.util.List;

public final class HlsMediaPlaylist extends HlsPlaylist {
    public final int f13452a;
    public final long f13453b;
    public final long f13454c;
    public final boolean f13455d;
    public final int f13456e;
    public final int f13457f;
    public final int f13458g;
    public final long f13459h;
    public final boolean f13460i;
    public final boolean f13461j;
    public final boolean f13462k;
    public final Segment f13463l;
    public final List<Segment> f13464m;
    public final long f13465n;

    public static final class Segment implements Comparable<Long> {
        public final String f4881a;
        public final long f4882b;
        public final int f4883c;
        public final long f4884d;
        public final boolean f4885e;
        public final String f4886f;
        public final String f4887g;
        public final long f4888h;
        public final long f4889i;

        public final /* synthetic */ int compareTo(Object obj) {
            Long l = (Long) obj;
            if (this.f4884d > l.longValue()) {
                return 1;
            }
            return this.f4884d < l.longValue() ? -1 : null;
        }

        public Segment(String str, long j, long j2) {
            this(str, 0, -1, -9223372036854775807L, false, null, null, j, j2);
        }

        public Segment(String str, long j, int i, long j2, boolean z, String str2, String str3, long j3, long j4) {
            this.f4881a = str;
            this.f4882b = j;
            this.f4883c = i;
            this.f4884d = j2;
            this.f4885e = z;
            this.f4886f = str2;
            this.f4887g = str3;
            this.f4888h = j3;
            this.f4889i = j4;
        }
    }

    public HlsMediaPlaylist(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, Segment segment, List<Segment> list2) {
        super(str, list);
        this.f13452a = i;
        this.f13454c = j2;
        this.f13455d = z;
        this.f13456e = i2;
        this.f13457f = i3;
        this.f13458g = i4;
        this.f13459h = j3;
        this.f13460i = z2;
        this.f13461j = z3;
        this.f13462k = z4;
        this.f13463l = segment;
        this.f13464m = Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            r0.f13465n = 0;
        } else {
            Segment segment2 = (Segment) list2.get(list2.size() - 1);
            r0.f13465n = segment2.f4884d + segment2.f4882b;
        }
        long j4 = j == -9223372036854775807L ? -9223372036854775807L : j >= 0 ? j : r0.f13465n + j;
        r0.f13453b = j4;
    }

    public final long m12535a() {
        return this.f13454c + this.f13465n;
    }
}
