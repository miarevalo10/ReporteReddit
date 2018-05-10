package com.reddit.frontpage.presentation.listing.submitted;

import android.view.View;
import com.reddit.frontpage.presentation.listing.ui.viewholder.LinkViewHolder;
import com.reddit.frontpage.ui.listing.newcard.VisibilityDependent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class UserSubmittedListingScreen$Adapter$bindViewHolder$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Adapter f36754a;
    final /* synthetic */ LinkViewHolder f36755b;

    UserSubmittedListingScreen$Adapter$bindViewHolder$1(Adapter adapter, LinkViewHolder linkViewHolder) {
        this.f36754a = adapter;
        this.f36755b = linkViewHolder;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        this.f36755b.mo6969w();
        UserSubmittedListingScreen.m40681a(this.f36754a.f34032c);
        if ((this.f36755b instanceof VisibilityDependent) != null) {
            ((VisibilityDependent) this.f36755b).aq();
        }
        return Unit.f25273a;
    }
}
