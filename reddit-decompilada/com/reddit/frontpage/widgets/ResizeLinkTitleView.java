package com.reddit.frontpage.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;

public class ResizeLinkTitleView extends LinkTitleView {
    public ResizeLinkTitleView(Context context) {
        super(context);
    }

    public ResizeLinkTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ResizeLinkTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void mo7025a(Link link) {
        super.mo7025a(link);
        setTextSize(2, (float) (link.getTitle().length() < 150 ? 17 : 14));
    }
}
