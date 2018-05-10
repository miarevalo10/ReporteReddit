package com.reddit.frontpage.debug;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.reddit.frontpage.debug.DataLoggingActivity.Data;
import com.reddit.frontpage.debug.DataLoggingActivity.DataViewHolder;
import com.reddit.frontpage.util.Util;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: DataLoggingActivity.kt */
final class DataLoggingActivity$DataLoggingAdapter$onBindViewHolder$2 implements OnLongClickListener {
    final /* synthetic */ DataLoggingAdapter f20115a;
    final /* synthetic */ int f20116b;
    final /* synthetic */ DataViewHolder f20117c;

    DataLoggingActivity$DataLoggingAdapter$onBindViewHolder$2(DataLoggingAdapter dataLoggingAdapter, int i, DataViewHolder dataViewHolder) {
        this.f20115a = dataLoggingAdapter;
        this.f20116b = i;
        this.f20117c = dataViewHolder;
    }

    public final boolean onLongClick(View view) {
        Data data = (Data) this.f20115a.f27477b.get(this.f20116b);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
        String format = String.format("%d. %s: %s", Arrays.copyOf(new Object[]{data.f20109b, data.f20108a, data.f20110c}, 3));
        Intrinsics.m26843a((Object) format, "java.lang.String.format(format, *args)");
        Util.m23969a((Context) this.f20115a.f27478c, format, DataLoggingActivity.m42473a(this.f20115a.f27478c, data.f20111d));
        View view2 = this.f20117c.c;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f25295a;
        Object format2 = String.format("Copied event #%d to clipboard.", Arrays.copyOf(new Object[]{data.f20109b}, 1));
        Intrinsics.m26843a(format2, "java.lang.String.format(format, *args)");
        Snackbar.a(view2, (CharSequence) format2, -1).a();
        return true;
    }
}
