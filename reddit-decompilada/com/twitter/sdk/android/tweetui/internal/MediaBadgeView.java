package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.instabug.chat.model.Attachment;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.tweetui.C2075R;

public class MediaBadgeView extends FrameLayout {
    TextView f24224a;
    ImageView f24225b;

    public MediaBadgeView(Context context) {
        this(context, null);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C2075R.layout.tw__media_badge, this, 1);
        this.f24224a = (TextView) context.findViewById(C2075R.id.tw__video_duration);
        this.f24225b = (ImageView) context.findViewById(C2075R.id.tw__gif_badge);
    }

    public void setMediaEntity(MediaEntity mediaEntity) {
        if ("animated_gif".equals(mediaEntity.f34649e)) {
            setBadge(getResources().getDrawable(C2075R.drawable.tw__gif_badge));
        } else if (Attachment.TYPE_VIDEO.equals(mediaEntity.f34649e)) {
            setText(mediaEntity.f34650f == null ? 0 : mediaEntity.f34650f.f24113a);
        } else {
            m25954a();
        }
    }

    public void setCard(Card card) {
        if (VineCardUtils.m25864a(card) != null) {
            setBadge(getResources().getDrawable(C2075R.drawable.tw__vine_badge));
        } else {
            m25954a();
        }
    }

    void setText(long j) {
        this.f24224a.setVisibility(0);
        this.f24225b.setVisibility(8);
        this.f24224a.setText(MediaTimeUtils.m25955a(j));
    }

    void setBadge(Drawable drawable) {
        this.f24225b.setVisibility(0);
        this.f24224a.setVisibility(8);
        this.f24225b.setImageDrawable(drawable);
    }

    private void m25954a() {
        this.f24224a.setVisibility(8);
        this.f24225b.setVisibility(8);
    }
}
