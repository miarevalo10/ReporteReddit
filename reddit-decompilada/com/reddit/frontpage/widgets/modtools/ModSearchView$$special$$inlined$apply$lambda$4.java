package com.reddit.frontpage.widgets.modtools;

import android.text.Editable;
import android.text.TextWatcher;
import com.reddit.frontpage.widgets.modtools.ModSearchView.SearchViewCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J(\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/reddit/frontpage/widgets/modtools/ModSearchView$2$3", "Landroid/text/TextWatcher;", "(Lcom/reddit/frontpage/widgets/modtools/ModSearchView$2;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModSearchView.kt */
public final class ModSearchView$$special$$inlined$apply$lambda$4 implements TextWatcher {
    final /* synthetic */ ModSearchView f21994a;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.m26847b(charSequence, "s");
    }

    ModSearchView$$special$$inlined$apply$lambda$4(ModSearchView modSearchView) {
        this.f21994a = modSearchView;
    }

    public final void afterTextChanged(Editable editable) {
        SearchViewCallback searchViewCallback = this.f21994a.getSearchViewCallback();
        if (searchViewCallback != null) {
            searchViewCallback.mo4908a(String.valueOf(editable));
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.m26847b(charSequence, "s");
        i2 = 1;
        if ((charSequence.length() > 0 ? 1 : 0) == 0 || this.f21994a.getClearView().getVisibility() != 8) {
            if (charSequence.length() != 0) {
                i2 = 0;
            }
            if (i2 != 0 && this.f21994a.getClearView().getVisibility() == 0) {
                this.f21994a.getClearView().setVisibility(8);
            }
        } else {
            this.f21994a.getClearView().setVisibility(0);
        }
        i = this.f21994a.getSearchViewCallback();
        if (i != 0) {
            i.mo4908a(charSequence);
        }
    }
}
