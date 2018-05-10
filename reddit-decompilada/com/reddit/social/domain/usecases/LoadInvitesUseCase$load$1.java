package com.reddit.social.domain.usecases;

import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.GroupChannel;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/sendbird/android/GroupChannel;", "it", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LoadInvitesUseCase.kt */
final class LoadInvitesUseCase$load$1<T, R> implements Function<T, R> {
    public static final LoadInvitesUseCase$load$1 f29592a = new LoadInvitesUseCase$load$1();

    LoadInvitesUseCase$load$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.m26847b(list, "it");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            Object obj2;
            if (!ChatUtilKt.m24765c((GroupChannel) next)) {
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
