package com.reddit.frontpage.widgets.modtools.modview.rightcomment;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"getStickyTitle", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ModViewRightComment.kt */
final class ModViewRightComment$setupDistinguishView$1 extends Lambda implements Function0<String> {
    final /* synthetic */ boolean f37458a;

    ModViewRightComment$setupDistinguishView$1(boolean z) {
        this.f37458a = z;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return m37853a();
    }

    public final String m37853a() {
        if (this.f37458a) {
            return Util.m24027f((int) C1761R.string.action_unsticky_comment);
        }
        return Util.m24027f((int) C1761R.string.action_sticky_comment);
    }
}
