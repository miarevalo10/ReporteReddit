package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.util.ModCacheComments;
import com.reddit.frontpage.util.ModUtil;

public class IconStatusView extends FrameLayout {
    @BindView
    TextView flaggedCountView;
    @BindView
    ImageView iconApproved;
    @BindView
    ImageView iconArchived;
    @BindView
    ImageView iconFlagged;
    @BindView
    ImageView iconLocked;
    @BindView
    ImageView iconRemoved;
    @BindView
    ImageView iconSpammed;
    @BindView
    ImageView iconStickied;

    public IconStatusView(Context context) {
        this(context, null);
    }

    public IconStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1761R.attr.linkStatusViewStyle);
    }

    public IconStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24152a(context);
    }

    @TargetApi(21)
    public IconStatusView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m24152a(context);
    }

    private void m24152a(Context context) {
        LayoutInflater.from(context).inflate(C1761R.layout.item_link_status_view, this, true);
        ButterKnife.a(this);
    }

    public final void m24153a() {
        int i = 0;
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            viewGroup.getChildAt(i).setVisibility(8);
            i++;
        }
    }

    public final void m24154a(Comment comment, ModCacheComments modCacheComments) {
        m24153a();
        boolean approvedState = modCacheComments.getApprovedState(comment.getName(), false);
        boolean removedState = modCacheComments.getRemovedState(comment.getName(), false);
        boolean a = modCacheComments.m30451a(comment.getName(), false);
        modCacheComments = modCacheComments.getStickyState(comment.getName(), comment.stickied);
        if (!((!approvedState && !comment.approved) || removedState || a)) {
            this.iconApproved.setVisibility(0);
        }
        if (!((!removedState && !comment.removed) || approvedState || a)) {
            this.iconRemoved.setVisibility(0);
        }
        if (!((!a && !comment.spam) || approvedState || removedState)) {
            this.iconSpammed.setVisibility(0);
        }
        if (modCacheComments != null) {
            this.iconStickied.setVisibility(0);
        }
        if (comment.num_reports > null) {
            this.iconFlagged.setVisibility(0);
            if (comment.num_reports > 1) {
                this.flaggedCountView.setVisibility(0);
                this.flaggedCountView.setText(Integer.toString(comment.num_reports));
            }
        }
    }

    @Deprecated
    public final void m24155a(Link link) {
        m24153a();
        if (ModUtil.m23824a().getStickyState(link.getName(), link.isStickied())) {
            this.iconStickied.setVisibility(0);
        }
        if (ModUtil.m23824a().getApprovedState(link.getName(), link.isApproved())) {
            this.iconApproved.setVisibility(0);
        }
        if (ModUtil.m23824a().getRemovedState(link.getName(), link.isRemoved())) {
            this.iconRemoved.setVisibility(0);
        }
        if (ModUtil.m23824a().m30459d(link.getName(), link.isSpam())) {
            this.iconSpammed.setVisibility(0);
        }
        if (link.isArchived()) {
            this.iconArchived.setVisibility(0);
        } else if (ModUtil.m23824a().m30457c(link.getName(), link.isLocked())) {
            this.iconLocked.setVisibility(0);
        }
        if (link.getNumReports() > 0) {
            this.iconFlagged.setVisibility(0);
            if (link.getNumReports() > 1) {
                this.flaggedCountView.setVisibility(0);
                this.flaggedCountView.setText(Integer.toString(link.getNumReports()));
            }
        }
    }

    public final void m24156a(LinkPresentationModel linkPresentationModel) {
        m24153a();
        if (ModUtil.m23824a().getStickyState(linkPresentationModel.getName(), linkPresentationModel.f33992s)) {
            this.iconStickied.setVisibility(0);
        }
        if (ModUtil.m23824a().getApprovedState(linkPresentationModel.getName(), linkPresentationModel.f33996w)) {
            this.iconApproved.setVisibility(0);
        }
        if (ModUtil.m23824a().getRemovedState(linkPresentationModel.getName(), linkPresentationModel.ab)) {
            this.iconRemoved.setVisibility(0);
        }
        if (ModUtil.m23824a().m30459d(linkPresentationModel.getName(), linkPresentationModel.ac)) {
            this.iconSpammed.setVisibility(0);
        }
        if (linkPresentationModel.f33989p) {
            this.iconArchived.setVisibility(0);
        } else if (linkPresentationModel.f33995v) {
            this.iconLocked.setVisibility(0);
        }
        if (linkPresentationModel.f33969V > 0) {
            this.iconFlagged.setVisibility(0);
            if (linkPresentationModel.f33969V > 1) {
                this.flaggedCountView.setVisibility(0);
                this.flaggedCountView.setText(Integer.toString(linkPresentationModel.f33969V));
            }
        }
    }
}
