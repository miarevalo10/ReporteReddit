package com.reddit.frontpage.ui.profile;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.util.CommentUtil;
import com.reddit.frontpage.util.IntentUtil;

final /* synthetic */ class SavedCommentsScreen$SavedCommentsAdapter$$Lambda$0 implements OnClickListener {
    private final SavedCommentsAdapter f21526a;
    private final SavedCommentViewHolder f21527b;

    SavedCommentsScreen$SavedCommentsAdapter$$Lambda$0(SavedCommentsAdapter savedCommentsAdapter, SavedCommentViewHolder savedCommentViewHolder) {
        this.f21526a = savedCommentsAdapter;
        this.f21527b = savedCommentViewHolder;
    }

    public final void onClick(View view) {
        view = this.f21526a;
        view.f29234a.a(IntentUtil.m23752a(CommentUtil.m23665a(this.f21527b.m34974w())));
    }
}
