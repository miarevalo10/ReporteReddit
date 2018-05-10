package com.reddit.frontpage.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.reddit.frontpage.C1761R;

public class SponsoredLinkHeaderView extends BaseHeaderView {
    public SponsoredLinkHeaderView(Context context) {
        super(context);
        m30496d();
    }

    public SponsoredLinkHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30496d();
    }

    public SponsoredLinkHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30496d();
    }

    public SponsoredLinkHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m30496d();
    }

    private void m30496d() {
        inflate(getContext(), C1761R.layout.linkheader_promoted, this);
        findViewById(C1761R.id.overflow_layout).setVisibility(8);
    }
}
