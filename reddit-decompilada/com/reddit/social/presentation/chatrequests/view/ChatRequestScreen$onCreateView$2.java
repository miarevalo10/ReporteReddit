package com.reddit.social.presentation.chatrequests.view;

import android.content.Context;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion;
import com.reddit.social.presentation.chatrequests.view.ChatRequestScreen.WhenMappings;
import com.reddit.social.presentation.groupchat.view.UserActions;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/social/presentation/groupchat/view/UserActions;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ChatRequestScreen.kt */
final class ChatRequestScreen$onCreateView$2<T> implements Consumer<Pair<? extends UserData, ? extends UserActions>> {
    final /* synthetic */ ChatRequestScreen f29676a;

    ChatRequestScreen$onCreateView$2(ChatRequestScreen chatRequestScreen) {
        this.f29676a = chatRequestScreen;
    }

    public final /* synthetic */ void accept(Object obj) {
        Pair pair = (Pair) obj;
        UserData userData = (UserData) pair.f25267a;
        switch (WhenMappings.f22336a[((UserActions) pair.f25268b).ordinal()]) {
            case 1:
                obj = this.f29676a.m41233w();
                Intrinsics.m26843a((Object) userData, "user");
                obj.mo5126a(userData);
                Routing.m22623a((Screen) this.f29676a, Nav.m22594j(userData.f22465b));
                return;
            case 2:
                obj = this.f29676a;
                String str = userData.f22464a;
                String str2 = userData.f22465b;
                Intrinsics.m26847b(str, "userId");
                Intrinsics.m26847b(str2, "username");
                Companion companion = RedditAlertDialog.f21112b;
                Object am_ = obj.am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                Intrinsics.m26843a(am_, "activity!!");
                Companion.m23297a((Context) am_, str2, (Function2) new ChatRequestScreen$confirmBlockUser$1(obj, str)).m23323a();
                return;
            case 3:
                ChatRequestScreen chatRequestScreen = this.f29676a;
                Intrinsics.m26843a((Object) userData, "user");
                ChatRequestScreen.m41202a(chatRequestScreen, userData);
                break;
            default:
                break;
        }
    }
}
