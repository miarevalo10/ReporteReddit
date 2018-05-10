package com.reddit.social.analytics;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ChatEventBuilder;
import com.reddit.frontpage.util.SessionUtil;
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
final class ChatAnalytics$chat$1 extends Lambda implements Function1<GroupChannel, Unit> {
    final /* synthetic */ String f37467a;

    public ChatAnalytics$chat$1(String str) {
        this.f37467a = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str;
        Object d;
        Object d2;
        GroupChannel groupChannel = (GroupChannel) obj;
        Intrinsics.m26847b(groupChannel, "groupChannel");
        int n = groupChannel.m30984n();
        String str2 = null;
        if (groupChannel.m30985o()) {
            str = "direct";
            d = SessionUtil.m23898d();
            Object m = groupChannel.m30983m();
            Intrinsics.m26843a(m, "groupChannel.members");
            for (Object next : (Iterable) m) {
                Object obj2 = (Member) next;
                Intrinsics.m26843a(obj2, "it");
                if ((Intrinsics.m26845a(obj2.m25021d(), d) ^ 1) != 0) {
                    break;
                }
            }
            Object next2 = null;
            Member member = (Member) next2;
            if (member != null) {
                str2 = member.m25021d();
            }
        } else {
            str = "group";
        }
        ChatEventBuilder e = ((ChatEventBuilder) ((ChatEventBuilder) ((ChatEventBuilder) AppAnalytics.m21879p().m21888a(Source.f22282b.f22289h)).m21892b("view")).m21895c("chat")).m28925g(str).m28920d(Long.valueOf((long) n)).m28932n(str2).m28924f(this.f37467a).m28921e(Long.valueOf((long) groupChannel.m30982l()));
        obj = groupChannel.m30983m();
        Intrinsics.m26843a(obj, "groupChannel.members");
        Collection arrayList = new ArrayList();
        for (Object d22 : (Iterable) obj) {
            d = (Member) d22;
            Intrinsics.m26843a(d, "it");
            if (d.m30995c()) {
                arrayList.add(d22);
            }
        }
        List<Object> list = (List) arrayList;
        e.m28915a(Long.valueOf((long) list.size()));
        if (list.isEmpty() != null) {
            e.m21891a();
        } else {
            obj = UUID.randomUUID().toString();
            for (Object d222 : list) {
                Intrinsics.m26843a(d222, "it");
                d222 = d222.m25021d();
                Intrinsics.m26843a(d222, "it.userId");
                e.m28929k(d222);
                Intrinsics.m26843a(obj, "correlationId");
                e.m21896d(obj);
                e.m21891a();
            }
        }
        return Unit.f25273a;
    }
}
