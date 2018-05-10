package com.reddit.frontpage.presentation.subreddit.rules.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.model.SubredditRule;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerSubredditRulesComponent;
import com.reddit.frontpage.di.component.SubredditRulesComponent.Builder;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.presentation.subreddit.rules.SubredditRulesContract.Parameters;
import com.reddit.frontpage.presentation.subreddit.rules.SubredditRulesContract.View;
import com.reddit.frontpage.presentation.subreddit.rules.presenter.SubredditRulesPresenter;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.LazyKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020,H\u0016J\u0016\u00101\u001a\u0002022\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0016J\u0010\u00107\u001a\u0002022\u0006\u00108\u001a\u000209H\u0014J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\b\u0010=\u001a\u000202H\u0016J\b\u0010>\u001a\u000202H\u0016J\b\u0010?\u001a\u000202H\u0016J\u0018\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u000202H\u0016J\u0010\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020\u001cH\u0016J\b\u0010H\u001a\u000202H\u0014J\b\u0010I\u001a\u000202H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006K"}, d2 = {"Lcom/reddit/frontpage/presentation/subreddit/rules/view/SubredditRulesScreen;", "Lcom/reddit/frontpage/ui/BaseScreen;", "Lcom/reddit/frontpage/presentation/subreddit/rules/SubredditRulesContract$View;", "()V", "adapter", "Lcom/reddit/frontpage/presentation/subreddit/rules/view/SubredditRulesAdapter;", "content", "Landroid/widget/FrameLayout;", "getContent", "()Landroid/widget/FrameLayout;", "content$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "description", "Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "getDescription", "()Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "description$delegate", "descriptionContainer", "Landroid/widget/ScrollView;", "getDescriptionContainer", "()Landroid/widget/ScrollView;", "descriptionContainer$delegate", "info", "Landroid/widget/TextView;", "getInfo", "()Landroid/widget/TextView;", "info$delegate", "loadingSnoo", "Landroid/view/View;", "getLoadingSnoo", "()Landroid/view/View;", "loadingSnoo$delegate", "presenter", "Lcom/reddit/frontpage/presentation/subreddit/rules/presenter/SubredditRulesPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/subreddit/rules/presenter/SubredditRulesPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/subreddit/rules/presenter/SubredditRulesPresenter;)V", "rulesList", "Landroid/support/v7/widget/RecyclerView;", "getRulesList", "()Landroid/support/v7/widget/RecyclerView;", "rulesList$delegate", "subredditName", "", "getSubredditName", "()Ljava/lang/String;", "setSubredditName", "(Ljava/lang/String;)V", "bind", "", "descriptionHtml", "rules", "", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRule;", "configureActionBar", "actionBar", "Landroid/support/v7/app/ActionBar;", "getDefaultScreenPosition", "", "getLayoutId", "hideLoading", "notifyNoRules", "notifyUnableLoadRules", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "view", "onInitialize", "showLoading", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditRulesScreen.kt */
public final class SubredditRulesScreen extends BaseScreen implements View {
    static final /* synthetic */ KProperty[] f39110v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SubredditRulesScreen.class), "content", "getContent()Landroid/widget/FrameLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SubredditRulesScreen.class), "description", "getDescription()Lcom/reddit/frontpage/widgets/BaseHtmlTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SubredditRulesScreen.class), "descriptionContainer", "getDescriptionContainer()Landroid/widget/ScrollView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SubredditRulesScreen.class), "rulesList", "getRulesList()Landroid/support/v7/widget/RecyclerView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SubredditRulesScreen.class), "info", "getInfo()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SubredditRulesScreen.class), "loadingSnoo", "getLoadingSnoo()Landroid/view/View;"))};
    public static final Companion f39111x = new Companion();
    private final InvalidatableLazy f39112A = LazyKt.m24085a((BaseScreen) this, (Function0) new SubredditRulesScreen$descriptionContainer$2(this));
    private final InvalidatableLazy f39113B = LazyKt.m24085a((BaseScreen) this, (Function0) new SubredditRulesScreen$rulesList$2(this));
    private final InvalidatableLazy f39114C = LazyKt.m24085a((BaseScreen) this, (Function0) new SubredditRulesScreen$info$2(this));
    private final InvalidatableLazy f39115D = LazyKt.m24085a((BaseScreen) this, (Function0) new SubredditRulesScreen$loadingSnoo$2(this));
    private SubredditRulesAdapter f39116E;
    @State
    public String subredditName;
    @Inject
    public SubredditRulesPresenter f39117w;
    private final InvalidatableLazy f39118y = LazyKt.m24085a((BaseScreen) this, (Function0) new SubredditRulesScreen$content$2(this));
    private final InvalidatableLazy f39119z = LazyKt.m24085a((BaseScreen) this, (Function0) new SubredditRulesScreen$description$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/subreddit/rules/view/SubredditRulesScreen$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/subreddit/rules/view/SubredditRulesScreen;", "subredditName", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SubredditRulesScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static SubredditRulesScreen m23201a(String str) {
            Intrinsics.m26847b(str, "subredditName");
            SubredditRulesScreen subredditRulesScreen = new SubredditRulesScreen();
            Intrinsics.m26847b(str, "<set-?>");
            subredditRulesScreen.subredditName = str;
            return subredditRulesScreen;
        }
    }

    private final android.view.View m38961O() {
        return (android.view.View) this.f39115D.mo5678b();
    }

    public static final SubredditRulesScreen m38963b(String str) {
        return Companion.m23201a(str);
    }

    private final FrameLayout m38964w() {
        return (FrameLayout) this.f39118y.mo5678b();
    }

    private final RecyclerView m38965x() {
        return (RecyclerView) this.f39113B.mo5678b();
    }

    private final TextView m38966y() {
        return (TextView) this.f39114C.mo5678b();
    }

    public final int mo7141s() {
        return C1761R.layout.screen_subreddit_rules;
    }

    public final int mo7143u() {
        return 2;
    }

    protected final void mo7142t() {
        super.mo7142t();
        Builder a = DaggerSubredditRulesComponent.m29279a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        a = a.mo4736a(k).mo4738a((View) this);
        String str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        a.mo4737a(new Parameters(str)).mo4739a().mo4740a(this);
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        n();
        this.f39116E = new SubredditRulesAdapter();
        layoutInflater = am_();
        if (layoutInflater == null) {
            Intrinsics.m26842a();
        }
        m38965x().addItemDecoration(DividerItemDecoration.m30092a((Context) layoutInflater, 1));
        m38965x().setLayoutManager((LayoutManager) new LinearLayoutManager(am_(), 1, false));
        layoutInflater = m38965x();
        viewGroup = this.f39116E;
        if (viewGroup == null) {
            Intrinsics.m26844a("adapter");
        }
        layoutInflater.setAdapter((Adapter) viewGroup);
        m38961O().setBackground(AnimUtil.m23637a(am_()));
        layoutInflater = this.f39117w;
        if (layoutInflater == null) {
            Intrinsics.m26844a("presenter");
        }
        layoutInflater.attach();
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        StringBuilder stringBuilder = new StringBuilder();
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Object[] objArr = new Object[1];
        String str = this.subredditName;
        if (str == null) {
            Intrinsics.m26844a("subredditName");
        }
        objArr[0] = str;
        stringBuilder.append(am_.getString(C1761R.string.fmt_r_name, objArr));
        stringBuilder.append(" rules");
        actionBar.a(stringBuilder.toString());
    }

    public final void mo7191l() {
        super.mo7191l();
        SubredditRulesPresenter subredditRulesPresenter = this.f39117w;
        if (subredditRulesPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        subredditRulesPresenter.detach();
    }

    public final void mo7187a(List<SubredditRule> list) {
        Intrinsics.m26847b(list, "rules");
        ViewsKt.m24107c(m38964w());
        ViewsKt.m24107c(m38965x());
        SubredditRulesAdapter subredditRulesAdapter = this.f39116E;
        if (subredditRulesAdapter == null) {
            Intrinsics.m26844a("adapter");
        }
        Intrinsics.m26847b(list, "<set-?>");
        subredditRulesAdapter.f28799b.m30902a(subredditRulesAdapter, SubredditRulesAdapter.f28798a[0], list);
    }

    public final void mo7186a(String str) {
        Intrinsics.m26847b(str, "descriptionHtml");
        ViewsKt.m24107c(m38964w());
        ViewsKt.m24107c((ScrollView) this.f39112A.mo5678b());
        ((BaseHtmlTextView) this.f39119z.mo5678b()).setHtmlFromString(str);
    }

    public final void mo7184a() {
        ViewsKt.m24107c(m38966y());
        TextView y = m38966y();
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        y.setText(am_.getString(C1761R.string.error_data_load));
    }

    public final void mo7188b() {
        ViewsKt.m24107c(m38966y());
        TextView y = m38966y();
        Activity am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        y.setText(am_.getString(C1761R.string.label_empty));
    }

    public final void mo7189c() {
        ViewsKt.m24107c(m38961O());
    }

    public final void mo7190d() {
        ViewsKt.m24109d(m38961O());
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        this.I.m24081a();
    }
}
