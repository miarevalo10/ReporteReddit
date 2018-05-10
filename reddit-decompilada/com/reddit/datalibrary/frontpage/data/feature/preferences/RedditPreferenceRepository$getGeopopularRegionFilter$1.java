package com.reddit.datalibrary.frontpage.data.feature.preferences;

import android.content.SharedPreferences;
import com.reddit.datalibrary.frontpage.data.feature.preferences.RedditPreferenceRepository.Companion;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.util.JsonUtil;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/geopopular/GeopopularRegionSelectFilter;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$getGeopopularRegionFilter$1<V> implements Callable<T> {
    final /* synthetic */ RedditPreferenceRepository f10728a;

    RedditPreferenceRepository$getGeopopularRegionFilter$1(RedditPreferenceRepository redditPreferenceRepository) {
        this.f10728a = redditPreferenceRepository;
    }

    public final /* synthetic */ Object call() {
        SharedPreferences a = this.f10728a.f16113d;
        Companion companion = RedditPreferenceRepository.f16105a;
        String a2 = RedditPreferenceRepository.f16107g;
        Companion companion2 = RedditPreferenceRepository.f16105a;
        String string = a.getString(a2, RedditPreferenceRepository.f16108h);
        Intrinsics.a(string, "filter");
        if ((((CharSequence) string).length() == 0 ? 1 : null) == null) {
            return (GeopopularRegionSelectFilter) JsonUtil.a(string, GeopopularRegionSelectFilter.class);
        }
        GeopopularRegionSelectFilter.Companion companion3 = GeopopularRegionSelectFilter.c;
        return GeopopularRegionSelectFilter.Companion.a();
    }
}
