package com.reddit.frontpage.util;

import dagger.internal.DoubleCheck;
import javax.inject.Provider;

public final class DaggerAudioUtilComponent implements AudioUtilComponent {
    private Provider<AudioUtil> f29378a;

    public static final class Builder {
        private Builder() {
        }
    }

    private DaggerAudioUtilComponent() {
        this.f29378a = DoubleCheck.m31842a(AudioUtilModule_ProvideAudioUtilFactory.m35277a());
    }

    public static Builder m30430b() {
        return new Builder();
    }

    public final AudioUtil mo5025a() {
        return (AudioUtil) this.f29378a.get();
    }
}
