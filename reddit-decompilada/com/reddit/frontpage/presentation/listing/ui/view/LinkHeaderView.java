package com.reddit.frontpage.presentation.listing.ui.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.modtools.PopupModReports;
import com.reddit.frontpage.util.MenuUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.BaseHeaderView;
import com.reddit.frontpage.widgets.IconStatusView;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0016J*\u0010$\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\u001eH\u0014J\u0016\u0010&\u001a\u00020\u001e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0(H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0019H\u0016J\u0010\u00101\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u00102\u001a\u0002032\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeaderView;", "Lcom/reddit/frontpage/widgets/BaseHeaderView;", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeader;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "hideItem", "Landroid/view/MenuItem;", "paddingRightVal", "reportItem", "saveItem", "selectListingBox", "Landroid/widget/CheckBox;", "getSelectListingBox", "()Landroid/widget/CheckBox;", "selectListingBox$delegate", "Lkotlin/Lazy;", "shareItem", "showDisplaySubredditName", "", "showDisplayWebsiteDomains", "unhideItem", "unsaveItem", "attachClickListener", "", "view", "Landroid/view/View;", "link", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "bindLink", "init", "onFinishInflate", "setClickListener", "action", "Lkotlin/Function0;", "setDisplaySubredditName", "setDomainClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnMenuItemClickListener", "Landroid/support/v7/widget/PopupMenu$OnMenuItemClickListener;", "setShowOverflow", "showOverflow", "showReportsPopup", "subredditName", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkHeaderView.kt */
public final class LinkHeaderView extends BaseHeaderView implements LinkHeader {
    static final /* synthetic */ KProperty[] f28481a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LinkHeaderView.class), "selectListingBox", "getSelectListingBox()Landroid/widget/CheckBox;"))};
    private MenuItem f28482e;
    private MenuItem f28483f;
    private MenuItem f28484g;
    private MenuItem f28485h;
    private MenuItem f28486i;
    private MenuItem f28487j;
    private boolean f28488k;
    private boolean f28489l;
    private int f28490m;
    private final Lazy f28491n;
    private HashMap f28492o;

    public LinkHeaderView(Context context) {
        this(context, null, 0, 6, null);
    }

    public LinkHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final View m29717a(int i) {
        if (this.f28492o == null) {
            this.f28492o = new HashMap();
        }
        View view = (View) this.f28492o.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f28492o.put(Integer.valueOf(i), view);
        return view;
    }

    public final CheckBox getSelectListingBox() {
        return (CheckBox) this.f28491n.mo5678b();
    }

    public /* synthetic */ LinkHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public LinkHeaderView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f28491n = LazyKt.m26777a(new LinkHeaderView$selectListingBox$2(this));
        m29714a(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public LinkHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i, i2);
        this.f28491n = LazyKt.m26777a(new LinkHeaderView$selectListingBox$2(this));
        m29714a(context, attributeSet, i, i2);
    }

    private final void m29714a(Context context, AttributeSet attributeSet, int i, int i2) {
        BaseHeaderView.inflate(context, C1761R.layout.merge_link_header, this);
        setClipToPadding(false);
        context = context.getTheme().obtainStyledAttributes(attributeSet, C1761R.styleable.LinkHeaderView, i, i2);
        try {
            this.f28489l = context.getBoolean(0, false);
            if (ModUtil.m23834b(Routing.m22617a(getContext())) != null) {
                getSelectListingBox().setVisibility(0);
            }
        } finally {
            context.recycle();
        }
    }

    protected final void onFinishInflate() {
        int i;
        super.onFinishInflate();
        Object obj = this.d;
        Intrinsics.m26843a(obj, "menu");
        MenuUtil.m23812a(obj.a());
        this.d.a(C1761R.menu.menu_link_options);
        obj = SessionManager.b();
        Intrinsics.m26843a(obj, "SessionManager.getInstance()");
        if (obj.c().isAnonymous()) {
            obj = this.d;
            Intrinsics.m26843a(obj, "menu");
            obj = obj.a().findItem(C1761R.id.action_report);
            Intrinsics.m26843a(obj, "menu.menu.findItem(R.id.action_report)");
            obj.setVisible(false);
        }
        obj = this.d;
        Intrinsics.m26843a(obj, "menu");
        obj = obj.a().findItem(C1761R.id.action_hide);
        Intrinsics.m26843a(obj, "menu.menu.findItem(R.id.action_hide)");
        this.f28482e = obj;
        obj = this.d;
        Intrinsics.m26843a(obj, "menu");
        obj = obj.a().findItem(C1761R.id.action_unhide);
        Intrinsics.m26843a(obj, "menu.menu.findItem(R.id.action_unhide)");
        this.f28483f = obj;
        obj = this.d;
        Intrinsics.m26843a(obj, "menu");
        obj = obj.a().findItem(C1761R.id.action_report);
        Intrinsics.m26843a(obj, "menu.menu.findItem(R.id.action_report)");
        this.f28484g = obj;
        obj = this.d;
        Intrinsics.m26843a(obj, "menu");
        obj = obj.a().findItem(C1761R.id.action_save);
        Intrinsics.m26843a(obj, "menu.menu.findItem(R.id.action_save)");
        this.f28485h = obj;
        obj = this.d;
        Intrinsics.m26843a(obj, "menu");
        obj = obj.a().findItem(C1761R.id.action_unsave);
        Intrinsics.m26843a(obj, "menu.menu.findItem(R.id.action_unsave)");
        this.f28486i = obj;
        obj = this.d;
        Intrinsics.m26843a(obj, "menu");
        obj = obj.a().findItem(C1761R.id.action_share);
        Intrinsics.m26843a(obj, "menu.menu.findItem(R.id.action_share)");
        this.f28487j = obj;
        if (ModUtil.m23834b(Routing.m22617a(getContext()))) {
            i = 0;
        } else {
            obj = (TextView) m29717a(C1761R.id.link_alt_link_label);
            Intrinsics.m26843a(obj, "link_alt_link_label");
            i = obj.getPaddingLeft() + getPaddingLeft();
        }
        TextView textView = (TextView) m29717a(C1761R.id.link_alt_link_label);
        Object obj2 = (TextView) m29717a(C1761R.id.link_alt_link_label);
        Intrinsics.m26843a(obj2, "link_alt_link_label");
        int paddingTop = obj2.getPaddingTop() + getPaddingTop();
        Object obj3 = (TextView) m29717a(C1761R.id.link_alt_link_label);
        Intrinsics.m26843a(obj3, "link_alt_link_label");
        int paddingRight = obj3.getPaddingRight();
        Object obj4 = (TextView) m29717a(C1761R.id.link_alt_link_label);
        Intrinsics.m26843a(obj4, "link_alt_link_label");
        textView.setPadding(i, paddingTop, paddingRight, obj4.getPaddingBottom() + getPaddingBottom());
        TextView textView2 = (TextView) m29717a(C1761R.id.time_posted_label);
        Object obj5 = (TextView) m29717a(C1761R.id.time_posted_label);
        Intrinsics.m26843a(obj5, "time_posted_label");
        int paddingLeft = obj5.getPaddingLeft();
        obj2 = (TextView) m29717a(C1761R.id.time_posted_label);
        Intrinsics.m26843a(obj2, "time_posted_label");
        paddingTop = obj2.getPaddingTop() + getPaddingTop();
        obj3 = (TextView) m29717a(C1761R.id.time_posted_label);
        Intrinsics.m26843a(obj3, "time_posted_label");
        paddingRight = obj3.getPaddingRight();
        obj4 = (TextView) m29717a(C1761R.id.time_posted_label);
        Intrinsics.m26843a(obj4, "time_posted_label");
        textView2.setPadding(paddingLeft, paddingTop, paddingRight, obj4.getPaddingBottom() + getPaddingBottom());
        textView2 = (TextView) m29717a(C1761R.id.domain_label);
        obj5 = (TextView) m29717a(C1761R.id.domain_label);
        Intrinsics.m26843a(obj5, "domain_label");
        paddingLeft = obj5.getPaddingLeft();
        obj2 = (TextView) m29717a(C1761R.id.domain_label);
        Intrinsics.m26843a(obj2, "domain_label");
        paddingTop = obj2.getPaddingTop() + getPaddingTop();
        obj3 = (TextView) m29717a(C1761R.id.domain_label);
        Intrinsics.m26843a(obj3, "domain_label");
        paddingRight = obj3.getPaddingRight();
        obj4 = (TextView) m29717a(C1761R.id.domain_label);
        Intrinsics.m26843a(obj4, "domain_label");
        textView2.setPadding(paddingLeft, paddingTop, paddingRight, obj4.getPaddingBottom() + getPaddingBottom());
        FrameLayout frameLayout = this.b;
        obj5 = this.b;
        Intrinsics.m26843a(obj5, "overflow");
        paddingLeft = obj5.getPaddingLeft();
        obj2 = this.b;
        Intrinsics.m26843a(obj2, "overflow");
        paddingTop = obj2.getPaddingTop() + getPaddingTop();
        obj3 = this.b;
        Intrinsics.m26843a(obj3, "overflow");
        paddingRight = obj3.getPaddingRight() + getPaddingRight();
        obj4 = this.b;
        Intrinsics.m26843a(obj4, "overflow");
        frameLayout.setPadding(paddingLeft, paddingTop, paddingRight, obj4.getPaddingBottom() + getPaddingBottom());
        this.f28490m = getPaddingRight();
        setPadding(0, 0, 0, 0);
        post(new LinkHeaderView$onFinishInflate$1(this));
    }

    public final void a_(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        Session c = b.c();
        boolean z = (c.isAnonymous() || SessionUtil.m23895a(c, linkPresentationModel.f33985l)) ? false : true;
        boolean z2 = linkPresentationModel.f33973Z;
        MenuItem menuItem = this.f28482e;
        if (menuItem == null) {
            Intrinsics.m26844a("hideItem");
        }
        boolean z3 = z && !z2;
        menuItem.setVisible(z3);
        menuItem = this.f28483f;
        if (menuItem == null) {
            Intrinsics.m26844a("unhideItem");
        }
        z2 = z && z2;
        menuItem.setVisible(z2);
        MenuItem menuItem2 = this.f28484g;
        if (menuItem2 == null) {
            Intrinsics.m26844a("reportItem");
        }
        menuItem2.setVisible(z);
        MenuItem menuItem3 = this.f28485h;
        if (menuItem3 == null) {
            Intrinsics.m26844a("saveItem");
        }
        menuItem3.setVisible(linkPresentationModel.aa ^ true);
        menuItem3 = this.f28486i;
        if (menuItem3 == null) {
            Intrinsics.m26844a("unsaveItem");
        }
        menuItem3.setVisible(linkPresentationModel.aa);
        menuItem3 = this.f28487j;
        if (menuItem3 == null) {
            Intrinsics.m26844a("shareItem");
        }
        menuItem3.setVisible(linkPresentationModel.f33968U);
        TextView textView = (TextView) m29717a(C1761R.id.link_alt_link_label);
        Intrinsics.m26843a((Object) textView, "link_alt_link_label");
        Object context = getContext();
        Intrinsics.m26843a(context, "context");
        Sdk21PropertiesKt.m28412a(textView, ResourcesUtil.m22740i(context, C1761R.attr.rdt_metadata_text_color));
        b = (TextView) m29717a(C1761R.id.link_alt_link_label);
        Intrinsics.m26843a(b, "link_alt_link_label");
        b.setAllCaps(false);
        ((UserIndicatorsView) m29717a(C1761R.id.link_user_indicators)).setActiveIndicators(SetsKt__SetsKt.m26799a());
        if (linkPresentationModel.f33962O) {
            b = (TextView) m29717a(C1761R.id.link_alt_link_label);
            Intrinsics.m26843a(b, "link_alt_link_label");
            b.setText(getContext().getString(C1761R.string.label_promoted));
            textView = (TextView) m29717a(C1761R.id.link_alt_link_label);
            Intrinsics.m26843a((Object) textView, "link_alt_link_label");
            Sdk21PropertiesKt.m28412a(textView, ContextCompat.c(getContext(), C1761R.color.rdt_blue));
            b = (TextView) m29717a(C1761R.id.link_alt_link_label);
            Intrinsics.m26843a(b, "link_alt_link_label");
            b.setAllCaps(true);
        } else if (this.f28488k) {
            b = (TextView) m29717a(C1761R.id.link_alt_link_label);
            Intrinsics.m26843a(b, "link_alt_link_label");
            String str = linkPresentationModel.f33979f;
            if (!(((CharSequence) str).length() > 0)) {
                StringBuilder stringBuilder = new StringBuilder("r/");
                stringBuilder.append(linkPresentationModel.af);
                str = stringBuilder.toString();
            }
            b.setText(str);
        } else {
            boolean z4;
            b = (TextView) m29717a(C1761R.id.link_alt_link_label);
            Intrinsics.m26843a(b, "link_alt_link_label");
            b.setText(Util.m23960a((int) C1761R.string.fmt_u_name, linkPresentationModel.f33985l));
            UserIndicatorsView userIndicatorsView = (UserIndicatorsView) m29717a(C1761R.id.link_user_indicators);
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
                    z4 = false;
                    if (z4) {
                        indicator = null;
                    }
                    indicatorArr[3] = indicator;
                    indicator = Indicator.f20737f;
                    if (linkPresentationModel.f33990q <= 0) {
                        indicator = null;
                    }
                    indicatorArr[4] = indicator;
                    userIndicatorsView.setActiveIndicators(CollectionsKt___CollectionsKt.m41451p(CollectionsKt__CollectionsKt.m26798d(indicatorArr)));
                    textView = (TextView) m29717a(C1761R.id.gilded_count);
                    ViewsKt.m24106b(textView, linkPresentationModel.f33990q <= 1);
                    textView.setText(textView.getContext().getString(C1761R.string.fmt_icon_count, new Object[]{Integer.valueOf(linkPresentationModel.f33990q)}));
                    m24133a(new LinkHeaderView$bindLink$7(linkPresentationModel));
                }
            }
            z4 = true;
            if (z4) {
                indicator = null;
            }
            indicatorArr[3] = indicator;
            indicator = Indicator.f20737f;
            if (linkPresentationModel.f33990q <= 0) {
            }
            if (linkPresentationModel.f33990q <= 0) {
                indicator = null;
            }
            indicatorArr[4] = indicator;
            userIndicatorsView.setActiveIndicators(CollectionsKt___CollectionsKt.m41451p(CollectionsKt__CollectionsKt.m26798d(indicatorArr)));
            textView = (TextView) m29717a(C1761R.id.gilded_count);
            if (linkPresentationModel.f33990q <= 1) {
            }
            ViewsKt.m24106b(textView, linkPresentationModel.f33990q <= 1);
            textView.setText(textView.getContext().getString(C1761R.string.fmt_icon_count, new Object[]{Integer.valueOf(linkPresentationModel.f33990q)}));
            m24133a(new LinkHeaderView$bindLink$7(linkPresentationModel));
        }
        if (linkPresentationModel.f33962O) {
            b = (TextView) m29717a(C1761R.id.time_posted_label);
            Intrinsics.m26843a(b, "time_posted_label");
            b.setText(null);
            b = (TextView) m29717a(C1761R.id.domain_label);
            Intrinsics.m26843a(b, "domain_label");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(getContext().getString(C1761R.string.unicode_delimiter));
            stringBuilder2.append(getContext().getString(C1761R.string.fmt_u_name, new Object[]{linkPresentationModel.f33985l}));
            b.setText(stringBuilder2);
        } else {
            b = (TextView) m29717a(C1761R.id.time_posted_label);
            Intrinsics.m26843a(b, "time_posted_label");
            b.setText(linkPresentationModel.f33983j);
            b = (TextView) m29717a(C1761R.id.domain_label);
            Intrinsics.m26843a(b, "domain_label");
            b.setText(linkPresentationModel.f33984k);
        }
        ((IconStatusView) m29717a(C1761R.id.link_status_view)).m24156a(linkPresentationModel);
        b = (IconStatusView) m29717a(C1761R.id.link_status_view);
        Intrinsics.m26843a(b, "link_status_view");
        ((View) b).setOnClickListener(new LinkHeaderView$inlined$sam$OnClickListener$i$7f478c20(new LinkHeaderView$bindLink$8(this, linkPresentationModel)));
        b = (ImageView) m29717a(C1761R.id.xpost_indicator);
        Intrinsics.m26843a(b, "xpost_indicator");
        ViewsKt.m24106b((View) b, ((Collection) linkPresentationModel.al).isEmpty() ^ 1);
    }

    public final void setClickListener(Function0<Unit> function0) {
        Intrinsics.m26847b(function0, "action");
        Object obj = (TextView) m29717a(C1761R.id.link_alt_link_label);
        Intrinsics.m26843a(obj, "link_alt_link_label");
        ((View) obj).setOnClickListener((OnClickListener) new LinkHeaderView$inlined$sam$OnClickListener$i$7f478c20(new LinkHeaderView$setClickListener$1(function0)));
    }

    public final void setDomainClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
        ((TextView) m29717a(C1761R.id.domain_label)).setOnClickListener(onClickListener);
    }

    public final void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        Intrinsics.m26847b(onMenuItemClickListener, "listener");
        this.d.a(onMenuItemClickListener);
    }

    public final void setDisplaySubredditName(boolean z) {
        this.f28488k = z;
    }

    public final void setShowOverflow(boolean z) {
        Object obj = this.b;
        Intrinsics.m26843a(obj, "overflow");
        ViewsKt.m24106b((View) obj, z);
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, 0, this.f28490m, 0);
        }
    }

    public static final /* synthetic */ void m29715a(LinkHeaderView linkHeaderView, LinkPresentationModel linkPresentationModel) {
        if ((linkPresentationModel.f33969V > 0 ? 1 : null) != null) {
            new PopupModReports(linkHeaderView.getContext(), linkPresentationModel, AppAnalytics.m21849a((View) linkHeaderView), new LinkHeaderView$showReportsPopup$1(linkHeaderView, linkPresentationModel)).m23562b();
        }
    }
}
