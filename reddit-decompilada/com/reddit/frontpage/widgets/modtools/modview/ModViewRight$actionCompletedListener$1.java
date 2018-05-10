package com.reddit.frontpage.widgets.modtools.modview;

import com.reddit.frontpage.widgets.LinkFooterView.OnModActionCompletedListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onActionCompleted"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModViewRight.kt */
final class ModViewRight$actionCompletedListener$1 implements OnModActionCompletedListener {
    final /* synthetic */ ModViewRight f29521a;
    final /* synthetic */ OnModActionCompletedListener f29522b;

    ModViewRight$actionCompletedListener$1(ModViewRight modViewRight, OnModActionCompletedListener onModActionCompletedListener) {
        this.f29521a = modViewRight;
        this.f29522b = onModActionCompletedListener;
    }

    public final void mo4891a() {
        ModViewRight.m35310a(this.f29521a);
        OnModActionCompletedListener onModActionCompletedListener = this.f29522b;
        if (onModActionCompletedListener != null) {
            onModActionCompletedListener.mo4891a();
        }
    }
}
