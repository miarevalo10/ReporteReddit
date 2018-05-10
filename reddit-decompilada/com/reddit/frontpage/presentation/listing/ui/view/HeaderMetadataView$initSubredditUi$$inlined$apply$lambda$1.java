package com.reddit.frontpage.presentation.listing.ui.view;

import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: HeaderMetadataView.kt */
final class HeaderMetadataView$initSubredditUi$$inlined$apply$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ TextView f36835a;
    final /* synthetic */ LinkPresentationModel f36836b;
    final /* synthetic */ boolean f36837c;

    HeaderMetadataView$initSubredditUi$$inlined$apply$lambda$1(TextView textView, LinkPresentationModel linkPresentationModel, boolean z) {
        this.f36835a = textView;
        this.f36836b = linkPresentationModel;
        this.f36837c = z;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        if (this.f36837c == null) {
            Routing.m22619a(this.f36835a.getContext(), Nav.m22566b(this.f36836b.af));
        } else if (Util.m24041k(this.f36836b.f33985l) == null) {
            Routing.m22619a(this.f36835a.getContext(), Nav.m22594j(this.f36836b.f33985l));
        }
        return Unit.f25273a;
    }
}
