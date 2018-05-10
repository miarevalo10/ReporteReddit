package com.reddit.datalibrary.social.data.datasource.cache;

import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J0\u0010\f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b0\r2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\bH\u0016R\"\u0010\u0003\u001a\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/datalibrary/social/data/datasource/cache/ChatUserDataCache;", "Lcom/reddit/datalibrary/social/data/datasource/cache/ChatUserDataCacheContract;", "()V", "cachedUsersData", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "getNotCachedUsersId", "", "usersId", "getUsersData", "Lio/reactivex/Observable;", "putUsersData", "", "data", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatUserDataCache.kt */
public final class ChatUserDataCache implements ChatUserDataCacheContract {
    private Map<String, UserData> cachedUsersData = new HashMap();

    public final Observable<Map<String, UserData>> getUsersData(Set<String> set) {
        Intrinsics.m26847b(set, "usersId");
        Map map = this.cachedUsersData;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            if (set.contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Object just = Observable.just(linkedHashMap);
        Intrinsics.m26843a(just, "Observable.just(cachedUs…erKeys { it in usersId })");
        return just;
    }

    public final Set<String> getNotCachedUsersId(Set<String> set) {
        Intrinsics.m26847b(set, "usersId");
        Collection arrayList = new ArrayList();
        for (Object next : set) {
            if ((this.cachedUsersData.keySet().contains((String) next) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        return CollectionsKt___CollectionsKt.m41451p((List) arrayList);
    }

    public final void putUsersData(Map<String, UserData> map) {
        Intrinsics.m26847b(map, "data");
        this.cachedUsersData = MapsKt__MapsKt.m36119a(this.cachedUsersData, (Map) map);
    }
}
