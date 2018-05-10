package com.google.android.exoplayer2;

import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

public interface Player {

    public interface EventListener {
        void m3594a();

        void m3595a(ExoPlaybackException exoPlaybackException);

        void m3596a(Timeline timeline);

        void m3597a(TrackSelectionArray trackSelectionArray);

        void m3598a(boolean z);

        void m3599a(boolean z, int i);
    }

    int mo3328a();

    void mo3329a(int i);

    void mo3330a(int i, long j);

    void mo3331a(long j);

    void mo3332a(EventListener eventListener);

    void mo3334a(boolean z);

    int mo3336b(int i);

    void mo3337b(EventListener eventListener);

    boolean mo3339b();

    void mo3340c();

    int mo3341d();

    long mo3342e();

    long mo3343f();

    long mo3344g();

    TrackSelectionArray mo3345h();

    Timeline mo3346i();
}
