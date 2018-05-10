package com.reddit.frontpage.ui.tokenautocomplete;

import android.content.Context;
import android.widget.TextView;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public class CountSpan extends ViewSpan {
    public String f29372a = "";

    public CountSpan(int i, Context context, int i2, int i3, int i4) {
        super(new TextView(context), i4);
        TextView textView = (TextView) this.c;
        textView.setTextColor(i2);
        textView.setTextSize(0, (float) i3);
        m30425a(i);
    }

    public final void m30425a(int i) {
        StringBuilder stringBuilder = new StringBuilder(Operation.PLUS);
        stringBuilder.append(i);
        this.f29372a = stringBuilder.toString();
        ((TextView) this.c).setText(this.f29372a);
    }
}
