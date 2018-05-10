package com.reddit.frontpage.ui.listing.newcard;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.Util;

public class XpostCompactCardBodyView extends ConstraintLayout {
    private static final String f29144h = Util.m24027f((int) C1761R.string.unicode_delimiter);
    @BindView
    RightIndentTextView headerMetadataView;
    @BindView
    RightIndentTextView metadataView;
    @BindView
    LinkThumbnailView thumbnailView;
    @BindView
    RightIndentTextView titleView;

    public XpostCompactCardBodyView(Context context) {
        super(context);
    }

    public XpostCompactCardBodyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XpostCompactCardBodyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.a(this);
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
        if (this.thumbnailView.getVisibility() != 8) {
            defaultSize = (int) (((((double) defaultSize) * 0.25d) - ((double) getPaddingRight())) - ((double) ((LayoutParams) this.thumbnailView.getLayoutParams()).leftMargin));
            this.thumbnailView.getLayoutParams().width = defaultSize;
            this.thumbnailView.getLayoutParams().height = defaultSize;
        }
        super.onMeasure(i, i2);
    }

    public final void m30250a(Link link) {
        String f;
        CharSequence b = DateUtil.m23684b(link.getCreatedUtc());
        if (Util.m24041k(link.getAuthor())) {
            f = Util.m24027f((int) C1761R.string.deleted_author);
        } else {
            f = Util.m23960a((int) C1761R.string.fmt_u_name, link.getAuthor());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(link.getSubredditNamePrefixed());
        stringBuilder.append(f29144h);
        stringBuilder.append(b);
        stringBuilder.append(f29144h);
        stringBuilder.append(f);
        b = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        int score = link.getScore();
        long numComments = link.getNumComments();
        String a = CountUtil.m23674a(numComments);
        stringBuilder2.append(Util.m23959a((int) C1761R.plurals.fmt_num_points, score, Integer.valueOf(score)));
        stringBuilder2.append(f29144h);
        stringBuilder2.append(Util.m23959a((int) C1761R.plurals.fmt_num_comments, (int) numComments, a));
        CharSequence stringBuilder3 = stringBuilder2.toString();
        this.titleView.setText(link.getTitle());
        this.headerMetadataView.setText(b);
        this.metadataView.setText(stringBuilder3);
        this.thumbnailView.m23478a(link);
        invalidate();
        requestLayout();
    }

    public void setTitleAlpha(int i) {
        this.titleView.setTextColor(this.titleView.getTextColors().withAlpha(i));
    }

    public void setThumbnailOnClickListener(OnClickListener onClickListener) {
        this.thumbnailView.setOnClickListener(onClickListener);
    }
}
