package com.reddit.frontpage.ui.preferences;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: BottomSheetListDialogFragment.kt */
final class C2904xbba9f092 extends Lambda implements Function1<DialogInterface, Unit> {
    final /* synthetic */ String f37324a;
    final /* synthetic */ BottomSheetListDialogFragment f37325b;

    C2904xbba9f092(String str, BottomSheetListDialogFragment bottomSheetListDialogFragment) {
        this.f37324a = str;
        this.f37325b = bottomSheetListDialogFragment;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Intrinsics.m26847b((DialogInterface) obj, "it");
        if (this.f37325b.m39355e().a(this.f37324a) != null) {
            this.f37325b.m39355e().a(this.f37324a);
        }
        this.f37325b.b();
        return Unit.f25273a;
    }
}
