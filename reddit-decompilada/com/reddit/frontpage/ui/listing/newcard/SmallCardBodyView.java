package com.reddit.frontpage.ui.listing.newcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listing.newcard.XpostImageCardBodyView.ImageHeight;
import com.reddit.frontpage.util.Util;

public class SmallCardBodyView extends RelativeLayout {
    private String f21369a;
    private String f21370b;
    @BindView
    LinkFlairView flairView;
    @BindView
    RightIndentTextView selfTextView;
    @BindView
    XpostSmallCardBodyView smallXpostCardBody;
    @BindView
    LinkThumbnailView thumbnailView;
    @BindView
    RightIndentTextView titleView;
    @BindView
    XpostImageCardBodyView videoXpostCardBody;

    public SmallCardBodyView(Context context) {
        this(context, null);
    }

    public SmallCardBodyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmallCardBodyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public SmallCardBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
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
            int i4 = ((LayoutParams) this.thumbnailView.getLayoutParams()).leftMargin;
            defaultSize = (int) (((((double) defaultSize) * 0.333d) - ((double) getPaddingRight())) - ((double) i4));
            this.thumbnailView.getLayoutParams().width = defaultSize;
            this.thumbnailView.getLayoutParams().height = defaultSize;
            i3 = ((LayoutParams) this.thumbnailView.getLayoutParams()).bottomMargin + defaultSize;
            defaultSize += i4;
        }
        this.titleView.setIndentHeight(i3);
        this.titleView.setIndentMargin(defaultSize);
        this.titleView.setText(this.f21369a);
        this.titleView.measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        i3 = ((i3 - this.titleView.getMeasuredHeight()) - m23485b(this.titleView)) - m23484a(this.flairView);
        if (i3 > 0) {
            paddingLeft -= defaultSize;
        }
        ((LayoutParams) this.flairView.getLayoutParams()).width = paddingLeft;
        this.flairView.measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        if (this.selfTextView != null) {
            if (TextUtils.isEmpty(this.f21370b)) {
                this.selfTextView.setVisibility(8);
            } else {
                this.selfTextView.setIndentHeight(Math.abs(((i3 - this.flairView.getMeasuredHeight()) - m23485b(this.flairView)) - m23484a(this.selfTextView)));
                this.selfTextView.setIndentMargin(defaultSize);
                this.selfTextView.setText(this.f21370b);
                this.selfTextView.setVisibility(0);
            }
        }
        super.onMeasure(i, i2);
    }

    private static int m23484a(View view) {
        if (view == null) {
            return null;
        }
        return ((MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    private static int m23485b(View view) {
        return ((MarginLayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public final void m23486a(Link link) {
        this.f21369a = link.getTitle();
        String str = null;
        this.f21370b = null;
        if (!link.isSpoiler()) {
            if (link.isSelf() && !TextUtils.isEmpty(link.getSelfTextHtml())) {
                str = link.getSelfTextHtml().substring(0, Math.min(link.getSelfTextHtml().length(), 400));
            }
            str = Util.m24030g(str);
            if (str != null && str.length() >= 140) {
                this.f21370b = str;
            }
        }
        if (this.thumbnailView != null) {
            this.thumbnailView.m23478a(link);
        }
        this.flairView.m23474a(link);
        link = link.getCrosspostParentList();
        if (!(link == null || link.isEmpty())) {
            ClientLink clientLink = (ClientLink) link.get(0);
            if (this.smallXpostCardBody != null) {
                this.smallXpostCardBody.m23497a(clientLink);
            } else if (this.videoXpostCardBody != null) {
                this.videoXpostCardBody.m23496a(clientLink, ImageHeight.CROPPED);
            }
        }
        invalidate();
        requestLayout();
    }

    public void setShowLinkFlair(boolean z) {
        this.flairView.setShowLinkFlair(z);
    }

    public void setTitleAlpha(int i) {
        this.titleView.setTextColor(this.titleView.getTextColors().withAlpha(i));
    }

    public void setPreviewOnClickListener(OnClickListener onClickListener) {
        if (this.thumbnailView != null) {
            this.thumbnailView.setOnClickListener(onClickListener);
        }
    }

    public void setXpostEmbedOnClickListener(OnClickListener onClickListener) {
        if (this.smallXpostCardBody != null) {
            this.smallXpostCardBody.setOnClickListener(onClickListener);
        }
        if (this.videoXpostCardBody != null) {
            this.videoXpostCardBody.setOnClickListener(onClickListener);
        }
    }

    public void setXpostPreviewOnClickListener(OnClickListener onClickListener) {
        if (this.smallXpostCardBody != null) {
            this.smallXpostCardBody.setPreviewOnClickListener(onClickListener);
        }
        if (this.videoXpostCardBody != null) {
            this.videoXpostCardBody.setPreviewOnClickListener(onClickListener);
        }
    }
}
