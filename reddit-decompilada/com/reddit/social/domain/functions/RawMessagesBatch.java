package com.reddit.social.domain.functions;

import com.sendbird.android.BaseMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/social/domain/functions/RawMessagesBatch;", "", "messages", "", "Lcom/sendbird/android/BaseMessage;", "hasMore", "", "(Ljava/util/List;Z)V", "getHasMore", "()Z", "getMessages", "()Ljava/util/List;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessagesBatch.kt */
public final class RawMessagesBatch {
    public final List<BaseMessage> f22304a;
    public final boolean f22305b;

    public RawMessagesBatch(List<? extends BaseMessage> list, boolean z) {
        Intrinsics.m26847b(list, "messages");
        this.f22304a = list;
        this.f22305b = z;
    }
}
