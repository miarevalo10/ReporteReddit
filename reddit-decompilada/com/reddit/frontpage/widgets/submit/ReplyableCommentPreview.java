package com.reddit.frontpage.widgets.submit;

import android.content.Context;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import com.reddit.frontpage.widgets.GoldCountView;
import com.reddit.frontpage.widgets.WhenView;
import java.util.concurrent.TimeUnit;

public class ReplyableCommentPreview extends ReplyablePreview<BaseHtmlTextView> {
    private TextView f29529a = ((TextView) findViewById(C1761R.id.author));
    private TextView f29530b = ((TextView) findViewById(C1761R.id.flair_text));
    private WhenView f29531c = ((WhenView) findViewById(C1761R.id.when_view));
    private GoldCountView f29532d = ((GoldCountView) findViewById(C1761R.id.gold_count));

    public ReplyableCommentPreview(Context context) {
        super(context, (int) C1761R.layout.merge_replyable_comment_preview, '\u0000');
    }

    public final void m30528a(Comment comment) {
        ((BaseHtmlTextView) getReplyTargetView()).setHtmlFromString(comment.b());
        this.f29529a.setText(comment.c());
        this.f29530b.setText(comment.author_flair_text);
        this.f29531c.setText(DateUtil.m23682a(comment.getCreatedUtc(), TimeUnit.SECONDS));
        GoldCountView goldCountView = this.f29532d;
        goldCountView.f21874a = comment;
        if (goldCountView.f21874a != null) {
            if (goldCountView.f21874a.getGilded() != null) {
                goldCountView.setVisibility(0);
                int gilded = goldCountView.f21874a.getGilded();
                if (gilded > 1) {
                    goldCountView.f21875b.setText(Integer.toString(gilded));
                    goldCountView.f21875b.setVisibility(0);
                    return;
                }
                goldCountView.f21875b.setVisibility(8);
                return;
            }
        }
        goldCountView.setVisibility(8);
    }
}
