package com.reddit.datalibrary.frontpage.data.feature.preferences;

import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$get$1<V> implements Callable<T> {
    final /* synthetic */ RedditPreferenceRepository f10720a;
    final /* synthetic */ String f10721b;
    final /* synthetic */ int f10722c;

    RedditPreferenceRepository$get$1(RedditPreferenceRepository redditPreferenceRepository, String str, int i) {
        this.f10720a = redditPreferenceRepository;
        this.f10721b = str;
        this.f10722c = i;
    }

    public final /* synthetic */ Object call() {
        return Integer.valueOf(this.f10720a.f16113d.getInt(this.f10721b, this.f10722c));
    }
}
