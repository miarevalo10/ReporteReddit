package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class Period {
    public final String f4830a;
    public final long f4831b;
    public final List<AdaptationSet> f4832c;

    public Period(String str, long j, List<AdaptationSet> list) {
        this.f4830a = str;
        this.f4831b = j;
        this.f4832c = Collections.unmodifiableList(list);
    }
}
