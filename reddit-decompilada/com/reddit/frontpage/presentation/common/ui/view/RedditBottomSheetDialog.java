package com.reddit.frontpage.presentation.common.ui.view;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010\"\u001a\u00020%2\u0006\u0010#\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010\u0016\u001a\u00020!2\b\u0010\u0013\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010\u0016\u001a\u00020!2\u0006\u0010+\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010,\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/RedditBottomSheetDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "titleHeaderEnabled", "", "(Landroid/content/Context;Z)V", "frameView", "Landroid/view/ViewGroup;", "headerStubView", "Landroid/view/ViewStub;", "headerView", "getHeaderView", "()Landroid/view/ViewGroup;", "setHeaderView", "(Landroid/view/ViewGroup;)V", "inflated", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getTitleHeaderEnabled", "()Z", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "applyWindowLayoutParams", "", "setContentView", "view", "Landroid/view/View;", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResId", "", "", "titleId", "wrapInRedditBottomSheet", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditBottomSheetDialog.kt */
public class RedditBottomSheetDialog extends BottomSheetDialog {
    private String f36381d;
    private boolean f36382e;
    private ViewGroup f36383f;
    private ViewStub f36384g;
    private ViewGroup f36385h;
    private TextView f36386i;
    private final boolean f36387j;

    public /* synthetic */ void setContentView(View view, LayoutParams layoutParams) {
        Intrinsics.m26847b(view, "view");
        throw ((Throwable) new NotImplementedError("Use setContentView(View) instead"));
    }

    public RedditBottomSheetDialog(Context context, boolean z) {
        Intrinsics.m26847b(context, "context");
        super(context);
        this.f36387j = z;
    }

    public final void m36781a(String str) {
        if (this.f36387j) {
            TextView textView = this.f36386i;
            if (textView != null) {
                textView.setText(str);
            }
            this.f36381d = str;
            return;
        }
        throw ((Throwable) new IllegalStateException("Bottom sheet's title was set, but was constructed without the title header. Either construct it with withTitleHeader = true, or use a custom title view."));
    }

    public void setContentView(View view) {
        Intrinsics.m26847b(view, "view");
        super.setContentView(m36779a(view));
        view = Unit.f25273a;
        mo7176b();
    }

    public void setTitle(CharSequence charSequence) {
        m36781a(String.valueOf(charSequence));
    }

    public void setTitle(int i) {
        m36781a(getContext().getString(i));
    }

    private final View m36779a(View view) {
        if (this.f36382e) {
            throw ((Throwable) new IllegalStateException("Bottom sheet's view was wrapped twice. Make sure to only call setContentView() once."));
        }
        ViewGroup viewGroup;
        Object inflate = getLayoutInflater().inflate(C1761R.layout.bottomsheet_frame, null, false);
        View findViewById = inflate.findViewById(C1761R.id.bottomsheet_frame);
        if (findViewById == null) {
            Intrinsics.m26842a();
        }
        this.f36383f = (ViewGroup) findViewById;
        findViewById = inflate.findViewById(C1761R.id.bottomsheet_frame_header_stub);
        if (findViewById == null) {
            Intrinsics.m26842a();
        }
        this.f36384g = (ViewStub) findViewById;
        inflate.addOnAttachStateChangeListener(new RedditBottomSheetDialog$wrapInRedditBottomSheet$2());
        if (this.f36387j) {
            ViewStub viewStub = this.f36384g;
            if (viewStub == null) {
                Intrinsics.m26844a("headerStubView");
            }
            findViewById = viewStub.inflate();
            if (findViewById == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            viewGroup = (ViewGroup) findViewById;
            this.f36385h = viewGroup;
            TextView textView = (TextView) viewGroup.findViewById(C1761R.id.bottomsheet_header_title);
            String str = this.f36381d;
            if (str != null) {
                textView.setText(str);
            }
            this.f36386i = textView;
        }
        viewGroup = this.f36383f;
        if (viewGroup == null) {
            Intrinsics.m26844a("frameView");
        }
        viewGroup.addView(view);
        this.f36382e = true;
        Intrinsics.m26843a(inflate, "rootView");
        return inflate;
    }

    private final void mo7176b() {
        getWindow().setLayout(-1, -1);
    }

    public void setContentView(int i) {
        View inflate = getLayoutInflater().inflate(i, null, false);
        Intrinsics.m26843a((Object) inflate, "it");
        super.setContentView(m36779a(inflate));
        i = Unit.f25273a;
        mo7176b();
    }
}
