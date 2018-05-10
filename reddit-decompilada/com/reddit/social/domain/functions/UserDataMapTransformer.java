package com.reddit.social.domain.functions;

import com.reddit.datalibrary.social.model.UserBriefData;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u000026\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\b0\u0001B\u0005¢\u0006\u0002\u0010\tJ8\u0010\f\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\b2\u001a\u0010\r\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u0006H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/social/domain/functions/UserDataMapTransformer;", "Lio/reactivex/functions/Function;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/model/UserBriefData;", "Lcom/reddit/datalibrary/social/network/UserBriefDataMap;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "()V", "userDataTransformer", "Lcom/reddit/social/domain/functions/UserDataTransformer;", "apply", "users", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserDataMapTransformer.kt */
public final class UserDataMapTransformer implements Function<Map<String, ? extends UserBriefData>, Map<String, ? extends UserData>> {
    private final UserDataTransformer f29585a = new UserDataTransformer();

    public final /* synthetic */ Object apply(Object obj) {
        Map map = (Map) obj;
        Intrinsics.m26847b(map, "users");
        Map linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.m36115a(map.size()));
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), UserDataTransformer.m30620a(entry));
        }
        return linkedHashMap;
    }
}
