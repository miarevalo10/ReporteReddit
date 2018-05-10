package com.reddit.frontpage.presentation.common.ui.view.listoptions;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionAction;", "", "actionName", "", "iconResId", "", "onClick", "Lkotlin/Function1;", "Landroid/content/DialogInterface;", "", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "getActionName", "()Ljava/lang/String;", "getIconResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListOptionAction.kt */
public final class ListOptionAction {
    final String f20390a;
    final Integer f20391b;
    final Function1<DialogInterface, Unit> f20392c;

    public ListOptionAction(String str, Integer num, Function1<? super DialogInterface, Unit> function1) {
        Intrinsics.m26847b(str, "actionName");
        Intrinsics.m26847b(function1, "onClick");
        this.f20390a = str;
        this.f20391b = num;
        this.f20392c = function1;
    }
}
