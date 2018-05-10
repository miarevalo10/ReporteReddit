package com.reddit.frontpage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class DetailHolderScreen_ViewBinding implements Unbinder {
    private DetailHolderScreen f27398b;

    public DetailHolderScreen_ViewBinding(DetailHolderScreen detailHolderScreen, View view) {
        this.f27398b = detailHolderScreen;
        detailHolderScreen.container = (ViewGroup) Utils.b(view, C1761R.id.detail_container, "field 'container'", ViewGroup.class);
        detailHolderScreen.stub = (ViewStub) Utils.b(view, C1761R.id.stub, "field 'stub'", ViewStub.class);
    }

    public final void m28859a() {
        DetailHolderScreen detailHolderScreen = this.f27398b;
        if (detailHolderScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f27398b = null;
        detailHolderScreen.container = null;
        detailHolderScreen.stub = null;
    }
}
