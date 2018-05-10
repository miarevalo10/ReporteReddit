package com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.ReasonsAdapter.ViewHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ReasonsAdapter.kt */
final class ReasonsAdapter$ViewHolder$bind$1 implements OnClickListener {
    final /* synthetic */ ViewHolder f20897a;
    final /* synthetic */ int f20898b;

    ReasonsAdapter$ViewHolder$bind$1(ViewHolder viewHolder, int i) {
        this.f20897a = viewHolder;
        this.f20898b = i;
    }

    public final void onClick(View view) {
        this.f20897a.f28591p.f28593b.mo6492a(this.f20897a.f28591p.f28592a.get(this.f20898b));
    }
}
