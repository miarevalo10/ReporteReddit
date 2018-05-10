package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.source.MediaSource.Listener;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.upstream.Allocator;
import java.io.IOException;
import java.util.ArrayList;

public final class MergingMediaSource implements MediaSource {
    private final MediaSource[] f13267a;
    private final ArrayList<MediaSource> f13268b;
    private final Window f13269c;
    private Listener f13270d;
    private Timeline f13271e;
    private Object f13272f;
    private int f13273g;
    private IllegalMergeException f13274h;

    public static final class IllegalMergeException extends IOException {
        public final int f4755a;

        public IllegalMergeException(int i) {
            this.f4755a = i;
        }
    }

    public final void mo1410a(ExoPlayer exoPlayer, Listener listener) {
        this.f13270d = listener;
        for (listener = null; listener < this.f13267a.length; listener++) {
            this.f13267a[listener].mo1410a(exoPlayer, new Listener(this) {
                final /* synthetic */ MergingMediaSource f13266b;

                public final void mo1413a(Timeline timeline, Object obj) {
                    MergingMediaSource.m12337a(this.f13266b, listener, timeline, obj);
                }
            });
        }
    }

    public final void mo1408a() throws IOException {
        if (this.f13274h != null) {
            throw this.f13274h;
        }
        for (MediaSource a : this.f13267a) {
            a.mo1408a();
        }
    }

    public final MediaPeriod mo1407a(MediaPeriodId mediaPeriodId, Allocator allocator) {
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[this.f13267a.length];
        for (int i = 0; i < mediaPeriodArr.length; i++) {
            mediaPeriodArr[i] = this.f13267a[i].mo1407a(mediaPeriodId, allocator);
        }
        return new MergingMediaPeriod(mediaPeriodArr);
    }

    public final void mo1411a(MediaPeriod mediaPeriod) {
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        for (int i = 0; i < this.f13267a.length; i++) {
            this.f13267a[i].mo1411a(mergingMediaPeriod.f16952a[i]);
        }
    }

    public final void mo1412b() {
        for (MediaSource b : this.f13267a) {
            b.mo1412b();
        }
    }

    static /* synthetic */ void m12337a(MergingMediaSource mergingMediaSource, int i, Timeline timeline, Object obj) {
        if (mergingMediaSource.f13274h == null) {
            IllegalMergeException illegalMergeException;
            int b = timeline.mo1302b();
            for (int i2 = 0; i2 < b; i2++) {
                if (timeline.mo1301a(i2, mergingMediaSource.f13269c, 0).f4075e) {
                    illegalMergeException = new IllegalMergeException(0);
                    break;
                }
            }
            if (mergingMediaSource.f13273g == -1) {
                mergingMediaSource.f13273g = timeline.mo1303c();
            } else if (timeline.mo1303c() != mergingMediaSource.f13273g) {
                illegalMergeException = new IllegalMergeException(1);
                mergingMediaSource.f13274h = illegalMergeException;
            }
            illegalMergeException = null;
            mergingMediaSource.f13274h = illegalMergeException;
        }
        if (mergingMediaSource.f13274h == null) {
            mergingMediaSource.f13268b.remove(mergingMediaSource.f13267a[i]);
            if (i == 0) {
                mergingMediaSource.f13271e = timeline;
                mergingMediaSource.f13272f = obj;
            }
            if (mergingMediaSource.f13268b.isEmpty() != 0) {
                mergingMediaSource.f13270d.mo1413a(mergingMediaSource.f13271e, mergingMediaSource.f13272f);
            }
        }
    }
}
