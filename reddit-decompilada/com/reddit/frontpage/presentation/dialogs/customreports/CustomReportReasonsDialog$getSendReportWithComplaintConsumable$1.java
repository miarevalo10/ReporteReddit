package com.reddit.frontpage.presentation.dialogs.customreports;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v1.Comment;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.dialogs.BaseThingReportDialog.DialogType;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: CustomReportReasonsDialog.kt */
final class CustomReportReasonsDialog$getSendReportWithComplaintConsumable$1<T> implements Consumer<Integer> {
    final /* synthetic */ CustomReportReasonsDialog f28200a;
    final /* synthetic */ String[] f28201b;
    final /* synthetic */ Thing f28202c;
    final /* synthetic */ Link f28203d;
    final /* synthetic */ String f28204e;
    final /* synthetic */ Context f28205f;

    CustomReportReasonsDialog$getSendReportWithComplaintConsumable$1(CustomReportReasonsDialog customReportReasonsDialog, String[] strArr, Thing thing, Link link, String str, Context context) {
        this.f28200a = customReportReasonsDialog;
        this.f28201b = strArr;
        this.f28202c = thing;
        this.f28203d = link;
        this.f28204e = str;
        this.f28205f = context;
    }

    public final /* synthetic */ void mo4813a(Object obj) {
        String c;
        obj = (Integer) obj;
        String[] strArr = this.f28201b;
        Intrinsics.m26843a(obj, "it");
        obj = strArr[obj.intValue()];
        if (this.f28202c instanceof Comment) {
            c = ((Comment) this.f28202c).c();
        } else {
            c = this.f28203d.getAuthor();
        }
        Object obj2 = c;
        CustomReportReasonsDialog customReportReasonsDialog = this.f28200a;
        String str = this.f28204e;
        Context context = this.f28205f;
        Link link = this.f28203d;
        c = Util.m23960a((int) C1761R.string.fmt_complaint, this.f28203d.getAuthor());
        Intrinsics.m26843a((Object) c, "Util.getString(R.string.…laint, parentLink.author)");
        String a = Util.m23960a((int) C1761R.string.success_report_complaint, this.f28203d.getAuthor());
        Intrinsics.m26843a(obj2, "blockUsername");
        customReportReasonsDialog.m29506a(str, context, link, c, a, obj2, new C2297x181551da(this, obj), DialogType.f20510b).show();
    }
}
