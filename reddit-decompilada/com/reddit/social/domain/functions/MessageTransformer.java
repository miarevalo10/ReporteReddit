package com.reddit.social.domain.functions;

import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.UserMessage;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\u00020\u00052\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/reddit/social/domain/functions/MessageTransformer;", "Lio/reactivex/functions/Function;", "Lkotlin/Pair;", "Lcom/sendbird/android/BaseMessage;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/social/presentation/presentationobjects/HasMessageData;", "currentUserId", "", "(Ljava/lang/String;)V", "getCurrentUserId", "()Ljava/lang/String;", "apply", "pair", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessageTransformer.kt */
public final class MessageTransformer implements Function<Pair<? extends BaseMessage, ? extends UserData>, HasMessageData> {
    private final String f29582a;

    public MessageTransformer(String str) {
        Intrinsics.m26847b(str, "currentUserId");
        this.f29582a = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        return m30619a((Pair) obj);
    }

    public final HasMessageData m30619a(Pair<? extends BaseMessage, UserData> pair) {
        Intrinsics.m26847b(pair, "pair");
        BaseMessage baseMessage = (BaseMessage) pair.f25267a;
        UserData userData = (UserData) pair.f25268b;
        Boolean bool = null;
        String str = userData != null ? userData.f22466c : null;
        if (userData != null) {
            bool = userData.f22470g;
        }
        if ((baseMessage instanceof UserMessage) != null) {
            return MessageTransformerKt.m24484a((UserMessage) baseMessage, this.f29582a, str, bool);
        }
        if ((baseMessage instanceof AdminMessage) != null) {
            return MessageTransformerKt.m24483a((AdminMessage) baseMessage);
        }
        if ((baseMessage instanceof FileMessage) != null) {
            return MessageTransformerKt.m24485a((FileMessage) baseMessage, this.f29582a, str, bool);
        }
        throw ((Throwable) new IllegalArgumentException("Looks like SendBird added new type of message and you got it"));
    }
}
