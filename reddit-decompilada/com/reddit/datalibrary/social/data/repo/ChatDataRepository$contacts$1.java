package com.reddit.datalibrary.social.data.repo;

import com.reddit.datalibrary.social.model.Contact;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a¾\u0001\u0012X\u0012V\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t \n**\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t\u0018\u00010\u00020\u0002 \n*^\u0012X\u0012V\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t \n**\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/reddit/datalibrary/social/model/Contact;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "kotlin.jvm.PlatformType", "contacts", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$contacts$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ ChatDataRepository f27346a;

    ChatDataRepository$contacts$1(ChatDataRepository chatDataRepository) {
        this.f27346a = chatDataRepository;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final List list = (List) obj;
        Intrinsics.m26847b(list, "contacts");
        Iterable<Contact> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Contact userId : iterable) {
            arrayList.add(userId.getUserId());
        }
        return this.f27346a.mo4515a(CollectionsKt___CollectionsKt.m41451p((List) arrayList)).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                Map map = (Map) obj;
                Intrinsics.m26847b(map, "it");
                return TuplesKt.m26780a(list, map);
            }
        });
    }
}
