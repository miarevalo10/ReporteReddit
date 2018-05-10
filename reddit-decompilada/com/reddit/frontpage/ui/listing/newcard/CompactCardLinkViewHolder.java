package com.reddit.frontpage.ui.listing.newcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.widgets.LinkHeader;

public class CompactCardLinkViewHolder extends LinkViewHolder {
    @BindView
    CompactLinkView bodyView;

    public static CompactCardLinkViewHolder m37616a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return new CompactCardLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_compact_card_link_legacy, viewGroup, false), consumer);
    }

    private CompactCardLinkViewHolder(View view, Consumer<Integer> consumer) {
        super(view);
        view.setOnLongClickListener(new CompactCardLinkViewHolder$$Lambda$0(this));
        this.bodyView.setViewMediaClickListener(new CompactCardLinkViewHolder$$Lambda$1(this, consumer));
    }

    final /* synthetic */ void m37619a(Consumer consumer) {
        if (this.p != null) {
            this.p.mo4993a(this.s);
        }
        consumer.mo4813a(Integer.valueOf(d()));
    }

    public final void mo7002a(Link link) {
        super.mo7002a(link);
        this.bodyView.m23470a(link);
    }

    protected final void mo7003b(boolean z) {
        this.bodyView.setShowLinkFlair(z);
    }

    protected final void mo7001a(int i) {
        this.bodyView.setTitleAlpha(i);
    }

    public final void mo7004c(boolean z) {
        this.b = (LinkHeader) this.c.findViewById(C1761R.id.link_header);
        this.b.setShowOverflow(false);
    }
}
