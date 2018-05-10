package com.reddit.frontpage.presentation.modtools.ban.add;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.ui.view.UserIndicatorsView;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0004R\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001c\u0010\u0014R\u001b\u0010\u001e\u001a\u00020\u001f8FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010!¨\u0006-"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/BannedForCommentView;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "authorIndicators", "Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;", "getAuthorIndicators", "()Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;", "authorIndicators$delegate", "Lkotlin/Lazy;", "authorView", "Landroid/widget/TextView;", "getAuthorView", "()Landroid/widget/TextView;", "authorView$delegate", "body", "Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "getBody", "()Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "body$delegate", "flair", "getFlair", "flair$delegate", "header", "Landroid/view/View;", "getHeader", "()Landroid/view/View;", "header$delegate", "attachComment", "", "comment", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "expanded", "", "updateHeader", "session", "Lcom/reddit/datalibrary/frontpage/redditauth/account/Session;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BannedForCommentView.kt */
public final class BannedForCommentView extends ConstraintLayout {
    static final /* synthetic */ KProperty[] f28579h = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(BannedForCommentView.class), "header", "getHeader()Landroid/view/View;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(BannedForCommentView.class), "body", "getBody()Lcom/reddit/frontpage/widgets/BaseHtmlTextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(BannedForCommentView.class), "authorView", "getAuthorView()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(BannedForCommentView.class), "authorIndicators", "getAuthorIndicators()Lcom/reddit/frontpage/presentation/listing/ui/view/UserIndicatorsView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(BannedForCommentView.class), "flair", "getFlair()Landroid/widget/TextView;"))};
    public static final Companion f28580i = new Companion();
    private static final String f28581o = "moderator";
    private static final String f28582p = "admin";
    private final Lazy f28583j;
    private final Lazy f28584k;
    private final Lazy f28585l;
    private final Lazy f28586m;
    private final Lazy f28587n;
    private HashMap f28588q;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/BannedForCommentView$Companion;", "", "()V", "DISTINGUISH_ADMIN", "", "getDISTINGUISH_ADMIN", "()Ljava/lang/String;", "DISTINGUISH_MODERATOR", "getDISTINGUISH_MODERATOR", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BannedForCommentView.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public BannedForCommentView(Context context) {
        this(context, null, 0, 6, null);
    }

    public BannedForCommentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final View m29751a(int i) {
        if (this.f28588q == null) {
            this.f28588q = new HashMap();
        }
        View view = (View) this.f28588q.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f28588q.put(Integer.valueOf(i), view);
        return view;
    }

    public final UserIndicatorsView getAuthorIndicators() {
        return (UserIndicatorsView) this.f28586m.mo5678b();
    }

    public final TextView getAuthorView() {
        return (TextView) this.f28585l.mo5678b();
    }

    public final BaseHtmlTextView getBody() {
        return (BaseHtmlTextView) this.f28584k.mo5678b();
    }

    public final TextView getFlair() {
        return (TextView) this.f28587n.mo5678b();
    }

    public final View getHeader() {
        return (View) this.f28583j.mo5678b();
    }

    public /* synthetic */ BannedForCommentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public BannedForCommentView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
        this.f28583j = LazyKt.m26777a((Function0) new BannedForCommentView$header$2(this));
        this.f28584k = LazyKt.m26777a((Function0) new BannedForCommentView$body$2(this));
        this.f28585l = LazyKt.m26777a((Function0) new BannedForCommentView$authorView$2(this));
        this.f28586m = LazyKt.m26777a((Function0) new BannedForCommentView$authorIndicators$2(this));
        this.f28587n = LazyKt.m26777a((Function0) new BannedForCommentView$flair$2(this));
        View.inflate(context, C1761R.layout.banned_for_comment_view, this);
    }

    @TargetApi(21)
    public BannedForCommentView(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        this(context, attributeSet, i);
    }
}
