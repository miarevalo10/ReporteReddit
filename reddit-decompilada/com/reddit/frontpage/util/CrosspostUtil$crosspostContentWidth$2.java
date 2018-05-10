package com.reddit.frontpage.util;

import android.content.res.Resources;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CrosspostUtil.kt */
final class CrosspostUtil$crosspostContentWidth$2 extends Lambda implements Function0<Integer> {
    public static final CrosspostUtil$crosspostContentWidth$2 f37393a = new CrosspostUtil$crosspostContentWidth$2();

    CrosspostUtil$crosspostContentWidth$2() {
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object system = Resources.getSystem();
        Intrinsics.m26843a(system, "Resources.getSystem()");
        return Integer.valueOf(system.getDisplayMetrics().widthPixels - (2 * Util.m24029g((int) C1761R.dimen.crosspost_margin)));
    }
}
