package com.reddit.frontpage.util;

import android.content.Intent;
import com.reddit.datalibrary.frontpage.service.api.SubmitService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: SubmitUtil.kt */
final class SubmitUtil$submitImage$1 extends Lambda implements Function1<Intent, Unit> {
    final /* synthetic */ String f37394a;

    SubmitUtil$submitImage$1(String str) {
        this.f37394a = str;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intent intent = (Intent) obj;
        Intrinsics.m26847b(intent, "$receiver");
        intent.putExtra(SubmitService.EXTRA_IMAGE, this.f37394a);
        return Unit.f25273a;
    }
}
