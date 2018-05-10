package com.reddit.frontpage.ui.submit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.reddit.frontpage.util.ScreenUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 1, 9})
/* compiled from: BaseSubmitScreen.kt */
final class BaseSubmitScreen$submit$$inlined$apply$lambda$2 implements OnCancelListener {
    final /* synthetic */ BaseSubmitScreen f21603a;

    BaseSubmitScreen$submit$$inlined$apply$lambda$2(BaseSubmitScreen baseSubmitScreen) {
        this.f21603a = baseSubmitScreen;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ScreenUtil.m23891c(this.f21603a.am_());
        this.f21603a.ai_();
    }
}
