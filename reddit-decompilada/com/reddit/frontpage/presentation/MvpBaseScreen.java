package com.reddit.frontpage.presentation;

import android.os.Bundle;
import com.evernote.android.state.StateSaver;
import com.reddit.frontpage.ui.BaseScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0014¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/presentation/MvpBaseScreen;", "Lcom/reddit/frontpage/ui/BaseScreen;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "onRestoreScreenState", "", "savedInstanceState", "onSaveScreenState", "outState", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MvpBaseScreen.kt */
public abstract class MvpBaseScreen extends BaseScreen {
    public MvpBaseScreen() {
        this();
    }

    public MvpBaseScreen(Bundle bundle) {
        super(bundle);
    }

    protected final void mo7148d(Bundle bundle) {
        Intrinsics.m26847b(bundle, "outState");
        StateSaver.saveInstanceState(this, bundle);
    }

    protected final void mo7149e(Bundle bundle) {
        Intrinsics.m26847b(bundle, "savedInstanceState");
        StateSaver.restoreInstanceState(this, bundle);
    }
}
