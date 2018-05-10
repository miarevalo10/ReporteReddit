package com.reddit.frontpage.ui.listing.adapter;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

final /* synthetic */ class CardLinkAdapter$$Lambda$32 implements Function0 {
    private final CardLinkAdapter f34360a;
    private final Bundle f34361b;

    CardLinkAdapter$$Lambda$32(CardLinkAdapter cardLinkAdapter, Bundle bundle) {
        this.f34360a = cardLinkAdapter;
        this.f34361b = bundle;
    }

    public final Object invoke() {
        CardLinkAdapter cardLinkAdapter = this.f34360a;
        Bundle bundle = this.f34361b;
        RecyclerView h = cardLinkAdapter.mo6490h();
        if (h != null) {
            for (ListingViewHolder a : cardLinkAdapter.m30181a((LinearLayoutManager) h.getLayoutManager())) {
                a.mo6494a(bundle);
            }
        }
        return Unit.f25273a;
    }
}
