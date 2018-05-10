package com.reddit.frontpage.ui.submit;

import android.widget.EditText;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import com.reddit.frontpage.widgets.submit.OnQuoteSelectedListener;

final /* synthetic */ class ReplyFragmentLegacy$$Lambda$0 implements OnQuoteSelectedListener {
    private final ReplyFragmentLegacy f29327a;

    ReplyFragmentLegacy$$Lambda$0(ReplyFragmentLegacy replyFragmentLegacy) {
        this.f29327a = replyFragmentLegacy;
    }

    public final void mo4812a(CharSequence charSequence) {
        ReplyFragmentLegacy replyFragmentLegacy = this.f29327a;
        StringBuilder stringBuilder = new StringBuilder(Operation.GREATER_THAN);
        stringBuilder.append(charSequence.toString().replace("\n\n", "\n\n>"));
        charSequence = stringBuilder.toString();
        String obj = replyFragmentLegacy.replyText.getText().toString();
        if (obj.trim().isEmpty()) {
            replyFragmentLegacy.replyText.setText(charSequence);
        } else if (obj.endsWith("\n\n")) {
            replyFragmentLegacy.replyText.append(charSequence);
        } else {
            EditText editText = replyFragmentLegacy.replyText;
            StringBuilder stringBuilder2 = new StringBuilder("\n\n");
            stringBuilder2.append(charSequence);
            editText.append(stringBuilder2.toString());
        }
        replyFragmentLegacy.replyText.append("\n\n");
        replyFragmentLegacy.replyText.setSelection(replyFragmentLegacy.replyText.length());
        replyFragmentLegacy.replyText.requestFocus();
    }
}
