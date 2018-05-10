package com.reddit.social.presentation.chatinbox.presentation;

import com.sendbird.android.GroupChannel;
import io.reactivex.functions.BiFunction;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/sendbird/android/GroupChannel;", "a", "b", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatInboxPresenter.kt */
final class ChatInboxPresenter$loadMore$1<T1, T2, R> implements BiFunction<List<? extends GroupChannel>, List<? extends GroupChannel>, List<? extends GroupChannel>> {
    public static final ChatInboxPresenter$loadMore$1 f29606a = new ChatInboxPresenter$loadMore$1();

    ChatInboxPresenter$loadMore$1() {
    }

    public final /* synthetic */ Object apply(Object obj, Object obj2) {
        List list = (List) obj;
        List list2 = (List) obj2;
        Intrinsics.m26847b(list, "a");
        Intrinsics.m26847b(list2, "b");
        return CollectionsKt___CollectionsKt.m41423b((Collection) list, (Iterable) list2);
    }
}
