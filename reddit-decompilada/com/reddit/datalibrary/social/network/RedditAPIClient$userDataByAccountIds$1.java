package com.reddit.datalibrary.social.network;

import com.reddit.datalibrary.social.model.UserBriefData;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/model/UserBriefData;", "error", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAPIClient.kt */
final class RedditAPIClient$userDataByAccountIds$1<T, R> implements Function<Throwable, Map<String, ? extends UserBriefData>> {
    final /* synthetic */ Set f27395a;

    RedditAPIClient$userDataByAccountIds$1(Set set) {
        this.f27395a = set;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        Intrinsics.m26847b(th, "error");
        StringBuilder stringBuilder = new StringBuilder("Failed to get userData for account Ids ");
        stringBuilder.append(this.f27395a.toString());
        Timber.c(th, stringBuilder.toString(), new Object[0]);
        return MapsKt__MapsKt.m36116a();
    }
}
