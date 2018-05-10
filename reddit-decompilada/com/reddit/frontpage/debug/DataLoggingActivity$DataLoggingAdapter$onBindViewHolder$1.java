package com.reddit.frontpage.debug;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.debug.DataLoggingActivity.Data;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: DataLoggingActivity.kt */
final class DataLoggingActivity$DataLoggingAdapter$onBindViewHolder$1 implements OnClickListener {
    final /* synthetic */ DataLoggingAdapter f20113a;
    final /* synthetic */ int f20114b;

    DataLoggingActivity$DataLoggingAdapter$onBindViewHolder$1(DataLoggingAdapter dataLoggingAdapter, int i) {
        this.f20113a = dataLoggingAdapter;
        this.f20114b = i;
    }

    public final void onClick(View view) {
        Data data = (Data) this.f20113a.f27477b.get(this.f20114b);
        data.f20112e ^= 1;
        this.f20113a.f27477b.set(this.f20114b, data);
        this.f20113a.d(this.f20114b);
    }
}
