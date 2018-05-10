package com.reddit.frontpage.presentation.dialogs.customreports;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: CustomReportReasonsDialog.kt */
final class C2299xe2b475<T> implements Consumer<Integer> {
    final /* synthetic */ CustomReportReasonsDialog f28208a;
    final /* synthetic */ String f28209b;
    final /* synthetic */ String f28210c;
    final /* synthetic */ Context f28211d;
    final /* synthetic */ Link f28212e;
    final /* synthetic */ Thing f28213f;
    final /* synthetic */ String[] f28214g;
    final /* synthetic */ Function0 f28215h;

    C2299xe2b475(CustomReportReasonsDialog customReportReasonsDialog, String str, String str2, Context context, Link link, Thing thing, String[] strArr, Function0 function0) {
        this.f28208a = customReportReasonsDialog;
        this.f28209b = str;
        this.f28210c = str2;
        this.f28211d = context;
        this.f28212e = link;
        this.f28213f = thing;
        this.f28214g = strArr;
        this.f28215h = function0;
    }

    public final /* synthetic */ void mo4813a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            if (num.intValue() == 0) {
                this.f28208a.m29507a(this.f28209b, this.f28210c, this.f28211d, this.f28212e, this.f28213f, "site_reason_selected", null, this.f28214g, this.f28215h).mo4813a(num);
                return;
            }
        }
        if (num != null) {
            if (num.intValue() == 1) {
                String[] stringArray = this.f28211d.getResources().getStringArray(C1761R.array.report_reasons_abusive);
                Consumer consumer = (Consumer) new C2298xffd64681(this, stringArray);
                String str = this.f28209b;
                Context context = this.f28211d;
                Intrinsics.m26843a((Object) stringArray, "rulesAbusive");
                String f = Util.m24027f((int) C1761R.string.option_report_reason_abusive_way);
                Intrinsics.m26843a((Object) f, "Util.getString(R.string.…eport_reason_abusive_way)");
                new CustomReportReasonsDialog(str, context, stringArray, f, this.f28212e, consumer).m29514c();
                return;
            }
        }
        if (num != null && num.intValue() == 2) {
            obj = this.f28211d.getResources().getStringArray(C1761R.array.report_reasons_private);
            Intrinsics.m26843a(obj, "rulesPrivate");
            consumer = this.f28208a.m29507a(this.f28209b, this.f28210c, this.f28211d, this.f28212e, this.f28213f, "site_reason_selected", null, obj, this.f28215h);
            str = this.f28209b;
            context = this.f28211d;
            f = Util.m24027f((int) C1761R.string.option_report_reason_private_content);
            Intrinsics.m26843a((Object) f, "Util.getString(R.string.…t_reason_private_content)");
            new CustomReportReasonsDialog(str, context, (String[]) obj, f, this.f28212e, consumer).m29514c();
        }
    }
}
