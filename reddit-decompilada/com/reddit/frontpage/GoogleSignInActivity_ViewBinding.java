package com.reddit.frontpage;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class GoogleSignInActivity_ViewBinding implements Unbinder {
    private GoogleSignInActivity f27420b;

    public GoogleSignInActivity_ViewBinding(GoogleSignInActivity googleSignInActivity, View view) {
        this.f27420b = googleSignInActivity;
        googleSignInActivity.container = (FrameLayout) Utils.b(view, C1761R.id.container, "field 'container'", FrameLayout.class);
    }

    public final void m28886a() {
        GoogleSignInActivity googleSignInActivity = this.f27420b;
        if (googleSignInActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f27420b = null;
        googleSignInActivity.container = null;
    }
}
