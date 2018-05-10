package com.reddit.frontpage.util;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AudioUtilModule_ProvideAudioUtilFactory implements Factory<AudioUtil> {
    private static final AudioUtilModule_ProvideAudioUtilFactory f34490a = new AudioUtilModule_ProvideAudioUtilFactory();

    public static AudioUtilModule_ProvideAudioUtilFactory m35277a() {
        return f34490a;
    }

    public final /* synthetic */ Object get() {
        return (AudioUtil) Preconditions.m26013a(AudioUtilModule.m23655a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
