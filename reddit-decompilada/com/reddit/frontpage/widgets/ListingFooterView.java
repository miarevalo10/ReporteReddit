package com.reddit.frontpage.widgets;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.frontpage.util.AnimUtil;

public class ListingFooterView extends FrameLayout {
    TextView f21927a;
    OnClickListener f21928b;
    @BindView
    View errorContainer;
    @BindView
    View loadingIndicator;

    public ListingFooterView(Context context) {
        this(context, (byte) 0);
    }

    private ListingFooterView(Context context, byte b) {
        this(context, (char) (byte) 0);
    }

    private ListingFooterView(Context context, char c) {
        super(context, '\u0000', 0);
        inflate(context, 'ł', this);
        ButterKnife.a(this);
        setLayoutParams(new LayoutParams(-1, -2));
        this.loadingIndicator.setBackground(AnimUtil.m23637a(context));
        ((ViewStub) this.errorContainer).setOnInflateListener(new ListingFooterView$$Lambda$0(this));
        m24182a();
    }

    public final void m24182a() {
        this.loadingIndicator.setVisibility(8);
        this.errorContainer.setVisibility(8);
    }

    public final void m24184b() {
        this.loadingIndicator.setVisibility(0);
        this.errorContainer.setVisibility(8);
    }

    public final void m24183a(String str) {
        this.loadingIndicator.setVisibility(8);
        this.errorContainer.setVisibility(0);
        this.f21927a.setText(str);
    }

    public void setErrorOnClickListener(OnClickListener onClickListener) {
        this.f21928b = onClickListener;
    }
}
