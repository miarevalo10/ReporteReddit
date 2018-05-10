package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.GroupChannel;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/sendbird/android/GroupChannel;", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "a", "b", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMessagingPresenter.kt */
final class GroupMessagingPresenter$loadChatInfo$1<T1, T2, R> implements BiFunction<GroupChannel, List<? extends UserData>, Pair<? extends GroupChannel, ? extends List<? extends UserData>>> {
    public static final GroupMessagingPresenter$loadChatInfo$1 f29759a = new GroupMessagingPresenter$loadChatInfo$1();

    GroupMessagingPresenter$loadChatInfo$1() {
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        GroupChannel groupChannel = (GroupChannel) obj;
        List list = (List) obj2;
        Intrinsics.m26847b(groupChannel, "a");
        Intrinsics.m26847b(list, "b");
        return TuplesKt.m26780a(groupChannel, list);
    }
}
