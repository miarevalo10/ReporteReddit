package com.reddit.frontpage.presentation.modtools.adapter;

import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModUsersAdapter.kt */
final class ModUsersAdapter$ViewHolder$username$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ View f36964a;

    ModUsersAdapter$ViewHolder$username$2(View view) {
        this.f36964a = view;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.f36964a.findViewById(C1761R.id.username);
        if (findViewById != null) {
            return (TextView) findViewById;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }
}
