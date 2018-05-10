package com.google.android.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

final class TtmlSubtitle implements Subtitle {
    private final TtmlNode f13564a;
    private final long[] f13565b;
    private final Map<String, TtmlStyle> f13566c;
    private final Map<String, TtmlRegion> f13567d;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2) {
        this.f13564a = ttmlNode;
        this.f13567d = map2;
        this.f13566c = Collections.unmodifiableMap(map);
        this.f13565b = ttmlNode.m4086a();
    }

    public final int mo1450a(long j) {
        j = Util.m4301a(this.f13565b, j, false, false);
        return j < this.f13565b.length ? j : -1;
    }

    public final int mo1452b() {
        return this.f13565b.length;
    }

    public final long a_(int i) {
        return this.f13565b[i];
    }

    public final List<Cue> mo1453b(long j) {
        TtmlNode ttmlNode = this.f13564a;
        Map map = this.f13566c;
        Map map2 = this.f13567d;
        Map treeMap = new TreeMap();
        ttmlNode.m4083a(j, false, ttmlNode.f5056g, treeMap);
        ttmlNode.m4085a(map, treeMap);
        List<Cue> arrayList = new ArrayList();
        for (Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion = (TtmlRegion) map2.get(entry.getKey());
            arrayList.add(new Cue(TtmlNode.m4076a((SpannableStringBuilder) entry.getValue()), null, ttmlRegion.f5063c, ttmlRegion.f5064d, ttmlRegion.f5065e, ttmlRegion.f5062b, Integer.MIN_VALUE, ttmlRegion.f5066f));
        }
        return arrayList;
    }
}
