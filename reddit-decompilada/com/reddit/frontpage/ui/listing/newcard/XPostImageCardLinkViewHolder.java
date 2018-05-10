package com.reddit.frontpage.ui.listing.newcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

public class XPostImageCardLinkViewHolder extends LinkViewHolder {
    @BindView
    SmallCardBodyView cardBodyView;

    public static XPostImageCardLinkViewHolder m37679a(ViewGroup viewGroup) {
        return new XPostImageCardLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_xpost_image_card_legacy, viewGroup, false));
    }

    private XPostImageCardLinkViewHolder(View view) {
        super(view);
        ButterKnife.a(this, view);
        this.cardBodyView.setXpostPreviewOnClickListener(new XPostImageCardLinkViewHolder$$Lambda$0(this));
        this.cardBodyView.setXpostEmbedOnClickListener(new XPostImageCardLinkViewHolder$$Lambda$1(this));
    }

    final /* synthetic */ void m37684y() {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            this.p.mo4993a(b);
        }
    }

    final /* synthetic */ void m37683x() {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            this.p.mo4995c(b);
        }
    }

    public final void mo7002a(Link link) {
        super.mo7002a(link);
        this.cardBodyView.m23486a(link);
    }

    protected final void mo7001a(int i) {
        this.cardBodyView.setTitleAlpha(i);
    }

    protected final void mo7003b(boolean z) {
        this.cardBodyView.setShowLinkFlair(z);
    }
}
