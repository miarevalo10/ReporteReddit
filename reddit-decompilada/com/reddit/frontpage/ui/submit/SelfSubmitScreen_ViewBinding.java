package com.reddit.frontpage.ui.submit;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class SelfSubmitScreen_ViewBinding implements Unbinder {
    private SelfSubmitScreen f29332b;

    public SelfSubmitScreen_ViewBinding(SelfSubmitScreen selfSubmitScreen, View view) {
        this.f29332b = selfSubmitScreen;
        selfSubmitScreen.submitText = (EditText) Utils.b(view, C1761R.id.submit_text, "field 'submitText'", EditText.class);
    }

    public final void m30400a() {
        SelfSubmitScreen selfSubmitScreen = this.f29332b;
        if (selfSubmitScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29332b = null;
        selfSubmitScreen.submitText = null;
    }
}
