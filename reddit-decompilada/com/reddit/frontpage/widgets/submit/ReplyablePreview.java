package com.reddit.frontpage.widgets.submit;

import android.content.Context;
import android.view.ActionMode.Callback;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/widgets/submit/ReplyablePreview;", "ReplyTargetView", "Landroid/widget/TextView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "layoutRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "quoteActionModeCallback", "Lcom/reddit/frontpage/widgets/submit/QuoteActionModeCallback;", "getQuoteActionModeCallback", "()Lcom/reddit/frontpage/widgets/submit/QuoteActionModeCallback;", "replyTargetView", "getReplyTargetView", "()Landroid/widget/TextView;", "Landroid/widget/TextView;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReplyablePreview.kt */
public abstract class ReplyablePreview<ReplyTargetView extends TextView> extends LinearLayout {
    private final ReplyTargetView f22030a;
    private final QuoteActionModeCallback f22031b;

    public ReplyablePreview(Context context, int i, char c) {
        this(context, i);
    }

    private ReplyablePreview(Context context, int i) {
        Intrinsics.m26847b(context, "context");
        super(context, null, 0);
        setOrientation(1);
        ViewGroupsKt.m24100a(this, i, true);
        Object findViewById = findViewById(C1761R.id.reply_target_text);
        Intrinsics.m26843a(findViewById, "findViewById(R.id.reply_target_text)");
        this.f22030a = (TextView) findViewById;
        this.f22031b = new QuoteActionModeCallback((Function0) new Function0<CharSequence>() {
            public final /* synthetic */ Object invoke() {
                TextView replyTargetView = this.getReplyTargetView();
                return replyTargetView.getText().subSequence(replyTargetView.getSelectionStart(), replyTargetView.getSelectionEnd());
            }
        });
        this.f22030a.setCustomSelectionActionModeCallback((Callback) this.f22031b);
    }

    protected final ReplyTargetView getReplyTargetView() {
        return this.f22030a;
    }

    public final QuoteActionModeCallback getQuoteActionModeCallback() {
        return this.f22031b;
    }
}
