package com.reddit.social.presentation.chatinbox.presentation;

import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.reddit.social.util.ChatUtilKt;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatInboxPresenter.kt */
final class ChatInboxPresenter$loadMore$3<T, R> implements Function<T, R> {
    public static final ChatInboxPresenter$loadMore$3 f29608a = new ChatInboxPresenter$loadMore$3();

    ChatInboxPresenter$loadMore$3() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "it");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            Object obj2;
            if (!((ChatInboxItem) next).f22322j) {
                if (!ChatUtilKt.m24762b()) {
                    obj2 = null;
                    if (obj2 != null) {
                        arrayList.add(next);
                    }
                }
            }
            obj2 = 1;
            if (obj2 != null) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
