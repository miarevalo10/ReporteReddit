package com.reddit.social.analytics;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.social.analytics.ChatAnalytics.Source;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "groupChannel", "Lcom/sendbird/android/GroupChannel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatAnalytics.kt */
final class ChatAnalytics$chatLeaveGroup$1 extends Lambda implements Function1<GroupChannel, Unit> {
    final /* synthetic */ String f37468a;

    public ChatAnalytics$chatLeaveGroup$1(String str) {
        this.f37468a = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "groupChannel");
        ChatEventBuilder f = ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22284d.f22289h)).m21892b("click")).m21895c("leave_group")).m28925g("group").m28920d(Long.valueOf((long) groupChannel.m30984n())).m28924f(this.f37468a);
        obj = groupChannel.m30983m();
        Intrinsics.m26843a(obj, "groupChannel.members");
        Collection arrayList = new ArrayList();
        for (Object next : (Iterable) obj) {
            Object next2;
            Object obj2 = (Member) next2;
            Intrinsics.m26843a(obj2, "it");
            if (obj2.m30995c()) {
                arrayList.add(next2);
            }
        }
        List<Object> list = (List) arrayList;
        f.m28915a(Long.valueOf((long) list.size()));
        if (list.isEmpty() != null) {
            f.m21891a();
        } else {
            obj = UUID.randomUUID().toString();
            for (Object next22 : list) {
                Intrinsics.m26843a(next22, "it");
                next22 = next22.m25021d();
                Intrinsics.m26843a(next22, "it.userId");
                f.m28929k(next22);
                Intrinsics.m26843a(obj, "correlationId");
                f.m21896d(obj);
                f.m21891a();
            }
        }
        return Unit.f25273a;
    }
}
