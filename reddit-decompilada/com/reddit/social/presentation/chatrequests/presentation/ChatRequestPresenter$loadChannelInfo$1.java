package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.domain.functions.MessagesBatch;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import com.reddit.social.presentation.chatrequests.ChatRequestContract.View;
import com.reddit.social.presentation.presentationobjects.HasMessageData;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.User;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012Z\u0010\u0002\u001aV\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t\u0012\u0004\u0012\u00020\n \u000b**\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "Lcom/sendbird/android/GroupChannel;", "", "", "Lcom/reddit/datalibrary/social/network/UserId;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/datalibrary/social/data/datasource/cache/UserDataMap;", "Lcom/reddit/social/domain/functions/MessagesBatch;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestPresenter.kt */
final class ChatRequestPresenter$loadChannelInfo$1<T> implements Consumer<Triple<? extends GroupChannel, ? extends Map<String, ? extends UserData>, ? extends MessagesBatch>> {
    final /* synthetic */ ChatRequestPresenter f29655a;
    final /* synthetic */ String f29656b;

    ChatRequestPresenter$loadChannelInfo$1(ChatRequestPresenter chatRequestPresenter, String str) {
        this.f29655a = chatRequestPresenter;
        this.f29656b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        Object obj2;
        boolean z;
        Triple triple = (Triple) obj;
        GroupChannel groupChannel = (GroupChannel) triple.f25269a;
        Map map = (Map) triple.f25270b;
        MessagesBatch messagesBatch = (MessagesBatch) triple.f25271c;
        View a = ChatRequestPresenter.m30676a(this.f29655a);
        String f = Util.m24027f(ChatUtilKt.m24765c(groupChannel) ? C1761R.string.rdt_title_chat_request_screen : C1761R.string.rdt_title_group_invite);
        Intrinsics.m26843a((Object) f, "Util.getString(\n        …p_invite\n              })");
        a.mo7511a(f);
        this.f29655a.f29668j = ChatUtilKt.m24760b(groupChannel, SessionUtil.m23899e());
        ChatRequestPresenter.m30676a(this.f29655a).mo7509a(groupChannel);
        Object m = groupChannel.m30983m();
        Intrinsics.m26843a(m, "channel.members");
        Collection arrayList = new ArrayList();
        Iterator it = ((Iterable) m).iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            obj2 = (Member) next;
            Intrinsics.m26843a(obj2, "it");
            if ((1 ^ Intrinsics.m26845a(obj2.m25021d(), SessionUtil.m23898d())) != 0) {
                arrayList.add(next);
            }
        }
        Collection arrayList2 = new ArrayList();
        Iterator it2 = ((List) arrayList).iterator();
        while (true) {
            obj2 = null;
            if (!it2.hasNext()) {
                break;
            }
            next = (Member) it2.next();
            Intrinsics.m26843a(next, "it");
            UserData userData = (UserData) map.get(next.m25021d());
            if (userData != null) {
                userData.f22469f = Boolean.valueOf(next.m30995c());
                obj2 = userData;
            }
            if (obj2 != null) {
                arrayList2.add(obj2);
            }
        }
        List a2 = CollectionsKt___CollectionsKt.m41418a((Iterable) (List) arrayList2, (Comparator) new C1938x6ff46d26());
        ChatRequestPresenter chatRequestPresenter = this.f29655a;
        Iterable<UserData> iterable = a2;
        boolean z3 = iterable instanceof Collection;
        if (!(z3 && ((Collection) iterable).isEmpty())) {
            for (UserData userData2 : iterable) {
                boolean booleanValue;
                Boolean bool = userData2.f22470g;
                if (bool != null) {
                    booleanValue = bool.booleanValue();
                    continue;
                } else {
                    booleanValue = false;
                    continue;
                }
                if (booleanValue) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        chatRequestPresenter.f29667i = z;
        User k = groupChannel.m30981k();
        if (k != null) {
            obj2 = k.m25021d();
        }
        UserData userData3 = (UserData) map.get(obj2);
        if (userData3 != null) {
            ChatRequestPresenter.m30676a(this.f29655a).mo7508a(userData3);
        }
        if (!ChatUtilKt.m24765c(groupChannel)) {
            if (!z3 || ((Collection) iterable).isEmpty() == null) {
                for (UserData userData32 : iterable) {
                    if (Intrinsics.m26845a(userData32.f22469f, Boolean.valueOf(true))) {
                        break;
                    }
                }
            }
            z2 = false;
            if (z2) {
                ChatRequestPresenter.m30676a(this.f29655a).mo7518e();
            }
            ChatRequestPresenter.m30676a(this.f29655a).mo7510a(groupChannel, a2);
        } else if ((messagesBatch.f22302a.isEmpty() ^ 1) != 0) {
            ChatRequestPresenter.m30676a(this.f29655a).mo7507a((HasMessageData) CollectionsKt___CollectionsKt.m41437f((List) messagesBatch.f22302a));
        }
        obj = this.f29655a.m30692d();
        String str = this.f29656b;
        Intrinsics.m26847b(str, "channelUrl");
        BiFunction biFunction = ChatAnalytics$invitation$combine$1.f29568a;
        LoadMessagesUseCase loadMessagesUseCase = obj.f22294d;
        if (loadMessagesUseCase == null) {
            Intrinsics.m26844a("loadMessagesUseCase");
        }
        ObservableSource a3 = loadMessagesUseCase.m24494a(str, false);
        ChatDataRepositoryContract chatDataRepositoryContract = obj.f22291a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Observable zip = Observable.zip(a3, chatDataRepositoryContract.mo4506a(str), biFunction);
        Intrinsics.m26843a((Object) zip, "Observable.zip(loadMessa…nel(channelUrl), combine)");
        ObservablesKt.m24091a(zip, (Function1) new ChatAnalytics$invitation$1(obj, str));
    }
}
