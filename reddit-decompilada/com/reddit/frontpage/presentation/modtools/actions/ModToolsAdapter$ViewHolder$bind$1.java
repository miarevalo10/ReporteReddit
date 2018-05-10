package com.reddit.frontpage.presentation.modtools.actions;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.presentation.modtools.actions.ModToolsAdapter.ViewHolder;
import com.reddit.frontpage.presentation.modtools.util.ModToolsAction;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModToolsActionsAdapter.kt */
final class ModToolsAdapter$ViewHolder$bind$1 implements OnClickListener {
    final /* synthetic */ ViewHolder f20861a;
    final /* synthetic */ ModToolsAction f20862b;

    ModToolsAdapter$ViewHolder$bind$1(ViewHolder viewHolder, ModToolsAction modToolsAction) {
        this.f20861a = viewHolder;
        this.f20862b = modToolsAction;
    }

    public final void onClick(View view) {
        this.f20861a.f28533q.f28534a.mo6492a(this.f20862b);
    }
}
