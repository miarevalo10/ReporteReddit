package com.reddit.frontpage.presentation.dialogs.customreports;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ThingReportPresenter.kt */
final class ThingReportPresenter$findAndBlockUser$1<T> implements Consumer<Account> {
    final /* synthetic */ ThingReportPresenter f28227a;
    final /* synthetic */ String f28228b;

    ThingReportPresenter$findAndBlockUser$1(ThingReportPresenter thingReportPresenter, String str) {
        this.f28227a = thingReportPresenter;
        this.f28228b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        Account account = (Account) obj;
        ThingReportPresenter thingReportPresenter = this.f28227a;
        obj = SessionUtil.m23893a(account.getId());
        Intrinsics.m26843a(obj, "SessionUtil.prependUserTypeIfMissing(result.id)");
        SinglesKt.m24094b(thingReportPresenter.f33850c.m22444b(obj), thingReportPresenter.f33849b).subscribe(new ThingReportPresenter$blockUser$1(thingReportPresenter, this.f28228b), (Consumer) new ThingReportPresenter$blockUser$2(thingReportPresenter));
    }
}
