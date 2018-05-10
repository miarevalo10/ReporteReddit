package com.reddit.frontpage.ui.listing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Subreddit;
import com.reddit.frontpage.nav.Screen;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionAction;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.ListOptionsDialog;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsScreen;
import com.reddit.frontpage.presentation.theme.ThemeOption;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.OnModQueueCommentSelectedListener;
import com.reddit.frontpage.ui.listener.ModQueueCheckListener;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter;
import com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter.OnLinkHiddenListener;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import com.reddit.frontpage.widgets.ListingFilterBarView;
import com.reddit.frontpage.widgets.modtools.modqueue.ModModeable;
import com.reddit.frontpage.widgets.modtools.modqueue.ModQueueHeader;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0002JKB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000200H\u0002J\b\u00106\u001a\u00020\u0006H\u0002J\b\u00107\u001a\u00020.H\u0014J\b\u00108\u001a\u00020.H\u0014J\b\u00109\u001a\u00020.H\u0014J\u0010\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020<H\u0014J\b\u0010=\u001a\u00020\u0006H\u0016J\u0018\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020.H\u0016J\u0010\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020FH\u0017J\b\u0010G\u001a\u00020.H\u0014J\u0010\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u000204H\u0002R\u0014\u0010\u000b\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\u0004\u0018\u00010*8BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006L"}, d2 = {"Lcom/reddit/frontpage/ui/listing/ModQueueListingScreen;", "Lcom/reddit/frontpage/ui/listing/LegacySubredditListingScreen;", "Lcom/reddit/frontpage/widgets/modtools/modqueue/ModModeable;", "name", "", "modQueue", "", "(Ljava/lang/String;Z)V", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "discoveryUnitsEnabled", "getDiscoveryUnitsEnabled", "()Z", "filterDialog", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialog;", "hasDiscoveryUnits", "getHasDiscoveryUnits", "modItemCheckedListener", "Lcom/reddit/frontpage/ui/listener/ModQueueCheckListener;", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Thing;", "getModQueue", "setModQueue", "(Z)V", "modQueueCommentSelectedListener", "Lcom/reddit/frontpage/ui/detail/comments/LegacyCommentViewHolder$OnModQueueCommentSelectedListener;", "modQueueHeader", "Lcom/reddit/frontpage/widgets/modtools/modqueue/ModQueueHeader;", "getModQueueHeader", "()Lcom/reddit/frontpage/widgets/modtools/modqueue/ModQueueHeader;", "modQueueOptionsScreen", "Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsScreen;", "getModQueueOptionsScreen", "()Lcom/reddit/frontpage/presentation/modtools/bottomsheet/modqueueoptions/ModQueueOptionsScreen;", "modQueueType", "getModQueueType", "()Ljava/lang/String;", "setModQueueType", "(Ljava/lang/String;)V", "modSelectedThingsDisposable", "Lio/reactivex/disposables/Disposable;", "toolbar", "Landroid/support/v7/widget/Toolbar;", "getToolbar", "()Landroid/support/v7/widget/Toolbar;", "bindSubreddit", "", "subreddit", "Lcom/reddit/frontpage/domain/model/Subreddit;", "createListingAdapter", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "getLayoutId", "", "getModSubreddit", "isModSubreddit", "load", "loadMore", "loadSubreddit", "onAttach", "view", "Landroid/view/View;", "onBackPressed", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPrepareOptionsMenu", "menu", "Landroid/view/Menu;", "refresh", "setupModQueueOptionsSheet", "keyColor", "Companion", "ModFlairLinkAdapter", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModQueueListingScreen.kt */
public final class ModQueueListingScreen extends LegacySubredditListingScreen implements ModModeable {
    public static final Companion f40747R = new Companion();
    private Disposable f40748S;
    private ListOptionsDialog f40749T;
    private ModQueueCheckListener<? super Thing> f40750U;
    private OnModQueueCommentSelectedListener f40751V;
    @State
    boolean modQueue;
    @State
    String modQueueType = "links";

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/ui/listing/ModQueueListingScreen$Companion;", "", "()V", "COMMENT_CONTEXT", "", "modQueueInstance", "Lcom/reddit/frontpage/ui/listing/ModQueueListingScreen;", "name", "moderatingInstance", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModQueueListingScreen.kt */
    public static final class Companion {
        private Companion() {
        }

        public static ModQueueListingScreen m23434a(String str) {
            Intrinsics.m26847b(str, "name");
            return new ModQueueListingScreen(str, true);
        }

        public static ModQueueListingScreen m23435b(String str) {
            Intrinsics.m26847b(str, "name");
            return new ModQueueListingScreen(str, false);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/ui/listing/ModQueueListingScreen$ModFlairLinkAdapter;", "Lcom/reddit/frontpage/ui/listing/adapter/CardLinkAdapter;", "context", "Landroid/content/Context;", "sourcePage", "", "(Lcom/reddit/frontpage/ui/listing/ModQueueListingScreen;Landroid/content/Context;Ljava/lang/String;)V", "bindViewHolder", "", "holder", "Lcom/reddit/frontpage/ui/listing/newcard/LinkViewHolder;", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "getCompact", "", "getItem", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "position", "", "getItemCount", "getSourcePage", "navigateToPostDetail", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModQueueListingScreen.kt */
    private final class ModFlairLinkAdapter extends CardLinkAdapter {
        final /* synthetic */ ModQueueListingScreen f34322a;
        private final String f34323b;

        public ModFlairLinkAdapter(ModQueueListingScreen modQueueListingScreen, Context context, String str) {
            Intrinsics.m26847b(context, "context");
            this.f34322a = modQueueListingScreen;
            super(context, 6);
            this.f34323b = str;
        }

        public final /* synthetic */ Object mo4996g(int i) {
            return mo6476c(i);
        }

        public final Listable mo6476c(int i) {
            Object obj = this.f34322a.y.get(i);
            Intrinsics.m26843a(obj, "this@ModQueueListingScreen.listing.get(position)");
            return (Listable) obj;
        }

        public final boolean mo6477c() {
            return this.f34322a.H == ListingViewMode.f20613b;
        }

        public final int m35048a() {
            Listing listing = this.f34322a.y;
            return listing != null ? listing.size() : 0;
        }

        protected final void mo6506b(LinkViewHolder linkViewHolder, Link link) {
            Intrinsics.m26847b(linkViewHolder, "holder");
            Intrinsics.m26847b(link, "link");
            super.mo6506b(linkViewHolder, link);
            if (this.f34322a.f40750U != null) {
                linkViewHolder.m35117a(this.f34322a.f40750U);
            }
            linkViewHolder.m35121a(this.f34322a.Y_());
        }

        protected final void mo6468a(LinkViewHolder linkViewHolder, Link link) {
            Intrinsics.m26847b(linkViewHolder, "holder");
            Intrinsics.m26847b(link, "link");
            linkViewHolder.mo7006w();
            this.f34322a.m39238a((ViewHolder) linkViewHolder);
        }

        protected final String mo6479f() {
            return this.f34323b;
        }
    }

    public static final ModQueueListingScreen m42545d(String str) {
        return Companion.m23434a(str);
    }

    public static final ModQueueListingScreen m42546e(String str) {
        return Companion.m23435b(str);
    }

    protected final boolean ao() {
        return false;
    }

    public final int mo7141s() {
        return C1761R.layout.mod_queue_screen;
    }

    public static final /* synthetic */ ListOptionsDialog m42544c(ModQueueListingScreen modQueueListingScreen) {
        modQueueListingScreen = modQueueListingScreen.f40749T;
        if (modQueueListingScreen == null) {
            Intrinsics.m26844a("filterDialog");
        }
        return modQueueListingScreen;
    }

    private final ModQueueHeader ar() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return (ModQueueHeader) obj.findViewById(C1761R.id.mod_queue_header);
    }

    private final ModQueueOptionsScreen as() {
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        return (ModQueueOptionsScreen) obj.findViewById(C1761R.id.mod_queue_options);
    }

    public final void mo7241c(String str) {
        Intrinsics.m26847b(str, "<set-?>");
        this.modQueueType = str;
    }

    public ModQueueListingScreen(String str, boolean z) {
        Intrinsics.m26847b(str, "name");
        super(str);
        this.f40616N = str;
        this.modQueue = z;
    }

    public ModQueueListingScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "args");
        super(bundle);
    }

    @SuppressLint({"MissingSuperCall"})
    public final void mo7730a(Menu menu) {
        Intrinsics.m26847b(menu, "menu");
        Object findItem = menu.findItem(C1761R.id.action_subscribe);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_subscribe)");
        findItem.setVisible(false);
        findItem = menu.findItem(C1761R.id.action_unsubscribe);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_unsubscribe)");
        findItem.setVisible(false);
        findItem = menu.findItem(C1761R.id.action_search);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_search)");
        findItem.setVisible(false);
        findItem = menu.findItem(C1761R.id.action_subreddit_info);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_subreddit_info)");
        findItem.setVisible(false);
        findItem = menu.findItem(C1761R.id.action_mod_tools);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_mod_tools)");
        Subreddit subreddit = this.subredditModel;
        boolean z = true;
        if ((!Intrinsics.m26845a(subreddit != null ? subreddit.getUserIsModerator() : null, Boolean.valueOf(true)) && !aB()) || this.modQueue) {
            z = false;
        }
        findItem.setVisible(z);
        findItem = menu.findItem(C1761R.id.action_contact_moderators);
        Intrinsics.m26843a(findItem, "menu.findItem(R.id.action_contact_moderators)");
        findItem.setVisible(false);
        Object findItem2 = menu.findItem(C1761R.id.action_refresh);
        Intrinsics.m26843a(findItem2, "menu.findItem(R.id.action_refresh)");
        findItem2.setVisible(false);
    }

    public final boolean mo6986J() {
        Screen screen = this;
        if (ModUtil.m23834b(screen)) {
            ModUtil.m23835c();
            C_().b("ModToolsActionsScreenTag");
            return true;
        }
        if (ModUtil.m23831a(screen)) {
            ModUtil.m23832b();
        }
        return super.mo6986J();
    }

    protected final void mo6992b(View view) {
        Intrinsics.m26847b(view, "view");
        super.mo6992b(view);
        if (aB() == null) {
            view = as();
            view = view != null ? view.getNumberCheckedSubject() : null;
            if (view == null) {
                Intrinsics.m26842a();
            }
            this.f40748S = view.observeOn(SchedulerProvider.m23887c()).subscribe((Consumer) new ModQueueListingScreen$onAttach$1(this));
        }
    }

    public final void mo7191l() {
        super.mo7191l();
        if (ModUtil.m23834b(this)) {
            ModUtil.m23835c();
        }
        Disposable disposable = this.f40748S;
        if (disposable != null) {
            disposable.mo5626a();
        }
    }

    protected final void am() {
        if (aB()) {
            mo7733b(new Subreddit("", "", "Mod", "r/Mod", null, "#46D160", null, null, "", "", "", "", "", 0, Long.valueOf(0), 0, "", "r/mod", false, Boolean.valueOf(false), "", Boolean.valueOf(true), "any", Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(false)));
            return;
        }
        ModQueueListingScreen modQueueListingScreen = this;
        super.am();
    }

    protected final void mo7733b(Subreddit subreddit) {
        m42294a(subreddit);
        al();
        Object obj = this.K;
        Intrinsics.m26843a(obj, "rootView");
        Toolbar toolbar = (Toolbar) obj.findViewById(C1761R.id.toolbar);
        if (toolbar != null) {
            Integer num = this.themedKeyColor;
            if (num == null) {
                Intrinsics.m26842a();
            }
            toolbar.setBackgroundColor(num.intValue());
        }
        if (this.modQueue) {
            Object c;
            Integer num2 = this.themedKeyColor;
            if (num2 == null) {
                Intrinsics.m26842a();
            }
            int intValue = num2.intValue();
            ModQueueHeader ar = ar();
            if (ar != null) {
                c = FrontpageSettings.a().c(true);
                if ((Intrinsics.m26845a(c, ThemeOption.f20981c) ^ 1) == 0 || (Intrinsics.m26845a(c, ThemeOption.f20984f) ^ 1) == 0) {
                    obj = ar.getContext();
                    Intrinsics.m26843a(obj, "context");
                    intValue = ResourcesUtil.m22740i(obj, C1761R.attr.rdt_body_text_color);
                } else {
                    c = ar.getSelectedButton().getBackground();
                    Intrinsics.m26843a(c, "selectedButton.background");
                    Drawable newDrawable = c.getConstantState().newDrawable();
                    newDrawable.setColorFilter(intValue, Mode.SRC_ATOP);
                    ar.getSelectedButton().setBackground(newDrawable);
                    ar.getSelectedButton().setTextColor(intValue);
                    ar.getFilterView().getDrawable().setColorFilter(intValue, Mode.SRC_ATOP);
                    ar.getViewModeButton().getDrawable().setColorFilter(intValue, Mode.SRC_ATOP);
                }
                c = ar.getContext();
                Intrinsics.m26843a(c, "context");
                ar.getSelectedButton().setCompoundDrawablesWithIntrinsicBounds(null, null, ResourcesUtil.m22730d(c, C1761R.drawable.ic_arrow_drop_down, intValue), null);
            }
            List arrayList = new ArrayList();
            c = Util.m24027f((int) C1761R.string.mod_queue_posts_only);
            Intrinsics.m26843a(c, "getString(R.string.mod_queue_posts_only)");
            arrayList.add(new ListOptionAction(c, Integer.valueOf(C1761R.drawable.ic_icon_feed_posts), new ModQueueListingScreen$setupModQueueOptionsSheet$1(this)));
            c = Util.m24027f((int) C1761R.string.mod_queue_comments_only);
            Intrinsics.m26843a(c, "getString(R.string.mod_queue_comments_only)");
            arrayList.add(new ListOptionAction(c, Integer.valueOf(C1761R.drawable.ic_icon_comments), new ModQueueListingScreen$setupModQueueOptionsSheet$2(this)));
            c = am_();
            if (c == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(c, "activity!!");
            this.f40749T = new ListOptionsDialog((Context) c, arrayList, 0, 8);
            ModQueueHeader ar2 = ar();
            if (ar2 != null) {
                ar2.setOnFilterViewClickListener(new ModQueueListingScreen$setupModQueueOptionsSheet$3(this));
            }
            ar2 = ar();
            if (ar2 != null) {
                ar2.setViewModeClickListener(new ModQueueListingScreen$setupModQueueOptionsSheet$4(this));
            }
            ar2 = ar();
            if (ar2 != null) {
                ar2.setOnSelectButtonClicked(new ModQueueListingScreen$setupModQueueOptionsSheet$5(this));
            }
        }
        if (!(subreddit == null || this.f40617O == null)) {
            ListingFilterBarView listingFilterBarView = this.f40617O;
            if (listingFilterBarView == null) {
                Intrinsics.m26842a();
            }
            ModUtil.m23828a(subreddit, (View) listingFilterBarView.getModModeButton(), (Runnable) new ModQueueListingScreen$bindSubreddit$1(this));
        }
        m29352G();
    }

    protected final void mo7693Z() {
        if (aB() && !this.modQueue) {
            super.mo7693Z();
        } else if (this.y != null) {
            ad();
            this.w.e();
            this.B.m23493a(true);
        } else {
            ac();
            aa();
            this.E.b(false, this.modQueueType);
        }
    }

    protected final void mo7448y() {
        if (!aB() || this.modQueue) {
            this.E.a(this.modQueueType);
        } else {
            super.mo7448y();
        }
    }

    protected final void mo7444O() {
        if (v_() && this.z != null) {
            this.z.m24184b();
        }
        if (this.E != null) {
            this.E.c(this.modQueueType);
        }
    }

    public final CardLinkAdapter mo7455Y() {
        Object am_ = am_();
        if (am_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a(am_, "activity!!");
        ModFlairLinkAdapter modFlairLinkAdapter = new ModFlairLinkAdapter(this, (Context) am_, this.f40616N);
        modFlairLinkAdapter.m30203a((OnLinkHiddenListener) new C2344xc32aae6d(this));
        return modFlairLinkAdapter;
    }

    private final boolean aB() {
        return Intrinsics.m26845a(this.f40616N, Util.m24027f((int) C1761R.string.mod));
    }

    public final View mo7139a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        CharSequence f;
        Intrinsics.m26847b(layoutInflater, "inflater");
        Intrinsics.m26847b(viewGroup, "container");
        this.f40618P = true;
        View a = super.mo7139a(layoutInflater, viewGroup);
        TextView S = m42280S();
        if (aB()) {
            f = Util.m24027f((int) C1761R.string.title_moderating);
        } else {
            f = Util.m24027f((int) C1761R.string.mod_tools_mod_queue);
        }
        S.setText(f);
        Button ak = ak();
        if (ak != null) {
            ak.setVisibility(8);
        }
        ModQueueHeader ar;
        if (this.modQueue) {
            ar = ar();
            if (ar != null) {
                String str = this.f40616N;
                if (str == null) {
                    Intrinsics.m26842a();
                }
                ar.setSubredditName(str);
            }
            ModQueueOptionsScreen as = as();
            if (as != null) {
                as.setVisibility(8);
            }
            as = as();
            if (as != null) {
                OnModActionCompletedListener modQueueListingScreen$onCreateView$1 = new ModQueueListingScreen$onCreateView$1(this);
                Intrinsics.m26847b(modQueueListingScreen$onCreateView$1, "listener");
                ModQueueOptionsPresenter modQueueOptionsPresenter = as.f28616d;
                if (modQueueOptionsPresenter == null) {
                    Intrinsics.m26844a("presenter");
                }
                modQueueOptionsPresenter.setOnOnModerateListener(modQueueListingScreen$onCreateView$1);
            }
            this.f40750U = new ModQueueListingScreen$onCreateView$2(this);
            this.f40751V = new ModQueueListingScreen$onCreateView$3(this);
            CardLinkAdapter cardLinkAdapter = this.C;
            if (cardLinkAdapter == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.listing.adapter.CardLinkAdapter");
            }
            cardLinkAdapter.m30202a(this.f40750U, this.f40751V);
            this.w.m35092a(layoutInflater.inflate(C1761R.layout.widget_list_margin_top, viewGroup, false));
        } else {
            ar = ar();
            if (ar != null) {
                ar.setVisibility(8);
            }
            m42300b(layoutInflater, viewGroup);
        }
        if (this.subredditModel == null) {
            am();
        } else {
            mo7733b(this.subredditModel);
        }
        return a;
    }
}
