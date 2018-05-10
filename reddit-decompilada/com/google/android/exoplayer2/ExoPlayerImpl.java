package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage;
import com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfo;
import com.google.android.exoplayer2.ExoPlayerImplInternal.SourceInfo;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class ExoPlayerImpl implements ExoPlayer {
    final TrackSelector f16770a;
    final CopyOnWriteArraySet<EventListener> f16771b;
    boolean f16772c;
    boolean f16773d;
    int f16774e;
    int f16775f;
    int f16776g;
    boolean f16777h;
    Timeline f16778i;
    Object f16779j;
    TrackGroupArray f16780k;
    TrackSelectionArray f16781l;
    PlaybackParameters f16782m;
    PlaybackInfo f16783n;
    int f16784o;
    int f16785p;
    long f16786q;
    private final Renderer[] f16787r;
    private final TrackSelectionArray f16788s;
    private final Handler f16789t;
    private final ExoPlayerImplInternal f16790u;
    private final Window f16791v;
    private final Period f16792w;
    private int f16793x;

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl) {
        StringBuilder stringBuilder = new StringBuilder("Init ");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" [ExoPlayerLib/2.5.3] [");
        stringBuilder.append(Util.f5287e);
        stringBuilder.append("]");
        Log.i("ExoPlayerImpl", stringBuilder.toString());
        Assertions.m4186b(rendererArr.length > 0);
        this.f16787r = (Renderer[]) Assertions.m4182a((Object) rendererArr);
        this.f16770a = (TrackSelector) Assertions.m4182a((Object) trackSelector);
        this.f16773d = false;
        this.f16793x = 0;
        this.f16774e = 1;
        this.f16771b = new CopyOnWriteArraySet();
        this.f16788s = new TrackSelectionArray(new TrackSelection[rendererArr.length]);
        this.f16778i = Timeline.f4081a;
        this.f16791v = new Window();
        this.f16792w = new Period();
        this.f16780k = TrackGroupArray.f4785a;
        this.f16781l = this.f16788s;
        this.f16782m = PlaybackParameters.f4054a;
        this.f16789t = new Handler(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) {
            final /* synthetic */ ExoPlayerImpl f3980a;

            public void handleMessage(Message message) {
                ExoPlayerImpl exoPlayerImpl = this.f3980a;
                boolean z = true;
                switch (message.what) {
                    case 0:
                        exoPlayerImpl.f16776g -= 1;
                        return;
                    case 1:
                        exoPlayerImpl.f16774e = message.arg1;
                        message = exoPlayerImpl.f16771b.iterator();
                        while (message.hasNext()) {
                            ((EventListener) message.next()).m3599a(exoPlayerImpl.f16773d, exoPlayerImpl.f16774e);
                        }
                        return;
                    case 2:
                        if (message.arg1 == null) {
                            z = false;
                        }
                        exoPlayerImpl.f16777h = z;
                        message = exoPlayerImpl.f16771b.iterator();
                        while (message.hasNext()) {
                            ((EventListener) message.next()).m3598a(exoPlayerImpl.f16777h);
                        }
                        return;
                    case 3:
                        if (exoPlayerImpl.f16776g == 0) {
                            TrackSelectorResult trackSelectorResult = (TrackSelectorResult) message.obj;
                            exoPlayerImpl.f16772c = true;
                            exoPlayerImpl.f16780k = trackSelectorResult.f5151a;
                            exoPlayerImpl.f16781l = trackSelectorResult.f5152b;
                            exoPlayerImpl.f16770a.mo1465a(trackSelectorResult.f5153c);
                            message = exoPlayerImpl.f16771b.iterator();
                            while (message.hasNext()) {
                                ((EventListener) message.next()).m3597a(exoPlayerImpl.f16781l);
                            }
                            return;
                        }
                        break;
                    case 4:
                        int i = exoPlayerImpl.f16775f - 1;
                        exoPlayerImpl.f16775f = i;
                        if (i == 0) {
                            exoPlayerImpl.f16783n = (PlaybackInfo) message.obj;
                            if (exoPlayerImpl.f16778i.m3636a()) {
                                exoPlayerImpl.f16785p = 0;
                                exoPlayerImpl.f16784o = 0;
                                exoPlayerImpl.f16786q = 0;
                            }
                            if (message.arg1 != null) {
                                message = exoPlayerImpl.f16771b.iterator();
                                while (message.hasNext()) {
                                    ((EventListener) message.next()).m3594a();
                                }
                                return;
                            }
                        }
                        break;
                    case 5:
                        if (exoPlayerImpl.f16775f == 0) {
                            exoPlayerImpl.f16783n = (PlaybackInfo) message.obj;
                            message = exoPlayerImpl.f16771b.iterator();
                            while (message.hasNext()) {
                                ((EventListener) message.next()).m3594a();
                            }
                            return;
                        }
                        break;
                    case 6:
                        SourceInfo sourceInfo = (SourceInfo) message.obj;
                        exoPlayerImpl.f16775f -= sourceInfo.f4009d;
                        if (exoPlayerImpl.f16776g == 0) {
                            exoPlayerImpl.f16778i = sourceInfo.f4006a;
                            exoPlayerImpl.f16779j = sourceInfo.f4007b;
                            exoPlayerImpl.f16783n = sourceInfo.f4008c;
                            if (exoPlayerImpl.f16775f == null && exoPlayerImpl.f16778i.m3636a() != null) {
                                exoPlayerImpl.f16785p = 0;
                                exoPlayerImpl.f16784o = 0;
                                exoPlayerImpl.f16786q = 0;
                            }
                            message = exoPlayerImpl.f16771b.iterator();
                            while (message.hasNext()) {
                                ((EventListener) message.next()).m3596a(exoPlayerImpl.f16778i);
                            }
                            return;
                        }
                        break;
                    case 7:
                        PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
                        if (!exoPlayerImpl.f16782m.equals(playbackParameters)) {
                            exoPlayerImpl.f16782m = playbackParameters;
                            message = exoPlayerImpl.f16771b.iterator();
                            while (message.hasNext()) {
                                message.next();
                            }
                            return;
                        }
                        break;
                    case 8:
                        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                        Iterator it = exoPlayerImpl.f16771b.iterator();
                        while (it.hasNext()) {
                            ((EventListener) it.next()).m3595a(exoPlaybackException);
                        }
                        return;
                    default:
                        throw new IllegalStateException();
                }
            }
        };
        this.f16783n = new PlaybackInfo(0);
        this.f16790u = new ExoPlayerImplInternal(rendererArr, trackSelector, loadControl, this.f16773d, this.f16793x, this.f16789t, this.f16783n, this);
    }

    public final void mo3332a(EventListener eventListener) {
        this.f16771b.add(eventListener);
    }

    public final void mo3337b(EventListener eventListener) {
        this.f16771b.remove(eventListener);
    }

    public final int mo3328a() {
        return this.f16774e;
    }

    public final void mo3333a(MediaSource mediaSource, boolean z, boolean z2) {
        if (z2) {
            if (!this.f16778i.m3636a() || this.f16779j) {
                this.f16778i = Timeline.f4081a;
                this.f16779j = null;
                z2 = this.f16771b.iterator();
                while (z2.hasNext()) {
                    ((EventListener) z2.next()).m3596a(this.f16778i);
                }
            }
            if (this.f16772c) {
                this.f16772c = false;
                this.f16780k = TrackGroupArray.f4785a;
                this.f16781l = this.f16788s;
                this.f16770a.mo1465a(null);
                z2 = this.f16771b.iterator();
                while (z2.hasNext()) {
                    ((EventListener) z2.next()).m3597a(this.f16781l);
                }
            }
        }
        this.f16776g++;
        this.f16790u.f16802a.obtainMessage(0, z, 0, mediaSource).sendToTarget();
    }

    public final void mo3334a(boolean z) {
        if (this.f16773d != z) {
            this.f16773d = z;
            this.f16790u.f16802a.obtainMessage(1, z, 0).sendToTarget();
            Iterator it = this.f16771b.iterator();
            while (it.hasNext()) {
                ((EventListener) it.next()).m3599a(z, this.f16774e);
            }
        }
    }

    public final boolean mo3339b() {
        return this.f16773d;
    }

    public final void mo3329a(int i) {
        if (this.f16793x != i) {
            this.f16793x = i;
            this.f16790u.f16802a.obtainMessage(12, i, 0).sendToTarget();
            i = this.f16771b.iterator();
            while (i.hasNext()) {
                i.next();
            }
        }
    }

    public final void mo3331a(long j) {
        mo3330a(mo3341d(), j);
    }

    public final void mo3330a(int i, long j) {
        if (i >= 0) {
            if (this.f16778i.m3636a() || i < this.f16778i.mo1302b()) {
                this.f16775f++;
                this.f16784o = i;
                if (this.f16778i.m3636a()) {
                    this.f16785p = 0;
                } else {
                    long j2;
                    this.f16778i.mo1301a(i, this.f16791v, 0);
                    if (j == -9223372036854775807L) {
                        j2 = this.f16791v.f4078h;
                    } else {
                        j2 = C0377C.m3540b(j);
                    }
                    int i2 = this.f16791v.f4076f;
                    long j3 = this.f16791v.f4080j + j2;
                    j2 = this.f16778i.mo1300a(i2, this.f16792w, false).f4063d;
                    while (j2 != -9223372036854775807L && j3 >= j2 && i2 < this.f16791v.f4077g) {
                        j3 -= j2;
                        i2++;
                        j2 = this.f16778i.mo1300a(i2, this.f16792w, false).f4063d;
                    }
                    this.f16785p = i2;
                }
                if (j == -9223372036854775807L) {
                    this.f16786q = 0;
                    this.f16790u.m17134a(this.f16778i, i, -9223372036854775807L);
                    return;
                }
                this.f16786q = j;
                this.f16790u.m17134a(this.f16778i, i, C0377C.m3540b(j));
                i = this.f16771b.iterator();
                while (i.hasNext() != null) {
                    ((EventListener) i.next()).m3594a();
                }
                return;
            }
        }
        throw new IllegalSeekPositionException(this.f16778i, i, j);
    }

    public final void mo3340c() {
        StringBuilder stringBuilder = new StringBuilder("Release ");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" [ExoPlayerLib/2.5.3] [");
        stringBuilder.append(Util.f5287e);
        stringBuilder.append("] [");
        stringBuilder.append(ExoPlayerLibraryInfo.m3552a());
        stringBuilder.append("]");
        Log.i("ExoPlayerImpl", stringBuilder.toString());
        this.f16790u.m17133a();
        this.f16789t.removeCallbacksAndMessages(null);
    }

    public final void mo3335a(ExoPlayerMessage... exoPlayerMessageArr) {
        ExoPlayerImplInternal exoPlayerImplInternal = this.f16790u;
        if (exoPlayerImplInternal.f16803b) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        exoPlayerImplInternal.f16804c++;
        exoPlayerImplInternal.f16802a.obtainMessage(11, exoPlayerMessageArr).sendToTarget();
    }

    public final void mo3338b(ExoPlayerMessage... exoPlayerMessageArr) {
        this.f16790u.m17138a(exoPlayerMessageArr);
    }

    public final int mo3341d() {
        if (!this.f16778i.m3636a()) {
            if (this.f16775f <= 0) {
                return this.f16778i.mo1300a(this.f16783n.f3998a.f4752b, this.f16792w, false).f4062c;
            }
        }
        return this.f16784o;
    }

    public final long mo3342e() {
        if (this.f16778i.m3636a()) {
            return -9223372036854775807L;
        }
        boolean z = this.f16775f == 0 && this.f16783n.f3998a.m3937a();
        if (!z) {
            return C0377C.m3539a(this.f16778i.mo1301a(mo3341d(), this.f16791v, 0).f4079i);
        }
        MediaPeriodId mediaPeriodId = this.f16783n.f3998a;
        this.f16778i.mo1300a(mediaPeriodId.f4752b, this.f16792w, false);
        return C0377C.m3539a(this.f16792w.m3628b(mediaPeriodId.f4753c, mediaPeriodId.f4754d));
    }

    public final long mo3343f() {
        if (!this.f16778i.m3636a()) {
            if (this.f16775f <= 0) {
                return m17090b(this.f16783n.f4001d);
            }
        }
        return this.f16786q;
    }

    public final long mo3344g() {
        if (!this.f16778i.m3636a()) {
            if (this.f16775f <= 0) {
                return m17090b(this.f16783n.f4002e);
            }
        }
        return this.f16786q;
    }

    public final int mo3336b(int i) {
        return this.f16787r[i].mo3310a();
    }

    public final TrackSelectionArray mo3345h() {
        return this.f16781l;
    }

    public final Timeline mo3346i() {
        return this.f16778i;
    }

    private long m17090b(long j) {
        j = C0377C.m3539a(j);
        if (this.f16783n.f3998a.m3937a()) {
            return j;
        }
        this.f16778i.mo1300a(this.f16783n.f3998a.f4752b, this.f16792w, false);
        return j + C0377C.m3539a(this.f16792w.f4064e);
    }
}
