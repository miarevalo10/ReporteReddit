package com.reddit.frontpage.ui.listing.newcard;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.requests.images.ImageProgressLoadListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.animation.SnooProgressDrawable;
import com.reddit.frontpage.util.CountUtil;
import com.reddit.frontpage.util.CrosspostUtil;
import com.reddit.frontpage.util.DateUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.TopCrop;
import com.reddit.frontpage.util.Util;

public class XpostImageCardBodyView extends LinearLayout {
    private static final String f21401a = Util.m24027f((int) C1761R.string.unicode_delimiter);
    private SnooProgressDrawable f21402b;
    private String f21403c;
    private String f21404d;
    private String f21405e;
    private Link f21406f;
    @BindView
    RightIndentTextView headerMetadataView;
    @BindView
    RightIndentTextView metadataView;
    @BindView
    ImageView playIcon;
    @BindView
    ImageView preview;
    @BindView
    RightIndentTextView titleView;

    public enum ImageHeight {
        FULL,
        CROPPED
    }

    public XpostImageCardBodyView(Context context) {
        this(context, null);
    }

    public XpostImageCardBodyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XpostImageCardBodyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23494a(context);
    }

    @TargetApi(21)
    public XpostImageCardBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m23494a(context);
    }

    private void m23494a(Context context) {
        this.f21402b = new SnooProgressDrawable(context);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.a(this);
    }

    public final void m23495a(Link link) {
        m23496a(link, ImageHeight.FULL);
    }

    public final void m23496a(Link link, ImageHeight imageHeight) {
        String f;
        this.f21406f = link;
        this.f21403c = link.getTitle();
        this.f21405e = null;
        CharSequence b = DateUtil.m23684b(link.getCreatedUtc());
        int i = 1;
        if (Util.m24041k(link.getAuthor())) {
            f = Util.m24027f((int) C1761R.string.deleted_author);
        } else {
            f = Util.m23960a((int) C1761R.string.fmt_u_name, link.getAuthor());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(link.getSubredditNamePrefixed());
        stringBuilder.append(f21401a);
        stringBuilder.append(b);
        stringBuilder.append(f21401a);
        stringBuilder.append(f);
        this.f21404d = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        int score = link.getScore();
        long numComments = link.getNumComments();
        String a = CountUtil.m23674a(numComments);
        stringBuilder2.append(Util.m23959a((int) C1761R.plurals.fmt_num_points, score, Integer.valueOf(score)));
        stringBuilder2.append(f21401a);
        stringBuilder2.append(Util.m23959a((int) C1761R.plurals.fmt_num_comments, (int) numComments, a));
        this.f21405e = stringBuilder2.toString();
        this.titleView.setText(this.f21403c);
        score = 8;
        if (TextUtils.isEmpty(this.f21405e)) {
            this.metadataView.setVisibility(8);
        } else {
            this.headerMetadataView.setText(this.f21404d);
            this.metadataView.setText(this.f21405e);
            this.metadataView.setVisibility(0);
        }
        invalidate();
        requestLayout();
        int a2 = CrosspostUtil.m23675a();
        link = LinkUtil.m23775a(link, FrontpageSettings.a().g(), Util.m23993b());
        if (this.preview != null) {
            if (this.playIcon != null) {
                if (link == null) {
                    this.preview.setVisibility(8);
                    return;
                }
                if (imageHeight != ImageHeight.CROPPED) {
                    i = 0;
                }
                if (i != 0) {
                    imageHeight = CrosspostUtil.m23676a(link, a2);
                } else {
                    imageHeight = CrosspostUtil.m23677b(link, a2);
                }
                this.preview.getLayoutParams().height = imageHeight;
                imageHeight = Util.m24010c(this.f21406f);
                ImageView imageView = this.playIcon;
                if (imageHeight != null) {
                    score = 0;
                }
                imageView.setVisibility(score);
                GlideApp.a(getContext()).b(link.getUrl()).diskCacheStrategy(DiskCacheStrategy.a).transform(i != 0 ? new TopCrop() : UnitTransformation.a()).transition(DrawableTransitionOptions.b()).placeholder(this.f21402b).listener(ImageProgressLoadListener.a(this.f21402b, link.getUrl())).into(this.preview).f();
            }
        }
    }

    public void setTitleAlpha(int i) {
        this.titleView.setTextColor(this.titleView.getTextColors().withAlpha(i));
    }

    public void setPreviewOnClickListener(OnClickListener onClickListener) {
        if (this.preview != null) {
            this.preview.setOnClickListener(onClickListener);
        }
    }
}
