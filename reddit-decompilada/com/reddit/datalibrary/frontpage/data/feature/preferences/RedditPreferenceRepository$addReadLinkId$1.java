package com.reddit.datalibrary.frontpage.data.feature.preferences;

import com.reddit.datalibrary.frontpage.data.feature.preferences.RedditPreferenceRepository.Companion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$addReadLinkId$1<V> implements Callable<Object> {
    final /* synthetic */ RedditPreferenceRepository f10717a;
    final /* synthetic */ String f10718b;

    RedditPreferenceRepository$addReadLinkId$1(RedditPreferenceRepository redditPreferenceRepository, String str) {
        this.f10717a = redditPreferenceRepository;
        this.f10718b = str;
    }

    public final /* synthetic */ Object call() {
        Companion companion = RedditPreferenceRepository.f16105a;
        RedditPreferenceRepository.f16109i.lock();
        try {
            String string = this.f10717a.f16113d.getString("readLinkIds", "");
            Intrinsics.a(string, "originalValue");
            List c = CollectionsKt.c(StringsKt.b(string, new String[]{","}));
            if (!c.contains(this.f10718b)) {
                c.add(this.f10718b);
                Collection arrayList = new ArrayList();
                for (Object next : c) {
                    if ((((CharSequence) ((String) next)).length() > 0 ? 1 : null) != null) {
                        arrayList.add(next);
                    }
                }
                this.f10717a.f16113d.edit().putString("readLinkIds", CollectionsKt.a(CollectionsKt.d((List) arrayList, 250), ",", null, null, 0, null, null, 62)).apply();
            }
            companion = RedditPreferenceRepository.f16105a;
            RedditPreferenceRepository.f16109i.unlock();
            return Unit.a;
        } catch (Throwable th) {
            Companion companion2 = RedditPreferenceRepository.f16105a;
            RedditPreferenceRepository.f16109i.unlock();
        }
    }
}
