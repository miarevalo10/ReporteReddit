package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Collections;
import java.util.List;

public class AdaptationSet {
    public final int f4807a;
    public final int f4808b;
    public final List<Representation> f4809c;
    public final List<Descriptor> f4810d;
    public final List<Descriptor> f4811e;

    public AdaptationSet(int i, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3) {
        this.f4807a = i;
        this.f4808b = i2;
        this.f4809c = Collections.unmodifiableList(list);
        this.f4810d = Collections.unmodifiableList(list2);
        this.f4811e = Collections.unmodifiableList(list3);
    }
}
