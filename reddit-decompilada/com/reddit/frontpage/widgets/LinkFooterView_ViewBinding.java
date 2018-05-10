package com.reddit.frontpage.widgets;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.modtools.modview.ModView;
import com.reddit.frontpage.widgets.vote.VoteView;

public class LinkFooterView_ViewBinding implements Unbinder {
    private LinkFooterView f29458b;

    public LinkFooterView_ViewBinding(LinkFooterView linkFooterView, View view) {
        this.f29458b = linkFooterView;
        linkFooterView.commentContainer = Utils.a(view, C1761R.id.comments, "field 'commentContainer'");
        linkFooterView.commentCountText = (TextView) Utils.b(view, C1761R.id.comment_count, "field 'commentCountText'", TextView.class);
        linkFooterView.voteView = (VoteView) Utils.b(view, C1761R.id.vote, "field 'voteView'", VoteView.class);
        linkFooterView.extraActionContainer = Utils.a(view, C1761R.id.extra_action, "field 'extraActionContainer'");
        linkFooterView.liveCommentIcon = (ImageView) Utils.b(view, C1761R.id.icon_live_comment, "field 'liveCommentIcon'", ImageView.class);
        linkFooterView.liveCommentCountText = (TextView) Utils.b(view, C1761R.id.live_comment_count, "field 'liveCommentCountText'", TextView.class);
        linkFooterView.extraActionText = (DrawableTextView) Utils.b(view, C1761R.id.extra_action_text, "field 'extraActionText'", DrawableTextView.class);
        linkFooterView.modView = (ModView) Utils.b(view, C1761R.id.mod_view, "field 'modView'", ModView.class);
    }

    public final void m30487a() {
        LinkFooterView linkFooterView = this.f29458b;
        if (linkFooterView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29458b = null;
        linkFooterView.commentContainer = null;
        linkFooterView.commentCountText = null;
        linkFooterView.voteView = null;
        linkFooterView.extraActionContainer = null;
        linkFooterView.liveCommentIcon = null;
        linkFooterView.liveCommentCountText = null;
        linkFooterView.extraActionText = null;
        linkFooterView.modView = null;
    }
}
