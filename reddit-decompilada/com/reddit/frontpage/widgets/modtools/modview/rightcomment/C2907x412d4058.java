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
final class C2907x412d4058 extends Lambda implements Function1<DialogInterface, Unit> {
    final /* synthetic */ ModViewRightComment f37462a;
    final /* synthetic */ boolean f37463b;

    C2907x412d4058(ModViewRightComment modViewRightComment, boolean z) {
        this.f37462a = modViewRightComment;
        this.f37463b = z;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((DialogInterface) obj, "it");
        Subreddit subreddit = null;
        Comment comment;
        if (this.f37463b != null) {
            obj = this.f37462a.getPresenter();
            comment = this.f37462a.getComment();
            String name = comment != null ? comment.getName() : null;
            if (name == null) {
                Intrinsics.m26842a();
            }
            obj.m35324a(name, DistinguishType.b, false);
            obj = this.f37462a.getLink();
            if (obj != null) {
                subreddit = obj.getSubredditDetail();
            }
            if (subreddit != null) {
                obj = this.f37462a;
                Link link = this.f37462a.getLink();
                if (link == null) {
                    Intrinsics.m26842a();
                }
                Object subredditDetail = link.getSubredditDetail();
                Intrinsics.m26843a(subredditDetail, "link!!.subredditDetail");
                ModViewRightComment.m35318a(obj, subredditDetail, false);
            }
        } else {
            obj = this.f37462a.getPresenter();
            comment = this.f37462a.getComment();
            if (comment == null) {
                Intrinsics.m26842a();
            }
            obj.m35324a(comment.getName(), DistinguishType.c, false);
            obj = this.f37462a.getLink();
            if (obj != null) {
                subreddit = obj.getSubredditDetail();
            }
            if (subreddit != null) {
                obj = this.f37462a;
                Link link2 = this.f37462a.getLink();
                if (link2 == null) {
                    Intrinsics.m26842a();
                }
                Object subredditDetail2 = link2.getSubredditDetail();
                Intrinsics.m26843a(subredditDetail2, "link!!.subredditDetail");
                ModViewRightComment.m35318a(obj, subredditDetail2, true);
            }
        }
        obj = this.f37462a.getLink();
        if (obj != null) {
            obj.getSubredditDetail();
        }
        return Unit.f25273a;
    }
}
