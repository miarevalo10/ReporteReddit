package com.reddit.frontpage.widgets.submit;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/reddit/frontpage/widgets/submit/QuoteActionModeCallback;", "Landroid/view/ActionMode$Callback;", "getSelectedText", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onQuoteSelectedListener", "Lcom/reddit/frontpage/widgets/submit/OnQuoteSelectedListener;", "getOnQuoteSelectedListener", "()Lcom/reddit/frontpage/widgets/submit/OnQuoteSelectedListener;", "setOnQuoteSelectedListener", "(Lcom/reddit/frontpage/widgets/submit/OnQuoteSelectedListener;)V", "quoteItem", "Landroid/view/MenuItem;", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", "item", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onDestroyActionMode", "", "onPrepareActionMode", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReplyableQuote.kt */
public final class QuoteActionModeCallback implements Callback {
    public OnQuoteSelectedListener f22027a;
    private MenuItem f22028b;
    private final Function0<CharSequence> f22029c;

    public QuoteActionModeCallback(Function0<? extends CharSequence> function0) {
        Intrinsics.m26847b(function0, "getSelectedText");
        this.f22029c = function0;
    }

    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        Intrinsics.m26847b(actionMode, "mode");
        Intrinsics.m26847b(menu, "menu");
        this.f22028b = menu.add(C1761R.string.action_quote);
        return true;
    }

    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        Intrinsics.m26847b(actionMode, "mode");
        Intrinsics.m26847b(menu, "menu");
        actionMode = this.f22028b;
        if (actionMode != null) {
            boolean z = this.f22027a != null;
            actionMode.setVisible(z);
            actionMode.setEnabled(z);
        }
        return true;
    }

    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        Intrinsics.m26847b(actionMode, "mode");
        Intrinsics.m26847b(menuItem, "item");
        menuItem = menuItem.getItemId();
        MenuItem menuItem2 = this.f22028b;
        if (menuItem2 == null || menuItem != menuItem2.getItemId()) {
            return null;
        }
        if (this.f22027a == null) {
            throw ((Throwable) new IllegalStateException("Quote action clicked, but no listener supplied"));
        }
        menuItem = this.f22027a;
        if (menuItem == null) {
            Intrinsics.m26842a();
        }
        Object invoke = this.f22029c.invoke();
        if (invoke == null) {
            Intrinsics.m26842a();
        }
        menuItem.mo4812a((CharSequence) invoke);
        actionMode.finish();
        return true;
    }

    public final void onDestroyActionMode(ActionMode actionMode) {
        Intrinsics.m26847b(actionMode, "mode");
        this.f22028b = null;
    }
}
