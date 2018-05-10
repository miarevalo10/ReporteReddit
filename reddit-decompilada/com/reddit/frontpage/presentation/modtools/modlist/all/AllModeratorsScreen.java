package com.reddit.frontpage.presentation.modtools.modlist.all;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerAllModeratorsComponent;
import com.reddit.frontpage.di.module.AllModeratorsViewModule;
import com.reddit.frontpage.presentation.modtools.adapter.ModAdapterMode;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.Presenter;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsScreen;
import com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsContract.View;
import com.reddit.frontpage.presentation.modtools.util.ModUsersOptionsAction;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsScreen;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsScreen;", "Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "moderatorPresenter", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "getModeratorPresenter", "()Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "presenter", "Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsPresenter;)V", "getAdapterMode", "Lcom/reddit/frontpage/presentation/modtools/adapter/ModAdapterMode;", "getLayoutId", "", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onDecline", "onEventMainThread", "event", "Lcom/reddit/frontpage/presentation/modtools/util/ModUsersOptionsAction;", "onInviteSuccess", "showModInviteDialog", "showOptions", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AllModeratorsScreen.kt */
public final class AllModeratorsScreen extends BaseModeratorsScreen implements View {
    public static final Companion f40587w = new Companion();
    @Inject
    public AllModeratorsPresenter f40588v;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/modlist/all/AllModeratorsScreen;", "subredditId", "", "subredditName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AllModeratorsScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static AllModeratorsScreen m23126a(String str, String str2) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            AllModeratorsScreen allModeratorsScreen = new AllModeratorsScreen();
            allModeratorsScreen.m40774b(str);
            allModeratorsScreen.mo7241c(str2);
            return allModeratorsScreen;
        }
    }

    public final void mo7673a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
    }

    public final void onEventMainThread(ModUsersOptionsAction modUsersOptionsAction) {
        Intrinsics.m26847b(modUsersOptionsAction, "event");
    }

    public final int mo7141s() {
        return C1761R.layout.screen_moderators;
    }

    public final void mo7669x() {
    }

    public AllModeratorsScreen() {
        DaggerAllModeratorsComponent.m29000a().m22059a(FrontpageApplication.m28875k()).m22060a(new AllModeratorsViewModule(this)).m22058a().mo4584a(this);
    }

    public AllModeratorsScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerAllModeratorsComponent.m29000a().m22059a(FrontpageApplication.m28875k()).m22060a(new AllModeratorsViewModule(this)).m22058a().mo4584a(this);
    }

    protected final ModAdapterMode mo7670O() {
        return ModAdapterMode.f20864b;
    }

    public final AllModeratorsPresenter mo7671P() {
        AllModeratorsPresenter allModeratorsPresenter = this.f40588v;
        if (allModeratorsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return allModeratorsPresenter;
    }

    public final Presenter mo7668w() {
        AllModeratorsPresenter allModeratorsPresenter = this.f40588v;
        if (allModeratorsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return allModeratorsPresenter;
    }

    public final void mo7674d() {
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion companion = RedditAlertDialog.f21112b;
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23299a((Context) am_, (Function2) new AllModeratorsScreen$showModInviteDialog$1(this), (Function2) new AllModeratorsScreen$showModInviteDialog$2(this)).m23323a();
    }

    public final void R_() {
        m29351F();
    }
}
