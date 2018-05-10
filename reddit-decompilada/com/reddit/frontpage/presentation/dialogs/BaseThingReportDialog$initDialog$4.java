package com.reddit.frontpage.presentation.dialogs;

import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.reddit.frontpage.ui.listener.Consumer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseThingReportDialog.kt */
final class BaseThingReportDialog$initDialog$4 implements OnClickListener {
    final /* synthetic */ RadioGroup f20524a;
    final /* synthetic */ Consumer f20525b;
    final /* synthetic */ AppCompatDialog f20526c;

    BaseThingReportDialog$initDialog$4(RadioGroup radioGroup, Consumer consumer, AppCompatDialog appCompatDialog) {
        this.f20524a = radioGroup;
        this.f20525b = consumer;
        this.f20526c = appCompatDialog;
    }

    public final void onClick(View view) {
        view = this.f20524a;
        view = view != null ? Integer.valueOf(view.getCheckedRadioButtonId()) : null;
        if (view == null) {
            Intrinsics.m26842a();
        }
        RadioButton radioButton = (RadioButton) this.f20524a.findViewById(view.intValue());
        if (radioButton != null) {
            Consumer consumer = this.f20525b;
            view = radioButton.getTag();
            if (view == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
            consumer.mo4813a((Integer) view);
            this.f20526c.dismiss();
        }
    }
}
