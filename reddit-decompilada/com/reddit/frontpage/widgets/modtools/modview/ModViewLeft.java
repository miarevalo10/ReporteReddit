package com.reddit.frontpage.widgets.modtools.modview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016R\u001b\u0010\t\u001a\u00020\n8DX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8DX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\n8DX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0013\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/modview/ModViewLeft;", "Lcom/reddit/frontpage/widgets/modtools/modview/ModViewBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "approveView", "Landroid/widget/ImageView;", "getApproveView", "()Landroid/widget/ImageView;", "approveView$delegate", "Lkotlin/Lazy;", "removeView", "getRemoveView", "removeView$delegate", "spamView", "getSpamView", "spamView$delegate", "approveEnabled", "", "isEnabled", "", "onApprove", "onCommentSet", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "onMarkSpam", "onRemove", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModViewLeft.kt */
public class ModViewLeft extends ModViewBase {
    static final /* synthetic */ KProperty[] f34528d = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModViewLeft.class), "approveView", "getApproveView()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModViewLeft.class), "removeView", "getRemoveView()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModViewLeft.class), "spamView", "getSpamView()Landroid/widget/ImageView;"))};
    private final Lazy f34529e;
    private final Lazy f34530f;
    private final Lazy f34531g;
    private HashMap f34532h;

    public ModViewLeft(Context context) {
        this(context, null, 0, 6, null);
    }

    public ModViewLeft(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public View mo5068a(int i) {
        if (this.f34532h == null) {
            this.f34532h = new HashMap();
        }
        View view = (View) this.f34532h.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f34532h.put(Integer.valueOf(i), view);
        return view;
    }

    protected final ImageView getApproveView() {
        return (ImageView) this.f34529e.mo5678b();
    }

    protected final ImageView getRemoveView() {
        return (ImageView) this.f34530f.mo5678b();
    }

    protected final ImageView getSpamView() {
        return (ImageView) this.f34531g.mo5678b();
    }

    public /* synthetic */ ModViewLeft(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ModViewLeft(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f34529e = LazyKt.m26777a((Function0) new ModViewLeft$approveView$2(this));
        this.f34530f = LazyKt.m26777a((Function0) new ModViewLeft$removeView$2(this));
        this.f34531g = LazyKt.m26777a((Function0) new ModViewLeft$spamView$2(this));
        View.inflate(context, C1761R.layout.mod_view_left, this);
        attributeSet = getApproveView();
        Drawable drawable = getApproveView().getDrawable();
        Intrinsics.m26843a((Object) drawable, "approveView.drawable");
        attributeSet.setImageDrawable(ResourcesUtil.m22733e(context, drawable));
        attributeSet.setOnClickListener((OnClickListener) new ModViewLeft$$special$$inlined$apply$lambda$1(this, context));
        attributeSet = getRemoveView();
        drawable = getRemoveView().getDrawable();
        Intrinsics.m26843a((Object) drawable, "removeView.drawable");
        attributeSet.setImageDrawable(ResourcesUtil.m22733e(context, drawable));
        attributeSet.setOnClickListener((OnClickListener) new ModViewLeft$$special$$inlined$apply$lambda$2(this, context));
        attributeSet = getSpamView();
        drawable = getSpamView().getDrawable();
        Intrinsics.m26843a((Object) drawable, "spamView.drawable");
        attributeSet.setImageDrawable(ResourcesUtil.m22733e(context, drawable));
        attributeSet.setOnClickListener((OnClickListener) new ModViewLeft$$special$$inlined$apply$lambda$3(this, context));
    }

    public final void m35306a(boolean z) {
        getApproveView().setVisibility(z ? false : true);
    }

    public final void mo6534a(Comment comment) {
        Object a = ModUtil.m23823a(comment != null ? comment.getName() : null);
        Intrinsics.m26843a(a, "ModUtil.commentsCache(comment?.name)");
        setModCache(a);
    }

    public void mo7026a() {
        Link link;
        Thing thing;
        if (getType() == 0) {
            link = getLink();
            if (link == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Thing");
            }
            thing = link;
        } else {
            Comment comment = getComment();
            if (comment == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Thing");
            }
            thing = comment;
        }
        getApproveView().setColorFilter(Util.m23950a((int) C1761R.color.rdt_green));
        getRemoveView().clearColorFilter();
        getSpamView().clearColorFilter();
        if (getType() == 0) {
            ModUtil.m23824a().cacheApprovedState(thing.getName(), Boolean.valueOf(true));
        } else {
            ModUtil.m23823a(thing.getName()).cacheApprovedState(thing.getName(), Boolean.valueOf(true));
        }
        getModerateListener().mo5036c(thing);
        link = getLink();
        Subreddit subredditDetail = link != null ? link.getSubredditDetail() : null;
        if (subredditDetail != null) {
            ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a("modmode")).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20045d.f20068M);
            String name = subredditDetail.getName();
            Object obj = subredditDetail.display_name;
            Intrinsics.m26843a(obj, "subreddit.display_name");
            ModEventBuilder modEventBuilder2 = (ModEventBuilder) modEventBuilder.m21889a(name, obj);
            Link link2 = getLink();
            if (link2 == null) {
                Intrinsics.m26842a();
            }
            String name2 = link2.getName();
            name = String.valueOf(Util.m23952a(getLink()));
            Link link3 = getLink();
            if (link3 == null) {
                Intrinsics.m26842a();
            }
            Object title = link3.getTitle();
            Intrinsics.m26843a(title, "link!!.title");
            ((ModEventBuilder) modEventBuilder2.m21890a(name2, name, title)).m21891a();
        }
        OnModActionCompletedListener actionCompletedListener = getActionCompletedListener();
        if (actionCompletedListener != null) {
            actionCompletedListener.mo4891a();
        }
        Screens.m22631a(getContext(), (int) C1761R.string.success_post_approved);
    }

    public void mo7027b() {
        Link link;
        Thing thing;
        if (getType() == 0) {
            link = getLink();
            if (link == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Thing");
            }
            thing = link;
        } else {
            Comment comment = getComment();
            if (comment == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Thing");
            }
            thing = comment;
        }
        getRemoveView().setColorFilter(Util.m23950a((int) C1761R.color.rdt_salmon));
        getApproveView().clearColorFilter();
        getSpamView().clearColorFilter();
        if (getType() == 0) {
            ModUtil.m23824a().cacheRemovedState(thing.getName(), Boolean.valueOf(true));
        } else {
            ModUtil.m23823a(thing.getName()).cacheRemovedState(thing.getName(), Boolean.valueOf(true));
        }
        getModerateListener().mo5031a(thing);
        link = getLink();
        Subreddit subredditDetail = link != null ? link.getSubredditDetail() : null;
        if (subredditDetail != null) {
            ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a("modmode")).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20046e.f20068M);
            String name = subredditDetail.getName();
            Object obj = subredditDetail.display_name;
            Intrinsics.m26843a(obj, "subreddit.display_name");
            ModEventBuilder modEventBuilder2 = (ModEventBuilder) modEventBuilder.m21889a(name, obj);
            Link link2 = getLink();
            if (link2 == null) {
                Intrinsics.m26842a();
            }
            String name2 = link2.getName();
            name = String.valueOf(Util.m23952a(getLink()));
            Link link3 = getLink();
            if (link3 == null) {
                Intrinsics.m26842a();
            }
            Object title = link3.getTitle();
            Intrinsics.m26843a(title, "link!!.title");
            ((ModEventBuilder) modEventBuilder2.m21890a(name2, name, title)).m21891a();
        }
        OnModActionCompletedListener actionCompletedListener = getActionCompletedListener();
        if (actionCompletedListener != null) {
            actionCompletedListener.mo4891a();
        }
        Screens.m22631a(getContext(), (int) C1761R.string.success_post_removed);
    }

    public void mo7028c() {
        Link link;
        Thing thing;
        if (getType() == 0) {
            link = getLink();
            if (link == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Thing");
            }
            thing = link;
        } else {
            Comment comment = getComment();
            if (comment == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.datalibrary.frontpage.requests.models.v1.Thing");
            }
            thing = comment;
        }
        getSpamView().setColorFilter(Util.m23950a((int) C1761R.color.rdt_salmon));
        getRemoveView().clearColorFilter();
        getApproveView().clearColorFilter();
        if (getType() == 0) {
            ModUtil.m23824a().m30458d(thing.getName(), Boolean.valueOf(true));
        } else {
            ModUtil.m23823a(thing.getName()).m30450a(thing.getName(), Boolean.valueOf(true));
        }
        getModerateListener().mo5034b(thing);
        link = getLink();
        Subreddit subredditDetail = link != null ? link.getSubredditDetail() : null;
        if (subredditDetail != null) {
            ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a("modmode")).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20047f.f20068M);
            String name = subredditDetail.getName();
            Object obj = subredditDetail.display_name;
            Intrinsics.m26843a(obj, "subreddit.display_name");
            ModEventBuilder modEventBuilder2 = (ModEventBuilder) modEventBuilder.m21889a(name, obj);
            Link link2 = getLink();
            if (link2 == null) {
                Intrinsics.m26842a();
            }
            String name2 = link2.getName();
            name = String.valueOf(Util.m23952a(getLink()));
            Link link3 = getLink();
            if (link3 == null) {
                Intrinsics.m26842a();
            }
            Object title = link3.getTitle();
            Intrinsics.m26843a(title, "link!!.title");
            ((ModEventBuilder) modEventBuilder2.m21890a(name2, name, title)).m21891a();
        }
        OnModActionCompletedListener actionCompletedListener = getActionCompletedListener();
        if (actionCompletedListener != null) {
            actionCompletedListener.mo4891a();
        }
        Screens.m22631a(getContext(), (int) C1761R.string.success_post_removed_spam);
    }
}
