package com.reddit.frontpage.widgets.modtools;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.reddit.frontpage.util.ScreenUtil;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModSearchView.kt */
final class ModSearchView$$special$$inlined$apply$lambda$7 implements OnEditorActionListener {
    final /* synthetic */ EditText f21997a;
    final /* synthetic */ ModSearchView f21998b;

    ModSearchView$$special$$inlined$apply$lambda$7(EditText editText, ModSearchView modSearchView) {
        this.f21997a = editText;
        this.f21998b = modSearchView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Object a = Util.m23954a(this.f21997a.getContext());
        Intrinsics.m26843a(a, "Util.getActivityFromContext(context)");
        ScreenUtil.m23888a(a);
        this.f21998b.getSearchView().clearFocus();
        return true;
    }
}
