package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.sendbird.android.UserMessage;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "Lcom/sendbird/android/UserMessage;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$resendMessage$1<T, R> implements Function<T, R> {
    public static final GroupMessagingPresenter$resendMessage$1 f29775a = new GroupMessagingPresenter$resendMessage$1();

    GroupMessagingPresenter$resendMessage$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        UserMessage userMessage = (UserMessage) obj;
        Intrinsics.m26847b(userMessage, "it");
        return TuplesKt.m26780a(SentStatus.f22461b, userMessage);
    }
}
