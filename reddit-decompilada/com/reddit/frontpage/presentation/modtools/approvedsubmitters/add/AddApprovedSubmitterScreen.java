package com.reddit.frontpage.presentation.modtools.approvedsubmitters.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.OnTextChanged;
import com.bluelinelabs.conductor.Controller;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerAddApprovedSubmitterComponent;
import com.reddit.frontpage.di.module.AddApprovedSubmitterViewModule;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.modtools.ModAddUserTarget;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.add.AddApprovedSubmitterContract.View;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u000205H\u0007J\b\u00106\u001a\u00020$H\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00068"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "menuItem", "Landroid/view/MenuItem;", "presenter", "Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterPresenter;)V", "subredditId", "", "getSubredditId", "()Ljava/lang/String;", "setSubredditId", "(Ljava/lang/String;)V", "subredditName", "getSubredditName", "setSubredditName", "username", "Landroid/widget/EditText;", "getUsername", "()Landroid/widget/EditText;", "setUsername", "(Landroid/widget/EditText;)V", "getDefaultScreenPosition", "", "getLayoutId", "isFormValid", "", "onAddApproveSubmitterError", "", "errorMessage", "onAddApproveSubmitterSuccess", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onOptionsItemSelected", "item", "onUsernameTextChanged", "textChanged", "", "updateMenuButton", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AddApprovedSubmitterScreen.kt */
public final class AddApprovedSubmitterScreen extends MvpBaseScreen implements View {
    public static final Companion f40079w = new Companion();
    @State
    public String subredditId;
    @State
    public String subredditName;
    @BindView
    public EditText username;
    @Inject
    public AddApprovedSubmitterPresenter f40080v;
    private MenuItem f40081x;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/approvedsubmitters/add/AddApprovedSubmitterScreen;", "subredditId", "", "subredditName", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: AddApprovedSubmitterScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static AddApprovedSubmitterScreen m23091a(String str, String str2) {
            Intrinsics.m26847b(str, "subredditId");
            Intrinsics.m26847b(str2, "subredditName");
            AddApprovedSubmitterScreen addApprovedSubmitterScreen = new AddApprovedSubmitterScreen();
            Intrinsics.m26847b(str, "<set-?>");
            addApprovedSubmitterScreen.subredditId = str;
            Intrinsics.m26847b(str2, "<set-?>");
            addApprovedSubmitterScreen.subredditName = str2;
            return addApprovedSubmitterScreen;
        }
    }

    public static final AddApprovedSubmitterScreen m40727a(String str, String str2) {
        return Companion.m23091a(str, str2);
    }

    public final int mo7141s() {
        return C1761R.layout.screen_add_approved_submitter;
    }

    public final int mo7143u() {
        return 2;
    }

    public AddApprovedSubmitterScreen() {
        super();
        DaggerAddApprovedSubmitterComponent.m28992a().m22039a(FrontpageApplication.m28875k()).m22040a(new AddApprovedSubmitterViewModule(this)).m22038a().mo4580a(this);
    }

    public AddApprovedSubmitterScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerAddApprovedSubmitterComponent.m28992a().m22039a(FrontpageApplication.m28875k()).m22040a(new AddApprovedSubmitterViewModule(this)).m22038a().mo4580a(this);
    }

    public final String mo7373a() {
        String str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        return str;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    public final void m40730a(Menu menu, MenuInflater menuInflater) {
        Intrinsics.m26847b(menu, "menu");
        Intrinsics.m26847b(menuInflater, "inflater");
        super.a(menu, menuInflater);
        menuInflater.inflate(C1761R.menu.menu_modtools_add_user, menu);
        Object findItem = menu.findItem(C1761R.id.action_modtools_add);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_modtools_add)");
        this.f40081x = findItem;
    }

    public final boolean mo7201a(MenuItem menuItem) {
        Intrinsics.m26847b(menuItem, "item");
        if (menuItem.getItemId() != C1761R.id.action_modtools_add) {
            return super.mo7201a(menuItem);
        }
        ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27454e)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20067z.f20068M);
        String str = this.subredditId;
        if (str == null) {
            Intrinsics.m26844a("subredditId");
        }
        ((ModEventBuilder) modEventBuilder.m21889a(str, mo7373a())).m21891a();
        menuItem = this.f40080v;
        if (menuItem == null) {
            Intrinsics.m26844a("presenter");
        }
        EditText editText = this.username;
        if (editText == null) {
            Intrinsics.m26844a("username");
        }
        Object text = editText.getText();
        Intrinsics.m26843a(text, "username.text");
        menuItem.m34795a(StringsKt__StringsKt.m42456b((CharSequence) text).toString());
        return true;
    }

    public final void mo7374a(String str) {
        Intrinsics.m26847b(str, "username");
        m29351F();
        Controller k = k();
        if (k == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.modtools.ModAddUserTarget");
        }
        ((ModAddUserTarget) k).mo7384a(str, C1761R.string.mod_tools_action_approve_success);
    }

    public final void mo7375b(String str) {
        Intrinsics.m26847b(str, "errorMessage");
        str = Screens.m22629a(this, str, -1);
        if (str != null) {
            str.a();
        }
    }

    @OnTextChanged
    public final void onUsernameTextChanged(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "textChanged");
        charSequence = this.f40081x;
        if (charSequence == null) {
            Intrinsics.m26844a("menuItem");
        }
        EditText editText = this.username;
        if (editText == null) {
            Intrinsics.m26844a("username");
        }
        Object text = editText.getText();
        Intrinsics.m26843a(text, "username.text");
        charSequence.setEnabled(StringsKt__StringsKt.m42456b((CharSequence) text).length() > 0);
    }
}
