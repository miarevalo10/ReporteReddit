package com.reddit.frontpage.presentation.modtools.actions;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import butterknife.BindView;
import com.evernote.android.state.State;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.di.component.DaggerModToolsActionsComponent;
import com.reddit.frontpage.di.module.ModToolsActionsViewModule;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.modtools.actions.ModToolsActionsContract.View;
import com.reddit.frontpage.presentation.modtools.util.ModToolsAction;
import com.reddit.frontpage.ui.listing.DividerItemDecoration;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000bH\u0016J*\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0/2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\b\u00100\u001a\u00020 H\u0002R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0007\u001a\u00020\b8\u0016@\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u00062"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsContract$View;", "()V", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "excludeValues", "", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "(Lcom/reddit/frontpage/domain/model/Subreddit;Ljava/util/List;)V", "adapter", "Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsAdapter;", "presenter", "Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsPresenter;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getSubreddit", "()Lcom/reddit/frontpage/domain/model/Subreddit;", "setSubreddit", "(Lcom/reddit/frontpage/domain/model/Subreddit;)V", "configureActionBar", "", "actionBar", "Landroid/support/v7/app/ActionBar;", "getLayoutId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onItemClicked", "modAction", "prepareMenuItems", "actions", "", "sendModMailAnalytics", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsActionsScreen.kt */
public final class ModToolsActionsScreen extends MvpBaseScreen implements View {
    public static final Companion f40076w = new Companion();
    @BindView
    public RecyclerView recyclerView;
    @State
    public Subreddit subreddit;
    @Inject
    public ModToolsActionsPresenter f40077v;
    private ModToolsAdapter f40078x;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsScreen$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsActionsScreen;", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "excludeValue", "", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModToolsActionsScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ModToolsActionsScreen m23082a(Subreddit subreddit) {
            Intrinsics.m26847b(subreddit, "subreddit");
            ModToolsActionsScreen modToolsActionsScreen = new ModToolsActionsScreen();
            modToolsActionsScreen.m40723a(subreddit);
            modToolsActionsScreen.f40078x = new ModToolsAdapter(new ModToolsActionsScreen$Companion$newInstance$1$1(modToolsActionsScreen), modToolsActionsScreen.m40717a((List) ArraysKt___ArraysKt.m36110j((Object[]) ModToolsAction.values()), CollectionsKt__CollectionsKt.m26790a()));
            return modToolsActionsScreen;
        }

        public static ModToolsActionsScreen m23083a(Subreddit subreddit, List<? extends ModToolsAction> list) {
            Intrinsics.m26847b(subreddit, "subreddit");
            Intrinsics.m26847b(list, "excludeValue");
            return new ModToolsActionsScreen(subreddit, list);
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20860a;

        static {
            int[] iArr = new int[ModToolsAction.values().length];
            f20860a = iArr;
            iArr[ModToolsAction.f20929e.ordinal()] = 1;
            f20860a[ModToolsAction.f20928d.ordinal()] = 2;
            f20860a[ModToolsAction.f20927c.ordinal()] = 3;
            f20860a[ModToolsAction.f20930f.ordinal()] = 4;
            f20860a[ModToolsAction.f20926b.ordinal()] = 5;
            f20860a[ModToolsAction.f20925a.ordinal()] = 6;
        }
    }

    public static final ModToolsActionsScreen m40715a(Subreddit subreddit, List<? extends ModToolsAction> list) {
        return Companion.m23083a(subreddit, list);
    }

    public static final ModToolsActionsScreen m40719b(Subreddit subreddit) {
        return Companion.m23082a(subreddit);
    }

    public final int mo7141s() {
        return C1761R.layout.screen_modtools_actions;
    }

    public ModToolsActionsScreen() {
        super();
        DaggerModToolsActionsComponent.m29183a().m22135a(FrontpageApplication.m28875k()).m22136a(new ModToolsActionsViewModule(this)).m22137a().mo4687a(this);
    }

    public ModToolsActionsScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
        DaggerModToolsActionsComponent.m29183a().m22135a(FrontpageApplication.m28875k()).m22136a(new ModToolsActionsViewModule(this)).m22137a().mo4687a(this);
    }

    public ModToolsActionsScreen(Subreddit subreddit, List<? extends ModToolsAction> list) {
        Intrinsics.m26847b(subreddit, "subreddit");
        Intrinsics.m26847b(list, "excludeValues");
        this();
        m40723a(subreddit);
        this.f40078x = new ModToolsAdapter(new Function1<ModToolsAction, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                ModToolsAction modToolsAction = (ModToolsAction) obj;
                Intrinsics.m26847b(modToolsAction, "it");
                this.m40726w().m34793a(modToolsAction);
                return Unit.f25273a;
            }
        }, m40717a(ArraysKt___ArraysKt.m36110j((Object[]) ModToolsAction.values()), (List) list));
    }

    public final ModToolsActionsPresenter m40726w() {
        ModToolsActionsPresenter modToolsActionsPresenter = this.f40077v;
        if (modToolsActionsPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return modToolsActionsPresenter;
    }

    private Subreddit m40720x() {
        Subreddit subreddit = this.subreddit;
        if (subreddit == null) {
            Intrinsics.m26844a("subreddit");
        }
        return subreddit;
    }

    public final void m40723a(Subreddit subreddit) {
        Intrinsics.m26847b(subreddit, "<set-?>");
        this.subreddit = subreddit;
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        super.mo7139a(layoutInflater, viewGroup);
        layoutInflater = new LinearLayoutManager(am_());
        viewGroup = this.recyclerView;
        if (viewGroup == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup.setLayoutManager((LayoutManager) layoutInflater);
        layoutInflater = this.recyclerView;
        if (layoutInflater == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup = this.f40078x;
        if (viewGroup == null) {
            Intrinsics.m26844a("adapter");
        }
        layoutInflater.setAdapter((Adapter) viewGroup);
        layoutInflater = am_();
        if (layoutInflater == null) {
            Intrinsics.m26842a();
        }
        layoutInflater = DividerItemDecoration.m30092a((Context) layoutInflater, 1);
        viewGroup = this.recyclerView;
        if (viewGroup == null) {
            Intrinsics.m26844a("recyclerView");
        }
        viewGroup.addItemDecoration((ItemDecoration) layoutInflater);
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return obj;
    }

    protected final void mo7185a(ActionBar actionBar) {
        Intrinsics.m26847b(actionBar, "actionBar");
        super.mo7185a(actionBar);
        m37537h(Util.m24027f((int) C1761R.string.action_mod_tools));
    }

    public final void mo7372a(ModToolsAction modToolsAction) {
        Intrinsics.m26847b(modToolsAction, "modAction");
        switch (WhenMappings.f20860a[modToolsAction.ordinal()]) {
            case 1:
                m29359a((Screen) Nav.m22576d(m40720x().getId(), m40720x().getDisplayName()));
                return;
            case 2:
                m29359a((Screen) Nav.m22580e(m40720x().getId(), m40720x().getDisplayName()));
                return;
            case 3:
                m29359a((Screen) Nav.m22572c(m40720x().getId(), m40720x().getDisplayName()));
                return;
            case 4:
                m29359a((Screen) Nav.m22592i(m40720x().getId(), m40720x().getDisplayName()));
                return;
            case 5:
                ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a(ModEventBuilder.f27457h)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20040L.f20068M)).m21889a(m40720x().getKindWithId(), m40720x().getDisplayName())).m21891a();
                if (m40720x().getNewModMailEnabled() != null) {
                    modToolsAction = m40720x().getNewModMailEnabled();
                    if (modToolsAction == null) {
                        Intrinsics.m26842a();
                    }
                    if (modToolsAction.booleanValue() != null) {
                        a(IntentUtil.m23762b((Context) am_(), Util.m24027f((int) C1761R.string.mod_mail_url), Util.m23950a((int) C1761R.color.rdt_alien_blue)));
                        return;
                    }
                }
                m29359a((Screen) Nav.m22605p(m40720x().getKeyColor()));
                return;
            case 6:
                Screen screen = this;
                if (!ModUtil.m23834b(screen)) {
                    ModUtil.m23835c();
                }
                if (ModUtil.m23831a(screen) == null) {
                    ModUtil.m23832b();
                }
                m29359a((Screen) Nav.m22571c(m40720x().getDisplayName()));
                break;
            default:
                break;
        }
    }

    private final List<ModToolsAction> m40717a(List<ModToolsAction> list, List<? extends ModToolsAction> list2) {
        for (Object obj : list) {
            if (Intrinsics.m26845a(obj, ModToolsAction.f20926b) && m40720x().getNewModMailEnabled() != null) {
                Boolean newModMailEnabled = m40720x().getNewModMailEnabled();
                if (newModMailEnabled == null) {
                    Intrinsics.m26842a();
                }
                if (newModMailEnabled.booleanValue()) {
                    obj.mo4913a(C1761R.string.mod_tools_mod_mail_beta);
                }
            }
            if (Intrinsics.m26845a(obj, ModToolsAction.f20926b)) {
                obj.mo4913a(C1761R.string.mod_tools_mod_mail);
            }
        }
        for (ModToolsAction remove : list2) {
            list.remove(remove);
        }
        return list;
    }
}
