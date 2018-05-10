package com.reddit.frontpage.presentation.modtools.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.data.model.ModToolsUserModel;
import com.reddit.frontpage.presentation.modtools.ModToolsListItemModel;
import com.reddit.frontpage.presentation.modtools.adapter.ModUsersAdapter.ViewHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModUsersAdapter.kt */
final class ModUsersAdapter$ViewHolder$bind$1 implements OnClickListener {
    final /* synthetic */ ViewHolder f20867a;
    final /* synthetic */ int f20868b;
    final /* synthetic */ ModToolsUserModel f20869c;

    ModUsersAdapter$ViewHolder$bind$1(ViewHolder viewHolder, int i, ModToolsUserModel modToolsUserModel) {
        this.f20867a = viewHolder;
        this.f20868b = i;
        this.f20869c = modToolsUserModel;
    }

    public final void onClick(View view) {
        this.f20867a.f28540r.f28546f.mo4905a(new ModToolsListItemModel(this.f20868b, this.f20869c));
    }
}
