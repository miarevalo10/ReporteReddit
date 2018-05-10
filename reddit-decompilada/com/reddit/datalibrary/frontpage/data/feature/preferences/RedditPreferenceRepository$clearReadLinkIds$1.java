package com.reddit.datalibrary.frontpage.data.feature.preferences;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$clearReadLinkIds$1<V> implements Callable<Object> {
    final /* synthetic */ RedditPreferenceRepository f10719a;

    RedditPreferenceRepository$clearReadLinkIds$1(RedditPreferenceRepository redditPreferenceRepository) {
        this.f10719a = redditPreferenceRepository;
    }

    public final /* synthetic */ Object call() {
        this.f10719a.f16113d.edit().putString("readLinkIds", "").apply();
        return Unit.a;
    }
}
