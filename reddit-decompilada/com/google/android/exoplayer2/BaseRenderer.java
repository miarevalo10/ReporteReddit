package com.google.android.exoplayer2;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

public abstract class BaseRenderer implements Renderer, RendererCapabilities {
    protected RendererConfiguration f16762a;
    protected int f16763b;
    protected int f16764c;
    protected SampleStream f16765d;
    protected long f16766e;
    protected boolean f16767f = true;
    protected boolean f16768g;
    private final int f16769h;

    public void mo3312a(int i, Object obj) throws ExoPlaybackException {
    }

    public void mo3914a(long j, boolean z) throws ExoPlaybackException {
    }

    public void mo3915a(boolean z) throws ExoPlaybackException {
    }

    public void mo3921a(Format[] formatArr, long j) throws ExoPlaybackException {
    }

    public final RendererCapabilities mo3316b() {
        return this;
    }

    public MediaClock mo3317c() {
        return null;
    }

    public int mo3327m() throws ExoPlaybackException {
        return 0;
    }

    public void mo3916n() throws ExoPlaybackException {
    }

    public void mo3917o() throws ExoPlaybackException {
    }

    public void mo3918p() {
    }

    public BaseRenderer(int i) {
        this.f16769h = i;
    }

    public final int mo3310a() {
        return this.f16769h;
    }

    public final void mo3311a(int i) {
        this.f16763b = i;
    }

    public final int mo3318d() {
        return this.f16764c;
    }

    public final void mo3314a(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, long j2) throws ExoPlaybackException {
        Assertions.m4186b(this.f16764c == 0);
        this.f16762a = rendererConfiguration;
        this.f16764c = 1;
        mo3915a(z);
        mo3315a(formatArr, sampleStream, j2);
        mo3914a(j, z);
    }

    public final void mo3319e() throws ExoPlaybackException {
        boolean z = true;
        if (this.f16764c != 1) {
            z = false;
        }
        Assertions.m4186b(z);
        this.f16764c = 2;
        mo3916n();
    }

    public final void mo3315a(Format[] formatArr, SampleStream sampleStream, long j) throws ExoPlaybackException {
        Assertions.m4186b(this.f16768g ^ 1);
        this.f16765d = sampleStream;
        this.f16767f = null;
        this.f16766e = j;
        mo3921a(formatArr, j);
    }

    public final SampleStream mo3320f() {
        return this.f16765d;
    }

    public final boolean mo3321g() {
        return this.f16767f;
    }

    public final void mo3322h() {
        this.f16768g = true;
    }

    public final boolean mo3323i() {
        return this.f16768g;
    }

    public final void mo3324j() throws IOException {
        this.f16765d.mo1400b();
    }

    public final void mo3313a(long j) throws ExoPlaybackException {
        this.f16768g = false;
        this.f16767f = false;
        mo3914a(j, false);
    }

    public final void mo3325k() throws ExoPlaybackException {
        Assertions.m4186b(this.f16764c == 2);
        this.f16764c = 1;
        mo3917o();
    }

    public final void mo3326l() {
        boolean z = true;
        if (this.f16764c != 1) {
            z = false;
        }
        Assertions.m4186b(z);
        this.f16764c = 0;
        this.f16765d = null;
        this.f16768g = false;
        mo3918p();
    }

    protected final int m17066a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        z = this.f16765d.mo1397a(formatHolder, decoderInputBuffer, z);
        if (z) {
            if (decoderInputBuffer.m3715c() != null) {
                this.f16767f = true;
                if (this.f16768g != null) {
                    return -4;
                }
                return -3;
            }
            decoderInputBuffer.f12801d += this.f16766e;
        } else if (z) {
            decoderInputBuffer = formatHolder.f4039a;
            if (decoderInputBuffer.f4035w != Long.MAX_VALUE) {
                formatHolder.f4039a = decoderInputBuffer.m3575a(decoderInputBuffer.f4035w + this.f16766e);
            }
        }
        return z;
    }
}
