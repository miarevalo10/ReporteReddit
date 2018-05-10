package com.reddit.frontpage.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.feature.common.SortingsLegacyMapper;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ui.view.listoptions.sort.SimpleSortOptionsDialog;

final /* synthetic */ class LinkSearchResultScreen$LinkResultAdapter$$Lambda$0 implements OnClickListener {
    private final LinkResultAdapter f21591a;

    LinkSearchResultScreen$LinkResultAdapter$$Lambda$0(LinkResultAdapter linkResultAdapter) {
        this.f21591a = linkResultAdapter;
    }

    public final void onClick(View view) {
        view = this.f21591a;
        view.f29294a.f39314E;
        new SimpleSortOptionsDialog(view.f29294a.f39319N, view.f29294a.am_(), view.f29294a.ao_().getString(C1761R.string.title_sort_results), LinkSearchResultScreen.f39308O, LinkSearchResultScreen.f39309P, view.f29294a.m39491x(), true, SortingsLegacyMapper.b(view.f29294a.timeframeId)).f20405a.show();
    }
}
