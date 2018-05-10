package com.reddit.frontpage.ui.detail.comments;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.ui.view.UserIndicatorsView;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import com.reddit.frontpage.widgets.DrawableTextView;
import com.reddit.frontpage.widgets.IconStatusView;
import com.reddit.frontpage.widgets.comment.CommentIndentView;
import com.reddit.frontpage.widgets.modtools.modview.ModView;
import com.reddit.frontpage.widgets.modtools.modview.ModViewLeftComment;
import com.reddit.frontpage.widgets.modtools.modview.rightcomment.ModViewRightComment;
import com.reddit.frontpage.widgets.vote.VoteView;

public class LegacyCommentViewHolder_ViewBinding implements Unbinder {
    private LegacyCommentViewHolder f28963b;

    public LegacyCommentViewHolder_ViewBinding(LegacyCommentViewHolder legacyCommentViewHolder, View view) {
        this.f28963b = legacyCommentViewHolder;
        legacyCommentViewHolder.selectCheckBox = (CheckBox) Utils.b(view, C1761R.id.select, "field 'selectCheckBox'", CheckBox.class);
        legacyCommentViewHolder.header = Utils.a(view, C1761R.id.comment_header, "field 'header'");
        legacyCommentViewHolder.collapsedText = (TextView) Utils.b(view, C1761R.id.collapsed_text, "field 'collapsedText'", TextView.class);
        legacyCommentViewHolder.body = (BaseHtmlTextView) Utils.b(view, C1761R.id.comment_text, "field 'body'", BaseHtmlTextView.class);
        legacyCommentViewHolder.statusView = (IconStatusView) Utils.b(view, C1761R.id.status_view, "field 'statusView'", IconStatusView.class);
        legacyCommentViewHolder.author = (TextView) Utils.b(view, C1761R.id.author, "field 'author'", TextView.class);
        legacyCommentViewHolder.gildedCount = (TextView) Utils.b(view, C1761R.id.gilded_count, "field 'gildedCount'", TextView.class);
        legacyCommentViewHolder.flair = (TextView) Utils.b(view, C1761R.id.flair_text, "field 'flair'", TextView.class);
        legacyCommentViewHolder.when = (TextView) Utils.b(view, C1761R.id.when_view, "field 'when'", TextView.class);
        legacyCommentViewHolder.indentView = (CommentIndentView) Utils.b(view, C1761R.id.indent_indicator, "field 'indentView'", CommentIndentView.class);
        legacyCommentViewHolder.replyView = (DrawableTextView) Utils.b(view, C1761R.id.reply, "field 'replyView'", DrawableTextView.class);
        legacyCommentViewHolder.voteView = (VoteView) Utils.b(view, C1761R.id.vote_view, "field 'voteView'", VoteView.class);
        legacyCommentViewHolder.modViewLeftComment = (ModViewLeftComment) Utils.b(view, C1761R.id.mod_view_left_comment, "field 'modViewLeftComment'", ModViewLeftComment.class);
        legacyCommentViewHolder.modView = (ModView) Utils.b(view, C1761R.id.mod_view, "field 'modView'", ModView.class);
        legacyCommentViewHolder.modViewRightComment = (ModViewRightComment) Utils.b(view, C1761R.id.mod_view_right_comment, "field 'modViewRightComment'", ModViewRightComment.class);
        legacyCommentViewHolder.menuView = Utils.a(view, C1761R.id.menu, "field 'menuView'");
        legacyCommentViewHolder.overFlowIcon = (ImageView) Utils.b(view, C1761R.id.overflow_icon, "field 'overFlowIcon'", ImageView.class);
        legacyCommentViewHolder.commentOptions = Utils.a(view, C1761R.id.comment_options, "field 'commentOptions'");
        legacyCommentViewHolder.authorIndicators = (UserIndicatorsView) Utils.b(view, C1761R.id.author_indicators, "field 'authorIndicators'", UserIndicatorsView.class);
    }

    public void mo6521a() {
        LegacyCommentViewHolder legacyCommentViewHolder = this.f28963b;
        if (legacyCommentViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28963b = null;
        legacyCommentViewHolder.selectCheckBox = null;
        legacyCommentViewHolder.header = null;
        legacyCommentViewHolder.collapsedText = null;
        legacyCommentViewHolder.body = null;
        legacyCommentViewHolder.statusView = null;
        legacyCommentViewHolder.author = null;
        legacyCommentViewHolder.gildedCount = null;
        legacyCommentViewHolder.flair = null;
        legacyCommentViewHolder.when = null;
        legacyCommentViewHolder.indentView = null;
        legacyCommentViewHolder.replyView = null;
        legacyCommentViewHolder.voteView = null;
        legacyCommentViewHolder.modViewLeftComment = null;
        legacyCommentViewHolder.modView = null;
        legacyCommentViewHolder.modViewRightComment = null;
        legacyCommentViewHolder.menuView = null;
        legacyCommentViewHolder.overFlowIcon = null;
        legacyCommentViewHolder.commentOptions = null;
        legacyCommentViewHolder.authorIndicators = null;
    }
}
