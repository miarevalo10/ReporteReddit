package com.reddit.frontpage.ui.share;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ShareActivity.kt */
final class ShareActivity$onCreate$4 extends Lambda implements Function1<Intent, Unit> {
    final /* synthetic */ ShareActivity f37383a;

    ShareActivity$onCreate$4(ShareActivity shareActivity) {
        this.f37383a = shareActivity;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intent intent = (Intent) obj;
        Intrinsics.m26847b(intent, "$receiver");
        Object intent2 = this.f37383a.getIntent();
        Intrinsics.m26843a(intent2, "intent");
        intent.putExtras(intent2.getExtras());
        return Unit.f25273a;
    }
}
