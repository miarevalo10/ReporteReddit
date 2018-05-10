package com.reddit.frontpage.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;

public class LinkTitleView extends AppCompatTextView {
    public LinkTitleView(Context context) {
        super(context);
    }

    public LinkTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinkTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void mo7025a(Link link) {
        setText(link.getTitle());
    }

    public final void m35294a(LinkPresentationModel linkPresentationModel) {
        setText(linkPresentationModel.f33999z);
    }
}
