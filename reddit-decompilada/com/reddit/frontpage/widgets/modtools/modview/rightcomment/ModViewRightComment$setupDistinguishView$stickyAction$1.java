package com.reddit.frontpage.widgets.modtools.modview.rightcomment;

import android.content.DialogInterface;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModViewRightComment.kt */
final class ModViewRightComment$setupDistinguishView$stickyAction$1 extends Lambda implements Function1<DialogInterface, Unit> {
    final /* synthetic */ ModViewRightComment f37464a;
    final /* synthetic */ boolean f37465b;

    ModViewRightComment$setupDistinguishView$stickyAction$1(ModViewRightComment modViewRightComment, boolean z) {
        this.f37464a = modViewRightComment;
        this.f37465b = z;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((DialogInterface) obj, "it");
        Subreddit subreddit = null;
        Comment comment;
        if (this.f37465b != null) {
            obj = this.f37464a.getPresenter();
            comment = this.f37464a.getComment();
            if (comment == null) {
                Intrinsics.m26842a();
            }
            obj.m35324a(comment.getName(), DistinguishType.b, false);
            obj = this.f37464a.getLink();
            if (obj != null) {
                subreddit = obj.getSubredditDetail();
            }
            if (subreddit != null) {
                obj = this.f37464a;
                Link link = this.f37464a.getLink();
                if (link == null) {
                    Intrinsics.m26842a();
                }
                Object subredditDetail = link.getSubredditDetail();
                Intrinsics.m26843a(subredditDetail, "link!!.subredditDetail");
                ModViewRightComment.m35318a(obj, subredditDetail, false);
            }
        } else {
            obj = this.f37464a.getPresenter();
            comment = this.f37464a.getComment();
            if (comment == null) {
                Intrinsics.m26842a();
            }
            obj.m35324a(comment.getName(), DistinguishType.a, true);
            obj = this.f37464a.getLink();
            if ((obj != null ? obj.getSubredditDetail() : null) != null) {
                obj = this.f37464a;
                Link link2 = this.f37464a.getLink();
                if (link2 != null) {
                    subreddit = link2.getSubredditDetail();
                }
                if (subreddit == null) {
                    Intrinsics.m26842a();
                }
                ModViewRightComment.m35317a(obj, subreddit);
            }
        }
        return Unit.f25273a;
    }
}
