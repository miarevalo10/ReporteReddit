package com.reddit.social.domain.functions;

import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.SentStatus;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.User;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002:\u00120\u0012.\u0012\u0004\u0012\u00020\u0003\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t0\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0001B\r\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ<\u0010\u0011\u001a\u00020\n22\u0010\u0012\u001a.\u0012\u0004\u0012\u00020\u0003\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t0\u00020\u0002H\u0016R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/reddit/social/domain/functions/SentMessageTransformer;", "Lio/reactivex/functions/Function;", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/SentStatus;", "Lcom/sendbird/android/BaseMessage;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "currentUserId", "(Ljava/lang/String;)V", "getCurrentUserId", "()Ljava/lang/String;", "messageTransformer", "Lcom/reddit/social/domain/functions/MessageTransformer;", "apply", "pair", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SentMessageTransformer.kt */
public final class SentMessageTransformer implements Function<Pair<? extends SentStatus, ? extends Pair<? extends BaseMessage, ? extends Map<String, ? extends UserData>>>, HasMessageData> {
    private final MessageTransformer f29583a = new MessageTransformer(this.f29584b);
    private final String f29584b;

    public SentMessageTransformer(String str) {
        Intrinsics.m26847b(str, "currentUserId");
        this.f29584b = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "pair");
        SentStatus sentStatus = (SentStatus) pair.f25267a;
        pair = (Pair) pair.f25268b;
        BaseMessage baseMessage = (BaseMessage) pair.f25267a;
        Map map = (Map) pair.f25268b;
        User b = ChatUtilKt.m24757b(baseMessage);
        obj = this.f29583a.m30619a(TuplesKt.m26780a(baseMessage, (UserData) map.get(b != null ? b.m25021d() : null)));
        obj.mo5204a().f22436i = sentStatus;
        return obj;
    }
}
