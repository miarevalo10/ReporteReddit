package com.reddit.frontpage.widgets.modtools.modview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.AnkoLinearLayout;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import com.reddit.frontpage.widgets.LinkFooterView.OnModerateListener;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020+R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019¨\u0006,"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/modview/ModView;", "Lcom/reddit/frontpage/util/kotlin/AnkoLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "modViewLeft", "Lcom/reddit/frontpage/widgets/modtools/modview/ModViewLeft;", "getModViewLeft", "()Lcom/reddit/frontpage/widgets/modtools/modview/ModViewLeft;", "modViewLeft$delegate", "Lkotlin/Lazy;", "modViewRight", "Lcom/reddit/frontpage/widgets/modtools/modview/ModViewRight;", "getModViewRight", "()Lcom/reddit/frontpage/widgets/modtools/modview/ModViewRight;", "modViewRight$delegate", "separator", "Landroid/view/View;", "getSeparator", "()Landroid/view/View;", "separator$delegate", "bindComment", "", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "bindLink", "link", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "hideListView", "hideModViewLeft", "hideModViewRight", "setActionCompletedListener", "listener", "Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;", "setComment", "setLink", "setModerateListener", "Lcom/reddit/frontpage/widgets/LinkFooterView$OnModerateListener;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModView.kt */
public final class ModView extends AnkoLinearLayout {
    static final /* synthetic */ KProperty[] f29507a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModView.class), "modViewLeft", "getModViewLeft()Lcom/reddit/frontpage/widgets/modtools/modview/ModViewLeft;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModView.class), "modViewRight", "getModViewRight()Lcom/reddit/frontpage/widgets/modtools/modview/ModViewRight;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ModView.class), "separator", "getSeparator()Landroid/view/View;"))};
    private final Lazy f29508b;
    private final Lazy f29509c;
    private final Lazy f29510d;
    private HashMap f29511e;

    public ModView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ModView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final View getSeparator() {
        return (View) this.f29510d.mo5678b();
    }

    public final View mo5068a(int i) {
        if (this.f29511e == null) {
            this.f29511e = new HashMap();
        }
        View view = (View) this.f29511e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f29511e.put(Integer.valueOf(i), view);
        return view;
    }

    public final ModViewLeft getModViewLeft() {
        return (ModViewLeft) this.f29508b.mo5678b();
    }

    public final ModViewRight getModViewRight() {
        return (ModViewRight) this.f29509c.mo5678b();
    }

    public final void setModerateListener(OnModerateListener onModerateListener) {
        Intrinsics.m26847b(onModerateListener, "listener");
        ModViewRight modViewRight = getModViewRight();
        if (modViewRight != null) {
            modViewRight.setModerateListener(onModerateListener);
        }
        ModViewLeft modViewLeft = getModViewLeft();
        if (modViewLeft != null) {
            modViewLeft.setModerateListener(onModerateListener);
        }
    }

    public final void setActionCompletedListener(OnModActionCompletedListener onModActionCompletedListener) {
        Intrinsics.m26847b(onModActionCompletedListener, "listener");
        ModViewRight modViewRight = getModViewRight();
        if (modViewRight != null) {
            modViewRight.setActionCompletedListener(onModActionCompletedListener);
        }
        ModViewLeft modViewLeft = getModViewLeft();
        if (modViewLeft != null) {
            modViewLeft.setActionCompletedListener(onModActionCompletedListener);
        }
    }

    public final void setLink(Link link) {
        Intrinsics.m26847b(link, "link");
        ModViewLeft modViewLeft = getModViewLeft();
        if (modViewLeft != null) {
            modViewLeft.setLink(link);
        }
        ModViewRight modViewRight = getModViewRight();
        if (modViewRight != null) {
            modViewRight.setLink(link);
        }
    }

    public final void setComment(Comment comment) {
        Intrinsics.m26847b(comment, "comment");
        ModViewLeft modViewLeft = getModViewLeft();
        if (modViewLeft != null) {
            modViewLeft.setComment(comment);
        }
        ModViewRight modViewRight = getModViewRight();
        if (modViewRight != null) {
            modViewRight.setComment(comment);
        }
    }

    public /* synthetic */ ModView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ModView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f29508b = LazyKt.m26777a((Function0) new ModView$modViewLeft$2(this));
        this.f29509c = LazyKt.m26777a((Function0) new ModView$modViewRight$2(this));
        this.f29510d = LazyKt.m26777a((Function0) new ModView$separator$2(this));
        View.inflate(getContext(), C1761R.layout.mod_view, this);
    }

    @TargetApi(21)
    public ModView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i, i2);
        this.f29508b = LazyKt.m26777a((Function0) new ModView$modViewLeft$2(this));
        this.f29509c = LazyKt.m26777a((Function0) new ModView$modViewRight$2(this));
        this.f29510d = LazyKt.m26777a((Function0) new ModView$separator$2(this));
        View.inflate(getContext(), C1761R.layout.mod_view, this);
    }
}
