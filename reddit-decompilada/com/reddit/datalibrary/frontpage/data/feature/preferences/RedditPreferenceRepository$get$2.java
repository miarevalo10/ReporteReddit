package com.reddit.datalibrary.frontpage.data.feature.preferences;

import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$get$2<V> implements Callable<T> {
    final /* synthetic */ RedditPreferenceRepository f10723a;
    final /* synthetic */ String f10724b;
    final /* synthetic */ boolean f10725c = false;

    RedditPreferenceRepository$get$2(RedditPreferenceRepository redditPreferenceRepository, String str) {
        this.f10723a = redditPreferenceRepository;
        this.f10724b = str;
    }

    public final /* synthetic */ Object call() {
        return Boolean.valueOf(this.f10723a.f16113d.getBoolean(this.f10724b, this.f10725c));
    }
}
