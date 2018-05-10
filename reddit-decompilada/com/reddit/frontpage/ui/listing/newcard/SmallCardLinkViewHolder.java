package com.reddit.frontpage.ui.listing.newcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listener.Consumer;

public class SmallCardLinkViewHolder extends LinkViewHolder {
    @BindView
    SmallCardBodyView cardBodyView;

    public static SmallCardLinkViewHolder m37627a(ViewGroup viewGroup, Consumer<Integer> consumer) {
        return new SmallCardLinkViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.item_small_card_link_legacy, viewGroup, false), consumer);
    }

    private SmallCardLinkViewHolder(View view, Consumer<Integer> consumer) {
        super(view);
        ButterKnife.a(this, view);
        this.cardBodyView.setPreviewOnClickListener(new SmallCardLinkViewHolder$$Lambda$0(this, consumer));
    }

    final /* synthetic */ void m37630a(Consumer consumer) {
        if (this.p != null) {
            if (consumer != null) {
                consumer.mo4813a(Integer.valueOf(d()));
            }
            this.p.mo4993a(this.s);
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
