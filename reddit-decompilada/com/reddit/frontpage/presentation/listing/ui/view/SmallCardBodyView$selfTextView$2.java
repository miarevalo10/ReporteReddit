package com.reddit.frontpage.presentation.listing.ui.view;

import android.view.View;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.ui.listing.newcard.RightIndentTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/listing/newcard/RightIndentTextView;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: SmallCardBodyView.kt */
final class SmallCardBodyView$selfTextView$2 extends Lambda implements Function0<RightIndentTextView> {
    final /* synthetic */ SmallCardBodyView f36870a;

    SmallCardBodyView$selfTextView$2(SmallCardBodyView smallCardBodyView) {
        this.f36870a = smallCardBodyView;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.f36870a.findViewById(C1761R.id.link_self_text);
        if (!(findViewById instanceof RightIndentTextView)) {
            findViewById = null;
        }
        return (RightIndentTextView) findViewById;
    }
}
