package com.reddit.frontpage.ui.submit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.reddit.frontpage.util.ScreenUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseSubmitScreen.kt */
final class BaseSubmitScreen$submit$$inlined$apply$lambda$1 implements OnDismissListener {
    final /* synthetic */ BaseSubmitScreen f21602a;

    BaseSubmitScreen$submit$$inlined$apply$lambda$1(BaseSubmitScreen baseSubmitScreen) {
        this.f21602a = baseSubmitScreen;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f21602a.f39340B = null;
        ScreenUtil.m23891c(this.f21602a.am_());
    }
}
