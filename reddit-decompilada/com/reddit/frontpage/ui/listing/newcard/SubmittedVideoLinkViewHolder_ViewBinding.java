package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class SubmittedVideoLinkViewHolder_ViewBinding extends LinkViewHolder_ViewBinding {
    private SubmittedVideoLinkViewHolder f34393b;

    public SubmittedVideoLinkViewHolder_ViewBinding(SubmittedVideoLinkViewHolder submittedVideoLinkViewHolder, View view) {
        super(submittedVideoLinkViewHolder, view);
        this.f34393b = submittedVideoLinkViewHolder;
        submittedVideoLinkViewHolder.linkPreview = (ImageView) Utils.b(view, C1761R.id.link_preview, "field 'linkPreview'", ImageView.class);
        submittedVideoLinkViewHolder.linkStatus = (ImageView) Utils.b(view, C1761R.id.link_status, "field 'linkStatus'", ImageView.class);
        submittedVideoLinkViewHolder.linkSubreddit = (TextView) Utils.b(view, C1761R.id.link_subreddit, "field 'linkSubreddit'", TextView.class);
        submittedVideoLinkViewHolder.linkTitle = (TextView) Utils.b(view, C1761R.id.link_title, "field 'linkTitle'", TextView.class);
        submittedVideoLinkViewHolder.linkClose = Utils.a(view, C1761R.id.link_close, "field 'linkClose'");
        submittedVideoLinkViewHolder.linkRetry = Utils.a(view, C1761R.id.link_retry, "field 'linkRetry'");
        submittedVideoLinkViewHolder.linkEdit = Utils.a(view, C1761R.id.link_edit, "field 'linkEdit'");
        submittedVideoLinkViewHolder.linkMessage = (TextView) Utils.b(view, C1761R.id.link_message, "field 'linkMessage'", TextView.class);
        submittedVideoLinkViewHolder.linkProgress = (ProgressBar) Utils.b(view, C1761R.id.link_progress, "field 'linkProgress'", ProgressBar.class);
    }

    public final void mo6516a() {
        SubmittedVideoLinkViewHolder submittedVideoLinkViewHolder = this.f34393b;
        if (submittedVideoLinkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f34393b = null;
        submittedVideoLinkViewHolder.linkPreview = null;
        submittedVideoLinkViewHolder.linkStatus = null;
        submittedVideoLinkViewHolder.linkSubreddit = null;
        submittedVideoLinkViewHolder.linkTitle = null;
        submittedVideoLinkViewHolder.linkClose = null;
        submittedVideoLinkViewHolder.linkRetry = null;
        submittedVideoLinkViewHolder.linkEdit = null;
        submittedVideoLinkViewHolder.linkMessage = null;
        submittedVideoLinkViewHolder.linkProgress = null;
        super.mo6516a();
    }
}
