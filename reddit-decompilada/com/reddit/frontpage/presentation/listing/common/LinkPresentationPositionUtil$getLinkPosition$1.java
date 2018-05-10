package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/reddit/frontpage/domain/model/Link;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPresentationPositionUtil.kt */
final class LinkPresentationPositionUtil$getLinkPosition$1 extends Lambda implements Function1<Link, Boolean> {
    final /* synthetic */ LinkPresentationModel f36537a;

    LinkPresentationPositionUtil$getLinkPosition$1(LinkPresentationModel linkPresentationModel) {
        this.f36537a = linkPresentationModel;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Link link = (Link) obj;
        Intrinsics.m26847b(link, "it");
        return Boolean.valueOf(Intrinsics.m26845a(link.getKindWithId(), this.f36537a.getName()));
    }
}
