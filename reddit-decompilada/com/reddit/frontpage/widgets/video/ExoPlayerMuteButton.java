package com.reddit.frontpage.widgets.video;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.reddit.frontpage.C1761R;

public class ExoPlayerMuteButton extends AppCompatImageButton {
    ExoPlayer f34561a;
    private final EventListener f34562b = new C27031(this);

    class C27031 implements EventListener {
        final /* synthetic */ ExoPlayerMuteButton f34560a;

        public final void m35363a() {
        }

        public final void m35364a(ExoPlaybackException exoPlaybackException) {
        }

        public final void m35365a(Timeline timeline) {
        }

        public final void m35367a(boolean z) {
        }

        public final void m35368a(boolean z, int i) {
        }

        C27031(ExoPlayerMuteButton exoPlayerMuteButton) {
            this.f34560a = exoPlayerMuteButton;
        }

        public final void m35366a(TrackSelectionArray trackSelectionArray) {
            int i = 0;
            while (i < trackSelectionArray.a) {
                if (this.f34560a.f34561a.b(i) != 1) {
                    i++;
                } else if (trackSelectionArray.b[i] != null) {
                    this.f34560a.setImageResource(C1761R.drawable.icon_audio_off);
                    return;
                } else {
                    this.f34560a.setImageResource(C1761R.drawable.icon_audio_on);
                    return;
                }
            }
        }
    }

    public ExoPlayerMuteButton(Context context) {
        super(context);
        m35371b();
    }

    public ExoPlayerMuteButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35371b();
    }

    public ExoPlayerMuteButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m35371b();
    }

    public void onDetachedFromWindow() {
        if (this.f34561a != null) {
            this.f34561a.b(this.f34562b);
            this.f34561a = null;
        }
        super.onDetachedFromWindow();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? true : true);
        m35370a();
    }

    public void setPlayer(ExoPlayer exoPlayer) {
        if (exoPlayer != this.f34561a) {
            if (this.f34561a != null) {
                this.f34561a.b(this.f34562b);
            }
            this.f34561a = exoPlayer;
            if (exoPlayer != null) {
                exoPlayer.a(this.f34562b);
            }
            m35370a();
        }
    }

    private void m35370a() {
        if (this.f34561a != null) {
            VideoPlayer a = VideoPlayer.m24337a(this.f34561a);
            if (a != null) {
                setImageResource(a.f22223e ? C1761R.drawable.icon_audio_on : C1761R.drawable.icon_audio_off);
            }
        }
    }

    private void m35371b() {
        setOnClickListener(new ExoPlayerMuteButton$$Lambda$0(this));
    }
}
