package com.reddit.frontpage.presentation.dialogs;

import android.content.Context;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.dialogs.BaseThingReportDialog.DialogType;
import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportPresenter;
import com.reddit.frontpage.ui.listener.Consumer;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseThingReportDialog.kt */
final class BaseThingReportDialog$getSendReportWithPostActionConsumable$1<T> implements Consumer<Integer> {
    final /* synthetic */ BaseThingReportDialog f28179a;
    final /* synthetic */ String f28180b;
    final /* synthetic */ String f28181c;
    final /* synthetic */ String[] f28182d;
    final /* synthetic */ Thing f28183e;
    final /* synthetic */ Function0 f28184f;
    final /* synthetic */ String f28185g;
    final /* synthetic */ Context f28186h;
    final /* synthetic */ Link f28187i;
    final /* synthetic */ String f28188j;

    BaseThingReportDialog$getSendReportWithPostActionConsumable$1(BaseThingReportDialog baseThingReportDialog, String str, String str2, String[] strArr, Thing thing, Function0 function0, String str3, Context context, Link link, String str4) {
        this.f28179a = baseThingReportDialog;
        this.f28180b = str;
        this.f28181c = str2;
        this.f28182d = strArr;
        this.f28183e = thing;
        this.f28184f = function0;
        this.f28185g = str3;
        this.f28186h = context;
        this.f28187i = link;
        this.f28188j = str4;
    }

    public final /* synthetic */ void mo4813a(Object obj) {
        obj = (Integer) obj;
        String str = "";
        if (!TextUtils.isEmpty(this.f28180b)) {
            if (TextUtils.isEmpty(this.f28181c)) {
                String[] strArr = this.f28182d;
                Intrinsics.m26843a(obj, "it");
                str = strArr[obj.intValue()];
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.f28181c);
                stringBuilder.append(" ");
                String[] strArr2 = this.f28182d;
                Intrinsics.m26843a(obj, "it");
                String str2 = strArr2[obj.intValue()];
                if (str2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                Object toLowerCase = str2.toLowerCase();
                Intrinsics.m26843a(toLowerCase, "(this as java.lang.String).toLowerCase()");
                stringBuilder.append(toLowerCase);
                str = stringBuilder.toString();
            }
        }
        ThingReportPresenter b = this.f28179a.m29511b();
        Thing thing = this.f28183e;
        String str3 = this.f28180b;
        if (str3 == null) {
            String[] strArr3 = this.f28182d;
            Intrinsics.m26843a(obj, "it");
            str3 = strArr3[obj.intValue()];
        }
        obj = this.f28184f;
        Intrinsics.m26847b(thing, "thing");
        Intrinsics.m26847b(str3, "reason");
        Intrinsics.m26847b(str, "siteReason");
        SinglesKt.m24094b(b.f33850c.m22455d(thing.getName(), str3, str), b.f33849b).subscribe(new ThingReportPresenter$reportLink$1(obj), (io.reactivex.functions.Consumer) new ThingReportPresenter$reportLink$2(b));
        BaseThingReportDialog baseThingReportDialog = this.f28179a;
        String str4 = this.f28185g;
        Context context = this.f28186h;
        Link link = this.f28187i;
        String a = Util.m23960a((int) C1761R.string.fmt_block_user, this.f28188j);
        Intrinsics.m26843a((Object) a, "Util.getString(R.string.…lock_user, blockUsername)");
        String str5 = a;
        this.f28179a.m29508a(baseThingReportDialog.m29506a(str4, context, link, str5, Util.m23960a((int) C1761R.string.fmt_block_pre_message, this.f28188j), this.f28188j, new C2296x606748bc(this), DialogType.f20509a));
        this.f28179a.m29514c();
    }
}
