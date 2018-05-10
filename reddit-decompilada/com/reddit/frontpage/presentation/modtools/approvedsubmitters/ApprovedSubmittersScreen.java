package com.reddit.frontpage.presentation.modtools.approvedsubmitters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerApprovedSubmittersComponent;
import com.reddit.frontpage.di.module.ApprovedSubmittersViewModule;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/ApprovedSubmittersScreen;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsScreen;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "moderatorPresenter", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "getModeratorPresenter", "()Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "presenter", "Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/ApprovedSubmittersPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/ApprovedSubmittersPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/ApprovedSubmittersPresenter;)V", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "getLayoutId", "", "onEventMainThread", "event", "Lcom/reddit/frontpage/presentation/modtools/util/ModUsersOptionsAction;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "showOptions", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ApprovedSubmittersScreen.kt */
public final class ApprovedSubmittersScreen extends BaseModeratorsScreen implements View {
    public static final Companion f40583w = new Companion();
    @Inject
    public ApprovedSubmittersPresenter f40584v;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/ApprovedSubmittersScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/ApprovedSubmittersScreen;", "subredditId", "", "subredditName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ApprovedSubmittersScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ApprovedSubmittersScreen m23087a(String str, String str2) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            ApprovedSubmittersScreen approvedSubmittersScreen = new ApprovedSubmittersScreen();
            approvedSubmittersScreen.m40774b(str);
            approvedSubmittersScreen.mo7241c(str2);
            return approvedSubmittersScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20873a;

        static {
            int[] iArr = new int[ModUsersOptionsAction.values().length];
            f20873a = iArr;
            iArr[ModUsersOptionsAction.f20932a.ordinal()] = 1;
            f20873a[ModUsersOptionsAction.f20933b.ordinal()] = 2;
            f20873a[ModUsersOptionsAction.f20934c.ordinal()] = 3;
        }
    }

    public static final ApprovedSubmittersScreen m42093a(String str, String str2) {
        return Companion.m23087a(str, str2);
    }

    public final int mo7141s() {
        return C1761R.layout.screen_modtools_users;
    }

    public ApprovedSubmittersScreen() {
        DaggerApprovedSubmittersComponent.m29028a().m22066a(FrontpageApplication.m28875k()).m22067a(new ApprovedSubmittersViewModule(this)).m22065a().mo4610a(this);
    }

    public ApprovedSubmittersScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerApprovedSubmittersComponent.m29028a().m22066a(FrontpageApplication.m28875k()).m22067a(new ApprovedSubmittersViewModule(this)).m22065a().mo4610a(this);
    }

    public final Presenter mo7668w() {
        ApprovedSubmittersPresenter approvedSubmittersPresenter = this.f40584v;
        if (approvedSubmittersPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return approvedSubmittersPresenter;
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        super.mo7185a(actionBar);
        m37537h(Util.m24027f((int) C1761R.string.mod_tools_approved_submitters));
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_modtools_add) {
            return super.mo7201a(menuItem);
        }
        ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27453d)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20030B.f20068M)).m21889a(m40781y(), mo7383a())).m21891a();
        Screen g = Nav.m22586g(m40781y(), mo7383a());
        Screen screen = this;
        g.m29363b(screen);
        Routing.m22623a(screen, g);
        return true;
    }

    public final void mo7669x() {
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        ModUsersOptionsScreen modUsersOptionsScreen = new ModUsersOptionsScreen((Context) am_, C1761R.layout.approved_submitters_options);
        modUsersOptionsScreen.m38959a((BaseScreen) this);
        modUsersOptionsScreen.show();
    }

    public final void onEventMainThread(ModUsersOptionsAction modUsersOptionsAction) {
        Intrinsics.m26847b(modUsersOptionsAction, "event");
        EventBus.getDefault().removeStickyEvent((Object) modUsersOptionsAction);
        switch (WhenMappings.f20873a[modUsersOptionsAction.ordinal()]) {
            case 1:
                Routing.m22623a((Screen) this, Nav.m22588h(mo7386b().f20859b.getUsername()));
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
                com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23295a((Context) am_, mo7386b().f20859b.getUsername(), C1761R.string.mod_tools_action_remove, C1761R.string.mod_tools_action_unapprove_content, C1761R.string.mod_tools_option_remove, (Function2) new ApprovedSubmittersScreen$onEventMainThread$1(this), true).m23323a();
                break;
            default:
                break;
        }
    }
}
