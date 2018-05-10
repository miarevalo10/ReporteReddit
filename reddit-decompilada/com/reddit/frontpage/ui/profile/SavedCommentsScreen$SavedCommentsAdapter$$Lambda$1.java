package com.reddit.frontpage.ui.profile;

import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.ui.detail.BaseDetailScreen;
import com.reddit.frontpage.ui.detail.comments.LegacyCommentViewHolder.OnCommentEditListener;
import com.reddit.frontpage.util.IntentUtil;

final /* synthetic */ class SavedCommentsScreen$SavedCommentsAdapter$$Lambda$1 implements OnCommentEditListener {
    private final SavedCommentsAdapter f29232a;

    SavedCommentsScreen$SavedCommentsAdapter$$Lambda$1(SavedCommentsAdapter savedCommentsAdapter) {
        this.f29232a = savedCommentsAdapter;
    }

    public final void mo5009a(Comment comment) {
        SavedCommentsAdapter savedCommentsAdapter = this.f29232a;
        savedCommentsAdapter.f29234a.a(IntentUtil.m23741a(savedCommentsAdapter.f29234a.am_(), comment), BaseDetailScreen.f39146w);
    }
}
