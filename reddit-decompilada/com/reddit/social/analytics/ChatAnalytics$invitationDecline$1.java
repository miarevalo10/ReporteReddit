package com.reddit.social.analytics;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.social.analytics.ChatAnalytics.Source;
import com.reddit.social.domain.functions.MessagesBatch;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "pair", "Lkotlin/Pair;", "Lcom/reddit/social/domain/functions/MessagesBatch;", "Lcom/sendbird/android/GroupChannel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatAnalytics.kt */
final class ChatAnalytics$invitationDecline$1 extends Lambda implements Function1<Pair<? extends MessagesBatch, ? extends GroupChannel>, Unit> {
    final /* synthetic */ ChatAnalytics f37490a;
    final /* synthetic */ String f37491b;

    public ChatAnalytics$invitationDecline$1(ChatAnalytics chatAnalytics, String str) {
        this.f37490a = chatAnalytics;
        this.f37491b = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Object d;
        Pair pair = (Pair) obj;
        Intrinsics.m26847b(pair, "pair");
        MessagesBatch messagesBatch = (MessagesBatch) pair.f25267a;
        GroupChannel groupChannel = (GroupChannel) pair.f25268b;
        boolean c = ChatUtilKt.m24765c(groupChannel);
        ChatEventBuilder d2 = ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22286f.f22289h)).m21892b("click")).m21895c("invitation_decline")).m28927i(this.f37491b).m28928j(c ? "direct" : "group").m28923f(Long.valueOf(groupChannel.m24871e())).m28920d(Long.valueOf((long) groupChannel.m30983m().size()));
        if (c && (messagesBatch.f22302a.isEmpty() ^ 1) != 0) {
            String a = ChatAnalytics.m24467b((HasMessageData) CollectionsKt___CollectionsKt.m41437f(messagesBatch.f22302a));
            if (a != null) {
                d2.m28930l(a);
            }
        }
        if (groupChannel.m30983m().size() > 0) {
            Object obj2 = groupChannel.m30983m().get(0);
            Intrinsics.m26843a(obj2, "groupChannel.members[0]");
            obj2 = ((Member) obj2).m25021d();
            Intrinsics.m26843a(obj2, "groupChannel.members[0].userId");
            d2.m28933o(obj2);
        }
        obj = groupChannel.m30983m();
        Intrinsics.m26843a(obj, "groupChannel.members");
        Collection arrayList = new ArrayList();
        for (Object d3 : (Iterable) obj) {
            Object obj3 = (Member) d3;
            Intrinsics.m26843a(obj3, "it");
            if (obj3.m30995c()) {
                arrayList.add(d3);
            }
        }
        List<Object> list = (List) arrayList;
        d2.m28915a(Long.valueOf((long) list.size()));
        if (list.isEmpty() != null) {
            d2.m21891a();
        } else {
            obj = UUID.randomUUID().toString();
            for (Object d32 : list) {
                Intrinsics.m26843a(d32, "it");
                d32 = d32.m25021d();
                Intrinsics.m26843a(d32, "it.userId");
                d2.m28929k(d32);
                Intrinsics.m26843a(obj, "correlationId");
                d2.m21896d(obj);
                d2.m21891a();
            }
        }
        return Unit.f25273a;
    }
}
