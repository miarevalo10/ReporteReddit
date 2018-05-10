package com.reddit.social.domain.functions;

import com.reddit.datalibrary.social.data.datasource.cache.FailedMessagesCacheContract;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.social.presentation.chatinbox.ChatInboxItem;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.GroupChannel;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\u0018\u00002:\u0012*\u0012(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u0001B\u0019\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ<\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00032,\u0010\u0018\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t0\u0002H\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J2\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u001b\u001a\u00020\u00042\u001a\u0010\u001d\u001a\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\tH\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0004R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/reddit/social/domain/functions/ChannelConversationTransformer;", "Lio/reactivex/functions/Function;", "Lkotlin/Pair;", "", "Lcom/sendbird/android/GroupChannel;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "Lcom/reddit/social/presentation/chatinbox/ChatInboxItem;", "currentUserId", "currentUserName", "(Ljava/lang/String;Ljava/lang/String;)V", "getCurrentUserId", "()Ljava/lang/String;", "getCurrentUserName", "failedMessagesCache", "Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;", "getFailedMessagesCache", "()Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;", "setFailedMessagesCache", "(Lcom/reddit/datalibrary/social/data/datasource/cache/FailedMessagesCacheContract;)V", "apply", "pair", "getTimestamp", "", "channel", "membersToUserDataList", "userData", "prepareMessageToShow", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChannelConversationTransformer.kt */
public final class ChannelConversationTransformer implements Function<Pair<? extends List<? extends GroupChannel>, ? extends Map<String, ? extends UserData>>, List<? extends ChatInboxItem>> {
    @Inject
    public FailedMessagesCacheContract f29573a;
    private final String f29574b;
    private final String f29575c;

    public ChannelConversationTransformer(String str, String str2) {
        this.f29574b = str;
        this.f29575c = str2;
        FrontpageApplication.m28878n().mo5081a(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object apply(java.lang.Object r22) {
        /*
        r21 = this;
        r0 = r21;
        r1 = r22;
        r1 = (kotlin.Pair) r1;
        r2 = "pair";
        kotlin.jvm.internal.Intrinsics.m26847b(r1, r2);
        r2 = r1.f25267a;
        r2 = (java.util.List) r2;
        r1 = r1.f25268b;
        r1 = (java.util.Map) r1;
        r2 = (java.lang.Iterable) r2;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r3 = (java.util.Collection) r3;
        r2 = r2.iterator();
    L_0x0020:
        r4 = r2.hasNext();
        r5 = 1;
        r6 = 0;
        r7 = 2;
        if (r4 == 0) goto L_0x0044;
    L_0x0029:
        r4 = r2.next();
        r8 = r4;
        r8 = (com.sendbird.android.GroupChannel) r8;
        r9 = com.reddit.social.util.ChatUtilKt.m24765c(r8);
        if (r9 == 0) goto L_0x003e;
    L_0x0036:
        r8 = r8.m30984n();
        if (r8 != r7) goto L_0x003d;
    L_0x003c:
        goto L_0x003e;
    L_0x003d:
        r5 = r6;
    L_0x003e:
        if (r5 == 0) goto L_0x0020;
    L_0x0040:
        r3.add(r4);
        goto L_0x0020;
    L_0x0044:
        r3 = (java.util.List) r3;
        r3 = (java.lang.Iterable) r3;
        r2 = new java.util.ArrayList;
        r4 = kotlin.collections.CollectionsKt__IterablesKt.m32812b(r3);
        r2.<init>(r4);
        r2 = (java.util.Collection) r2;
        r3 = r3.iterator();
    L_0x0057:
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0182;
    L_0x005d:
        r4 = r3.next();
        r4 = (com.sendbird.android.GroupChannel) r4;
        r15 = new com.reddit.social.presentation.chatinbox.ChatInboxItem;
        r8 = r0.f29575c;
        r9 = com.reddit.social.util.ChatUtilKt.m24760b(r4, r8);
        r10 = r4.m24870d();
        r8 = "channel.url";
        kotlin.jvm.internal.Intrinsics.m26843a(r10, r8);
        r8 = r0.f29574b;
        r11 = com.reddit.social.util.ChatUtilKt.m24756a(r4, r8);
        r8 = "channel";
        kotlin.jvm.internal.Intrinsics.m26847b(r4, r8);
        r8 = r0.f29573a;
        if (r8 != 0) goto L_0x0088;
    L_0x0083:
        r12 = "failedMessagesCache";
        kotlin.jvm.internal.Intrinsics.m26844a(r12);
    L_0x0088:
        r12 = r4.m24870d();
        r13 = "channel.url";
        kotlin.jvm.internal.Intrinsics.m26843a(r12, r13);
        r8 = r8.has(r12);
        if (r8 == 0) goto L_0x00a7;
    L_0x0097:
        r8 = 2131886250; // 0x7f1200aa float:1.9407074E38 double:1.053291757E-314;
        r8 = com.reddit.frontpage.util.Util.m24027f(r8);
        r12 = "Util.getString(R.string.chat_error_message_failed)";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r12);
        r8 = (java.lang.CharSequence) r8;
    L_0x00a5:
        r12 = r8;
        goto L_0x010a;
    L_0x00a7:
        r8 = r4.m30980j();
        if (r8 == 0) goto L_0x00e7;
    L_0x00ad:
        r8 = com.reddit.social.util.ChatUtilKt.m24757b(r8);
        if (r8 == 0) goto L_0x00e7;
    L_0x00b3:
        r12 = r8.m25021d();
        r13 = r0.f29574b;
        r12 = kotlin.jvm.internal.Intrinsics.m26845a(r12, r13);
        if (r12 == 0) goto L_0x00c7;
    L_0x00bf:
        r8 = 2131887126; // 0x7f120416 float:1.940885E38 double:1.05329219E-314;
        r8 = com.reddit.frontpage.util.Util.m24027f(r8);
        goto L_0x00e5;
    L_0x00c7:
        r12 = com.reddit.social.util.ChatUtilKt.m24765c(r4);
        if (r12 != 0) goto L_0x00e3;
    L_0x00cd:
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r8 = r8.m25022e();
        r12.append(r8);
        r8 = ": ";
        r12.append(r8);
        r8 = r12.toString();
        goto L_0x00e5;
    L_0x00e3:
        r8 = "";
    L_0x00e5:
        if (r8 != 0) goto L_0x00e9;
    L_0x00e7:
        r8 = "";
    L_0x00e9:
        r12 = new java.lang.CharSequence[r7];
        r13 = new android.text.SpannableString;
        r8 = (java.lang.CharSequence) r8;
        r13.<init>(r8);
        r13 = (java.lang.CharSequence) r13;
        r12[r6] = r13;
        r8 = r4.m30980j();
        r8 = com.reddit.social.util.ChatUtilKt.m24751a(r8);
        r12[r5] = r8;
        r8 = android.text.TextUtils.concat(r12);
        r12 = "TextUtils.concat(\n      …ext(channel.lastMessage))";
        kotlin.jvm.internal.Intrinsics.m26843a(r8, r12);
        goto L_0x00a5;
    L_0x010a:
        r8 = "channel";
        kotlin.jvm.internal.Intrinsics.m26847b(r4, r8);
        r13 = r4.m24871e();
        r8 = r4.m30980j();
        r16 = 0;
        if (r8 == 0) goto L_0x0122;
    L_0x011b:
        r18 = r8.m24879g();
        r5 = r18;
        goto L_0x0124;
    L_0x0122:
        r5 = r16;
    L_0x0124:
        r8 = r0.f29573a;
        if (r8 != 0) goto L_0x012d;
    L_0x0128:
        r7 = "failedMessagesCache";
        kotlin.jvm.internal.Intrinsics.m26844a(r7);
    L_0x012d:
        r7 = r4.m24870d();
        r0 = "channel.url";
        kotlin.jvm.internal.Intrinsics.m26843a(r7, r0);
        r0 = r8.get(r7);
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.m41434e(r0);
        r0 = (com.sendbird.android.BaseMessage) r0;
        if (r0 == 0) goto L_0x0146;
    L_0x0142:
        r16 = r0.m24879g();
    L_0x0146:
        r7 = r16;
        r5 = java.lang.Math.max(r5, r7);
        r13 = java.lang.Math.max(r13, r5);
        r0 = r4.m30982l();
        r16 = m30614a(r4, r1);
        r18 = com.reddit.social.util.ChatUtilKt.m24765c(r4);
        r4 = r4.m30981k();
        if (r4 == 0) goto L_0x0167;
    L_0x0162:
        r4 = r4.m25021d();
        goto L_0x0168;
    L_0x0167:
        r4 = 0;
    L_0x0168:
        r4 = r1.get(r4);
        r17 = r4;
        r17 = (com.reddit.social.presentation.presentationobjects.UserData) r17;
        r19 = 0;
        r8 = r15;
        r4 = r15;
        r15 = r0;
        r8.<init>(r9, r10, r11, r12, r13, r15, r16, r17, r18);
        r2.add(r4);
        r0 = r21;
        r5 = 1;
        r6 = 0;
        r7 = 2;
        goto L_0x0057;
    L_0x0182:
        r2 = (java.util.List) r2;
        r2 = (java.lang.Iterable) r2;
        r0 = new com.reddit.social.domain.functions.ChannelConversationTransformer$apply$$inlined$compareBy$1;
        r0.<init>();
        r0 = (java.util.Comparator) r0;
        r1 = new com.reddit.social.domain.functions.ChannelConversationTransformer$apply$$inlined$thenByDescending$1;
        r1.<init>(r0);
        r1 = (java.util.Comparator) r1;
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.m41418a(r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.social.domain.functions.ChannelConversationTransformer.apply(java.lang.Object):java.lang.Object");
    }

    private static List<UserData> m30614a(GroupChannel groupChannel, Map<String, UserData> map) {
        Object m = groupChannel.m30983m();
        Intrinsics.m26843a(m, "channel.members");
        Collection arrayList = new ArrayList();
        for (Object obj : (Iterable) m) {
            Intrinsics.m26843a(obj, "it");
            UserData userData = (UserData) map.get(obj.m25021d());
            if (userData != null) {
                arrayList.add(userData);
            }
        }
        return (List) arrayList;
    }
}
