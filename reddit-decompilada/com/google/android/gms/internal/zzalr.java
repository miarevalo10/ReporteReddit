package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.gms.ads.internal.zzbs;
import com.instabug.library.ui.custom.MaterialMenuDrawable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@zzzv
@TargetApi(14)
public final class zzalr extends zzamb implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, SurfaceTextureListener {
    private static final Map<Integer, String> f17557c = new HashMap();
    private final zzamq f17558d;
    private final boolean f17559e;
    private int f17560f = 0;
    private int f17561g = 0;
    private MediaPlayer f17562h;
    private Uri f17563i;
    private int f17564j;
    private int f17565k;
    private int f17566l;
    private int f17567m;
    private int f17568n;
    private zzamn f17569o;
    private boolean f17570p;
    private int f17571q;
    private zzama f17572r;

    static {
        if (VERSION.SDK_INT >= 17) {
            f17557c.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
            f17557c.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
            f17557c.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
            f17557c.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
            f17557c.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        f17557c.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        f17557c.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        f17557c.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        f17557c.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        f17557c.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        f17557c.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        f17557c.put(Integer.valueOf(MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION), "MEDIA_INFO_BAD_INTERLEAVING");
        f17557c.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        f17557c.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        if (VERSION.SDK_INT >= 19) {
            f17557c.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            f17557c.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    private final void m17804a(float r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        r0 = r1.f17562h;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r1.f17562h;	 Catch:{ IllegalStateException -> 0x0009 }
        r0.setVolume(r2, r2);	 Catch:{ IllegalStateException -> 0x0009 }
    L_0x0009:
        return;
    L_0x000a:
        r2 = "AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().";
        com.google.android.gms.internal.zzakb.m5371e(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalr.a(float):void");
    }

    private final void m17805a(boolean z) {
        zzagf.m13278a("AdMediaPlayerView release");
        if (this.f17569o != null) {
            this.f17569o.m13380b();
            this.f17569o = null;
        }
        if (this.f17562h != null) {
            this.f17562h.reset();
            this.f17562h.release();
            this.f17562h = null;
            m17806b(0);
            if (z) {
                this.f17561g = 0;
                this.f17561g = 0;
            }
        }
    }

    private final void m17808g() {
        if (this.f17559e && m17809h() && this.f17562h.getCurrentPosition() > 0 && this.f17561g != 3) {
            zzagf.m13278a("AdMediaPlayerView nudging MediaPlayer");
            m17804a(0.0f);
            this.f17562h.start();
            int currentPosition = this.f17562h.getCurrentPosition();
            long a = zzbs.m4492k().mo1632a();
            while (m17809h() && this.f17562h.getCurrentPosition() == currentPosition) {
                if (zzbs.m4492k().mo1632a() - a > 250) {
                    break;
                }
            }
            this.f17562h.pause();
            mo1740e();
        }
    }

    private final boolean m17809h() {
        return (this.f17562h == null || this.f17560f == -1 || this.f17560f == 0 || this.f17560f == 1) ? false : true;
    }

    public final String mo3447a() {
        String str = "MediaPlayer";
        String valueOf = String.valueOf(this.f17570p ? " spherical" : "");
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    public final void mo3449a(int i) {
        StringBuilder stringBuilder = new StringBuilder(34);
        stringBuilder.append("AdMediaPlayerView seek ");
        stringBuilder.append(i);
        zzagf.m13278a(stringBuilder.toString());
        if (m17809h()) {
            this.f17562h.seekTo(i);
            this.f17571q = 0;
            return;
        }
        this.f17571q = i;
    }

    public final void mo3450a(zzama com_google_android_gms_internal_zzama) {
        this.f17572r = com_google_android_gms_internal_zzama;
    }

    public final void mo3453d() {
        zzagf.m13278a("AdMediaPlayerView pause");
        if (m17809h() && this.f17562h.isPlaying()) {
            this.f17562h.pause();
            m17806b(4);
            zzahn.f6379a.post(new zzalz(this));
        }
        this.f17561g = 4;
    }

    public final int getCurrentPosition() {
        return m17809h() ? this.f17562h.getCurrentPosition() : 0;
    }

    public final int getDuration() {
        return m17809h() ? this.f17562h.getDuration() : -1;
    }

    public final int getVideoHeight() {
        return this.f17562h != null ? this.f17562h.getVideoHeight() : 0;
    }

    public final int getVideoWidth() {
        return this.f17562h != null ? this.f17562h.getVideoWidth() : 0;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f17566l = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzagf.m13278a("AdMediaPlayerView completion");
        m17806b(5);
        this.f17561g = 5;
        zzahn.f6379a.post(new zzalt(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f17557c.get(Integer.valueOf(i));
        String str2 = (String) f17557c.get(Integer.valueOf(i2));
        StringBuilder stringBuilder = new StringBuilder((38 + String.valueOf(str).length()) + String.valueOf(str2).length());
        stringBuilder.append("AdMediaPlayerView MediaPlayer error: ");
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(str2);
        zzakb.m5371e(stringBuilder.toString());
        m17806b(-1);
        this.f17561g = -1;
        zzahn.f6379a.post(new zzalu(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = (String) f17557c.get(Integer.valueOf(i));
        String str2 = (String) f17557c.get(Integer.valueOf(i2));
        StringBuilder stringBuilder = new StringBuilder((37 + String.valueOf(str).length()) + String.valueOf(str2).length());
        stringBuilder.append("AdMediaPlayerView MediaPlayer info: ");
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(str2);
        zzagf.m13278a(stringBuilder.toString());
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void onMeasure(int r6, int r7) {
        /*
        r5 = this;
        r0 = r5.f17564j;
        r0 = getDefaultSize(r0, r6);
        r1 = r5.f17565k;
        r1 = getDefaultSize(r1, r7);
        r2 = r5.f17564j;
        if (r2 <= 0) goto L_0x0085;
    L_0x0010:
        r2 = r5.f17565k;
        if (r2 <= 0) goto L_0x0085;
    L_0x0014:
        r2 = r5.f17569o;
        if (r2 != 0) goto L_0x0085;
    L_0x0018:
        r0 = android.view.View.MeasureSpec.getMode(r6);
        r6 = android.view.View.MeasureSpec.getSize(r6);
        r1 = android.view.View.MeasureSpec.getMode(r7);
        r7 = android.view.View.MeasureSpec.getSize(r7);
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r0 != r2) goto L_0x004f;
    L_0x002c:
        if (r1 != r2) goto L_0x004f;
    L_0x002e:
        r0 = r5.f17564j;
        r0 = r0 * r7;
        r1 = r5.f17565k;
        r1 = r1 * r6;
        if (r0 >= r1) goto L_0x003f;
    L_0x0036:
        r6 = r5.f17564j;
        r6 = r6 * r7;
        r0 = r5.f17565k;
        r0 = r6 / r0;
        r6 = r0;
        goto L_0x0087;
    L_0x003f:
        r0 = r5.f17564j;
        r0 = r0 * r7;
        r1 = r5.f17565k;
        r1 = r1 * r6;
        if (r0 <= r1) goto L_0x0087;
    L_0x0047:
        r7 = r5.f17565k;
        r7 = r7 * r6;
        r0 = r5.f17564j;
        r1 = r7 / r0;
        goto L_0x0086;
    L_0x004f:
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r0 != r2) goto L_0x0060;
    L_0x0053:
        r0 = r5.f17565k;
        r0 = r0 * r6;
        r2 = r5.f17564j;
        r0 = r0 / r2;
        if (r1 != r3) goto L_0x005e;
    L_0x005b:
        if (r0 <= r7) goto L_0x005e;
    L_0x005d:
        goto L_0x0087;
    L_0x005e:
        r7 = r0;
        goto L_0x0087;
    L_0x0060:
        if (r1 != r2) goto L_0x006f;
    L_0x0062:
        r1 = r5.f17564j;
        r1 = r1 * r7;
        r2 = r5.f17565k;
        r1 = r1 / r2;
        if (r0 != r3) goto L_0x006d;
    L_0x006a:
        if (r1 <= r6) goto L_0x006d;
    L_0x006c:
        goto L_0x0087;
    L_0x006d:
        r6 = r1;
        goto L_0x0087;
    L_0x006f:
        r2 = r5.f17564j;
        r4 = r5.f17565k;
        if (r1 != r3) goto L_0x007e;
    L_0x0075:
        if (r4 <= r7) goto L_0x007e;
    L_0x0077:
        r1 = r5.f17564j;
        r1 = r1 * r7;
        r2 = r5.f17565k;
        r1 = r1 / r2;
        goto L_0x0080;
    L_0x007e:
        r1 = r2;
        r7 = r4;
    L_0x0080:
        if (r0 != r3) goto L_0x006d;
    L_0x0082:
        if (r1 <= r6) goto L_0x006d;
    L_0x0084:
        goto L_0x0047;
    L_0x0085:
        r6 = r0;
    L_0x0086:
        r7 = r1;
    L_0x0087:
        r5.setMeasuredDimension(r6, r7);
        r0 = r5.f17569o;
        if (r0 == 0) goto L_0x0093;
    L_0x008e:
        r0 = r5.f17569o;
        r0.m13379a(r6, r7);
    L_0x0093:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 != r1) goto L_0x00b0;
    L_0x0099:
        r0 = r5.f17567m;
        if (r0 <= 0) goto L_0x00a1;
    L_0x009d:
        r0 = r5.f17567m;
        if (r0 != r6) goto L_0x00a9;
    L_0x00a1:
        r0 = r5.f17568n;
        if (r0 <= 0) goto L_0x00ac;
    L_0x00a5:
        r0 = r5.f17568n;
        if (r0 == r7) goto L_0x00ac;
    L_0x00a9:
        r5.m17808g();
    L_0x00ac:
        r5.f17567m = r6;
        r5.f17568n = r7;
    L_0x00b0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalr.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzagf.m13278a("AdMediaPlayerView surface created");
        m17807f();
        zzahn.f6379a.post(new zzalv(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzagf.m13278a("AdMediaPlayerView surface destroyed");
        if (this.f17562h != null && this.f17571q == 0) {
            this.f17571q = this.f17562h.getCurrentPosition();
        }
        if (this.f17569o != null) {
            this.f17569o.m13380b();
        }
        zzahn.f6379a.post(new zzalx(this));
        m17805a(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzagf.m13278a("AdMediaPlayerView surface changed");
        Object obj = null;
        Object obj2 = this.f17561g == 3 ? 1 : null;
        if (this.f17564j == i && this.f17565k == i2) {
            obj = 1;
        }
        if (!(this.f17562h == null || obj2 == null || r0 == null)) {
            if (this.f17571q != 0) {
                mo3449a(this.f17571q);
            }
            mo3452c();
        }
        if (this.f17569o != null) {
            this.f17569o.m13379a(i, i2);
        }
        zzahn.f6379a.post(new zzalw(this, i, i2));
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(57);
        stringBuilder.append("AdMediaPlayerView size changed: ");
        stringBuilder.append(i);
        stringBuilder.append(" x ");
        stringBuilder.append(i2);
        zzagf.m13278a(stringBuilder.toString());
        this.f17564j = mediaPlayer.getVideoWidth();
        this.f17565k = mediaPlayer.getVideoHeight();
        if (this.f17564j != 0 && this.f17565k != 0) {
            requestLayout();
        }
    }

    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzil a = zzil.m18751a(parse);
        if (a != null) {
            parse = Uri.parse(a.f18114a);
        }
        this.f17563i = parse;
        this.f17571q = 0;
        m17807f();
        requestLayout();
        invalidate();
    }

    public final String toString() {
        String name = getClass().getName();
        String toHexString = Integer.toHexString(hashCode());
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(name).length()) + String.valueOf(toHexString).length());
        stringBuilder.append(name);
        stringBuilder.append("@");
        stringBuilder.append(toHexString);
        return stringBuilder.toString();
    }

    public zzalr(Context context, boolean z, boolean z2, zzamq com_google_android_gms_internal_zzamq) {
        super(context);
        setSurfaceTextureListener(this);
        this.f17558d = com_google_android_gms_internal_zzamq;
        this.f17570p = z;
        this.f17559e = z2;
        context = this.f17558d;
        zznn.m6499a(context.f6568e, context.f6567d, new String[]{"vpc2"});
        context.f6572i = true;
        if (context.f6568e) {
            context.f6568e.m6504a("vpn", mo3447a());
        }
        context.f6577n = this;
    }

    public final void mo3451b() {
        zzagf.m13278a("AdMediaPlayerView stop");
        int i = 0;
        if (this.f17562h != null) {
            this.f17562h.stop();
            this.f17562h.release();
            this.f17562h = null;
            m17806b(0);
            this.f17561g = 0;
        }
        zzamq com_google_android_gms_internal_zzamq = this.f17558d;
        if (((Boolean) zzkb.m6350f().m6488a(zznh.f7907p)).booleanValue() && !com_google_android_gms_internal_zzamq.f6578o) {
            String valueOf;
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", com_google_android_gms_internal_zzamq.f6565b);
            bundle.putString("player", com_google_android_gms_internal_zzamq.f6577n.mo3447a());
            for (zzait com_google_android_gms_internal_zzait : com_google_android_gms_internal_zzamq.f6569f.m5288a()) {
                valueOf = String.valueOf("fps_c_");
                String valueOf2 = String.valueOf(com_google_android_gms_internal_zzait.f6427a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(com_google_android_gms_internal_zzait.f6429c));
                valueOf = String.valueOf("fps_p_");
                valueOf2 = String.valueOf(com_google_android_gms_internal_zzait.f6427a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Double.toString(com_google_android_gms_internal_zzait.f6428b));
            }
            while (i < com_google_android_gms_internal_zzamq.f6570g.length) {
                String str = com_google_android_gms_internal_zzamq.f6571h[i];
                if (str != null) {
                    String str2 = "fh_";
                    valueOf = String.valueOf(Long.valueOf(com_google_android_gms_internal_zzamq.f6570g[i]));
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + String.valueOf(valueOf).length());
                    stringBuilder.append(str2);
                    stringBuilder.append(valueOf);
                    bundle.putString(stringBuilder.toString(), str);
                }
                i++;
            }
            zzbs.m4486e();
            zzahn.m5169a(com_google_android_gms_internal_zzamq.f6564a, com_google_android_gms_internal_zzamq.f6566c.f17551a, "gmob-apps", bundle, true);
            com_google_android_gms_internal_zzamq.f6578o = true;
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzagf.m13278a("AdMediaPlayerView prepared");
        m17806b(2);
        zzamq com_google_android_gms_internal_zzamq = this.f17558d;
        if (com_google_android_gms_internal_zzamq.f6572i) {
            if (!com_google_android_gms_internal_zzamq.f6573j) {
                zznn.m6499a(com_google_android_gms_internal_zzamq.f6568e, com_google_android_gms_internal_zzamq.f6567d, "vfr2");
                com_google_android_gms_internal_zzamq.f6573j = true;
            }
        }
        zzahn.f6379a.post(new zzals(this));
        this.f17564j = mediaPlayer.getVideoWidth();
        this.f17565k = mediaPlayer.getVideoHeight();
        if (this.f17571q != null) {
            mo3449a(this.f17571q);
        }
        m17808g();
        mediaPlayer = this.f17564j;
        int i = this.f17565k;
        StringBuilder stringBuilder = new StringBuilder(62);
        stringBuilder.append("AdMediaPlayerView stream dimensions: ");
        stringBuilder.append(mediaPlayer);
        stringBuilder.append(" x ");
        stringBuilder.append(i);
        zzakb.m5370d(stringBuilder.toString());
        if (this.f17561g == 3) {
            mo3452c();
        }
        mo1740e();
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        zzami com_google_android_gms_internal_zzami;
        zzama com_google_android_gms_internal_zzama;
        zzamq com_google_android_gms_internal_zzamq = this.f17558d;
        if (com_google_android_gms_internal_zzamq.f6574k && !com_google_android_gms_internal_zzamq.f6575l) {
            zznn.m6499a(com_google_android_gms_internal_zzamq.f6568e, com_google_android_gms_internal_zzamq.f6567d, "vff2");
            com_google_android_gms_internal_zzamq.f6575l = true;
        }
        long c = zzbs.m4492k().mo1634c();
        if (com_google_android_gms_internal_zzamq.f6576m && com_google_android_gms_internal_zzamq.f6579p && com_google_android_gms_internal_zzamq.f6580q != -1) {
            double toNanos = ((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (c - com_google_android_gms_internal_zzamq.f6580q));
            zzair com_google_android_gms_internal_zzair = com_google_android_gms_internal_zzamq.f6569f;
            com_google_android_gms_internal_zzair.f6425d++;
            int i = 0;
            while (i < com_google_android_gms_internal_zzair.f6423b.length) {
                if (com_google_android_gms_internal_zzair.f6423b[i] <= toNanos && toNanos < com_google_android_gms_internal_zzair.f6422a[i]) {
                    int[] iArr = com_google_android_gms_internal_zzair.f6424c;
                    iArr[i] = iArr[i] + 1;
                }
                if (toNanos < com_google_android_gms_internal_zzair.f6423b[i]) {
                    break;
                }
                i++;
            }
        }
        com_google_android_gms_internal_zzamq.f6579p = com_google_android_gms_internal_zzamq.f6576m;
        com_google_android_gms_internal_zzamq.f6580q = c;
        c = ((Long) zzkb.m6350f().m6488a(zznh.f7909r)).longValue();
        long currentPosition = (long) getCurrentPosition();
        int i2 = 0;
        while (i2 < com_google_android_gms_internal_zzamq.f6571h.length) {
            long timestamp;
            if (com_google_android_gms_internal_zzamq.f6571h[i2] != null || c <= Math.abs(currentPosition - com_google_android_gms_internal_zzamq.f6570g[i2])) {
                i2++;
            } else {
                String[] strArr = com_google_android_gms_internal_zzamq.f6571h;
                int i3 = 8;
                Bitmap bitmap = getBitmap(8, 8);
                long j = 63;
                long j2 = 0;
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = 0;
                    long j3 = j;
                    while (i5 < i3) {
                        int pixel = bitmap.getPixel(i5, i4);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j3);
                        i5++;
                        j3--;
                        i3 = 8;
                    }
                    i4++;
                    j = j3;
                    i3 = 8;
                }
                strArr[i2] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                com_google_android_gms_internal_zzami = r0.a;
                com_google_android_gms_internal_zzama = r0.f17572r;
                if (com_google_android_gms_internal_zzama != null) {
                    timestamp = surfaceTexture.getTimestamp();
                    if (!com_google_android_gms_internal_zzami.f6547c || Math.abs(timestamp - com_google_android_gms_internal_zzami.f6546b) >= com_google_android_gms_internal_zzami.f6545a) {
                        com_google_android_gms_internal_zzami.f6547c = false;
                        com_google_android_gms_internal_zzami.f6546b = timestamp;
                        zzahn.f6379a.post(new zzamj(com_google_android_gms_internal_zzama));
                    }
                    return;
                }
            }
        }
        com_google_android_gms_internal_zzami = r0.a;
        com_google_android_gms_internal_zzama = r0.f17572r;
        if (com_google_android_gms_internal_zzama != null) {
            timestamp = surfaceTexture.getTimestamp();
            if (com_google_android_gms_internal_zzami.f6547c) {
            }
            com_google_android_gms_internal_zzami.f6547c = false;
            com_google_android_gms_internal_zzami.f6546b = timestamp;
            zzahn.f6379a.post(new zzamj(com_google_android_gms_internal_zzama));
        }
    }

    private final void m17807f() {
        zzagf.m13278a("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.f17563i != null && surfaceTexture != null) {
            m17805a(false);
            try {
                zzbs.m4501t();
                this.f17562h = new MediaPlayer();
                this.f17562h.setOnBufferingUpdateListener(this);
                this.f17562h.setOnCompletionListener(this);
                this.f17562h.setOnErrorListener(this);
                this.f17562h.setOnInfoListener(this);
                this.f17562h.setOnPreparedListener(this);
                this.f17562h.setOnVideoSizeChangedListener(this);
                this.f17566l = 0;
                if (this.f17570p) {
                    this.f17569o = new zzamn(getContext());
                    zzamn com_google_android_gms_internal_zzamn = this.f17569o;
                    int width = getWidth();
                    int height = getHeight();
                    com_google_android_gms_internal_zzamn.f14172d = width;
                    com_google_android_gms_internal_zzamn.f14171c = height;
                    com_google_android_gms_internal_zzamn.f14173e = surfaceTexture;
                    this.f17569o.start();
                    SurfaceTexture c = this.f17569o.m13381c();
                    if (c != null) {
                        surfaceTexture = c;
                    } else {
                        this.f17569o.m13380b();
                        this.f17569o = null;
                    }
                }
                this.f17562h.setDataSource(getContext(), this.f17563i);
                zzbs.m4502u();
                this.f17562h.setSurface(new Surface(surfaceTexture));
                this.f17562h.setAudioStreamType(3);
                this.f17562h.setScreenOnWhilePlaying(true);
                this.f17562h.prepareAsync();
                m17806b(1);
            } catch (Throwable e) {
                String valueOf = String.valueOf(this.f17563i);
                StringBuilder stringBuilder = new StringBuilder(36 + String.valueOf(valueOf).length());
                stringBuilder.append("Failed to initialize MediaPlayer at ");
                stringBuilder.append(valueOf);
                zzakb.m5369c(stringBuilder.toString(), e);
                onError(this.f17562h, 1, 0);
            }
        }
    }

    public final void mo3452c() {
        zzagf.m13278a("AdMediaPlayerView play");
        if (m17809h()) {
            this.f17562h.start();
            m17806b(3);
            this.a.f6547c = true;
            zzahn.f6379a.post(new zzaly(this));
        }
        this.f17561g = 3;
    }

    public final void mo3448a(float f, float f2) {
        if (this.f17569o != null) {
            float f3;
            zzamn com_google_android_gms_internal_zzamn = this.f17569o;
            if (com_google_android_gms_internal_zzamn.f14172d > com_google_android_gms_internal_zzamn.f14171c) {
                f = (f * 1.7453293f) / ((float) com_google_android_gms_internal_zzamn.f14172d);
                f3 = 1.7453293f * f2;
                f2 = com_google_android_gms_internal_zzamn.f14172d;
            } else {
                f = (f * 1.7453293f) / ((float) com_google_android_gms_internal_zzamn.f14171c);
                f3 = 1.7453293f * f2;
                f2 = com_google_android_gms_internal_zzamn.f14171c;
            }
            f3 /= (float) f2;
            com_google_android_gms_internal_zzamn.f14169a -= f;
            com_google_android_gms_internal_zzamn.f14170b -= f3;
            if (com_google_android_gms_internal_zzamn.f14170b < -1.5707964f) {
                com_google_android_gms_internal_zzamn.f14170b = -1.5707964f;
            }
            if (com_google_android_gms_internal_zzamn.f14170b > 1.5707964f) {
                com_google_android_gms_internal_zzamn.f14170b = 1.5707964f;
            }
        }
    }

    public final void mo1740e() {
        zzams com_google_android_gms_internal_zzams = this.b;
        float f = com_google_android_gms_internal_zzams.f6585c ? 0.0f : com_google_android_gms_internal_zzams.f6586d;
        if (!com_google_android_gms_internal_zzams.f6583a) {
            f = 0.0f;
        }
        m17804a(f);
    }

    private final void m17806b(int i) {
        zzams com_google_android_gms_internal_zzams;
        if (i == 3) {
            zzamq com_google_android_gms_internal_zzamq = this.f17558d;
            com_google_android_gms_internal_zzamq.f6576m = true;
            if (com_google_android_gms_internal_zzamq.f6573j && !com_google_android_gms_internal_zzamq.f6574k) {
                zznn.m6499a(com_google_android_gms_internal_zzamq.f6568e, com_google_android_gms_internal_zzamq.f6567d, "vfp2");
                com_google_android_gms_internal_zzamq.f6574k = true;
            }
            com_google_android_gms_internal_zzams = this.b;
            com_google_android_gms_internal_zzams.f6584b = true;
            com_google_android_gms_internal_zzams.m5426a();
        } else if (this.f17560f == 3) {
            this.f17558d.f6576m = false;
            com_google_android_gms_internal_zzams = this.b;
            com_google_android_gms_internal_zzams.f6584b = false;
            com_google_android_gms_internal_zzams.m5426a();
        }
        this.f17560f = i;
    }
}
