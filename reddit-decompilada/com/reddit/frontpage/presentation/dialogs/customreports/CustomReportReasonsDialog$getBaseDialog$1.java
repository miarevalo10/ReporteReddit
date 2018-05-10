package com.reddit.frontpage.presentation.dialogs.customreports;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.builders.CustomReasonsNoun;
import com.reddit.frontpage.commons.analytics.builders.CustomReportEventBuilder;
import com.reddit.frontpage.presentation.dialogs.BaseThingReportDialog;
import com.reddit.frontpage.presentation.dialogs.BaseThingReportDialog.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: CustomReportReasonsDialog.kt */
final class CustomReportReasonsDialog$getBaseDialog$1 implements OnClickListener {
    final /* synthetic */ Thing f20527a;
    final /* synthetic */ Link f20528b;

    CustomReportReasonsDialog$getBaseDialog$1(Thing thing, Link link) {
        this.f20527a = thing;
        this.f20528b = link;
    }

    public final void onClick(View view) {
        String str;
        view = BaseThingReportDialog.f28189e;
        if (Companion.m22820a().size() > 1) {
            view = BaseThingReportDialog.f28189e;
            if (Companion.m22820a().size() == 2) {
                str = CustomReasonsNoun.f20022g.f20028l;
            } else {
                view = BaseThingReportDialog.f28189e;
                if (Companion.m22820a().size() == 3) {
                    str = CustomReasonsNoun.f20023h.f20028l;
                } else {
                    view = BaseThingReportDialog.f28189e;
                    if (Companion.m22820a().size() == 4) {
                        str = CustomReasonsNoun.f20024i.f20028l;
                    } else {
                        str = "";
                    }
                }
            }
            Companion companion = BaseThingReportDialog.f28189e;
            List a = Companion.m22820a();
            Companion companion2 = BaseThingReportDialog.f28189e;
            ((Dialog) a.get(Companion.m22820a().size() - 2)).show();
            Companion companion3 = BaseThingReportDialog.f28189e;
            List a2 = Companion.m22820a();
            companion = BaseThingReportDialog.f28189e;
            ((Dialog) a2.remove(Companion.m22820a().size() - 1)).dismiss();
        } else {
            str = CustomReasonsNoun.f20021f.f20028l;
            Companion companion4 = BaseThingReportDialog.f28189e;
            ((Dialog) Companion.m22820a().remove(0)).dismiss();
        }
        if (!StringsKt__StringsJVMKt.m41943a((CharSequence) str)) {
            CustomReportEventBuilder.Companion companion5;
            if (this.f20527a instanceof Comment) {
                companion5 = CustomReportEventBuilder.f27449a;
                CustomReportEventBuilder.Companion.m21897a((Comment) this.f20527a, this.f20528b, "comment_report", "click", str);
                return;
            }
            companion5 = CustomReportEventBuilder.f27449a;
            CustomReportEventBuilder.Companion.m21899a(this.f20528b, "post_report", "click", str);
        }
    }
}
