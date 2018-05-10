package com.reddit.social.presentation.messaginglist.content;

import android.view.View;
import android.view.View.OnLongClickListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 5})
/* compiled from: Listeners.kt */
public final class TextKt$inlined$sam$OnLongClickListener$i$e2258e04 implements OnLongClickListener {
    private final /* synthetic */ Function1 f22427a;

    public TextKt$inlined$sam$OnLongClickListener$i$e2258e04(Function1 function1) {
        this.f22427a = function1;
    }

    public final /* synthetic */ boolean onLongClick(View view) {
        Object a = this.f22427a.mo6492a(view);
        Intrinsics.m26843a(a, "invoke(...)");
        return ((Boolean) a).booleanValue();
    }
}
