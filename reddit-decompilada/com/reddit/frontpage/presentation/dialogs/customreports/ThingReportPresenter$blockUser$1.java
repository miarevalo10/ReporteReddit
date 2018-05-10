package com.reddit.frontpage.presentation.dialogs.customreports;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: ThingReportPresenter.kt */
final class ThingReportPresenter$blockUser$1<T> implements Consumer<Response<ResponseBody>> {
    final /* synthetic */ ThingReportPresenter f28224a;
    final /* synthetic */ String f28225b;

    ThingReportPresenter$blockUser$1(ThingReportPresenter thingReportPresenter, String str) {
        this.f28224a = thingReportPresenter;
        this.f28225b = str;
    }

    public final /* synthetic */ void accept(Object obj) {
        this.f28224a.f33848a.mo4815b(this.f28225b);
    }
}
