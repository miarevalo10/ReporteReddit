package com.reddit.social.domain.functions;

import com.reddit.datalibrary.social.model.UserBriefData;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.functions.Function;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\"\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0001B\u0005¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\u00072\u001a\u0010\n\u001a\u0016\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u0002`\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/reddit/social/domain/functions/UserDataTransformer;", "Lio/reactivex/functions/Function;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/datalibrary/social/model/UserBriefData;", "Lcom/reddit/datalibrary/social/network/UserBriefDataMapEntry;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "()V", "apply", "user", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserDataTransformer.kt */
public final class UserDataTransformer implements Function<Entry<? extends String, ? extends UserBriefData>, UserData> {
    public final /* synthetic */ Object apply(Object obj) {
        return m30620a((Entry) obj);
    }

    public static UserData m30620a(Entry<String, UserBriefData> entry) {
        Intrinsics.m26847b(entry, "user");
        return new UserData((String) entry.getKey(), ((UserBriefData) entry.getValue()).getName(), ((UserBriefData) entry.getValue()).getProfileIcon(), ((UserBriefData) entry.getValue()).getLinkKarma() + ((UserBriefData) entry.getValue()).getCommentKarma(), ((UserBriefData) entry.getValue()).getCreatedUtc(), null, Boolean.valueOf(((UserBriefData) entry.getValue()).isNsfw()));
    }
}
