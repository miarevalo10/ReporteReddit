package com.reddit.frontpage.ui.listing.newcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

public class XPostSmallCardLinkViewHolder extends LinkViewHolder {
    @BindView
    SmallCardBodyView cardBodyView;

    public static XPostSmallCardLinkViewHolder m37694a(ViewGroup viewGroup) {
        return new XPostSmallCardLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_xpost_small_card, viewGroup, false));
    }

    private XPostSmallCardLinkViewHolder(View view) {
        super(view);
        ButterKnife.a(this, view);
        this.cardBodyView.setPreviewOnClickListener(new XPostSmallCardLinkViewHolder$$Lambda$0(this));
        this.cardBodyView.setXpostEmbedOnClickListener(new XPostSmallCardLinkViewHolder$$Lambda$1(this));
        this.cardBodyView.setXpostPreviewOnClickListener(new XPostSmallCardLinkViewHolder$$Lambda$2(this));
    }

    final /* synthetic */ void m37700z() {
        if (this.p != null) {
            this.p.mo4993a(this.s);
        }
    }

    final /* synthetic */ void m37699y() {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            this.p.mo4995c(b);
        }
    }

    final /* synthetic */ void m37698x() {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            this.p.mo4993a(b);
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
