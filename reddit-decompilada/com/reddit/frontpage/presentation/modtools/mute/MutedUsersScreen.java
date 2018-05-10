package com.reddit.frontpage.presentation.modtools.mute;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.reddit.datalibrary.frontpage.data.model.ModToolsUserModel;
import com.reddit.datalibrary.frontpage.data.model.MutedUser;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerMutedUsersComponent;
import com.reddit.frontpage.di.module.MutedUsersViewModule;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.Presenter;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsScreen;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions.ModUsersOptionsScreen;
import com.reddit.frontpage.presentation.modtools.util.ModUsersOptionsAction;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import com.reddit.frontpage.util.Util;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/mute/MutedUsersScreen;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsScreen;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "moderatorPresenter", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "getModeratorPresenter", "()Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "presenter", "Lcom/reddit/frontpage/presentation/modtools/mute/MutedUsersPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/mute/MutedUsersPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/mute/MutedUsersPresenter;)V", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "getLayoutId", "", "onEventMainThread", "event", "Lcom/reddit/frontpage/presentation/modtools/util/ModUsersOptionsAction;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "showOptions", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MutedUsersScreen.kt */
public final class MutedUsersScreen extends BaseModeratorsScreen implements View {
    public static final Companion f40591w = new Companion();
    @Inject
    public MutedUsersPresenter f40592v;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/mute/MutedUsersScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/mute/MutedUsersScreen;", "subredditId", "", "subredditName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: MutedUsersScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static MutedUsersScreen m23132a(String str, String str2) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            MutedUsersScreen mutedUsersScreen = new MutedUsersScreen();
            mutedUsersScreen.m40774b(str);
            mutedUsersScreen.mo7241c(str2);
            return mutedUsersScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20913a;

        static {
            int[] iArr = new int[ModUsersOptionsAction.values().length];
            f20913a = iArr;
            iArr[ModUsersOptionsAction.f20932a.ordinal()] = 1;
            f20913a[ModUsersOptionsAction.f20933b.ordinal()] = 2;
            f20913a[ModUsersOptionsAction.f20934c.ordinal()] = 3;
        }
    }

    public static final MutedUsersScreen m42118a(String str, String str2) {
        return Companion.m23132a(str, str2);
    }

    public final int mo7141s() {
        return C1761R.layout.screen_modtools_users;
    }

    public MutedUsersScreen() {
        DaggerMutedUsersComponent.m29187a().m22144a(FrontpageApplication.m28875k()).m22145a(new MutedUsersViewModule(this)).m22146a().mo4689a(this);
    }

    public MutedUsersScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerMutedUsersComponent.m29187a().m22144a(FrontpageApplication.m28875k()).m22145a(new MutedUsersViewModule(this)).m22146a().mo4689a(this);
    }

    public final Presenter mo7668w() {
        MutedUsersPresenter mutedUsersPresenter = this.f40592v;
        if (mutedUsersPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return mutedUsersPresenter;
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        super.mo7185a(actionBar);
        m37537h(Util.m24027f((int) C1761R.string.mod_tools_mute_users));
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_modtools_add) {
            return super.mo7201a(menuItem);
        }
        ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27453d)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20065x.f20068M)).m21889a(m40781y(), mo7383a())).m21891a();
        Screen f = Nav.m22583f(m40781y(), mo7383a());
        Screen screen = this;
        f.m29363b(screen);
        Routing.m22623a(screen, f);
        return true;
    }

    public final void mo7669x() {
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        ModUsersOptionsScreen modUsersOptionsScreen = new ModUsersOptionsScreen((Context) am_, C1761R.layout.muted_users_options);
        modUsersOptionsScreen.m38959a((BaseScreen) this);
        modUsersOptionsScreen.show();
    }

    public final void onEventMainThread(ModUsersOptionsAction modUsersOptionsAction) {
        Intrinsics.m26847b(modUsersOptionsAction, "event");
        EventBus.getDefault().removeStickyEvent((Object) modUsersOptionsAction);
        switch (WhenMappings.f20913a[modUsersOptionsAction.ordinal()]) {
            case 1:
                ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27453d)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20066y.f20068M)).m21889a(m40781y(), mo7383a())).m21891a();
                ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27453d)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20062u.f20068M)).m21889a(m40781y(), mo7383a())).m21891a();
                String y = m40781y();
                String a = mo7383a();
                ModToolsUserModel modToolsUserModel = mo7386b().f20859b;
                if (modToolsUserModel == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.data.model.MutedUser");
                }
                Screen a2 = Nav.m22555a(y, a, (MutedUser) modToolsUserModel);
                Screen screen = this;
                a2.m29363b(screen);
                Routing.m22623a(screen, a2);
                return;
            case 2:
                m40779d(mo7386b().f20859b.getUsername());
                return;
            case 3:
                modUsersOptionsAction = RedditAlertDialog.f21112b;
                Object am_ = am_();
                if (am_ == null) {
                    Intrinsics.m26842a();
                }
                Intrinsics.m26843a(am_, "activity!!");
                com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23295a((Context) am_, mo7386b().f20859b.getUsername(), C1761R.string.mod_tools_action_unmute, C1761R.string.mod_tools_action_unmute_content, C1761R.string.mod_tools_option_unmute, (Function2) new MutedUsersScreen$onEventMainThread$1(this), false).m23323a();
                break;
            default:
                break;
        }
    }
}
