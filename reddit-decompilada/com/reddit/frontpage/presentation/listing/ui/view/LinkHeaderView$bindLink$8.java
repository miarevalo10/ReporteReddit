package com.reddit.frontpage.presentation.listing.ui.view;

import android.view.View;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkHeaderView.kt */
final class LinkHeaderView$bindLink$8 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ LinkHeaderView f36858a;
    final /* synthetic */ LinkPresentationModel f36859b;

    LinkHeaderView$bindLink$8(LinkHeaderView linkHeaderView, LinkPresentationModel linkPresentationModel) {
        this.f36858a = linkHeaderView;
        this.f36859b = linkPresentationModel;
        super(1);
    }

    public final /* bridge */ /* synthetic */ Object mo6492a(Object obj) {
        LinkHeaderView.m29715a(this.f36858a, this.f36859b);
        return Unit.f25273a;
    }
}
