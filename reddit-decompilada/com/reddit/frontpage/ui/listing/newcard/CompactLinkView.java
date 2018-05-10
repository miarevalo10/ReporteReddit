package com.reddit.frontpage.ui.listing.newcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.widgets.LinkHeaderView;

public class CompactLinkView extends RelativeLayout {
    private String f21353a;
    @BindView
    LinkFlairView flairView;
    @BindView
    LinkHeaderView linkHeaderView;
    @BindView
    LinkThumbnailView thumbnailView;
    @BindView
    RightIndentTextView titleView;
    @BindView
    XpostCompactCardBodyView xpostCardBody;

    public final void m23469a() {
        this.linkHeaderView.m24134b();
    }

    public final void m23471b() {
        this.linkHeaderView.m24132a();
    }

    public CompactLinkView(Context context) {
        this(context, null);
    }

    public CompactLinkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CompactLinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public CompactLinkView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.a(this);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
        int paddingLeft = (defaultSize - getPaddingLeft()) - getPaddingRight();
        if (this.thumbnailView == null || this.thumbnailView.getVisibility() == 8) {
            defaultSize = 0;
            i3 = defaultSize;
        } else {
            i3 = ((LayoutParams) this.thumbnailView.getLayoutParams()).leftMargin;
            int paddingRight = (int) (((((double) defaultSize) * 0.25d) - ((double) getPaddingRight())) - ((double) i3));
            this.thumbnailView.getLayoutParams().width = paddingRight;
            this.thumbnailView.getLayoutParams().height = paddingRight;
            int i4 = (defaultSize - paddingRight) - i3;
            i3 = m23467a(this.thumbnailView) + paddingRight;
            defaultSize -= i4;
        }
        this.linkHeaderView.measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        i3 = ((i3 - this.linkHeaderView.getMeasuredHeight()) - m23467a(this.linkHeaderView)) - m23468b(this.titleView);
        this.titleView.setIndentHeight(i3);
        this.titleView.setIndentMargin(defaultSize);
        this.titleView.setText(this.f21353a);
        this.titleView.measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        if (((i3 - this.titleView.getMeasuredHeight()) - ((MarginLayoutParams) this.titleView.getLayoutParams()).bottomMargin) - m23468b(this.flairView) > 0) {
            paddingLeft -= defaultSize;
        }
        ((LayoutParams) this.flairView.getLayoutParams()).width = paddingLeft;
        this.flairView.measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        super.onMeasure(i, i2);
    }

    private static int m23467a(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static int m23468b(View view) {
        return ((MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void setViewMediaClickListener(OnClickListener onClickListener) {
        if (this.thumbnailView != null) {
            this.thumbnailView.setOnClickListener(onClickListener);
        }
    }

    public void setShowLinkFlair(boolean z) {
        this.flairView.setShowLinkFlair(z);
    }

    public final void m23470a(Link link) {
        this.f21353a = link.getTitle();
        this.linkHeaderView.b_(link);
        this.flairView.m23474a(link);
        if (this.thumbnailView != null) {
            this.thumbnailView.m23478a(link);
        }
        link = link.getCrosspostParentList();
        if (!(this.xpostCardBody == null || link == null || link.isEmpty())) {
            this.xpostCardBody.m30250a((Link) link.get(0));
        }
        invalidate();
        requestLayout();
    }

    public void setXpostEmbedOnClickListener(OnClickListener onClickListener) {
        if (this.xpostCardBody != null) {
            this.xpostCardBody.setOnClickListener(onClickListener);
        }
    }

    public void setXpostThumbnailOnClickListener(OnClickListener onClickListener) {
        if (this.xpostCardBody != null) {
            this.xpostCardBody.setThumbnailOnClickListener(onClickListener);
        }
    }

    public void setTitleAlpha(int i) {
        this.titleView.setTextColor(this.titleView.getTextColors().withAlpha(i));
    }
}
