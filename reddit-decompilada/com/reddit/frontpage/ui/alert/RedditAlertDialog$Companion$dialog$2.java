package com.reddit.frontpage.ui.alert;

import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J(\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/reddit/frontpage/ui/alert/RedditAlertDialog$Companion$dialog$2", "Landroid/text/TextWatcher;", "(Landroid/support/v7/app/AlertDialog;Landroid/widget/EditText;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditAlertDialog.kt */
public final class RedditAlertDialog$Companion$dialog$2 implements TextWatcher {
    final /* synthetic */ AlertDialog f21096a;
    final /* synthetic */ EditText f21097b;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.m26847b(charSequence, "s");
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.m26847b(charSequence, "s");
    }

    RedditAlertDialog$Companion$dialog$2(AlertDialog alertDialog, EditText editText) {
        this.f21096a = alertDialog;
        this.f21097b = editText;
    }

    public final void afterTextChanged(Editable editable) {
        int i;
        Intrinsics.m26847b(editable, "s");
        Object a = this.f21096a.a(-1);
        Intrinsics.m26843a(a, "reportDialog\n           …rtDialog.BUTTON_POSITIVE)");
        Object obj = this.f21097b;
        Intrinsics.m26843a(obj, "inputView");
        CharSequence text = obj.getText();
        if (text != null) {
            if (!StringsKt__StringsJVMKt.m41943a(text)) {
                i = 0;
                a.setEnabled(i ^ true);
            }
        }
        i = 1;
        a.setEnabled(i ^ true);
    }
}
