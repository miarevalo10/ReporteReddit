package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.boxes.CompositionTimeToSample.Entry;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractTrack implements Track {
    String f15122a;
    List<Edit> f15123b = new ArrayList();
    Map<GroupEntry, long[]> f15124c = new HashMap();

    public List<Entry> mo2512a() {
        return null;
    }

    public long[] mo2513b() {
        return null;
    }

    public List<SampleDependencyTypeBox.Entry> mo2514c() {
        return null;
    }

    public SubSampleInformationBox mo2515d() {
        return null;
    }

    public AbstractTrack(String str) {
        this.f15122a = str;
    }

    public final long mo2516e() {
        long j = 0;
        for (long j2 : mo3624k()) {
            j += j2;
        }
        return j;
    }

    public String mo2517f() {
        return this.f15122a;
    }

    public final List<Edit> mo2518g() {
        return this.f15123b;
    }

    public final Map<GroupEntry, long[]> mo2519h() {
        return this.f15124c;
    }
}
