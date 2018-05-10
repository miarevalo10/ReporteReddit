package com.reddit.datalibrary.social.data.repo;

import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.Member;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "kotlin.jvm.PlatformType", "users", "Lcom/sendbird/android/Member;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$getMembers$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatDataRepository f27348a;

    ChatDataRepository$getMembers$1(ChatDataRepository chatDataRepository) {
        this.f27348a = chatDataRepository;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final List list = (List) obj;
        Intrinsics.m26847b(list, "users");
        Iterable<Member> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Member d : iterable) {
            arrayList.add(d.m25021d());
        }
        return this.f27348a.mo4515a(CollectionsKt___CollectionsKt.m41451p((List) arrayList)).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                Map map = (Map) obj;
                Intrinsics.m26847b(map, "usersData");
                Object obj2 = list;
                Intrinsics.m26843a(obj2, "users");
                Collection arrayList = new ArrayList();
                for (Member member : (Iterable) obj2) {
                    Object obj3 = (UserData) map.get(member.m25021d());
                    if (obj3 != null) {
                        obj3.f22469f = Boolean.valueOf(member.m30995c());
                    } else {
                        obj3 = null;
                    }
                    if (obj3 != null) {
                        arrayList.add(obj3);
                    }
                }
                return (List) arrayList;
            }
        });
    }
}
