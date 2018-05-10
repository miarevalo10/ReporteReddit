package com.reddit.frontpage.util;

import dagger.internal.DoubleCheck;
import javax.inject.Provider;

public final class DaggerVideoUtilComponent implements VideoUtilComponent {
    private Provider<VideoStateUtil> f29379a;

    public static final class Builder {
        private Builder() {
        }
    }

    private DaggerVideoUtilComponent() {
        this.f29379a = DoubleCheck.m31842a(VideoUtilModule_ProvideVideoStateUtilFactory.m35279a());
    }

    public static Builder m30432a() {
        return new Builder();
    }

    public final VideoStateUtil mo5026b() {
        return (VideoStateUtil) this.f29379a.get();
    }
}
