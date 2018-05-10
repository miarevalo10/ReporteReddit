package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaPeriod.Callback;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

final class MergingMediaPeriod implements MediaPeriod, Callback {
    public final MediaPeriod[] f16952a;
    private final IdentityHashMap<SampleStream, Integer> f16953b = new IdentityHashMap();
    private Callback f16954c;
    private int f16955d;
    private TrackGroupArray f16956e;
    private MediaPeriod[] f16957f;
    private SequenceableLoader f16958g;

    public MergingMediaPeriod(MediaPeriod... mediaPeriodArr) {
        this.f16952a = mediaPeriodArr;
    }

    public final void mo3353a(Callback callback, long j) {
        this.f16954c = callback;
        this.f16955d = this.f16952a.length;
        for (MediaPeriod a : this.f16952a) {
            a.mo3353a(this, j);
        }
    }

    public final void b_() throws IOException {
        for (MediaPeriod b_ : this.f16952a) {
            b_.b_();
        }
    }

    public final TrackGroupArray mo3355b() {
        return this.f16956e;
    }

    public final long mo3351a(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        ArrayList arrayList;
        MergingMediaPeriod mergingMediaPeriod = this;
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[trackSelectionArr2.length];
        int[] iArr2 = new int[trackSelectionArr2.length];
        for (int i = 0; i < trackSelectionArr2.length; i++) {
            int i2;
            if (sampleStreamArr2[i] == null) {
                i2 = -1;
            } else {
                i2 = ((Integer) mergingMediaPeriod.f16953b.get(sampleStreamArr2[i])).intValue();
            }
            iArr[i] = i2;
            iArr2[i] = -1;
            if (trackSelectionArr2[i] != null) {
                TrackGroup d = trackSelectionArr2[i].mo1459d();
                for (int i3 = 0; i3 < mergingMediaPeriod.f16952a.length; i3++) {
                    if (mergingMediaPeriod.f16952a[i3].mo3355b().m3975a(d) != -1) {
                        iArr2[i] = i3;
                        break;
                    }
                }
            }
        }
        mergingMediaPeriod.f16953b.clear();
        Object obj = new SampleStream[trackSelectionArr2.length];
        SampleStream[] sampleStreamArr3 = new SampleStream[trackSelectionArr2.length];
        TrackSelection[] trackSelectionArr3 = new TrackSelection[trackSelectionArr2.length];
        ArrayList arrayList2 = new ArrayList(mergingMediaPeriod.f16952a.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < mergingMediaPeriod.f16952a.length) {
            int i5 = 0;
            while (i5 < trackSelectionArr2.length) {
                TrackSelection trackSelection = null;
                sampleStreamArr3[i5] = iArr[i5] == i4 ? sampleStreamArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    trackSelection = trackSelectionArr2[i5];
                }
                trackSelectionArr3[i5] = trackSelection;
                i5++;
            }
            arrayList = arrayList2;
            TrackSelection[] trackSelectionArr4 = trackSelectionArr3;
            int i6 = i4;
            long a = mergingMediaPeriod.f16952a[i4].mo3351a(trackSelectionArr3, zArr, sampleStreamArr3, zArr2, j2);
            if (i6 == 0) {
                j2 = a;
            } else if (a != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (i5 = 0; i5 < trackSelectionArr2.length; i5++) {
                boolean z2 = true;
                if (iArr2[i5] == i6) {
                    Assertions.m4186b(sampleStreamArr3[i5] != null);
                    obj[i5] = sampleStreamArr3[i5];
                    mergingMediaPeriod.f16953b.put(sampleStreamArr3[i5], Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i5] == i6) {
                    if (sampleStreamArr3[i5] != null) {
                        z2 = false;
                    }
                    Assertions.m4186b(z2);
                }
            }
            if (z) {
                arrayList.add(mergingMediaPeriod.f16952a[i6]);
            }
            i4 = i6 + 1;
            arrayList2 = arrayList;
            trackSelectionArr3 = trackSelectionArr4;
        }
        arrayList = arrayList2;
        System.arraycopy(obj, 0, sampleStreamArr2, 0, obj.length);
        mergingMediaPeriod.f16957f = new MediaPeriod[arrayList.size()];
        arrayList.toArray(mergingMediaPeriod.f16957f);
        mergingMediaPeriod.f16958g = new CompositeSequenceableLoader(mergingMediaPeriod.f16957f);
        return j2;
    }

    public final void mo3352a(long j) {
        for (MediaPeriod a : this.f16957f) {
            a.mo3352a(j);
        }
    }

    public final boolean mo1401c(long j) {
        return this.f16958g.mo1401c(j);
    }

    public final long mo1403e() {
        return this.f16958g.mo1403e();
    }

    public final long mo3357c() {
        long c = this.f16952a[0].mo3357c();
        for (int i = 1; i < this.f16952a.length; i++) {
            if (this.f16952a[i].mo3357c() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (c != -9223372036854775807L) {
            MediaPeriod[] mediaPeriodArr = this.f16957f;
            int length = mediaPeriodArr.length;
            int i2 = 0;
            while (i2 < length) {
                MediaPeriod mediaPeriod = mediaPeriodArr[i2];
                if (mediaPeriod == this.f16952a[0] || mediaPeriod.mo3354b(c) == c) {
                    i2++;
                } else {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return c;
    }

    public final long mo1402d() {
        return this.f16958g.mo1402d();
    }

    public final long mo3354b(long j) {
        j = this.f16957f[0].mo3354b(j);
        for (int i = 1; i < this.f16957f.length; i++) {
            if (this.f16957f[i].mo3354b(j) != j) {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return j;
    }

    public final void mo3347a(MediaPeriod mediaPeriod) {
        mediaPeriod = this.f16955d - 1;
        this.f16955d = mediaPeriod;
        if (mediaPeriod <= null) {
            mediaPeriod = this.f16952a;
            int i = 0;
            int i2 = i;
            while (i < mediaPeriod.length) {
                i2 += mediaPeriod[i].mo3355b().f4786b;
                i++;
            }
            mediaPeriod = new TrackGroup[i2];
            MediaPeriod[] mediaPeriodArr = this.f16952a;
            i = mediaPeriodArr.length;
            i2 = 0;
            int i3 = i2;
            while (i2 < i) {
                TrackGroupArray b = mediaPeriodArr[i2].mo3355b();
                int i4 = b.f4786b;
                int i5 = i3;
                i3 = 0;
                while (i3 < i4) {
                    int i6 = i5 + 1;
                    mediaPeriod[i5] = b.f4787c[i3];
                    i3++;
                    i5 = i6;
                }
                i2++;
                i3 = i5;
            }
            this.f16956e = new TrackGroupArray(mediaPeriod);
            this.f16954c.mo3347a(this);
        }
    }
}
