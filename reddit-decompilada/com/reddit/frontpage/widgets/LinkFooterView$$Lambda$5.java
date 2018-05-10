package com.reddit.frontpage.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.provider.FlairProvider;
import com.reddit.frontpage.util.SchedulerProvider;

final /* synthetic */ class LinkFooterView$$Lambda$5 implements OnClickListener {
    private final LinkFooterView f21896a;

    LinkFooterView$$Lambda$5(LinkFooterView linkFooterView) {
        this.f21896a = linkFooterView;
    }

    public final void onClick(View view) {
        view = this.f21896a;
        if (view.f21899a != null) {
            FlairProvider flairProvider = new FlairProvider();
            view.f21901c = FlairProvider.a(view.f21899a.getSubreddit()).observeOn(SchedulerProvider.m23887c()).subscribe(new LinkFooterView$$Lambda$0(view), new LinkFooterView$$Lambda$1(view));
        }
    }
}
