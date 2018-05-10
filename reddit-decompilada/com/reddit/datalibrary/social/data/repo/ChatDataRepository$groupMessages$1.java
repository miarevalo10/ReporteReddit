package com.reddit.datalibrary.social.data.repo;

import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import com.reddit.social.domain.functions.RawMessagesBatch;
import io.reactivex.functions.Function;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$groupMessages$1<T, R> implements Function<T, R> {
    final /* synthetic */ ChatDataRepository f27350a;
    final /* synthetic */ String f27351b;

    ChatDataRepository$groupMessages$1(ChatDataRepository chatDataRepository, String str) {
        this.f27350a = chatDataRepository;
        this.f27351b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        RawMessagesBatch rawMessagesBatch = (RawMessagesBatch) obj;
        Intrinsics.m26847b(rawMessagesBatch, "it");
        FailedMessagesCacheContract failedMessagesCacheContract = this.f27350a.f27365d;
        if (failedMessagesCacheContract == null) {
            Intrinsics.m26844a("failedMessagesCache");
        }
        return new RawMessagesBatch(CollectionsKt___CollectionsKt.m41423b((Collection) failedMessagesCacheContract.get(this.f27351b), (Iterable) rawMessagesBatch.f22304a), rawMessagesBatch.f22305b);
    }
}
