package com.reddit.social.widgets;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.BaseActivity;
import com.reddit.frontpage.ui.sorting.SnoomojiPreviewDialog;
import com.reddit.social.widgets.SnoomojiMedium.SnoomojiAdapter;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: SnoomojiMedium.kt */
final class SnoomojiMedium$SnoomojiAdapter$onBindViewHolder$1 implements OnClickListener {
    final /* synthetic */ SnoomojiAdapter f22490a;
    final /* synthetic */ int f22491b;
    final /* synthetic */ ViewHolder f22492c;

    SnoomojiMedium$SnoomojiAdapter$onBindViewHolder$1(SnoomojiAdapter snoomojiAdapter, int i, ViewHolder viewHolder) {
        this.f22490a = snoomojiAdapter;
        this.f22491b = i;
        this.f22492c = viewHolder;
    }

    public final void onClick(View view) {
        view = SnoomojiPreviewDialog.m37824a(this.f22490a.f29980c, Integer.valueOf(this.f22490a.f29978a[this.f22491b]), this.f22490a.f29979b[this.f22491b]);
        Object obj = this.f22492c.c;
        Intrinsics.m26843a(obj, "holder.itemView");
        Context context = obj.getContext();
        if (context == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.BaseActivity");
        }
        view.a(((BaseActivity) context).getSupportFragmentManager(), "chat_preview");
    }
}
