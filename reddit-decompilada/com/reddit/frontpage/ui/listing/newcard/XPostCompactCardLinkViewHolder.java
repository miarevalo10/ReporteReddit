package com.reddit.frontpage.ui.listing.newcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.DetailHolderScreen;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.widgets.LinkHeader;

public class XPostCompactCardLinkViewHolder extends LinkViewHolder {
    @BindView
    CompactLinkView cardBodyView;

    public static XPostCompactCardLinkViewHolder m37671a(ViewGroup viewGroup) {
        return new XPostCompactCardLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_xpost_compact_card_legacy, viewGroup, false));
    }

    private XPostCompactCardLinkViewHolder(View view) {
        super(view);
        view.setOnLongClickListener(new XPostCompactCardLinkViewHolder$$Lambda$0(this));
        this.cardBodyView.setViewMediaClickListener(new XPostCompactCardLinkViewHolder$$Lambda$1(this));
        this.cardBodyView.setXpostEmbedOnClickListener(new XPostCompactCardLinkViewHolder$$Lambda$2(this, view));
        this.cardBodyView.setXpostThumbnailOnClickListener(new XPostCompactCardLinkViewHolder$$Lambda$3(this));
    }

    final /* synthetic */ void m37678y() {
        if (this.p != null) {
            this.p.mo4993a(this.s);
        }
    }

    final /* synthetic */ void m37673a(View view) {
        ClientLink b = Util.m23994b(this.s);
        if (b != null) {
            Context context = view.getContext();
            context.startActivity(IntentUtil.m23745a(context, DetailHolderScreen.m38887b(b.getId(), null, null)));
        }
    }

    final /* synthetic */ void m37677x() {
        Link b = Util.m23994b(this.s);
        if (this.p != null && b != null) {
            this.p.mo4993a(b);
        }
    }

    public final void mo7002a(Link link) {
        super.mo7002a(link);
        this.cardBodyView.m23470a(link);
    }

    protected final void mo7001a(int i) {
        this.cardBodyView.setTitleAlpha(i);
    }

    protected final void mo7003b(boolean z) {
        this.cardBodyView.setShowLinkFlair(z);
    }

    public final void mo7004c(boolean z) {
        this.b = (LinkHeader) this.c.findViewById(C1761R.id.link_header);
        this.b.setShowOverflow(false);
    }
}
