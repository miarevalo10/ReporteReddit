package com.reddit.frontpage.presentation.listing.ui.view;

import android.view.View;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listing.newcard.LinkFlairView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/listing/newcard/LinkFlairView;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: SmallCardBodyView.kt */
final class SmallCardBodyView$flairView$2 extends Lambda implements Function0<LinkFlairView> {
    final /* synthetic */ SmallCardBodyView f36869a;

    SmallCardBodyView$flairView$2(SmallCardBodyView smallCardBodyView) {
        this.f36869a = smallCardBodyView;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.f36869a.findViewById(C1761R.id.link_flair);
        if (findViewById != null) {
            return (LinkFlairView) findViewById;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.ui.listing.newcard.LinkFlairView");
    }
}
