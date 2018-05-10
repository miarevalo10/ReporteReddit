package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.C0377C;
import java.util.List;

public class DashManifest {
    public final long f4812a;
    public final long f4813b;
    public final long f4814c;
    public final boolean f4815d;
    public final long f4816e;
    public final long f4817f;
    public final long f4818g;
    public final UtcTimingElement f4819h;
    public final Uri f4820i;
    private final List<Period> f4821j;

    public DashManifest(long j, long j2, long j3, boolean z, long j4, long j5, long j6, UtcTimingElement utcTimingElement, Uri uri, List<Period> list) {
        this.f4812a = j;
        this.f4813b = j2;
        this.f4814c = j3;
        this.f4815d = z;
        this.f4816e = j4;
        this.f4817f = j5;
        this.f4818g = j6;
        this.f4819h = utcTimingElement;
        this.f4820i = uri;
        this.f4821j = list;
    }

    public final int m3998a() {
        return this.f4821j.size();
    }

    public final Period m3999a(int i) {
        return (Period) this.f4821j.get(i);
    }

    public final long m4000b(int i) {
        long j = -9223372036854775807L;
        if (i != this.f4821j.size() - 1) {
            j = ((Period) this.f4821j.get(i + 1)).f4831b - ((Period) this.f4821j.get(i)).f4831b;
        } else if (this.f4813b != -9223372036854775807L) {
            j = this.f4813b - ((Period) this.f4821j.get(i)).f4831b;
        }
        return C0377C.m3540b(j);
    }
}
