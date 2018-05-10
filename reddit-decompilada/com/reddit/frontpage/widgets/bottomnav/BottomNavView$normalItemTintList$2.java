package com.reddit.frontpage.widgets.bottomnav;

import android.content.Context;
import android.content.res.ColorStateList;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/res/ColorStateList;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: BottomNavView.kt */
final class BottomNavView$normalItemTintList$2 extends Lambda implements Function0<ColorStateList> {
    final /* synthetic */ Context f37441a;

    BottomNavView$normalItemTintList$2(Context context) {
        this.f37441a = context;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        r2 = new int[2][];
        r2[0] = new int[]{16842913};
        r2[1] = new int[]{-16842913};
        return new ColorStateList(r2, new int[]{ResourcesUtil.m22740i(this.f37441a, C1761R.attr.rdt_nav_icon_color), ResourcesUtil.m22740i(this.f37441a, C1761R.attr.rdt_action_icon_color)});
    }
}
