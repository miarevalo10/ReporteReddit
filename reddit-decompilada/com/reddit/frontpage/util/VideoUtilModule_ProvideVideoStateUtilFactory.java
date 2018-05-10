package com.reddit.frontpage.util;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class VideoUtilModule_ProvideVideoStateUtilFactory implements Factory<VideoStateUtil> {
    private static final VideoUtilModule_ProvideVideoStateUtilFactory f34492a = new VideoUtilModule_ProvideVideoStateUtilFactory();

    public static VideoUtilModule_ProvideVideoStateUtilFactory m35279a() {
        return f34492a;
    }

    public final /* synthetic */ Object get() {
        return (VideoStateUtil) Preconditions.m26013a(VideoUtilModule.m24058a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
