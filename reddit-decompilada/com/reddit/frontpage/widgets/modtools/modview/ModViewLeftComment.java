package com.reddit.frontpage.widgets.modtools.modview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.nav.Screens;
import com.reddit.frontpage.util.ModCacheComments;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/widgets/modtools/modview/ModViewLeftComment;", "Lcom/reddit/frontpage/widgets/modtools/modview/ModViewLeft;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onApprove", "", "onMarkSpam", "onRemove", "sendAnalytics", "noun", "", "subreddit", "Lcom/reddit/datalibrary/frontpage/requests/models/v1/Subreddit;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModViewLeftComment.kt */
public final class ModViewLeftComment extends ModViewLeft {
    private HashMap f37453e;

    public ModViewLeftComment(Context context) {
        this(context, null, 0, 6, null);
    }

    public ModViewLeftComment(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final View mo5068a(int i) {
        if (this.f37453e == null) {
            this.f37453e = new HashMap();
        }
        View view = (View) this.f37453e.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f37453e.put(Integer.valueOf(i), view);
        return view;
    }

    public /* synthetic */ ModViewLeftComment(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != null) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public ModViewLeftComment(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, attributeSet, i);
    }

    public final void mo7026a() {
        ModCacheComments modCache = getModCache();
        Comment comment = getComment();
        Subreddit subreddit = null;
        modCache.cacheApprovedState(comment != null ? comment.getName() : null, Boolean.valueOf(true));
        getModerateListener().mo5036c(getComment());
        Link link = getLink();
        if (link != null) {
            subreddit = link.getSubredditDetail();
        }
        OnModActionCompletedListener actionCompletedListener = getActionCompletedListener();
        if (actionCompletedListener != null) {
            actionCompletedListener.mo4891a();
        }
        Screens.m22631a(getContext(), (int) C1761R.string.success_comment_approved);
        if (subreddit != null && getComment() != null) {
            m37848a(ModNoun.f20051j.f20068M, subreddit);
        }
    }

    public final void mo7027b() {
        ModCacheComments modCache = getModCache();
        Comment comment = getComment();
        Subreddit subreddit = null;
        modCache.cacheRemovedState(comment != null ? comment.getName() : null, Boolean.valueOf(true));
        getApproveView().setVisibility(0);
        getModerateListener().mo5031a(getComment());
        OnModActionCompletedListener actionCompletedListener = getActionCompletedListener();
        if (actionCompletedListener != null) {
            actionCompletedListener.mo4891a();
        }
        Link link = getLink();
        if (link != null) {
            subreddit = link.getSubredditDetail();
        }
        Screens.m22631a(getContext(), (int) C1761R.string.success_comment_removed);
        if (subreddit != null && getComment() != null) {
            m37848a(ModNoun.f20052k.f20068M, subreddit);
        }
    }

    public final void mo7028c() {
        ModCacheComments modCache = getModCache();
        Comment comment = getComment();
        Subreddit subreddit = null;
        modCache.m30450a(comment != null ? comment.getName() : null, Boolean.valueOf(true));
        getApproveView().setVisibility(0);
        getModerateListener().mo5034b(getComment());
        OnModActionCompletedListener actionCompletedListener = getActionCompletedListener();
        if (actionCompletedListener != null) {
            actionCompletedListener.mo4891a();
        }
        Link link = getLink();
        if (link != null) {
            subreddit = link.getSubredditDetail();
        }
        Screens.m22631a(getContext(), (int) C1761R.string.success_comment_removed_spam);
        if (subreddit != null && getComment() != null) {
            m37848a(ModNoun.f20053l.f20068M, subreddit);
        }
    }

    private final void m37848a(String str, Subreddit subreddit) {
        if (getComment() != null) {
            if (getLink() != null) {
                ModEventBuilder modEventBuilder = (ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) AppAnalytics.m21880q().m21888a("modmode")).m21892b(ModEventBuilder.f27450a)).m21895c(str);
                String name = subreddit.getName();
                Object obj = subreddit.display_name;
                Intrinsics.m26843a(obj, "subreddit.display_name");
                modEventBuilder = (ModEventBuilder) modEventBuilder.m21889a(name, obj);
                subreddit = getLink();
                if (subreddit == null) {
                    Intrinsics.m26842a();
                }
                subreddit = subreddit.getName();
                name = String.valueOf(Util.m23952a(getLink()));
                Link link = getLink();
                if (link == null) {
                    Intrinsics.m26842a();
                }
                Object title = link.getTitle();
                Intrinsics.m26843a(title, "link!!.title");
                modEventBuilder = (ModEventBuilder) modEventBuilder.m21890a(subreddit, name, title);
                subreddit = getComment();
                if (subreddit == null) {
                    Intrinsics.m26842a();
                }
                subreddit = subreddit.getName();
                Comment comment = getComment();
                if (comment == null) {
                    Intrinsics.m26842a();
                }
                Object j = comment.j();
                Intrinsics.m26843a(j, "comment!!.linkId");
                ((ModEventBuilder) modEventBuilder.m21893b(subreddit, j)).m21891a();
            }
        }
    }
}
