package org.jetbrains.anko;

import android.content.Context;
import android.widget.TabWidget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/widget/TabWidget;", "ctx", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: Views.kt */
final class C$$Anko$Factories$Sdk21View$TAB_WIDGET$1 extends Lambda implements Function1<Context, TabWidget> {
    public static final C$$Anko$Factories$Sdk21View$TAB_WIDGET$1 f39019a = new C$$Anko$Factories$Sdk21View$TAB_WIDGET$1();

    C$$Anko$Factories$Sdk21View$TAB_WIDGET$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Context context = (Context) obj;
        Intrinsics.m26847b(context, "ctx");
        return new TabWidget(context);
    }
}
