package com.reddit.datalibrary.frontpage.requests.models.v1;

import com.reddit.frontpage.domain.model.AdEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"toLegacyList", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/AdEvent;", "Lcom/reddit/frontpage/domain/model/AdEvent;", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: AdEvent.kt */
public final class AdEventKt {
    public static final List<AdEvent> m9383a(List<AdEvent> list) {
        Intrinsics.b(list, "$receiver");
        Iterable<AdEvent> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        for (AdEvent adEvent : iterable) {
            arrayList.add(new AdEvent(adEvent.getUrl(), adEvent.getType()));
        }
        return (List) arrayList;
    }
}
