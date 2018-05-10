package com.reddit.social.domain.functions;

import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.MessageType;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.User;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002.\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b0\u0002\u0012\u0004\u0012\u00020\t0\u0001B\r\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ0\u0010\u0010\u001a\u00020\t2&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`\b0\u0002H\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/social/domain/functions/MessageListTransformer;", "Lio/reactivex/functions/Function;", "Lkotlin/Pair;", "Lcom/reddit/social/domain/functions/RawMessagesBatch;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "Lcom/reddit/social/domain/functions/MessagesBatch;", "currentUserId", "(Ljava/lang/String;)V", "getCurrentUserId", "()Ljava/lang/String;", "messageTransformer", "Lcom/reddit/social/domain/functions/MessageTransformer;", "apply", "pair", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessageListTransformer.kt */
public final class MessageListTransformer implements Function<Pair<? extends RawMessagesBatch, ? extends Map<String, ? extends UserData>>, MessagesBatch> {
    private final MessageTransformer f29580a = new MessageTransformer(this.f29581b);
    private final String f29581b;

    public MessageListTransformer(String str) {
        Intrinsics.m26847b(str, "currentUserId");
        this.f29581b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        HasMore hasMore;
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "pair");
        RawMessagesBatch rawMessagesBatch = (RawMessagesBatch) pair.f25267a;
        Map map = (Map) pair.f25268b;
        if (rawMessagesBatch.f22305b) {
            hasMore = HasMore.f22298a;
        } else {
            hasMore = HasMore.f22299b;
        }
        Iterable<BaseMessage> iterable = rawMessagesBatch.f22304a;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (BaseMessage baseMessage : iterable) {
            User b = ChatUtilKt.m24757b(baseMessage);
            arrayList.add(this.f29580a.m30619a(TuplesKt.m26780a(baseMessage, (UserData) map.get(b != null ? b.m25021d() : null))));
        }
        Collection collection = (Collection) new ArrayList();
        for (Object next : (List) arrayList) {
            if ((Intrinsics.m26845a(((HasMessageData) next).mo5204a().f22435h, MessageType.f22452i) ^ 1) != 0) {
                collection.add(next);
            }
        }
        return new MessagesBatch((List) collection, hasMore);
    }
}
