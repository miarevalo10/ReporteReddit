package com.reddit.social.analytics;

import com.reddit.social.domain.functions.MessagesBatch;
import com.sendbird.android.GroupChannel;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/reddit/social/domain/functions/MessagesBatch;", "Lcom/sendbird/android/GroupChannel;", "batch", "groupChannel", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatAnalytics.kt */
final class ChatAnalytics$invitation$combine$1<T1, T2, R> implements BiFunction<MessagesBatch, GroupChannel, Pair<? extends MessagesBatch, ? extends GroupChannel>> {
    public static final ChatAnalytics$invitation$combine$1 f29568a = new ChatAnalytics$invitation$combine$1();

    ChatAnalytics$invitation$combine$1() {
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        MessagesBatch messagesBatch = (MessagesBatch) obj;
        GroupChannel groupChannel = (GroupChannel) obj2;
        Intrinsics.m26847b(messagesBatch, "batch");
        Intrinsics.m26847b(groupChannel, "groupChannel");
        return new Pair(messagesBatch, groupChannel);
    }
}
