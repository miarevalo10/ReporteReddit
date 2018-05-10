package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.CompositeSequenceableLoader;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader.Callback;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream.EmbeddedSampleStream;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.source.dash.DashChunkSource.Factory;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

final class DashMediaPeriod implements MediaPeriod, Callback<ChunkSampleStream<DashChunkSource>> {
    final int f16966a;
    MediaPeriod.Callback f16967b;
    ChunkSampleStream<DashChunkSource>[] f16968c = new ChunkSampleStream[0];
    DashManifest f16969d;
    int f16970e;
    List<AdaptationSet> f16971f;
    private final Factory f16972g;
    private final int f16973h;
    private final EventDispatcher f16974i;
    private final long f16975j;
    private final LoaderErrorThrower f16976k;
    private final Allocator f16977l;
    private final TrackGroupArray f16978m;
    private final TrackGroupInfo[] f16979n;
    private CompositeSequenceableLoader f16980o = new CompositeSequenceableLoader(this.f16968c);

    private static final class TrackGroupInfo {
        public final int[] f4791a;
        public final int f4792b;
        public final boolean f4793c;
        public final int f4794d;
        public final boolean f4795e;
        public final boolean f4796f;

        public TrackGroupInfo(int i, int[] iArr, int i2, boolean z, boolean z2, boolean z3) {
            this.f4792b = i;
            this.f4791a = iArr;
            this.f4794d = i2;
            this.f4793c = z;
            this.f4795e = z2;
            this.f4796f = z3;
        }
    }

    public final long mo3357c() {
        return -9223372036854775807L;
    }

    public DashMediaPeriod(int i, DashManifest dashManifest, int i2, Factory factory, int i3, EventDispatcher eventDispatcher, long j, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.f16966a = i;
        this.f16969d = dashManifest;
        this.f16970e = i2;
        this.f16972g = factory;
        this.f16973h = i3;
        this.f16974i = eventDispatcher;
        this.f16975j = j;
        this.f16976k = loaderErrorThrower;
        this.f16977l = allocator;
        this.f16971f = dashManifest.m3999a(i2).f4832c;
        i = m17257a(this.f16971f);
        this.f16978m = (TrackGroupArray) i.first;
        this.f16979n = (TrackGroupInfo[]) i.second;
    }

    public final void mo3353a(MediaPeriod.Callback callback, long j) {
        this.f16967b = callback;
        callback.mo3347a(this);
    }

    public final void b_() throws IOException {
        this.f16976k.mo1477c();
    }

    public final TrackGroupArray mo3355b() {
        return this.f16978m;
    }

    public final long mo3351a(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        int i;
        long j2;
        DashMediaPeriod dashMediaPeriod = this;
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        long j3 = j;
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < trackSelectionArr2.length) {
            int i3;
            if (sampleStreamArr[i2] instanceof ChunkSampleStream) {
                ChunkSampleStream chunkSampleStream = (ChunkSampleStream) sampleStreamArr[i2];
                if (trackSelectionArr2[i2] != null) {
                    if (zArr[i2]) {
                        hashMap.put(Integer.valueOf(dashMediaPeriod.f16978m.m3975a(trackSelectionArr2[i2].mo1459d())), chunkSampleStream);
                    }
                }
                chunkSampleStream.m12394c();
                sampleStreamArr[i2] = null;
            }
            if (sampleStreamArr[i2] == null && trackSelectionArr2[i2] != null) {
                int a = dashMediaPeriod.f16978m.m3975a(trackSelectionArr2[i2].mo1459d());
                TrackGroupInfo trackGroupInfo = dashMediaPeriod.f16979n[a];
                if (trackGroupInfo.f4793c) {
                    TrackSelection trackSelection = trackSelectionArr2[i2];
                    int[] iArr = new int[2];
                    boolean z = trackGroupInfo.f4795e;
                    if (z) {
                        iArr[0] = 4;
                        i = 1;
                    } else {
                        i = 0;
                    }
                    boolean z2 = trackGroupInfo.f4796f;
                    if (z2) {
                        int i4 = i + 1;
                        iArr[i] = 3;
                        i = i4;
                    }
                    if (i < 2) {
                        iArr = Arrays.copyOf(iArr, i);
                    }
                    int i5 = i2;
                    int i6 = a;
                    ChunkSource a2 = dashMediaPeriod.f16972g.mo1430a(dashMediaPeriod.f16976k, dashMediaPeriod.f16969d, dashMediaPeriod.f16970e, trackGroupInfo.f4791a, trackSelection, trackGroupInfo.f4792b, dashMediaPeriod.f16975j, z, z2);
                    int i7 = trackGroupInfo.f4792b;
                    Allocator allocator = dashMediaPeriod.f16977l;
                    int i8 = dashMediaPeriod.f16973h;
                    EventDispatcher eventDispatcher = dashMediaPeriod.f16974i;
                    DashMediaPeriod dashMediaPeriod2 = dashMediaPeriod;
                    i3 = i5;
                    int i9 = i6;
                    ChunkSampleStream chunkSampleStream2 = new ChunkSampleStream(i7, iArr, a2, dashMediaPeriod2, allocator, j3, i8, eventDispatcher);
                    hashMap.put(Integer.valueOf(i9), chunkSampleStream2);
                    sampleStreamArr[i3] = chunkSampleStream2;
                    zArr2[i3] = true;
                    i2 = i3 + 1;
                    j3 = j;
                    dashMediaPeriod = this;
                    trackSelectionArr2 = trackSelectionArr;
                }
            }
            i3 = i2;
            i2 = i3 + 1;
            j3 = j;
            dashMediaPeriod = this;
            trackSelectionArr2 = trackSelectionArr;
        }
        TrackSelection[] trackSelectionArr3 = trackSelectionArr2;
        i = 0;
        while (i < trackSelectionArr3.length) {
            if (((sampleStreamArr[i] instanceof EmbeddedSampleStream) || (sampleStreamArr[i] instanceof EmptySampleStream)) && (trackSelectionArr3[i] == null || !zArr[i])) {
                m17258a(sampleStreamArr[i]);
                sampleStreamArr[i] = null;
            }
            if (trackSelectionArr3[i] != null) {
                TrackGroupInfo trackGroupInfo2 = this.f16979n[this.f16978m.m3975a(trackSelectionArr3[i].mo1459d())];
                if (!trackGroupInfo2.f4793c) {
                    ChunkSampleStream chunkSampleStream3 = (ChunkSampleStream) hashMap.get(Integer.valueOf(trackGroupInfo2.f4794d));
                    SampleStream sampleStream = sampleStreamArr[i];
                    boolean z3 = chunkSampleStream3 == null ? sampleStream instanceof EmptySampleStream : (sampleStream instanceof EmbeddedSampleStream) && ((EmbeddedSampleStream) sampleStream).f13322a == chunkSampleStream3;
                    if (!z3) {
                        EmptySampleStream emptySampleStream;
                        m17258a(sampleStream);
                        if (chunkSampleStream3 == null) {
                            emptySampleStream = new EmptySampleStream();
                            j2 = j;
                        } else {
                            emptySampleStream = chunkSampleStream3.m12387a(j, trackGroupInfo2.f4792b);
                        }
                        sampleStreamArr[i] = emptySampleStream;
                        zArr2[i] = true;
                        i++;
                    }
                }
            } else {
                DashMediaPeriod dashMediaPeriod3 = this;
            }
            j2 = j;
            i++;
        }
        j2 = j;
        this.f16968c = new ChunkSampleStream[hashMap.size()];
        hashMap.values().toArray(this.f16968c);
        this.f16980o = new CompositeSequenceableLoader(this.f16968c);
        return j2;
    }

    public final void mo3352a(long j) {
        for (ChunkSampleStream chunkSampleStream : this.f16968c) {
            for (int i = 0; i < chunkSampleStream.f13328c.length; i++) {
                chunkSampleStream.f13328c[i].m12354a(j, true, chunkSampleStream.f13326a[i]);
            }
        }
    }

    public final boolean mo1401c(long j) {
        return this.f16980o.mo1401c(j);
    }

    public final long mo1403e() {
        return this.f16980o.mo1403e();
    }

    public final long mo1402d() {
        return this.f16980o.mo1402d();
    }

    public final long mo3354b(long j) {
        for (ChunkSampleStream b : this.f16968c) {
            b.m12393b(j);
        }
        return j;
    }

    private static Descriptor m17260b(List<Descriptor> list) {
        for (int i = 0; i < list.size(); i++) {
            Descriptor descriptor = (Descriptor) list.get(i);
            if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(descriptor.f4827a)) {
                return descriptor;
            }
        }
        return null;
    }

    private static boolean m17259a(List<AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            List list2 = ((AdaptationSet) list.get(i)).f4809c;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!((Representation) list2.get(i2)).f4842f.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m17261b(List<AdaptationSet> list, int[] iArr) {
        for (int i : iArr) {
            List list2 = ((AdaptationSet) list.get(i)).f4810d;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if ("urn:scte:dash:cc:cea-608:2015".equals(((Descriptor) list2.get(i2)).f4827a)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void m17258a(SampleStream sampleStream) {
        if (sampleStream instanceof EmbeddedSampleStream) {
            EmbeddedSampleStream embeddedSampleStream = (EmbeddedSampleStream) sampleStream;
            Assertions.m4186b(embeddedSampleStream.f13324c.f13326a[embeddedSampleStream.f13323b]);
            embeddedSampleStream.f13324c.f13326a[embeddedSampleStream.f13323b] = false;
        }
    }

    private static Pair<TrackGroupArray, TrackGroupInfo[]> m17257a(List<AdaptationSet> list) {
        int i;
        int i2;
        List list2 = list;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            sparseIntArray.put(((AdaptationSet) list2.get(i4)).f4807a, i4);
        }
        Object[] objArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i5 = 0;
        int i6 = i5;
        while (i5 < size) {
            if (!zArr[i5]) {
                zArr[i5] = true;
                Descriptor b = m17260b(((AdaptationSet) list2.get(i5)).f4811e);
                if (b == null) {
                    i = i6 + 1;
                    objArr[i6] = new int[]{i5};
                    i6 = i;
                } else {
                    String[] split = b.f4828b.split(",");
                    int[] iArr = new int[(split.length + 1)];
                    iArr[0] = i5;
                    i2 = 0;
                    while (i2 < split.length) {
                        int i7 = sparseIntArray.get(Integer.parseInt(split[i2]));
                        zArr[i7] = true;
                        i2++;
                        iArr[i2] = i7;
                    }
                    int i8 = i6 + 1;
                    objArr[i6] = iArr;
                    i6 = i8;
                }
            }
            i5++;
        }
        if (i6 < size) {
            objArr = (int[][]) Arrays.copyOf(objArr, i6);
        }
        size = objArr.length;
        boolean[] zArr2 = new boolean[size];
        zArr = new boolean[size];
        i6 = size;
        for (i5 = 0; i5 < size; i5++) {
            if (m17259a(list2, objArr[i5])) {
                zArr2[i5] = true;
                i6++;
            }
            if (m17261b(list2, objArr[i5])) {
                zArr[i5] = true;
                i6++;
            }
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i6];
        Object obj = new TrackGroupInfo[i6];
        i = 0;
        int i9 = i;
        while (i < size) {
            int i10;
            int i11;
            Object obj2 = objArr[i];
            List arrayList = new ArrayList();
            i2 = obj2.length;
            for (i7 = i3; i7 < i2; i7++) {
                arrayList.addAll(((AdaptationSet) list2.get(obj2[i7])).f4809c);
            }
            Format[] formatArr = new Format[arrayList.size()];
            for (i7 = i3; i7 < formatArr.length; i7++) {
                formatArr[i7] = ((Representation) arrayList.get(i7)).f4839c;
            }
            AdaptationSet adaptationSet = (AdaptationSet) list2.get(obj2[i3]);
            boolean z = zArr2[i];
            boolean z2 = zArr[i];
            trackGroupArr[i9] = new TrackGroup(formatArr);
            int i12 = i9 + 1;
            AdaptationSet adaptationSet2 = adaptationSet;
            Object obj3 = obj2;
            obj[i9] = new TrackGroupInfo(adaptationSet.f4808b, obj2, i9, true, z, z2);
            if (z) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(adaptationSet2.f4807a);
                stringBuilder.append(":emsg");
                trackGroupArr[i12] = new TrackGroup(Format.m3573b(stringBuilder.toString(), "application/x-emsg"));
                i10 = i12 + 1;
                obj[i12] = new TrackGroupInfo(4, obj3, i9, false, false, false);
            } else {
                i10 = i12;
            }
            if (z2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(adaptationSet2.f4807a);
                stringBuilder.append(":cea608");
                formatArr = new Format[1];
                i11 = 0;
                formatArr[0] = Format.m3555a(stringBuilder.toString(), "application/cea-608");
                trackGroupArr[i10] = new TrackGroup(formatArr);
                i3 = i10 + 1;
                obj[i10] = new TrackGroupInfo(3, obj3, i9, false, false, false);
                i9 = i3;
            } else {
                i11 = 0;
                i9 = i10;
            }
            i++;
            i3 = i11;
        }
        return Pair.create(new TrackGroupArray(trackGroupArr), obj);
    }
}
