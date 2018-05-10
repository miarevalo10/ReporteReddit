package com.reddit.datalibrary.social.data.datasource.cache;

import com.reddit.frontpage.util.kotlin.CollectionsKt;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.BaseMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCache;", "Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;", "()V", "cache", "Ljava/util/HashMap;", "", "", "Lcom/sendbird/android/BaseMessage;", "Lkotlin/collections/HashMap;", "add", "", "channelUrl", "message", "get", "has", "", "remove", "requestId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FailedMessagesCache.kt */
public final class FailedMessagesCache implements FailedMessagesCacheContract {
    private final HashMap<String, List<BaseMessage>> cache = new HashMap();

    public final void add(String str, BaseMessage baseMessage) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(baseMessage, "message");
        this.cache.put(str, CollectionsKt.m24072a(get(str), baseMessage));
    }

    public final List<BaseMessage> get(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        List list = (List) this.cache.get(str);
        return list == null ? CollectionsKt__CollectionsKt.m26790a() : list;
    }

    public final boolean has(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        return ((Collection) get(str)).isEmpty() == null ? true : null;
    }

    public final void remove(String str, String str2) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(str2, "requestId");
        Collection arrayList = new ArrayList();
        for (Object next : get(str)) {
            if ((Intrinsics.m26845a(ChatUtilKt.m24764c((BaseMessage) next), (Object) str2) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        this.cache.put(str, (List) arrayList);
    }
}
