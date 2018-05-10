package com.reddit.frontpage.ui.listing;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModQueueListingScreen.kt */
final class ModQueueListingScreen$setupModQueueOptionsSheet$1 extends Lambda implements Function1<DialogInterface, Unit> {
    final /* synthetic */ ModQueueListingScreen f37286a;

    ModQueueListingScreen$setupModQueueOptionsSheet$1(ModQueueListingScreen modQueueListingScreen) {
        this.f37286a = modQueueListingScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DialogInterface dialogInterface = (DialogInterface) obj;
        Intrinsics.m26847b(dialogInterface, "dialogInterface");
        this.f37286a.E.d(true, "links");
        this.f37286a.mo7241c("links");
        dialogInterface.dismiss();
        return Unit.f25273a;
    }
}
