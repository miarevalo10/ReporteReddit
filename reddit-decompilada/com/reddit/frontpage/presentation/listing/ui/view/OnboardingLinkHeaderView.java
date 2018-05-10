package com.reddit.frontpage.presentation.listing.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.ShapedIconView;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\"2\u0006\u0010&\u001a\u00020)H\u0016J$\u0010(\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010-\u001a\u0004\u0018\u00010+H\u0002J\u0015\u0010.\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u00100J\u0016\u00101\u001a\u00020\"2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\"03H\u0016J\u0010\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\fH\u0016J\u0010\u00106\u001a\u00020\"2\u0006\u0010#\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\"2\u0006\u0010#\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020\fH\u0016J\u0014\u0010<\u001a\u00020\"2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\"03J\u000e\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\fJ\u000e\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020+J\b\u0010A\u001a\u00020\"H\u0002R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b\u001f\u0010\u0017¨\u0006B"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/ui/view/OnboardingLinkHeaderView;", "Landroid/support/constraint/ConstraintLayout;", "Lcom/reddit/frontpage/presentation/listing/ui/view/LinkHeader;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "categoryColor", "isSubscribed", "", "()Z", "subredditIconView", "Lcom/reddit/frontpage/widgets/ShapedIconView;", "getSubredditIconView", "()Lcom/reddit/frontpage/widgets/ShapedIconView;", "subredditIconView$delegate", "Lkotlin/Lazy;", "subredditName", "Landroid/widget/TextView;", "getSubredditName", "()Landroid/widget/TextView;", "subredditName$delegate", "subscribeButton", "Landroid/widget/Button;", "getSubscribeButton", "()Landroid/widget/Button;", "subscribeButton$delegate", "subscriberCount", "getSubscriberCount", "subscriberCount$delegate", "addRunnableToOverflowClickListener", "", "listener", "Ljava/lang/Runnable;", "bindLegacyLink", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "bindLink", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "displayName", "", "iconImage", "keyColor", "setCategoryColor", "color", "(Ljava/lang/Integer;)V", "setClickListener", "action", "Lkotlin/Function0;", "setDisplaySubredditName", "showDisplaySubredditName", "setDomainClickListener", "Landroid/view/View$OnClickListener;", "setOnMenuItemClickListener", "Landroid/support/v7/widget/PopupMenu$OnMenuItemClickListener;", "setShowOverflow", "showOverflow", "setSubscribeClickListener", "setSubscribed", "subscribed", "setSubscriberCount", "count", "updateSubscribeButton", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: OnboardingLinkHeaderView.kt */
public final class OnboardingLinkHeaderView extends ConstraintLayout implements LinkHeader {
    static final /* synthetic */ KProperty[] f28494h = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingLinkHeaderView.class), "subredditIconView", "getSubredditIconView()Lcom/reddit/frontpage/widgets/ShapedIconView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingLinkHeaderView.class), "subredditName", "getSubredditName()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingLinkHeaderView.class), "subscriberCount", "getSubscriberCount()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(OnboardingLinkHeaderView.class), "subscribeButton", "getSubscribeButton()Landroid/widget/Button;"))};
    private final Lazy f28495i;
    private final Lazy f28496j;
    private final Lazy f28497k;
    private final Lazy f28498l;
    private int f28499m;
    private HashMap f28500n;

    public OnboardingLinkHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final ShapedIconView getSubredditIconView() {
        return (ShapedIconView) this.f28495i.mo5678b();
    }

    private final TextView getSubredditName() {
        return (TextView) this.f28496j.mo5678b();
    }

    private final Button getSubscribeButton() {
        return (Button) this.f28498l.mo5678b();
    }

    private final TextView getSubscriberCount() {
        return (TextView) this.f28497k.mo5678b();
    }

    public final View m29719a(int i) {
        if (this.f28500n == null) {
            this.f28500n = new HashMap();
        }
        View view = (View) this.f28500n.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f28500n.put(Integer.valueOf(i), view);
        return view;
    }

    public final void setDisplaySubredditName(boolean z) {
    }

    public final void setDomainClickListener(OnClickListener onClickListener) {
        Intrinsics.m26847b(onClickListener, "listener");
    }

    public final void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        Intrinsics.m26847b(onMenuItemClickListener, "listener");
    }

    public final void setShowOverflow(boolean z) {
    }

    public /* synthetic */ OnboardingLinkHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public OnboardingLinkHeaderView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super(context, attributeSet, i);
        this.f28495i = LazyKt.m26777a((Function0) new OnboardingLinkHeaderView$subredditIconView$2(this));
        this.f28496j = LazyKt.m26777a((Function0) new OnboardingLinkHeaderView$subredditName$2(this));
        this.f28497k = LazyKt.m26777a((Function0) new OnboardingLinkHeaderView$subscriberCount$2(this));
        this.f28498l = LazyKt.m26777a((Function0) new OnboardingLinkHeaderView$subscribeButton$2(this));
        View.inflate(context, C1761R.layout.merge_link_header_onboarding, this);
        this.f28499m = ResourcesUtil.m22740i(context, C1761R.attr.rdt_button_text_color);
        m29718b();
    }

    public final void setClickListener(Function0<Unit> function0) {
        Intrinsics.m26847b(function0, "action");
        getSubredditName().setOnClickListener(new OnboardingLinkHeaderView$setClickListener$1(function0));
        getSubscriberCount().setOnClickListener(new OnboardingLinkHeaderView$setClickListener$2(function0));
    }

    public final void m29720a(String str, String str2, String str3) {
        Util.m23985a(getSubredditIconView(), str, str2, str3);
        getSubredditName().setText(str);
    }

    public final void setSubscriberCount(String str) {
        Intrinsics.m26847b(str, "count");
        getSubscriberCount().setText(getContext().getString(C1761R.string.fmt_num_subscribers_simple, new Object[]{str}));
    }

    public final void setSubscribed(boolean z) {
        if (getSubscribeButton().isActivated() != z) {
            getSubscribeButton().setActivated(z);
            m29718b();
        }
    }

    public final void setCategoryColor(Integer num) {
        if (num != null) {
            this.f28499m = num.intValue();
            m29718b();
        }
    }

    public final void setSubscribeClickListener(Function0<Unit> function0) {
        Intrinsics.m26847b(function0, "action");
        getSubscribeButton().setOnClickListener(new OnboardingLinkHeaderView$setSubscribeClickListener$1(function0));
    }

    private final void m29718b() {
        Button subscribeButton = getSubscribeButton();
        Drawable background = subscribeButton.getBackground();
        Intrinsics.m26843a((Object) background, "background");
        ResourcesUtil.m22722a(background, this.f28499m);
        background = subscribeButton.getCompoundDrawablesRelative()[0];
        if (getSubscribeButton().isActivated()) {
            subscribeButton.setText(null);
            Intrinsics.m26843a((Object) background, "icon");
            ResourcesUtil.m22722a(background, this.f28499m);
            subscribeButton.setCompoundDrawablePadding(0);
            return;
        }
        subscribeButton.setText(subscribeButton.getContext().getText(C1761R.string.action_subscribe));
        Context context = subscribeButton.getContext();
        Intrinsics.m26843a((Object) context, "context");
        Intrinsics.m26843a((Object) background, "icon");
        ResourcesUtil.m22721a(context, background, (int) C1761R.attr.rdt_button_text_color);
        subscribeButton.setCompoundDrawablePadding(Util.m24012d((int) C1761R.dimen.half_pad));
    }

    public final void a_(LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(linkPresentationModel, "link");
        m29720a(linkPresentationModel.f33979f, linkPresentationModel.ai, linkPresentationModel.ah);
    }
}
