package com.reddit.datalibrary.frontpage.data.feature.preferences;

import android.content.SharedPreferences.Editor;
import com.reddit.datalibrary.frontpage.data.feature.preferences.RedditPreferenceRepository.Companion;
import com.reddit.frontpage.presentation.geopopular.GeopopularRegionSelectFilter;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.JsonUtil;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$setGeopopularRegionFilter$1<V> implements Callable<Object> {
    final /* synthetic */ RedditPreferenceRepository f10742a;
    final /* synthetic */ GeopopularRegionSelectFilter f10743b;

    RedditPreferenceRepository$setGeopopularRegionFilter$1(RedditPreferenceRepository redditPreferenceRepository, GeopopularRegionSelectFilter geopopularRegionSelectFilter) {
        this.f10742a = redditPreferenceRepository;
        this.f10743b = geopopularRegionSelectFilter;
    }

    public final /* synthetic */ Object call() {
        this.f10742a.f16112c.m9089a().geopopular = this.f10743b.a;
        this.f10742a.f16112c.m9091b();
        this.f10742a.f16111b.startService(IntentUtil.c(this.f10742a.f16111b));
        Editor edit = this.f10742a.f16113d.edit();
        Companion companion = RedditPreferenceRepository.f16105a;
        edit.putString(RedditPreferenceRepository.f16107g, JsonUtil.a(this.f10743b)).apply();
        return Unit.a;
    }
}
