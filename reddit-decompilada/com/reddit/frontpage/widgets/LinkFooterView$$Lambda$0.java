package com.reddit.frontpage.widgets;

import io.reactivex.functions.Consumer;
import java.util.List;

final /* synthetic */ class LinkFooterView$$Lambda$0 implements Consumer {
    private final LinkFooterView f29452a;

    LinkFooterView$$Lambda$0(LinkFooterView linkFooterView) {
        this.f29452a = linkFooterView;
    }

    public final void accept(Object obj) {
        this.f29452a.m24176a(((List) obj).isEmpty() ^ 1);
    }
}
