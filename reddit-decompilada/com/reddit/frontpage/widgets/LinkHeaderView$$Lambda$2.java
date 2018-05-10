package com.reddit.frontpage.widgets;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.util.Util;

final /* synthetic */ class LinkHeaderView$$Lambda$2 implements OnCheckedChangeListener {
    private final LinkHeaderView f21909a;
    private final Link f21910b;

    LinkHeaderView$$Lambda$2(LinkHeaderView linkHeaderView, Link link) {
        this.f21909a = linkHeaderView;
        this.f21910b = link;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        compoundButton = this.f21909a;
        Link link = this.f21910b;
        if (z) {
            compoundButton.f29463f.mo4987a(link, String.valueOf(Util.m23952a(link)));
        } else {
            compoundButton.f29463f.mo4986a(link);
        }
    }
}
