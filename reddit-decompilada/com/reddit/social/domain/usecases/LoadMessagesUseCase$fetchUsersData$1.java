package com.reddit.social.domain.usecases;

import com.reddit.social.domain.functions.RawMessagesBatch;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00070\u00012\u001a\u0010\b\u001a\u0016\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LoadMessagesUseCase.kt */
final class LoadMessagesUseCase$fetchUsersData$1<T, R> implements Function<T, R> {
    final /* synthetic */ RawMessagesBatch f29595a;

    LoadMessagesUseCase$fetchUsersData$1(RawMessagesBatch rawMessagesBatch) {
        this.f29595a = rawMessagesBatch;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Map map = (Map) obj;
        Intrinsics.m26847b(map, "it");
        return TuplesKt.m26780a(this.f29595a, map);
    }
}