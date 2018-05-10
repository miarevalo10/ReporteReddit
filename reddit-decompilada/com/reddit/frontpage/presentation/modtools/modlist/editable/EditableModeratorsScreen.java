package com.reddit.frontpage.presentation.modtools.modlist.editable;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import com.reddit.datalibrary.frontpage.data.model.ModToolsUserModel;
import com.reddit.datalibrary.frontpage.data.model.Moderator;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerEditableModeratorsComponent;
import com.reddit.frontpage.di.module.EditableModeratorsViewModule;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.modtools.adapter.ModAdapterMode;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.Presenter;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsScreen;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions.ModUsersOptionsScreen;
import com.reddit.frontpage.presentation.modtools.modlist.ModeratorListTarget;
import com.reddit.frontpage.presentation.modtools.util.ModUsersOptionsAction;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.alert.RedditAlertDialog;
import de.greenrobot.event.EventBus;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/editable/EditableModeratorsScreen;", "Lcom/reddit/frontpage/presentation/modtools/modlist/ModeratorListTarget;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsScreen;", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "moderatorPresenter", "Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "getModeratorPresenter", "()Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsContract$Presenter;", "presenter", "Lcom/reddit/frontpage/presentation/modtools/modlist/editable/EditableModeratorsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/modlist/editable/EditableModeratorsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/modlist/editable/EditableModeratorsPresenter;)V", "getAdapterMode", "Lcom/reddit/frontpage/presentation/modtools/adapter/ModAdapterMode;", "getLayoutId", "", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onEventMainThread", "event", "Lcom/reddit/frontpage/presentation/modtools/util/ModUsersOptionsAction;", "onModEdited", "username", "", "showOptions", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: EditableModeratorsScreen.kt */
public final class EditableModeratorsScreen extends BaseModeratorsScreen implements View, ModeratorListTarget {
    public static final Companion f40589w = new Companion();
    @Inject
    public EditableModeratorsPresenter f40590v;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/modlist/editable/EditableModeratorsScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/modlist/editable/EditableModeratorsScreen;", "subredditId", "", "subredditName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: EditableModeratorsScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static EditableModeratorsScreen m23127a(String str, String str2) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            EditableModeratorsScreen editableModeratorsScreen = new EditableModeratorsScreen();
            editableModeratorsScreen.m40774b(str);
            editableModeratorsScreen.mo7241c(str2);
            return editableModeratorsScreen;
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20910a;

        static {
            int[] iArr = new int[ModUsersOptionsAction.values().length];
            f20910a = iArr;
            iArr[ModUsersOptionsAction.f20932a.ordinal()] = 1;
            f20910a[ModUsersOptionsAction.f20933b.ordinal()] = 2;
            f20910a[ModUsersOptionsAction.f20934c.ordinal()] = 3;
        }
    }

    public final void mo7673a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
    }

    public final int mo7141s() {
        return C1761R.layout.screen_moderators;
    }

    public EditableModeratorsScreen() {
        DaggerEditableModeratorsComponent.m29112a().m22097a(FrontpageApplication.m28875k()).m22098a(new EditableModeratorsViewModule(this)).m22099a().mo4652a(this);
    }

    public EditableModeratorsScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerEditableModeratorsComponent.m29112a().m22097a(FrontpageApplication.m28875k()).m22098a(new EditableModeratorsViewModule(this)).m22099a().mo4652a(this);
    }

    protected final ModAdapterMode mo7670O() {
        return ModAdapterMode.f20865c;
    }

    public final Presenter mo7668w() {
        EditableModeratorsPresenter editableModeratorsPresenter = this.f40590v;
        if (editableModeratorsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return editableModeratorsPresenter;
    }

    public final void mo7669x() {
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        ModUsersOptionsScreen modUsersOptionsScreen = new ModUsersOptionsScreen((Context) am_, C1761R.layout.moderators_options);
        modUsersOptionsScreen.m38959a((BaseScreen) this);
        modUsersOptionsScreen.show();
    }

    public final void onEventMainThread(ModUsersOptionsAction modUsersOptionsAction) {
        Intrinsics.m26847b(modUsersOptionsAction, "event");
        EventBus.getDefault().removeStickyEvent((Object) modUsersOptionsAction);
        switch (WhenMappings.f20910a[modUsersOptionsAction.ordinal()]) {
            case 1:
                ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27455f)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20033E.f20068M)).m21889a(m40781y(), mo7383a())).m21891a();
                String y = m40781y();
                String a = mo7383a();
                ModToolsUserModel modToolsUserModel = mo7386b().f20859b;
                if (modToolsUserModel == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.data.model.Moderator");
                }
                Screen a2 = Nav.m22554a(y, a, (Moderator) modToolsUserModel);
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
                com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion.m23295a((Context) am_, mo7386b().f20859b.getUsername(), C1761R.string.mod_tools_action_remove, C1761R.string.mod_tools_action_remove_moderator_content, C1761R.string.mod_tools_option_remove, (Function2) new EditableModeratorsScreen$onEventMainThread$1(this), false).m23323a();
                break;
            default:
                break;
        }
    }

    public final void mo7675a(String str) {
        Intrinsics.m26847b(str, "username");
        mo7384a(str, (int) C1761R.string.mod_tools_action_edit_permissions_success);
    }
}
