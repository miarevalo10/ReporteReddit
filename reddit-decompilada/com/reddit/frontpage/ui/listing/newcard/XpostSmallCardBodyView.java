package com.reddit.frontpage.ui.listing.newcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.Util;

public class XpostSmallCardBodyView extends RelativeLayout {
    private static final String f21407a = Util.m24027f((int) C1761R.string.unicode_delimiter);
    private String f21408b;
    private String f21409c;
    private String f21410d;
    @BindView
    RightIndentTextView headerMetadataView;
    @BindView
    RightIndentTextView metadataView;
    @BindView
    LinkThumbnailView thumbnailView;
    @BindView
    RightIndentTextView titleView;

    public XpostSmallCardBodyView(Context context) {
        this(context, null);
    }

    public XpostSmallCardBodyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XpostSmallCardBodyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public XpostSmallCardBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
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
        if (this.thumbnailView.getVisibility() != 8) {
            int i4 = ((LayoutParams) this.thumbnailView.getLayoutParams()).leftMargin;
            defaultSize = (int) (((((double) defaultSize) * 0.333d) - ((double) getPaddingRight())) - ((double) i4));
            this.thumbnailView.getLayoutParams().width = defaultSize;
            this.thumbnailView.getLayoutParams().height = defaultSize;
            i3 = ((LayoutParams) this.thumbnailView.getLayoutParams()).bottomMargin + defaultSize;
            defaultSize += i4;
        } else {
            defaultSize = 0;
            i3 = defaultSize;
        }
        this.titleView.setIndentHeight(i3);
        this.titleView.setIndentMargin(defaultSize);
        this.titleView.setText(this.f21408b);
        this.titleView.measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        i3 = (i3 - this.titleView.getMeasuredHeight()) - ((MarginLayoutParams) this.titleView.getLayoutParams()).bottomMargin;
        if (TextUtils.isEmpty(this.f21410d)) {
            this.metadataView.setVisibility(8);
        } else {
            this.metadataView.setIndentHeight(Math.abs(i3));
            this.metadataView.setIndentMargin(defaultSize);
            this.headerMetadataView.setText(this.f21409c);
            this.metadataView.setText(this.f21410d);
            this.metadataView.setVisibility(0);
        }
        super.onMeasure(i, i2);
    }

    public final void m23497a(Link link) {
        String f;
        this.f21408b = link.getTitle();
        this.f21410d = null;
        CharSequence b = DateUtil.m23684b(link.getCreatedUtc());
        if (Util.m24041k(link.getAuthor())) {
            f = Util.m24027f((int) C1761R.string.deleted_author);
        } else {
            f = Util.m23960a((int) C1761R.string.fmt_u_name, link.getAuthor());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(link.getSubredditNamePrefixed());
        stringBuilder.append(f21407a);
        stringBuilder.append(b);
        stringBuilder.append(f21407a);
        stringBuilder.append(f);
        this.f21409c = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        int score = link.getScore();
        long numComments = link.getNumComments();
        String a = CountUtil.m23674a(numComments);
        stringBuilder2.append(Util.m23959a((int) C1761R.plurals.fmt_num_points, score, Integer.valueOf(score)));
        stringBuilder2.append(f21407a);
        stringBuilder2.append(Util.m23959a((int) C1761R.plurals.fmt_num_comments, (int) numComments, a));
        this.f21410d = stringBuilder2.toString();
        this.thumbnailView.m23478a(link);
        invalidate();
        requestLayout();
    }

    public void setTitleAlpha(int i) {
        this.titleView.setTextColor(this.titleView.getTextColors().withAlpha(i));
    }

    public void setPreviewOnClickListener(OnClickListener onClickListener) {
        this.thumbnailView.setOnClickListener(onClickListener);
    }
}
