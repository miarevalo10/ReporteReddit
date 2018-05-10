package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.social.domain.functions.MessagesBatch;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.GroupChannel;
import io.reactivex.functions.Function3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00012\u0006\u0010\t\u001a\u00020\u00022\u001a\u0010\n\u001a\u0016\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u0003j\u0002`\u00072\u0006\u0010\u000b\u001a\u00020\bH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lcom/sendbird/android/GroupChannel;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "Lcom/reddit/social/domain/functions/MessagesBatch;", "channel", "members", "batch", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestPresenter.kt */
final class ChatRequestPresenter$loadChannelInfo$combine$1<T1, T2, T3, R> implements Function3<GroupChannel, Map<String, ? extends UserData>, MessagesBatch, Triple<? extends GroupChannel, ? extends Map<String, ? extends UserData>, ? extends MessagesBatch>> {
    public static final ChatRequestPresenter$loadChannelInfo$combine$1 f29658a = new ChatRequestPresenter$loadChannelInfo$combine$1();

    ChatRequestPresenter$loadChannelInfo$combine$1() {
    }

    public final /* synthetic */ Object mo4932a(Object obj, Object obj2, Object obj3) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Map map = (Map) obj2;
        MessagesBatch messagesBatch = (MessagesBatch) obj3;
        Intrinsics.m26847b(groupChannel, "channel");
        Intrinsics.m26847b(map, "members");
        Intrinsics.m26847b(messagesBatch, "batch");
        return new Triple(groupChannel, map, messagesBatch);
    }
}
