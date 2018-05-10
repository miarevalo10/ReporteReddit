package com.reddit.social.presentation;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "focused", "", "onFocusChange"}, k = 3, mv = {1, 1, 9})
/* compiled from: EditTextWithCounter.kt */
final class EditTextWithCounter$init$2 implements OnFocusChangeListener {
    final /* synthetic */ EditTextWithCounter f22310a;

    EditTextWithCounter$init$2(EditTextWithCounter editTextWithCounter) {
        this.f22310a = editTextWithCounter;
    }

    public final void onFocusChange(View view, boolean z) {
        ViewsKt.m24106b(this.f22310a.getCharCounter(), z);
        Function2 b = this.f22310a.f22311a;
        if (b != null) {
            Intrinsics.m26843a((Object) view, "view");
            b.mo6497a(view, Boolean.valueOf(z));
        }
    }
}
