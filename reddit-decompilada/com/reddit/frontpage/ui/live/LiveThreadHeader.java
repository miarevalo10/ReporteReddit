package com.reddit.frontpage.ui.live;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.reddit.frontpage.widgets.BaseHtmlTextView;

public class LiveThreadHeader extends LinearLayout {
    @BindView
    BaseHtmlTextView descriptionView;
    @BindView
    TextView titleView;

    public LiveThreadHeader(Context context) {
        super(context);
    }

    public LiveThreadHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LiveThreadHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public LiveThreadHeader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.a(this);
    }

    public void setTitle(String str) {
        this.titleView.setText(str);
    }

    public void setDescription(String str) {
        this.descriptionView.setHtmlFromString(str);
        if (TextUtils.isEmpty(this.descriptionView.getText()) != null) {
            this.descriptionView.setVisibility(TextUtils.isEmpty(this.descriptionView.getText()) ? 8 : 0);
        }
    }
}
