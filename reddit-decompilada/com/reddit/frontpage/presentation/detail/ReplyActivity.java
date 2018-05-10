package com.reddit.frontpage.presentation.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.reddit.datalibrary.frontpage.data.feature.common.CommentSortType;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Link;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/ReplyActivity;", "Lcom/reddit/frontpage/BaseActivity;", "()V", "link", "Lcom/reddit/frontpage/domain/model/Link;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/CommentSortType;", "addFragment", "", "getFragment", "Lcom/reddit/frontpage/presentation/detail/ReplyFragment;", "getLayoutId", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReplyActivity.kt */
public final class ReplyActivity extends BaseActivity {
    public static final Companion f40828d = new Companion();
    private Link f40829h;
    private CommentSortType f40830i;
    private HashMap f40831j;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/detail/ReplyActivity$Companion;", "", "()V", "FRAGTAG_REPLY", "", "LINK", "SORT", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ReplyActivity.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public final View mo7727a(int i) {
        if (this.f40831j == null) {
            this.f40831j = new HashMap();
        }
        View view = (View) this.f40831j.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this.f40831j.put(Integer.valueOf(i), view);
        return view;
    }

    public final int mo7724d() {
        return C1761R.layout.activity_single_container;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("com.reddit.frontpage.link_reply_mvp") != null) {
            this.f40829h = (Link) getIntent().getParcelableExtra("com.reddit.frontpage.link_reply_mvp");
            bundle = getIntent().getSerializableExtra("com.reddit.frontpage.sort_mvp");
            if (!(bundle instanceof CommentSortType)) {
                bundle = null;
            }
            this.f40830i = (CommentSortType) bundle;
        }
        if (m42726f() == null) {
            bundle = this.f40829h;
            if (bundle != null) {
                com.reddit.frontpage.presentation.detail.LinkReplyFragment.Companion companion = LinkReplyFragment.f40015a;
                getSupportFragmentManager().a().a(C1761R.id.container, com.reddit.frontpage.presentation.detail.LinkReplyFragment.Companion.m22810a(bundle, this.f40830i), "fragtag_reply").e();
                return;
            }
            throw ((Throwable) new IllegalArgumentException("Unable to create reply fragment"));
        }
    }

    private final ReplyFragment m42726f() {
        Fragment a = getSupportFragmentManager().a("fragtag_reply");
        if (!(a instanceof ReplyFragment)) {
            a = null;
        }
        return (ReplyFragment) a;
    }

    public final void onBackPressed() {
        ReplyFragment f = m42726f();
        if (f == null || !f.mo7172k()) {
            super.onBackPressed();
        }
    }
}
