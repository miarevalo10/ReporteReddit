package com.reddit.frontpage.presentation.dialogs.customreports;

import com.reddit.frontpage.presentation.dialogs.customreports.ThingReportContract.View;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ThingReportPresenter.kt */
final class ThingReportPresenter$blockUser$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ThingReportPresenter f28226a;

    ThingReportPresenter$blockUser$2(ThingReportPresenter thingReportPresenter) {
        this.f28226a = thingReportPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Throwable th = (Throwable) obj;
        View view = this.f28226a.f33848a;
        Intrinsics.m26843a((Object) th, "it");
        view.mo4816b(th);
    }
}
