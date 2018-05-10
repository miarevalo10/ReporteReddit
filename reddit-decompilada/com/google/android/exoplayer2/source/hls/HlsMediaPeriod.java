package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import android.text.TextUtils;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.CompositeSequenceableLoader;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class HlsMediaPeriod implements MediaPeriod, Callback, PlaylistEventListener {
    final HlsPlaylistTracker f16997a;
    final Handler f16998b = new Handler();
    HlsSampleStreamWrapper[] f16999c = new HlsSampleStreamWrapper[0];
    private final HlsDataSourceFactory f17000d;
    private final int f17001e;
    private final EventDispatcher f17002f;
    private final Allocator f17003g;
    private final IdentityHashMap<SampleStream, Integer> f17004h = new IdentityHashMap();
    private final TimestampAdjusterProvider f17005i = new TimestampAdjusterProvider();
    private MediaPeriod.Callback f17006j;
    private int f17007k;
    private TrackGroupArray f17008l;
    private HlsSampleStreamWrapper[] f17009m = new HlsSampleStreamWrapper[0];
    private CompositeSequenceableLoader f17010n;

    public final long mo3357c() {
        return -9223372036854775807L;
    }

    public HlsMediaPeriod(HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, int i, EventDispatcher eventDispatcher, Allocator allocator) {
        this.f16997a = hlsPlaylistTracker;
        this.f17000d = hlsDataSourceFactory;
        this.f17001e = i;
        this.f17002f = eventDispatcher;
        this.f17003g = allocator;
    }

    public final void mo3353a(MediaPeriod.Callback callback, long j) {
        this.f17006j = callback;
        this.f16997a.f13505g.add(this);
        HlsMasterPlaylist hlsMasterPlaylist = this.f16997a.f13507i;
        List arrayList = new ArrayList(hlsMasterPlaylist.f13447a);
        ArrayList arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            HlsUrl hlsUrl = (HlsUrl) arrayList.get(i);
            if (hlsUrl.f4880b.f4023k <= 0) {
                if (!m17289a(hlsUrl, "avc")) {
                    if (m17289a(hlsUrl, AudioSampleEntry.TYPE3)) {
                        arrayList3.add(hlsUrl);
                    }
                }
            }
            arrayList2.add(hlsUrl);
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else if (arrayList3.size() < arrayList.size()) {
            arrayList.removeAll(arrayList3);
        }
        List list = hlsMasterPlaylist.f13448b;
        List list2 = hlsMasterPlaylist.f13449c;
        r7.f16999c = new HlsSampleStreamWrapper[((list.size() + 1) + list2.size())];
        r7.f17007k = r7.f16999c.length;
        Assertions.m4184a(arrayList.isEmpty() ^ true);
        HlsUrl[] hlsUrlArr = new HlsUrl[arrayList.size()];
        arrayList.toArray(hlsUrlArr);
        HlsSampleStreamWrapper a = m17288a(0, hlsUrlArr, hlsMasterPlaylist.f13450d, hlsMasterPlaylist.f13451e, j);
        r7.f16999c[0] = a;
        a.m12517a(true);
        a.m12519b();
        int i2 = 0;
        int i3 = 1;
        while (i2 < list.size()) {
            a = m17288a(1, new HlsUrl[]{(HlsUrl) list.get(i2)}, null, Collections.emptyList(), j);
            int i4 = i3 + 1;
            r7.f16999c[i3] = a;
            a.m12519b();
            i2++;
            i3 = i4;
        }
        int i5 = 0;
        while (i5 < list2.size()) {
            a = m17288a(3, new HlsUrl[]{(HlsUrl) list2.get(i5)}, null, Collections.emptyList(), j);
            a.m12511a(0).mo1345a(r12.f4880b);
            a.f13420h = true;
            a.m12527i();
            i4 = i3 + 1;
            r7.f16999c[i3] = a;
            i5++;
            i3 = i4;
        }
        r7.f17009m = r7.f16999c;
    }

    public final void b_() throws IOException {
        for (HlsSampleStreamWrapper c : this.f16999c) {
            c.m12520c();
        }
    }

    public final TrackGroupArray mo3355b() {
        return this.f17008l;
    }

    public final long mo3351a(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr;
        int i;
        HlsMediaPeriod hlsMediaPeriod = this;
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        long j2 = j;
        int[] iArr = new int[trackSelectionArr2.length];
        int[] iArr2 = new int[trackSelectionArr2.length];
        for (int i2 = 0; i2 < trackSelectionArr2.length; i2++) {
            int i3;
            int i4;
            if (sampleStreamArr2[i2] == null) {
                i3 = -1;
            } else {
                i3 = ((Integer) hlsMediaPeriod.f17004h.get(sampleStreamArr2[i2])).intValue();
            }
            iArr[i2] = i3;
            iArr2[i2] = -1;
            if (trackSelectionArr2[i2] != null) {
                TrackGroup d = trackSelectionArr2[i2].mo1459d();
                for (i4 = 0; i4 < hlsMediaPeriod.f16999c.length; i4++) {
                    if (hlsMediaPeriod.f16999c[i4].f13426n.m3975a(d) != -1) {
                        iArr2[i2] = i4;
                        break;
                    }
                }
            }
        }
        hlsMediaPeriod.f17004h.clear();
        Object obj = new SampleStream[trackSelectionArr2.length];
        SampleStream[] sampleStreamArr3 = new SampleStream[trackSelectionArr2.length];
        TrackSelection[] trackSelectionArr3 = new TrackSelection[trackSelectionArr2.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[hlsMediaPeriod.f16999c.length];
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (i5 < hlsMediaPeriod.f16999c.length) {
            int[] iArr3;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            TrackSelection[] trackSelectionArr4;
            boolean z2;
            SampleQueue sampleQueue;
            boolean z3;
            hlsSampleStreamWrapperArr = hlsSampleStreamWrapperArr2;
            int i7 = 0;
            while (i7 < trackSelectionArr2.length) {
                sampleStreamArr3[i7] = iArr[i7] == i5 ? sampleStreamArr2[i7] : null;
                trackSelectionArr3[i7] = iArr2[i7] == i5 ? trackSelectionArr2[i7] : null;
                i7++;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsMediaPeriod.f16999c[i5];
            Assertions.m4186b(hlsSampleStreamWrapper.f13421i);
            i4 = hlsSampleStreamWrapper.f13422j;
            i = i6;
            int i8 = 0;
            while (i8 < trackSelectionArr3.length) {
                if (sampleStreamArr3[i8] == null || (trackSelectionArr3[i8] != null && zArr[i8])) {
                    iArr3 = iArr;
                } else {
                    iArr3 = iArr;
                    hlsSampleStreamWrapper.m12513a(((HlsSampleStream) sampleStreamArr3[i8]).f13407a, false);
                    sampleStreamArr3[i8] = null;
                }
                i8++;
                iArr = iArr3;
            }
            iArr3 = iArr;
            if (!z) {
                if (hlsSampleStreamWrapper.f13431s) {
                    if (i4 == 0) {
                    }
                } else if (j2 != hlsSampleStreamWrapper.f13429q) {
                }
                obj2 = null;
                obj3 = hlsSampleStreamWrapper.f13414b.f4874q;
                obj4 = obj2;
                obj5 = obj3;
                i8 = 0;
                while (i8 < trackSelectionArr3.length) {
                    if (sampleStreamArr3[i8] == null || trackSelectionArr3[i8] == null) {
                        trackSelectionArr4 = trackSelectionArr3;
                        z2 = z;
                    } else {
                        TrackSelection trackSelection = trackSelectionArr3[i8];
                        trackSelectionArr4 = trackSelectionArr3;
                        z2 = z;
                        int a = hlsSampleStreamWrapper.f13426n.m3975a(trackSelection.mo1459d());
                        hlsSampleStreamWrapper.m12513a(a, true);
                        if (a == hlsSampleStreamWrapper.f13427o) {
                            hlsSampleStreamWrapper.f13414b.f4874q = trackSelection;
                            obj5 = trackSelection;
                        }
                        sampleStreamArr3[i8] = new HlsSampleStream(hlsSampleStreamWrapper, a);
                        zArr2[i8] = true;
                        if (obj4 == null) {
                            sampleQueue = hlsSampleStreamWrapper.f13419g[a];
                            sampleQueue.m12359b();
                            obj4 = (sampleQueue.m12358a(j2, true) || sampleQueue.m12349a() == 0) ? null : 1;
                        }
                    }
                    i8++;
                    trackSelectionArr3 = trackSelectionArr4;
                    z = z2;
                }
                trackSelectionArr4 = trackSelectionArr3;
                z2 = z;
                if (hlsSampleStreamWrapper.f13422j != 0) {
                    hlsSampleStreamWrapper.f13414b.f4867j = null;
                    hlsSampleStreamWrapper.f13423k = null;
                    hlsSampleStreamWrapper.f13417e.clear();
                    if (hlsSampleStreamWrapper.f13415c.m12693a()) {
                        hlsSampleStreamWrapper.m12526h();
                    } else {
                        for (SampleQueue sampleQueue2 : hlsSampleStreamWrapper.f13419g) {
                            sampleQueue2.m12361d();
                        }
                        hlsSampleStreamWrapper.f13415c.m12695b();
                    }
                } else {
                    if (!(hlsSampleStreamWrapper.f13417e.isEmpty() || Util.m4313a(obj5, obj3))) {
                        if (!hlsSampleStreamWrapper.f13431s) {
                            obj5.mo3369a(0);
                            if (obj5.mo1463g() != hlsSampleStreamWrapper.f13414b.f4863f.m3974a(((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.getLast()).e)) {
                                obj2 = null;
                                if (obj2 != null) {
                                    hlsSampleStreamWrapper.f13430r = true;
                                    z3 = true;
                                    obj4 = 1;
                                    if (obj4 != null) {
                                        hlsSampleStreamWrapper.m12518a(j2, z3);
                                        for (i8 = 0; i8 < sampleStreamArr3.length; i8++) {
                                            if (sampleStreamArr3[i8] == null) {
                                                zArr2[i8] = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        obj2 = 1;
                        if (obj2 != null) {
                            hlsSampleStreamWrapper.f13430r = true;
                            z3 = true;
                            obj4 = 1;
                            if (obj4 != null) {
                                hlsSampleStreamWrapper.m12518a(j2, z3);
                                for (i8 = 0; i8 < sampleStreamArr3.length; i8++) {
                                    if (sampleStreamArr3[i8] == null) {
                                        zArr2[i8] = true;
                                    }
                                }
                            }
                        }
                    }
                    z3 = z2;
                    if (obj4 != null) {
                        hlsSampleStreamWrapper.m12518a(j2, z3);
                        for (i8 = 0; i8 < sampleStreamArr3.length; i8++) {
                            if (sampleStreamArr3[i8] == null) {
                                zArr2[i8] = true;
                            }
                        }
                    }
                }
                hlsSampleStreamWrapper.f13431s = true;
                obj3 = null;
                for (i8 = 0; i8 < trackSelectionArr2.length; i8++) {
                    if (iArr2[i8] == i5) {
                        Assertions.m4186b(sampleStreamArr3[i8] == null);
                        obj[i8] = sampleStreamArr3[i8];
                        hlsMediaPeriod.f17004h.put(sampleStreamArr3[i8], Integer.valueOf(i5));
                        obj3 = 1;
                    } else if (iArr3[i8] != i5) {
                        Assertions.m4186b(sampleStreamArr3[i8] != null);
                    }
                }
                if (obj3 == null) {
                    hlsSampleStreamWrapperArr[i] = hlsSampleStreamWrapper;
                    i8 = i + 1;
                    if (i != 0) {
                        hlsSampleStreamWrapper.m12517a(true);
                        if (obj4 != null && hlsMediaPeriod.f17009m.length != 0) {
                            if (hlsSampleStreamWrapper != hlsMediaPeriod.f17009m[0]) {
                            }
                        }
                        hlsMediaPeriod.f17005i.f4878a.clear();
                        z = true;
                        i5++;
                        i6 = i8;
                        hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr;
                        iArr = iArr3;
                        trackSelectionArr3 = trackSelectionArr4;
                        sampleStreamArr2 = sampleStreamArr;
                    } else {
                        hlsSampleStreamWrapper.m12517a(false);
                    }
                } else {
                    i8 = i;
                }
                z = z2;
                i5++;
                i6 = i8;
                hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr;
                iArr = iArr3;
                trackSelectionArr3 = trackSelectionArr4;
                sampleStreamArr2 = sampleStreamArr;
            }
            obj2 = 1;
            obj3 = hlsSampleStreamWrapper.f13414b.f4874q;
            obj4 = obj2;
            obj5 = obj3;
            i8 = 0;
            while (i8 < trackSelectionArr3.length) {
                if (sampleStreamArr3[i8] == null) {
                }
                trackSelectionArr4 = trackSelectionArr3;
                z2 = z;
                i8++;
                trackSelectionArr3 = trackSelectionArr4;
                z = z2;
            }
            trackSelectionArr4 = trackSelectionArr3;
            z2 = z;
            if (hlsSampleStreamWrapper.f13422j != 0) {
                if (hlsSampleStreamWrapper.f13431s) {
                    obj5.mo3369a(0);
                    if (obj5.mo1463g() != hlsSampleStreamWrapper.f13414b.f4863f.m3974a(((HlsMediaChunk) hlsSampleStreamWrapper.f13417e.getLast()).e)) {
                        obj2 = null;
                        if (obj2 != null) {
                            hlsSampleStreamWrapper.f13430r = true;
                            z3 = true;
                            obj4 = 1;
                            if (obj4 != null) {
                                hlsSampleStreamWrapper.m12518a(j2, z3);
                                for (i8 = 0; i8 < sampleStreamArr3.length; i8++) {
                                    if (sampleStreamArr3[i8] == null) {
                                        zArr2[i8] = true;
                                    }
                                }
                            }
                        }
                        z3 = z2;
                        if (obj4 != null) {
                            hlsSampleStreamWrapper.m12518a(j2, z3);
                            for (i8 = 0; i8 < sampleStreamArr3.length; i8++) {
                                if (sampleStreamArr3[i8] == null) {
                                    zArr2[i8] = true;
                                }
                            }
                        }
                    }
                }
                obj2 = 1;
                if (obj2 != null) {
                    hlsSampleStreamWrapper.f13430r = true;
                    z3 = true;
                    obj4 = 1;
                    if (obj4 != null) {
                        hlsSampleStreamWrapper.m12518a(j2, z3);
                        for (i8 = 0; i8 < sampleStreamArr3.length; i8++) {
                            if (sampleStreamArr3[i8] == null) {
                                zArr2[i8] = true;
                            }
                        }
                    }
                }
                z3 = z2;
                if (obj4 != null) {
                    hlsSampleStreamWrapper.m12518a(j2, z3);
                    for (i8 = 0; i8 < sampleStreamArr3.length; i8++) {
                        if (sampleStreamArr3[i8] == null) {
                            zArr2[i8] = true;
                        }
                    }
                }
            } else {
                hlsSampleStreamWrapper.f13414b.f4867j = null;
                hlsSampleStreamWrapper.f13423k = null;
                hlsSampleStreamWrapper.f13417e.clear();
                if (hlsSampleStreamWrapper.f13415c.m12693a()) {
                    hlsSampleStreamWrapper.m12526h();
                } else {
                    while (r7 < r3) {
                        sampleQueue2.m12361d();
                    }
                    hlsSampleStreamWrapper.f13415c.m12695b();
                }
            }
            hlsSampleStreamWrapper.f13431s = true;
            obj3 = null;
            for (i8 = 0; i8 < trackSelectionArr2.length; i8++) {
                if (iArr2[i8] == i5) {
                    if (sampleStreamArr3[i8] == null) {
                    }
                    Assertions.m4186b(sampleStreamArr3[i8] == null);
                    obj[i8] = sampleStreamArr3[i8];
                    hlsMediaPeriod.f17004h.put(sampleStreamArr3[i8], Integer.valueOf(i5));
                    obj3 = 1;
                } else if (iArr3[i8] != i5) {
                    if (sampleStreamArr3[i8] != null) {
                    }
                    Assertions.m4186b(sampleStreamArr3[i8] != null);
                }
            }
            if (obj3 == null) {
                i8 = i;
            } else {
                hlsSampleStreamWrapperArr[i] = hlsSampleStreamWrapper;
                i8 = i + 1;
                if (i != 0) {
                    hlsSampleStreamWrapper.m12517a(false);
                } else {
                    hlsSampleStreamWrapper.m12517a(true);
                    if (obj4 != null) {
                    }
                    hlsMediaPeriod.f17005i.f4878a.clear();
                    z = true;
                    i5++;
                    i6 = i8;
                    hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr;
                    iArr = iArr3;
                    trackSelectionArr3 = trackSelectionArr4;
                    sampleStreamArr2 = sampleStreamArr;
                }
            }
            z = z2;
            i5++;
            i6 = i8;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr;
            iArr = iArr3;
            trackSelectionArr3 = trackSelectionArr4;
            sampleStreamArr2 = sampleStreamArr;
        }
        hlsSampleStreamWrapperArr = hlsSampleStreamWrapperArr2;
        i = i6;
        System.arraycopy(obj, 0, sampleStreamArr, 0, obj.length);
        hlsMediaPeriod.f17009m = (HlsSampleStreamWrapper[]) Arrays.copyOf(hlsSampleStreamWrapperArr, i);
        hlsMediaPeriod.f17010n = new CompositeSequenceableLoader(hlsMediaPeriod.f17009m);
        return j2;
    }

    public final void mo3352a(long j) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f17009m) {
            int length = hlsSampleStreamWrapper.f13419g.length;
            for (int i = 0; i < length; i++) {
                hlsSampleStreamWrapper.f13419g[i].m12354a(j, false, hlsSampleStreamWrapper.f13428p[i]);
            }
        }
    }

    public final boolean mo1401c(long j) {
        return this.f17010n.mo1401c(j);
    }

    public final long mo1403e() {
        return this.f17010n.mo1403e();
    }

    public final long mo1402d() {
        return this.f17010n.mo1402d();
    }

    public final long mo3354b(long j) {
        if (this.f17009m.length > 0) {
            boolean a = this.f17009m[0].m12518a(j, false);
            for (int i = 1; i < this.f17009m.length; i++) {
                this.f17009m[i].m12518a(j, a);
            }
            if (a) {
                this.f17005i.f4878a.clear();
            }
        }
        return j;
    }

    public final void mo3374f() {
        int i = this.f17007k - 1;
        this.f17007k = i;
        if (i <= 0) {
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.f16999c;
            int i2 = 0;
            int i3 = i2;
            while (i2 < hlsSampleStreamWrapperArr.length) {
                i3 += hlsSampleStreamWrapperArr[i2].f13426n.f4786b;
                i2++;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i3];
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.f16999c;
            i2 = hlsSampleStreamWrapperArr2.length;
            i3 = 0;
            int i4 = i3;
            while (i3 < i2) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = hlsSampleStreamWrapperArr2[i3];
                int i5 = hlsSampleStreamWrapper.f13426n.f4786b;
                int i6 = i4;
                i4 = 0;
                while (i4 < i5) {
                    int i7 = i6 + 1;
                    trackGroupArr[i6] = hlsSampleStreamWrapper.f13426n.f4787c[i4];
                    i4++;
                    i6 = i7;
                }
                i3++;
                i4 = i6;
            }
            this.f17008l = new TrackGroupArray(trackGroupArr);
            this.f17006j.mo3347a(this);
        }
    }

    public final void mo3372a(HlsUrl hlsUrl) {
        ((MediaPlaylistBundle) this.f16997a.f13503e.get(hlsUrl)).m12555a();
    }

    public final void mo3375g() {
        m17290h();
    }

    public final void mo3373b(HlsUrl hlsUrl) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.f16999c) {
            HlsChunkSource hlsChunkSource = hlsSampleStreamWrapper.f13414b;
            int a = hlsChunkSource.f4863f.m3974a(hlsUrl.f4880b);
            if (a != -1) {
                a = hlsChunkSource.f4874q.mo1458c(a);
                if (a != -1) {
                    hlsChunkSource.f4874q.mo1460d(a);
                }
            }
        }
        m17290h();
    }

    private HlsSampleStreamWrapper m17288a(int i, HlsUrl[] hlsUrlArr, Format format, List<Format> list, long j) {
        return new HlsSampleStreamWrapper(i, this, new HlsChunkSource(this.f16997a, hlsUrlArr, this.f17000d, this.f17005i, list), this.f17003g, j, format, this.f17001e, this.f17002f);
    }

    private void m17290h() {
        if (this.f17008l != null) {
            this.f17006j.mo3348a(this);
            return;
        }
        for (HlsSampleStreamWrapper b : this.f16999c) {
            b.m12519b();
        }
    }

    private static boolean m17289a(HlsUrl hlsUrl, String str) {
        hlsUrl = hlsUrl.f4880b.f4015c;
        if (TextUtils.isEmpty(hlsUrl)) {
            return false;
        }
        for (String startsWith : hlsUrl.split("(\\s*,\\s*)|(\\s*$)")) {
            if (startsWith.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
