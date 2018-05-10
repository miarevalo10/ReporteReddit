package com.reddit.frontpage.widgets.modtools.modview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.util.ModCacheComments;
import com.reddit.frontpage.util.kotlin.AnkoLinearLayout;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import com.reddit.frontpage.widgets.LinkFooterView.OnModerateListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 :2\u00020\u0001:\u0001:B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u00105\u001a\u0002062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u00107\u001a\u0002062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u00108\u001a\u0002062\u0006\u00109\u001a\u00020\u001fH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0018@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006;"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/modview/ModViewBase;", "Lcom/reddit/frontpage/util/kotlin/AnkoLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "actionCompletedListener", "Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;", "getActionCompletedListener", "()Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;", "setActionCompletedListener", "(Lcom/reddit/frontpage/widgets/LinkFooterView$OnModActionCompletedListener;)V", "value", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "comment", "getComment", "()Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;", "setComment", "(Lcom/reddit/datalibrary/frontpage/requests/models/v1/Comment;)V", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "link", "getLink", "()Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;", "setLink", "(Lcom/reddit/datalibrary/frontpage/requests/models/v2/Link;)V", "linkId", "", "getLinkId", "()Ljava/lang/String;", "setLinkId", "(Ljava/lang/String;)V", "modCache", "Lcom/reddit/frontpage/util/ModCacheComments;", "getModCache", "()Lcom/reddit/frontpage/util/ModCacheComments;", "setModCache", "(Lcom/reddit/frontpage/util/ModCacheComments;)V", "moderateListener", "Lcom/reddit/frontpage/widgets/LinkFooterView$OnModerateListener;", "getModerateListener", "()Lcom/reddit/frontpage/widgets/LinkFooterView$OnModerateListener;", "setModerateListener", "(Lcom/reddit/frontpage/widgets/LinkFooterView$OnModerateListener;)V", "type", "getType", "()I", "setType", "(I)V", "bindLink", "", "onCommentSet", "updateDistinguishVisibility", "author", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModViewBase.kt */
public abstract class ModViewBase extends AnkoLinearLayout {
    public static final Companion f29512c = new Companion();
    public OnModerateListener f29513a;
    public ModCacheComments f29514b;
    private Link f29515d;
    private String f29516e;
    private Comment f29517f;
    private OnModActionCompletedListener f29518g;
    private int f29519h;
    private HashMap f29520i;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/modview/ModViewBase$Companion;", "", "()V", "TYPE_COMMENT", "", "TYPE_LINK", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModViewBase.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public ModViewBase(Context context) {
        this(context, null, 0, 6, null);
    }

    public ModViewBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public View mo5068a(int i) {
        if (this.f29520i == null) {
            this.f29520i = new HashMap();
        }
        View view = (View) this.f29520i.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f29520i.put(Integer.valueOf(i), view);
        return view;
    }

    public void mo6534a(Comment comment) {
    }

    public void mo6535a(String str) {
        Intrinsics.m26847b(str, "author");
    }

    public final Link getLink() {
        return this.f29515d;
    }

    public final void setLink(Link link) {
        this.f29515d = link;
        if (!(link == null || link.getAuthor() == null)) {
            String author = link.getAuthor();
            Intrinsics.m26843a((Object) author, "value.author");
            mo6535a(author);
        }
        this.f29519h = null;
    }

    public final String getLinkId() {
        return this.f29516e;
    }

    public final void setLinkId(String str) {
        this.f29516e = str;
    }

    public final Comment getComment() {
        return this.f29517f;
    }

    public final void setComment(Comment comment) {
        this.f29517f = comment;
        if (!(comment == null || comment.c() == null)) {
            String c = comment.c();
            Intrinsics.m26843a((Object) c, "value.author");
            mo6535a(c);
        }
        mo6534a(comment);
        this.f29519h = 1;
    }

    public final OnModerateListener getModerateListener() {
        OnModerateListener onModerateListener = this.f29513a;
        if (onModerateListener == null) {
            Intrinsics.m26844a("moderateListener");
        }
        return onModerateListener;
    }

    public final void setModerateListener(OnModerateListener onModerateListener) {
        Intrinsics.m26847b(onModerateListener, "<set-?>");
        this.f29513a = onModerateListener;
    }

    public OnModActionCompletedListener getActionCompletedListener() {
        return this.f29518g;
    }

    public void setActionCompletedListener(OnModActionCompletedListener onModActionCompletedListener) {
        this.f29518g = onModActionCompletedListener;
    }

    public final ModCacheComments getModCache() {
        ModCacheComments modCacheComments = this.f29514b;
        if (modCacheComments == null) {
            Intrinsics.m26844a("modCache");
        }
        return modCacheComments;
    }

    public final void setModCache(ModCacheComments modCacheComments) {
        Intrinsics.m26847b(modCacheComments, "<set-?>");
        this.f29514b = modCacheComments;
    }

    protected final int getType() {
        return this.f29519h;
    }

    protected final void setType(int i) {
        this.f29519h = i;
    }

    public /* synthetic */ ModViewBase(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ModViewBase(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public ModViewBase(Context context, AttributeSet attributeSet, int i, int i2) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i, i2);
    }
}
