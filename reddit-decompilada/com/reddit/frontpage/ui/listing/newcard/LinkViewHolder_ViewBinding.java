package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.view.ViewStub;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.LinkFooterView;

public class LinkViewHolder_ViewBinding implements Unbinder {
    private LinkViewHolder f29133b;

    public LinkViewHolder_ViewBinding(LinkViewHolder linkViewHolder, View view) {
        this.f29133b = linkViewHolder;
        linkViewHolder.headerStub = (ViewStub) Utils.a(view, C1761R.id.link_header_stub, "field 'headerStub'", ViewStub.class);
        linkViewHolder.footerView = (LinkFooterView) Utils.b(view, C1761R.id.link_footer, "field 'footerView'", LinkFooterView.class);
    }

    public void mo6516a() {
        LinkViewHolder linkViewHolder = this.f29133b;
        if (linkViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29133b = null;
        linkViewHolder.headerStub = null;
        linkViewHolder.footerView = null;
    }
}
