package com.reddit.frontpage.presentation.dialogs;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.presentation.dialogs.BaseThingReportDialog.Companion;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseThingReportDialog.kt */
final class BaseThingReportDialog$initDialog$3 implements OnClickListener {
    public static final BaseThingReportDialog$initDialog$3 f20523a = new BaseThingReportDialog$initDialog$3();

    BaseThingReportDialog$initDialog$3() {
    }

    public final void onClick(View view) {
        view = BaseThingReportDialog.f28189e;
        if (Companion.m22820a().size() > 1) {
            view = BaseThingReportDialog.f28189e;
            view = Companion.m22820a();
            Companion companion = BaseThingReportDialog.f28189e;
            ((Dialog) view.get(Companion.m22820a().size() - 2)).show();
            view = BaseThingReportDialog.f28189e;
            view = Companion.m22820a();
            companion = BaseThingReportDialog.f28189e;
            ((Dialog) view.remove(Companion.m22820a().size() - 1)).dismiss();
            return;
        }
        view = BaseThingReportDialog.f28189e;
        ((Dialog) Companion.m22820a().remove(0)).dismiss();
    }
}
