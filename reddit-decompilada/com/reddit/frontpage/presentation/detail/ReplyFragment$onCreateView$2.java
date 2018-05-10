package com.reddit.frontpage.presentation.detail;

import android.widget.EditText;
import com.reddit.frontpage.widgets.submit.OnQuoteSelectedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/reddit/frontpage/presentation/detail/ReplyFragment$onCreateView$2", "Lcom/reddit/frontpage/widgets/submit/OnQuoteSelectedListener;", "(Lcom/reddit/frontpage/presentation/detail/ReplyFragment;)V", "onQuoteSelected", "", "selectedText", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReplyFragment.kt */
public final class ReplyFragment$onCreateView$2 implements OnQuoteSelectedListener {
    final /* synthetic */ ReplyFragment f28175a;

    ReplyFragment$onCreateView$2(ReplyFragment replyFragment) {
        this.f28175a = replyFragment;
    }

    public final void mo4812a(CharSequence charSequence) {
        Intrinsics.m26847b(charSequence, "selectedText");
        charSequence = ReplyFragment.m38931a(charSequence);
        String obj = this.f28175a.m38934m().getText().toString();
        EditText a = this.f28175a.m38934m();
        if (StringsKt__StringsJVMKt.m41943a((CharSequence) obj)) {
            a.setText(charSequence);
        } else if (StringsKt__StringsJVMKt.m41948b(obj, "\n\n")) {
            a.append(charSequence);
        } else {
            StringBuilder stringBuilder = new StringBuilder("\n\n");
            stringBuilder.append(charSequence);
            a.append(stringBuilder.toString());
        }
        a.append("\n\n");
        a.setSelection(a.length());
        a.requestFocus();
    }
}
