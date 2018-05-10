package com.reddit.social.domain.functions;

import com.reddit.social.presentation.presentationobjects.HasMessageData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/social/domain/functions/MessagesBatch;", "", "messages", "", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "hasMore", "Lcom/reddit/social/domain/functions/HasMore;", "(Ljava/util/List;Lcom/reddit/social/domain/functions/HasMore;)V", "getHasMore", "()Lcom/reddit/social/domain/functions/HasMore;", "getMessages", "()Ljava/util/List;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessagesBatch.kt */
public final class MessagesBatch {
    public final List<HasMessageData> f22302a;
    public final HasMore f22303b;

    public MessagesBatch(List<? extends HasMessageData> list, HasMore hasMore) {
        Intrinsics.m26847b(list, "messages");
        Intrinsics.m26847b(hasMore, "hasMore");
        this.f22302a = list;
        this.f22303b = hasMore;
    }
}
