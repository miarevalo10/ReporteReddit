package com.reddit.frontpage.presentation.dialogs.customreports;

import android.content.Context;
import com.reddit.datalibrary.frontpage.requests.models.v1.Thing;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listener.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 1, 9})
/* compiled from: CustomReportReasonsDialog.kt */
final class C2298xffd64681<T> implements Consumer<Integer> {
    final /* synthetic */ C2299xe2b475 f28206a;
    final /* synthetic */ String[] f28207b;

    C2298xffd64681(C2299xe2b475 c2299xe2b475, String[] strArr) {
        this.f28206a = c2299xe2b475;
        this.f28207b = strArr;
    }

    public final /* synthetic */ void mo4813a(Object obj) {
        obj = (Integer) obj;
        CustomReportReasonsDialog customReportReasonsDialog = this.f28206a.f28208a;
        String str = this.f28206a.f28209b;
        String str2 = this.f28206a.f28210c;
        Context context = this.f28206a.f28211d;
        Link link = this.f28206a.f28212e;
        Thing thing = this.f28206a.f28213f;
        String[] strArr = this.f28207b;
        Intrinsics.m26843a(obj, "it");
        String str3 = strArr[obj.intValue()];
        Intrinsics.m26843a((Object) str3, "rulesAbusive[it]");
        CustomReportReasonsDialog.m34661a(customReportReasonsDialog, str, str2, context, link, thing, str3, this.f28206a.f28215h).m29514c();
    }
}
