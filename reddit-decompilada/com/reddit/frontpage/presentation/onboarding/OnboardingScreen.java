package com.reddit.frontpage.presentation.onboarding;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.evernote.android.state.State;
import com.reddit.config.GlideApp;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.PageType;
import com.reddit.frontpage.commons.analytics.events.v2.OnboardingEventBuilder.Source;
import com.reddit.frontpage.di.component.DaggerOnboardingViewComponent;
import com.reddit.frontpage.di.module.OnboardingViewModule;
import com.reddit.frontpage.domain.model.SubredditCategory;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.MvpBaseScreen;
import com.reddit.frontpage.presentation.common.LoopingDataSource;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.CenterLinearLayoutManager;
import com.reddit.frontpage.presentation.common.ui.UiUtil;
import com.reddit.frontpage.presentation.onboarding.OnboardingContract.View;
import com.reddit.frontpage.presentation.onboarding.OnboardingScreen$pageChangeListener$2.C26791;
import com.reddit.frontpage.presentation.onboarding.OnboardingScreen$tabListener$2.C23161;
import com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen;
import com.reddit.frontpage.ui.BaseScreen;
import com.reddit.frontpage.ui.listing.adapter.ScreenPagerAdapter;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import com.reddit.frontpage.util.AnimUtil;
import com.reddit.frontpage.util.BundlerSetString;
import com.reddit.frontpage.util.kotlin.InvalidatableLazy;
import com.reddit.frontpage.util.kotlin.LazyKt;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0014*\u0002b$\u0018\u0000 ¢\u00012\u00020\u00012\u00020\u0002:\b¡\u0001¢\u0001£\u0001¤\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010n\u001a\u00020oH\u0002J\b\u0010p\u001a\u00020oH\u0016J\b\u0010q\u001a\u00020oH\u0016J\b\u0010r\u001a\u00020;H\u0016J\b\u0010s\u001a\u00020;H\u0016J\u0018\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020yH\u0002J\b\u0010z\u001a\u00020AH\u0016J\u0018\u0010{\u001a\u00020u2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020yH\u0002J\b\u0010|\u001a\u00020AH\u0016J\b\u0010}\u001a\u00020oH\u0016J\b\u0010~\u001a\u00020oH\u0016J\u0010\u0010\u001a\u00020o2\u0006\u0010x\u001a\u00020yH\u0016J\u0012\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00020\u001fH\u0014J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00020AH\u0002J\u001c\u0010\u0001\u001a\u00020\u001f2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020NH\u0016J\t\u0010\u0001\u001a\u00020oH\u0016J\u0012\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00020\u001fH\u0014J\t\u0010\u0001\u001a\u00020oH\u0014J\t\u0010\u0001\u001a\u00020oH\u0002J\u0019\u0010\u0001\u001a\u00020o2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020y0\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00020AH\u0016J\u001b\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020AH\u0016J\t\u0010\u0001\u001a\u00020oH\u0016J\t\u0010\u0001\u001a\u00020oH\u0016J\t\u0010\u0001\u001a\u00020oH\u0002J\t\u0010\u0001\u001a\u00020oH\u0016J\t\u0010\u0001\u001a\u00020oH\u0016J\t\u0010\u0001\u001a\u00020oH\u0002J\u0014\u0010\u0001\u001a\u00020o2\t\u0010\u0001\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00020AH\u0002J\u001a\u0010\u0001\u001a\u00020o2\u0006\u0010x\u001a\u00020y2\u0007\u0010 \u0001\u001a\u00020AH\u0016R\u001f\u0010\u0004\u001a\u00060\u0005R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u0010/\u001a\u0002008BX\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0002¢\u0006\f\n\u0004\b8\u0010\t\u001a\u0004\b6\u00107R$\u00109\u001a\b\u0012\u0004\u0012\u00020;0:8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010@\u001a\u00020A8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bB\u0010\u0003\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001b\u0010G\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\bI\u0010\t\u001a\u0004\bH\u0010\u0012R\u001b\u0010J\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\bL\u0010\t\u001a\u0004\bK\u0010\u0017R\u001b\u0010M\u001a\u00020N8BX\u0002¢\u0006\f\n\u0004\bQ\u0010\t\u001a\u0004\bO\u0010PR\u001b\u0010R\u001a\u00020S8BX\u0002¢\u0006\f\n\u0004\bV\u0010\t\u001a\u0004\bT\u0010UR\u001f\u0010W\u001a\u00060XR\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b[\u0010\t\u001a\u0004\bY\u0010ZR\u001b\u0010\\\u001a\u00020]8BX\u0002¢\u0006\f\n\u0004\b`\u0010\t\u001a\u0004\b^\u0010_R\u001b\u0010a\u001a\u00020b8BX\u0002¢\u0006\f\n\u0004\be\u0010(\u001a\u0004\bc\u0010dR\u001b\u0010f\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\bh\u0010\t\u001a\u0004\bg\u0010\u0017R\u001b\u0010i\u001a\u00020j8BX\u0002¢\u0006\f\n\u0004\bm\u0010\t\u001a\u0004\bk\u0010l¨\u0006¥\u0001"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen;", "Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingContract$View;", "()V", "categoryAdapter", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$CategoryPagerAdapter;", "getCategoryAdapter", "()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$CategoryPagerAdapter;", "categoryAdapter$delegate", "Lcom/reddit/frontpage/util/kotlin/InvalidatableLazy;", "categoryHeader", "Landroid/support/design/widget/AppBarLayout;", "getCategoryHeader", "()Landroid/support/design/widget/AppBarLayout;", "categoryHeader$delegate", "categoryName", "Landroid/widget/TextView;", "getCategoryName", "()Landroid/widget/TextView;", "categoryName$delegate", "doneButton", "Landroid/widget/Button;", "getDoneButton", "()Landroid/widget/Button;", "doneButton$delegate", "errorStubView", "Landroid/view/ViewStub;", "getErrorStubView", "()Landroid/view/ViewStub;", "errorStubView$delegate", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "loadingView$delegate", "pageChangeListener", "com/reddit/frontpage/presentation/onboarding/OnboardingScreen$pageChangeListener$2$1", "getPageChangeListener", "()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$pageChangeListener$2$1;", "pageChangeListener$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingPresenter;", "getPresenter", "()Lcom/reddit/frontpage/presentation/onboarding/OnboardingPresenter;", "setPresenter", "(Lcom/reddit/frontpage/presentation/onboarding/OnboardingPresenter;)V", "progressBar", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingProgressView;", "getProgressBar", "()Lcom/reddit/frontpage/presentation/onboarding/OnboardingProgressView;", "progressBar$delegate", "progressText", "Landroid/widget/TextSwitcher;", "getProgressText", "()Landroid/widget/TextSwitcher;", "progressText$delegate", "seenCategoryIds", "", "", "getSeenCategoryIds", "()Ljava/util/Set;", "setSeenCategoryIds", "(Ljava/util/Set;)V", "selectedTab", "", "selectedTab$annotations", "getSelectedTab", "()I", "setSelectedTab", "(I)V", "subredditCount", "getSubredditCount", "subredditCount$delegate", "subscribeAllButton", "getSubscribeAllButton", "subscribeAllButton$delegate", "subscribeAllContainer", "Landroid/view/ViewGroup;", "getSubscribeAllContainer", "()Landroid/view/ViewGroup;", "subscribeAllContainer$delegate", "subscribeAllProgressBar", "Landroid/widget/ProgressBar;", "getSubscribeAllProgressBar", "()Landroid/widget/ProgressBar;", "subscribeAllProgressBar$delegate", "tabAdapter", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapter;", "getTabAdapter", "()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapter;", "tabAdapter$delegate", "tabLayout", "Landroid/support/v7/widget/RecyclerView;", "getTabLayout", "()Landroid/support/v7/widget/RecyclerView;", "tabLayout$delegate", "tabListener", "com/reddit/frontpage/presentation/onboarding/OnboardingScreen$tabListener$2$1", "getTabListener", "()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$tabListener$2$1;", "tabListener$delegate", "unsubscribeAllButton", "getUnsubscribeAllButton", "unsubscribeAllButton$delegate", "viewPager", "Landroid/support/v4/view/ViewPager;", "getViewPager", "()Landroid/support/v4/view/ViewPager;", "viewPager$delegate", "addListeners", "", "close", "disableSubscribeAll", "getAnalyticsPageType", "getAnalyticsScreenName", "getButtonBackgroundTintList", "Landroid/content/res/ColorStateList;", "context", "Landroid/content/Context;", "category", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "getDefaultScreenPosition", "getIconBackgroundTintList", "getLayoutId", "hideLoading", "notifyCategoryLoadError", "notifySubredditCountLoadError", "onAttach", "view", "onBackPressed", "", "onCategorySelected", "position", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroy", "onDestroyView", "onDetach", "onInitialize", "removeListeners", "setCategories", "categories", "", "showDone", "requiredSubscriptions", "showInProgress", "subscriptions", "showLoading", "showSubscribeAll", "showSubscribeAllButton", "showSubscribeInProgress", "showUnsubscribeAll", "showUnsubscribeAllButton", "updateProgressText", "newText", "updateSelectedTab", "updateSubredditCount", "count", "CategoryPagerAdapter", "Companion", "TabAdapter", "TabAdapterViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingScreen.kt */
public final class OnboardingScreen extends MvpBaseScreen implements View {
    static final /* synthetic */ KProperty[] f40113v = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "progressText", "getProgressText()Landroid/widget/TextSwitcher;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "progressBar", "getProgressBar()Lcom/reddit/frontpage/presentation/onboarding/OnboardingProgressView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "doneButton", "getDoneButton()Landroid/widget/Button;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "loadingView", "getLoadingView()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "errorStubView", "getErrorStubView()Landroid/view/ViewStub;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "tabLayout", "getTabLayout()Landroid/support/v7/widget/RecyclerView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "viewPager", "getViewPager()Landroid/support/v4/view/ViewPager;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "categoryHeader", "getCategoryHeader()Landroid/support/design/widget/AppBarLayout;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "categoryName", "getCategoryName()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "subredditCount", "getSubredditCount()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "subscribeAllContainer", "getSubscribeAllContainer()Landroid/view/ViewGroup;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "subscribeAllButton", "getSubscribeAllButton()Landroid/widget/Button;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "unsubscribeAllButton", "getUnsubscribeAllButton()Landroid/widget/Button;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "subscribeAllProgressBar", "getSubscribeAllProgressBar()Landroid/widget/ProgressBar;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "categoryAdapter", "getCategoryAdapter()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$CategoryPagerAdapter;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "tabAdapter", "getTabAdapter()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapter;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "pageChangeListener", "getPageChangeListener()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$pageChangeListener$2$1;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingScreen.class), "tabListener", "getTabListener()Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$tabListener$2$1;"))};
    public static final Companion f40114x = new Companion();
    private final InvalidatableLazy f40115A = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$doneButton$2(this));
    private final InvalidatableLazy f40116B = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$loadingView$2(this));
    private final InvalidatableLazy f40117C = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$errorStubView$2(this));
    private final InvalidatableLazy f40118D = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$tabLayout$2(this));
    private final InvalidatableLazy f40119E = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$viewPager$2(this));
    private final InvalidatableLazy f40120F = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$categoryHeader$2(this));
    private final InvalidatableLazy f40121G = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$categoryName$2(this));
    private final InvalidatableLazy f40122H = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$subredditCount$2(this));
    private final InvalidatableLazy f40123M = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$subscribeAllContainer$2(this));
    private final InvalidatableLazy f40124N = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$subscribeAllButton$2(this));
    private final InvalidatableLazy f40125O = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$unsubscribeAllButton$2(this));
    private final InvalidatableLazy f40126P = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$subscribeAllProgressBar$2(this));
    private final InvalidatableLazy f40127Q = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$categoryAdapter$2(this));
    private final InvalidatableLazy f40128R = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$tabAdapter$2(this));
    private final Lazy f40129S = kotlin.LazyKt.m26777a(new OnboardingScreen$pageChangeListener$2(this));
    private final Lazy f40130T = kotlin.LazyKt.m26777a(new OnboardingScreen$tabListener$2(this));
    @State(BundlerSetString.class)
    Set<String> seenCategoryIds = new LinkedHashSet();
    @State
    int selectedTab = -2;
    @Inject
    public OnboardingPresenter f40131w;
    private final InvalidatableLazy f40132y = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$progressText$2(this));
    private final InvalidatableLazy f40133z = LazyKt.m24085a((BaseScreen) this, (Function0) new OnboardingScreen$progressBar$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$Companion;", "", "()V", "ANALYTICS_SCREEN_NAME", "", "VIEW_PAGER_OFF_SCREEN_PAGES", "", "newInstance", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static OnboardingScreen m23160a() {
            return new OnboardingScreen();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0016\u0010\u0019\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0018\u00010\u0002R\u00020\u0003H\u0016J\u0016\u0010\u001a\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0018\u00010\u0002R\u00020\u0003H\u0016R0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapterViewHolder;", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen;", "(Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen;)V", "value", "Lcom/reddit/frontpage/presentation/common/LoopingDataSource;", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "data", "getData", "()Lcom/reddit/frontpage/presentation/common/LoopingDataSource;", "setData", "(Lcom/reddit/frontpage/presentation/common/LoopingDataSource;)V", "getItemCount", "", "getItemId", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingScreen.kt */
    private final class TabAdapter extends Adapter<TabAdapterViewHolder> {
        LoopingDataSource<SubredditCategory> f28713a = new LoopingDataSource();
        final /* synthetic */ OnboardingScreen f28714b;

        public TabAdapter(OnboardingScreen onboardingScreen) {
            this.f28714b = onboardingScreen;
        }

        public final /* synthetic */ ViewHolder m29823a(ViewGroup viewGroup, int i) {
            Intrinsics.m26847b(viewGroup, "parent");
            return (ViewHolder) new TabAdapterViewHolder(this.f28714b, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.onboarding_category_tab_item, false));
        }

        public final /* synthetic */ void m29824a(ViewHolder viewHolder, int i) {
            TabAdapterViewHolder tabAdapterViewHolder = (TabAdapterViewHolder) viewHolder;
            Intrinsics.m26847b(tabAdapterViewHolder, "holder");
            Context context = tabAdapterViewHolder.f28715a.getContext();
            SubredditCategory subredditCategory = (SubredditCategory) this.f28713a.m22715a(i);
            GlideApp.a(context).b(subredditCategory.getIcon()).diskCacheStrategy(DiskCacheStrategy.a).placeholder(C1761R.drawable.ic_icon_snoo_home).into(tabAdapterViewHolder.f28715a);
            Intrinsics.m26843a((Object) context, "context");
            ViewCompat.a((android.view.View) tabAdapterViewHolder.f28715a, OnboardingScreen.m40856a(context, subredditCategory));
        }

        public final /* synthetic */ void m29825b(ViewHolder viewHolder) {
            TabAdapterViewHolder tabAdapterViewHolder = (TabAdapterViewHolder) viewHolder;
            if (tabAdapterViewHolder != null) {
                tabAdapterViewHolder.f28717p.getViewTreeObserver().addOnScrollChangedListener((OnScrollChangedListener) tabAdapterViewHolder.f28716b);
            }
        }

        public final /* synthetic */ void m29826c(ViewHolder viewHolder) {
            TabAdapterViewHolder tabAdapterViewHolder = (TabAdapterViewHolder) viewHolder;
            if (tabAdapterViewHolder != null) {
                tabAdapterViewHolder.f28717p.getViewTreeObserver().removeOnScrollChangedListener((OnScrollChangedListener) tabAdapterViewHolder.f28716b);
            }
        }

        public final int m29821a() {
            return this.f28713a.f20382a;
        }

        public final long m29822a(int i) {
            return (long) ((SubredditCategory) this.f28713a.m22715a(i)).getId().hashCode();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\n\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapterViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "root", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen;Landroid/view/View;)V", "icon", "Landroid/support/v7/widget/AppCompatImageView;", "getIcon", "()Landroid/support/v7/widget/AppCompatImageView;", "scrollListener", "com/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapterViewHolder$scrollListener$1", "Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$TabAdapterViewHolder$scrollListener$1;", "onAttached", "", "onDetached", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingScreen.kt */
    private final class TabAdapterViewHolder extends ViewHolder {
        final AppCompatImageView f28715a;
        final OnboardingScreen$TabAdapterViewHolder$scrollListener$1 f28716b = new OnboardingScreen$TabAdapterViewHolder$scrollListener$1(this);
        final android.view.View f28717p;
        final /* synthetic */ OnboardingScreen f28718q;

        public TabAdapterViewHolder(OnboardingScreen onboardingScreen, android.view.View view) {
            Intrinsics.m26847b(view, "root");
            this.f28718q = onboardingScreen;
            super(view);
            this.f28717p = view;
            Object findViewById = this.f28717p.findViewById(C1761R.id.category_icon);
            Intrinsics.m26843a(findViewById, "root.findViewById(R.id.category_icon)");
            this.f28715a = (AppCompatImageView) findViewById;
            this.f28717p.setOnClickListener(new C1866xfadf6837((Function1) new Function1<android.view.View, Unit>() {
                public final /* synthetic */ Object mo6492a(Object obj) {
                    this.f28718q.m40848S().smoothScrollToPosition(this.d());
                    return Unit.f25273a;
                }
            }));
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0014\u001a\u00020\u0010H\u0014R0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen$CategoryPagerAdapter;", "Lcom/reddit/frontpage/ui/listing/adapter/ScreenPagerAdapter;", "(Lcom/reddit/frontpage/presentation/onboarding/OnboardingScreen;)V", "value", "Lcom/reddit/frontpage/presentation/common/LoopingDataSource;", "Lcom/reddit/frontpage/domain/model/SubredditCategory;", "data", "getData", "()Lcom/reddit/frontpage/presentation/common/LoopingDataSource;", "setData", "(Lcom/reddit/frontpage/presentation/common/LoopingDataSource;)V", "configureScreen", "", "screen", "Lcom/reddit/frontpage/nav/Screen;", "position", "", "createScreen", "Lcom/reddit/frontpage/presentation/onboarding/listing/OnboardingListingScreen;", "getItem", "getScreenCount", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: OnboardingScreen.kt */
    private final class CategoryPagerAdapter extends ScreenPagerAdapter {
        LoopingDataSource<SubredditCategory> f36998d = new LoopingDataSource();
        final /* synthetic */ OnboardingScreen f36999e;

        public CategoryPagerAdapter(OnboardingScreen onboardingScreen) {
            this.f36999e = onboardingScreen;
            super(onboardingScreen, false);
        }

        protected final void mo6954a(Screen screen, int i) {
            if (((VisibilityDependent) (!(screen instanceof VisibilityDependent) ? null : screen)) != null) {
                if (i == this.f36999e.selectedTab) {
                    ((VisibilityDependent) screen).ap();
                    return;
                }
                ((VisibilityDependent) screen).aq();
            }
        }

        protected final int mo6955f() {
            return this.f36998d.f20382a;
        }

        public final SubredditCategory m37379c(int i) {
            return (SubredditCategory) this.f36998d.m22715a(i);
        }

        public final /* synthetic */ Screen mo6953a(int i) {
            SubredditCategory subredditCategory = (SubredditCategory) this.f36998d.m22715a(i);
            boolean add = this.f36999e.seenCategoryIds.add(subredditCategory.getId());
            com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen.Companion companion = OnboardingListingScreen.f40594y;
            return com.reddit.frontpage.presentation.onboarding.listing.OnboardingListingScreen.Companion.m23164a(subredditCategory, add);
        }
    }

    private final OnboardingProgressView m40844O() {
        return (OnboardingProgressView) this.f40133z.mo5678b();
    }

    private final Button m40845P() {
        return (Button) this.f40115A.mo5678b();
    }

    private final android.view.View m40846Q() {
        return (android.view.View) this.f40116B.mo5678b();
    }

    private final ViewStub m40847R() {
        return (ViewStub) this.f40117C.mo5678b();
    }

    private final RecyclerView m40848S() {
        return (RecyclerView) this.f40118D.mo5678b();
    }

    private final ViewPager m40849T() {
        return (ViewPager) this.f40119E.mo5678b();
    }

    private final TextView m40850U() {
        return (TextView) this.f40122H.mo5678b();
    }

    private final ViewGroup m40851V() {
        return (ViewGroup) this.f40123M.mo5678b();
    }

    private final Button m40852W() {
        return (Button) this.f40124N.mo5678b();
    }

    private final Button m40853X() {
        return (Button) this.f40125O.mo5678b();
    }

    private final ProgressBar m40854Y() {
        return (ProgressBar) this.f40126P.mo5678b();
    }

    private final CategoryPagerAdapter m40855Z() {
        return (CategoryPagerAdapter) this.f40127Q.mo5678b();
    }

    private final TabAdapter aa() {
        return (TabAdapter) this.f40128R.mo5678b();
    }

    private final C26791 ab() {
        return (C26791) this.f40129S.mo5678b();
    }

    private final C23161 ac() {
        return (C23161) this.f40130T.mo5678b();
    }

    public static final OnboardingScreen m40868x() {
        return Companion.m23160a();
    }

    private final TextSwitcher m40869y() {
        return (TextSwitcher) this.f40132y.mo5678b();
    }

    public final int mo7141s() {
        return C1761R.layout.onboarding_layout;
    }

    public final int mo7143u() {
        return 2;
    }

    public OnboardingScreen() {
        super();
    }

    public final OnboardingPresenter m40889w() {
        OnboardingPresenter onboardingPresenter = this.f40131w;
        if (onboardingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        return onboardingPresenter;
    }

    protected final void mo7142t() {
        super.mo7142t();
        DaggerOnboardingViewComponent.m29222a().m22152a(FrontpageApplication.m28875k()).m22153a(new OnboardingViewModule(this)).m22154a().mo4710a(this);
    }

    public final android.view.View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        Object a = super.mo7139a(layoutInflater, viewGroup);
        viewGroup = am_();
        if (viewGroup != null) {
            m40846Q().setBackground(AnimUtil.m23637a((Context) viewGroup));
        }
        viewGroup = m40849T();
        viewGroup.setAdapter(m40855Z());
        viewGroup.setOffscreenPageLimit(1);
        viewGroup = m40848S();
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        Context context = (Context) am_;
        Object am_2 = am_();
        if (am_2 == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_2, "activity!!");
        viewGroup.setLayoutManager(new CenterLinearLayoutManager(context, am_2.getResources().getDimensionPixelSize(C1761R.dimen.onboarding_category_container_size)));
        new LinearSnapHelper().a(viewGroup);
        viewGroup.setAdapter(aa());
        m40845P().setOnClickListener(new OnboardingScreen$onCreateView$4(this));
        m40852W().setOnClickListener(new OnboardingScreen$onCreateView$5(this));
        m40853X().setOnClickListener(new OnboardingScreen$onCreateView$6(this));
        Intrinsics.m26843a(a, "view");
        return a;
    }

    public final void mo6987a(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6987a(view);
        m40855Z().m35104g();
        this.I.m24081a();
    }

    protected final void mo6992b(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        view = this.f40131w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.attach();
    }

    protected final void mo6993c(android.view.View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6993c(view);
        view = this.f40131w;
        if (view == null) {
            Intrinsics.m26844a("presenter");
        }
        view.detach();
    }

    public final void mo7191l() {
        super.mo7191l();
        OnboardingPresenter onboardingPresenter = this.f40131w;
        if (onboardingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        onboardingPresenter.destroy();
    }

    public final boolean mo6986J() {
        new OnboardingEventBuilder().m28958a(PageType.RECOMMENDATIONS).m28959a(Source.ONBOARDING).m28956a(Action.CLICK).m28957a(Noun.BACK).m21891a();
        return super.mo6986J();
    }

    public final String getAnalyticsScreenName() {
        return PageType.RECOMMENDATIONS.value;
    }

    public final String getAnalyticsPageType() {
        return PageType.RECOMMENDATIONS.value;
    }

    public final void mo7409a() {
        ViewsKt.m24107c(m40846Q());
    }

    public final void mo7414b() {
        ViewsKt.m24109d(m40846Q());
    }

    public final void mo7410a(int i) {
        String string;
        int max = Math.max(3 - i, 0);
        Activity am_ = am_();
        if (am_ != null) {
            switch (max) {
                case 0:
                    string = am_.getString(C1761R.string.onboarding_subscribe_progress_done);
                    break;
                case 1:
                    string = am_.getString(C1761R.string.onboarding_subscribe_progress_one);
                    break;
                case 2:
                    string = am_.getString(C1761R.string.onboarding_subscribe_progress_two);
                    break;
                default:
                    string = am_.getString(C1761R.string.onboarding_subscribe_progress_many, new Object[]{Integer.valueOf(max)});
                    break;
            }
        }
        string = null;
        m40859a(string);
        m40845P().setText(C1761R.string.action_skip);
        m40844O().setSegments(3);
        m40844O().setSelectedSegments(i);
    }

    public final void mo7415c() {
        Activity am_ = am_();
        m40859a(am_ != null ? am_.getString(C1761R.string.onboarding_subscribe_progress_done) : null);
        m40845P().setText(C1761R.string.action_done);
        m40844O().setSegments(3);
        m40844O().setSelectedSegments(3);
    }

    public final void mo7413a(List<SubredditCategory> list) {
        Intrinsics.m26847b(list, "categories");
        ViewsKt.m24109d(m40847R());
        ViewsKt.m24107c(m40851V());
        Object loopingDataSource = new LoopingDataSource(list);
        if (Intrinsics.m26845a(m40855Z().f36998d, loopingDataSource) == null) {
            int i;
            m40849T().removeOnPageChangeListener(ab());
            m40848S().removeOnScrollListener(ac());
            list = m40855Z();
            Intrinsics.m26847b(loopingDataSource, "value");
            list.f36998d = loopingDataSource;
            list.d();
            list = aa();
            Intrinsics.m26847b(loopingDataSource, "value");
            list.f28713a = loopingDataSource;
            list.e();
            if (this.selectedTab != -2) {
                if (this.selectedTab < loopingDataSource.f20382a) {
                    i = this.selectedTab;
                    m40849T().setCurrentItem(i, false);
                    ViewsKt.m24107c(m40849T());
                    if (ViewCompat.G(m40848S())) {
                        m40848S().getViewTreeObserver().addOnGlobalLayoutListener(new OnboardingScreen$setCategories$1(this, i));
                    } else {
                        m40848S().scrollToPosition(i);
                        ae();
                    }
                    m40850U().setText(null);
                    m40861b(i);
                }
            }
            i = loopingDataSource.f20383b.size() * 5000;
            m40849T().setCurrentItem(i, false);
            ViewsKt.m24107c(m40849T());
            if (ViewCompat.G(m40848S())) {
                m40848S().getViewTreeObserver().addOnGlobalLayoutListener(new OnboardingScreen$setCategories$1(this, i));
            } else {
                m40848S().scrollToPosition(i);
                ae();
            }
            m40850U().setText(null);
            m40861b(i);
        }
    }

    public final void mo7416d() {
        ViewsKt.m24109d(m40851V());
        ViewsKt.m24109d(m40846Q());
        ViewsKt.m24107c(m40847R());
    }

    public final void mo7412a(SubredditCategory subredditCategory, int i) {
        Intrinsics.m26847b(subredditCategory, "category");
        if (Intrinsics.m26845a(m40855Z().m37379c(this.selectedTab), (Object) subredditCategory) != null) {
            subredditCategory = m40850U();
            Resources ao_ = ao_();
            if (ao_ != null) {
                i = ao_.getQuantityString(C1761R.plurals.fmt_num_communities, i, new Object[]{Integer.valueOf(i)});
            } else {
                i = 0;
            }
            subredditCategory.setText((CharSequence) i);
        }
    }

    public final void mo7411a(SubredditCategory subredditCategory) {
        Intrinsics.m26847b(subredditCategory, "category");
        if (Intrinsics.m26845a(m40855Z().m37379c(this.selectedTab), (Object) subredditCategory) != null) {
            m40850U().setText(null);
        }
    }

    public final void mo7417e() {
        ad();
        ViewsKt.m24109d(m40853X());
        ViewsKt.m24109d(m40854Y());
        m40852W().setEnabled(false);
    }

    public final void V_() {
        ad();
        ViewsKt.m24109d(m40853X());
        ViewsKt.m24109d(m40854Y());
        m40852W().setEnabled(true);
    }

    public final void W_() {
        m40852W().setText("");
        m40853X().setText("");
        m40852W().setEnabled(false);
        m40853X().setEnabled(false);
        ViewsKt.m24107c(m40854Y());
    }

    public final void mo7418i() {
        Routing.m22621a((Screen) this);
    }

    private final void ad() {
        m40852W().setText(C1761R.string.onboarding_subscribe_to_all);
        ViewsKt.m24107c(m40852W());
    }

    private final void ae() {
        m40849T().addOnPageChangeListener(ab());
        m40848S().addOnScrollListener(ac());
    }

    private final void m40859a(String str) {
        android.view.View currentView = m40869y().getCurrentView();
        Object obj = null;
        if (!(currentView instanceof TextView)) {
            currentView = null;
        }
        TextView textView = (TextView) currentView;
        Object text = textView != null ? textView.getText() : null;
        if (text != null) {
            obj = text.toString();
        }
        if ((Intrinsics.m26845a(obj, (Object) str) ^ 1) != 0) {
            m40869y().setText(str);
        }
    }

    private final void m40861b(int i) {
        this.selectedTab = i;
        SubredditCategory c = m40855Z().m37379c(i);
        Object context = m40852W().getContext();
        Intrinsics.m26843a(context, "subscribeAllButton.context");
        int a = ResourcesUtil.m22717a(OnboardingUtil.m23161a(context, c), ResourcesUtil.m22716a(context));
        ColorStateList a2 = UiUtil.m22746a(TuplesKt.m26780a(Integer.valueOf(16842910), Integer.valueOf(r2)), TuplesKt.m26780a(Integer.valueOf(-16842910), Integer.valueOf(a)));
        ViewCompat.a(m40852W(), a2);
        ViewCompat.a(m40853X(), a2);
        m40853X().setTextColor(a2);
        OnboardingPresenter onboardingPresenter = this.f40131w;
        if (onboardingPresenter == null) {
            Intrinsics.m26844a("presenter");
        }
        onboardingPresenter.m34822a(c);
        Iterator it = new IntRange(i - 1, i + 1).iterator();
        while (it.hasNext()) {
            a = ((IntIterator) it).mo6663a();
            Screen d = m40855Z().m35102d(a);
            if (!(d instanceof VisibilityDependent)) {
                d = null;
            }
            VisibilityDependent visibilityDependent = (VisibilityDependent) d;
            if (visibilityDependent != null) {
                if (a == i) {
                    visibilityDependent.ap();
                } else {
                    visibilityDependent.aq();
                }
            }
        }
    }

    public final void X_() {
        m40853X().setText(C1761R.string.onboarding_subscribe_to_all_done);
        ViewsKt.m24107c(m40853X());
        ViewsKt.m24109d(m40852W());
        ViewsKt.m24109d(m40854Y());
        m40853X().setEnabled(true);
    }

    public static final /* synthetic */ ColorStateList m40856a(Context context, SubredditCategory subredditCategory) {
        subredditCategory = OnboardingUtil.m23161a(context, subredditCategory);
        context = ResourcesUtil.m22740i(context, C1761R.attr.rdt_placeholder_color);
        return UiUtil.m22746a(TuplesKt.m26780a(Integer.valueOf(16842913), Integer.valueOf(subredditCategory)), TuplesKt.m26780a(Integer.valueOf(-16842913), Integer.valueOf(context)));
    }

    public static final /* synthetic */ void m40858a(OnboardingScreen onboardingScreen, int i) {
        if (onboardingScreen.selectedTab != i) {
            onboardingScreen.m40861b(i);
            new OnboardingEventBuilder().m28958a(PageType.RECOMMENDATIONS).m28959a(Source.ONBOARDING).m28956a(Action.CLICK).m28957a(Noun.CATEGORY).m28960a(onboardingScreen.m40855Z().m37379c(i)).m21891a();
        }
    }
}
