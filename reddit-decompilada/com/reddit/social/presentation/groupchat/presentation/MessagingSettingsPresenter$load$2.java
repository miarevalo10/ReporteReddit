package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.social.presentation.presentationobjects.UserData;
import com.reddit.social.util.ChatUtilKt;
import com.sendbird.android.GroupChannel;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005 \u0007*\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/sendbird/android/GroupChannel;", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
final class MessagingSettingsPresenter$load$2 extends Lambda implements Function1<Pair<? extends GroupChannel, ? extends List<? extends UserData>>, Unit> {
    final /* synthetic */ MessagingSettingsPresenter f37534a;

    MessagingSettingsPresenter$load$2(MessagingSettingsPresenter messagingSettingsPresenter) {
        this.f37534a = messagingSettingsPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Pair pair = (Pair) obj;
        GroupChannel groupChannel = (GroupChannel) pair.f25267a;
        this.f37534a.f29844f = CollectionsKt___CollectionsKt.m41418a((Iterable) (List) pair.f25268b, (Comparator) new MessagingSettingsPresenter$load$2$$special$$inlined$sortedBy$1());
        if (ChatUtilKt.m24765c(groupChannel) != null) {
            MessagingSettingsPresenter.m30830b(this.f37534a).mo7577a(MessagingSettingsPresenter.m30827a(this.f37534a));
            if (ChatUtilKt.m24762b() != null) {
                MessagingSettingsPresenter.m30830b(this.f37534a).mo7587f();
            }
        } else {
            MessagingSettingsPresenter.m30830b(this.f37534a).mo7571a(MessagingSettingsPresenter.m30827a(this.f37534a).size());
            MessagingSettingsPresenter.m30830b(this.f37534a).mo7585d();
            MessagingSettingsPresenter.m30830b(this.f37534a).mo7586e();
            MessagingSettingsPresenter.m30830b(this.f37534a).mo7582b(groupChannel.m24872f());
        }
        return Unit.f25273a;
    }
}
