package com.reddit.social.analytics;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.social.analytics.ChatAnalytics.Source;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "chatInboxItems", "", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatAnalytics.kt */
final class ChatAnalytics$sendChatInboxEvent$1 extends Lambda implements Function1<List<? extends ChatInboxItem>, Unit> {
    final /* synthetic */ String f37500a;
    final /* synthetic */ String f37501b;

    ChatAnalytics$sendChatInboxEvent$1(String str, String str2) {
        this.f37500a = str;
        this.f37501b = str2;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        List<ChatInboxItem> list = (List) obj;
        Intrinsics.m26847b(list, "chatInboxItems");
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        int i4 = i3;
        for (ChatInboxItem chatInboxItem : list) {
            if (chatInboxItem.f22315c) {
                i2++;
                i3 += chatInboxItem.f22318f;
            } else {
                i4++;
                if (chatInboxItem.f22321i > 0) {
                    i = chatInboxItem.f22321i;
                }
            }
        }
        if (i <= 0) {
            i = i4;
        }
        ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22281a.f22289h)).m21892b(this.f37500a)).m21895c(this.f37501b)).m28917b(Long.valueOf((long) i2)).m28921e(Long.valueOf((long) i3)).m28919c(Long.valueOf((long) i)).m21891a();
        return Unit.f25273a;
    }
}
