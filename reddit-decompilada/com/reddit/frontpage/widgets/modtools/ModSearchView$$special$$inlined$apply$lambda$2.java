package com.reddit.frontpage.widgets.modtools;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModSearchView.kt */
final class ModSearchView$$special$$inlined$apply$lambda$2 implements OnFocusChangeListener {
    final /* synthetic */ ModSearchView f21991a;

    ModSearchView$$special$$inlined$apply$lambda$2(ModSearchView modSearchView) {
        this.f21991a = modSearchView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            view = this.f21991a.getSearchViewCallback();
            if (view != null) {
                view.mo4907a();
            }
            this.f21991a.m24220a();
            return;
        }
        Object text = this.f21991a.getSearchView().getText();
        Intrinsics.m26843a(text, "searchView.text");
        if ((((CharSequence) text).length() == null ? true : null) != null) {
            this.f21991a.m24221b();
        }
    }
}
