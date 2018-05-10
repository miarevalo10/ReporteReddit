package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.MediaPeriodInfoSequence.MediaPeriodInfo;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource.Listener;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;
import java.io.IOException;

final class ExoPlayerImplInternal implements Callback, MediaPeriod.Callback, Listener, InvalidationListener {
    private long f16794A;
    private int f16795B;
    private SeekPosition f16796C;
    private long f16797D;
    private MediaPeriodHolder f16798E;
    private MediaPeriodHolder f16799F;
    private MediaPeriodHolder f16800G;
    private Timeline f16801H;
    final Handler f16802a;
    boolean f16803b;
    int f16804c;
    private final Renderer[] f16805d;
    private final RendererCapabilities[] f16806e;
    private final TrackSelector f16807f;
    private final LoadControl f16808g;
    private final StandaloneMediaClock f16809h;
    private final HandlerThread f16810i;
    private final Handler f16811j;
    private final ExoPlayer f16812k;
    private final Window f16813l;
    private final Period f16814m;
    private final MediaPeriodInfoSequence f16815n;
    private PlaybackInfo f16816o;
    private PlaybackParameters f16817p;
    private Renderer f16818q;
    private MediaClock f16819r;
    private MediaSource f16820s;
    private Renderer[] f16821t;
    private boolean f16822u;
    private boolean f16823v;
    private boolean f16824w;
    private int f16825x = 1;
    private int f16826y;
    private int f16827z;

    private static final class MediaPeriodHolder {
        public final MediaPeriod f3981a;
        public final Object f3982b;
        public final int f3983c;
        public final SampleStream[] f3984d;
        public final boolean[] f3985e;
        public final long f3986f;
        public MediaPeriodInfo f3987g;
        public boolean f3988h;
        public boolean f3989i;
        public MediaPeriodHolder f3990j;
        public TrackSelectorResult f3991k;
        final LoadControl f3992l;
        private final Renderer[] f3993m;
        private final RendererCapabilities[] f3994n;
        private final TrackSelector f3995o;
        private final MediaSource f3996p;
        private TrackSelectorResult f3997q;

        public MediaPeriodHolder(Renderer[] rendererArr, RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector, LoadControl loadControl, MediaSource mediaSource, Object obj, int i, MediaPeriodInfo mediaPeriodInfo) {
            this.f3993m = rendererArr;
            this.f3994n = rendererCapabilitiesArr;
            this.f3986f = j;
            this.f3995o = trackSelector;
            this.f3992l = loadControl;
            this.f3996p = mediaSource;
            this.f3982b = Assertions.m4182a(obj);
            this.f3983c = i;
            this.f3987g = mediaPeriodInfo;
            this.f3984d = new SampleStream[rendererArr.length];
            this.f3985e = new boolean[rendererArr.length];
            rendererArr = mediaSource.mo1407a(mediaPeriodInfo.f4043a, loadControl.mo1282d());
            if (mediaPeriodInfo.f4045c != -9223372036854775808) {
                rendererCapabilitiesArr = new ClippingMediaPeriod(rendererArr);
                j = mediaPeriodInfo.f4045c;
                rendererCapabilitiesArr.f16912b = null;
                rendererCapabilitiesArr.f16913c = j;
                rendererArr = rendererCapabilitiesArr;
            }
            this.f3981a = rendererArr;
        }

        public final long m3546a() {
            return this.f3983c == 0 ? this.f3986f : this.f3986f - this.f3987g.f4044b;
        }

        public final boolean m3549b() {
            return this.f3988h && (!this.f3989i || this.f3981a.mo1402d() == Long.MIN_VALUE);
        }

        public final boolean m3550c() throws ExoPlaybackException {
            boolean z;
            TrackSelectorResult a = this.f3995o.mo1464a(this.f3994n, this.f3981a.mo3355b());
            TrackSelectorResult trackSelectorResult = this.f3997q;
            if (trackSelectorResult != null) {
                int i = 0;
                while (i < a.f5152b.f5147a) {
                    if (a.m4136a(trackSelectorResult, i)) {
                        i++;
                    }
                }
                z = true;
                if (z) {
                    return false;
                }
                this.f3991k = a;
                return true;
            }
            z = false;
            if (z) {
                return false;
            }
            this.f3991k = a;
            return true;
        }

        public final long m3547a(long j) {
            return m3548a(j, false, new boolean[this.f3993m.length]);
        }

        public final long m3548a(long j, boolean z, boolean[] zArr) {
            TrackSelectionArray trackSelectionArray = this.f3991k.f5152b;
            int i = 0;
            while (true) {
                boolean z2 = true;
                if (i >= trackSelectionArray.f5147a) {
                    break;
                }
                boolean[] zArr2 = r0.f3985e;
                if (z || !r0.f3991k.m4136a(r0.f3997q, i)) {
                    z2 = false;
                }
                zArr2[i] = z2;
                i++;
            }
            long a = r0.f3981a.mo3351a(trackSelectionArray.m4133a(), r0.f3985e, r0.f3984d, zArr, j);
            r0.f3997q = r0.f3991k;
            r0.f3989i = false;
            for (int i2 = 0; i2 < r0.f3984d.length; i2++) {
                if (r0.f3984d[i2] != null) {
                    Assertions.m4186b(trackSelectionArray.f5148b[i2] != null);
                    r0.f3989i = true;
                } else {
                    Assertions.m4186b(trackSelectionArray.f5148b[i2] == null);
                }
            }
            r0.f3992l.mo1277a(r0.f3993m, trackSelectionArray);
            return a;
        }

        public final void m3551d() {
            try {
                if (this.f3987g.f4045c != Long.MIN_VALUE) {
                    this.f3996p.mo1411a(((ClippingMediaPeriod) this.f3981a).f16911a);
                } else {
                    this.f3996p.mo1411a(this.f3981a);
                }
            } catch (Throwable e) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e);
            }
        }
    }

    public static final class PlaybackInfo {
        public final MediaPeriodId f3998a;
        public final long f3999b;
        public final long f4000c;
        public volatile long f4001d;
        public volatile long f4002e;

        public PlaybackInfo(long j) {
            this(new MediaPeriodId(0), j);
        }

        public PlaybackInfo(MediaPeriodId mediaPeriodId, long j) {
            this(mediaPeriodId, j, -9223372036854775807L);
        }

        public PlaybackInfo(MediaPeriodId mediaPeriodId, long j, long j2) {
            this.f3998a = mediaPeriodId;
            this.f3999b = j;
            this.f4000c = j2;
            this.f4001d = j;
            this.f4002e = j;
        }
    }

    private static final class SeekPosition {
        public final Timeline f4003a;
        public final int f4004b;
        public final long f4005c;

        public SeekPosition(Timeline timeline, int i, long j) {
            this.f4003a = timeline;
            this.f4004b = i;
            this.f4005c = j;
        }
    }

    public static final class SourceInfo {
        public final Timeline f4006a;
        public final Object f4007b;
        public final PlaybackInfo f4008c;
        public final int f4009d;

        public SourceInfo(Timeline timeline, Object obj, PlaybackInfo playbackInfo, int i) {
            this.f4006a = timeline;
            this.f4007b = obj;
            this.f4008c = playbackInfo;
            this.f4009d = i;
        }
    }

    public final boolean handleMessage(android.os.Message r43) {
        /* JADX: method processing error */
/*
Error: java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:463)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:464)
*/
        /*
        r42 = this;
        r1 = r42;
        r2 = r43;
        r4 = 1;
        r5 = r2.what;	 Catch:{ ExoPlaybackException -> 0x0b4a, IOException -> 0x0b2d, RuntimeException -> 0x0b10 }
        r6 = 7;
        r9 = 3;
        r10 = 4;
        r11 = 0;
        r13 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r15 = -1;
        r3 = 2;
        r7 = 0;
        r8 = 0;
        switch(r5) {
            case 0: goto L_0x0acb;
            case 1: goto L_0x0a9b;
            case 2: goto L_0x05ac;
            case 3: goto L_0x04c1;
            case 4: goto L_0x04a0;
            case 5: goto L_0x049c;
            case 6: goto L_0x0485;
            case 7: goto L_0x025b;
            case 8: goto L_0x0200;
            case 9: goto L_0x01ed;
            case 10: goto L_0x00f6;
            case 11: goto L_0x00b4;
            case 12: goto L_0x0019;
            default: goto L_0x0018;
        };
    L_0x0018:
        return r8;
    L_0x0019:
        r2 = r2.arg1;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16826y = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16815n;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3.f4053d = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 == 0) goto L_0x0028;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0025:
        r3 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x002a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0028:
        r3 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x002a:
        if (r3 == 0) goto L_0x00b3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x002c:
        r5 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r3.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.f4043a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.f4752b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r1.f16814m;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r1.f16813l;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.m3630a(r6, r9, r10, r2);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x003c:
        r6 = r3.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 == 0) goto L_0x0049;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0040:
        r6 = r3.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.f4048f;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 != 0) goto L_0x0049;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0046:
        r3 = r3.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x003c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0049:
        if (r5 == r15) goto L_0x005c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x004b:
        r6 = r3.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 == 0) goto L_0x005c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x004f:
        r6 = r3.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.f4043a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.f4752b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 != r5) goto L_0x005c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0059:
        r3 = r3.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x002c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x005c:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f3983c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r1.f16799F;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 == 0) goto L_0x0069;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0064:
        r5 = r1.f16799F;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.f3983c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x006a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0069:
        r5 = r15;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x006a:
        r6 = r3.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 == 0) goto L_0x0075;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x006e:
        r6 = r3.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        m17117a(r6);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3.f3990j = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0075:
        r6 = r1.f16815n;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r3.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r7.f4043a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.m3591a(r7, r9);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3.f3987g = r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r3.f3983c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r2 > r6) goto L_0x0087;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0085:
        r2 = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0088;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0087:
        r2 = r8;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0088:
        if (r2 != 0) goto L_0x008c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x008a:
        r1.f16798E = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x008c:
        if (r5 == r15) goto L_0x0093;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x008e:
        r2 = r3.f3983c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 > r2) goto L_0x0093;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0092:
        r8 = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0093:
        if (r8 != 0) goto L_0x00b3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0095:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x00b3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0099:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r2.f4043a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f4001d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r1.m17111a(r6, r2);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r3.f4000c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5.<init>(r6, r7, r9);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16816o = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00b3:
        return r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00b4:
        r2 = r2.obj;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = (com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage[]) r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r2.length;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00b9:
        if (r8 >= r5) goto L_0x00c9;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00bb:
        r6 = r2[r8];	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r6.f3977a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r6.f3978b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.f3979c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7.mo3312a(r10, r6);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r8 = r8 + 1;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x00b9;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00c9:
        r2 = r1.f16825x;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r2 == r9) goto L_0x00d1;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00cd:
        r2 = r1.f16825x;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r2 != r3) goto L_0x00d6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00d1:
        r2 = r1.f16802a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.sendEmptyMessage(r3);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00d6:
        monitor-enter(r42);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16827z;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2 + r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16827z = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r42.notifyAll();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        monitor-exit(r42);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        return r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00e1:
        r0 = move-exception;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r0;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        monitor-exit(r42);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        throw r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00e5:
        r0 = move-exception;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r0;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        monitor-enter(r42);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16827z;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3 + r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16827z = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r42.notifyAll();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        monitor-exit(r42);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        throw r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00f2:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r42);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        throw r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00f6:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x01ec;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00fa:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00fd:
        if (r2 == 0) goto L_0x01ec;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x00ff:
        r6 = r2.f3988h;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 != 0) goto L_0x0105;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0103:
        goto L_0x01ec;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0105:
        r6 = r2.m3550c();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 != 0) goto L_0x0113;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x010b:
        r6 = r1.f16799F;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r2 != r6) goto L_0x0110;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x010f:
        r5 = r8;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0110:
        r2 = r2.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x00fd;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0113:
        if (r5 == 0) goto L_0x01b1;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0115:
        r5 = r1.f16799F;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 == r6) goto L_0x011d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x011b:
        r5 = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x011e;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x011d:
        r5 = r8;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x011e:
        r6 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        m17117a(r6);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6.f3990j = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16798E = r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16799F = r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r1.f16805d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.length;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = new boolean[r6];	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r11 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r11 = r11.f4001d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r10.m3548a(r11, r5, r6);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r12 = r5.f4001d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 == 0) goto L_0x014f;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0148:
        r5 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5.f4001d = r10;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.m17115a(r10);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x014f:
        r5 = r1.f16805d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.length;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = new boolean[r5];	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r8;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r11 = r10;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0156:
        r12 = r1.f16805d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r12 = r12.length;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r10 >= r12) goto L_0x01a2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x015b:
        r12 = r1.f16805d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r12 = r12[r10];	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13 = r12.mo3318d();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r13 == 0) goto L_0x0167;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0165:
        r13 = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0168;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0167:
        r13 = r8;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0168:
        r5[r10] = r13;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13 = r13.f3984d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13 = r13[r10];	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r13 == 0) goto L_0x0174;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0172:
        r11 = r11 + 1;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0174:
        r14 = r5[r10];	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r14 == 0) goto L_0x019f;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0178:
        r14 = r12.mo3320f();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r13 == r14) goto L_0x0196;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x017e:
        r14 = r1.f16818q;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r12 != r14) goto L_0x018f;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0182:
        if (r13 != 0) goto L_0x018b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0184:
        r13 = r1.f16809h;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r14 = r1.f16819r;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13.m12717a(r14);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x018b:
        r1.f16819r = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16818q = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x018f:
        m17118a(r12);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r12.mo3326l();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x019f;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0196:
        r13 = r6[r10];	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r13 == 0) goto L_0x019f;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x019a:
        r13 = r1.f16797D;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r12.mo3313a(r13);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x019f:
        r10 = r10 + 1;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0156;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01a2:
        r6 = r1.f16811j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f3991k;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r6.obtainMessage(r9, r2);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.sendToTarget();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.m17121a(r5, r11);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x01e1;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01b1:
        r1.f16798E = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01b7:
        if (r2 == 0) goto L_0x01bf;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01b9:
        r2.m3551d();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x01b7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01bf:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.f3990j = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f3988h;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x01e1;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01c9:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r2.f4044b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r1.f16797D;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r2.m3546a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r7 - r9;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = java.lang.Math.max(r5, r7);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.m3547a(r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01e1:
        r42.m17132g();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r42.m17129d();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16802a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.sendEmptyMessage(r3);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01ec:
        return r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01ed:
        r2 = r2.obj;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = (com.google.android.exoplayer2.source.MediaPeriod) r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 == 0) goto L_0x01ff;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01f5:
        r3 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.f3981a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 == r2) goto L_0x01fc;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01fb:
        goto L_0x01ff;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01fc:
        r42.m17132g();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x01ff:
        return r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0200:
        r2 = r2.obj;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = (com.google.android.exoplayer2.source.MediaPeriod) r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 == 0) goto L_0x025a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0208:
        r3 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.f3981a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 == r2) goto L_0x020f;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x020e:
        goto L_0x025a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x020f:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.f3988h = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.m3550c();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r2.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r3.f4044b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r18 = r2.m3547a(r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r2.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = new com.google.android.exoplayer2.MediaPeriodInfoSequence$MediaPeriodInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r3.f4043a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r3.f4045c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r3.f4046d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r11 = r3.f4047e;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13 = r3.f4048f;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.f4049g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r16 = r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r17 = r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r20 = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r22 = r9;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r24 = r11;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r26 = r13;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r27 = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r16.<init>(r17, r18, r20, r22, r24, r26, r27);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.f3987g = r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x0257;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0245:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16799F = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16799F;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.f4044b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.m17115a(r2);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16799F;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.m17124b(r2);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0257:
        r42.m17132g();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x025a:
        return r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x025b:
        r2 = r2.obj;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = (android.util.Pair) r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r2.first;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = (com.google.android.exoplayer2.Timeline) r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16801H = r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r1.f16815n;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5.f4052c = r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.second;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 != 0) goto L_0x0307;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0271:
        r3 = r1.f16795B;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 <= 0) goto L_0x02bb;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0275:
        r3 = r1.f16796C;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.m17112a(r3);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r1.f16795B;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16795B = r8;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16796C = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 != 0) goto L_0x0288;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0283:
        r1.m17119a(r2, r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0484;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0288:
        r6 = r3.first;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = (java.lang.Integer) r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.intValue();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.second;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = (java.lang.Long) r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r3.longValue();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16815n;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.m3593a(r6, r7);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r3.m3937a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r9 == 0) goto L_0x02a9;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02a6:
        r18 = r11;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x02ab;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02a9:
        r18 = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02ab:
        r16 = r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r17 = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r20 = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r16.<init>(r17, r18, r20);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16816o = r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.m17125b(r2, r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0484;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02bb:
        r3 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r3.f3999b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1));	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 != 0) goto L_0x0302;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02c3:
        r3 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.m3636a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 == 0) goto L_0x02d0;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02cb:
        r1.m17119a(r2, r8);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0484;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02d0:
        r3 = r1.m17122b(r8);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r3.first;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = (java.lang.Integer) r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.intValue();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.second;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = (java.lang.Long) r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r3.longValue();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16815n;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.m3593a(r5, r6);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r3.m3937a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r9 == 0) goto L_0x02f5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02f2:
        r18 = r11;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x02f7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02f5:
        r18 = r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x02f7:
        r16 = r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r17 = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r20 = r6;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r16.<init>(r17, r18, r20);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16816o = r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0302:
        r1.m17125b(r2, r8);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0484;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0307:
        r5 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.f3998a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.f4752b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 == 0) goto L_0x0314;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0311:
        r6 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0316;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0314:
        r6 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0316:
        if (r6 != 0) goto L_0x031e;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0318:
        r9 = r3.mo1303c();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 >= r9) goto L_0x0481;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x031e:
        if (r6 != 0) goto L_0x0329;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0320:
        r9 = r1.f16814m;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r3.mo1300a(r5, r9, r4);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r9.f4061b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x032b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0329:
        r9 = r6.f3982b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x032b:
        r10 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r10.mo1299a(r9);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r9 != r15) goto L_0x03a7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0333:
        r7 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.m17110a(r5, r3, r7);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 != r15) goto L_0x0340;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x033b:
        r1.m17119a(r2, r8);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0484;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0340:
        r5 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r1.f16814m;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r5.mo1300a(r3, r7, r8);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.f4062c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.m17122b(r3);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r3.first;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = (java.lang.Integer) r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.intValue();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.second;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = (java.lang.Long) r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r3.longValue();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r1.f16814m;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3.mo1300a(r5, r7, r4);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 == 0) goto L_0x0395;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0367:
        r3 = r1.f16814m;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.f4061b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r6.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r7.m3585a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6.f3987g = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0373:
        r7 = r6.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r7 == 0) goto L_0x0395;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0377:
        r6 = r6.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r6.f3982b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r7.equals(r3);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r7 == 0) goto L_0x038c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0381:
        r7 = r1.f16815n;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r11 = r6.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r7.m3590a(r11, r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6.f3987g = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0373;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x038c:
        r7 = r6.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = r7.m3585a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6.f3987g = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0373;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0395:
        r3 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3.<init>(r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r1.m17111a(r3, r9);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r7.<init>(r3, r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16816o = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0481;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x03a7:
        if (r9 == r5) goto L_0x03ca;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x03a9:
        r3 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r3.f3998a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r17 = r10.m3936a(r9);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r3.f3999b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13 = r3.f4000c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r16 = r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r18 = r10;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r20 = r13;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r16.<init>(r17, r18, r20);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r3.f4001d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5.f4001d = r10;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r3.f4002e;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5.f4002e = r10;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16816o = r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x03ca:
        r3 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.f3998a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.m3937a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 == 0) goto L_0x0415;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x03d4:
        r3 = r1.f16815n;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r5.f4000c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.m3593a(r9, r10);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r3.m3937a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 == 0) goto L_0x03ee;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x03e4:
        r5 = r3.f4754d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r10.f3998a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r10.f4754d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 == r10) goto L_0x0415;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x03ee:
        r5 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.f4000c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r18 = r1.m17111a(r3, r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r3.m3937a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 == 0) goto L_0x0403;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x03fc:
        r5 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13 = r5.f4000c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r20 = r13;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0408;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0403:
        r20 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0408:
        r5 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r16 = r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r17 = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r16.<init>(r17, r18, r20);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16816o = r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0481;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0415:
        if (r6 == 0) goto L_0x0481;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0417:
        r3 = r1.m17113a(r6, r9);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x041b:
        r5 = r3.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 == 0) goto L_0x0481;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x041f:
        r5 = r3.f3990j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r1.f16814m;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r11 = r1.f16813l;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r12 = r1.f16826y;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r6.m3630a(r9, r10, r11, r12);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r9 == r15) goto L_0x0446;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x042f:
        r6 = r5.f3982b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r11 = r1.f16814m;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r10.mo1300a(r9, r11, r4);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r10.f4061b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.equals(r10);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 == 0) goto L_0x0446;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0441:
        r3 = r1.m17113a(r5, r9);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x041b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0446:
        r6 = r1.f16799F;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 == 0) goto L_0x0454;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x044a:
        r6 = r1.f16799F;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r6.f3983c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r5.f3983c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r6 >= r9) goto L_0x0454;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0452:
        r6 = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0455;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0454:
        r6 = r8;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0455:
        if (r6 != 0) goto L_0x0478;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0457:
        r3 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.f4043a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.f4001d;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r11 = r1.m17111a(r3, r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r1.f16800G;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.f3987g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r10 = r5.f4043a;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13 = r5.f4000c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9 = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r9.<init>(r10, r11, r13);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16816o = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0481;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0478:
        r1.f16798E = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16798E;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3.f3990j = r7;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        m17117a(r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0481:
        r1.m17125b(r2, r8);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0484:
        return r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0485:
        r1.m17126b(r4);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16808g;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.mo1281c();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.m17114a(r4);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        monitor-enter(r42);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16803b = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r42.notifyAll();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        monitor-exit(r42);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        return r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0498:
        r0 = move-exception;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r0;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        monitor-exit(r42);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        throw r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x049c:
        r42.m17130e();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        return r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04a0:
        r2 = r2.obj;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = (com.google.android.exoplayer2.PlaybackParameters) r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16819r;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 == 0) goto L_0x04af;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04a8:
        r3 = r1.f16819r;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r3.mo1493a(r2);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x04b5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04af:
        r3 = r1.f16809h;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r3.mo1493a(r2);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04b5:
        r1.f16817p = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16811j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r3.obtainMessage(r6, r2);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.sendToTarget();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        return r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04c1:
        r2 = r2.obj;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = (com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition) r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16801H;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 != 0) goto L_0x04d3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04c9:
        r3 = r1.f16795B;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3 + r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16795B = r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16796C = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04d0:
        r2 = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x0584;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04d3:
        r3 = r1.m17112a(r2);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r3 != 0) goto L_0x04fe;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04d9:
        r2 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.<init>(r11);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16816o = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r1.f16811j;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16816o;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = r2.obtainMessage(r10, r4, r8, r3);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.sendToTarget();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2.<init>(r5);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.f16816o = r2;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.m17114a(r10);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r1.m17126b(r8);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x04d0;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x04fe:
        r5 = r2.f4005c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r13 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r2 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1));	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x050b;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x0509:
        r2 = r4;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        goto L_0x050c;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x050b:
        r2 = r8;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
    L_0x050c:
        r5 = r3.first;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = (java.lang.Integer) r5;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r5.intValue();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.second;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = (java.lang.Long) r3;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r6 = r3.longValue();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r1.f16815n;	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r3 = r3.m3593a(r5, r6);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r5 = r3.m3937a();	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        if (r5 == 0) goto L_0x052a;
    L_0x0528:
        r2 = r4;
        goto L_0x052b;
    L_0x052a:
        r11 = r6;
    L_0x052b:
        r5 = r1.f16816o;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.f3998a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r3.equals(r5);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 == 0) goto L_0x055a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0535:
        r13 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r16 = r11 / r13;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r1.f16816o;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r5.f4001d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4 / r13;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r4 != 0) goto L_0x055a;
    L_0x0542:
        r4 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r19 = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r20 = r11;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = r6;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18.<init>(r19, r20, r22);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.f16816o = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16811j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r1.f16816o;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r3.obtainMessage(r10, r2, r8, r4);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0580;
    L_0x055a:
        r20 = r1.m17111a(r3, r11);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1));
        if (r4 == 0) goto L_0x0564;
    L_0x0562:
        r4 = 1;
        goto L_0x0565;
    L_0x0564:
        r4 = r8;
    L_0x0565:
        r2 = r2 | r4;
        r4 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r19 = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = r6;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18.<init>(r19, r20, r22);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.f16816o = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16811j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0579;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0577:
        r2 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x057a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0579:
        r2 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x057a:
        r4 = r1.f16816o;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r3.obtainMessage(r10, r2, r8, r4);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0580:
        r2.sendToTarget();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0584:
        return r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0585:
        r0 = move-exception;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r19 = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r20 = r11;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = r6;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18.<init>(r19, r20, r22);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.f16816o = r5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16811j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r1.f16816o;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r3.obtainMessage(r10, r2, r8, r5);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.sendToTarget();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        throw r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05a2:
        r0 = move-exception;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0b07;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05a7:
        r0 = move-exception;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0b0d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05ac:
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16801H;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x05bd;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05b4:
        r2 = r1.f16820s;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.mo1408a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r28 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x092c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05bd:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x05db;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05c1:
        r2 = r1.f16815n;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r1.f16816o;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r7.f3998a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r7.f4000c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = r7.f3999b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r19 = r11;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r20 = r9;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = r6;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r18.m3592a(r19, r20, r22);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r28 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0766;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05db:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f4049g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x060d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05e3:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.m3549b();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x060d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05eb:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r2.f4047e;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1));	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x05fb;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05fa:
        goto L_0x060d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05fb:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0611;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x05ff:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3983c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = r6.f3983c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2 - r6;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = 100;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == r6) goto L_0x060d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x060c:
        goto L_0x0611;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x060d:
        r28 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x07ec;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0611:
        r2 = r1.f16815n;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = r6.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r9.m3546a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r28 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16797D;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r6.f4048f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 == 0) goto L_0x0699;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0625:
        r5 = r2.f4052c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r6.f4043a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7.f4752b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r13 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r14 = r2.f4051b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r2.f4053d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.m3630a(r7, r13, r14, r11);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 != r15) goto L_0x063a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0637:
        r7 = 0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0766;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x063a:
        r7 = r2.f4052c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7.mo1300a(r5, r11, r8);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7.f4062c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r2.f4052c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r12 = r2.f4051b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r13 = 0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r11.mo1301a(r7, r12, r13);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r11.f4076f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r11 != r5) goto L_0x0687;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0652:
        r5 = r6.f4047e;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r9 + r5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r9 - r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r2.f4052c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r2.f4051b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = 0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r24 = java.lang.Math.max(r11, r9);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r19 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r20 = r5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r21 = r7;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r18.m3633a(r19, r20, r21, r22, r24);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r3 != 0) goto L_0x0676;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0675:
        goto L_0x0637;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0676:
        r4 = r3.first;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = (java.lang.Integer) r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r4.intValue();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3.second;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = (java.lang.Long) r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r3.longValue();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0689;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0687:
        r11 = 0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0689:
        r19 = r2.m3593a(r5, r11);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r20 = r11;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = r11;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r18.m3592a(r19, r20, r22);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0766;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0699:
        r3 = r6.f4043a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r3.m3937a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 == 0) goto L_0x06fd;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06a1:
        r4 = r3.f4753c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r2.f4052c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r3.f4752b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5.mo1300a(r7, r9, r8);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.f4066g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5[r4];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 != r15) goto L_0x06b5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06b4:
        goto L_0x0637;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06b5:
        r7 = r3.f4754d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7 + r9;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r7 >= r5) goto L_0x06d9;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06bb:
        r5 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.m3626a(r4, r7);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 != 0) goto L_0x06c5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06c3:
        goto L_0x0637;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06c5:
        r3 = r3.f4752b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r6.f4046d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r19 = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r20 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r21 = r7;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = r5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r18.m3588a(r19, r20, r21, r22);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0766;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06d9:
        r4 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r6.f4046d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.m3627b(r9);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 != r15) goto L_0x06e6;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06e3:
        r22 = -9223372036854775808;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x06ee;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06e6:
        r5 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.f4065f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r13 = r5[r4];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = r13;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06ee:
        r3 = r3.f4752b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r6.f4046d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r19 = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r20 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r18.m3589a(r19, r20, r22);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0766;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x06fd:
        r4 = r6.f4045c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = -9223372036854775808;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 == 0) goto L_0x072a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0705:
        r4 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r6.f4045c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.m3623a(r9);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.m3626a(r4, r8);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 != 0) goto L_0x0717;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0715:
        goto L_0x0637;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0717:
        r3 = r3.f4752b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r21 = 0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r6.f4045c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r19 = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r20 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = r5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r18.m3588a(r19, r20, r21, r22);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0766;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x072a:
        r4 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.m3622a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 == 0) goto L_0x0637;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0732:
        r5 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4 - r6;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.f4065f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = r5[r4];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = -9223372036854775808;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1));	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 != 0) goto L_0x0637;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0740:
        r5 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.m3625a(r4);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 != 0) goto L_0x0637;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0748:
        r5 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.m3626a(r4, r8);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 != 0) goto L_0x0752;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0750:
        goto L_0x0637;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0752:
        r5 = r2.f4050a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r5.f4063d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3.f4752b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r21 = 0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r18 = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r19 = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r20 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r22 = r5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r18.m3588a(r19, r20, r21, r22);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0766:
        if (r7 != 0) goto L_0x076f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0768:
        r2 = r1.f16820s;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.mo1408a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x07ec;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x076f:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x0779;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0773:
        r2 = 60000000; // 0x3938700 float:8.670878E-37 double:2.96439388E-316;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0776:
        r33 = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0787;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0779:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.m3546a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f4047e;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2 + r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0776;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0787:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x078f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x078b:
        r39 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0797;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x078f:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3983c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 1;
        r2 = r2 + r3;
        r39 = r2;
    L_0x0797:
        r2 = r1.f16801H;	 Catch:{ ExoPlaybackException -> 0x07e8, IOException -> 0x07e4, RuntimeException -> 0x0b10 }
        r4 = r7.f4043a;	 Catch:{ ExoPlaybackException -> 0x07e8, IOException -> 0x07e4, RuntimeException -> 0x0b10 }
        r4 = r4.f4752b;	 Catch:{ ExoPlaybackException -> 0x07e8, IOException -> 0x07e4, RuntimeException -> 0x0b10 }
        r5 = r1.f16814m;	 Catch:{ ExoPlaybackException -> 0x07e8, IOException -> 0x07e4, RuntimeException -> 0x0b10 }
        r2 = r2.mo1300a(r4, r5, r3);	 Catch:{ ExoPlaybackException -> 0x07e8, IOException -> 0x07e4, RuntimeException -> 0x0b10 }
        r2 = r2.f4061b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = new com.google.android.exoplayer2.ExoPlayerImplInternal$MediaPeriodHolder;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r1.f16805d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r1.f16806e;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = r1.f16807f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r1.f16808g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r10 = r1.f16820s;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r30 = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r31 = r4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r32 = r5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r35 = r6;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r36 = r9;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r37 = r10;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r38 = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r40 = r7;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r30.<init>(r31, r32, r33, r35, r36, r37, r38, r39, r40);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x07cc;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x07c8:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.f3990j = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x07cc:
        r1.f16798E = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3981a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r7.f4044b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.mo3353a(r1, r3);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = 1;
        r1.m17120a(r2);	 Catch:{ ExoPlaybackException -> 0x07e0, IOException -> 0x07dc, RuntimeException -> 0x0b10 }
        goto L_0x07ec;
    L_0x07dc:
        r0 = move-exception;
        r3 = r0;
        goto L_0x0b07;
    L_0x07e0:
        r0 = move-exception;
        r3 = r0;
        goto L_0x0b0d;
    L_0x07e4:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0b2f;
    L_0x07e8:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0b4c;
    L_0x07ec:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0805;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x07f0:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.m3549b();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x07f9;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x07f8:
        goto L_0x0805;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x07f9:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0808;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x07fd:
        r2 = r1.f16824w;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x0808;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0801:
        r42.m17132g();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0808;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0805:
        r1.m17120a(r8);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0808:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x092c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x080c:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == r3) goto L_0x0854;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0812:
        r2 = r1.f16797D;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f3990j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f3986f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 < 0) goto L_0x0854;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x081e:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.m3551d();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3990j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.m17124b(r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r10 = r3.f4043a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r3.f4044b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r13 = r3.f4046d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9.<init>(r10, r11, r13);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.f16816o = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r42.m17129d();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16811j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r1.f16816o;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.obtainMessage(r3, r4);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.sendToTarget();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x080c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0854:
        r2 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f4049g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0880;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x085c:
        r2 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x085d:
        r3 = r1.f16805d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3.length;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 >= r3) goto L_0x092c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0862:
        r3 = r1.f16805d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3[r2];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f3984d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4[r2];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 == 0) goto L_0x087d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x086e:
        r5 = r3.mo3320f();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 != r4) goto L_0x087d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0874:
        r4 = r3.mo3321g();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 == 0) goto L_0x087d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x087a:
        r3.mo3322h();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x087d:
        r2 = r2 + 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x085d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0880:
        r2 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0881:
        r3 = r1.f16805d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3.length;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 >= r3) goto L_0x08a3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0886:
        r3 = r1.f16805d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3[r2];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f3984d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4[r2];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r3.mo3320f();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 != r4) goto L_0x092c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0896:
        if (r4 == 0) goto L_0x08a0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0898:
        r3 = r3.mo3321g();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r3 != 0) goto L_0x08a0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x089e:
        goto L_0x092c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08a0:
        r2 = r2 + 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0881;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08a3:
        r2 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3990j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x092c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08a9:
        r2 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3990j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3988h;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x092c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08b1:
        r2 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3991k;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3.f3990j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.f16799F = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r3.f3991k;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f3981a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.mo3357c();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 == 0) goto L_0x08d2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08d0:
        r4 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x08d3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08d2:
        r4 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08d3:
        r5 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08d4:
        r6 = r1.f16805d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = r6.length;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r5 >= r6) goto L_0x092c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08d9:
        r6 = r1.f16805d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6 = r6[r5];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r2.f5152b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7.f5148b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7[r5];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r7 == 0) goto L_0x0929;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08e5:
        if (r4 != 0) goto L_0x0926;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08e7:
        r7 = r6.mo3323i();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r7 != 0) goto L_0x0929;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08ed:
        r7 = r3.f5152b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7.f5148b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7[r5];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r2.f5154d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r9[r5];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r10 = r3.f5154d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r10 = r10[r5];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r7 == 0) goto L_0x0926;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x08fd:
        r9 = r10.equals(r9);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r9 == 0) goto L_0x0926;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0903:
        r9 = r7.mo1461e();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = new com.google.android.exoplayer2.Format[r9];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r10 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x090a:
        r11 = r9.length;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r10 >= r11) goto L_0x0916;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x090d:
        r11 = r7.mo1456a(r10);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9[r10] = r11;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r10 = r10 + 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x090a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0916:
        r7 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7.f3984d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r7[r5];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r10 = r1.f16799F;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r10 = r10.m3546a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r6.mo3315a(r9, r7, r10);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0929;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0926:
        r6.mo3322h();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0929:
        r5 = r5 + 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x08d4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x092c:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 10;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x093d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0932:
        r42.m17131f();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r5 = r28;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.m17116a(r5, r3);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x093a:
        r2 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a9a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x093d:
        r5 = r28;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = "doSomeWork";	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        com.google.android.exoplayer2.util.TraceUtil.m4290a(r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r42.m17129d();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3981a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r1.f16816o;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r7.f4001d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.mo3352a(r9);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16821t;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = r2.length;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r10 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0958:
        if (r9 >= r7) goto L_0x098f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x095a:
        r12 = r2[r9];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r13 = r1.f16797D;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16794A;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r12.mo3913a(r13, r3);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r11 == 0) goto L_0x096d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0965:
        r3 = r12.mo3920r();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r3 == 0) goto L_0x096d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x096b:
        r11 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x096e;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x096d:
        r11 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x096e:
        r3 = r12.mo3919q();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r3 != 0) goto L_0x097d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0974:
        r3 = r12.mo3920r();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r3 == 0) goto L_0x097b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x097a:
        goto L_0x097d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x097b:
        r3 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x097e;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x097d:
        r3 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x097e:
        if (r3 != 0) goto L_0x0983;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0980:
        r12.mo3324j();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0983:
        if (r10 == 0) goto L_0x0989;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0985:
        if (r3 == 0) goto L_0x0989;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0987:
        r10 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x098a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0989:
        r10 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x098a:
        r9 = r9 + 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 10;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0958;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x098f:
        if (r10 != 0) goto L_0x0994;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0991:
        r42.m17131f();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0994:
        r2 = r1.f16819r;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x09b9;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0998:
        r2 = r1.f16819r;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.mo1495w();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16817p;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r2.equals(r3);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r3 != 0) goto L_0x09b9;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09a6:
        r1.f16817p = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16809h;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r1.f16819r;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3.m12717a(r4);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16811j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = 7;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r3.obtainMessage(r4, r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.sendToTarget();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09b9:
        r2 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.f4047e;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r11 == 0) goto L_0x09e3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09c1:
        r11 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1));	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 == 0) goto L_0x09d2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09ca:
        r4 = r1.f16816o;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r4.f4001d;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1));	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 > 0) goto L_0x09e3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09d2:
        r4 = r1.f16800G;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f4049g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 == 0) goto L_0x09e3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09da:
        r4 = 4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.m17114a(r4);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r42.m17128c();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a56;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09e3:
        r4 = r1.f16825x;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = 2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 != r7) goto L_0x0a3a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09e8:
        r4 = r1.f16821t;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.length;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 <= 0) goto L_0x0a28;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09ed:
        if (r10 == 0) goto L_0x0a26;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09ef:
        r2 = r1.f16798E;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16823v;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r1.f16797D;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r2.f3988h;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 != 0) goto L_0x09fe;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09f9:
        r4 = r2.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r4.f4044b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a04;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x09fe:
        r4 = r2.f3981a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r4.mo1402d();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a04:
        r13 = -9223372036854775808;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 != 0) goto L_0x0a16;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a0a:
        r4 = r2.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.f4049g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 == 0) goto L_0x0a12;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a10:
        r4 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a22;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a12:
        r4 = r2.f3987g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r4.f4047e;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a16:
        r4 = r2.f3992l;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r13 = r2.m3546a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r9 = r9 - r13;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r11 = r11 - r9;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.mo1279a(r11, r3);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a22:
        if (r4 == 0) goto L_0x0a26;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a24:
        r4 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a2c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a26:
        r4 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a2c;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a28:
        r4 = r1.m17127b(r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a2c:
        if (r4 == 0) goto L_0x0a56;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a2e:
        r2 = 3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.m17114a(r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16822u;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0a56;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a36:
        r42.m17123b();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a56;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a3a:
        r4 = r1.f16825x;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r7 = 3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 != r7) goto L_0x0a56;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a3f:
        r4 = r1.f16821t;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = r4.length;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r4 <= 0) goto L_0x0a45;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a44:
        goto L_0x0a49;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a45:
        r10 = r1.m17127b(r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a49:
        if (r10 != 0) goto L_0x0a56;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a4b:
        r2 = r1.f16822u;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.f16823v = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = 2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.m17114a(r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r42.m17128c();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a56:
        r2 = r1.f16825x;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != r3) goto L_0x0a68;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a5b:
        r2 = r1.f16821t;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r2.length;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a5e:
        if (r8 >= r3) goto L_0x0a68;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a60:
        r4 = r2[r8];	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4.mo3324j();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r8 = r8 + 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a5e;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a68:
        r2 = r1.f16822u;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0a75;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a6c:
        r2 = r1.f16825x;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == r3) goto L_0x0a72;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a71:
        goto L_0x0a75;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a72:
        r2 = 10;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a7b;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a75:
        r2 = r1.f16825x;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != r3) goto L_0x0a7f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a7a:
        goto L_0x0a72;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a7b:
        r1.m17116a(r5, r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a95;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a7f:
        r2 = r1.f16821t;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.length;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0a8f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a84:
        r2 = r1.f16825x;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 4;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == r3) goto L_0x0a8f;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a89:
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.m17116a(r5, r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0a95;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a8f:
        r2 = r1.f16802a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.removeMessages(r3);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a95:
        com.google.android.exoplayer2.util.TraceUtil.m4289a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x093a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a9a:
        return r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a9b:
        r2 = r2.arg1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0aa1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0a9f:
        r2 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0aa2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0aa1:
        r2 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0aa2:
        r1.f16823v = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.f16822u = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != 0) goto L_0x0ab0;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0aa8:
        r42.m17128c();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r42.m17129d();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0aae:
        r2 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0aca;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0ab0:
        r2 = r1.f16825x;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != r3) goto L_0x0abf;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0ab5:
        r42.m17123b();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16802a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.sendEmptyMessage(r3);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0aae;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0abf:
        r2 = r1.f16825x;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = 2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 != r3) goto L_0x0aae;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0ac4:
        r2 = r1.f16802a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.sendEmptyMessage(r3);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0aae;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0aca:
        return r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0acb:
        r3 = r2.obj;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = (com.google.android.exoplayer2.source.MediaSource) r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r2.arg1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0ad5;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0ad3:
        r2 = 1;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        goto L_0x0ad6;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0ad5:
        r2 = r8;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0ad6:
        r4 = r1.f16811j;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4.sendEmptyMessage(r8);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = 1;
        r1.m17126b(r4);	 Catch:{ all -> 0x0498, all -> 0x00e5, all -> 0x00f2, all -> 0x00e1, ExoPlaybackException -> 0x05a7, IOException -> 0x05a2, RuntimeException -> 0x0b10 }
        r4 = r1.f16808g;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4.mo1276a();	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        if (r2 == 0) goto L_0x0af2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0ae6:
        r2 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfo;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r4 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2.<init>(r4);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.f16816o = r2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
    L_0x0af2:
        r1.f16820s = r3;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = r1.f16812k;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3.mo1410a(r2, r1);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = 2;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r1.m17114a(r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3 = r1.f16802a;	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r3.sendEmptyMessage(r2);	 Catch:{ all -> 0x0585, ExoPlaybackException -> 0x0b0a, IOException -> 0x0b04, RuntimeException -> 0x0b10 }
        r2 = 1;
        return r2;
    L_0x0b04:
        r0 = move-exception;
        r3 = r0;
        r2 = 1;
    L_0x0b07:
        r4 = 8;
        goto L_0x0b32;
    L_0x0b0a:
        r0 = move-exception;
        r3 = r0;
        r2 = 1;
    L_0x0b0d:
        r4 = 8;
        goto L_0x0b4f;
    L_0x0b10:
        r0 = move-exception;
        r2 = r0;
        r3 = "ExoPlayerImplInternal";
        r4 = "Internal runtime error.";
        android.util.Log.e(r3, r4, r2);
        r3 = r1.f16811j;
        r2 = com.google.android.exoplayer2.ExoPlaybackException.m3543a(r2);
        r4 = 8;
        r2 = r3.obtainMessage(r4, r2);
        r2.sendToTarget();
        r42.m17130e();
        r2 = 1;
        return r2;
    L_0x0b2d:
        r0 = move-exception;
        r2 = r4;
    L_0x0b2f:
        r4 = 8;
        r3 = r0;
    L_0x0b32:
        r5 = "ExoPlayerImplInternal";
        r6 = "Source error.";
        android.util.Log.e(r5, r6, r3);
        r5 = r1.f16811j;
        r3 = com.google.android.exoplayer2.ExoPlaybackException.m3541a(r3);
        r3 = r5.obtainMessage(r4, r3);
        r3.sendToTarget();
        r42.m17130e();
        return r2;
    L_0x0b4a:
        r0 = move-exception;
        r2 = r4;
    L_0x0b4c:
        r4 = 8;
        r3 = r0;
    L_0x0b4f:
        r5 = "ExoPlayerImplInternal";
        r6 = "Renderer error.";
        android.util.Log.e(r5, r6, r3);
        r5 = r1.f16811j;
        r3 = r5.obtainMessage(r4, r3);
        r3.sendToTarget();
        r42.m17130e();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.handleMessage(android.os.Message):boolean");
    }

    public final /* synthetic */ void mo3348a(SequenceableLoader sequenceableLoader) {
        this.f16802a.obtainMessage(9, (MediaPeriod) sequenceableLoader).sendToTarget();
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl, boolean z, int i, Handler handler, PlaybackInfo playbackInfo, ExoPlayer exoPlayer) {
        this.f16805d = rendererArr;
        this.f16807f = trackSelector;
        this.f16808g = loadControl;
        this.f16822u = z;
        this.f16826y = i;
        this.f16811j = handler;
        this.f16816o = playbackInfo;
        this.f16812k = exoPlayer;
        this.f16806e = new RendererCapabilities[rendererArr.length];
        for (int i2 = false; i2 < rendererArr.length; i2++) {
            rendererArr[i2].mo3311a(i2);
            this.f16806e[i2] = rendererArr[i2].mo3316b();
        }
        this.f16809h = new StandaloneMediaClock();
        this.f16821t = new Renderer[0];
        this.f16813l = new Window();
        this.f16814m = new Period();
        this.f16815n = new MediaPeriodInfoSequence();
        trackSelector.f5150b = this;
        this.f16817p = PlaybackParameters.f4054a;
        this.f16810i = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f16810i.start();
        this.f16802a = new Handler(this.f16810i.getLooper(), this);
    }

    public final void m17134a(Timeline timeline, int i, long j) {
        this.f16802a.obtainMessage(3, new SeekPosition(timeline, i, j)).sendToTarget();
    }

    public final synchronized void m17138a(com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage... r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f16803b;	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x000e;	 Catch:{ all -> 0x0035 }
    L_0x0005:
        r4 = "ExoPlayerImplInternal";	 Catch:{ all -> 0x0035 }
        r0 = "Ignoring messages sent after release.";	 Catch:{ all -> 0x0035 }
        android.util.Log.w(r4, r0);	 Catch:{ all -> 0x0035 }
        monitor-exit(r3);
        return;
    L_0x000e:
        r0 = r3.f16804c;	 Catch:{ all -> 0x0035 }
        r1 = r0 + 1;	 Catch:{ all -> 0x0035 }
        r3.f16804c = r1;	 Catch:{ all -> 0x0035 }
        r1 = r3.f16802a;	 Catch:{ all -> 0x0035 }
        r2 = 11;	 Catch:{ all -> 0x0035 }
        r4 = r1.obtainMessage(r2, r4);	 Catch:{ all -> 0x0035 }
        r4.sendToTarget();	 Catch:{ all -> 0x0035 }
        r4 = 0;	 Catch:{ all -> 0x0035 }
    L_0x0020:
        r1 = r3.f16827z;	 Catch:{ all -> 0x0035 }
        if (r1 > r0) goto L_0x002a;
    L_0x0024:
        r3.wait();	 Catch:{ InterruptedException -> 0x0028 }
        goto L_0x0020;
    L_0x0028:
        r4 = 1;
        goto L_0x0020;
    L_0x002a:
        if (r4 == 0) goto L_0x0033;
    L_0x002c:
        r4 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0035 }
        r4.interrupt();	 Catch:{ all -> 0x0035 }
    L_0x0033:
        monitor-exit(r3);
        return;
    L_0x0035:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.a(com.google.android.exoplayer2.ExoPlayer$ExoPlayerMessage[]):void");
    }

    public final synchronized void m17133a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f16803b;	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);
        return;
    L_0x0007:
        r0 = r2.f16802a;	 Catch:{ all -> 0x0028 }
        r1 = 6;	 Catch:{ all -> 0x0028 }
        r0.sendEmptyMessage(r1);	 Catch:{ all -> 0x0028 }
        r0 = 0;	 Catch:{ all -> 0x0028 }
    L_0x000e:
        r1 = r2.f16803b;	 Catch:{ all -> 0x0028 }
        if (r1 != 0) goto L_0x0018;
    L_0x0012:
        r2.wait();	 Catch:{ InterruptedException -> 0x0016 }
        goto L_0x000e;
    L_0x0016:
        r0 = 1;
        goto L_0x000e;
    L_0x0018:
        if (r0 == 0) goto L_0x0021;
    L_0x001a:
        r0 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0028 }
        r0.interrupt();	 Catch:{ all -> 0x0028 }
    L_0x0021:
        r0 = r2.f16810i;	 Catch:{ all -> 0x0028 }
        r0.quit();	 Catch:{ all -> 0x0028 }
        monitor-exit(r2);
        return;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.a():void");
    }

    public final void mo1413a(Timeline timeline, Object obj) {
        this.f16802a.obtainMessage(7, Pair.create(timeline, obj)).sendToTarget();
    }

    public final void mo3347a(MediaPeriod mediaPeriod) {
        this.f16802a.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    private void m17114a(int i) {
        if (this.f16825x != i) {
            this.f16825x = i;
            this.f16811j.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private void m17120a(boolean z) {
        if (this.f16824w != z) {
            this.f16824w = z;
            this.f16811j.obtainMessage(2, z, 0).sendToTarget();
        }
    }

    private void m17123b() throws ExoPlaybackException {
        int i = 0;
        this.f16823v = false;
        StandaloneMediaClock standaloneMediaClock = this.f16809h;
        if (!standaloneMediaClock.f13710a) {
            standaloneMediaClock.f13711b = SystemClock.elapsedRealtime();
            standaloneMediaClock.f13710a = true;
        }
        Renderer[] rendererArr = this.f16821t;
        int length = rendererArr.length;
        while (i < length) {
            rendererArr[i].mo3319e();
            i++;
        }
    }

    private void m17128c() throws ExoPlaybackException {
        this.f16809h.m12715a();
        for (Renderer a : this.f16821t) {
            m17118a(a);
        }
    }

    private void m17129d() throws ExoPlaybackException {
        if (this.f16800G != null) {
            long j;
            long c = this.f16800G.f3981a.mo3357c();
            if (c != -9223372036854775807L) {
                m17115a(c);
            } else {
                if (this.f16818q == null || this.f16818q.mo3920r()) {
                    this.f16797D = this.f16809h.mo1494v();
                } else {
                    this.f16797D = this.f16819r.mo1494v();
                    this.f16809h.m12716a(this.f16797D);
                }
                c = this.f16797D - this.f16800G.m3546a();
            }
            this.f16816o.f4001d = c;
            this.f16794A = SystemClock.elapsedRealtime() * 1000;
            if (this.f16821t.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.f16800G.f3981a.mo1402d();
            }
            PlaybackInfo playbackInfo = this.f16816o;
            if (j == Long.MIN_VALUE) {
                j = this.f16800G.f3987g.f4047e;
            }
            playbackInfo.f4002e = j;
        }
    }

    private void m17116a(long j, long j2) {
        this.f16802a.removeMessages(2);
        j = (j + j2) - SystemClock.elapsedRealtime();
        if (j <= 0) {
            this.f16802a.sendEmptyMessage(2);
        } else {
            this.f16802a.sendEmptyMessageDelayed(2, j);
        }
    }

    private long m17111a(MediaPeriodId mediaPeriodId, long j) throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder;
        int b;
        m17128c();
        this.f16823v = false;
        m17114a(2);
        if (this.f16800G == null) {
            if (this.f16798E != null) {
                this.f16798E.m3551d();
            }
            mediaPeriodHolder = null;
        } else {
            MediaPeriodHolder mediaPeriodHolder2 = this.f16800G;
            mediaPeriodHolder = null;
            while (mediaPeriodHolder2 != null) {
                boolean z;
                if (mediaPeriodId.equals(mediaPeriodHolder2.f3987g.f4043a) && mediaPeriodHolder2.f3988h) {
                    this.f16801H.mo1300a(mediaPeriodHolder2.f3987g.f4043a.f4752b, this.f16814m, false);
                    b = this.f16814m.m3627b(j);
                    if (b == -1 || this.f16814m.f4065f[b] == mediaPeriodHolder2.f3987g.f4045c) {
                        z = true;
                        if (z) {
                            mediaPeriodHolder2.m3551d();
                        } else {
                            mediaPeriodHolder = mediaPeriodHolder2;
                        }
                        mediaPeriodHolder2 = mediaPeriodHolder2.f3990j;
                    }
                }
                z = false;
                if (z) {
                    mediaPeriodHolder2.m3551d();
                } else {
                    mediaPeriodHolder = mediaPeriodHolder2;
                }
                mediaPeriodHolder2 = mediaPeriodHolder2.f3990j;
            }
        }
        if (!(this.f16800G == mediaPeriodHolder && this.f16800G == this.f16799F)) {
            for (Renderer l : this.f16821t) {
                l.mo3326l();
            }
            this.f16821t = new Renderer[0];
            this.f16819r = null;
            this.f16818q = null;
            this.f16800G = null;
        }
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.f3990j = null;
            this.f16798E = mediaPeriodHolder;
            this.f16799F = mediaPeriodHolder;
            m17124b(mediaPeriodHolder);
            if (this.f16800G.f3989i != null) {
                j = this.f16800G.f3981a.mo3354b(j);
            }
            m17115a(j);
            m17132g();
        } else {
            this.f16798E = null;
            this.f16799F = null;
            this.f16800G = null;
            m17115a(j);
        }
        this.f16802a.sendEmptyMessage(2);
        return j;
    }

    private void m17115a(long j) throws ExoPlaybackException {
        if (this.f16800G == null) {
            j += 60000000;
        } else {
            j += this.f16800G.m3546a();
        }
        this.f16797D = j;
        this.f16809h.m12716a(this.f16797D);
        for (Renderer a : this.f16821t) {
            a.mo3313a(this.f16797D);
        }
    }

    private void m17130e() {
        m17126b(true);
        this.f16808g.mo1280b();
        m17114a(1);
    }

    private void m17126b(boolean z) {
        this.f16802a.removeMessages(2);
        this.f16823v = false;
        this.f16809h.m12715a();
        this.f16819r = null;
        this.f16818q = null;
        this.f16797D = 60000000;
        for (Renderer renderer : this.f16821t) {
            try {
                m17118a(renderer);
                renderer.mo3326l();
            } catch (Throwable e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.f16821t = new Renderer[0];
        m17117a(this.f16800G != null ? this.f16800G : this.f16798E);
        this.f16798E = null;
        this.f16799F = null;
        this.f16800G = null;
        m17120a(false);
        if (z) {
            if (this.f16820s) {
                this.f16820s.mo1412b();
                this.f16820s = null;
            }
            this.f16815n.f4052c = null;
            this.f16801H = null;
        }
    }

    private static void m17118a(Renderer renderer) throws ExoPlaybackException {
        if (renderer.mo3318d() == 2) {
            renderer.mo3325k();
        }
    }

    private boolean m17127b(long j) {
        if (j != -9223372036854775807L && this.f16816o.f4001d >= j) {
            if (this.f16800G.f3990j != null) {
                if (this.f16800G.f3990j.f3988h == null) {
                    if (this.f16800G.f3990j.f3987g.f4043a.m3937a() != null) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    private void m17131f() throws IOException {
        if (!(this.f16798E == null || this.f16798E.f3988h || (this.f16799F != null && this.f16799F.f3990j != this.f16798E))) {
            Renderer[] rendererArr = this.f16821t;
            int length = rendererArr.length;
            int i = 0;
            while (i < length) {
                if (rendererArr[i].mo3321g()) {
                    i++;
                } else {
                    return;
                }
            }
            this.f16798E.f3981a.b_();
        }
    }

    private MediaPeriodHolder m17113a(MediaPeriodHolder mediaPeriodHolder, int i) {
        while (true) {
            mediaPeriodHolder.f3987g = this.f16815n.m3590a(mediaPeriodHolder.f3987g, i);
            if (mediaPeriodHolder.f3987g.f4048f) {
                break;
            } else if (mediaPeriodHolder.f3990j == null) {
                break;
            } else {
                mediaPeriodHolder = mediaPeriodHolder.f3990j;
            }
        }
        return mediaPeriodHolder;
    }

    private void m17119a(Object obj, int i) {
        this.f16816o = new PlaybackInfo(0);
        m17125b(obj, i);
        this.f16816o = new PlaybackInfo(-9223372036854775807L);
        m17114a(4);
        m17126b((boolean) null);
    }

    private void m17125b(Object obj, int i) {
        this.f16811j.obtainMessage(6, new SourceInfo(this.f16801H, obj, this.f16816o, i)).sendToTarget();
    }

    private int m17110a(int i, Timeline timeline, Timeline timeline2) {
        int c = timeline.mo1303c();
        int i2 = i;
        i = -1;
        for (int i3 = 0; i3 < c && i == -1; i3++) {
            i2 = timeline.m3630a(i2, this.f16814m, this.f16813l, this.f16826y);
            if (i2 == -1) {
                break;
            }
            i = timeline2.mo1299a(timeline.mo1300a(i2, this.f16814m, true).f4061b);
        }
        return i;
    }

    private android.util.Pair<java.lang.Integer, java.lang.Long> m17112a(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r0 = r8.f4003a;
        r1 = r0.m3636a();
        if (r1 == 0) goto L_0x000a;
    L_0x0008:
        r0 = r7.f16801H;
    L_0x000a:
        r2 = r7.f16813l;	 Catch:{ IndexOutOfBoundsException -> 0x0063 }
        r3 = r7.f16814m;	 Catch:{ IndexOutOfBoundsException -> 0x0063 }
        r4 = r8.f4004b;	 Catch:{ IndexOutOfBoundsException -> 0x0063 }
        r5 = r8.f4005c;	 Catch:{ IndexOutOfBoundsException -> 0x0063 }
        r1 = r0;	 Catch:{ IndexOutOfBoundsException -> 0x0063 }
        r1 = r1.m3632a(r2, r3, r4, r5);	 Catch:{ IndexOutOfBoundsException -> 0x0063 }
        r8 = r7.f16801H;
        if (r8 != r0) goto L_0x001c;
    L_0x001b:
        return r1;
    L_0x001c:
        r8 = r7.f16801H;
        r2 = r1.first;
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r3 = r7.f16814m;
        r4 = 1;
        r2 = r0.mo1300a(r2, r3, r4);
        r2 = r2.f4061b;
        r8 = r8.mo1299a(r2);
        r2 = -1;
        if (r8 == r2) goto L_0x0041;
    L_0x0036:
        r8 = java.lang.Integer.valueOf(r8);
        r0 = r1.second;
        r8 = android.util.Pair.create(r8, r0);
        return r8;
    L_0x0041:
        r8 = r1.first;
        r8 = (java.lang.Integer) r8;
        r8 = r8.intValue();
        r1 = r7.f16801H;
        r8 = r7.m17110a(r8, r0, r1);
        if (r8 == r2) goto L_0x0061;
    L_0x0051:
        r0 = r7.f16801H;
        r1 = r7.f16814m;
        r2 = 0;
        r8 = r0.mo1300a(r8, r1, r2);
        r8 = r8.f4062c;
        r8 = r7.m17122b(r8);
        return r8;
    L_0x0061:
        r8 = 0;
        return r8;
    L_0x0063:
        r0 = new com.google.android.exoplayer2.IllegalSeekPositionException;
        r1 = r7.f16801H;
        r2 = r8.f4004b;
        r3 = r8.f4005c;
        r0.<init>(r1, r2, r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.a(com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition):android.util.Pair<java.lang.Integer, java.lang.Long>");
    }

    private Pair<Integer, Long> m17122b(int i) {
        return this.f16801H.m3632a(this.f16813l, this.f16814m, i, -9223372036854775807L);
    }

    private void m17132g() {
        boolean z;
        MediaPeriodHolder mediaPeriodHolder = this.f16798E;
        long j = this.f16797D;
        long e = !mediaPeriodHolder.f3988h ? 0 : mediaPeriodHolder.f3981a.mo1403e();
        if (e == Long.MIN_VALUE) {
            z = false;
        } else {
            z = mediaPeriodHolder.f3992l.mo1278a(e - (j - mediaPeriodHolder.m3546a()));
        }
        m17120a(z);
        if (z) {
            mediaPeriodHolder = this.f16798E;
            mediaPeriodHolder.f3981a.mo1401c(this.f16797D - mediaPeriodHolder.m3546a());
        }
    }

    private static void m17117a(MediaPeriodHolder mediaPeriodHolder) {
        while (mediaPeriodHolder != null) {
            mediaPeriodHolder.m3551d();
            mediaPeriodHolder = mediaPeriodHolder.f3990j;
        }
    }

    private void m17124b(MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        if (this.f16800G != mediaPeriodHolder) {
            boolean[] zArr = new boolean[this.f16805d.length];
            int i = 0;
            int i2 = i;
            while (i < this.f16805d.length) {
                Renderer renderer = this.f16805d[i];
                zArr[i] = renderer.mo3318d() != 0;
                TrackSelection trackSelection = mediaPeriodHolder.f3991k.f5152b.f5148b[i];
                if (trackSelection != null) {
                    i2++;
                }
                if (zArr[i] && (trackSelection == null || (renderer.mo3323i() && renderer.mo3320f() == this.f16800G.f3984d[i]))) {
                    if (renderer == this.f16818q) {
                        this.f16809h.m12717a(this.f16819r);
                        this.f16819r = null;
                        this.f16818q = null;
                    }
                    m17118a(renderer);
                    renderer.mo3326l();
                }
                i++;
            }
            this.f16800G = mediaPeriodHolder;
            this.f16811j.obtainMessage(3, mediaPeriodHolder.f3991k).sendToTarget();
            m17121a(zArr, i2);
        }
    }

    private void m17121a(boolean[] zArr, int i) throws ExoPlaybackException {
        this.f16821t = new Renderer[i];
        int i2 = 0;
        int i3 = i2;
        while (i2 < this.f16805d.length) {
            Renderer renderer = this.f16805d[i2];
            TrackSelection trackSelection = this.f16800G.f3991k.f5152b.f5148b[i2];
            if (trackSelection != null) {
                int i4 = i3 + 1;
                this.f16821t[i3] = renderer;
                if (renderer.mo3318d() == 0) {
                    RendererConfiguration rendererConfiguration = this.f16800G.f3991k.f5154d[i2];
                    i3 = (this.f16822u && this.f16825x == 3) ? 1 : 0;
                    boolean z = (zArr[i2] || i3 == 0) ? false : true;
                    Format[] formatArr = new Format[trackSelection.mo1461e()];
                    for (int i5 = 0; i5 < formatArr.length; i5++) {
                        formatArr[i5] = trackSelection.mo1456a(i5);
                    }
                    renderer.mo3314a(rendererConfiguration, formatArr, this.f16800G.f3984d[i2], this.f16797D, z, this.f16800G.m3546a());
                    MediaClock c = renderer.mo3317c();
                    if (c != null) {
                        if (this.f16819r != null) {
                            throw ExoPlaybackException.m3543a(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.f16819r = c;
                        this.f16818q = renderer;
                        this.f16819r.mo1493a(this.f16817p);
                    }
                    if (i3 != 0) {
                        renderer.mo3319e();
                    }
                }
                i3 = i4;
            }
            i2++;
        }
    }
}
