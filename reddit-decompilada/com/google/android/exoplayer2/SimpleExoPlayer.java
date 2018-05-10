package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent;
import com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextRenderer.Output;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public class SimpleExoPlayer implements ExoPlayer {
    protected final Renderer[] f16828a;
    public final CopyOnWriteArraySet<Output> f16829b = new CopyOnWriteArraySet();
    public Format f16830c;
    public AudioRendererEventListener f16831d;
    public VideoRendererEventListener f16832e;
    private final ExoPlayer f16833f;
    private final ComponentListener f16834g = new ComponentListener();
    private final CopyOnWriteArraySet<VideoListener> f16835h = new CopyOnWriteArraySet();
    private final CopyOnWriteArraySet<MetadataRenderer.Output> f16836i = new CopyOnWriteArraySet();
    private final int f16837j;
    private final int f16838k;
    private Format f16839l;
    private Surface f16840m;
    private boolean f16841n;
    private int f16842o;
    private SurfaceHolder f16843p;
    private TextureView f16844q;
    private DecoderCounters f16845r;
    private DecoderCounters f16846s;
    private int f16847t;
    private AudioAttributes f16848u;
    private float f16849v;

    public interface VideoListener {
        void m3620a(int i, int i2, float f);

        void m3621b();
    }

    private final class ComponentListener implements Callback, SurfaceTextureListener, AudioRendererEventListener, MetadataRenderer.Output, Output, VideoRendererEventListener {
        final /* synthetic */ SimpleExoPlayer f12768a;

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        private ComponentListener(SimpleExoPlayer simpleExoPlayer) {
            this.f12768a = simpleExoPlayer;
        }

        public final void mo1290a(DecoderCounters decoderCounters) {
            this.f12768a.f16845r = decoderCounters;
            if (this.f12768a.f16832e != null) {
                this.f12768a.f16832e.mo1290a(decoderCounters);
            }
        }

        public final void mo1292a(String str, long j, long j2) {
            if (this.f12768a.f16832e != null) {
                this.f12768a.f16832e.mo1292a(str, j, j2);
            }
        }

        public final void mo1289a(Format format) {
            this.f12768a.f16839l = format;
            if (this.f12768a.f16832e != null) {
                this.f12768a.f16832e.mo1289a(format);
            }
        }

        public final void mo1286a(int i, long j) {
            if (this.f12768a.f16832e != null) {
                this.f12768a.f16832e.mo1286a(i, j);
            }
        }

        public final void mo1285a(int i, int i2, int i3, float f) {
            Iterator it = this.f12768a.f16835h.iterator();
            while (it.hasNext()) {
                ((VideoListener) it.next()).m3620a(i, i2, f);
            }
            if (this.f12768a.f16832e != null) {
                this.f12768a.f16832e.mo1285a(i, i2, i3, f);
            }
        }

        public final void mo1288a(Surface surface) {
            if (this.f12768a.f16840m == surface) {
                Iterator it = this.f12768a.f16835h.iterator();
                while (it.hasNext()) {
                    ((VideoListener) it.next()).m3621b();
                }
            }
            if (this.f12768a.f16832e != null) {
                this.f12768a.f16832e.mo1288a(surface);
            }
        }

        public final void mo1295b(DecoderCounters decoderCounters) {
            if (this.f12768a.f16832e != null) {
                this.f12768a.f16832e.mo1295b(decoderCounters);
            }
            this.f12768a.f16839l = null;
            this.f12768a.f16845r = null;
        }

        public final void mo1297c(DecoderCounters decoderCounters) {
            this.f12768a.f16846s = decoderCounters;
            if (this.f12768a.f16831d != null) {
                this.f12768a.f16831d.mo1297c(decoderCounters);
            }
        }

        public final void mo1284a(int i) {
            this.f12768a.f16847t = i;
            if (this.f12768a.f16831d != null) {
                this.f12768a.f16831d.mo1284a(i);
            }
        }

        public final void mo1296b(String str, long j, long j2) {
            if (this.f12768a.f16831d != null) {
                this.f12768a.f16831d.mo1296b(str, j, j2);
            }
        }

        public final void mo1294b(Format format) {
            this.f12768a.f16830c = format;
            if (this.f12768a.f16831d != null) {
                this.f12768a.f16831d.mo1294b(format);
            }
        }

        public final void mo1287a(int i, long j, long j2) {
            if (this.f12768a.f16831d != null) {
                this.f12768a.f16831d.mo1287a(i, j, j2);
            }
        }

        public final void mo1298d(DecoderCounters decoderCounters) {
            if (this.f12768a.f16831d != null) {
                this.f12768a.f16831d.mo1298d(decoderCounters);
            }
            this.f12768a.f16830c = null;
            this.f12768a.f16846s = null;
            this.f12768a.f16847t = 0;
        }

        public final void mo1293a(List<Cue> list) {
            Iterator it = this.f12768a.f16829b.iterator();
            while (it.hasNext()) {
                ((Output) it.next()).mo1293a(list);
            }
        }

        public final void mo1291a(Metadata metadata) {
            Iterator it = this.f12768a.f16836i.iterator();
            while (it.hasNext()) {
                ((MetadataRenderer.Output) it.next()).mo1291a(metadata);
            }
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f12768a.m17143a(surfaceHolder.getSurface(), false);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f12768a.m17143a(null, false);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.f12768a.m17143a(new Surface(surfaceTexture), true);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f12768a.m17143a(null, true);
            return true;
        }
    }

    protected SimpleExoPlayer(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        this.f16828a = renderersFactory.mo1283a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.f16834g, this.f16834g, this.f16834g, this.f16834g);
        renderersFactory = this.f16828a;
        int length = renderersFactory.length;
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < length) {
            switch (renderersFactory[i].mo3310a()) {
                case 1:
                    i3++;
                    break;
                case 2:
                    i2++;
                    break;
                default:
                    break;
            }
            i++;
        }
        this.f16837j = i2;
        this.f16838k = i3;
        this.f16849v = 1.0f;
        this.f16847t = 0;
        this.f16848u = AudioAttributes.f4096a;
        this.f16842o = 1;
        this.f16833f = new ExoPlayerImpl(this.f16828a, trackSelector, loadControl);
    }

    public final void m17158a(Surface surface) {
        m17152j();
        m17143a(surface, false);
    }

    public final void m17159a(SurfaceView surfaceView) {
        Surface surface;
        surfaceView = surfaceView == null ? null : surfaceView.getHolder();
        m17152j();
        this.f16843p = surfaceView;
        if (surfaceView != null) {
            surfaceView.addCallback(this.f16834g);
            surface = surfaceView.getSurface();
            if (surface != null && surface.isValid()) {
                m17143a(surface, false);
            }
        }
        surface = null;
        m17143a(surface, false);
    }

    public final void m17160a(TextureView textureView) {
        m17152j();
        this.f16844q = textureView;
        Surface surface = null;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != null) {
                Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.f16834g);
            textureView = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            if (textureView != null) {
                surface = new Surface(textureView);
            }
        }
        m17143a(surface, true);
    }

    public final void m17154a(float f) {
        this.f16849v = f;
        ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayerMessage[this.f16838k];
        Renderer[] rendererArr = this.f16828a;
        int i = 0;
        int length = rendererArr.length;
        int i2 = 0;
        while (i < length) {
            ExoPlayerComponent exoPlayerComponent = rendererArr[i];
            if (exoPlayerComponent.mo3310a() == 1) {
                int i3 = i2 + 1;
                exoPlayerMessageArr[i2] = new ExoPlayerMessage(exoPlayerComponent, 2, Float.valueOf(f));
                i2 = i3;
            }
            i++;
        }
        this.f16833f.mo3335a(exoPlayerMessageArr);
    }

    @Deprecated
    public final void m17162a(VideoListener videoListener) {
        this.f16835h.clear();
        if (videoListener != null) {
            this.f16835h.add(videoListener);
        }
    }

    public final void mo3332a(EventListener eventListener) {
        this.f16833f.mo3332a(eventListener);
    }

    public final void mo3337b(EventListener eventListener) {
        this.f16833f.mo3337b(eventListener);
    }

    public final int mo3328a() {
        return this.f16833f.mo3328a();
    }

    public final void mo3333a(MediaSource mediaSource, boolean z, boolean z2) {
        this.f16833f.mo3333a(mediaSource, z, z2);
    }

    public final void mo3334a(boolean z) {
        this.f16833f.mo3334a(z);
    }

    public final boolean mo3339b() {
        return this.f16833f.mo3339b();
    }

    public final void mo3329a(int i) {
        this.f16833f.mo3329a(i);
    }

    public final void mo3331a(long j) {
        this.f16833f.mo3331a(j);
    }

    public final void mo3330a(int i, long j) {
        this.f16833f.mo3330a(i, j);
    }

    public final void mo3340c() {
        this.f16833f.mo3340c();
        m17152j();
        if (this.f16840m != null) {
            if (this.f16841n) {
                this.f16840m.release();
            }
            this.f16840m = null;
        }
    }

    public final void mo3335a(ExoPlayerMessage... exoPlayerMessageArr) {
        this.f16833f.mo3335a(exoPlayerMessageArr);
    }

    public final void mo3338b(ExoPlayerMessage... exoPlayerMessageArr) {
        this.f16833f.mo3338b(exoPlayerMessageArr);
    }

    public final int mo3336b(int i) {
        return this.f16833f.mo3336b(i);
    }

    public final TrackSelectionArray mo3345h() {
        return this.f16833f.mo3345h();
    }

    public final Timeline mo3346i() {
        return this.f16833f.mo3346i();
    }

    public final int mo3341d() {
        return this.f16833f.mo3341d();
    }

    public final long mo3342e() {
        return this.f16833f.mo3342e();
    }

    public final long mo3343f() {
        return this.f16833f.mo3343f();
    }

    public final long mo3344g() {
        return this.f16833f.mo3344g();
    }

    private void m17152j() {
        if (this.f16844q != null) {
            if (this.f16844q.getSurfaceTextureListener() != this.f16834g) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f16844q.setSurfaceTextureListener(null);
            }
            this.f16844q = null;
        }
        if (this.f16843p != null) {
            this.f16843p.removeCallback(this.f16834g);
            this.f16843p = null;
        }
    }

    private void m17143a(Surface surface, boolean z) {
        ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayerMessage[this.f16837j];
        Renderer[] rendererArr = this.f16828a;
        int i = 0;
        int length = rendererArr.length;
        int i2 = 0;
        while (i < length) {
            ExoPlayerComponent exoPlayerComponent = rendererArr[i];
            if (exoPlayerComponent.mo3310a() == 2) {
                int i3 = i2 + 1;
                exoPlayerMessageArr[i2] = new ExoPlayerMessage(exoPlayerComponent, 1, surface);
                i2 = i3;
            }
            i++;
        }
        if (this.f16840m == null || this.f16840m == surface) {
            this.f16833f.mo3335a(exoPlayerMessageArr);
        } else {
            this.f16833f.mo3338b(exoPlayerMessageArr);
            if (this.f16841n) {
                this.f16840m.release();
            }
        }
        this.f16840m = surface;
        this.f16841n = z;
    }
}
