package com.reddit.frontpage.ui.submit;

import android.os.Bundle;
import android.view.View;
import com.reddit.datalibrary.frontpage.requests.models.Replyable;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.submit.ReplyableCommentPreview;

public class CommentReplyFragment extends ReplyFragmentLegacy {
    public final int mo7473c() {
        return C1761R.string.title_reply_comment;
    }

    protected final int mo7474d() {
        return C1761R.string.hint_comment_reply;
    }

    protected final int mo7475e() {
        return C1761R.string.discard_comment;
    }

    public static CommentReplyFragment m41082a(Comment comment) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("comment", comment);
        comment = new CommentReplyFragment();
        comment.setArguments(bundle);
        return comment;
    }

    public final View mo7471a() {
        View replyableCommentPreview = new ReplyableCommentPreview(getActivity());
        replyableCommentPreview.m30528a((Comment) mo7472b());
        return replyableCommentPreview;
    }

    public final Replyable mo7472b() {
        return (Replyable) getArguments().getSerializable("comment");
    }
}
