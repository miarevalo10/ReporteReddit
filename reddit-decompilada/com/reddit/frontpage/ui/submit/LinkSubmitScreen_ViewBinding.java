package com.reddit.frontpage.ui.submit;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class LinkSubmitScreen_ViewBinding implements Unbinder {
    private LinkSubmitScreen f29313b;

    public LinkSubmitScreen_ViewBinding(LinkSubmitScreen linkSubmitScreen, View view) {
        this.f29313b = linkSubmitScreen;
        linkSubmitScreen.submitLink = (EditText) Utils.b(view, C1761R.id.submit_link, "field 'submitLink'", EditText.class);
        linkSubmitScreen.safeHarborText = (TextView) Utils.b(view, C1761R.id.safe_harbor, "field 'safeHarborText'", TextView.class);
    }

    public final void m30396a() {
        LinkSubmitScreen linkSubmitScreen = this.f29313b;
        if (linkSubmitScreen == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29313b = null;
        linkSubmitScreen.submitLink = null;
        linkSubmitScreen.safeHarborText = null;
    }
}
