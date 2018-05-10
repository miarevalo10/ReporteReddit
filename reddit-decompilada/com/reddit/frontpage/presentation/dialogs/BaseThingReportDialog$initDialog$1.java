package com.reddit.frontpage.presentation.dialogs;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onCheckedChanged"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseThingReportDialog.kt */
final class BaseThingReportDialog$initDialog$1 implements OnCheckedChangeListener {
    final /* synthetic */ BaseThingReportDialog f20521a;

    BaseThingReportDialog$initDialog$1(BaseThingReportDialog baseThingReportDialog) {
        this.f20521a = baseThingReportDialog;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        radioGroup = this.f20521a.f28193c;
        if (radioGroup != null) {
            radioGroup.setEnabled(1);
        }
        radioGroup = this.f20521a.f28193c;
        if (radioGroup != null) {
            radioGroup.setAlpha(1065353216);
        }
    }
}
