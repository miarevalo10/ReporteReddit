package com.reddit.frontpage.ui.alert;

import com.reddit.frontpage.ui.alert.RedditAlertDialog.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "submittedText", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
final class RedditAlertDialog$Companion$reportOtherDialog$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String f37165a;
    final /* synthetic */ Function0 f37166b;

    RedditAlertDialog$Companion$reportOtherDialog$1(String str, Function0 function0) {
        this.f37165a = str;
        this.f37166b = function0;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "submittedText");
        Companion companion = RedditAlertDialog.f21112b;
        Companion.m23303a(this.f37165a, "other", str, this.f37166b);
        return Unit.f25273a;
    }
}
