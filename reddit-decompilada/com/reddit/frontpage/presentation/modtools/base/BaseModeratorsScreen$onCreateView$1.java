package com.reddit.frontpage.presentation.modtools.base;

import com.reddit.frontpage.presentation.modtools.adapter.ModUsersAdapter;
import com.reddit.frontpage.widgets.modtools.ModSearchView;
import com.reddit.frontpage.widgets.modtools.ModSearchView.SearchViewCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/reddit/frontpage/presentation/modtools/base/BaseModeratorsScreen$onCreateView$1", "Lcom/reddit/frontpage/widgets/modtools/ModSearchView$SearchViewCallback;", "(Lcom/reddit/frontpage/presentation/modtools/base/BaseModeratorsScreen;)V", "onClear", "", "onClick", "onTextChanged", "s", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BaseModeratorsScreen.kt */
public final class BaseModeratorsScreen$onCreateView$1 implements SearchViewCallback {
    final /* synthetic */ BaseModeratorsScreen f28595a;

    BaseModeratorsScreen$onCreateView$1(BaseModeratorsScreen baseModeratorsScreen) {
        this.f28595a = baseModeratorsScreen;
    }

    public final void mo4907a() {
        ModSearchView modSearchView = this.f28595a.searchView;
        if (modSearchView == null) {
            Intrinsics.m26844a("searchView");
        }
        modSearchView.m24220a();
        ModUsersAdapter a = this.f28595a.f40092v;
        a.f28545c.clear();
        a.f28543a = a.f28545c;
        a.e();
    }

    public final void mo4908a(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "s");
        if ((charSequence.length() > 0 ? 1 : null) != null) {
            this.f28595a.mo7668w().mo6974a(charSequence.toString());
        } else {
            this.f28595a.f40092v.m29741b();
        }
    }

    public final void mo4909b() {
        this.f28595a.f40092v.m29741b();
    }
}
