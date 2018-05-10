package com.reddit.social.domain.functions;

import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/reddit/social/domain/functions/ChatInboxChannelsTransformer;", "Lio/reactivex/functions/Function;", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "()V", "apply", "chatInboxItems", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxChannelsTransformer.kt */
public final class ChatInboxChannelsTransformer implements Function<List<? extends ChatInboxItem>, List<? extends ChatInboxItem>> {
    public static final Companion f29576a = new Companion();
    private static final int f29577b = 2;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/social/domain/functions/ChatInboxChannelsTransformer$Companion;", "", "()V", "UNACCEPTED_MAX", "", "getUNACCEPTED_MAX", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ChatInboxChannelsTransformer.kt */
    public static final class Companion {
        private Companion() {
        }

        public static int m24482a() {
            return ChatInboxChannelsTransformer.f29577b;
        }
    }

    public final /* synthetic */ Object apply(Object obj) {
        List<ChatInboxItem> list = (List) obj;
        Intrinsics.m26847b(list, "chatInboxItems");
        ArrayList arrayList = new ArrayList();
        ChatInboxItem chatInboxItem = null;
        int i = 0;
        for (ChatInboxItem chatInboxItem2 : list) {
            if (chatInboxItem2.f22315c) {
                arrayList.add(chatInboxItem2);
            } else {
                i++;
                if (i <= Companion.m24482a()) {
                    arrayList.add(chatInboxItem2);
                    chatInboxItem = chatInboxItem2;
                }
            }
        }
        if (chatInboxItem != null) {
            if (i > Companion.m24482a()) {
                chatInboxItem.f22321i = i;
            } else {
                chatInboxItem.f22321i = 0;
            }
        }
        return arrayList;
    }
}
