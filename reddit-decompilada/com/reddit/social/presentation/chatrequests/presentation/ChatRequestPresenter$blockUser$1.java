package com.reddit.social.presentation.chatrequests.presentation;

import com.sendbird.android.GroupChannel;
import io.reactivex.functions.Function3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lcom/sendbird/android/GroupChannel;", "channel", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "apply", "(Lcom/sendbird/android/GroupChannel;Ljava/lang/Object;Ljava/lang/Boolean;)Lcom/sendbird/android/GroupChannel;"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestPresenter.kt */
final class ChatRequestPresenter$blockUser$1<T1, T2, T3, R> implements Function3<GroupChannel, Object, Boolean, GroupChannel> {
    public static final ChatRequestPresenter$blockUser$1 f29650a = new ChatRequestPresenter$blockUser$1();

    ChatRequestPresenter$blockUser$1() {
    }

    public final /* synthetic */ Object mo4932a(Object obj, Object obj2, Object obj3) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Boolean bool = (Boolean) obj3;
        Intrinsics.m26847b(groupChannel, "channel");
        Intrinsics.m26847b(obj2, "<anonymous parameter 1>");
        Intrinsics.m26847b(bool, "<anonymous parameter 2>");
        return groupChannel;
    }
}
