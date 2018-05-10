package com.reddit.frontpage.ui.submit;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.reddit.frontpage.C1761R;

public class ReplyFragmentLegacy_ViewBinding implements Unbinder {
    private ReplyFragmentLegacy f29329b;

    public ReplyFragmentLegacy_ViewBinding(ReplyFragmentLegacy replyFragmentLegacy, View view) {
        this.f29329b = replyFragmentLegacy;
        replyFragmentLegacy.toolbar = (Toolbar) Utils.b(view, C1761R.id.toolbar, "field 'toolbar'", Toolbar.class);
        replyFragmentLegacy.replyText = (EditText) Utils.b(view, C1761R.id.reply_text, "field 'replyText'", EditText.class);
        replyFragmentLegacy.mTargetContainer = (FrameLayout) Utils.b(view, C1761R.id.replyable_container, "field 'mTargetContainer'", FrameLayout.class);
    }

    public final void m30399a() {
        ReplyFragmentLegacy replyFragmentLegacy = this.f29329b;
        if (replyFragmentLegacy == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29329b = null;
        replyFragmentLegacy.toolbar = null;
        replyFragmentLegacy.replyText = null;
        replyFragmentLegacy.mTargetContainer = null;
    }
}
