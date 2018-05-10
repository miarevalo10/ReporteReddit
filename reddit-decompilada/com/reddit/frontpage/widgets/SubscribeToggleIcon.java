package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;

public class SubscribeToggleIcon extends FrameLayout {
    private Drawable f21950a;
    private Drawable f21951b;
    @BindView
    ImageView icon;

    public SubscribeToggleIcon(Context context) {
        this(context, null);
    }

    public SubscribeToggleIcon(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1761R.attr.linkStatusViewStyle);
    }

    public SubscribeToggleIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24196a(context);
    }

    @TargetApi(21)
    public SubscribeToggleIcon(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m24196a(context);
    }

    private void m24196a(Context context) {
        LayoutInflater.from(context).inflate(C1761R.layout.merge_subscribe_toggle_icon, this, true);
        ButterKnife.a(this);
        this.f21950a = Util.m24032h((int) C1761R.drawable.ic_icon_subscribe);
        this.f21951b = Util.m24032h((int) C1761R.drawable.ic_icon_subscribed);
    }

    public void setSubscribe(Boolean bool) {
        if (bool != null) {
            this.icon.setImageDrawable(bool.booleanValue() != null ? this.f21951b : this.f21950a);
        }
    }
}
