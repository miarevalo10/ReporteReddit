package com.reddit.datalibrary.social.data.repo;

import com.reddit.datalibrary.social.data.datasource.cache.ChatUserDataCacheContract;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000128\u0010\u0002\u001a4\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \b*\u001a\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003j\u0004\u0018\u0001`\u00070\u0003j\u0002`\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "data", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatDataRepository.kt */
final class ChatDataRepository$usersData$1<T> implements Consumer<Map<String, ? extends UserData>> {
    final /* synthetic */ ChatDataRepository f27359a;

    ChatDataRepository$usersData$1(ChatDataRepository chatDataRepository) {
        this.f27359a = chatDataRepository;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (Map) obj;
        ChatUserDataCacheContract b = this.f27359a.m28794b();
        Intrinsics.m26843a(obj, "data");
        b.putUsersData(obj);
    }
}
