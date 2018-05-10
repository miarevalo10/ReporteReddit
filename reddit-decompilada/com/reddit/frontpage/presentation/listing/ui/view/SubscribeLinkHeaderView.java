package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.presentation.listing.ui.view.HeaderMetadataView.StringWithIndicators;
import com.reddit.frontpage.util.MenuUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.SessionUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010'\u001a\u00020\u001cH\u0014J\u0016\u0010(\u001a\u00020\u001c2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020-H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/SubscribeLinkHeaderView;", "Lcom/reddit/frontpage/presentation/listing/ui/view/HeaderMetadataView;", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeader;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "analyticsRunnable", "Ljava/lang/Runnable;", "getAnalyticsRunnable", "()Ljava/lang/Runnable;", "setAnalyticsRunnable", "(Ljava/lang/Runnable;)V", "hideItem", "Landroid/view/MenuItem;", "menu", "Landroid/support/v7/widget/PopupMenu;", "reportItem", "saveItem", "shareItem", "unhideItem", "unsaveItem", "addRunnableToOverflowClickListener", "", "listener", "bindLink", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "configureMenu", "configureMenuItems", "generateBottomMetadata", "Lcom/reddit/frontpage/presentation/listing/ui/view/HeaderMetadataView$StringWithIndicators;", "generateTopMetadata", "", "onFinishInflate", "setClickListener", "action", "Lkotlin/Function0;", "setDisplaySubredditName", "showDisplaySubredditName", "", "setDomainClickListener", "Landroid/view/View$OnClickListener;", "setOnMenuItemClickListener", "Landroid/support/v7/widget/PopupMenu$OnMenuItemClickListener;", "setShowOverflow", "showOverflow", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubscribeLinkHeaderView.kt */
public final class SubscribeLinkHeaderView extends HeaderMetadataView implements LinkHeader {
    private PopupMenu f28503b;
    private MenuItem f28504c;
    private MenuItem f28505d;
    private MenuItem f28506e;
    private MenuItem f28507f;
    private MenuItem f28508g;
    private MenuItem f28509h;
    private Runnable f28510i;
    private HashMap f28511j;

    public SubscribeLinkHeaderView(Context context) {
        this(context, null, 0, 6, null);
    }

    public SubscribeLinkHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final View mo4901a(int i) {
        if (this.f28511j == null) {
            this.f28511j = new HashMap();
        }
        View view = (View) this.f28511j.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f28511j.put(Integer.valueOf(i), view);
        return view;
    }

    protected final String mo4902a(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        return "";
    }

    public final void setDisplaySubredditName(boolean z) {
    }

    public final void setShowOverflow(boolean z) {
    }

    public static final /* synthetic */ PopupMenu m29725a(SubscribeLinkHeaderView subscribeLinkHeaderView) {
        subscribeLinkHeaderView = subscribeLinkHeaderView.f28503b;
        if (subscribeLinkHeaderView == null) {
            Intrinsics.m26844a("menu");
        }
        return subscribeLinkHeaderView;
    }

    public /* synthetic */ SubscribeLinkHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public SubscribeLinkHeaderView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        if (attributeSet == null) {
            Intrinsics.m26842a();
        }
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public SubscribeLinkHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
    }

    public final Runnable getAnalyticsRunnable() {
        return this.f28510i;
    }

    public final void setAnalyticsRunnable(Runnable runnable) {
        this.f28510i = runnable;
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        this.f28503b = new PopupMenu(getContext(), getOverflowIcon());
        PopupMenu popupMenu = this.f28503b;
        if (popupMenu == null) {
            Intrinsics.m26844a("menu");
        }
        MenuUtil.m23812a(popupMenu.a());
        popupMenu = this.f28503b;
        if (popupMenu == null) {
            Intrinsics.m26844a("menu");
        }
        popupMenu.a(C1761R.menu.menu_link_options);
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        if (b.c().isAnonymous()) {
            popupMenu = this.f28503b;
            if (popupMenu == null) {
                Intrinsics.m26844a("menu");
            }
            b = popupMenu.a().findItem(C1761R.id.action_report);
            Intrinsics.m26843a(b, "menu.menu.findItem(R.id.action_report)");
            b.setVisible(false);
        }
        getOverflowLayout().setOnClickListener(new SubscribeLinkHeaderView$configureMenu$1(this));
        popupMenu = this.f28503b;
        if (popupMenu == null) {
            Intrinsics.m26844a("menu");
        }
        b = popupMenu.a().findItem(C1761R.id.action_hide);
        Intrinsics.m26843a(b, "menu.menu.findItem(R.id.action_hide)");
        this.f28504c = b;
        popupMenu = this.f28503b;
        if (popupMenu == null) {
            Intrinsics.m26844a("menu");
        }
        b = popupMenu.a().findItem(C1761R.id.action_unhide);
        Intrinsics.m26843a(b, "menu.menu.findItem(R.id.action_unhide)");
        this.f28505d = b;
        popupMenu = this.f28503b;
        if (popupMenu == null) {
            Intrinsics.m26844a("menu");
        }
        b = popupMenu.a().findItem(C1761R.id.action_report);
        Intrinsics.m26843a(b, "menu.menu.findItem(R.id.action_report)");
        this.f28506e = b;
        popupMenu = this.f28503b;
        if (popupMenu == null) {
            Intrinsics.m26844a("menu");
        }
        b = popupMenu.a().findItem(C1761R.id.action_save);
        Intrinsics.m26843a(b, "menu.menu.findItem(R.id.action_save)");
        this.f28507f = b;
        popupMenu = this.f28503b;
        if (popupMenu == null) {
            Intrinsics.m26844a("menu");
        }
        b = popupMenu.a().findItem(C1761R.id.action_unsave);
        Intrinsics.m26843a(b, "menu.menu.findItem(R.id.action_unsave)");
        this.f28508g = b;
        popupMenu = this.f28503b;
        if (popupMenu == null) {
            Intrinsics.m26844a("menu");
        }
        b = popupMenu.a().findItem(C1761R.id.action_share);
        Intrinsics.m26843a(b, "menu.menu.findItem(R.id.action_share)");
        this.f28509h = b;
    }

    public final void a_(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        m22998c(linkPresentationModel);
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        Session c = b.c();
        boolean z = false;
        boolean z2 = (c.isAnonymous() || SessionUtil.m23895a(c, linkPresentationModel.f33985l)) ? false : true;
        boolean z3 = linkPresentationModel.f33973Z;
        MenuItem menuItem = this.f28504c;
        if (menuItem == null) {
            Intrinsics.m26844a("hideItem");
        }
        boolean z4 = z2 && !z3;
        menuItem.setVisible(z4);
        menuItem = this.f28505d;
        if (menuItem == null) {
            Intrinsics.m26844a("unhideItem");
        }
        if (z2 && z3) {
            z = true;
        }
        menuItem.setVisible(z);
        MenuItem menuItem2 = this.f28506e;
        if (menuItem2 == null) {
            Intrinsics.m26844a("reportItem");
        }
        menuItem2.setVisible(z2);
        MenuItem menuItem3 = this.f28507f;
        if (menuItem3 == null) {
            Intrinsics.m26844a("saveItem");
        }
        menuItem3.setVisible(linkPresentationModel.aa ^ true);
        menuItem3 = this.f28508g;
        if (menuItem3 == null) {
            Intrinsics.m26844a("unsaveItem");
        }
        menuItem3.setVisible(linkPresentationModel.aa);
        menuItem3 = this.f28509h;
        if (menuItem3 == null) {
            Intrinsics.m26844a("shareItem");
        }
        menuItem3.setVisible(linkPresentationModel.f33968U);
    }

    public final void setClickListener(Function0<Unit> function0) {
        Intrinsics.m26847b(function0, "action");
        getTopMetadata().setOnClickListener((OnClickListener) new SubscribeLinkHeaderView$inlined$sam$OnClickListener$i$7f478c20(new SubscribeLinkHeaderView$setClickListener$1(function0)));
    }

    public final void setDomainClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        getTopMetadata().setOnClickListener(onClickListener);
    }

    public final void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        Intrinsics.m26847b(onMenuItemClickListener, "listener");
        PopupMenu popupMenu = this.f28503b;
        if (popupMenu == null) {
            Intrinsics.m26844a("menu");
        }
        popupMenu.a(onMenuItemClickListener);
    }

    protected final StringWithIndicators mo4903b(LinkPresentationModel linkPresentationModel) {
        int i;
        Object stringBuilder;
        Intrinsics.m26847b(linkPresentationModel, "link");
        StringBuilder stringBuilder2 = new StringBuilder();
        int i2 = 0;
        if (linkPresentationModel.f33990q > 1) {
            stringBuilder2.append(getContext().getString(C1761R.string.fmt_icon_count, new Object[]{Integer.valueOf(linkPresentationModel.f33990q)}));
        }
        if (!linkPresentationModel.f33962O) {
            stringBuilder2.append(linkPresentationModel.f33983j);
        }
        if (!linkPresentationModel.ao) {
            int i3;
            CharSequence charSequence = linkPresentationModel.f33984k;
            if (charSequence != null) {
                if (charSequence.length() != 0) {
                    i3 = 0;
                    if (i3 == 0) {
                        stringBuilder2.append(linkPresentationModel.f33984k);
                    }
                }
            }
            i3 = 1;
            if (i3 == 0) {
                stringBuilder2.append(linkPresentationModel.f33984k);
            }
        }
        String str = linkPresentationModel.f33986m;
        Indicator[] indicatorArr = new Indicator[5];
        Indicator indicator = Indicator.f20734c;
        if (!Intrinsics.m26845a(SessionUtil.m23899e(), linkPresentationModel.f33985l)) {
            indicator = null;
        }
        indicatorArr[0] = indicator;
        indicator = Indicator.f20736e;
        if (!linkPresentationModel.f33987n) {
            indicator = null;
        }
        indicatorArr[1] = indicator;
        indicator = Indicator.f20732a;
        if (!Intrinsics.m26845a(linkPresentationModel.f33993t, DistinguishType.c)) {
            indicator = null;
        }
        indicatorArr[2] = indicator;
        indicator = Indicator.f20733b;
        if (!Intrinsics.m26845a(linkPresentationModel.f33993t, DistinguishType.a)) {
            if (!ModUtil.m23824a().getDistinguishState(linkPresentationModel.getName(), linkPresentationModel.m34744a())) {
                i = 0;
                if (i != 0) {
                    indicator = null;
                }
                indicatorArr[3] = indicator;
                indicator = Indicator.f20737f;
                if (linkPresentationModel.f33990q > null) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    indicator = null;
                }
                indicatorArr[4] = indicator;
                stringBuilder = stringBuilder2.toString();
                Intrinsics.m26843a(stringBuilder, "bottomTextBuilder.toString()");
                return new StringWithIndicators(str, CollectionsKt___CollectionsKt.m41451p(CollectionsKt__CollectionsKt.m26798d(indicatorArr)), "", stringBuilder);
            }
        }
        i = 1;
        if (i != 0) {
            indicator = null;
        }
        indicatorArr[3] = indicator;
        indicator = Indicator.f20737f;
        if (linkPresentationModel.f33990q > null) {
            i2 = 1;
        }
        if (i2 != 0) {
            indicator = null;
        }
        indicatorArr[4] = indicator;
        stringBuilder = stringBuilder2.toString();
        Intrinsics.m26843a(stringBuilder, "bottomTextBuilder.toString()");
        return new StringWithIndicators(str, CollectionsKt___CollectionsKt.m41451p(CollectionsKt__CollectionsKt.m26798d(indicatorArr)), "", stringBuilder);
    }
}
