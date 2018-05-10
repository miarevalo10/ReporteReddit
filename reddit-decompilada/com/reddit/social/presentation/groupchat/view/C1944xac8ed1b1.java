package com.reddit.social.presentation.groupchat.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 5})
/* compiled from: Listeners.kt */
public final class C1944xac8ed1b1 implements OnCheckedChangeListener {
    private final /* synthetic */ Function2 f22370a;

    public C1944xac8ed1b1(Function2 function2) {
        this.f22370a = function2;
    }

    public final /* synthetic */ void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Intrinsics.m26843a(this.f22370a.mo6497a(compoundButton, Boolean.valueOf(z)), "invoke(...)");
    }
}
