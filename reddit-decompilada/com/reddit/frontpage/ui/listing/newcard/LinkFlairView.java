package com.reddit.frontpage.ui.listing.newcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.detail.LinkEditCache;
import com.reddit.frontpage.util.ModUtil;
import com.reddit.frontpage.util.RichTextUtil;

public class LinkFlairView extends LinearLayout {
    private boolean f21356a;
    @BindView
    TextView flairView;
    @BindView
    TextView nsfwView;
    @BindView
    TextView quarantinedView;
    @BindView
    TextView removedSpamView;
    @BindView
    TextView removedView;
    @BindView
    TextView spoilerView;

    public LinkFlairView(Context context) {
        this(context, null);
    }

    public LinkFlairView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinkFlairView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21356a = true;
        m23472a();
    }

    @TargetApi(21)
    public LinkFlairView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f21356a = true;
        m23472a();
    }

    private void m23472a() {
        inflate(getContext(), C1761R.layout.layout_link_flair_view, this);
        ButterKnife.a(this);
    }

    public final void m23474a(Link link) {
        int i = 8;
        this.nsfwView.setVisibility(ModUtil.m23824a().m30453a(link.getName(), link.isNsfw()) ? 0 : 8);
        this.spoilerView.setVisibility(ModUtil.m23824a().m30455b(link.getName(), link.isSpoiler()) ? 0 : 8);
        this.quarantinedView.setVisibility(link.isQuarantined() ? 0 : 8);
        this.removedView.setVisibility(ModUtil.m23824a().getRemovedState(link.getName(), link.isRemoved()) ? 0 : 8);
        TextView textView = this.removedSpamView;
        if (ModUtil.m23824a().m30459d(link.getName(), link.isSpam())) {
            i = 0;
        }
        textView.setVisibility(i);
        String str = (String) LinkEditCache.getLinkFlairEditCache().get(link.getName());
        if (str == null) {
            str = link.getLinkFlairRichText();
        }
        if (str != null) {
            RichTextUtil.m23883a(str, this.flairView);
        }
        m23473b();
    }

    public final void m23475a(LinkPresentationModel linkPresentationModel) {
        int i = 8;
        this.nsfwView.setVisibility(ModUtil.m23824a().m30453a(linkPresentationModel.getName(), linkPresentationModel.f33950C) ? 0 : 8);
        this.spoilerView.setVisibility(ModUtil.m23824a().m30455b(linkPresentationModel.getName(), linkPresentationModel.f33953F) ? 0 : 8);
        this.quarantinedView.setVisibility(linkPresentationModel.f33998y ? 0 : 8);
        this.removedView.setVisibility(ModUtil.m23824a().getRemovedState(linkPresentationModel.getName(), linkPresentationModel.ab) ? 0 : 8);
        TextView textView = this.removedSpamView;
        if (ModUtil.m23824a().m30459d(linkPresentationModel.getName(), linkPresentationModel.ac)) {
            i = 0;
        }
        textView.setVisibility(i);
        this.flairView.setText(linkPresentationModel.f33948A);
        m23473b();
    }

    public void setShowLinkFlair(boolean z) {
        this.f21356a = z;
        m23473b();
    }

    private void m23473b() {
        if (!this.f21356a || TextUtils.isEmpty(this.flairView.getText())) {
            this.flairView.setVisibility(8);
        } else {
            this.flairView.setVisibility(0);
        }
        if (this.nsfwView.getVisibility() == 8 && this.spoilerView.getVisibility() == 8 && this.quarantinedView.getVisibility() == 8 && this.flairView.getVisibility() == 8 && this.removedView.getVisibility() == 8 && this.removedSpamView.getVisibility() == 8) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }
}
