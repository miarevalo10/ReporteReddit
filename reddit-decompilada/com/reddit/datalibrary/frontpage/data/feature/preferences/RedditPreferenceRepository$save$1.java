package com.reddit.datalibrary.frontpage.data.feature.preferences;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$save$1<V> implements Callable<Object> {
    final /* synthetic */ RedditPreferenceRepository f10733a;
    final /* synthetic */ String f10734b;
    final /* synthetic */ int f10735c;

    RedditPreferenceRepository$save$1(RedditPreferenceRepository redditPreferenceRepository, String str, int i) {
        this.f10733a = redditPreferenceRepository;
        this.f10734b = str;
        this.f10735c = i;
    }

    public final /* synthetic */ Object call() {
        this.f10733a.f16113d.edit().putInt(this.f10734b, this.f10735c).apply();
        return Unit.a;
    }
}
