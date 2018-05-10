package com.reddit.social.presentation.groupchat.view;

import android.content.Context;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0002 \u0005**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004 \u0005*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lkotlin/Pair;", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "Lcom/reddit/social/presentation/groupchat/view/UserActions;", "kotlin.jvm.PlatformType", "user", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: GroupMembersScreen.kt */
final class GroupMembersScreen$onCreateView$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ GroupMembersScreen f29847a;

    GroupMembersScreen$onCreateView$1(GroupMembersScreen groupMembersScreen) {
        this.f29847a = groupMembersScreen;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final UserData userData = (UserData) obj;
        Intrinsics.m26847b(userData, "user");
        if (Intrinsics.m26845a(userData.f22464a, SessionUtil.m23898d())) {
            return Single.just(TuplesKt.m26780a(userData, UserActions.f22372a));
        }
        Companion companion = RedditAlertDialog.f21112b;
        Object am_ = this.f29847a.am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Context context = (Context) am_;
        Object[] objArr = (Object[]) UserActions.values();
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj2 : objArr) {
            arrayList.add(((UserActions) obj2).f22376d);
        }
        return Companion.m23301a(context, (Collection) (List) arrayList, 0).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                Integer num = (Integer) obj;
                Intrinsics.m26847b(num, "it");
                return TuplesKt.m26780a(userData, UserActions.values()[num.intValue()]);
            }
        });
    }
}
