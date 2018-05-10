package com.reddit.frontpage.util;

import android.media.AudioManager.OnAudioFocusChangeListener;
import timber.log.Timber;

final /* synthetic */ class AudioUtil$$Lambda$0 implements OnAudioFocusChangeListener {
    private final AudioUtil f21698a;

    AudioUtil$$Lambda$0(AudioUtil audioUtil) {
        this.f21698a = audioUtil;
    }

    public final void onAudioFocusChange(int i) {
        AudioUtil audioUtil = this.f21698a;
        Timber.b("Broadcasting audio event [%d]", new Object[]{Integer.valueOf(i)});
        audioUtil.f21699a.onNext(Integer.valueOf(i));
    }
}
