package com.reddit.frontpage.presentation.listing.ui.view;

import com.reddit.frontpage.commons.analytics.builders.CustomReasonsNoun;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder.Companion;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkHeaderView.kt */
final class LinkHeaderView$bindLink$7 implements Runnable {
    final /* synthetic */ LinkPresentationModel f20758a;

    LinkHeaderView$bindLink$7(LinkPresentationModel linkPresentationModel) {
        this.f20758a = linkPresentationModel;
    }

    public final void run() {
        Companion companion = CustomReportEventBuilder.f27449a;
        Companion.m21900a(this.f20758a, "post_overflow", "click", CustomReasonsNoun.f20016a.f20028l);
    }
}
