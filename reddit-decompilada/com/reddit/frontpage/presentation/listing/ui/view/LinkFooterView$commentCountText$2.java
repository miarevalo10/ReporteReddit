package com.reddit.frontpage.presentation.listing.ui.view;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.DrawableTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/widgets/DrawableTextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkFooterView.kt */
final class LinkFooterView$commentCountText$2 extends Lambda implements Function0<DrawableTextView> {
    final /* synthetic */ LinkFooterView f36852a;

    LinkFooterView$commentCountText$2(LinkFooterView linkFooterView) {
        this.f36852a = linkFooterView;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return (DrawableTextView) this.f36852a.m23015a(C1761R.id.comment_count);
    }
}
