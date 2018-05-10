package com.reddit.frontpage.widgets.modtools.modview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020!H\u0002J\u0012\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-H\u0016R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001d\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001e\u0010\u0015¨\u0006."}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/modview/ModViewRight;", "Lcom/reddit/frontpage/widgets/modtools/modview/ModViewBase;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;", "actionCompletedListener", "getActionCompletedListener", "()Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;", "setActionCompletedListener", "(Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;)V", "communityHasFlairs", "", "distinguishView", "Landroid/widget/ImageView;", "getDistinguishView", "()Landroid/widget/ImageView;", "distinguishView$delegate", "Lkotlin/Lazy;", "flairDisposable", "Lio/reactivex/disposables/Disposable;", "listView", "getListView", "listView$delegate", "tagView", "getTagView", "tagView$delegate", "bindLink", "", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "disposeFlairDisposable", "onCommentSet", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "resetTint", "drawable", "Landroid/graphics/drawable/Drawable;", "updateDistinguishVisibility", "author", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModViewRight.kt */
public final class ModViewRight extends ModViewBase {
    static final /* synthetic */ KProperty[] f34533d = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModViewRight.class), "distinguishView", "getDistinguishView()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModViewRight.class), "tagView", "getTagView()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModViewRight.class), "listView", "getListView()Landroid/widget/ImageView;"))};
    private final Lazy f34534e;
    private final Lazy f34535f;
    private final Lazy f34536g;
    private Disposable f34537h;
    private OnModActionCompletedListener f34538i;
    private boolean f34539j;
    private HashMap f34540k;

    public ModViewRight(Context context) {
        this(context, null, 0, 6, null);
    }

    public ModViewRight(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final ImageView getTagView() {
        return (ImageView) this.f34535f.mo5678b();
    }

    public final View mo5068a(int i) {
        if (this.f34540k == null) {
            this.f34540k = new HashMap();
        }
        View view = (View) this.f34540k.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f34540k.put(Integer.valueOf(i), view);
        return view;
    }

    public final ImageView getDistinguishView() {
        return (ImageView) this.f34534e.mo5678b();
    }

    public final ImageView getListView() {
        return (ImageView) this.f34536g.mo5678b();
    }

    public /* synthetic */ ModViewRight(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ModViewRight(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f34534e = LazyKt.m26777a((Function0) new ModViewRight$distinguishView$2(this));
        this.f34535f = LazyKt.m26777a((Function0) new ModViewRight$tagView$2(this));
        this.f34536g = LazyKt.m26777a((Function0) new ModViewRight$listView$2(this));
        this.f34539j = true;
        View.inflate(context, C1761R.layout.mod_view_right, this);
        attributeSet = getDistinguishView();
        Drawable drawable = getDistinguishView().getDrawable();
        Intrinsics.m26843a((Object) drawable, "distinguishView.drawable");
        attributeSet.setImageDrawable(ResourcesUtil.m22733e(context, drawable));
        attributeSet.setOnClickListener((OnClickListener) new ModViewRight$$special$$inlined$apply$lambda$1(this, context));
        attributeSet = getListView();
        drawable = getListView().getDrawable();
        Intrinsics.m26843a((Object) drawable, "listView.drawable");
        attributeSet.setImageDrawable(ResourcesUtil.m22733e(context, drawable));
        attributeSet.setOnClickListener((OnClickListener) new ModViewRight$$special$$inlined$apply$lambda$2(attributeSet, this, context));
        attributeSet = getTagView();
        drawable = getTagView().getDrawable();
        Intrinsics.m26843a((Object) drawable, "tagView.drawable");
        attributeSet.setImageDrawable(ResourcesUtil.m22733e(context, drawable));
        attributeSet.setOnClickListener((OnClickListener) new ModViewRight$$special$$inlined$apply$lambda$3(this, context));
    }

    public final OnModActionCompletedListener getActionCompletedListener() {
        return this.f34538i;
    }

    public final void setActionCompletedListener(OnModActionCompletedListener onModActionCompletedListener) {
        this.f34538i = new ModViewRight$actionCompletedListener$1(this, onModActionCompletedListener);
    }

    public final void mo6534a(Comment comment) {
        Object a = ModUtil.m23823a(comment != null ? comment.a() : null);
        Intrinsics.m26843a(a, "ModUtil.commentsCache(comment?.parentId)");
        setModCache(a);
    }

    public final void mo6535a(String str) {
        Intrinsics.m26847b(str, "author");
        Object b = SessionManager.b();
        Intrinsics.m26843a(b, "SessionManager.getInstance()");
        Account d = b.d();
        Boolean bool = null;
        if (Intrinsics.m26845a((Object) str, d != null ? d.getName() : null) != null) {
            getDistinguishView().setVisibility(0);
            str = getLink();
            if ((str != null ? Boolean.valueOf(str.isDistinguished()) : null) != null) {
                str = getLink();
                if ((str != null ? str.getName() : null) != null) {
                    str = ModUtil.m23824a();
                    Link link = getLink();
                    String name = link != null ? link.getName() : null;
                    Link link2 = getLink();
                    if (link2 != null) {
                        bool = Boolean.valueOf(link2.isDistinguished());
                    }
                    if (bool == null) {
                        Intrinsics.m26842a();
                    }
                    if (str.getDistinguishState(name, bool.booleanValue()) != null) {
                        str = getDistinguishView().getDrawable();
                        b = getContext();
                        Intrinsics.m26843a(b, "context");
                        DrawableCompat.a(str, b.getResources().getColor(C1761R.color.rdt_green));
                        return;
                    }
                }
            }
            Drawable drawable = getDistinguishView().getDrawable();
            Intrinsics.m26843a((Object) drawable, "distinguishView.drawable");
            m35309a(drawable);
            return;
        }
        getDistinguishView().setVisibility(8);
    }

    private final void m35309a(Drawable drawable) {
        Object context = getContext();
        Intrinsics.m26843a(context, "context");
        DrawableCompat.a(drawable, ResourcesUtil.m22740i(context, C1761R.attr.rdt_action_icon_color));
    }

    public static final /* synthetic */ void m35310a(ModViewRight modViewRight) {
        if (modViewRight.f34537h != null) {
            modViewRight = modViewRight.f34537h;
            if (modViewRight == null) {
                Intrinsics.m26842a();
            }
            modViewRight.mo5626a();
        }
    }
}
