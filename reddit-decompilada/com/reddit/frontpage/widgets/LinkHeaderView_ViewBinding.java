package com.reddit.frontpage.widgets;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.listing.ui.view.UserIndicatorsView;

public class LinkHeaderView_ViewBinding implements Unbinder {
    private LinkHeaderView f29472b;

    public LinkHeaderView_ViewBinding(LinkHeaderView linkHeaderView, View view) {
        this.f29472b = linkHeaderView;
        linkHeaderView.linkAltLinkLabel = (TextView) Utils.b(view, C1761R.id.link_alt_link_label, "field 'linkAltLinkLabel'", TextView.class);
        linkHeaderView.linkUserIndicators = (UserIndicatorsView) Utils.b(view, C1761R.id.link_user_indicators, "field 'linkUserIndicators'", UserIndicatorsView.class);
        linkHeaderView.gildedCount = (TextView) Utils.b(view, C1761R.id.gilded_count, "field 'gildedCount'", TextView.class);
        linkHeaderView.timePostedLabel = (TextView) Utils.b(view, C1761R.id.time_posted_label, "field 'timePostedLabel'", TextView.class);
        linkHeaderView.domainLabel = (TextView) Utils.b(view, C1761R.id.domain_label, "field 'domainLabel'", TextView.class);
        linkHeaderView.iconStatusView = (IconStatusView) Utils.b(view, C1761R.id.link_status_view, "field 'iconStatusView'", IconStatusView.class);
        linkHeaderView.xpostIndicator = (ImageView) Utils.b(view, C1761R.id.xpost_indicator, "field 'xpostIndicator'", ImageView.class);
        linkHeaderView.selectListingBox = (CheckBox) Utils.b(view, C1761R.id.select, "field 'selectListingBox'", CheckBox.class);
    }

    public final void m30491a() {
        LinkHeaderView linkHeaderView = this.f29472b;
        if (linkHeaderView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29472b = null;
        linkHeaderView.linkAltLinkLabel = null;
        linkHeaderView.linkUserIndicators = null;
        linkHeaderView.gildedCount = null;
        linkHeaderView.timePostedLabel = null;
        linkHeaderView.domainLabel = null;
        linkHeaderView.iconStatusView = null;
        linkHeaderView.xpostIndicator = null;
        linkHeaderView.selectListingBox = null;
    }
}
