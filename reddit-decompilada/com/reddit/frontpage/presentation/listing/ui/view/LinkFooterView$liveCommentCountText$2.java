package com.reddit.frontpage.presentation.listing.ui.view;

import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkFooterView.kt */
final class LinkFooterView$liveCommentCountText$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ LinkFooterView f36855a;

    LinkFooterView$liveCommentCountText$2(LinkFooterView linkFooterView) {
        this.f36855a = linkFooterView;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return (TextView) this.f36855a.m23015a(C1761R.id.live_comment_count);
    }
}
