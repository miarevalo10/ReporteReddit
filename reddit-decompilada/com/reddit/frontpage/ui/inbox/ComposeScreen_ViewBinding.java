package com.reddit.frontpage.ui.inbox;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class ComposeScreen_ViewBinding implements Unbinder {
    private ComposeScreen f28990b;

    public ComposeScreen_ViewBinding(ComposeScreen composeScreen, View view) {
        this.f28990b = composeScreen;
        composeScreen.subject = (EditText) Utils.b(view, C1761R.id.subject, "field 'subject'", EditText.class);
        composeScreen.prefix = (TextView) Utils.b(view, C1761R.id.prefix, "field 'prefix'", TextView.class);
        composeScreen.to = (EditText) Utils.b(view, C1761R.id.to, "field 'to'", EditText.class);
        composeScreen.text = (EditText) Utils.b(view, C1761R.id.text, "field 'text'", EditText.class);
    }

    public final void m30044a() {
        ComposeScreen composeScreen = this.f28990b;
        if (composeScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f28990b = null;
        composeScreen.subject = null;
        composeScreen.prefix = null;
        composeScreen.to = null;
        composeScreen.text = null;
    }
}
