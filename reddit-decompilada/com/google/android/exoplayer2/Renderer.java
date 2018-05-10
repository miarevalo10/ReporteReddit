package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayer.ExoPlayerComponent;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

public interface Renderer extends ExoPlayerComponent {
    int mo3310a();

    void mo3311a(int i);

    void mo3313a(long j) throws ExoPlaybackException;

    void mo3913a(long j, long j2) throws ExoPlaybackException;

    void mo3314a(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, long j2) throws ExoPlaybackException;

    void mo3315a(Format[] formatArr, SampleStream sampleStream, long j) throws ExoPlaybackException;

    RendererCapabilities mo3316b();

    MediaClock mo3317c();

    int mo3318d();

    void mo3319e() throws ExoPlaybackException;

    SampleStream mo3320f();

    boolean mo3321g();

    void mo3322h();

    boolean mo3323i();

    void mo3324j() throws IOException;

    void mo3325k() throws ExoPlaybackException;

    void mo3326l();

    boolean mo3919q();

    boolean mo3920r();
}
