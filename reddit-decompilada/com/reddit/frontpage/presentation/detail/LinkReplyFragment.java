package com.reddit.frontpage.presentation.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import androidx.os.BundleKt;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.di.component.DaggerReplyComponent;
import com.reddit.frontpage.di.component.UserComponent;
import com.reddit.frontpage.domain.model.Comment;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.detail.ReplyContract.Parameters;
import com.reddit.frontpage.presentation.detail.ReplyContract.View;
import com.reddit.frontpage.widgets.submit.ReplyableLinkPreview;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/LinkReplyFragment;", "Lcom/reddit/frontpage/presentation/detail/ReplyFragment;", "()V", "kindWithId", "", "getKindWithId", "()Ljava/lang/String;", "getDiscardWarning", "", "getHint", "getLink", "Lcom/reddit/frontpage/domain/model/Link;", "getReplyablePreview", "Landroid/view/View;", "getSort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "getTitle", "navigateAway", "", "comment", "Lcom/reddit/frontpage/domain/model/Comment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkReplyFragment.kt */
public final class LinkReplyFragment extends ReplyFragment {
    public static final Companion f40015a = new Companion();
    private HashMap f40016g;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/LinkReplyFragment$Companion;", "", "()V", "LINK", "", "REPLY_TO_LINK", "SORT", "newInstance", "Lcom/reddit/frontpage/presentation/detail/LinkReplyFragment;", "link", "Lcom/reddit/frontpage/domain/model/Link;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkReplyFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public static LinkReplyFragment m22810a(Link link, CommentSortType commentSortType) {
            Intrinsics.m26847b(link, "link");
            link = BundleKt.a(new Pair[]{TuplesKt.m26780a("link", link), TuplesKt.m26780a("sort", commentSortType)});
            commentSortType = new LinkReplyFragment();
            commentSortType.setArguments(link);
            return commentSortType;
        }
    }

    public final void mo7341b() {
        if (this.f40016g != null) {
            this.f40016g.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo7341b();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = DaggerReplyComponent.m29270a();
        UserComponent k = FrontpageApplication.m28875k();
        Intrinsics.m26843a((Object) k, "FrontpageApplication.getUserComponent()");
        bundle = bundle.mo4731a(k).mo4733a((View) this);
        String kindWithId = m40584m().getKindWithId();
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.m26842a();
        }
        Serializable serializable = arguments.getSerializable("sort");
        if (!(serializable instanceof CommentSortType)) {
            serializable = null;
        }
        bundle.mo4732a(new Parameters(kindWithId, (CommentSortType) serializable)).mo4734a().mo4735a(this);
    }

    protected final android.view.View mo7339a() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.m26842a();
        }
        ReplyableLinkPreview replyableLinkPreview = new ReplyableLinkPreview(activity);
        replyableLinkPreview.m30530a(m40584m());
        return replyableLinkPreview;
    }

    public final void mo7340a(Comment comment) {
        Intrinsics.m26847b(comment, "comment");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("com.reddit.frontpage.reply_to_link", comment);
            activity.setResult(-1, intent);
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final Link m40584m() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.m26842a();
        }
        Object parcelable = arguments.getParcelable("link");
        Intrinsics.m26843a(parcelable, "arguments!!.getParcelable(LINK)");
        return (Link) parcelable;
    }
}
