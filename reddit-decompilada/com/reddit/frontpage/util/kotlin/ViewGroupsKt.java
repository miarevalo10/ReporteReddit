package com.reddit.frontpage.util.kotlin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"inflate", "Landroid/view/View;", "Landroid/view/ViewGroup;", "layoutRes", "", "attachToRoot", "", "app_standardRelease"}, k = 2, mv = {1, 1, 9})
/* compiled from: ViewGroups.kt */
public final class ViewGroupsKt {
    public static final View m24100a(ViewGroup viewGroup, int i, boolean z) {
        Intrinsics.m26847b(viewGroup, "$receiver");
        Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, z);
        Intrinsics.m26843a(inflate, "LayoutInflater.from(cont…tRes, this, attachToRoot)");
        return inflate;
    }
}
