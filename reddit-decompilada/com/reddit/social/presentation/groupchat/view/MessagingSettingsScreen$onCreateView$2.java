package com.reddit.social.presentation.groupchat.view;

import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.social.presentation.groupchat.view.MessagingSettingsScreen.WhenMappings;
import com.reddit.social.presentation.presentationobjects.UserData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/social/presentation/groupchat/view/UserActions;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MessagingSettingsScreen.kt */
final class MessagingSettingsScreen$onCreateView$2 extends Lambda implements Function1<Pair<? extends UserData, ? extends UserActions>, Unit> {
    final /* synthetic */ MessagingSettingsScreen f37546a;

    MessagingSettingsScreen$onCreateView$2(MessagingSettingsScreen messagingSettingsScreen) {
        this.f37546a = messagingSettingsScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Pair pair = (Pair) obj;
        UserData userData = (UserData) pair.f25267a;
        switch (WhenMappings.f22369a[((UserActions) pair.f25268b).ordinal()]) {
            case 1:
                Routing.m22623a((Screen) this.f37546a, Nav.m22594j(userData.f22465b));
                break;
            case 2:
                this.f37546a.m41360w().mo5183a(userData.f22464a, userData.f22465b);
                break;
            case 3:
                MessagingSettingsScreen messagingSettingsScreen = this.f37546a;
                Intrinsics.m26843a((Object) userData, "user");
                MessagingSettingsScreen.m41333a(messagingSettingsScreen, userData);
                break;
            default:
                break;
        }
        return Unit.f25273a;
    }
}
