package com.reddit.frontpage.presentation.listing.ui.view;

import com.reddit.frontpage.animation.SnooProgressDrawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/animation/SnooProgressDrawable;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CrossPostImageCardBodyView.kt */
final class CrossPostImageCardBodyView$progressDrawable$2 extends Lambda implements Function0<SnooProgressDrawable> {
    final /* synthetic */ CrossPostImageCardBodyView f36787a;

    CrossPostImageCardBodyView$progressDrawable$2(CrossPostImageCardBodyView crossPostImageCardBodyView) {
        this.f36787a = crossPostImageCardBodyView;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new SnooProgressDrawable(this.f36787a.getContext());
    }
}
