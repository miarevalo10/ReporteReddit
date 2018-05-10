package com.reddit.frontpage.presentation.profile.user;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerUserAccountComponent;
import com.reddit.frontpage.di.module.UserAccountViewModule;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.profile.trophies.TrophiesAdapter;
import com.reddit.frontpage.presentation.profile.user.UserAccountContract.View;
import com.reddit.frontpage.presentation.profile.user.model.UserAccountPresentationModel;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.profile.AccountStatsView;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006+"}, d2 = {"Lcom/reddit/frontpage/presentation/profile/user/UserAccountScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/profile/user/UserAccountContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "presenter", "Lcom/reddit/frontpage/presentation/profile/user/UserAccountPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/profile/user/UserAccountPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/profile/user/UserAccountPresenter;)V", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "username", "getUsername", "setUsername", "enableCreateChat", "", "enabled", "", "getAnalyticsScreenName", "getLayoutId", "", "launchChat", "onAttach", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "setAccount", "account", "Lcom/reddit/frontpage/presentation/profile/user/model/UserAccountPresentationModel;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserAccountScreen.kt */
public final class UserAccountScreen extends MvpBaseScreen implements View {
    public static final Companion f40134w = new Companion();
    @State
    String userId;
    @State
    String username;
    @Inject
    public UserAccountPresenter f40135v;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/profile/user/UserAccountScreen$Companion;", "", "()V", "ANALYTICS_SCREEN_NAME", "", "newInstance", "Lcom/reddit/frontpage/presentation/profile/user/UserAccountScreen;", "username", "userId", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: UserAccountScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static UserAccountScreen m23182a(String str, String str2) {
            Intrinsics.m26847b(str, "username");
            UserAccountScreen userAccountScreen = new UserAccountScreen();
            userAccountScreen.username = str;
            userAccountScreen.userId = str2;
            return userAccountScreen;
        }
    }

    public static final UserAccountScreen m40890a(String str, String str2) {
        return Companion.m23182a(str, str2);
    }

    public final String getAnalyticsScreenName() {
        return "profile_about";
    }

    public final int mo7141s() {
        return C1761R.layout.profile_account;
    }

    public UserAccountScreen() {
        super();
        DaggerUserAccountComponent.m29289a().m22170a(FrontpageApplication.m28875k()).m22171a(new UserAccountViewModule(this)).m22172a().mo4746a(this);
    }

    public UserAccountScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerUserAccountComponent.m29289a().m22170a(FrontpageApplication.m28875k()).m22171a(new UserAccountViewModule(this)).m22172a().mo4746a(this);
    }

    public final String mo7419a() {
        return this.username;
    }

    public final String mo7423b() {
        return this.userId;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        Object a = super.mo7139a(layoutInflater, viewGroup);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        RecyclerView recyclerView = (RecyclerView) obj.findViewById(C1761R.id.trophies_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(am_()));
        recyclerView.setAdapter(new TrophiesAdapter());
        Intrinsics.m26843a(a, "view");
        return a;
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40135v;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40135v;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final void mo7420a(UserAccountPresentationModel userAccountPresentationModel) {
        Intrinsics.m26847b(userAccountPresentationModel, "account");
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        ((AccountStatsView) obj.findViewById(C1761R.id.user_stats_view)).m30526a(userAccountPresentationModel);
        obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (TextView) obj.findViewById(C1761R.id.description);
        Intrinsics.m26843a(obj, "rootView.description");
        obj.setText(userAccountPresentationModel.f20963c);
        obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (TextView) obj.findViewById(C1761R.id.description);
        Intrinsics.m26843a(obj, "rootView.description");
        ViewsKt.m24106b((android.view.View) obj, StringsKt__StringsJVMKt.m41943a((CharSequence) userAccountPresentationModel.f20963c) ^ 1);
        obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        TextView textView = (TextView) obj.findViewById(C1761R.id.pm_button);
        android.view.View view = textView;
        ViewsKt.m24107c(view);
        view.setOnClickListener(new UserAccountScreen$inlined$sam$OnClickListener$i$7f478c20(new UserAccountScreen$setAccount$$inlined$apply$lambda$1(this)));
        Context context = textView.getContext();
        Intrinsics.m26843a((Object) context, "context");
        ColorStateList h = ResourcesUtil.m22738h(context, (int) C1761R.attr.rdt_action_icon_color);
        if (h == null) {
            Intrinsics.m26842a();
        }
        TextViewsKt.m24096a(textView, h);
        obj = FrontpageSettings.a();
        Intrinsics.m26843a(obj, "FrontpageSettings.getInstance()");
        if (obj.l()) {
            obj = this.K;
            Intrinsics.m26843a(obj, "rootView");
            textView = (TextView) obj.findViewById(C1761R.id.chat_message_button);
            view = textView;
            ViewsKt.m24107c(view);
            view.setOnClickListener(new UserAccountScreen$inlined$sam$OnClickListener$i$7f478c20(new UserAccountScreen$setAccount$$inlined$apply$lambda$2(this)));
            context = textView.getContext();
            Intrinsics.m26843a((Object) context, "context");
            h = ResourcesUtil.m22738h(context, (int) C1761R.attr.rdt_action_icon_color);
            if (h == null) {
                Intrinsics.m26842a();
            }
            TextViewsKt.m24096a(textView, h);
        } else {
            obj = this.K;
            Intrinsics.m26843a(obj, "rootView");
            obj = (TextView) obj.findViewById(C1761R.id.chat_message_button);
            Intrinsics.m26843a(obj, "rootView.chat_message_button");
            ViewsKt.m24103a((android.view.View) obj, false);
        }
        obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (RecyclerView) obj.findViewById(C1761R.id.trophies_list);
        Intrinsics.m26843a(obj, "rootView.trophies_list");
        Adapter adapter = obj.getAdapter();
        if (adapter == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.presentation.profile.trophies.TrophiesAdapter");
        }
        TrophiesAdapter trophiesAdapter = (TrophiesAdapter) adapter;
        trophiesAdapter.f28741a = userAccountPresentationModel.f20964d;
        trophiesAdapter.e();
    }

    public final void mo7421a(String str) {
        Intrinsics.m26847b(str, "userId");
        String d = SessionUtil.m23898d();
        if (d != null) {
            if (!TextUtils.isEmpty(str)) {
                m29359a((Screen) Nav.m22598k(str, this.username));
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Error invoking one on one messaging. Account is null:");
        stringBuilder.append(d == null);
        stringBuilder.append(". UserId is empty: ");
        stringBuilder.append(TextUtils.isEmpty(str));
        Timber.e(stringBuilder.toString(), new Object[0]);
    }

    public final void mo7422a(boolean z) {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        obj = (TextView) obj.findViewById(C1761R.id.chat_message_button);
        Intrinsics.m26843a(obj, "rootView.chat_message_button");
        obj.setEnabled(z);
    }
}
