package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.requests.models.Gildable;
import com.reddit.frontpage.C1761R;

public class GoldCountView extends LinearLayout {
    public Gildable f21874a;
    public TextView f21875b;

    public GoldCountView(Context context) {
        super(context);
        m24144a();
    }

    public GoldCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24144a();
    }

    public GoldCountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24144a();
    }

    @TargetApi(21)
    public GoldCountView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m24144a();
    }

    private void m24144a() {
        setOrientation(0);
        inflate(getContext(), C1761R.layout.widget_gold_count, this);
        this.f21875b = (TextView) findViewById(C1761R.id.gild_count);
    }
}
