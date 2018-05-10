package com.reddit.frontpage.presentation.listing.common;

import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.util.ListUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/LinkPresentationPositionUtil;", "", "()V", "getLinkPosition", "", "position", "items", "", "Lcom/reddit/frontpage/domain/model/Link;", "presentationLink", "Lcom/reddit/frontpage/presentation/listing/model/LinkPresentationModel;", "getLinkPositionFilterStubs", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPresentationPositionUtil.kt */
public final class LinkPresentationPositionUtil {
    public static final LinkPresentationPositionUtil f20573a = new LinkPresentationPositionUtil();

    private LinkPresentationPositionUtil() {
    }

    public static int m22873a(int i, List<Link> list, LinkPresentationModel linkPresentationModel) {
        Intrinsics.m26847b(list, "items");
        Intrinsics.m26847b(linkPresentationModel, "presentationLink");
        ListUtil listUtil = ListUtil.f21753a;
        return ListUtil.m23809a(i, list, new LinkPresentationPositionUtil$getLinkPosition$1(linkPresentationModel));
    }
}
